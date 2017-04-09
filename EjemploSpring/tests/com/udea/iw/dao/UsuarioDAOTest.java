package com.udea.iw.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.UsuarioDAOImp;
import com.udea.iw.dto.UsuarioDTO;


//@Author Cristian Berrio Pulido - cbp453252.hdrl@gmail.com @Version = 1.0
@RunWith(SpringJUnit4ClassRunner.class)//Correr un tipo especial de prueba en este caso de Spring
@Transactional//Para indicar que se realizan transacciones con la base de datos
@ContextConfiguration(locations = "classpath:BeanConfig.xml")//Para indicar la ruta del archivo de configuracion de Spring
public class UsuarioDAOTest {
	@Autowired//Inyeccion por medio del bean
	UsuarioDAOImp usuarioDao;
	final Logger log = Logger.getLogger(UsuarioDAOTest.class.getName());
	@Test
	public void testObtener(){
		String login = "elver";
		UsuarioDTO user = null;
		try{
			log.info("Iniciando prueba de obtener  usuarios de la BD");
			user = usuarioDao.obtener(login);
			assertTrue(user!=null);
			System.out.println(user.getNombres()+"-"+user.getRol().getNombre());
		}catch(ReizzelException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
