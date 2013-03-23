package com.google.gwt.sample.stockwatcher.server;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.annotations.Key;


import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.sample.stockwatcher.client.ExistenciaService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ExistenciaServiceImpl extends RemoteServiceServlet implements ExistenciaService {
	private static final PersistenceManagerFactory PMF =
		      JDOHelper.getPersistenceManagerFactory("transactions-optional");
		  private PersistenceManager getPersistenceManager() {
			    return PMF.getPersistenceManager();
			  }
		  
		  public void addExistencia(String codigoBodega, ArrayList<String> codigoProducto,
					ArrayList<String> cantidad, ArrayList<Date> fecha){	
			  
			          PersistenceManager pm = getPersistenceManager();	
			          
	            try {	
	            	
			    	 pm.makePersistent(new Exixtencias(codigoBodega, codigoProducto,cantidad, fecha));      
			      
			       }
			    finally {
			      pm.close();
			    }	
		  }
		  
		  
		  @Override			 	
          public ArrayList<Exixtencias>getExistencia(){
				PersistenceManager pm = getPersistenceManager();
				Exixtencias a=null;
				ArrayList<Exixtencias>aa= new ArrayList<Exixtencias>();
				Extent extent = pm.getExtent(Exixtencias.class, false);			
				Iterator it = extent.iterator();
				while(it.hasNext()) {
					 a = (Exixtencias) it.next();
					 aa.add(a);
					 }
				extent.closeAll();
				pm.close(); 
				return aa;
		  }
		  
		  
		  @Override
		  public ArrayList<Exixtencias> buscarExistencia(String  codigoProducto){
				PersistenceManager pm = getPersistenceManager();
				Exixtencias a=null;
				ArrayList<Exixtencias>aa= new ArrayList<Exixtencias>();
				Extent extent = pm.getExtent(Exixtencias.class, false);			
				Iterator it = extent.iterator();
				while(it.hasNext()) {
					 a = (Exixtencias) it.next();
					 aa.add(a);
					 }
				extent.closeAll();
				pm.close(); 
				return aa;
			  
		  }
		  
		  
}

		  
		  
		
		




