package com.udea.iw.dao;

import java.util.List;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dto.ClienteDTO;

public interface ClienteDAO {
	//Entrega la lista clientes ordenados por su fecha de creación
	public List<ClienteDTO> obtener() throws ReizzelException;
	
	public void guardar(ClienteDTO cliente) throws ReizzelException;
}
