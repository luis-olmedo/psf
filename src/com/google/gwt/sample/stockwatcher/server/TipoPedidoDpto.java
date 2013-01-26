package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class TipoPedidoDpto implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private String codigoPedido;
	@Persistent
	private String codigoDpto;
	@Persistent
	private String lugarPedido;
	@Persistent 
	private String codigoEmpresa;
	@Persistent
	private int diasCubrimiento;
	
	
	public TipoPedidoDpto() {
		
	}
	
	public TipoPedidoDpto(String codigoPedido, String codigoDpto,
			String lugarPedido, String codigoEmpresa, int diasCubrimiento) {
		super();
		this.codigoPedido = codigoPedido;
		this.codigoDpto = codigoDpto;
		this.lugarPedido = lugarPedido;
		this.codigoEmpresa = codigoEmpresa;
		this.diasCubrimiento = diasCubrimiento;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getCodigoDpto() {
		return codigoDpto;
	}

	public void setCodigoDpto(String codigoDpto) {
		this.codigoDpto = codigoDpto;
	}

	public String getLugarPedido() {
		return lugarPedido;
	}

	public void setLugarPedido(String lugarPedido) {
		this.lugarPedido = lugarPedido;
	}

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public int getDiasCubrimiento() {
		return diasCubrimiento;
	}

	public void setDiasCubrimiento(int diasCubrimiento) {
		this.diasCubrimiento = diasCubrimiento;
	}

	@Override
	public String toString() {
		return "TipoPedidoDpto [codigoPedido=" + codigoPedido + ", codigoDpto="
				+ codigoDpto + ", lugarPedido=" + lugarPedido
				+ ", codigoEmpresa=" + codigoEmpresa + ", diasCubrimiento="
				+ diasCubrimiento + "]";
	}

	
	
	
	
}
