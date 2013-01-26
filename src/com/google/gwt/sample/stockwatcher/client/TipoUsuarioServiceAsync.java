package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.TipoUsuario;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TipoUsuarioServiceAsync {
	void addTipoUsuario(String tipo, String tipoUsu,
			AsyncCallback<Void> callback);

	void modificarTipoUsuario(String tipo, String tipoUsu,
			AsyncCallback<Void> callback);

	void elminarTipoUsuario(String tipo, AsyncCallback<Void> callback);

	void t(String codigo, AsyncCallback<TipoUsuario> callback);

	void cargarTipo(AsyncCallback<ArrayList<TipoUsuario>> callback);

}
