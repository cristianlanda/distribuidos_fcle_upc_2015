package com.rrhhintegration.servicesweb.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {
	private static Propiedades instance = null;
	private Properties propert = null;
	
	
	/**
	 * Metodo que permite obtener una instancia
	 * @return
	 */
	private static Propiedades getInstance(){
		if (instance == null) {
			instance = new Propiedades();
		}		
		return instance;
	}
	/**
	 * Constructor tipo privado
	 */
	private Propiedades() {
		FileInputStream fis=null;
		String rutaCompleta=Constantes.RUTA_ARCHIVO_PROPIEDADES_CONFIG_BD+Constantes.NOMBRE_ARCHIVO_PROPIEDADES_CONFIG_BD;
		propert=new Properties();
		
		try{
			fis=new FileInputStream(rutaCompleta);
			propert.load(fis);
		}
		catch(Exception e){
			System.out.println("Error al cargar el archivo de Propiedades: "+rutaCompleta +". "+ e);
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar archivo de Propiedades: "+e.toString());
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Metodo que permite obtener un valor leido del objeto Property, el cual se
	 * cargo en memoria una primera vez del archivo de Propiedades
	 * @param key
	 * @return
	 */
	public static String getProperty(String key){
	    String valorPropiedad = null;
	    
	    valorPropiedad = getInstance().propert.getProperty(key);
	    
	    if (valorPropiedad != null) {
	        valorPropiedad = valorPropiedad.trim();
	    }
	    
		return valorPropiedad;
	}
	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(Propiedades instance) {
		Propiedades.instance = instance;
	}
	
}