package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.jdo.Extent;
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
		TipoUsuario tu = pm.getObjectById(TipoUsuario.class, tipo);	
		  if(tu.getTipo().equalsIgnoreCase(tipo)){
			  pm.makePersistent(new TipoUsuario(tipo,tipoUsu)); 
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
		TipoUsuario a=null;
		ArrayList<TipoUsuario>aa= new ArrayList<TipoUsuario>();
		Extent extent = pm.getExtent(Empresa.class, false);
		Iterator it = extent.iterator();
		while(it.hasNext()) {
			 a = (TipoUsuario) it.next();
			 aa.add(a);
			 }
		extent.closeAll();
		pm.close(); 
		return aa;
	}
	
}
