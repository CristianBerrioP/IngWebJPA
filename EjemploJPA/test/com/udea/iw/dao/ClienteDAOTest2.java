package com.udea.iw.dao;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.imp.ClienteDAOImp;
import com.udea.iw.dto.ClienteDTO;
import com.udea.iw.dto.UsuarioDTO;

public class ClienteDAOTest2 {
	@Test
	public void testGuardar(){
		ClienteDTO cliente = null;
		ClienteDAOImp clienteDao = null;
		UsuarioDTO usuario = null;
		try{
			cliente = new ClienteDTO();
			cliente.setCedula("123456789");
			cliente.setNombres("elver");
			cliente.setApellidos("ELVERAPELLIDO");
			cliente.setEmail("elver@udea.com");
			usuario = new UsuarioDTO();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());
			clienteDao = new ClienteDAOImp();
			clienteDao.guardar(cliente);
		}catch(ReizzelException r){
			r.printStackTrace();
			fail(r.getMessage());
		}
	}
}
