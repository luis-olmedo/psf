package com.google.gwt.sample.stockwatcher.server;


import java.util.ArrayList;
import java.util.Date;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;


import com.google.gwt.sample.stockwatcher.client.ExistenciaService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ExistenciaServiceImpl extends RemoteServiceServlet implements ExistenciaService {
	private static final PersistenceManagerFactory PMF =
		      JDOHelper.getPersistenceManagerFactory("transactions-optional");
		  private PersistenceManager getPersistenceManager() {
			    return PMF.getPersistenceManager();
			  }
		  
		  @Override
		  public void addExistencia(String codigoBodega, ArrayList<String> codigoProducto,
					ArrayList<Date> fecha, ArrayList<String> cantidad){		  
			
			          PersistenceManager pm = getPersistenceManager();					
				        
	            try {							       
			    	 pm.makePersistent(new Exixtencias(codigoBodega,codigoProducto,fecha,cantidad));      
			      
			       }
			    finally {
			      pm.close();
			    }	
			}
		  
		

}

