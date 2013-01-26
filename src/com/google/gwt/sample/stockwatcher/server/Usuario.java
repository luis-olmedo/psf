package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Usuario implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private String  correo;	
	@Persistent
	private String nombre;	
	@Persistent	
	private  ArrayList<String> tipo;	
	
	public Usuario() {		
	}

	public Usuario(String correo, String nombre, ArrayList<String> tipo) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getTipo() {
		return tipo;
	}

	public void setTipo(ArrayList<String> tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", nombre=" + nombre + ", tipo="
				+ tipo + "]";
	}
	
	
	
	
	
	
	
	
}
