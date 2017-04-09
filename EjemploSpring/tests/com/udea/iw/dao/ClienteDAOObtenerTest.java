package com.udea.iw.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.ClienteDAOImp;
import com.udea.iw.dto.ClienteDTO;


//@Author Cristian Berrio Pulido - cbp453252.hdrl@gmail.com @Version = 1.0
@RunWith(SpringJUnit4ClassRunner.class)//Correr un tipo especial de prueba en este caso de Spring
@Transactional//Para indicar que se realizan transacciones con la base de datos
@ContextConfiguration(locations = "classpath:BeanConfig.xml")//Para indicar la ruta del archivo de configuracion de Spring
public class ClienteDAOObtenerTest {
	@Autowired//Inyeccion por medio del bean
	ClienteDAOImp clienteDao;
	final Logger log = Logger.getLogger(ClienteDAOObtenerTest.class.getName());
	@Test
	public void testObtener(){
		List<ClienteDTO> resultado = null;
		try{
			log.info("Iniciando prueba de obtener clientes a la BD");
			resultado = clienteDao.obtener();
			for(ClienteDTO cliente : resultado){
				System.out.println(cliente.getNombres() + " " + cliente.getApellidos());
			}
			assertTrue(resultado.size()>0);
		}catch(ReizzelException e){
			fail(e.getMessage());
		}
	}
}
