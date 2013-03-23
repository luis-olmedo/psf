package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.Date;


import com.google.gwt.sample.stockwatcher.server.Exixtencias;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExistenciaServiceAsync {	

	void getExistencia(AsyncCallback<ArrayList<Exixtencias>> callback);


	void buscarExistencia(String codigoProducto,
			AsyncCallback<ArrayList<Exixtencias>> callback);

	void addExistencia(String codigoBodega, ArrayList<String> codigoProducto,
			ArrayList<String> cantidad, ArrayList<Date> fecha,
			AsyncCallback<Void> callback);


}
