package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.google.gwt.sample.stockwatcher.client.CentroCostoService;
import com.google.gwt.sample.stockwatcher.client.UndConsumoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UndConsumoServiceImpl   extends RemoteServiceServlet implements UndConsumoService{
	
	 private static final Logger LOG = Logger.getLogger(CentroCostoService.class.getName());
	  private static final PersistenceManagerFactory PMF =
	      JDOHelper.getPersistenceManagerFactory("transactions-optional");

	  
	  private PersistenceManager getPersistenceManager() {
	    return PMF.getPersistenceManager();
	  }
	  
	@Override
	public void addUndConsumjo(String idUnd, String nombreUnd) {
		
		PersistenceManager pm = getPersistenceManager();
	    try {
	      pm.makePersistent(new UndConsumo(idUnd,nombreUnd));
	    } finally {
	      pm.close();
	    }		
	}
	
	public void elminarUndConsumo(String idUnd){
		PersistenceManager pm = getPersistenceManager();
		TipoUsuario t= pm.getObjectById(TipoUsuario.class,idUnd);
		pm.deletePersistent(t);
	}

	@Override
	public void modificarUndConsumo(String idUnd, String nombreUnd) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();    
		UndConsumo u = pm.getObjectById(UndConsumo.class, idUnd);
		
		  if(u.getIdUnd().equalsIgnoreCase(idUnd)){
			  pm.makePersistent(new UndConsumo(idUnd,nombreUnd)); 
		         }else{	        	
		           pm.close();
		         } 
		  }
	
	@Override
	public UndConsumo u(String  codigo){
		PersistenceManager pm = getPersistenceManager();
		UndConsumo u= pm.getObjectById(UndConsumo.class, codigo);
		return u;
	}
	
	@Override
	public ArrayList<UndConsumo> cargarUnd(){
		PersistenceManager pm = getPersistenceManager();
		ArrayList<UndConsumo>un=new ArrayList<UndConsumo>();
		UndConsumo und1=new UndConsumo("LIT","LITRO");
		UndConsumo und2=new UndConsumo("PAR","PAR");
		UndConsumo und3=new UndConsumo("UND","UNIDAD");	
		
		UndConsumo u1= pm.getObjectById(UndConsumo.class, und1.getIdUnd());
		if(u1!=null){
			un.add(u1);
		}
		UndConsumo u2= pm.getObjectById(UndConsumo.class, und2.getIdUnd());
		if(u2!=null){
			un.add(u2);
		}
		UndConsumo u3= pm.getObjectById(UndConsumo.class, und3.getIdUnd());
		if(u3!=null){
			un.add(u3);
		}
		
		return un;

	}
	
}
