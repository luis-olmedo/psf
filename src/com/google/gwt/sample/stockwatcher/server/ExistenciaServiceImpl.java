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
		 @Override 
		  public void addExistencia(String codigoBodega, ArrayList<String> codigoProducto,
					ArrayList<Double> cantidad, ArrayList<Date> fecha){	
			  
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
		  
		  public void  elminarExistencia(String codigo){
				PersistenceManager pm = getPersistenceManager();
				Exixtencias e = pm.getObjectById(Exixtencias.class, codigo);
				pm.deletePersistent(e);
				return;	
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
		  @Override
		  public String consultarExistencia(String codigo){		
			  PersistenceManager pm = getPersistenceManager();
			  Exixtencias e = pm.getObjectById(Exixtencias.class, codigo);
			  return e.getCodigoBodega();
			  }
		  
		  @Override
			public ArrayList<Exixtencias> cargarExistenciass(String codigoBodega, Date fecha, String codigoProducto){
				PersistenceManager pm = getPersistenceManager();
				Exixtencias resultado=null,detached=null;
				ArrayList<Exixtencias>un=new ArrayList<Exixtencias>();
				Query q= pm.newQuery(Exixtencias.class);				
				q.setFilter("codigoBodega==:codigoBodega && fecha==:fecha && codigoProducto==:codigoProducto");				
				
				q.setUnique(true);
				  try{						
					  resultado=(Exixtencias)q.execute(codigoBodega,fecha,codigoProducto);					 
						  if(resultado!=null){								    
								  detached=pm.detachCopy(resultado);								  
								  un.add(detached);
								  }							 
				  }catch (Exception e){
					  e.printStackTrace();
				  }finally{
					  pm.close();
					  q.closeAll();
				  }
				  return un;
			}	
	
		  @Override
			public ArrayList<Exixtencias> cargarExistenciassBodega(String codigoBodega){
			  PersistenceManager pm = getPersistenceManager();
				Exixtencias resultado=null,detached=null;
				ArrayList<Exixtencias>un=new ArrayList<Exixtencias>();
		
				Query q= pm.newQuery(Exixtencias.class);					
				q.setFilter("codigoBodega==:codigoBodega");		
				q.setUnique(true);

				  try{						
					  resultado=(Exixtencias)q.execute(codigoBodega);					 
						  if(resultado!=null){								    
								  detached=pm.detachCopy(resultado);								  
								  un.add(detached);
								  }							 
				  }catch (Exception e){
					  e.printStackTrace();
				  }finally{
					  pm.close();
					  q.closeAll();
				  }
				  return un;
			}	
			
		  @Override
			public ArrayList<Exixtencias> cargarExistenciassFecha( Date fecha){
				PersistenceManager pm = getPersistenceManager();
				Exixtencias resultado=null,detached=null;
				ArrayList<Exixtencias>un=new ArrayList<Exixtencias>();
		
				Query q= pm.newQuery(Exixtencias.class);					
				q.setFilter("fecha==:fecha");					
				q.setUnique(true);

				  try{						
					  resultado=(Exixtencias)q.execute(fecha);					 
						  if(resultado!=null){								    
								  detached=pm.detachCopy(resultado);								  
								  un.add(detached);
								  }							 
				  }catch (Exception e){
					  e.printStackTrace();
				  }finally{
					  pm.close();
					  q.closeAll();
				  }
				  return un;
			}	
			
		  @Override
			public ArrayList<Exixtencias> cargarExistenciassProducto(String codigoProducto){
				PersistenceManager pm = getPersistenceManager();
				Exixtencias resultado=null,detached=null;
				ArrayList<Exixtencias>un=new ArrayList<Exixtencias>();
				Query q= pm.newQuery(Exixtencias.class);				
				q.setFilter("codigoProducto==:codigoProducto");	
				
				q.setUnique(true);
				  try{						
					  resultado=(Exixtencias)q.execute(codigoProducto);					 
						  if(resultado!=null){								    
								  detached=pm.detachCopy(resultado);								  
								  un.add(detached);
								  }							 
				  }catch (Exception e){
					  e.printStackTrace();
				  }finally{
					  pm.close();
					  q.closeAll();
				  }
				  return un;
			}
		  
		  
		  @Override
			public ArrayList<Exixtencias> maximafecha(String codigoBodega){
				PersistenceManager pm = getPersistenceManager();
				Exixtencias resultado=null,detached=null;
				ArrayList<Exixtencias>un=new ArrayList<Exixtencias>();
				Query q= pm.newQuery(Exixtencias.class);				
				q.setFilter("codigoBodega==:codigoBodega");				
				
				q.setUnique(true);
				  try{						
					  resultado=(Exixtencias)q.execute(codigoBodega);					 
						  if(resultado!=null){								    
								  detached=pm.detachCopy(resultado);								  
								  un.add(detached);
								  }							 
				  }catch (Exception e){
					  e.printStackTrace();
				  }finally{
					  pm.close();
					  q.closeAll();
				  }
				  return un;
			}
			
		  
		  
}

		  
		  
		
		




