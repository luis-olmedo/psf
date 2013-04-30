package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ModuloConfiguracion implements EntryPoint {
;
	  private VerticalPanel mainPanel = new VerticalPanel();	 
	  private Button apboton = new Button("IR EMPRESAS");
	  private Button apboton1 = new Button("IR TIPOS USUARIOS");
	  private Button apboton2= new Button("IR CENTRO DE COSTOS");
	  private Button dptBoton= new Button("IR DEPARTAMENTOS");
	  private Button lugarBoton= new Button("IR LUGAR PEDIDO");
	  private Button undconBoton= new Button("IR UNIDAD CONSUMO");
	  private Button bodegaBoton= new Button("IR BODEGA");
	  private Button productoBoton= new Button("IR PRODUCTO BASE");	
	  private Button tipopedidodptpBoton=new Button("IR TIPO PEDIDO DPTO");
	 
	 
	  public void onModuleLoad() {
			
		  mainPanel.add(apboton);
		  mainPanel.add(apboton1);
		  mainPanel.add(apboton2);
		  mainPanel.add(dptBoton);
		  mainPanel.add(lugarBoton);
		  mainPanel.add(undconBoton);
		  mainPanel.add(bodegaBoton);
		  mainPanel.add(productoBoton);
		  mainPanel.add(tipopedidodptpBoton);
		  
		 apboton.setStyleName("apboton");
		 apboton1.setStyleName("apboton1");
		 apboton2.setStyleName("apboton2");
		 dptBoton.setStyleName("dptBoton");
		 lugarBoton.setStyleName("lugarBoton");
		 undconBoton.setStyleName("undconBoton");
		 bodegaBoton.setStyleName("bodegaBoton");
		 productoBoton.setStyleName("productoBoton");		
		 tipopedidodptpBoton.setStyleName("tipopedidodptpBoton");
		  
		  RootPanel.get("gg").add(mainPanel);
		  		
		  apboton1.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					Window.Location.assign("TipoUsuario.html");
				}
			});
		  
		  apboton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					Window.Location.assign("Empresa.html");
				}
			});
		  
		  apboton2.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					
					Window.Location.assign("centro.html");
				}
			});
		  
		 dptBoton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					Window.Location.assign("Departamento.html");
				}
			});
		  
		  lugarBoton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					Window.Location.assign("Lugar.html");
				}
			});
		  
		  undconBoton.addClickHandler(new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					Window.Location.assign("Unidad.html");
				}
			});
		  bodegaBoton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Window.Location.assign("Bodega.html");
			}
			
			
		});
		  
		  productoBoton.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub			
				Window.Location.assign("Producto.html");	
			}
		});		
		 
		 tipopedidodptpBoton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Window.Location.assign("TipoPedido.html");
			}
		});
		 
		
	  }
}
