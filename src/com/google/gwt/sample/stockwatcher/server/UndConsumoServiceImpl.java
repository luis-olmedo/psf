package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.jdo.Extent;
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
		UndConsumo a=null;
		ArrayList<UndConsumo>aa= new ArrayList<UndConsumo>();
		Extent extent = pm.getExtent(UndConsumo.class, false);
		Iterator it = extent.iterator();
		while(it.hasNext()) {
			 a = (UndConsumo) it.next();
			 aa.add(a);
			 }
		extent.closeAll();
		pm.close(); 
		return aa;

	}

	@Override
	public void elminarUndConsumo(String idUnd) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		UndConsumo e = pm.getObjectById(UndConsumo.class,idUnd);
		pm.deletePersistent(e);
		return;	
	}
	
}
