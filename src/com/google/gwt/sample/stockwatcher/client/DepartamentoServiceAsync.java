package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.Departamento;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DepartamentoServiceAsync {

	void addDepartamento(String codDpto, String nomDpto,
			AsyncCallback<Void> callback);

	void modificarDepartamento(String codDpto, String nomDpto,
			AsyncCallback<Void> callback);
	void elminarDepartamento(String codDpto, AsyncCallback<Void> callback);

	void d(String codigo, AsyncCallback<Departamento> callback);

	void cargarDepartamento(AsyncCallback<ArrayList<Departamento>> callback);

}
