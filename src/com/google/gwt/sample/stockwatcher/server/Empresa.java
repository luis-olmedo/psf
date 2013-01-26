package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Empresa implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String codigoEmpresa;
	@Persistent
	private String nombre;	
	

	public Empresa() {		
		
	}


	public Empresa(String codigoEmpresa, String nombre) {
		super();
		this.codigoEmpresa = codigoEmpresa;
		this.nombre = nombre;
	}


	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}


	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Empresa [codigoEmpresa=" + codigoEmpresa + ", nombre=" + nombre
				+ "]";
	}
	

	
	
	

	
	
	
	

 

	
	

}
