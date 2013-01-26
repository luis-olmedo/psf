package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.google.gwt.sample.stockwatcher.client.CentroCostoService;
import com.google.gwt.sample.stockwatcher.client.ProductoBaseService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ProductoBaseServiceImpl extends RemoteServiceServlet implements ProductoBaseService{
	private static final Logger LOG = Logger.getLogger(CentroCostoService.class.getName());
	  private static final PersistenceManagerFactory PMF =
	      JDOHelper.getPersistenceManagerFactory("transactions-optional");

	  
	  private PersistenceManager getPersistenceManager() {
	    return PMF.getPersistenceManager();
	  }
		@Override
		public void addProductos(String codigoProducto, String  descripcion, double cantidad, double precio,String idUnd) {			
			PersistenceManager pm = getPersistenceManager();
			UndConsumo u= pm.getObjectById(UndConsumo.class, idUnd);
		    try {
		    	if (u!=null){
		    	     pm.makePersistent(new ProductoBase(codigoProducto,descripcion,cantidad,precio,idUnd));
		    	}   		 
		    } finally {
		      pm.close();
		    }		
		}
		
		@Override
		public ArrayList<ProductoBase> cargarProducto(){
			PersistenceManager pm = getPersistenceManager();
			ArrayList<ProductoBase>un=new ArrayList<ProductoBase>();
			ProductoBase prod1=new ProductoBase("024","GASOLINA",5000,8000,"UND");
			ProductoBase prod2=new ProductoBase("025","ACP",1000,5000,"LIT");
			ProductoBase prod3=new ProductoBase("026","agua",1000,5000,"LIT");
						
			ProductoBase pro1= pm.getObjectById(ProductoBase.class, prod1.getCodigoProducto());
			if(prod1!=null){
				
					un.add(pro1);			
			
			}
			ProductoBase pro2= pm.getObjectById(ProductoBase.class, prod2.getCodigoProducto());
			if(prod2!=null){				
					un.add(pro2);				
			}			
			
			ProductoBase pro3= pm.getObjectById(ProductoBase.class, prod3.getCodigoProducto());
			if(prod3!=null){				
					un.add(pro3);				
			}		
			return un;

		}
		
		 @Override
		  public ProductoBase buscarProductoBase (String codigo){
		  	PersistenceManager pm = getPersistenceManager();
		  	ProductoBase pb = pm.getObjectById(ProductoBase.class, codigo);
		  	return pb;
		  }	
		 
		 
		 @Override
		  public void modificarProductoBase(String codigoProducto, String  descripcion, double cantidad, double precio,String idUnd) {
		  	// TODO Auto-generated method stub
		  	PersistenceManager pm = getPersistenceManager();    
		  	ProductoBase pb = pm.getObjectById(ProductoBase.class, codigoProducto);
		  	
		  	  if(pb.getCodigoProducto().equalsIgnoreCase(codigoProducto)){
		  		  pm.makePersistent(new ProductoBase(codigoProducto, descripcion, cantidad, precio, idUnd)); 
		  	         }else{	        	
		  	           pm.close();
		  	         } 
		        }		 
		 
		 @Override
		  public void elminarProductoBase(String codigo){
				PersistenceManager pm = getPersistenceManager();
				ProductoBase pb = pm.getObjectById(ProductoBase.class, codigo);
				pm.deletePersistent(pb);
			}
		
		
	
}
