package com.udea.iw.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.UsuarioDAOImp;
import com.udea.iw.dto.UsuarioDTO;

public class UsuarioDAOTest {
	@Test
	public void testObtener(){
		UsuarioDAOImp usuario = null;
		String login = "elver";
		UsuarioDTO user = null;
		try{
			usuario =new UsuarioDAOImp();
			user = usuario.obtener(login);
			assertTrue(user!=null);
			System.out.println(user.getRol());
		}catch(ReizzelException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
