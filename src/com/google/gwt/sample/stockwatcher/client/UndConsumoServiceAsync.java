package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.UndConsumo;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UndConsumoServiceAsync {
	void addUndConsumjo(String idUnd, String nombreUnd,
			AsyncCallback<Void> callback);

	void elminarUndConsumo(String idUnd, AsyncCallback<Void> callback);

	void modificarUndConsumo(String idUnd, String nombreUnd,
			AsyncCallback<Void> callback);

	void u(String codigo, AsyncCallback<UndConsumo> callback);

	void cargarUnd(AsyncCallback<ArrayList<UndConsumo>> callback);

}
