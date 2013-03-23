package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Bienevenida extends DialogBox {

	private static final Binder binder = GWT.create(Binder.class);
	final private TextBox pedido= new TextBox();	
	interface Binder extends UiBinder<Widget, Bienevenida> {
		
	}
	
	public Bienevenida() {
		setLayoutData(new HorizontalPanel());
		setWidget(binder.createAndBindUi(this));
		DockPanel dock = new DockPanel();	
	    dock.setSpacing(4);
	    setText("Bienvenido al Gestor de Pedidos");	
	    Label ped= new Label("Ingresar  el pedido a realizar: ");	    	   
	    Button ingresar= new Button("+"); 
	    dock.add(ingresar, DockPanel.SOUTH);
	    dock.add(ped, DockPanel.NORTH);
	    dock.add(pedido, DockPanel.EAST);
	    dock.setCellHorizontalAlignment(ingresar, DockPanel.ALIGN_RIGHT);
	    dock.setWidth("100%");
	    setWidget(dock);
	  
	    
	    ingresar.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			     StockWatcher s = new StockWatcher();
			     pedidoDato();
				 s.mostrarProductoPedido();				
				 }
			});
	}
	
	public  void pedidoDato(){
		String pedi=pedido.getText().toUpperCase().trim();
		Window.alert("el metodo trajo"+pedi);
		StockWatcher s = new StockWatcher();
		s.pasar(pedi);		
	}
	

}
