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
	private  ArrayList<String> codigoProducto;	
	@Persistent
	private ArrayList<String> cantidad;
	@Persistent
	private Date fecha;

	
	public Exixtencias() {

	}


	public Exixtencias(String codigoBodega, ArrayList<String> codigoProducto,
			ArrayList<String> cantidad, Date fecha) {
		super();
		this.codigoBodega = codigoBodega;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.fecha = fecha;
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


	public ArrayList<String> getCantidad() {
		return cantidad;
	}


	public void setCantidad(ArrayList<String> cantidad) {
		this.cantidad = cantidad;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Exixtencias [codigoBodega=" + codigoBodega
				+ ", codigoProducto=" + codigoProducto + ", cantidad="
				+ cantidad + ", fecha=" + fecha + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
