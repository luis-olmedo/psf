package com.google.gwt.sample.stockwatcher.client;





import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.Empresa;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmpresaServiceAsync {	
	 void addEmpresa(String codigo, String nombre, AsyncCallback<String> async);

	void consultarEmpresa(String codigo, AsyncCallback<String> callback);

	void elminarEmpresa(String codigo, AsyncCallback<Void> callback);

	void modificarEmpresa(String codigo, String nombre,
			AsyncCallback<Void> callback);

	void e(String codigo, AsyncCallback<Empresa> callback);

	void cargarEmpresa(AsyncCallback<ArrayList<Empresa>> callback);

	void listTodos(AsyncCallback<ArrayList<Empresa>> callback);


	



	
	

	 

	
	
	

	
}
