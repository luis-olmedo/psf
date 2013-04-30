package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.stockwatcher.server.TipoUsuario;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


public class Mtipousuario implements EntryPoint {
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 

	  private final TipoUsuarioServiceAsync tipoService=GWT.create(TipoUsuarioService.class);
	  private Label tipolabel= new Label("Codigo: ");
	  private TextBox tipoBox= new TextBox();  
	  private Label usulabel= new Label("Tipo Usuario: ");
	  private TextBox usuBox= new TextBox();
	  private Button addTuBoton= new Button("Crear Tipo");  
	  private Button modificarTipoUsu=new Button("Modificar");
	  private Button eliminarTipoUsu=new Button("Eliminar");	   
	  private Button buscarTipo= new Button("Buscar");
	  
	@Override
	public void onModuleLoad() {	
		 tipoBox.addStyleName("tipoBox");
		 usuBox.addStyleName("usuBox");
		 addTuBoton.addStyleName("addTuBoton");
		 modificarTipoUsu.addStyleName("modificarTipoUsu");
		 eliminarTipoUsu.addStyleName("eliminarTipoUsu");
		 buscarTipo.addStyleName("buscarTipo");		 
		 addPanel1.add(tipolabel);
		 addPanel1.add(tipoBox);
		 addPanel2.add(usulabel);
		 addPanel2.add(usuBox);
		 addPanel3.add(addTuBoton);	
		 addPanel3.add(modificarTipoUsu);
		 addPanel3.add(eliminarTipoUsu);
		 addPanel3.add(buscarTipo);	
		 
		 RootPanel.get("tu").add(addPanel1);
		 RootPanel.get("tu1").add(addPanel2);
		 RootPanel.get("tu2").add(addPanel3);
		 
		 tipoBox.setFocus(true); 	 
		
		 addTuBoton.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				 addTipoUsuario();
			}
		});	
		 
		 eliminarTipoUsu.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				eliminarTipo();
			}
		});
		 
		 
		 modificarTipoUsu.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				modificarTipo();			
			}
		});
		 
		 
		 buscarTipo.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				buscarTipo();			
			}
		});
	 } 
	
	private void addTipoUsuario(){
		 final String tipo = tipoBox.getText().toUpperCase().trim();
		 final String tipousu=usuBox.getText().toUpperCase().trim();
		 tipoBox.setFocus(true);
		 if(!tipo.equalsIgnoreCase("") && !tipousu.equalsIgnoreCase("")){
			 Window.alert("Guardo satisfactoriamente ");       		 
		}else{    	
	    	Window.alert("Porfavor  llene los campos"); 
	    }	 
		   tipoBox.setText("");	
		   usuBox.setText("");    		
		   addTipoUsuario(tipo,tipousu);	
		 
	 }
	
	private void addTipoUsuario(final String tipo,final String tipousu){
    	tipoService.addTipoUsuario(tipo, tipousu, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				 Window.alert("No logro guardar ");
			}

			@Override
			public void onSuccess(Void result) {
				 Window.alert("Guardo satisfactoriamente ");
				
			}
	
    	});
    }

	 private  void buscarTipo (){
		 final String codigo=tipoBox.getText().toUpperCase().trim();
		 buscarTipo(codigo);
	 } 
	 private void buscarTipo (String codigo){
		 tipoService.t(codigo, new AsyncCallback<TipoUsuario>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub			
			}
			@Override
			public void onSuccess(TipoUsuario result) {
				// TODO Auto-generated method stub
				tipoBox.setText(result.getTipo());
				usuBox.setText(result.getNombreUsu());
			}		 
		});
		 }
	 
	 private  void eliminarTipo(){
		 final String tipo= tipoBox.getText().toUpperCase().trim();
		 eliminarTipo(tipo);	 
	 }
	 
	 private void eliminarTipo(String tipo){
		tipoService.elminarTipoUsuario(tipo,new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("No se pudo eliminar el Tipo de Usuario");
				}
			
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("Se elimino satisfactoriamente el Tipo de Usuario");	
			    tipoBox.setText("");
			    usuBox.setText("");
			}
		});
	 }
	 
	 private void modificarTipo(){	 
		 final String tipo= tipoBox.getText().toUpperCase().trim();
		 final String  usu =usuBox.getText().toUpperCase().trim();	 
		 modificarTipo(tipo,usu);
		 } 
	 private  void  modificarTipo(String tipo, String tipoUsu){
		 tipoService.modificarTipoUsuario(tipo, tipoUsu,new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("El Tipo de Usuario no se pudo modificar");			
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("El Tipo de Usuario se Modifico satisfactoriamente");			
			}
		});
		 
	 }

	}


