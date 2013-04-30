package com.google.gwt.sample.stockwatcher.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class ModuloPedio implements EntryPoint {

	
	private Button b= new Button("IR A  PEDIDOS");
	private Button a= new Button("IR A EXISTENCIAS");
	private HorizontalPanel appanel= new HorizontalPanel();
	@Override
	public void onModuleLoad() {
		appanel.add(b);
		appanel.add(a);
		
		a.setStyleName("a");
		b.setStyleName("b");
		
		RootPanel.get("gp").add(appanel);
		
        b.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Window.Location.assign("Pedido.html");
			}
		});
        a.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Window.Location.assign("existencia.html");
			}
		});
	}

}
