package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.ProductoBase;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("producto")
public interface ProductoBaseService extends RemoteService{

	void addProductos(String codigoProducto, String descripcion,
			double cantidad, double precio, String idUnd);

	ArrayList<ProductoBase> cargarProducto();

	ProductoBase buscarProductoBase(String codigo);


	void elminarProductoBase(String codigo);

	void modificarProductoBase(String codigoProducto, String descripcion,
			double cantidad, double precio, String idUnd);

	
}
