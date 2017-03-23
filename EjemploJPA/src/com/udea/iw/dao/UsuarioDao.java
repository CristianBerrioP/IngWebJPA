package com.udea.iw.dao;

import java.util.List;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dto.UsuarioDTO;

public interface UsuarioDao {
	public List<UsuarioDTO> obtener() throws ReizzelException;
	public UsuarioDTO obtener(String login) throws ReizzelException;
}
