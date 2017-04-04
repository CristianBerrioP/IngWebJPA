package com.udea.iw.dao;

import java.util.List;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dto.CiudadDTO;

public interface CiudadDao {
	public List<CiudadDTO> obtener() throws ReizzelException;
	public CiudadDTO obtener(long codigo) throws ReizzelException;
}
