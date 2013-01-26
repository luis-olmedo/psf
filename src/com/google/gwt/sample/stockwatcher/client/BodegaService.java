package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.Bodega;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("bodega")

public interface BodegaService extends RemoteService {
	
	void addBodega(String codigo, String nombre, String codigoEmpresa);
	
	ArrayList<Bodega> cargarBodega();

	Bodega buscarBodega(String codigo);

	void modificarBodega(String codigo, String nombre, String empresa);

	void elminarBodega(String codigo);
}