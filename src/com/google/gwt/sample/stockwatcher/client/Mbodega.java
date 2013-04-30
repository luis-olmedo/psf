package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.stockwatcher.server.Bodega;
import com.google.gwt.sample.stockwatcher.server.Empresa;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


public class Mbodega implements EntryPoint {	
	 
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 
	  private HorizontalPanel addPanel4 = new HorizontalPanel(); 	  
	  private ArrayList<Empresa> empresa=new ArrayList<Empresa>();
	  private final BodegaServiceAsync bodegaService=GWT.create(BodegaService.class);
	  private final EmpresaServiceAsync empresaService = GWT.create(EmpresaService.class);
	  private Label codBodegalabel= new Label("Codigo: ");
	  private TextBox codBodegaBox= new TextBox();  
	  private Label bodegalabel= new Label("Bodega: ");
	  private TextBox bodegaBox= new TextBox();
	  private Label  empresalabel= new Label("Empresa: ");
	  private ListBox empresaBox= new ListBox();
	  private Button crearBodegaBoton= new Button("Crear");
	  private Button eliminarBodega= new Button("Eliminar");
	  private Button modificarBodega= new Button("Modificar");
	  private Button buscarBodega= new Button("Buscar");
	  private TextBox pruebabox= new TextBox();  
	@Override
	public void onModuleLoad() {
		
		  addPanel1.add(codBodegalabel);
		  addPanel1.add(codBodegaBox);
		  addPanel2.add(bodegalabel);
		  addPanel2.add(bodegaBox);
		  addPanel3.add(empresalabel);
		  addPanel3.add(empresaBox);
		  addPanel3.add(pruebabox);
		  addPanel4.add(crearBodegaBoton);
		  addPanel4.add(modificarBodega);
		  addPanel4.add(eliminarBodega);
		  addPanel4.add(buscarBodega); 	

		  codBodegalabel.setStyleName("codBodegalabel");
		  codBodegaBox.setStyleName("codBodegaBox");
		  bodegalabel.setStyleName("bodegalabel");
		  bodegaBox.setStyleName("bodegaBox");
		  empresalabel.setStyleName("empresalabel");
		  empresaBox.setStyleName("empresaBox");
		  pruebabox.setStyleName("pruebabox");
		  crearBodegaBoton.setStyleName("crearBodegaBoton");
		  modificarBodega.setStyleName("modificarBodega");
		  eliminarBodega.setStyleName("eliminarBodega");
		  buscarBodega.setStyleName("buscarBodega");
		  
		  
		  cargarEmpresas();
		  
		  RootPanel.get("bo").add(addPanel1);
		  RootPanel.get("bo1").add(addPanel2);
		  RootPanel.get("bo2").add(addPanel3);
		  RootPanel.get("bo3").add(addPanel4);
		 
		 
		
		  crearBodegaBoton.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub			
				crearBodega();			
			}
		});
		  modificarBodega.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				modificarBodega();
				
			}
		});
		  eliminarBodega.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				eliminarBodega();
			}
		});
		  
		  buscarBodega.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				buscarBodega();
			}
		});
	    
	  }
	  
	  private  void  cargarEmpresas(){
		  empresaService.listTodos(new AsyncCallback<ArrayList<Empresa>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void onSuccess(ArrayList<Empresa> result) {
				// TODO Auto-generated method stub
				displayEmpresas(result);
			}
			  
		});
	  }
	  
	  private  void  displayEmpresas(List<Empresa>und){
			for (Empresa un:und){	
			empresaBox.addItem(un.getCodigoEmpresa());			
			}  	
		  }
	  
	  private  void  buscarBodega(){
		  final String  codigo= codBodegaBox.getText().toUpperCase().trim();
		  buscarBodega(codigo);
	  }
	  private 	void buscarBodega(String codigo){
		  bodegaService.buscarBodega(codigo,new AsyncCallback<Bodega>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se encontro");
			}
			
			@Override
			public void onSuccess(Bodega result) {
				// TODO Auto-generated method stub			
				bodegaBox.setText(result.getNombre());				
					if(result.getCodigoEmpresa().equalsIgnoreCase("PSF")){
						
						
						empresaBox.setItemText(0, result.getCodigoEmpresa());
						empresaBox.setItemText(1, "EX");
						
					}else{
							
						empresaBox.setItemText(0, result.getCodigoEmpresa());
						empresaBox.setItemText(1, "PSF");
					}
			}	  
			  
		});
	  }
	  
	  private  void eliminarBodega(){
		  final String  codigo= codBodegaBox.getText().toUpperCase().trim();
		  eliminarBodega(codigo);
	  }
	  
	  private  void  eliminarBodega(String  codigo){
		  bodegaService.elminarBodega(codigo, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no  elimino");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se  elimino  satisfactoriamente");
				codBodegaBox.setText("");
				bodegaBox.setText("");
			}
		});
	  }
	  
	  private void modificarBodega(){
		  final String  codigo= codBodegaBox.getText().toUpperCase().trim();
		  final String  nombre= bodegaBox.getText().toUpperCase().trim();
		  final int i= empresaBox.getSelectedIndex();
		  final String emp=empresaBox.getItemText(i);
		  
		  modificarBodega(codigo,nombre,emp);
	  }
	  
	  private  void modificarBodega(String  codigo,String nombre, String empresa){
		  bodegaService.modificarBodega(codigo, nombre, empresa, new AsyncCallback<Void>() {		
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se modifico Exitosamente");
				codBodegaBox.setText("");
				bodegaBox.setText("");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no  se  logro modificar");
			}
		});
	  }
	  
	  private  void crearBodega(){	 
		  final String  codigo= codBodegaBox.getText().toUpperCase().trim();
		  final String  nombre= bodegaBox.getText().toUpperCase().trim();
		  final int i= empresaBox.getSelectedIndex();
		  final String emp=empresaBox.getItemText(i);	 
		  
		  if(emp!="" && codigo!="" && nombre!=""){		  
			   empresaService.e(emp, new AsyncCallback<Empresa>() {
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub		
					Window.alert("llene  los  campos porfavor");
				}
				@Override
				public void onSuccess(Empresa result) {	
					empresa.add(result);
					crearBodega(codigo,nombre,result.getCodigoEmpresa());				
				}			
			});
		  }	else {		  
			  Window.alert("LLenar  los campos");
		  }
	  }  
	  
	  private  void crearBodega(String  codigo,String nombre,String  codigoEmpresa ){
		  	  bodegaService.addBodega(codigo, nombre, codigoEmpresa , new AsyncCallback<Void>() {		
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Lo sentimos  pero la  Bodega no pudo ser Almacenada ");
			}
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("guardo exitosamente");		
				codBodegaBox.setText("");
				bodegaBox.setText("");			
			}
			  
		});
	  }
	 

	}


