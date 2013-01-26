package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.Departamento;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dpto")
public interface DepartamentoService extends RemoteService {
	public  void addDepartamento (String codDpto, String nomDpto);
	void modificarDepartamento(String codDpto, String nomDpto);
	public void elminarDepartamento(String codDpto);
	Departamento d(String codigo);
	ArrayList<Departamento> cargarDepartamento();

}
