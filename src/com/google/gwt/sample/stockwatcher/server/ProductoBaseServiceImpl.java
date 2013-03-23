package com.google.gwt.sample.stockwatcher.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

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
			ProductoBase a=null;
			ArrayList<ProductoBase>aa= new ArrayList<ProductoBase>();
			Extent extent = pm.getExtent(ProductoBase.class, false);
			Iterator it = extent.iterator();
			while(it.hasNext()) {
				 a = (ProductoBase) it.next();
				 aa.add(a);
				 }
			extent.closeAll();
			pm.close(); 
			return aa;

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
		 
		 @Override
		 public ArrayList<ProductoBase>cargarProductico(int k,String descripcion){
				PersistenceManager pm = getPersistenceManager();
				ProductoBase resultado=null,detached=null;
				ArrayList<ProductoBase>un=new ArrayList<ProductoBase>();
				Query q= pm.newQuery(ProductoBase.class);	
				q.setFilter("descripcion==:descripcion");
				q.setUnique(true);
				  try{						
					  resultado=(ProductoBase)q.execute(descripcion);					 
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
