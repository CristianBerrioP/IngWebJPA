package com.udea.iw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.CiudadDAOImp;
import com.udea.iw.dto.CiudadDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:BeanConfig.xml")
public class CiudadDAOTest {
	@Autowired//Inyeccion por medio del bean
	CiudadDAOImp ciudadDao;
	@Test
	public void testObtener(){
		List<CiudadDTO> lista = null;
		try{
			lista = ciudadDao.obtener();
			assertTrue(lista.size()>0);
		}catch(ReizzelException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
