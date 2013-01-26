package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.Usuario;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UsuarioServiceAsync {	

	void modificarUsuario(String correo, String nombre, ArrayList<String> tipo,
			AsyncCallback<Void> callback);

	

	void elminarUsuario(String cuenta, AsyncCallback<Void> callback);

	void addUsuario(String correo, String nombre, ArrayList<String> tipo,
			AsyncCallback<Void> callback);



	void buscarUsuario(String correo, AsyncCallback<Usuario> callback);

}
