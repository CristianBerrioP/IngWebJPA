package com.udea.iw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.CiudadDAOImp;
import com.udea.iw.dto.CiudadDTO;

//@Author Cristian Berrio Pulido - cbp453252.hdrl@gmail.com @Version = 1.0
@RunWith(SpringJUnit4ClassRunner.class)//Correr un tipo especial de prueba en este caso de Spring
@Transactional//Para indicar que se realizan transacciones con la base de datos
@ContextConfiguration(locations = "classpath:BeanConfig.xml")//Para indicar la ruta del archivo de configuracion de Spring
public class CiudadDAOTest {
	@Autowired//Inyeccion por medio del bean
	CiudadDAOImp ciudadDao;
	final Logger log = Logger.getLogger(CiudadDAOTest.class.getName());
	@Test
	public void testObtener(){
		log.info("Iniciando prueba de obtener Ciudades de la BD");
		List<CiudadDTO> lista = null;//lISTA DE CIUDADES
		try{
			lista = ciudadDao.obtener();
			assertTrue(lista.size()>0);
		}catch(ReizzelException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
