package com.google.gwt.sample.stockwatcher.server;


import java.util.ArrayList;
import java.util.logging.Logger;
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
	ArrayList<CentroCostos>un=new ArrayList<CentroCostos>();
	CentroCostos und1=new CentroCostos("1001","MOTO");
	CentroCostos und2=new CentroCostos("1002","KUBOTA");
	CentroCostos und3=new CentroCostos("1003","JOHN DEERE");	
	
	CentroCostos u1= pm.getObjectById(CentroCostos.class, und1.getCodigoCosto());
	if(u1!=null){
		un.add(u1);
	}
	CentroCostos u2= pm.getObjectById(CentroCostos.class, und2.getCodigoCosto());
	if(u2!=null){
		un.add(u2);
	}
	CentroCostos u3= pm.getObjectById(CentroCostos.class, und3.getCodigoCosto());
	if(u3!=null){
		un.add(u3);
	}
	
	return un;

}

}


