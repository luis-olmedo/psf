package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)

public class Bodega implements Serializable{
@PrimaryKey
@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
private String codigoBodega;
@Persistent
private String nombre;
@Persistent 
private String codigoEmpresa;

public Bodega() {

}

public Bodega(String codigoBodega, String nombre, String codigoEmpresa) {
	super();
	this.codigoBodega = codigoBodega;
	this.nombre = nombre;
	this.codigoEmpresa = codigoEmpresa;
}

public String getCodigoBodega() {
	return codigoBodega;
}

public void setCodigoBodega(String codigoBodega) {
	this.codigoBodega = codigoBodega;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCodigoEmpresa() {
	return codigoEmpresa;
}

public void setCodigoEmpresa(String codigoEmpresa) {
	this.codigoEmpresa = codigoEmpresa;
}

@Override
public String toString() {
	return "Bodega [codigoBodega=" + codigoBodega + ", nombre=" + nombre
			+ ", codigoEmpresa=" + codigoEmpresa + "]";
}





}