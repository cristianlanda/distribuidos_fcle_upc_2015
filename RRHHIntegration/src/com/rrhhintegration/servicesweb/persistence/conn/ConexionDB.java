package com.rrhhintegration.servicesweb.persistence.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.rrhhintegration.servicesweb.common.Constantes;
import com.rrhhintegration.servicesweb.common.Propiedades;
import com.rrhhintegration.servicesweb.common.UserRRHHException;



public class ConexionDB {
	public static Connection obtenerConexion()throws UserRRHHException{
		Connection con=null;
		String entidadNegocio=Constantes.ENTIDAD_NEGOCIO_RRHH;
		String driver=Propiedades.getProperty(Constantes.PROPIEDAD_DRIVER_BD+entidadNegocio);
		String url=Propiedades.getProperty(Constantes.PROPIEDAD_URL_BD+entidadNegocio);
		String usuario=Propiedades.getProperty(Constantes.PROPIEDAD_USUARIO_BD+entidadNegocio);
		String clave=Propiedades.getProperty(Constantes.PROPIEDAD_PASSWORD_BD+entidadNegocio);
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,usuario,clave);
		} catch (ClassNotFoundException e) {
			throw new UserRRHHException("3001", "No se encontro el driver. "+e.toString(),e);
		} catch (SQLException e) {
			throw new UserRRHHException("3002", "Error al obtener coneccion en la BD "+entidadNegocio+". "+e.toString(),e);
		}
		return con;
	}

}
