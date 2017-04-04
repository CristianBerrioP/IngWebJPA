package com.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.udea.iw.Exception.ReizzelException;
import com.udea.iw.dao.ClienteDAO;
import com.udea.iw.dao.DataSource;
import com.udea.iw.dto.ClienteDTO;

public class ClienteDAOImp implements ClienteDAO{
	//Metodo para obtener todas los usuarios
	@Override
	public List<ClienteDTO> obtener() throws ReizzelException{
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = DataSource.getInstance().getSession();//Se obtiene la sesion
			criteria = session.createCriteria(ClienteDTO.class);//Con el criteria se hace la consulta a la base de datos
			criteria.addOrder(Order.asc("fechaCreacion"));//Ordena ascendentemente con la propiedad fechaCreacion
			clientes=criteria.list();
		}catch(HibernateException e){
			throw new ReizzelException("Error consultando clientes", e);
		}
		return clientes;
	}

	@Override
	public void guardar(ClienteDTO cliente) throws ReizzelException {
		Transaction tx = null;
		Session session=null;
		try{
			session = DataSource.getInstance().getSession();//Se obtiene la sesion
			tx = session.beginTransaction();//Inicializa la transaccion
			session.save(cliente);
			tx.commit();//Realizar el cambio en la base de datos
		}catch(HibernateException e){
			throw new ReizzelException("Error en la transaccion guardando el cliente", e);
		}
		
	}
}
