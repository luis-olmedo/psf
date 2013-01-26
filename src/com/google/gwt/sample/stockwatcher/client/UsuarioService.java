package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.Usuario;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("usuario")
public interface UsuarioService extends RemoteService{



	void elminarUsuario(String correo);

	void addUsuario(String correo, String nombre, ArrayList<String> tipo);

	void modificarUsuario(String correo, String nombre, ArrayList<String> tipo);

	Usuario buscarUsuario(String correo);

}
