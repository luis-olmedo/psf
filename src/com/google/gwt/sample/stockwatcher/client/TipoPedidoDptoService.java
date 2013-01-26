package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.sample.stockwatcher.server.TipoPedidoDpto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("tipopedidodpto")
public interface TipoPedidoDptoService extends RemoteService {

	void addTipoPedidoDpto(String codigoPedido, String codigoDpto,
			String lugarPedido, String codigoEmpresa, int diasCubrimiento);

	TipoPedidoDpto buscarTipoPedidoDpto(String codigoPedido);

	void modificarTipoPedidoDpto(String codigoPedido, String codigoDpto,
			String lugarPedido, String codigoEmpresa, int diasCubrimiento);	

	void elminarTipoPedidoDpto(String codigoPedido);

}
