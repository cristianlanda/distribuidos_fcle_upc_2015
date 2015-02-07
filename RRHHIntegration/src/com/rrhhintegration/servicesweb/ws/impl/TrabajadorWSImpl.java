package com.rrhhintegration.servicesweb.ws.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.rrhhintegration.servicesweb.bean.Trabajador;
import com.rrhhintegration.servicesweb.persistence.dao.impl.TrabajadorDaoImpl;
import com.rrhhintegration.servicesweb.ws.TrabajadorWS;

@Stateless
@WebService
@Remote(TrabajadorWS.class)
public class TrabajadorWSImpl implements TrabajadorWS{
	@Override
	@WebMethod(operationName = "actualizarTrabajador")
	@WebResult(name="response")
	public String actualizarTrabajador(Trabajador trabajador){
		return new TrabajadorDaoImpl().actualizarTrabajador(trabajador);
	}
	@Override
	@WebMethod(operationName = "eliminarTrabajador")
	@WebResult(name="response")
	public String eliminarTrabajador(String codigoTrabajador){
		return new TrabajadorDaoImpl().eliminarTrabajador(codigoTrabajador);
	}
	@Override
	@WebMethod(operationName = "obtenerTodos")
	@WebResult(name="response")
	public List<Trabajador> obtenerTodos(String nombre,String codigoTrabajador){
		return new TrabajadorDaoImpl().obtenerTodos(nombre, codigoTrabajador);
	}
	@Override
	@WebMethod(operationName = "registrarTrabajador")
	@WebResult(name="response")
	public String registrarTrabajador(Trabajador trabajador){
		return new TrabajadorDaoImpl().registrarTrabajador(trabajador);
	}
	@Override
	@WebMethod(operationName = "obtenerUno")
	@WebResult(name="response")
	public Trabajador obtenerUno(String codigoTrabajador) {
		return new TrabajadorDaoImpl().obtenerUno(codigoTrabajador);
	}
	
	public List<Trabajador> obtenerTodos(String idEmpresa,String nombre,String codigoTrabajador){
		
		return null;
	}
}
