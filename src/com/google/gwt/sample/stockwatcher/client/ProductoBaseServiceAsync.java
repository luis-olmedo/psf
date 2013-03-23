package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.ProductoBase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProductoBaseServiceAsync {

	void addProductos(String codigoProducto, String descripcion,
			double cantidad, double precio, String idUnd,
			AsyncCallback<Void> callback);

	void cargarProducto(AsyncCallback<ArrayList<ProductoBase>> callback);

	void buscarProductoBase(String codigo, AsyncCallback<ProductoBase> callback);

	void modificarProductoBase(String codigoProducto, String descripcion,
			double cantidad, double precio, String idUnd,
			AsyncCallback<Void> callback);

	void elminarProductoBase(String codigo, AsyncCallback<Void> callback);

	void cargarProductico(int k, String descripcion,
			AsyncCallback<ArrayList<ProductoBase>> callback);

}
