package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.stockwatcher.server.LugarPedido;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


public class Mlugar implements EntryPoint {	  
	
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 	 	  
	  private Label codlugarlabel= new Label("Codigo: ");
	  private TextBox codlugarBox= new TextBox();  
	  private Label lugarlabel= new Label("Lugar: ");
	  private TextBox lugtarBox= new TextBox();
	  private Button crearlugarBoton= new Button("Crear");
	  private Button eliminarLugar= new Button("Eliminar");
	  private Button modificarLugar= new Button("Modificar");
	  private Button buscarLugar= new Button("Buscar"); 
	  private  final LugarPedidoServiceAsync lugarService=GWT.create(LugarPedidoService.class);
	  
	@Override
	public void onModuleLoad() {	
		 addPanel1.add(codlugarlabel);
		 addPanel1.add(codlugarBox);
		 addPanel2.add(lugarlabel);
		 addPanel2.add(lugtarBox);
		 addPanel3.add(crearlugarBoton);
		 addPanel3.add(eliminarLugar);
		 addPanel3.add(modificarLugar);
		 addPanel3.add(buscarLugar);
		 
		 RootPanel.get("lu").add(addPanel1);	
		 RootPanel.get("lu1").add(addPanel2);	
		 RootPanel.get("lu2").add(addPanel3);
		 
		 codlugarlabel.setStyleName("codlugarlabel");
		 codlugarBox.setStyleName("codlugarBox");
		 lugarlabel.setStyleName("lugarlabel");
		 lugtarBox.setStyleName("lugtarBox");
		 crearlugarBoton.setStyleName("crearlugarBoton");
		 eliminarLugar.setStyleName(" eliminarLugar");
		 modificarLugar.setStyleName("modificarLugar");
		 buscarLugar.setStyleName("buscarLugar");
		 
		 codlugarBox.setFocus(true);
			
		 crearlugarBoton.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {			
				
				addLugar();
			}
		});
		 eliminarLugar.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				eliminarLugar();
				
			}
		});
		 modificarLugar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				modificarLugar();
				
			}
		});
		 
		 buscarLugar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			     buscarLugar();	
			}
		});
		 
	 }
	 
	private void addLugar (){	 
		 final String codLugar =codlugarBox.getText().toUpperCase().trim();
		 final String nomLugar=lugtarBox.getText().toUpperCase().trim();
		 codlugarBox.setFocus(true);
		 if(!codLugar.equalsIgnoreCase("") && !nomLugar.equalsIgnoreCase("")){
			 addLugar(codLugar,nomLugar); 
		}else{    	
	    	Window.alert("Porfavor  llene los campos"); 
	    }
		 
	 }
	
	private  void addLugar (final String codLugar, final String nombLugar){
	       lugarService.addLugarPedidos(codLugar,nombLugar,new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no  se logro guardar");
			}

			@Override
			public void onSuccess(Void result) {				
				Window.alert("Se guardo Satisfactoriamente el Lugar");
				codlugarBox.setText("");	
				lugtarBox.setText("");  
			}
		});
	    }
	 private  void buscarLugar(){
		 final String codigo=codlugarBox.getText().toUpperCase().trim();	
		 buscarLugar(codigo);
	 }
	 private  void buscarLugar(String codigo){
		 lugarService.l(codigo, new AsyncCallback<LugarPedido>() {		 
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("No se  logro Encontrar el Lugar");
			}
			@Override
			public void onSuccess(LugarPedido result) {
				// TODO Auto-generated method stub
				codlugarBox.setText(result.getCodigoLugar());
			    lugtarBox.setText(result.getNombreLugar());			
			}		 
		});
	 }
	 private void eliminarLugar(){
		 final String codlugar=codlugarBox.getText().toUpperCase().trim();
		 eliminarLugar(codlugar);
	 }
	 private void eliminarLugar(String codlugar){
		 lugarService.elminarLugarPedido(codlugar, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se pudo eliminar");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se elimino satisfactoriemnte");	
				codlugarBox.setText("");
				lugtarBox.setText("");	
			}
		});
	 }
	 
	 private  void modificarLugar(){
		 final String codlugar=codlugarBox.getText().toUpperCase().trim();
		 final String lugar=lugtarBox.getText().toUpperCase().trim();
		 modificarLugar(codlugar,lugar);
		 
	 }
	 
	 private  void  modificarLugar(String codLugar,String lugar){
		 lugarService.modificarLugarPedido(codLugar, lugar, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se  pudo modificar");			
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se modifico satisfactoriamente");
				codlugarBox.setText("");
				lugtarBox.setText("");	
			}
			 
		});
	 } 
	}


