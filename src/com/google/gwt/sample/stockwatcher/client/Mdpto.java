package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.stockwatcher.server.Departamento;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Mdpto implements EntryPoint {	  
	 
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 	
	  private final DepartamentoServiceAsync dptoService=GWT.create(DepartamentoService.class);
	  private Label codeptlabel= new Label("Codigo: ");
	  private TextBox codeptBox= new TextBox();  
	  private Label deptabel= new Label("Departamento: ");
	  private TextBox deptBox= new TextBox();
	  private Button crearDptBoton= new Button("Crear Departamento");
	  private Button modificarDepto= new Button("Modificar");
	  private Button eliminarDepto= new Button("Eliminar"); 
	  private Button buscarDepto= new Button("Buscar");
	  
	 	@Override	
	public void onModuleLoad() {	 		
	 		 addPanel1.add(codeptlabel);
	 		 addPanel1.add(codeptBox);
	 		 addPanel2.add(deptabel);
	 		 addPanel2.add(deptBox);
	 		 addPanel3.add(crearDptBoton);
	 		 addPanel3.add(eliminarDepto);
	 		 addPanel3.add(modificarDepto);
	 		 addPanel3.add(buscarDepto); 	 		
	 		
	 		 RootPanel.get("dep").add(addPanel1);	
	 		 RootPanel.get("dep1").add(addPanel2);	
	 		 RootPanel.get("dep2").add(addPanel3);
	 		 
	 		 
	 		 codeptlabel.setStyleName("codeptlabel");
	 		 codeptBox.setStyleName("codeptBox");
	 		 deptabel.setStyleName("deptabel");
	 		 deptBox.setStyleName("deptBox");
	 		 crearDptBoton.setStyleName("crearDptBoton");
	 		 eliminarDepto.setStyleName("eliminarDepto");
	 		 modificarDepto.setStyleName("modificarDepto");
	 		 buscarDepto.setStyleName("buscarDepto");
	 		 
	 		 codeptBox.setFocus(true);	
	 		 	
	 		 
	 		 crearDptBoton.addClickHandler(new ClickHandler() {		
	 			@Override
	 			public void onClick(ClickEvent event) {
	 				// TODO Auto-generated method stub
	 				addDpto();		
	 				
	 			}
	 		});
	 		 eliminarDepto.addClickHandler(new ClickHandler() {
	 			
	 			@Override
	 			public void onClick(ClickEvent event) {
	 				eliminarDpto();
	 				
	 			}
	 		});
	 		 
	 		 modificarDepto.addClickHandler(new ClickHandler() {
	 			
	 			@Override
	 			public void onClick(ClickEvent event) {
	 				// TODO Auto-generated method stub
	 				modificarDpto();
	 			}
	 		});
	 		 
	 		 buscarDepto.addClickHandler(new ClickHandler() {		
	 			@Override
	 			public void onClick(ClickEvent event) {
	 				// TODO Auto-generated method stub
	 				buscarDepto();
	 			}
	 		});

	}
	 	
	 	 private  void addDpto(){
	 		 
	 		 final String codDpto =codeptBox.getText().toUpperCase().trim();
	 		 final String nomDpto=deptBox.getText().toUpperCase().trim();
	 		 codeptBox.setFocus(true);
	 		 if(!codDpto.equalsIgnoreCase("") && !nomDpto.equalsIgnoreCase("")){
	 			 addDpto(codDpto,nomDpto);
	 		}else{    	
	 	    	Window.alert("Porfavor  llene los campos"); 
	 	    }   	
	 		 
	 		 
	 	 }
	 	 
	 	private void addDpto(final String codDpto, final String nomDpto){
	    	dptoService.addDepartamento(codDpto, nomDpto, new AsyncCallback<Void>() {
	    		
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Window.alert("No se logro  Guardar");
					}
				
				@Override
				public void onSuccess(Void result) {					
					Window.alert("Se guardop  Satisfactoriamente el Departamento");
					 codeptBox.setText("");	
					 deptBox.setText("");
				}
			});
	    	
	    }
	 	
	 	private  void buscarDepto(){
	 		 final String codigo=codeptBox.getText().toUpperCase().trim();
	 		 buscarDepto(codigo);
	 	 }
	 	 
	 	 private void buscarDepto(String codigo){
	 		 dptoService.d(codigo,new AsyncCallback<Departamento>() {

	 			@Override
	 			public void onFailure(Throwable caught) {
	 				// TODO Auto-generated method stub			
	 			}		

	 			@Override
	 			public void onSuccess(Departamento result) {
	 				// TODO Auto-generated method stub
	 				codeptBox.setText(result.getCodDpto());
	 				deptBox.setText(result.getNomDpto());
	 			}		 
	 		});
	 	 }
	 	 
	 	 private void eliminarDpto(){
	 		 final String codpt= codeptBox.getText().toUpperCase().trim();
	 		 eliminarDpto(codpt);
	 	 }
	 	 
	 	 private void eliminarDpto(String codpt){
	 		 dptoService.elminarDepartamento(codpt, new AsyncCallback<Void>() {

	 			@Override
	 			public void onFailure(Throwable caught) {
	 				// TODO Auto-generated method stub
	 				Window.alert("no se pudo eliminar el departamento");
	 			}
	 			@Override
	 			public void onSuccess(Void result) {
	 				// TODO Auto-generated method stub
	 				Window.alert("se  ha  eliminado el departamento satisfactoriamente");	
	 				codeptBox.setText("");
	 				deptBox.setText("");
	 			}
	 		});
	 	 }
	 	 
	 	 private void modificarDpto(){
	 		 final String codpt= codeptBox.getText().toUpperCase().trim();
	 		 final String dpto= deptBox.getText().toUpperCase().trim();
	 		 modificarDpto(codpt,dpto);
	 	 }
	 	 
	 	 private  void modificarDpto(String codpt,String dpto){
	 		 dptoService.modificarDepartamento(codpt, dpto,new AsyncCallback<Void>() {
	 			@Override
	 			public void onFailure(Throwable caught) {
	 				// TODO Auto-generated method stub
	 				Window.alert("No se pudo modificar");		
	 			}
	 			@Override
	 			public void onSuccess(Void result) {
	 				// TODO Auto-generated method stub
	 				Window.alert("Se modifico satisfactoriamente");
	 				codeptBox.setText("");
	 				deptBox.setText("");
	 			}
	 		} );
	 	 }

}
