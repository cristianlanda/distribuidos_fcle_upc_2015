/**
 * 
 */
package com.rrhhintegration.servicesweb.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.rrhhintegration.servicesweb.bean.Trabajador;

/**
 * @author flandaes
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface TrabajadorWS {
	@WebMethod(operationName = "actualizarTrabajador")
	@WebResult(name="response")
	public String actualizarTrabajador(@WebParam(name = "trabajador")Trabajador trabajador);
	@WebMethod(operationName = "eliminarTrabajador")
	@WebResult(name="response")
	public String eliminarTrabajador(@WebParam(name = "codigoTrabajador")String codigoTrabajador);
	@WebMethod(operationName = "obtenerUno")
	@WebResult(name="response")
	public Trabajador obtenerUno(@WebParam(name = "codigoTrabajador")String codigoTrabajador);
	@WebMethod(operationName = "obtenerTodos")
	@WebResult(name="response")
	public List<Trabajador> obtenerTodos(@WebParam(name = "nombre")String nombre,@WebParam(name = "codigoTrabajador")String codigoTrabajador);
	@WebMethod(operationName = "registrarTrabajador")
	@WebResult(name="response")
	public String registrarTrabajador(@WebParam(name = "trabajador")Trabajador trabajador);
	@WebMethod(operationName = "filtrarTodos")
	@WebResult(name="response")
	public List<Trabajador> filtrarTodos(@WebParam(name = "idEmpresa")String idEmpresa,@WebParam(name = "idCampanha")String idCampanha,@WebParam(name = "nombre")String nombre,@WebParam(name = "codigoTrabajador")String codigoTrabajador);

}
