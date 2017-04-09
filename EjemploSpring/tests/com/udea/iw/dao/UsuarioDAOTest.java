package com.udea.iw.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.UsuarioDAOImp;
import com.udea.iw.dto.UsuarioDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:BeanConfig.xml")
public class UsuarioDAOTest {
	@Autowired//Inyeccion por medio del bean
	UsuarioDAOImp usuarioDao;
	@Test
	public void testObtener(){
		String login = "elver";
		UsuarioDTO user = null;
		try{
			user = usuarioDao.obtener(login);
			assertTrue(user!=null);
			System.out.println(user.getNombres()+"-"+user.getRol().getNombre());
		}catch(ReizzelException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
