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
import com.google.gwt.sample.stockwatcher.client.LugarPedidoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LugarPedidoServiceImpl extends RemoteServiceServlet implements LugarPedidoService{

	  private static final Logger LOG = Logger.getLogger(CentroCostoService.class.getName());
	  private static final PersistenceManagerFactory PMF =
	      JDOHelper.getPersistenceManagerFactory("transactions-optional");	  
	  private PersistenceManager getPersistenceManager() {
	    return PMF.getPersistenceManager();
	  }

	@Override
	public void addLugarPedidos(String codLugar, String nomLugar) {
		
		PersistenceManager pm = getPersistenceManager();
	    try {
	      pm.makePersistent(new LugarPedido(codLugar,nomLugar));
	    } finally {
	      pm.close();
	    }
		}	
	
	public void elminarLugarPedido(String codLugar){
		PersistenceManager pm = getPersistenceManager();
		LugarPedido l= pm.getObjectById(LugarPedido.class, codLugar );
		pm.deletePersistent(l);
	}
	
	@Override
	public void modificarLugarPedido(String codDpto, String nomDpto) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();    
		Departamento d = pm.getObjectById(Departamento.class, codDpto);
		
		  if(d.getCodDpto().equalsIgnoreCase(codDpto)){
			  pm.makePersistent(new Departamento(codDpto, nomDpto)); 
		         }else{	        	
		           pm.close();
		         } 
	      }
	
	
	@Override
	public LugarPedido l(String codigo){
		PersistenceManager pm = getPersistenceManager();
		LugarPedido l = pm.getObjectById(LugarPedido.class, codigo);
		return l;
		
	}

	@Override
	public ArrayList<LugarPedido> cargarLugarPedido(){
		PersistenceManager pm = getPersistenceManager();
		LugarPedido a=null;
		ArrayList<LugarPedido>aa= new ArrayList<LugarPedido>();
		Extent extent = pm.getExtent(LugarPedido.class, false);
		Iterator it = extent.iterator();
		while(it.hasNext()) {
			 a = (LugarPedido) it.next();
			 aa.add(a);
			 }
		extent.closeAll();
		pm.close(); 
		return aa;

	}
	
}
