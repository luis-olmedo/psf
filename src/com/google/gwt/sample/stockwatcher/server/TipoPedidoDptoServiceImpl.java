package com.google.gwt.sample.stockwatcher.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import com.google.gwt.sample.stockwatcher.client.TipoPedidoDptoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TipoPedidoDptoServiceImpl extends RemoteServiceServlet implements TipoPedidoDptoService {
	private static final PersistenceManagerFactory PMF =
		      JDOHelper.getPersistenceManagerFactory("transactions-optional");
		  private PersistenceManager getPersistenceManager() {
			    return PMF.getPersistenceManager();
			  }
		  
		  @Override
		  public void addTipoPedidoDpto(String codigoPedido,String codigoDpto, String lugarPedido, String codigoEmpresa,int diasCubrimiento){		  
				PersistenceManager pm = getPersistenceManager();	
				
			    pm.makePersistent(new TipoPedidoDpto (codigoPedido,codigoDpto,lugarPedido,codigoEmpresa,diasCubrimiento));			        
			   
			}
		  
		  @Override
		  public TipoPedidoDpto buscarTipoPedidoDpto(String codigoPedido){
		  	PersistenceManager pm = getPersistenceManager();
		  	TipoPedidoDpto tpd = pm.getObjectById(TipoPedidoDpto.class, codigoPedido);
		  	return tpd;
		  }	
		  
		  
		  @Override
		  public void modificarTipoPedidoDpto(String codigoPedido,String codigoDpto, String lugarPedido, String codigoEmpresa,int diasCubrimiento) {
		  	// TODO Auto-generated method stub
		  	PersistenceManager pm = getPersistenceManager();    
		  	TipoPedidoDpto tpd = pm.getObjectById(TipoPedidoDpto.class, codigoPedido);
		  	
		  	  if(tpd.getCodigoPedido().equalsIgnoreCase(codigoPedido)){
		  		  pm.makePersistent(new TipoPedidoDpto(codigoPedido,codigoDpto,lugarPedido,codigoEmpresa,diasCubrimiento)); 
		  	         }else{	        	
		  	           pm.close();
		  	         } 
		        }
		  
		  @Override
		  public void elminarTipoPedidoDpto(String codigoPedido){
				PersistenceManager pm = getPersistenceManager();
				TipoPedidoDpto tpd = pm.getObjectById(TipoPedidoDpto.class, codigoPedido);
				pm.deletePersistent(tpd);
			}
}
