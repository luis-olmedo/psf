package com.google.gwt.sample.stockwatcher.server;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class Departamento implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	String codDpto;
	@Persistent
	String nomDpto;
	
    public Departamento (){
		
	}
	
	public Departamento(String codDpto, String nomDpto) {
		super();
		this.codDpto = codDpto;
		this.nomDpto = nomDpto;
	}
	public String getCodDpto() {
		return codDpto;
	}
	public void setCodDpto(String codDpto) {
		this.codDpto = codDpto;
	}
	public String getNomDpto() {
		return nomDpto;
	}
	public void setNomDpto(String nomDpto) {
		this.nomDpto = nomDpto;
	}
	
	
}
