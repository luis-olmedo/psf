package com.google.gwt.sample.stockwatcher.server;


import java.util.ArrayList;

import java.util.Date;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import com.google.gwt.sample.stockwatcher.client.ProductoPedidoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ProductoPedidoServiceImpl  extends RemoteServiceServlet implements ProductoPedidoService{
	 
	private static final PersistenceManagerFactory PMF =
		      JDOHelper.getPersistenceManagerFactory("transactions-optional");
		  private PersistenceManager getPersistenceManager() {
			    return PMF.getPersistenceManager();
			  } 		
		  @Override		  
		  public void addProductoPedido(String codigoPedido,ArrayList<String> producto,ArrayList<Double> cantidadProducto,
				  ArrayList<Date> fechaCubrimiento, ArrayList<String> centro,
					ArrayList<String> observaciones){
			  
				PersistenceManager pm = getPersistenceManager();
				
				try{			
					ProductoPedido pp=new ProductoPedido(codigoPedido,producto,cantidadProducto,fechaCubrimiento,centro,observaciones);					
					pm.makePersistent(pp);			  
				
				}finally{					
					pm.close();
				}				    
			}	
		  
		  @Override
			public ArrayList<ProductoPedido> cargarProductoPedido(String producto){
				PersistenceManager pm = getPersistenceManager();
				ProductoPedido resultado=null,detached=null;
				ArrayList<ProductoPedido>un=new ArrayList<ProductoPedido>();
				Query q= pm.newQuery(ProductoPedido.class);	
				q.setFilter("producto==:producto");
				q.setUnique(true);	
				
				  try{						
					  resultado=(ProductoPedido)q.execute(producto);					 
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
             public ProductoPedido getProductoPedido(String producto){
			  PersistenceManager pm = getPersistenceManager();			  
			  ProductoPedido resultado=null,detached=null;
			  Query q= pm.newQuery(ProductoPedido.class);	
			  q.setFilter("producto==:producto");
			  q.setUnique(true);
			  try{				
				  resultado=(ProductoPedido)q.execute(producto);
				  if(resultado!=null){
					  detached=pm.detachCopy(resultado);					  
				  }
			  }catch (Exception e){
				  e.printStackTrace();
			  }finally{
				  pm.close();
				  q.closeAll();
			  }
			  return detached;
		  }
 
			 @Override
			  public ProductoPedido buscarProductoPedido (String codigo){
			  	PersistenceManager pm = getPersistenceManager();
			  	ProductoPedido pp = pm.getObjectById( ProductoPedido.class, codigo);
			  	return pp;
			  }	
			 
			 @Override
			 public void elminarProductoPedido(String codigo){
					PersistenceManager pm = getPersistenceManager();
					CentroCostos c = pm.getObjectById(CentroCostos.class, codigo);
					pm.deletePersistent(c);
				}

				@Override
				public void modificarProductoPedidos(String codigo, String nombre) {
					// TODO Auto-generated method stub
					PersistenceManager pm = getPersistenceManager();    
					CentroCostos c = pm.getObjectById(CentroCostos.class, codigo);
					
					  if(c.getCodigoCosto().equalsIgnoreCase(codigo)){
						  pm.makePersistent(new CentroCostos(codigo,nombre)); 
					         }else{	        	
					           pm.close();
					         } 
				      }
			

	

}
