package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.stockwatcher.server.Departamento;
import com.google.gwt.sample.stockwatcher.server.Empresa;
import com.google.gwt.sample.stockwatcher.server.LugarPedido;
import com.google.gwt.sample.stockwatcher.server.TipoPedidoDpto;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;


public class Mtiopopedido implements EntryPoint {	
	  
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 
	  private HorizontalPanel addPanel4 = new HorizontalPanel(); 	
	
	  private final TipoPedidoDptoServiceAsync tipoPedidoService=GWT.create(TipoPedidoDptoService.class);	 
	  private final EmpresaServiceAsync empresaService = GWT.create(EmpresaService.class);	  
	  private final DepartamentoServiceAsync dptoService=GWT.create(DepartamentoService.class);
	  private  final LugarPedidoServiceAsync lugarService=GWT.create(LugarPedidoService.class);
	  
	  private Label pedidos= new Label("Pedidos ");
	  MultiWordSuggestOracle p = new MultiWordSuggestOracle ();  
	  private SuggestBox BoxlistPedidos= new SuggestBox(p) ;
	  private Label lugar= new Label("Lugar Pedido: ");
	  private ListBox BoxlistLugar= new ListBox();
	  private Label dpto= new Label("Departamentos: ");
	  private ListBox BoxlistDpto= new ListBox();
	  private Label empresas= new Label("Empresa ");
	  private ListBox BoxlistEmpresas= new ListBox();
	  private Label cubrimiento= new Label("Dias  de  Cubrimiento: ");
	  private  TextBox BoxCubrimiento= new TextBox();
	  private Button crearTipoPedidoBoton= new Button("Crear");
	  private Button eliminarTipoPedido= new Button("Eliminar");
	  private Button modificarTipoPedido= new Button("Modificar");
	  private Button buscarTipoPedido= new Button("Buscar");
	@Override
	public void onModuleLoad() {
		
		  addPanel1.add(pedidos);
		  addPanel1.add(BoxlistPedidos);
		  addPanel1.add(lugar);
		  addPanel1.add(BoxlistLugar);
		  addPanel2.add(dpto);
		  addPanel2.add(BoxlistDpto);
		  addPanel2.add(empresas);
		  addPanel2.add(BoxlistEmpresas);
		  addPanel3.add(cubrimiento);
		  addPanel3.add(BoxCubrimiento);
		  addPanel4.add(eliminarTipoPedido);
		  addPanel4.add(crearTipoPedidoBoton);
		  addPanel4.add(modificarTipoPedido);
		  addPanel4.add(buscarTipoPedido); 
		  
		  
		  pedidos.setStyleName("pedidos");
		  BoxlistPedidos.setStyleName("BoxlistPedidos");
		  lugar.setStyleName("lugar");
		  BoxlistLugar.setStyleName("BoxlistLugar");
		  dpto.setStyleName("dpto");
		  BoxlistDpto.setStyleName("BoxlistDpto");
		  empresas.setStyleName("empresas");
		  BoxlistEmpresas.setStyleName(" BoxlistEmpresas");
		  cubrimiento.setStyleName("cubrimiento");
		  BoxCubrimiento.setStyleName("BoxCubrimiento");
		  eliminarTipoPedido.setStyleName("eliminarTipoPedido");
		  crearTipoPedidoBoton.setStyleName("crearTipoPedidoBoton");
		  modificarTipoPedido.setStyleName("modificarTipoPedido");
		  buscarTipoPedido.setStyleName("buscarTipoPedido");
		  
		 		  
		  RootPanel.get("tp").add(addPanel1);
		  RootPanel.get("tp1").add(addPanel2);
		  RootPanel.get("tp2").add(addPanel3);
		  RootPanel.get("tp3").add(addPanel4);
		  cargarDepartamento();
		  cargarEmpresa();
		  cargarLugar();	  
		  
		  crearTipoPedidoBoton.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				crearTipoPedido();
			}
		});
		  modificarTipoPedido.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				modificarTipoPedido();
			}
		});
		  eliminarTipoPedido.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				eliminarTipoPedido();
			}
		});
		  
		  buscarTipoPedido.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				buscarTipoPedido();
			}
		});
		  
	  }
	  private  void buscarTipoPedido(){
		  String codigoPedido=BoxlistPedidos.getText().toUpperCase().trim();
		  buscarTipoPedido(codigoPedido);
		  
	  }
	  private  void buscarTipoPedido(String codigoPedido){
		  tipoPedidoService.buscarTipoPedidoDpto(codigoPedido,new AsyncCallback<TipoPedidoDpto>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se encontro ");
			}

			@Override
			public void onSuccess(TipoPedidoDpto result) {
				// TODO Auto-generated method stub
				BoxlistLugar.setItemText(0, result.getLugarPedido());
				BoxlistEmpresas.setItemText(0, result.getCodigoEmpresa());
				BoxlistDpto.setItemText(0, result.getCodigoDpto());
				BoxCubrimiento.setText(result.getDiasCubrimiento()+"");
				
				
			}
		});
		  
	  }
	  private  void eliminarTipoPedido(){
		  String codigoPedido=BoxlistPedidos.getText().toUpperCase().trim();
		  eliminarTipoPedido(codigoPedido);
	  }
	  
	  private  void eliminarTipoPedido(String codigoPedido){
		  tipoPedidoService.elminarTipoPedidoDpto(codigoPedido, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught){
				// TODO Auto-generated method stub
				Window.alert("no se elimino");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se elimino con exito");
				BoxlistPedidos.setText("");
				BoxCubrimiento.setText("");
			}
			  
		});
	  }
	  private  void modificarTipoPedido(){
		  String codigoPedido=BoxlistPedidos.getText().toUpperCase().trim();
		  final int i=BoxlistLugar.getSelectedIndex();
		  final String lugarPedido=BoxlistLugar.getItemText(i);
		  final int j=BoxlistDpto.getSelectedIndex();
		  final String deptoPedido=BoxlistDpto.getItemText(j);
		  final int k=BoxlistEmpresas.getSelectedIndex();
		  final String empresaPedido=BoxlistEmpresas.getItemText(k);
		  final String cu=BoxCubrimiento.getText().toUpperCase().trim();
		  int  cubrimiento=Integer.parseInt(cu);	  
		  modificarTipoPedido(codigoPedido,lugarPedido,deptoPedido,empresaPedido,cubrimiento);
	  }
	    
	  private void modificarTipoPedido(String codigoPedido,String lugarPedido,String deptoPedido,String empresaPedido,int cubrimiento){
		  tipoPedidoService.modificarTipoPedidoDpto(codigoPedido, deptoPedido, lugarPedido, empresaPedido, cubrimiento, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se  logroo modificar hubo  un error  con los  datos");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("modificado satisfactoriamente el tipo de  pedido");
			}
		});
		  
	  }
	  
	  private  void crearTipoPedido(){	  
		  String codigoPedido=BoxlistPedidos.getText().toUpperCase().trim();
		  final int i=BoxlistLugar.getSelectedIndex();
		  final String lugarPedido=BoxlistLugar.getItemText(i);
		  final int j=BoxlistDpto.getSelectedIndex();
		  final String deptoPedido=BoxlistDpto.getItemText(j);
		  final int k=BoxlistEmpresas.getSelectedIndex();
		  final String empresaPedido=BoxlistEmpresas.getItemText(k);
		  final String cu=BoxCubrimiento.getText().toUpperCase().trim();
		  int  cubrimiento=Integer.parseInt(cu);	  
		  crearTipoPedido(codigoPedido,lugarPedido,deptoPedido,empresaPedido,cubrimiento);
	  }
	    
	  private  void crearTipoPedido(String codigoPedido,String lugarPedido,String deptoPedido,String empresaPedido,int cubrimiento){
		  tipoPedidoService.addTipoPedidoDpto(codigoPedido, deptoPedido, lugarPedido, empresaPedido, cubrimiento, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se pudo guardar hubo  error");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("guardo tipo pedido der  manera Satisfactoria");
				BoxlistPedidos.setText("");
				BoxCubrimiento.setText("");
				
			}
		});
	  }
	  

	  private  void cargarLugar(){
		  lugarService.cargarLugarPedido(new AsyncCallback<ArrayList<LugarPedido>>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("error  al cargar la  lista del lugar");
			}

			@Override
			public void onSuccess(ArrayList<LugarPedido> result) {
				// TODO Auto-generated method stub
				displayLugar(result);
			}
			  
		});
	  }
	  private  void  displayLugar(List<LugarPedido>lug){
			for (LugarPedido l:lug){			   
				BoxlistLugar.addItem(l.getNombreLugar());		
			}  		
		  }
	  
	  private  void cargarEmpresa(){
		  empresaService.cargarEmpresa(new AsyncCallback<ArrayList<Empresa>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no  logro cargar la lista de empresa");
			}

			@Override
			public void onSuccess(ArrayList<Empresa> result) {			
				displayEmpresa(result);
			}
			  
		});
	  }
	  
	  private  void  displayEmpresa(List<Empresa>emp){
			for (Empresa e:emp){			   
				BoxlistEmpresas.addItem(e.getCodigoEmpresa());			
			}  		
		  }
	  private  void cargarDepartamento(){
		  dptoService.cargarDepartamento(new AsyncCallback<ArrayList<Departamento>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("error  al cargar lista de departamento ");
			}
			
			@Override
			public void onSuccess(ArrayList<Departamento> result) {
				// TODO Auto-generated method stub
				displayDpto(result);
			}
		});
		  
	  }
	  private  void  displayDpto(List<Departamento>dpto){
			for (Departamento d:dpto){			   
				BoxlistDpto.addItem(d.getNomDpto());			
			}  		
		  }

	}


