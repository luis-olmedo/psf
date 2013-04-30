
package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;



public class Index implements EntryPoint {

   
  private HorizontalPanel addPanel = new HorizontalPanel();






private Button gestionPedido= new Button("MODULO \n PEDIDO");
private Button gestionConfiguracion= new Button("MODULO CONFIGURATION");

  public void onModuleLoad() {
	  
	
	
	  addPanel.add(gestionPedido);
	  addPanel.add(gestionConfiguracion);	 
	  gestionPedido.setStyleName("gestionPedido1");
	  gestionConfiguracion.setStyleName("gestionConfiguracion1");
	  
	  RootPanel.get("principal").add(addPanel);	  
	  gestionConfiguracion.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			Window.Location.assign("ModuloConfiguracion.html");
		}
	});
	  gestionPedido.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			Window.Location.assign("ModuloPedido.html");
		}
	});
	  	
  }
}