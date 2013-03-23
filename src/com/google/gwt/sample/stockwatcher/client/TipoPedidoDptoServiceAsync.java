package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.sample.stockwatcher.server.TipoPedidoDpto;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TipoPedidoDptoServiceAsync {

	void addTipoPedidoDpto(String codigoPedido, String codigoDpto,
			String lugarPedido, String codigoEmpresa, int diasCubrimiento,
			AsyncCallback<Void> callback);

	void buscarTipoPedidoDpto(String codigoPedido,
			AsyncCallback<TipoPedidoDpto> callback);

	void modificarTipoPedidoDpto(String codigoPedido, String codigoDpto,
			String lugarPedido, String codigoEmpresa, int diasCubrimiento,
			AsyncCallback<Void> callback);

	void elminarTipoPedidoDpto(String codigoPedido, AsyncCallback<Void> callback);

	void cargartpd(AsyncCallback<ArrayList<TipoPedidoDpto>> callback);

}
