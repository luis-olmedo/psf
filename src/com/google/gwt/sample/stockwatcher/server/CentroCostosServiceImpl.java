package com.google.gwt.sample.stockwatcher.server;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.google.gwt.sample.stockwatcher.client.CentroCostoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CentroCostosServiceImpl extends RemoteServiceServlet implements
CentroCostoService
{
  private static final Logger LOG = Logger.getLogger(CentroCostoService.class.getName());
  private static final PersistenceManagerFactory PMF =
      JDOHelper.getPersistenceManagerFactory("transactions-optional");  
  private PersistenceManager getPersistenceManager() {
    return PMF.getPersistenceManager();
  }  
  
@Override
public void addCentroCostos(String codigoCostos, String nombreCostos) {
	// TODO Auto-generated method stub
	PersistenceManager pm = getPersistenceManager();
    try {
      pm.makePersistent(new CentroCostos(codigoCostos,nombreCostos));
    } finally {
      pm.close();
    }	    
}


public void elminarCentroCostos(String codigo){
	PersistenceManager pm = getPersistenceManager();
	CentroCostos c = pm.getObjectById(CentroCostos.class, codigo);
	pm.deletePersistent(c);
}

@Override
public void modificarCentroCostos(String codigo, String nombre) {
	// TODO Auto-generated method stub
	PersistenceManager pm = getPersistenceManager();    
	CentroCostos c = pm.getObjectById(CentroCostos.class, codigo);
	
	  if(c.getCodigoCosto().equalsIgnoreCase(codigo)){
		  pm.makePersistent(new CentroCostos(codigo,nombre)); 
	         }else{	        	
	           pm.close();
	         } 
      }


@Override
public CentroCostos c(String codigo){
	PersistenceManager pm = getPersistenceManager();
	CentroCostos c = pm.getObjectById(CentroCostos.class, codigo);
	return c;
}


@Override
public ArrayList<CentroCostos> cargarCentroCostos(){
	PersistenceManager pm = getPersistenceManager();
	CentroCostos a=null;
	ArrayList<CentroCostos>aa= new ArrayList<CentroCostos>();
	Extent extent = pm.getExtent(CentroCostos.class, false);
	Iterator it = extent.iterator();
	while(it.hasNext()) {
		 a = (CentroCostos) it.next();
		 aa.add(a);
		 }
	extent.closeAll();
	pm.close(); 
	return aa;

}

}


