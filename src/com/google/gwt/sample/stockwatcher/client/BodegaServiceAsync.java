package com.google.gwt.sample.stockwatcher.client;



import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.Bodega;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BodegaServiceAsync {	

	void addBodega(String codigo, String nombre, String codigoEmpresa,
			AsyncCallback<Void> callback);

	void cargarBodega(AsyncCallback<ArrayList<Bodega>> callback);

	void buscarBodega(String codigo, AsyncCallback<Bodega> callback);	

	void modificarBodega(String codigo, String nombre, String empresa,
			AsyncCallback<Void> callback);

	void elminarBodega(String codigo, AsyncCallback<Void> callback);
}

