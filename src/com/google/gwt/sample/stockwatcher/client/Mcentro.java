package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.stockwatcher.server.CentroCostos;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Mcentro implements EntryPoint {	 
	
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 
		 
	  private final CentroCostoServiceAsync centroService=GWT.create(CentroCostoService.class);
	  
	  private Label codlabel= new Label("Codigo: ");
	  private TextBox codBox= new TextBox();  
	  private Label costoabel= new Label("Centro: ");
	  private TextBox costoBox= new TextBox();
	  private Button costoBoton= new Button("Crear"); 
	  private Button modificarCentro= new Button("Modificar");
	  private Button eliminarCentro= new Button("Eliminar");
	  private Button buscarCosto= new Button("Buscar");
	  
	@Override
	public void onModuleLoad() {		
		 addPanel1.add(codlabel);
		 addPanel1.add(codBox);
		 addPanel2.add(costoabel);
		 addPanel2.add(costoBox);
		 addPanel3.add(costoBoton);
		 addPanel3.add(modificarCentro);
		 addPanel3.add(eliminarCentro);
		 addPanel3.add(buscarCosto);
		 
		 RootPanel.get("cen").add(addPanel1);
		 RootPanel.get("cen1").add(addPanel2);
		 RootPanel.get("cen2").add(addPanel3);
		 codBox.setFocus(true);		
		 
		 codlabel.setStyleName("codlabel");
		 codBox.setStyleName("codBox");
		 costoabel.setStyleName("costoabel");
		 costoBox.setStyleName("costoBox");
		 costoBoton.setStyleName("costoBoton");
		 modificarCentro.setStyleName("modificarCentro");
		 eliminarCentro.setStyleName("eliminarCentro");
		 buscarCosto.setStyleName("buscarCosto");
		 
		 costoBoton.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				addCentroCotos();			
			}
		});
		 
		 modificarCentro.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				modificarCentro ();
				
			}
		});
		 
		 eliminarCentro.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub			
				eliminarCentro();
			}
		});
		 
		 buscarCosto.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub			
				buscarCosto();
				}
		});	
    
	}
	
	private  void addCentroCotos (){
		 final String codCosto =codBox.getText().toUpperCase().trim();
		 final String nomCosto=costoBox.getText().toUpperCase().trim();
		 codBox.setFocus(true);
		 if(!codCosto.equalsIgnoreCase("") && !nomCosto.equalsIgnoreCase("")){
			 Window.alert("Guardo satisfactoriamente ");       		 
		}else{    	
	    	Window.alert("Porfavor  llene los campos"); 
	    }	 
		 codBox.setText("");	
		 costoBox.setText("");    		
		 addCentroCotos( codCosto,nomCosto);
		 
	 }
	
	 private  void addCentroCotos(final String codCosto, final String nomCostos ){
	    	centroService.addCentroCostos(codCosto, nomCostos, new AsyncCallback<Void>() {
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Window.alert("No  se  logro Guardar  el Centro de  costo");
				}			
				@Override
				public void onSuccess(Void result) {
					// TODO Auto-generated method stub					
					Window.alert("Se Guardo Satisfactoriamente el Centro de Costo");
				}
			});
	    	
	    }
	 
	private  void buscarCosto(){
		 final String codigo= codBox.getText().toUpperCase().trim();
		 buscarCosto(codigo);	 
	 }
	 
	 private  void buscarCosto(String codigo){
		centroService.c(codigo,new AsyncCallback<CentroCostos>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub	
				Window.alert("Lo sentimos pero el codigo del Centro de Costo ingresado no exixte");
			}
			@Override
			public void onSuccess(CentroCostos result) {
				// TODO Auto-generated method stub
				codBox.setText(result.getCodigoCosto());
				costoBox.setText(result.getNombreCosto());			
			}		
		});
		 
	 }
	 
	 private  void eliminarCentro(){
		 final String codCentro=codBox.getText().toUpperCase().trim();
		 eliminarCentro(codCentro);
	 }
	 
	 
	 private  void  eliminarCentro(String codCentro){
		 centroService.elminarCentroCostos(codCentro,new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no  se pudo  eliminar ya  q no exixte ");			
			}
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se elimino satisfactoriamente");
				codBox.setText("");
				costoBox.setText("");
			}
		});
	 }
	 
	 private void modificarCentro (){	 
		 final String codCentro=codBox.getText().toUpperCase().trim();
		 final String costos=costoBox.getText().toUpperCase().trim();
		 modificarCentro(codCentro,costos);
	 }
	 
	 private  void modificarCentro (String codCentro, String costo){
		 centroService.modificarCentroCostos(codCentro, costo, new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("El Centro de  Costo se logro modificar");			
			}		
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("Se Modifico Satisfactoriamente");
				codBox.setText("");
				costoBox.setText("");
			}
		});
	 }
	 

}
