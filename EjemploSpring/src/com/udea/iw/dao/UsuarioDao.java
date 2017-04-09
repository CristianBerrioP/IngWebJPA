package com.udea.iw.dao;

import java.util.List;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dto.UsuarioDTO;

//@Author Cristian Berrio Pulido - cbp453252.hdrl@gmail.com @Version = 1.0

//Clase Interfaz para CiudadDao
public interface UsuarioDao {
	//Metodo para obtener la lista de usuarios
	public List<UsuarioDTO> obtener() throws ReizzelException;
	//Metodo para obtener un usuario mediante su usuario de login
	public UsuarioDTO obtener(String login) throws ReizzelException;
}
