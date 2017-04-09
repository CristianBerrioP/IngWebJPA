package com.udea.iw.dao;

import java.util.List;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dto.CiudadDTO;

//@Author Cristian Berrio Pulido - cbp453252.hdrl@gmail.com @Version = 1.0

//Clase Interfaz para CiudadDao
public interface CiudadDao {
	//Metodo para obtener la lista de datos de ciudades
	public List<CiudadDTO> obtener() throws ReizzelException;
	//Metodo para obtener una ciudad mediante su codigo
	public CiudadDTO obtener(long codigo) throws ReizzelException;
}
