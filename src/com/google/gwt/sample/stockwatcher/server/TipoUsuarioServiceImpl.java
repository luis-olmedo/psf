package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.google.gwt.sample.stockwatcher.client.TipoUsuarioService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TipoUsuarioServiceImpl extends RemoteServiceServlet implements TipoUsuarioService{
	
	 private static final Logger LOG = Logger.getLogger(EmpresaServiceImpl.class.getName());
	  private static final PersistenceManagerFactory PMF =
	      JDOHelper.getPersistenceManagerFactory("transactions-optional");

	  
	  private PersistenceManager getPersistenceManager() {
	    return PMF.getPersistenceManager();
	  }
	  
	@Override
	public void addTipoUsuario(String tipo, String tipoUsu) {		
	    PersistenceManager pm = getPersistenceManager();	    
	    try {	    
	    	   pm.makePersistent(new TipoUsuario(tipo,tipoUsu));
	      
	    } finally {
	      pm.close();
	    }	
	}
	
	public void elminarTipoUsuario(String tipo){
		PersistenceManager pm = getPersistenceManager();
		TipoUsuario t= pm.getObjectById(TipoUsuario.class,tipo);
		pm.deletePersistent(t);
	}

	@Override
	public void modificarTipoUsuario(String tipo, String tipoUsu) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();    
		TipoUsuario t = pm.getObjectById(TipoUsuario.class, tipo);
		
		  if(t.getTipo().equalsIgnoreCase(tipo)){
			  pm.makePersistent(new Departamento(tipo,tipoUsu)); 
		         }else{	        	
		           pm.close();
		         } 
	      }
	
	@Override
	public TipoUsuario t(String codigo){
		PersistenceManager pm = getPersistenceManager();
		TipoUsuario t = pm.getObjectById(TipoUsuario.class, codigo);
		return t;
	}	

	@Override
	public ArrayList<TipoUsuario> cargarTipo(){
		PersistenceManager pm = getPersistenceManager();
		ArrayList<TipoUsuario>un=new ArrayList<TipoUsuario>();
		TipoUsuario und1=new TipoUsuario("ADMIN","ADMINISTRADOR");
		TipoUsuario und2=new TipoUsuario("ALMA","ALMACENISTA");
		TipoUsuario und3=new TipoUsuario("REC","RECIBIDOR");	
		
		TipoUsuario u1= pm.getObjectById(TipoUsuario.class, und1.getTipo());
		if(u1!=null){
			un.add(u1);
		}
		TipoUsuario u2= pm.getObjectById(TipoUsuario.class, und2.getTipo());
		if(u2!=null){
			un.add(u2);
		}
		TipoUsuario u3= pm.getObjectById(TipoUsuario.class, und3.getTipo());
		if(u3!=null){
			un.add(u3);
		}
		
		return un;

	}
	
}
