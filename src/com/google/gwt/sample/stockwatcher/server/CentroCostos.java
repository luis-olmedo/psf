package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class CentroCostos implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	String codigoCosto;
	@Persistent
	String nombreCosto;
	
	public CentroCostos(){
		
	}
	
   public CentroCostos(String   codigoCosto){
	   this.codigoCosto = codigoCosto;
	}
	
	public CentroCostos(String codigoCosto, String nombreCosto) {
		super();
		this.codigoCosto = codigoCosto;
		this.nombreCosto = nombreCosto;
	}

	public String getCodigoCosto() {
		return codigoCosto;
	}

	public void setCodigoCosto(String codigoCosto) {
		this.codigoCosto = codigoCosto;
	}

	public String getNombreCosto() {
		return nombreCosto;
	}

	public void setNombreCosto(String nombreCosto) {
		this.nombreCosto = nombreCosto;
	}

	@Override
	public String toString() {
		return "CentroCostos [codigoCosto=" + codigoCosto + "]";
	}

	
	
	
	
	
	
	
}
