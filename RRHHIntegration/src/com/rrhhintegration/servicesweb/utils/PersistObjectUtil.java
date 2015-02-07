package com.rrhhintegration.servicesweb.utils;

import java.util.ArrayList;
import java.util.List;

import com.rrhhintegration.servicesweb.bean.Trabajador;

public class PersistObjectUtil {
	public static List<Trabajador> listTrabajadores=new ArrayList<Trabajador>();
	
	static{
		listTrabajadores.add(
				new Trabajador("11223344","Jose","Llontop","Orlando",
						"Av. garcilazo 234", "24323","344334",
						"1934533","S","PE","Lima","Lima","San Miguel","M","T","email1"));
		
		listTrabajadores.add(
				new Trabajador("22334455","Carlos","Irribarren","Huaman",
						"Av. aviacion 234", "3443","5644",
						"192434","S","PE","Lima","Lima","Surco","M","P","email2"));		
		
		
		
	}

}
