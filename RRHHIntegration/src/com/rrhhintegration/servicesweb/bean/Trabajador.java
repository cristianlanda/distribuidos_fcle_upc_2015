package com.rrhhintegration.servicesweb.bean;

public class Trabajador {
	private String codigoDNI;
	private String nombres;
	private String apePat;
	private String apeMat;
	private String direccion;
	private String numCUPS;
	private String codigoAFP;
	private String codigoBancoAbono;
	private String estadoCivil;
	private String codigoNacionalidad;
	private String codigoDepartamento;
	private String codigoProvincia;
	private String codigoDistrito;
	private String sexoColaborador;
	private String estadoActivo;
	private String correo;
	private String campanha;
	
	
	public Trabajador(String codigoDNI, String nombres, String apePat,
			String apeMat, String direccion, String numCUPS, String codigoAFP,
			String codigoBancoAbono, String estadoCivil,
			String codigoNacionalidad, String codigoDepartamento,
			String codigoProvincia, String codigoDistrito,
			String sexoColaborador, String estadoActivo, String correo) {
		super();
		this.codigoDNI = codigoDNI;
		this.nombres = nombres;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.direccion = direccion;
		this.numCUPS = numCUPS;
		this.codigoAFP = codigoAFP;
		this.codigoBancoAbono = codigoBancoAbono;
		this.estadoCivil = estadoCivil;
		this.codigoNacionalidad = codigoNacionalidad;
		this.codigoDepartamento = codigoDepartamento;
		this.codigoProvincia = codigoProvincia;
		this.codigoDistrito = codigoDistrito;
		this.sexoColaborador = sexoColaborador;
		this.estadoActivo = estadoActivo;
		this.correo = correo;
	}
	
	

	
	public Trabajador(String codigoDNI, String nombres, String apePat,
			String apeMat, String direccion, String numCUPS, String codigoAFP,
			String codigoBancoAbono, String estadoCivil,
			String codigoNacionalidad, String codigoDepartamento,
			String codigoProvincia, String codigoDistrito,
			String sexoColaborador, String estadoActivo, String correo,
			String campanha) {
		super();
		this.codigoDNI = codigoDNI;
		this.nombres = nombres;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.direccion = direccion;
		this.numCUPS = numCUPS;
		this.codigoAFP = codigoAFP;
		this.codigoBancoAbono = codigoBancoAbono;
		this.estadoCivil = estadoCivil;
		this.codigoNacionalidad = codigoNacionalidad;
		this.codigoDepartamento = codigoDepartamento;
		this.codigoProvincia = codigoProvincia;
		this.codigoDistrito = codigoDistrito;
		this.sexoColaborador = sexoColaborador;
		this.estadoActivo = estadoActivo;
		this.correo = correo;
		this.campanha = campanha;
	}




	public Trabajador(String codigoDNI, String estadoActivo) {
		super();
		this.codigoDNI = codigoDNI;
		this.estadoActivo = estadoActivo;
	}


	public Trabajador() {
		super();
	}


	public String getCodigoDNI() {
		return codigoDNI;
	}


	public void setCodigoDNI(String codigoDNI) {
		this.codigoDNI = codigoDNI;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApePat() {
		return apePat;
	}


	public void setApePat(String apePat) {
		this.apePat = apePat;
	}


	public String getApeMat() {
		return apeMat;
	}


	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getNumCUPS() {
		return numCUPS;
	}


	public void setNumCUPS(String numCUPS) {
		this.numCUPS = numCUPS;
	}


	public String getCodigoAFP() {
		return codigoAFP;
	}


	public void setCodigoAFP(String codigoAFP) {
		this.codigoAFP = codigoAFP;
	}


	public String getCodigoBancoAbono() {
		return codigoBancoAbono;
	}


	public void setCodigoBancoAbono(String codigoBancoAbono) {
		this.codigoBancoAbono = codigoBancoAbono;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public String getCodigoNacionalidad() {
		return codigoNacionalidad;
	}


	public void setCodigoNacionalidad(String codigoNacionalidad) {
		this.codigoNacionalidad = codigoNacionalidad;
	}


	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}


	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}


	public String getCodigoProvincia() {
		return codigoProvincia;
	}


	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}


	public String getCodigoDistrito() {
		return codigoDistrito;
	}


	public void setCodigoDistrito(String codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}


	public String getSexoColaborador() {
		return sexoColaborador;
	}


	public void setSexoColaborador(String sexoColaborador) {
		this.sexoColaborador = sexoColaborador;
	}


	public String getEstadoActivo() {
		return estadoActivo;
	}


	public void setEstadoActivo(String estadoActivo) {
		this.estadoActivo = estadoActivo;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getCampanha() {
		return campanha;
	}


	public void setCampanha(String campanha) {
		this.campanha = campanha;
	}




	@Override
	public String toString() {
		return "Trabajador [codigoDNI=" + codigoDNI + ", nombres=" + nombres
				+ ", apePat=" + apePat + ", apeMat=" + apeMat + ", direccion="
				+ direccion + ", numCUPS=" + numCUPS + ", codigoAFP="
				+ codigoAFP + ", codigoBancoAbono=" + codigoBancoAbono
				+ ", estadoCivil=" + estadoCivil + ", codigoNacionalidad="
				+ codigoNacionalidad + ", codigoDepartamento="
				+ codigoDepartamento + ", codigoProvincia=" + codigoProvincia
				+ ", codigoDistrito=" + codigoDistrito + ", sexoColaborador="
				+ sexoColaborador + ", estadoActivo=" + estadoActivo
				+ ", correo=" + correo + ", campanha=" + campanha + "]";
	}
	
	

	



	
	
	

}
