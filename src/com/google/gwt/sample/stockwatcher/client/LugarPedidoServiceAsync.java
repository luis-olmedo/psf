package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.LugarPedido;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LugarPedidoServiceAsync {

	void addLugarPedidos(String codLugar, String nomLugar,
			AsyncCallback<Void> callback);

	void modificarLugarPedido(String codDpto, String nomDpto,
			AsyncCallback<Void> callback);

	void elminarLugarPedido(String codLugar, AsyncCallback<Void> callback);

	void l(String codigo, AsyncCallback<LugarPedido> callback);

	void cargarLugarPedido(AsyncCallback<ArrayList<LugarPedido>> callback);

}
