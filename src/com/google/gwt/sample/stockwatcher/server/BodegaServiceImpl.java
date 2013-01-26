package com.google.gwt.sample.stockwatcher.server;


import java.util.ArrayList;
import java.util.logging.Logger;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;



import com.google.gwt.sample.stockwatcher.client.BodegaService;
import com.google.gwt.sample.stockwatcher.client.DepartamentoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class BodegaServiceImpl extends RemoteServiceServlet implements BodegaService{
	
	private static final Logger LOG = Logger.getLogger(DepartamentoService.class.getName());
	  private static final PersistenceManagerFactory PMF =
	      JDOHelper.getPersistenceManagerFactory("transactions-optional");
	  private PersistenceManager getPersistenceManager() {
		    return PMF.getPersistenceManager();
		  }
	  
	  @Override
	  public void addBodega(String codigo, String nombre,String codigoEmpresa){		  
			PersistenceManager pm = getPersistenceManager();
			Empresa e = pm.getObjectById(Empresa.class, codigoEmpresa);
			
		    try {
		      if (e!=null){
		    	  
		    	  pm.makePersistent(new Bodega(codigo,nombre,codigoEmpresa));
		      }else{		    	  
		    	  pm.close();
		      }	    
		      
		    } finally {
		      pm.close();
		    }	
		}
	  
	  @Override
		public ArrayList<Bodega> cargarBodega(){
			PersistenceManager pm = getPersistenceManager();
			ArrayList<Bodega>un=new ArrayList<Bodega>();
			Bodega prod1=new Bodega("01","001","PSF");
			Bodega prod2=new Bodega("02","002","EX");		
						
			Bodega pro1= pm.getObjectById(Bodega.class, prod1.getCodigoBodega());
			if(prod1!=null){
				un.add(pro1);
			}			
			Bodega pro2= pm.getObjectById(Bodega.class, prod2.getCodigoBodega());
			if(prod2!=null){
				un.add(pro2);
			}				
			return un;
		}		  
	  
	  @Override
	  public Bodega buscarBodega(String codigo){
	  	PersistenceManager pm = getPersistenceManager();
	  	Bodega b = pm.getObjectById(Bodega.class, codigo);
	  	return b;
	  }	
	  
	  
	  @Override
	  public void modificarBodega(String codigo, String nombre,String  empresa) {
	  	// TODO Auto-generated method stub
	  	PersistenceManager pm = getPersistenceManager();    
	  	Bodega b = pm.getObjectById(Bodega.class, codigo);
	  	
	  	  if(b.getCodigoBodega().equalsIgnoreCase(codigo)){
	  		  pm.makePersistent(new Bodega(codigo,nombre,empresa)); 
	  	         }else{	        	
	  	           pm.close();
	  	         } 
	        }
	  
	  @Override
	  public void elminarBodega(String codigo){
			PersistenceManager pm = getPersistenceManager();
			Bodega b = pm.getObjectById(Bodega.class, codigo);
			pm.deletePersistent(b);
		}
	
}
