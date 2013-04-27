package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.Date;


import com.google.gwt.sample.stockwatcher.server.Exixtencias;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExistenciaServiceAsync {	

	void getExistencia(AsyncCallback<ArrayList<Exixtencias>> callback);


	void buscarExistencia(String codigoProducto,
			AsyncCallback<ArrayList<Exixtencias>> callback);	


	void elminarExistencia(String codigo, AsyncCallback<Void> callback);


	void consultarExistencia(String codigo, AsyncCallback<String> callback);


	void addExistencia(String codigoBodega, ArrayList<String> codigoProducto,
			ArrayList<Double> cantidad, ArrayList<Date> fecha,
			AsyncCallback<Void> callback);


	void cargarExistenciass(String codigoBodega, Date fecha,
			String codigoProducto,
			AsyncCallback<ArrayList<Exixtencias>> callback);


	void cargarExistenciassBodega(String codigoBodega,
			AsyncCallback<ArrayList<Exixtencias>> callback);


	void cargarExistenciassFecha(Date fecha,
			AsyncCallback<ArrayList<Exixtencias>> callback);


	void cargarExistenciassProducto(String codigoProducto,
			AsyncCallback<ArrayList<Exixtencias>> callback);


	void maximafecha(String codigoBodega,
			AsyncCallback<ArrayList<Exixtencias>> callback);


}
