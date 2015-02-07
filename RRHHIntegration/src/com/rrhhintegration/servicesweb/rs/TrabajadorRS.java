package com.rrhhintegration.servicesweb.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rrhhintegration.servicesweb.bean.Trabajador;
import com.rrhhintegration.servicesweb.persistence.dao.TrabajadorDao;
import com.rrhhintegration.servicesweb.persistence.dao.impl.TrabajadorDaoImpl;
import com.rrhhintegration.servicesweb.rs.model.Message;

@Path("/TrabajadorRS")
public class TrabajadorRS {
	@POST
	@Path("/Trabajador/actualizarEstado")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public Message actualizarEstado(@FormParam("codigoTrabajador") String codigoTrabajador,	@FormParam("flagEstado") String flagEstado) {
		TrabajadorDao trabajadorDao=new TrabajadorDaoImpl();
		Message message=new Message();
		message.setCodeReply("0000");
		message.setMessageReply("Se actualizo satisfactoriamente");		
		Trabajador trabajador=new Trabajador(codigoTrabajador,flagEstado);
		String codRpta=trabajadorDao.actualizarEstadoTrabajador(trabajador);
		
		if(!codRpta.equals("0000")){
			message.setCodeReply("0001");
			message.setMessageReply("Error al actualizar el estado en el sistema");
		}
		
		return message;
	}


}
