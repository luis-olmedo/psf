package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.CentroCostos;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CentroCostoServiceAsync {

	void addCentroCostos(String codigoCostos, String nombreCostos,
			AsyncCallback<Void> callback);

	void modificarCentroCostos(String codigo, String nombre,
			AsyncCallback<Void> callback);

	void elminarCentroCostos(String codigo, AsyncCallback<Void> callback);

	void c(String codigo, AsyncCallback<CentroCostos> callback);

	void cargarCentroCostos(AsyncCallback<ArrayList<CentroCostos>> callback);

}
