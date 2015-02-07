package com.rrhhintegration.servicesweb.persistence.dao;

import java.util.List;




import com.rrhhintegration.servicesweb.bean.Trabajador;

public interface TrabajadorDao {
	public String actualizarTrabajador(Trabajador trabajador) ;
	public String actualizarEstadoTrabajador(Trabajador trabajador) ;
	public String eliminarTrabajador(String codigoTrabajador);
	public Trabajador obtenerUno(String codigoTrabajador);
	public List<Trabajador> obtenerTodos(String nombres,String codigoTrabajador);
	public String registrarTrabajador(Trabajador trabajador);
	public List<Trabajador> obtenerTodos(String nombres,
			String codigoTrabajador, String idCampanha, String idEmpresa);

}
