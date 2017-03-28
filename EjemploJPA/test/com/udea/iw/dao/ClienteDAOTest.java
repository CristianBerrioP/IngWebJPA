package com.udea.iw.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.ClienteDAOImp;
import com.udea.iw.dto.ClienteDTO;

public class ClienteDAOTest {
	@Test
	public void testObtener(){
		ClienteDAO clienteDao = null;
		List<ClienteDTO> resultado = null;
		try{
			clienteDao = new ClienteDAOImp();
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
