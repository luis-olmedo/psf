package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.google.gwt.sample.stockwatcher.client.EmpresaService;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EmpresaServiceImpl extends RemoteServiceServlet implements
EmpresaService 

{
  private static final Logger LOG = Logger.getLogger(EmpresaServiceImpl.class.getName());
  private static final PersistenceManagerFactory PMF =
      JDOHelper.getPersistenceManagerFactory("transactions-optional");  
  private static PersistenceManager getPersistenceManager() {
    return PMF.getPersistenceManager();
  } 

@Override
public String addEmpresa(String codigo, String nombre) {
	
	PersistenceManager pm = getPersistenceManager();		
	pm.makePersistent(new Empresa(codigo,nombre)); 	
	return codigo;	
}

public String consultarEmpresa(String codigo){		
PersistenceManager pm = getPersistenceManager();
Empresa e = pm.getObjectById(Empresa.class, codigo);
return e.getNombre();
}




public void  elminarEmpresa(String codigo){
	PersistenceManager pm = getPersistenceManager();
	Empresa e = pm.getObjectById(Empresa.class, codigo);
	pm.deletePersistent(e);
	return;	
}


@Override
public void modificarEmpresa(String codigo, String nombre) {
	// TODO Auto-generated method stub
	PersistenceManager pm = getPersistenceManager();    
	Empresa e = pm.getObjectById(Empresa.class, codigo);	
	  if(e.getCodigoEmpresa().equalsIgnoreCase(codigo)){
		  pm.makePersistent(new Empresa(codigo,nombre)); 
	         }else{	        	
	           pm.close();
	         } 	
}


@Override
public Empresa e(String  codigo){
	PersistenceManager pm = getPersistenceManager();
	Empresa e = pm.getObjectById(Empresa.class, codigo);
	return e;
}

@Override
public ArrayList<Empresa> cargarEmpresa(){
	PersistenceManager pm = getPersistenceManager();
	ArrayList<Empresa>un=new ArrayList<Empresa>();
	Empresa und1=new Empresa("PSF","PALMA SANTA FE");
	Empresa und2=new Empresa("EX","EXTRACTORA");	
	
	Empresa u1= pm.getObjectById(Empresa.class, und1.getCodigoEmpresa());
	if(u1!=null){
		un.add(u1);
	}	
	Empresa  u2= pm.getObjectById(Empresa.class, und2.getCodigoEmpresa());
	if(u2!=null){
		un.add(u2);
	}	
	return un;
}

@Override
public ArrayList<Empresa> listTodos() {	
	PersistenceManager pm = getPersistenceManager();
	Empresa a=null;
	ArrayList<Empresa>aa= new ArrayList<Empresa>();
	Extent extent = pm.getExtent(Empresa.class, false);
	Iterator it = extent.iterator();
	while(it.hasNext()) {
		 a = (Empresa) it.next();
		 aa.add(a);
	}
	extent.closeAll();
	pm.close(); 
	return aa;
}

}










