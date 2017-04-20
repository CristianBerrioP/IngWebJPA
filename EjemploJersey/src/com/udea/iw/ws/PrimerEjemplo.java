package com.udea.iw.ws;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("saludo")
public class PrimerEjemplo {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String saludar(){
		return "Hola mundo";
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("2")
	public String saludar2(){
		return "Hola";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("3")
	public String saludar3(@QueryParam("a")String nombre){
		return "Buenas tardes " + nombre;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("4/{a}")
	public String saludar4(@PathParam("a")String nombre){
		return "Buenas tardes " + nombre;
	}
}
