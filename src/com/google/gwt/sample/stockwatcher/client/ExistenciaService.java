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

	void addExistencia(String codigoBodega, ArrayList<String> codigoProducto,
			ArrayList<String> cantidad, ArrayList<Date> fecha);

}
