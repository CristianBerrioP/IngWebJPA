package com.udea.iw.dao;

import java.util.List;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dto.ClienteDTO;

//@Author Cristian Berrio Pulido - cbp453252.hdrl@gmail.com @Version = 1.0

//Clase Interfaz para ClienteDao
public interface ClienteDAO{
	//Entrega la lista clientes ordenados por su fecha de creación
	public List<ClienteDTO> obtener() throws ReizzelException;
	
	//Metodo para guardar un cliente
	public void guardar(ClienteDTO cliente) throws ReizzelException;
}
