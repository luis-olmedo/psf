package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.CentroCostos;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("centros")
public interface CentroCostoService extends RemoteService{
	public void addCentroCostos (String codigoCostos, String nombreCostos);
	void modificarCentroCostos(String codigo, String nombre);
	public void  elminarCentroCostos(String codigo);
	CentroCostos c(String codigo);
	ArrayList<CentroCostos> cargarCentroCostos();
}
