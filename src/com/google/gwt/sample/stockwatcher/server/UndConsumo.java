package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class UndConsumo implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	String idUnd;
	@Persistent
	String nombreUnd;
	
public UndConsumo (){
		
	}

public UndConsumo(String idUnd, String nombreUnd) {
	super();
	this.idUnd = idUnd;
	this.nombreUnd = nombreUnd;
}

public String getIdUnd() {
	return idUnd;
}

public void setIdUnd(String idUnd) {
	this.idUnd = idUnd;
}

public String getNombreUnd() {
	return nombreUnd;
}

public void setNombreUnd(String nombreUnd) {
	this.nombreUnd = nombreUnd;
}

@Override
public String toString() {
	return "UndConsumo [idUnd=" + idUnd + ", nombreUnd=" + nombreUnd + "]";
}


	
	
}