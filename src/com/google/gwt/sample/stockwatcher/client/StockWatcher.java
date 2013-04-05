package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class StockWatcher implements EntryPoint {

  private VerticalPanel mainPanel = new VerticalPanel(); 
  private HorizontalPanel addPanel = new HorizontalPanel();
  private HorizontalPanel addPanel1 = new HorizontalPanel();
  private HorizontalPanel addPanel2 = new HorizontalPanel();
  private HorizontalPanel addPanel3 = new HorizontalPanel(); 

  private LoginInfo loginInfo = null;
  private VerticalPanel loginPanel = new VerticalPanel();
  private Label loginLabel = new Label("Acceder a  su cuenta  de google para utilizar la aplicacion PSFSERVICE");
  private Anchor signInLink = new Anchor("Iniciar Sesión");
  private Anchor signOutLink = new Anchor("Salir");
   
private Label usu= new Label ("Usuario: ");
private Label usuario= new Label ();


private Button gestionPedido= new Button("Gestion de Pedido");
private Button gestionConfiguracion= new Button("Gestion de Configuracion");

  public void onModuleLoad() {
	  
	    LoginServiceAsync loginService = GWT.create(LoginService.class);	    
	    loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
	    	
	      public void onFailure(Throwable error) {	    	  
	    	  Window.alert("lo sentimos  pero no funciono");
	    	  }	 
	      
	      public void onSuccess(LoginInfo result) {
	      loginInfo = result;	      
	      if(loginInfo.isLoggedIn()) {	    	  
	        loadStockWatcher();	        
	        Window.alert("Bienvenido Usuario: "+result.getEmailAddress());	
	        usuario.setText(result.getEmailAddress()); 	       
	        }else{         
	          loadLogin();         
	        }
	      }
		
	    });
	    
	  }   
 
 
	  private void loadLogin() {
	    // Assemble login panel.
	    signInLink.setHref(loginInfo.getLoginUrl());
	    loginPanel.add(loginLabel);
	    loginPanel.add(signInLink);	 
	    RootPanel.get("stockList").add(loginPanel);
	    }   
	  
	  
  private void loadStockWatcher(){	
	  signOutLink.setHref(loginInfo.getLogoutUrl());
	  addPanel.add(gestionPedido);
	  addPanel.add(gestionConfiguracion);	  
	  addPanel3.add(usu);
	  addPanel3.add(usuario);
	  mainPanel.add(addPanel);
	  mainPanel.add(addPanel1);
	  mainPanel.add(addPanel2);
	  mainPanel.add(addPanel3); 
	
	  gestionPedido.setStyleName("gestionPedido");
	  gestionConfiguracion.setStyleName("gestionConfiguracion");
	  
	  RootPanel.get("stockList").add(mainPanel);	  
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