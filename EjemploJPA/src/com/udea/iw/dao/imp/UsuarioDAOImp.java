package com.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.DataSource;
import com.udea.iw.dto.UsuarioDTO;

public class UsuarioDAOImp {
	//Metodo para obtener todas los usuarios
	public List<UsuarioDTO> obtener() throws ReizzelException{
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		Session session=null;
		try{
			session = DataSource.getInstance().getSession();//Se obtiene la sesion
			Criteria criteria = session.createCriteria(UsuarioDTO.class);//Con el criteria se hace la consulta a la base de datos
			lista=criteria.list();
		}catch(HibernateException e){
			throw new ReizzelException("Error consultando ciudades", e);
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return lista;
	}
	
	//Metodo para obtener solo 1 ciudad con codigo como parametro
		public UsuarioDTO obtener(String login) throws ReizzelException{
			UsuarioDTO usuario= new UsuarioDTO();
			Session session=null;
			try{
				session = DataSource.getInstance().getSession();//Se obtiene la sesion
				Criteria criteria = session.createCriteria(UsuarioDTO.class);
				criteria.add(Restrictions.eq("login", login));//Se agrega la condicion con la que se hace la consulta
				usuario = (UsuarioDTO)criteria.uniqueResult();//Unique porque sé y estoy seguro que me va a arrojar solo 1 valor
				//uniqueResult retorna un objeto tipo "object"
			}catch(HibernateException e){
				throw new ReizzelException("Error consultando ciudades", e);
			}finally{
				if(session!=null){
					session.close();
				}
			}
			return usuario;
		}
}
