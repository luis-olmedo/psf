package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
//ojo la  cantidad  va  hacer un  metodo  que dependera de las exitencias  totales  que hay  del producto
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ProductoBase implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String  codigoProducto;
	@Persistent
	private  String  descripcion;
	@Persistent
	private  double cantidadInventariado;
	@Persistent
	private  double precio;	
	@Persistent
	private  String idUnd;
	
	public ProductoBase() {
		
	}
	
	public ProductoBase(String  codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public ProductoBase(String codigoProducto, String descripcion,
			double cantidadInventariado, double precio, String idUnd) {
		super();
		this.codigoProducto = codigoProducto;
		this.descripcion = descripcion;
		this.cantidadInventariado = cantidadInventariado;
		this.precio = precio;
		this.idUnd = idUnd;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCantidadInventariado() {
		return cantidadInventariado;
	}

	public void setCantidadInventariado(double cantidadInventariado) {
		this.cantidadInventariado = cantidadInventariado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getIdUnd() {
		return idUnd;
	}

	public void setIdUnd(String idUnd) {
		this.idUnd = idUnd;
	}

	@Override
	public String toString() {
		return "ProductoBase [codigoProducto=" + codigoProducto + "]";
	}


	
	
	
	
	
}
