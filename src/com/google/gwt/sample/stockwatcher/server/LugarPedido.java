package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LugarPedido implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	String codigoLugar;
	@Persistent
	String nombreLugar;
	
    public LugarPedido (){
		
	}
    
	public LugarPedido(String codigoLugar, String nombreLugar) {
		super();
		this.codigoLugar = codigoLugar;
		this.nombreLugar = nombreLugar;
	}
	
	public String getCodigoLugar() {
		return codigoLugar;
	}
	
	public void setCodigoLugar(String codigoLugar) {
		this.codigoLugar = codigoLugar;
	}
	
	public String getNombreLugar() {
		return nombreLugar;
	}
	
	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}
	
	@Override
	public String toString() {
		return "LugarPedido [codigoLugar=" + codigoLugar + ", nombreLugar="
				+ nombreLugar + "]";
	}
	
	
	
	
}
