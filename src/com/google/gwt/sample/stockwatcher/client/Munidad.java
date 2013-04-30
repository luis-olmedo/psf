package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.stockwatcher.server.UndConsumo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


public class Munidad implements EntryPoint { 
	 
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 	 
	  private Label idundlabel= new Label("ID Unidad: ");
	  private TextBox idundBox= new TextBox();  
	  private Label unidadbel= new Label("Unidad Consumo: ");
	  private TextBox unidadBox= new TextBox();
	  private Button crearundBoton= new Button("Crear Unidad");
	  private Button eliminarUnd= new Button("Eliminar");
	  private Button modificarUnd= new Button("modificar");
	  private Button buscarUnd= new Button("Buscar");
	  private  final UndConsumoServiceAsync undService=GWT.create(UndConsumoService.class);
	  
	@Override
	public void onModuleLoad() {		 
		 addPanel1.add(idundlabel);
		 addPanel1.add(idundBox);
		 addPanel2.add(unidadbel);
		 addPanel2.add(unidadBox);
		 addPanel3.add(crearundBoton);
		 addPanel3.add(eliminarUnd);
		 addPanel3.add(modificarUnd);
		 addPanel3.add(buscarUnd);
		 
		 idundlabel.setStyleName("idundlabel");
		 idundBox.setStyleName("idundBox");
		 unidadbel.setStyleName("unidadbel");
		 unidadBox.setStyleName(" unidadBox");
		 crearundBoton.setStyleName(" crearundBoton");
		 eliminarUnd.setStyleName("eliminarUnd");
		 modificarUnd.setStyleName("modificarUnd");
		 buscarUnd.setStyleName(" buscarUnd");
		 
		 RootPanel.get("und").add(addPanel1);	
		 RootPanel.get("und1").add(addPanel2);	
		 RootPanel.get("und2").add(addPanel3);	
		 idundBox.setFocus(true);	
		 
		 
		
		 crearundBoton.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				addUnd();			
			}
		});
		 
		 eliminarUnd.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				eliminarUnd();
			}
		});
		 
		 modificarUnd.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				modificarUnd();
			}
		});
		 
		 buscarUnd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			    buscarUnd();		    
			}
		});
	 }
	 
	private void addUnd(){
		 final String idUnd=idundBox.getText().toUpperCase().trim();
		 final String nomUnd=unidadBox.getText().toUpperCase().trim();	 
		 idundBox.setFocus(true);
		 
		 if(!idUnd.equalsIgnoreCase("") && !nomUnd.equalsIgnoreCase("")){
			      		 
		}else{    	
	    	Window.alert("Porfavor  llene los campos"); 
	    }	 
		 idundBox.setText("");	
		 unidadBox.setText("");    		
		 addUnd(idUnd,nomUnd);
		 
	 }
	
	private  void addUnd (final String idUnd, final String nombreUnd){
    	undService.addUndConsumjo(idUnd, nombreUnd, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				 Window.alert("no  pudo ser almacenado "); 
			}

			@Override
			public void onSuccess(Void result) {
				 Window.alert("Guardo satisfactoriamente "); 
				
			}
		});
    	
    }
	 private  void buscarUnd(){
	    final  String id=idundBox.getText().toUpperCase().trim();
	    buscarUnd(id);
	 }
	 private  void  buscarUnd(String codigo){
		 undService.u(codigo,new AsyncCallback<UndConsumo>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub		
				Window.alert("No se  logro  Encontrar");
			}

			@Override
			public void onSuccess(UndConsumo result) {
				// TODO Auto-generated method stub			
				idundBox.setText(result.getIdUnd());
				unidadBox.setText(result.getNombreUnd());
				
			}
		});
		 
	 }
	 private  void  eliminarUnd(){
		 final  String id=idundBox.getText().toUpperCase().trim();
		 eliminarUnd(id);
	 }
	 
	 private  void eliminarUnd(String id){
		 
		 undService.elminarUndConsumo(id,new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se pudo eliminar");
			}
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se elimino satisfactoriamente");
				idundBox.setText("");
				unidadBox.setText("");			
			}
		});
	 }
	 
	 private void modificarUnd (){
		 final  String id=idundBox.getText().toUpperCase().trim();
		 final  String und=unidadBox.getText().toUpperCase().trim();
		 modificarUnd(id,und);
	 }
	 
	 private  void modificarUnd(String id,String und){
		 undService.modificarUndConsumo(id, und, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se pudo modificar");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se  modifico satisfactoriamente");
				idundBox.setText("");
				unidadBox.setText("");	
			}
		});
	 }
	 
	 
	}


