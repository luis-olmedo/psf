package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExistenciaServiceAsync {
	void addExistencia(String codigoBodega, ArrayList<String> codigoProducto,
			ArrayList<Date> fecha, ArrayList<String> cantidad,
			AsyncCallback<Void> callback);

}
