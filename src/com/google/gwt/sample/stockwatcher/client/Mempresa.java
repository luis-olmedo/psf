package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.stockwatcher.server.Empresa;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


public class Mempresa implements EntryPoint {
	
	 
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 
	  private HorizontalPanel addPanel4 = new HorizontalPanel(); 	  
	  private final EmpresaServiceAsync empresaService = GWT.create(EmpresaService.class);	 
	  private Label codigolabel= new Label("Codigo: ");
	  private TextBox codigoBox= new TextBox();
	  private Label nombrelabel= new Label("Empresa: ");
	  private TextBox nombreBox= new TextBox();
	  private Button eliminarBoton= new Button("Eliminar");
	  private Button modificarEmpresa = new Button("modificar");
	  private Button todaEmpresa = new Button("Traer Empresas");
	  private Button busBoton = new Button("Buscar");
	  private Button crearButon= new Button ("Crear"); 
	  
	@Override
	public void onModuleLoad() {
		  
		  addPanel1.add(codigolabel);
		  addPanel1.add(codigoBox);
		  addPanel3.add(crearButon);
		  addPanel3.add(busBoton);
		  addPanel2.add(nombrelabel);
		  addPanel2.add(nombreBox);		 
		  addPanel3.add(eliminarBoton);
		  addPanel3.add(modificarEmpresa);			
		  addPanel4.add(todaEmpresa);		
		  
		  RootPanel.get("em").add( addPanel1);
		  RootPanel.get("em1").add( addPanel2);
		  RootPanel.get("em2").add( addPanel3);
		  RootPanel.get("em3").add( addPanel4);
		  
		  codigolabel.setStyleName("codigolabel");
		  codigoBox.setStyleName("codigoBox");
		  crearButon.setStyleName("crearButon");
		  busBoton.setStyleName("busBoton");
		  nombrelabel.setStyleName("nombrelabel");
		  nombreBox.setStyleName("nombreBox");
		  eliminarBoton.setStyleName("eliminarBoton");
		  modificarEmpresa.setStyleName("modificarEmpresa");
		  todaEmpresa.setStyleName("todaEmpresa");
		  
		  codigoBox.setFocus(true);	  
		 
		  crearButon.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				addCrear();	
			
			}
		});	  
		  busBoton.addClickHandler(new ClickHandler() {			 
				@Override
				public void onClick(ClickEvent event) {			
				
				mostrar();			
					
					
				}
			});
		  
		  
		
		  eliminarBoton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
		      
				eliminarEmpresa();
				
				
			}
		});	
		  		  
		  modificarEmpresa.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				modificarEmpresa();				
			}
		});
		  
		  todaEmpresa.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {			
			 todasEmpresas();
			}
		});

	}
	
	private  void mostrar(){
		  final String codigo= codigoBox.getText().toUpperCase().trim();
		  mostrar(codigo);  
	  }
	  
	  private  void mostrar(String codigo){
		  empresaService.e(codigo,new AsyncCallback<Empresa>() {		
			@Override
			public void onSuccess(Empresa result) {
				// TODO Auto-generated method stub			
				codigoBox.setText(result.getCodigoEmpresa());
				nombreBox.setText(result.getNombre());
			}		
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub			
			}
		});
	  }
	  
	  
	private  void  todasEmpresas(){
    	empresaService.listTodos( new AsyncCallback<ArrayList<Empresa>>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no  funciono");
			}
			@Override
			public void onSuccess(ArrayList<Empresa> result) {
				// TODO Auto-generated method stub
				Window.alert("funciono"+result.toString());
			}    		
		});
    }
	private  void modificarEmpresa(){
		  final String codigo= codigoBox.getText().toUpperCase().trim();
		  final String nombre= nombreBox.getText().toUpperCase().trim();
		  
		  modificarEmpresa(codigo,nombre);
	  }
	
	  private  void  modificarEmpresa(String codigo, String nombre){
		  empresaService.modificarEmpresa(codigo, nombre,new AsyncCallback<Void>() {
			  
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se  pudo modificar  ya que no existe");
				codigoBox.setText("");
				nombreBox.setText("");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se modifico  correctamente");
				
			}
		});
		  
	  }
	private void addCrear(){
    	final String codigo= codigoBox.getText().toUpperCase().trim();
    	final String nombre= nombreBox.getText().toUpperCase().trim();
    	codigoBox.setFocus(true);  	
    	
    	if(!codigo.equalsIgnoreCase("") && !nombre.equalsIgnoreCase("")){
    		 addCrear(codigo,nombre); 
    	}else{
        	
        	Window.alert("Porfavor  llene los campos"); 
        }          		
    	
    }
	
	private void addCrear(final String codigo, final String nombre) {
	    empresaService.addEmpresa(codigo, nombre, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				 Window.alert("NO  SE LOGRO  GUARDAR LA EMPRESA");
			}

			@Override
			public void onSuccess(String result) {
				Window.alert("LA  EMPRESA: "+ result+"  HA  SIDO  ALMACENADA  CON EXITO");
				  codigoBox.setText("");	
		    	  nombreBox.setText("");  
			}
	    	
		});
	      }
	
	private void eliminarEmpresa (){
    	final String codigo= codigoBox.getText().toUpperCase().trim();
    	eliminarEmpresa(codigo);
    }
	
    private void eliminarEmpresa(String codigo){
    	empresaService.elminarEmpresa(codigo,new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				codigoBox.setText("");
				Window.alert("**** La empresa que usted  desea no se pudo  eliminar  debe  ser que no  exista o  su codigo  este mal ****");		
			}
			
			@Override
			public void onSuccess(Void result) {
				if (result==null){
					codigoBox.setText("");
					nombreBox.setText("");
					Window.alert("La Empresa se ha Eliminado Satisfactoriamente: ");					
				}	
				
			}
		});
    	
    }
    

}
