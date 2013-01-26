package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.google.gwt.sample.stockwatcher.client.CentroCostoService;
import com.google.gwt.sample.stockwatcher.client.DepartamentoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DepartamentoServiceImpl  extends RemoteServiceServlet implements DepartamentoService{
	
	  private static final Logger LOG = Logger.getLogger(DepartamentoService.class.getName());
	  private static final PersistenceManagerFactory PMF =
	      JDOHelper.getPersistenceManagerFactory("transactions-optional");
	  
	  private PersistenceManager getPersistenceManager() {
		    return PMF.getPersistenceManager();
		  }

	@Override
	public void addDepartamento(String codDpto, String nomDpto) {
		
		PersistenceManager pm = getPersistenceManager();
	    try {
	      pm.makePersistent(new Departamento(codDpto,nomDpto));
	    } finally {
	      pm.close();
	    }	
	}
	
	public void elminarDepartamento(String codDpto){
		PersistenceManager pm = getPersistenceManager();
		Departamento d = pm.getObjectById(Departamento.class, codDpto );
		pm.deletePersistent(d);
	}

	@Override
	public void modificarDepartamento(String codDpto, String nomDpto) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();    
		Departamento d = pm.getObjectById(Departamento.class, codDpto);
		
		  if(d.getCodDpto().equalsIgnoreCase(codDpto)){
			  pm.makePersistent(new Departamento(codDpto, nomDpto)); 
		         }else{	        	
		           pm.close();
		         } 
	      }
	
	@Override
	public Departamento d(String  codigo){
		PersistenceManager pm = getPersistenceManager();
		Departamento d = pm.getObjectById(Departamento.class, codigo);
		return d;
	}
	
	@Override
	public ArrayList<Departamento> cargarDepartamento(){
		PersistenceManager pm = getPersistenceManager();
		ArrayList<Departamento>un=new ArrayList<Departamento>();
		Departamento und1=new Departamento("01","PLANTACION");
		Departamento und2=new Departamento("02","EXTRACTORA");
		Departamento und3=new Departamento("03","AGRICOLA");	
		
		Departamento u1= pm.getObjectById(Departamento.class, und1.getCodDpto());
		if(u1!=null){
			un.add(u1);
		}
		Departamento u2= pm.getObjectById(Departamento.class, und2.getCodDpto());
		if(u2!=null){
			un.add(u2);
		}
		Departamento u3= pm.getObjectById(Departamento.class, und3.getCodDpto());
		if(u3!=null){
			un.add(u3);
		}
		
		return un;

	}


}
