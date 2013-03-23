package com.google.gwt.sample.stockwatcher.client;


import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.sample.stockwatcher.server.CentroCostos;
import com.google.gwt.sample.stockwatcher.server.ProductoBase;
import com.google.gwt.sample.stockwatcher.server.ProductoPedido;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProductoPedidoServiceAsync {	

	void buscarProductoPedido(String codigoPedido,
			AsyncCallback<ProductoPedido> callback);

	void elminarProductoPedido(String codigo, AsyncCallback<Void> callback);


	void modificarProductoPedidos(String codigo, String nombre,
			AsyncCallback<Void> callback);

	void cargarProducto(AsyncCallback<ArrayList<ProductoPedido>> callback);

	void cargarProductoPedido(String codigoPedido,
			AsyncCallback<ArrayList<ProductoPedido>> callback);	

	void cargarProducto2(String codigoPedido, String fechaPedido,
			AsyncCallback<ArrayList<ProductoPedido>> callback);

	void addProductoPedido(String codigoPedido, ArrayList<String> producto,
			ArrayList<Double> cantidadProducto,
			ArrayList<Date> fechaCubrimiento, ArrayList<String> centro,
			ArrayList<String> observaciones, String departamento,
			ArrayList<Date> fePed, AsyncCallback<Void> callback);



	



}
