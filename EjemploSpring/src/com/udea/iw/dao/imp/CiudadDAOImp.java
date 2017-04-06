package com.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dto.CiudadDTO;

public class CiudadDAOImp {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//Metodo para obtener todas las ciudades
	public List<CiudadDTO> obtener() throws ReizzelException{
		List<CiudadDTO> lista = new ArrayList<CiudadDTO>();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();//Se obtiene la sesion
			Criteria criteria = session.createCriteria(CiudadDTO.class);//Con el criteria se hace la consulta a la base de datos
			lista=criteria.list();
		}catch(HibernateException e){
			throw new ReizzelException("Error consultando ciudades", e);
		}
		return lista;
	}
	//Metodo para obtener solo 1 ciudad con codigo como parametro
	public CiudadDTO obtener(long codigo) throws ReizzelException{
		CiudadDTO ciudad= new CiudadDTO();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();//Se obtiene la sesion
			Criteria criteria = session.createCriteria(CiudadDTO.class);
			criteria.add(Restrictions.eq("codigo", codigo));//Se agrega la condicion con la que se hace la consulta
			ciudad = (CiudadDTO)criteria.uniqueResult();//Unique porque sé y estoy seguro que me va a arrojar solo 1 valor
			//uniqueResult retorna un objeto tipo "object"
		}catch(HibernateException e){
			throw new ReizzelException("Error consultando ciudades", e);
		}
		return ciudad;
	}
	/*
	 *Otra forma
	 public CiudadDTO obtener(long codigo) throws ReizzelException{
		CiudadDTO ciudad= new CiudadDTO();
		Session session=null;
		try{
			session = DataSource.getInstance().getSession();//Se obtiene la sesion
			ciudad=(CiudadDTO) session.get(Ciudad.class,codigo);//Retorna nulo si no lo encuentra
			//ciudad=(CiudadDTO) session.load(Ciudad.class,codigo);Retorna una excepcion si no lo encuentra			
		}catch(HibernateException e){
			throw new ReizzelException("Error consultando ciudades", e);
		}
		return ciudad;
	}
	 */
	public void guardar(CiudadDTO ciudad) throws ReizzelException{
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();//Se obtiene la sesion
			session.saveOrUpdate(ciudad);
		}catch(HibernateException e){
			throw new ReizzelException("Error en la transaccion", e);
		}
	}
	
	public void borrar(CiudadDTO ciudad) throws ReizzelException{
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();//Se obtiene la sesion
			session.delete(ciudad);
		}catch(HibernateException e){
			throw new ReizzelException("Error en la transaccion", e);
		}
	}
}
