package com.rrhhintegration.servicesweb.utils;

public class Utils {
	public static String validateNull(String cadena){
		if(cadena==null){
			return "''";
		}
		cadena=cadena.trim();
		
		if(cadena.equals("")){
			cadena= "''";
		}else{
			cadena="'"+cadena+"'";
		}
		return cadena;
	}
}
