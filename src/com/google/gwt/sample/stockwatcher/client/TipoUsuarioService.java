package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.TipoUsuario;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("tipousuario")
public interface TipoUsuarioService extends RemoteService{
	public void addTipoUsuario(String tipo,String tipoUsu);
	public void elminarTipoUsuario(String tipo);
	void modificarTipoUsuario(String tipo, String tipoUsu);
	TipoUsuario t(String codigo);
	ArrayList<TipoUsuario> cargarTipo();

}
