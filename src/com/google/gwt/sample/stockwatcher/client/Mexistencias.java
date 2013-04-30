package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.sample.stockwatcher.server.Bodega;
import com.google.gwt.sample.stockwatcher.server.Exixtencias;
import com.google.gwt.sample.stockwatcher.server.ProductoBase;
import com.google.gwt.sample.stockwatcher.server.ProductoPedido;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.sun.java.swing.plaf.windows.resources.windows;

public class Mexistencias implements EntryPoint {
	
	private HorizontalPanel addPanel = new HorizontalPanel();	
	private HorizontalPanel addPanel2 = new HorizontalPanel();	 
	private HorizontalPanel addPanel4 = new HorizontalPanel(); 
	  
	private  FlexTable productoPedido = new FlexTable();
	private  Button add= new  Button("Add");
	private  ListBox pedidoBox= new ListBox();
	private  TextBox cantidadBox= new TextBox();	
	MultiWordSuggestOracle pro = new MultiWordSuggestOracle ();  
	private SuggestBox BoxlistProductop= new SuggestBox(pro) ;
	private TextBox BoxfechaCubrimiento= new TextBox();
	private Label  pedidooo= new Label("Bodega:");	
	private  Button eliminarProductoPedido=new Button("Consultas");
	private Button buscarProductoPedido=new Button("Guardar");	
	private  Button limpiar= new Button("Limpiar");
	private Button eliminarPedidosButton = new Button("Eliminar ");
	//private Button consultarBodega=new Button("Consultar ");	
	private Button to=new Button("Ultimo Conteo");
	 private  final ExistenciaServiceAsync existenciaService=GWT.create(ExistenciaService.class);
	 private final ProductoBaseServiceAsync productoService=GWT.create(ProductoBaseService.class);
	 private final BodegaServiceAsync bodegaService=GWT.create(BodegaService.class);
	
	@Override
	public void onModuleLoad() {
		
		mostrarProductoPedido();

	}
	
	private  void  filitas(){	
		 productoPedido.getCellFormatter().addStyleName(0, 0, "menu");
		 productoPedido.getCellFormatter().addStyleName(0, 5, "menu");
		 productoPedido.getCellFormatter().addStyleName(0, 10, "menu");
		 productoPedido.getCellFormatter().addStyleName(0, 20, "menu");
		 productoPedido.getCellFormatter().addStyleName(0, 30, "menu");		
		 
		 productoPedido.setStyleName("productoPedido");
	     productoPedido.setText(1, 0, "ITEM");
		 productoPedido.setText(1, 5, "PRODUCTO");
		 productoPedido.setText(1, 10,"CANTIDAD");
		 productoPedido.setText(1, 20,"FECHA DE CONTEO");
		 productoPedido.setText(1, 30,"BODEGA");	
		 productoPedido.setWidget(2, 55, add);
		 productoPedido.setWidget(2, 5, BoxlistProductop);
		 productoPedido.setWidget(2, 10, cantidadBox);
		 productoPedido.setWidget(2, 20, BoxfechaCubrimiento);	
		 
	
}

public  void mostrarProductoPedido(){	
	 productoPedido.setStyleName("productoPedido1");
	 BoxlistProductop.setLimit(10);
     filitas();
     addPanel.add(pedidooo); 
	 addPanel.add(pedidoBox);			 	
	 addPanel2.add(productoPedido);		
	 addPanel4.add(eliminarProductoPedido);
	 addPanel4.add(buscarProductoPedido);
	 addPanel4.add(limpiar);	
	 addPanel4.add(eliminarPedidosButton);
	 addPanel4.add(to);
	// addPanel4.add(consultarBodega);
	
	    add.setStyleName("add1");
	    pedidooo.setStyleName("pedidooo1");
		pedidoBox.setStyleName("pedidoBox1");	
		cantidadBox.setStyleName("cantidadBox1");
		BoxfechaCubrimiento.setStyleName("BoxfechaCubrimiento1");		
		productoPedido.setStyleName("productoPedido1");	
		productoPedido.getRowFormatter().setStyleName(0, "ri1");
		eliminarProductoPedido.setStyleName("eliminarProductoPedido1");
		buscarProductoPedido.setStyleName("buscarProductoPedido1");
		limpiar.setStyleName("limpiar1");
		eliminarPedidosButton.setStyleName("eliminarPedidosButton1");
		BoxlistProductop.setStyleName("BoxlistProductop1");
		to.setStyleName("to");
	//	consultarBodega.setStyleName("consultarBodega");
	 cargarProductoss();
	 cargarBodega();	
	 BoxfechaCubrimiento.setEnabled(false);		 
	 RootPanel.get("e").add( addPanel);
	 RootPanel.get("e1").add( addPanel2);
	 RootPanel.get("e2").add( addPanel4);
	
	 
	 add.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			validarProducto();
		}
	});
	 
	 to.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			traerTodos();
		}
	});
	 
	 eliminarPedidosButton.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			borrarTodo();
		}
	});
	 		 
	 
	 eliminarProductoPedido.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			//consultarListas();
			consultaparahacer();
		}
	});
	 
		 
	 
	 limpiar.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
		productoPedido.removeAllRows();
        filitas();      
     	BoxlistProductop.setText("");
 	    cantidadBox.setText("");  	    	
 	    pedidoBox.setEnabled(true);
 	    BoxfechaCubrimiento.setText("");
 	    int jj=0;
 	    int h=0;
		}
	});	
	 
	 
	 buscarProductoPedido.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
		 guardarExistencia();	
		}
	});
	 
	/* consultarBodega.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			//consultar();
		}
	});*/
	 }

private  void consultaparahacer(){	
	final int i=pedidoBox.getSelectedIndex();
	final String codigoBodega=pedidoBox.getItemText(i);
	final String codigoProducto=BoxlistProductop.getText().toUpperCase().trim();
	
	if((codigoBodega=="" || codigoBodega==null)&& (codigoProducto=="" || codigoProducto==null)){
		
		Window.alert("Porfavor llenar campos  de consulta ya  sea  la bodega  o el producto");
	}else{
		
	}	
	
	if(codigoProducto!="" || codigoProducto!=null){
		consultarListas();
	}else{
		
	}
	
	if((codigoProducto==""|| codigoProducto==null)&&(codigoBodega!="" || codigoBodega!=null)){		
		consultar();
	}else{
		
	}
	
	
	
	
	
}
private  void consultar(){
	final int i=pedidoBox.getSelectedIndex();
	final String codigoBodega=pedidoBox.getItemText(i);
	productoPedido.removeAllRows();
    filitas(); 	
    cantidadBox.setText("");  	    	
    pedidoBox.setEnabled(false); 
	existenciaService.cargarExistenciassBodega(codigoBodega, new AsyncCallback<ArrayList<Exixtencias>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no  encontro  nada");
		}

		@Override
		public void onSuccess(ArrayList<Exixtencias> result) {
			// TODO Auto-generated method stub			
			if (result.size()==0){
				Window.alert("La bodega a  la que usted quiere acceder no existe ");
				
				pedidoBox.setFocus(true);
			}
	           for(Exixtencias e: result){	        	  
				for (int i=0; i<e.getCodigoProducto().size();i++){					
						 Date fu=e.getFecha().get(i);
						 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");							
						 String feP=fmtDate.format(fu);
						 // Window.alert("la fecha de ese  producto es: " + feP);
						 //Window.alert("tamano de las  filitas es: " + productoPedido.getRowCount());
						 final Button edit= new Button("EDITAR");							
						 final Button eli= new Button("ELIMINAR");
						 eli.setStyleName("eliminar1");
						 edit.setStyleName("editar1");
					     int m=productoPedido.getRowCount()-1;
						 int k=productoPedido.getRowCount();
						 
						 final int u=k-2;									
					
						 productoPedido.setText(k-1, 0,u+"");							 
						 productoPedido.setText(k-1, 30, e.getCodigoBodega());
					
						 int p= m;
						 edit.setTitle(""+p);						
						 eli.setTitle(""+p);	
						
						
						 
						
						 
						 edit.addClickHandler(new ClickHandler() {											
								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub							
									int id=Integer.parseInt(edit.getTitle());
									//Window.alert("el numero es"+id);
									editarPed(id);
								}
							});
							
							eli.addClickHandler(new ClickHandler() {						
								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub
									
								    int p=Integer.parseInt(eli.getTitle());
								    //Window.alert("la  fila a eliminar es: "+p);
									productoPedido.removeRow(p);							
								    organizar();									
								
								
								}
							});
						 
						 productoPedido.setText(k-1, 5, e.getCodigoProducto().get(i));
						 productoPedido.setText(k-1, 10,e.getCantidad().get(i)+"");									
						 productoPedido.setText(k-1, 20,feP);			
						 productoPedido.setWidget(k-1, 60,edit);
						 productoPedido.setWidget(k-1, 65, eli);		 
						 productoPedido.setWidget(k, 55, add);
						 productoPedido.setWidget(k, 5, BoxlistProductop);
						 productoPedido.setWidget(k, 10, cantidadBox);
						 productoPedido.setWidget(k, 20, BoxfechaCubrimiento);
					
				}
			}
		}
		
	});
	BoxlistProductop.setText("");
}
int jj=0;
private  void guardarExistencia(){
	
	final int i=pedidoBox.getSelectedIndex();
	final String codigoBodega=pedidoBox.getItemText(i);
	jj=0;		
		//Window.alert("esto tieene la tabla "+productoPedido.getRowCount());
		//Window.alert("esto tiene jj \n"+jj);		
		
		ArrayList<Double>cantidad=new ArrayList<Double>();	
		ArrayList<String>producto=new ArrayList<String>();	
		ArrayList<Date>fe= new ArrayList<Date>();
		ArrayList<Date>fePed= new ArrayList<Date>();	 
	
		
		 
		 for(int k=2; k<=productoPedido.getRowCount()-2; k++){	
			    //Window.alert("el valor de tamano"+productoPedido.getRowCount());
				//Window.alert("el valor de k"+k);
				 //Window.alert("el valor de jj"+jj);	 
										 
					 String c=productoPedido.getText(k, 10);
					 double cant=Double.parseDouble(c);			 
					 cantidad.add(jj,cant);					 				
					 
					 String f= productoPedido.getText(k, 20);
					 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");
					 Date  fecha=fmtDate.parse(f);
					 
					 fe.add(jj, fecha);						
					 
					 producto.add(jj,productoPedido.getText(k,5));	 			
					 
					 if(jj==productoPedido.getRowCount()-4){			 
					
						 Window.alert("se guardo satisfactoriamente");
					     gurad(codigoBodega,producto,cantidad,fe);
						 Window.alert("Los  datos almacenados  son: "+"\n Bodega : "+codigoBodega+"\n Producto: "+producto+"\n Cantidad: "+cantidad+"\n Fecha: "+fe);
						 
						 
					 }
					 jj++;
					
}
}
		 
		 private  void gurad(String codigoBodega, ArrayList<String> codigoProducto,
					ArrayList<Double> cantidad,
					ArrayList<Date> fecha){
			    
	    	   
			 existenciaService.addExistencia(codigoBodega, codigoProducto, cantidad, fecha, new AsyncCallback<Void>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Window.alert("no se  pudo alamcenar");
				}

				@Override
				public void onSuccess(Void result) {
					// TODO Auto-generated method stub
					productoPedido.removeAllRows();
		            filitas();		            
		        	BoxlistProductop.setText("");
		    	    cantidadBox.setText("");			    	    
		    	    pedidoBox.setEnabled(true);
		    	    BoxfechaCubrimiento.setText("");
				}
				 
			});
			 
		} 

private void validarProducto(){
	 
	 productoService.cargarProducto(new AsyncCallback<ArrayList<ProductoBase>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("No se logro cargar el Producto porfavor  vuelva y cargue la pagina");
		}

		@Override
		public void onSuccess(ArrayList<ProductoBase> result) {
			// TODO Auto-generated method stub			
			 displayProductosss(result);
		}
		 
	});
	
}

private  void  displayProductosss(List<ProductoBase>p){
	// Window.alert("la lista de producto es: "+p);
	 final String pro=BoxlistProductop.getText().toUpperCase().trim();
	 final int i=pedidoBox.getSelectedIndex();
     final String codigoBodega=pedidoBox.getItemText(i);
	
	 String po="";
	 
		for (ProductoBase pp:p){
			
			
		if(pp.getDescripcion().equalsIgnoreCase(pro)){		
			     po="hay algo";	
			     
			 	bodegaService.buscarBodega(codigoBodega, new AsyncCallback<Bodega>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("La bodega a la que  usted esta accediendo no existe porfavor ingrese una  bodega que exista");
						
					}

					@Override
					public void onSuccess(Bodega result) {
						// TODO Auto-generated method stub
						addPedidoPro();
					}
				});
				}	
		} 
		
		if(po.equalsIgnoreCase("")|| po==null){
			Window.alert("Lo sentimos pero el producto que ingreso no esta inventariado, porfavor  ingrese  un producto existente");		
			BoxlistProductop.setText("");
			cantidadBox.setText("");
			pedidoBox.setFocus(true);
		}
		
	
			
		
		
	  } 
private void addPedidoPro() { 	 
    int i=productoPedido.getRowCount();	     
    //Window.alert("cantidad de filas"+i);
    final int h=pedidoBox.getSelectedIndex();
     final String ped=pedidoBox.getItemText(h);
	 final String pro=BoxlistProductop.getText().toUpperCase().trim();
	 final String c= cantidadBox.getText().toUpperCase().trim();			 
	 final double cant= Double.parseDouble(c);				  						     
						 	
							 Date fu=new Date();
							 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");								
							 String feP=fmtDate.format(fu);
							 BoxfechaCubrimiento.setText(feP);
							 
							 int po=i-1;
							 int p=i-2;
							 
							 Button edit= new Button("EDITAR");
							 edit.setTitle(""+po);
							 edit.setStyleName("editar1");
							 final Button eli= new Button("ELIMINAR");
							 eli.setTitle(""+po);	
							 eli.setStyleName("eliminar1");
						
							 
							 eli.addClickHandler( new ClickHandler() {									
								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub
									int l=Integer.parseInt(eli.getTitle());
									productoPedido.removeRow(l);
									organizar();
								}
							});
						         productoPedido.getCellFormatter().addStyleName(i-1, 0, "celdas");
	                             productoPedido.getCellFormatter().addStyleName(i-1, 5, "celdas");
	                             productoPedido.getCellFormatter().addStyleName(i-1, 10, "celdas");
	                             productoPedido.getCellFormatter().addStyleName(i-1, 20, "celdas");                  
	                        
	                        
	                            // Window.alert("po es: "+po);
								 productoPedido.setText(i-1, 0,p+"");	
								 productoPedido.setText(i-1, 5, pro);
								 productoPedido.setText(i-1, 10, cant+"");
								 productoPedido.setText(i-1, 20, feP);								
								 productoPedido.setWidget(i-1, 60, edit);
								 productoPedido.setWidget(i-1, 65, eli);
								 productoPedido.setWidget(i, 55, add);
								 productoPedido.setWidget(i, 5,  BoxlistProductop);
								 productoPedido.setWidget(i, 10, cantidadBox);
								 productoPedido.setWidget(i, 20, BoxfechaCubrimiento);
							
																 									
								 
							 
						
}	

private void organizar(){
	
	//Window.alert("entro al metodo organizar");
	
	for (int p=2; p<productoPedido.getRowCount()-1; p++){
		//Window.alert("entro al metodo organizar con cilco"+ p);
		//Window.alert("EL  TAMANO  ES: "+productoPedido.getRowCount() );
		final Button edit=new Button("EDITAR");
		final Button eli= new Button("ELIMINAR");
		 eli.setStyleName("eliminar1");
		 edit.setStyleName("editar1");
		edit.setTitle(""+p);
		eli.setTitle(""+p);
		int t=p-1;
	    productoPedido.setText(p, 0,t+"");	
		productoPedido.setWidget(p, 65, eli);
		productoPedido.setWidget(p, 60, edit);
		
		edit.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				int id=Integer.parseInt(edit.getTitle());
				//Window.alert("el numero es"+id);
				editarPed(id);
			}
		});
	
		
		eli.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				int p=Integer.parseInt(eli.getTitle());
			    //Window.alert("la  fila a eliminar es: "+p);
				productoPedido.removeRow(p);							
			    organizar();
			}
		});
	}
	
}

private void editarPed(int m){ 
	
	 final String pro=BoxlistProductop.getText().toUpperCase().trim();
	 final String c= cantidadBox.getText().toUpperCase().trim();			 
	 final double cant= Double.parseDouble(c); 	 	  
	 Date fu=new Date();
     DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");		
	 String fechaC=fmtDate.format(fu);	
	 int p=0;
	 
	   if(pro.equalsIgnoreCase("")|| pro==null){ 		  
			Window.alert("porfavor llene los campos para proceder lo la editacion");
			BoxlistProductop.setFocus(true);
			
	   }else{
		   
		     productoPedido.setText(m, 5,pro);
			 productoPedido.setText(m, 10,c);
			 productoPedido.setText(m, 20,fechaC);
		   		   
	   }						
		
	
}

private  void cargarProductoss(){
	 productoService.cargarProducto(new AsyncCallback<ArrayList<ProductoBase>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<ProductoBase> result) {
			// TODO Auto-generated method stub
			displayProductoss(result);
			}		 
	});
}

private void cargarBodega(){
	bodegaService.cargarBodega(new AsyncCallback<ArrayList<Bodega>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no logro cargar las  bodegas porfavor vuelva a  cargar  la  pagina");
		}

		@Override
		public void onSuccess(ArrayList<Bodega> result) {
			// TODO Auto-generated method stub
			displayBodegas(result);
		}
		
	});
}

private  void displayBodegas(List<Bodega>b){
	for(Bodega bb:b){
		pedidoBox.addItem(bb.getCodigoBodega());
	}
}

private  void  displayProductoss(List<ProductoBase>p){
	for (ProductoBase pp:p){			   
		pro.add(pp.getDescripcion());
	}  		
  }  

private void traerTodos(){
	
	
	if(productoPedido.getRowCount()==3){
		Window.alert("Para realizar el  utlimo conteo  necesita  consultar primero el producto");
		BoxlistProductop.setFocus(true);
	}
	 
     DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");
     Date fu=fmtDate.parse(productoPedido.getText(2, 20));
     long f=fu.getTime();
    // Window.alert("el long  es: "+ f);
     Date d =new Date (f);
     DateTimeFormat fmtDate1=DateTimeFormat.getFormat("dd/MM/yyyy");
     String s=fmtDate1.format(d);
     //Window.alert("la transformacion del  long es: "+s);
	 String fechaC=fmtDate.format(fu);	
	 String producto="";
	 String cantidad="";
	 String bodega="";
	for (int i=2;i<productoPedido.getRowCount()-1; i++){
		//Window.alert("esto  tiene las  filas : "+productoPedido.getText(i, 20));
		Date fechita=fmtDate.parse(productoPedido.getText(i, 20));
        long fechota=fechita.getTime();
        if(fechota>f){
        	f=fechota;
            bodega=productoPedido.getText(i,30);
        	producto=productoPedido.getText(i, 5);
        	cantidad=productoPedido.getText(i, 10);       		
        }
		
	}
	productoPedido.removeAllRows();
	filitas();	
	Date dd= new Date(f);
	String fechaMayor=fmtDate.format(dd);
	productoPedido.setText(2, 5, producto);
	productoPedido.setText(2, 10, cantidad);
	productoPedido.setText(2, 30, bodega);
	productoPedido.setText(2, 20,fechaMayor);
}





private   void borrarTodo(){
	
     final int h=pedidoBox.getSelectedIndex();
     final String codigo=pedidoBox.getItemText(h);
	 if(codigo.equalsIgnoreCase("")||codigo==null){
		 Window.alert("Porfavor  ingresar el  codigo de la  bodega a eliminar");
	 }else{
	 if( Window.confirm("Esta  seguro que deseas eliminar  esta existencia ??? \n Recuerde que una vez elimando la existencia  sera imposible recuperar los datos de ella ")==true){
		 borrarTodo(codigo);		 
	 }else{
		
	 }
		 }
	 }


private  void  borrarTodo(String codigo){
existenciaService.elminarExistencia(codigo, new AsyncCallback<Void>() {

	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub
		Window.alert("no se logro  eliminar la existencia  probablemente esta no exista");
	}

	@Override
	public void onSuccess(Void result) {
		// TODO Auto-generated method stub		
		BoxlistProductop.setText("");
		BoxfechaCubrimiento.setText("");
		cantidadBox.setText("");
		productoPedido.removeAllRows();
		filitas();
		Window.alert("se elimino con exito la existencia");
	}
	
});	 
}



private void consultarListas(){	
	pedidoBox.setEnabled(true);
	final String codigoProducto=BoxlistProductop.getText().toUpperCase().trim();
	 bodegaService.cargarBodega(new AsyncCallback<ArrayList<Bodega>>() {		 
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no logro cargar la bodega  porfavor  vuelva  y  cargue la  pagina");
		}
		@Override
		public void onSuccess(ArrayList<Bodega> result) {
			// TODO Auto-generated method stub
			for(Bodega b:result){				
				String bodega=b.getCodigoBodega();
				//Window.alert("Bodega: "+ bodega);
				consultarListas(bodega, codigoProducto);
			}
			
		}
	});
}



private void consultarListas(String codigoBodega, String codigoProducto){
	final String producto=codigoProducto;	
	//Window.alert("entro  a cargar : \n" +codigoBodega + "\n" +codigoProducto);
	existenciaService.cargarExistenciassBodega(codigoBodega, new AsyncCallback<ArrayList<Exixtencias>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no  logro cargar las  exitencias  porfavor   volver  a cargar la pagina");
		}

		@Override
		public void onSuccess(ArrayList<Exixtencias> result) {
			// TODO Auto-generated method stub
			for(Exixtencias e: result){
				
				for (int i=0; i<e.getCodigoProducto().size();i++){
					if(e.getCodigoProducto().get(i).equalsIgnoreCase(producto)){
						 Date fu=e.getFecha().get(i);
						 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");							
						 String feP=fmtDate.format(fu);
						 //Window.alert("la fecha de ese  producto es: " + feP);
						 //Window.alert("tamano de las  filitas es: " + productoPedido.getRowCount());
						 final Button edit= new Button("EDITAR");							
						 final Button eli= new Button("ELIMINAR");
						 eli.setStyleName("eliminar1");
						 edit.setStyleName("editar1");
					     int m=productoPedido.getRowCount()-1;
						 int k=productoPedido.getRowCount();
						 
						 final int u=k-2;									
					
						 productoPedido.setText(k-1, 0,u+"");							 
						 productoPedido.setText(k-1, 30, e.getCodigoBodega());
					
						 int p= m;
						 edit.setTitle(""+p);						
						 eli.setTitle(""+p);
						 
						
						
						 
						
						 
						 edit.addClickHandler(new ClickHandler() {											
								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub							
									int id=Integer.parseInt(edit.getTitle());
									//Window.alert("el numero es"+id);
									editarPed(id);
								}
							});
							
							eli.addClickHandler(new ClickHandler() {						
								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub
									
								    int p=Integer.parseInt(eli.getTitle());
								    //Window.alert("la  fila a eliminar es: "+p);
									productoPedido.removeRow(p);							
								    organizar();									
								
								
								}
							});
						 
						 productoPedido.setText(k-1, 5, e.getCodigoProducto().get(i));
						 productoPedido.setText(k-1, 10,e.getCantidad().get(i)+"");									
						 productoPedido.setText(k-1, 20,feP);			
						 productoPedido.setWidget(k-1, 60,edit);
						 productoPedido.setWidget(k-1, 65, eli);		 
						 productoPedido.setWidget(k, 55, add);
						 productoPedido.setWidget(k, 5, BoxlistProductop);
						 productoPedido.setWidget(k, 10, cantidadBox);
						 productoPedido.setWidget(k, 20, BoxfechaCubrimiento);
					}
				}
			}
		}
		
	});
	BoxlistProductop.setText("");
}



}








