package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import com.google.gwt.sample.stockwatcher.client.CentroCostoService;
import com.google.gwt.sample.stockwatcher.client.UsuarioService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UsuarioServiceImpl extends RemoteServiceServlet implements UsuarioService {
	
	 private static final Logger LOG = Logger.getLogger(CentroCostoService.class.getName());
	  private static final PersistenceManagerFactory PMF =
	      JDOHelper.getPersistenceManagerFactory("transactions-optional");	  
	  private PersistenceManager getPersistenceManager() {
	    return PMF.getPersistenceManager();
	  }
	  
	@Override
	public void addUsuario(String correo, String nombre, ArrayList<String> tipo) {		
		PersistenceManager pm = getPersistenceManager();
	    try {
	    Usuario u=  new Usuario(correo,nombre,tipo);
	    pm.makePersistent(u);
	    } finally {
	      pm.close();
	    }		
	}
	
	@Override
	public void elminarUsuario(String correo){
		PersistenceManager pm = getPersistenceManager();
		Usuario u = pm.getObjectById(Usuario.class,correo);
		pm.deletePersistent(u);
	}

	@Override
	public void modificarUsuario(String correo, String nombre, ArrayList<String> tipo) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();    
		Usuario u = pm.getObjectById(Usuario.class, correo);		
		  if(u.getCorreo().equalsIgnoreCase(correo)){
			  pm.makePersistent(new Usuario(correo,nombre,tipo)); 
		         }else{	        	
		           pm.close();
		         } 
		  }
	
	@Override
	public Usuario buscarUsuario(String correo){
		PersistenceManager pm = getPersistenceManager();
		Usuario u= pm.getObjectById(Usuario.class,correo);
		return u;
	}
	
	
	
	
}
