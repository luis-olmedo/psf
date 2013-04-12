package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.Date;





import com.google.gwt.sample.stockwatcher.server.Exixtencias;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("existencia")
public interface ExistenciaService  extends RemoteService{	
	
	ArrayList<Exixtencias> getExistencia();

	ArrayList<Exixtencias> buscarExistencia(String codigoProducto);



	void elminarExistencia(String codigo);

	String consultarExistencia(String codigo);

	void addExistencia(String codigoBodega, ArrayList<String> codigoProducto,
			ArrayList<Double> cantidad, ArrayList<Date> fecha);

	ArrayList<Exixtencias> cargarExistenciass(String codigoBodega, Date fecha,
			String codigoProducto);

	ArrayList<Exixtencias> cargarExistenciassFecha(Date fecha);

	ArrayList<Exixtencias> cargarExistenciassProducto(String codigoProducto);

	ArrayList<Exixtencias> cargarExistenciassBodega(String codigoBodega);

}
