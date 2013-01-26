package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.UndConsumo;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("und")
public interface UndConsumoService extends RemoteService{  
   public void elminarUndConsumo(String idUnd);  
   UndConsumo u(String codigo);    
   void addUndConsumjo(String idUnd, String nombreUnd);
    void modificarUndConsumo(String idUnd, String nombreUnd);
	ArrayList<UndConsumo> cargarUnd();
}
