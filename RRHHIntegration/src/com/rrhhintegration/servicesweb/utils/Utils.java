package com.rrhhintegration.servicesweb.utils;

public class Utils {
	public static String validateNull(String cadena){
		if(cadena==null){
			return "";
		}
		return cadena.trim();
	}
}
