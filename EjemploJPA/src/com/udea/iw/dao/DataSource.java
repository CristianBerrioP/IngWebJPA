package com.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udea.iw.Exception.ReizzelException;

public class DataSource {
	/*Para el patron singleton: 
	  Se necesita un constructor privado y un metodo publico que me permita crear una instancia*/
	
	/*Declaracion de objetos*/
	private static DataSource instancia;
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
			
	/*Constructor privado*/
	private DataSource(){
		
	}
	/*Metodo publico para crear instancias*/
	public static DataSource getInstance(){
		if(instancia==null){
			instancia = new DataSource();
		}
		return instancia;
	}
	/*Metodo para entregar conexiones(Sesiones) activas a la base de datos*/
	public Session getSession() throws ReizzelException{
		try{
			/*Si es primera vez que creo la factoria*/
			if(factory==null){
				conf.configure("com/udea/iw/config/hibernate.cfg.xml");//Ruta donde se encuentra el archivo de configuracion de hibernate
				factory = conf.buildSessionFactory();
			}
			return factory.openSession();//Entrega una sesion abierta a la base de datos
		}catch(HibernateException e){
			throw new ReizzelException("Error configurando la sesion",e);
		}
	}
}
