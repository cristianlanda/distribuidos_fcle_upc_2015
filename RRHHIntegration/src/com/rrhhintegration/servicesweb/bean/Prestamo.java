package com.rrhhintegration.servicesweb.bean;

public class Prestamo {
	private String codigoDNI;
	private String conceptoPrestamo;
	private String importePrestamo;
	public Prestamo() {
		// TODO Auto-generated constructor stub
	}
	public Prestamo(String codigoDNI, String conceptoPrestamo,
			String importePrestamo) {
		super();
		this.codigoDNI = codigoDNI;
		this.conceptoPrestamo = conceptoPrestamo;
		this.importePrestamo = importePrestamo;
	}
	public String getCodigoDNI() {
		return codigoDNI;
	}
	public void setCodigoDNI(String codigoDNI) {
		this.codigoDNI = codigoDNI;
	}
	public String getConceptoPrestamo() {
		return conceptoPrestamo;
	}
	public void setConceptoPrestamo(String conceptoPrestamo) {
		this.conceptoPrestamo = conceptoPrestamo;
	}
	public String getImportePrestamo() {
		return importePrestamo;
	}
	public void setImportePrestamo(String importePrestamo) {
		this.importePrestamo = importePrestamo;
	}
	
	
	
	
	

}
