package com.google.gwt.sample.stockwatcher.server;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.PrimaryKeyJoinColumn;

@PersistenceCapable(identityType=IdentityType.APPLICATION)

public class ProductoPedido implements Serializable {	
	@PrimaryKey  	
    @Persistent	(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String codigoPedido;	
    @Persistent   
    private ArrayList<String>producto;
   	@Persistent
	private ArrayList<Double> cantidadProducto;
	@Persistent
	private ArrayList<Date>fechaCubrimiento;
	@Persistent
	private ArrayList<String> centro;
	@Persistent
	private ArrayList<String> observaciones;
	@Persistent
	private String departamento;
	@Persistent
	private ArrayList<Date>fePed;
	
	
	public  ProductoPedido (){		
		
	}


	public ProductoPedido(String codigoPedido, ArrayList<String> producto,
			ArrayList<Double> cantidadProducto,
			ArrayList<Date> fechaCubrimiento, ArrayList<String> centro,
			ArrayList<String> observaciones, String departamento,
			ArrayList<Date> fePed) {
		super();
		this.codigoPedido = codigoPedido;
		this.producto = producto;
		this.cantidadProducto = cantidadProducto;
		this.fechaCubrimiento = fechaCubrimiento;
		this.centro = centro;
		this.observaciones = observaciones;
		this.departamento = departamento;
		this.fePed = fePed;
	}


	public String getCodigoPedido() {
		return codigoPedido;
	}


	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}


	public ArrayList<String> getProducto() {
		return producto;
	}


	public void setProducto(ArrayList<String> producto) {
		this.producto = producto;
	}


	public ArrayList<Double> getCantidadProducto() {
		return cantidadProducto;
	}


	public void setCantidadProducto(ArrayList<Double> cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	public ArrayList<Date> getFechaCubrimiento() {
		return fechaCubrimiento;
	}


	public void setFechaCubrimiento(ArrayList<Date> fechaCubrimiento) {
		this.fechaCubrimiento = fechaCubrimiento;
	}


	public ArrayList<String> getCentro() {
		return centro;
	}


	public void setCentro(ArrayList<String> centro) {
		this.centro = centro;
	}


	public ArrayList<String> getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(ArrayList<String> observaciones) {
		this.observaciones = observaciones;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public ArrayList<Date> getFePed() {
		return fePed;
	}


	public void setFePed(ArrayList<Date> fePed) {
		this.fePed = fePed;
	}


	@Override
	public String toString() {
		return "ProductoPedido [codigoPedido=" + codigoPedido + ", producto="
				+ producto + ", cantidadProducto=" + cantidadProducto
				+ ", fechaCubrimiento=" + fechaCubrimiento + ", centro="
				+ centro + ", observaciones=" + observaciones
				+ ", departamento=" + departamento + ", fePed=" + fePed + "]";
	}

	
	
}
