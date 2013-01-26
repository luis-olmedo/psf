package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Exixtencias implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private String codigoBodega;
	@Persistent
	private ArrayList<String> codigoProducto;
	@Persistent
	private ArrayList<Date>fecha;
	@Persistent
	private ArrayList<String>cantidad;
	
	public Exixtencias() {

	}

	public Exixtencias(String codigoBodega, ArrayList<String> codigoProducto,
			ArrayList<Date> fecha, ArrayList<String> cantidad) {
		super();
		this.codigoBodega = codigoBodega;
		this.codigoProducto = codigoProducto;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}

	public String getCodigoBodega() {
		return codigoBodega;
	}

	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}

	public ArrayList<String> getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(ArrayList<String> codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public ArrayList<Date> getFecha() {
		return fecha;
	}

	public void setFecha(ArrayList<Date> fecha) {
		this.fecha = fecha;
	}

	public ArrayList<String> getCantidad() {
		return cantidad;
	}

	public void setCantidad(ArrayList<String> cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Exixtencias [codigoBodega=" + codigoBodega
				+ ", codigoProducto=" + codigoProducto + ", fecha=" + fecha
				+ ", cantidad=" + cantidad + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
