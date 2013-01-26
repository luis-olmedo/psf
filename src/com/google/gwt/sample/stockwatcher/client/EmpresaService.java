package com.google.gwt.sample.stockwatcher.client;
import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.Empresa;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("empresa")
public interface EmpresaService extends RemoteService {	
	String addEmpresa(String codigo, String nombre);
	public String consultarEmpresa(String codigo);
	public void  elminarEmpresa(String codigo);	
	void modificarEmpresa(String codigo, String nombre);
	Empresa e(String codigo);
	ArrayList<Empresa> cargarEmpresa();

	
	


}