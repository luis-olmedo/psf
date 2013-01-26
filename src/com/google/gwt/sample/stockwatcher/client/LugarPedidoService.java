package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.LugarPedido;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("lugar")
public interface LugarPedidoService extends RemoteService{
   public void addLugarPedidos (String codLugar, String nomLugar);
   public void elminarLugarPedido(String codLugar);
   void modificarLugarPedido(String codDpto, String nomDpto);
   LugarPedido l(String codigo);
ArrayList<LugarPedido> cargarLugarPedido();
}
