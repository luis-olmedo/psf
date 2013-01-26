package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.sample.stockwatcher.server.CentroCostos;
import com.google.gwt.sample.stockwatcher.server.ProductoBase;
import com.google.gwt.sample.stockwatcher.server.ProductoPedido;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("pp")
public interface ProductoPedidoService extends RemoteService{	

	ProductoPedido buscarProductoPedido(String codigoPedido);

	ProductoPedido getProductoPedido(String codigoPedido);

	void elminarProductoPedido(String codigo);

	void modificarProductoPedidos(String codigo, String nombre);

	ArrayList<ProductoPedido> cargarProductoPedido(String codigoPedido);	

		void addProductoPedido(String codigoPedido, ArrayList<String> producto,
				ArrayList<Double> cantidadProducto,
				ArrayList<Date> fechaCubrimiento, ArrayList<String> centro,
				ArrayList<String> observaciones);


}