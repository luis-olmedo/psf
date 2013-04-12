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

  private LoginInfo loginInfo = null;
  private VerticalPanel loginPanel = new VerticalPanel();
  private Label loginLabel = new Label("Acceder a  su cuenta  de google para utilizar la aplicacion PSFSERVICE");
  private Anchor signInLink = new Anchor("Iniciar Sesión");
  private Anchor signOutLink = new Anchor("Salir");
 private Label usuario= new Label ();

  public void onModuleLoad() {
	  
	    LoginServiceAsync loginService = GWT.create(LoginService.class);	    
	    loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
	    	
	      public void onFailure(Throwable error) {	    	  
	    	  Window.alert("lo sentimos  pero no funciono");
	    	  }	 
	      
	      public void onSuccess(LoginInfo result) {
	      loginInfo = result;	      
	      if(loginInfo.isLoggedIn()) {
	    	  
	       Window.alert("Bienvenido Usuario: "+result.getEmailAddress());	
	       Window.Location.assign("Index.html");       
	      
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
	  
	  
 
}