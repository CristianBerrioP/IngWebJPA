package com.udea.iw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.CiudadDAOImp;
import com.udea.iw.dto.CiudadDTO;

public class ciudadDAOTest {
	@Test
	public void testObtener(){
		CiudadDAOImp ciudad = null;
		List<CiudadDTO> lista = null;
		try{
			ciudad =new CiudadDAOImp();
			lista = ciudad.obtener();
			assertTrue(lista.size()>0);
		}catch(ReizzelException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
