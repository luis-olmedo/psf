package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Date;

import javax.jdo.Extent;
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
		  public void addProductoPedido(String codigoPedido, ArrayList<String> producto,
					ArrayList<Double> cantidadProducto,
					ArrayList<Date> fechaCubrimiento, ArrayList<String> centro,
					ArrayList<String> observaciones, String departamento,
					ArrayList<Date> fePed){			  
				     PersistenceManager pm = getPersistenceManager();				
				try{					
					ProductoPedido pp=new ProductoPedido(codigoPedido, producto, cantidadProducto, fechaCubrimiento,centro,observaciones, departamento,fePed);					
					pm.makePersistent(pp);					
				}finally{					
					pm.close();
				}				    
			}
		
		  @Override
			public ArrayList<ProductoPedido> cargarProductoPedido(String codigoPedido){
				PersistenceManager pm = getPersistenceManager();
				ProductoPedido resultado=null,detached=null;
				ArrayList<ProductoPedido>un=new ArrayList<ProductoPedido>();
				Query q= pm.newQuery(ProductoPedido.class);	
				q.setFilter("codigoPedido==:codigoPedido ");
				q.setUnique(true);

				  try{						
					  resultado=(ProductoPedido)q.execute(codigoPedido);					 
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
			  public ProductoPedido buscarProductoPedido (String codigo){
			  	PersistenceManager pm = getPersistenceManager();
			  	ProductoPedido pp = pm.getObjectById( ProductoPedido.class, codigo);
			  	return pp;
			  }	

			 @Override
			 public void elminarProductoPedido(String codigo){
					PersistenceManager pm = getPersistenceManager();
					ProductoPedido c = pm.getObjectById(ProductoPedido.class, codigo);
					pm.deletePersistent(c);
				}

				@Override
				public void modificarProductoPedidos(String codigo, String nombre) {
					// TODO Auto-generated method stub
					PersistenceManager pm = getPersistenceManager();    
					ProductoPedido c = pm.getObjectById(ProductoPedido.class, codigo);

					  
						  pm.makePersistent(new CentroCostos(codigo,nombre)); 
					      
				      }

				@Override
				public ArrayList<ProductoPedido> cargarProducto() {
					// TODO Auto-generated method stub
					return null;
				}

					

				@Override
				public ArrayList<ProductoPedido> cargarProducto2(
						String codigoPedido,String fechaPedido) {
					PersistenceManager pm = getPersistenceManager();
					ProductoPedido resultado=null,detached=null;
					ArrayList<ProductoPedido>un=new ArrayList<ProductoPedido>();
					Query q= pm.newQuery(ProductoPedido.class);	
					q.setFilter("codigoPedido==:codigoPedido && fechaPedido==:fechaPedido");
					q.setUnique(true);	
					  try{						
						  resultado=(ProductoPedido)q.execute(codigoPedido,fechaPedido);					 
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
