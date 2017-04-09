package com.udea.iw.dao;

import static org.junit.Assert.fail;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.CiudadDAOImp;
import com.udea.iw.dao.imp.ClienteDAOImp;
import com.udea.iw.dto.ClienteDTO;
import com.udea.iw.dto.UsuarioDTO;

//@Author Cristian Berrio Pulido - cbp453252.hdrl@gmail.com @Version = 1.0
@RunWith(SpringJUnit4ClassRunner.class)//Correr un tipo especial de prueba en este caso de Spring
@Transactional//Para indicar que se realizan transacciones con la base de datos
@ContextConfiguration(locations = "classpath:BeanConfig.xml")//Para indicar la ruta del archivo de configuracion de Spring

public class ClienteDAOGuardarTest {
	@Autowired//Inyeccion por medio del bean
	ClienteDAOImp clienteDao;
	final Logger log = Logger.getLogger(ClienteDAOGuardarTest.class.getName());
	@Test
	public void testGuardar(){
		ClienteDTO cliente = null;
		UsuarioDTO usuario = null;
		try{
			log.info("Iniciando prueba de agregar clientes a la BD");
			cliente = new ClienteDTO();
			cliente.setCedula("987654321");
			cliente.setNombres("elver");
			cliente.setApellidos("ELVERAPELLIDO");
			cliente.setEmail("elver@udea.com");
			usuario = new UsuarioDTO();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());
			clienteDao.guardar(cliente);
		}catch(ReizzelException r){
			r.printStackTrace();
			fail(r.getMessage());
		}
	}
}
