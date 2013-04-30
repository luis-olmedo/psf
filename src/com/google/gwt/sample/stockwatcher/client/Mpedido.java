package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java_cup.production;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.sample.stockwatcher.server.CentroCostos;
import com.google.gwt.sample.stockwatcher.server.Departamento;
import com.google.gwt.sample.stockwatcher.server.ProductoBase;
import com.google.gwt.sample.stockwatcher.server.ProductoPedido;
import com.google.gwt.sample.stockwatcher.server.TipoPedidoDpto;
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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class Mpedido implements EntryPoint {

	  private final ProductoPedidoServiceAsync productopedidoService=GWT.create(ProductoPedidoService.class);
	  private final DepartamentoServiceAsync dptoService=GWT.create(DepartamentoService.class);
	  private final ProductoBaseServiceAsync productoService=GWT.create(ProductoBaseService.class);
	  private final CentroCostoServiceAsync centroService=GWT.create(CentroCostoService.class);
	  private final TipoPedidoDptoServiceAsync tipoPedidoService=GWT.create(TipoPedidoDptoService.class);
	  
	  private VerticalPanel mainPanel = new VerticalPanel(); 
	  private HorizontalPanel addPanel = new HorizontalPanel();
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 
	  private HorizontalPanel addPanel4 = new HorizontalPanel(); 
	  private HorizontalPanel addPanel5 = new HorizontalPanel();
	  
	private  FlexTable productoPedido = new FlexTable();
	private  Button add= new  Button("Add");
	private  TextBox pedidoBox= new TextBox();
	private  TextBox cantidadBox= new TextBox();
	private  TextBox observacionesBox= new TextBox();
	MultiWordSuggestOracle cen = new MultiWordSuggestOracle ();  
	private SuggestBox BoxlistCentro= new SuggestBox(cen) ;
	MultiWordSuggestOracle pro = new MultiWordSuggestOracle ();  
	private SuggestBox BoxlistProductop= new SuggestBox(pro) ;
	
	private TextBox BoxfechaCubrimiento= new TextBox();
	private Label  pedidooo= new Label("Pedido:");
	private  Label pedFecha= new Label("Fecha: ");
	private  Label pedFecha1= new Label();
	private  Label dp = new Label("Departamento: ");
	private ListBox BoxlistDepto= new ListBox();
	private  Button eliminarProductoPedido=new Button("Consultar");
	private Button buscarProductoPedido=new Button("Guardar");
	private  Button borrarTodo=new Button("Cancelar Producto Pedido");
	private  Button limpiar= new Button("Limpiar");
	private Button eliminarPedidosButton = new Button("Eliminar");
	private  TextBox  fechaped= new TextBox();

	
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
		 productoPedido.getCellFormatter().addStyleName(0, 40, "menu");
		 productoPedido.getCellFormatter().addStyleName(0, 45, "menu");
	     productoPedido.setText(1, 0, "ITEM");
		 productoPedido.setText(1, 5, "PRODUCTO");
		 productoPedido.setText(1, 10,"CANTIDAD");
		 productoPedido.setText(1, 20,"FECHA CUBRIMIENTO");
		 productoPedido.setText(1, 30,"CENTRO DE COSTOS");
		 productoPedido.setText(1, 40,"OBSERVACIONES");		
		 productoPedido.setText(1, 45,"SALDO");	
		 productoPedido.setWidget(2, 55, add);
		 productoPedido.setWidget(2, 5, BoxlistProductop);
		 productoPedido.setWidget(2, 10, cantidadBox);
		 productoPedido.setWidget(2, 20, BoxfechaCubrimiento);
		 productoPedido.setWidget(2, 30, BoxlistCentro);
		 productoPedido.setWidget(2, 40, observacionesBox);
		 productoPedido.setText(1, 75, "");
	
 }
 
public  void mostrarProductoPedido(){	
	
	productoPedido.setStyleName("productoPedido1");
	BoxlistProductop.setLimit(10);
	BoxlistCentro.setLimit(10);
     filitas();
     addPanel.add(pedidooo); 
 	 addPanel.add(pedidoBox);
	 addPanel.add(pedFecha);
	 addPanel.add(pedFecha1);
	 addPanel.add(fechaped);	 
	 addPanel1.add(dp);
	 addPanel1.add(BoxlistDepto);	 	
	 addPanel2.add(productoPedido);
	 
	 /*addPanel3.add(BoxlistProductop);
	 addPanel3.add(cantidadBox);
	 addPanel3.add(BoxfechaCubrimiento);
	 addPanel3.add(BoxlistCentro);
	 addPanel3.add(observacionesBox);	
	 addPanel3.add(saldoBox);
	 addPanel3.add(add);*/	
	 addPanel4.add(eliminarProductoPedido);
	 addPanel4.add(buscarProductoPedido);
	 addPanel4.add(limpiar);	
	 addPanel4.add(eliminarPedidosButton);	
	 mainPanel.add(addPanel);
	 mainPanel.add(addPanel1);
	 mainPanel.add(addPanel2);
	 mainPanel.add(addPanel3);
	 mainPanel.add(addPanel4);
	 mainPanel.add(addPanel5);	
	 BoxfechaCubrimiento.setEnabled(false);
	 cargarCentross();
	 cargarProductoss();	
	 cargarDepartamento1();	
	 Date d= new Date();
	 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");
	 String fechaC=fmtDate.format(d);	 
	 fechaped.setText(fechaC);
	 fechaped.setEnabled(false); 	
	 
	 add.setStyleName("add");
	 pedidooo.setStyleName("pedidooo");
 	 pedidoBox.setStyleName("pedidoBox");
	 pedFecha.setStyleName("pedFecha");
	 pedFecha1.setStyleName("pedFecha1");
	 fechaped.setStyleName("fechaped");
	 dp.setStyleName("dp");
	 BoxfechaCubrimiento.setStyleName("BoxfechaCubrimiento");
	 BoxlistDepto.setStyleName("BoxlistDepto"); 	
	 productoPedido.setStyleName("productoPedido");	
	 BoxlistProductop.setStyleName("BoxlistProductop");
	 cantidadBox.setStyleName("cantidadBox");
	 BoxlistCentro.setStyleName("BoxlistCentro");
	 observacionesBox.setStyleName("observacionesBox");
	 eliminarProductoPedido.setStyleName("eliminarProductoPedido");
	 buscarProductoPedido.setStyleName("buscarProductoPedido");
	 limpiar.setStyleName("limpiar");	
	 eliminarPedidosButton.setStyleName("eliminarPedidosButton");	 
	 
	 
	 RootPanel.get("p").add(mainPanel);
	 
	 eliminarPedidosButton.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			eliminarPedido();
		}
	});
	 	
	
	 add.addClickHandler(new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			//addPedidoPro();
			validarProducto();
			
		}
	});	  
	 
	 buscarProductoPedido.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			gurad();
			
		}
	});
	 
	 eliminarProductoPedido.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			consultarListas();
		}
	});
	
	 
	 borrarTodo.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			borrarTodo();
		
		}
	});
		 
	 
	 limpiar.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
		productoPedido.removeAllRows();
        filitas();
        pedidoBox.setText("");
       	BoxlistProductop.setText("");
   	    cantidadBox.setText("");    	
   	    BoxlistCentro.setText("");
   	    observacionesBox.setText("");	
   	    pedidoBox.setEnabled(true);
   	    BoxlistDepto.setEnabled(true);
   	    fechaped.setText("");
   	    BoxfechaCubrimiento.setText("");
   	    BoxlistDepto.setItemText(0, "PLANTACION");
   	    BoxlistDepto.setItemText(1, "EXTRACTORA");
   	    
   	    int jj=0;
   	    int h=0;
		}
	});	 
	 } 


private  void cargarDepartamento1(){
	  dptoService.cargarDepartamento(new AsyncCallback<ArrayList<Departamento>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("error  al cargar lista de departamento ");
		}
		
		@Override
		public void onSuccess(ArrayList<Departamento> result) {
			// TODO Auto-generated method stub			
			displayDpto1(result);
		}
	});
	  
}

private  void  displayDpto1(List<Departamento>dpto){
	for (Departamento d:dpto){			   
		BoxlistDepto.addItem(d.getNomDpto());			
	}  		
 }

private  void  mostrardept(int  h){
	BoxlistDepto.getItemText(h);
}

private void eliminarPedido(){
	String pedido= pedidoBox.getText().toUpperCase().trim();
	if(pedido==""){
		Window.alert("Porfavor llenar el campo del  pedido a  eliminar");
	}else{
		if(Window.confirm("Esta  seguro que desea  eliminar el pedido \nRecuerde que una vez eliminado el  pedido no se podra recuperar")==true){
			eliminarPedido(pedido);
		}else{
			pedidoBox.setText("");
		}
	}
	
}

private  void eliminarPedido(String pedido){
	productopedidoService.elminarProductoPedido(pedido, new AsyncCallback<Void>() {
		
		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("EL PEDIDO  FUE ELIMINADO");
			pedidoBox.setText("");
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("NO SE  LOGRO ELIMINAR EL PRODUCTO PORFAVOR INGRESAR  BIEN EL CODIGO");
		}
	});
}

private void editarPed(int m){ 
	
	 final String pro=BoxlistProductop.getText().toUpperCase().trim();
	 final String c= cantidadBox.getText().toUpperCase().trim();			 
	 final double cant= Double.parseDouble(c); 
	 final String  cc=BoxlistCentro.getText().toUpperCase().trim();
	 final String obs= observacionesBox.getText().toUpperCase().trim();  	  
	 Date fu=new Date();
     DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");		
	 String fechaC=fmtDate.format(fu);	
	 int p=0;
	 
	   if(pro.equalsIgnoreCase("")|| pro==null){ 		  
			Window.alert("porfavor llene los campos que de editacion");
			BoxlistProductop.setFocus(true);
			
	   }else{
		     productoPedido.setText(m, 5,pro);
			 productoPedido.setText(m, 10,c);
			 productoPedido.setText(m, 20,fechaC);
		     productoPedido.setText(m, 30,cc);
			 productoPedido.setText(m, 40,obs);			   
	   }
						
		
	
}

public  void act(){
	mostrarProductoPedido();
}

public  void pasar(String pe){
	 // Window.alert("pe llego con: "+pe);
	  String p=pe;
	  pedidoBox.setText("llegue-"+p);
}

private   void borrarTodo(){
	 final String codigoPedido=pedidoBox.getText().toUpperCase().trim();
	 borrarTodo(codigoPedido);
}

private  void  borrarTodo(String codigoPedido){
	productopedidoService.elminarProductoPedido(codigoPedido, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se  pudo eliminar");
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("si elimino de  manera exitosa");
		}		
	});	 
}

private  void consultarListas(){
	 pedidoBox.setEnabled(false);
	 BoxlistDepto.setEnabled(false);
	 final String codigoPedido=pedidoBox.getText().toUpperCase().trim();
	 consultarListas(codigoPedido);	 
} 

int j=2; 
private  void  consultarListas(String codigoPedido){	
	
	productopedidoService.cargarProductoPedido(codigoPedido,new AsyncCallback<ArrayList<ProductoPedido>>() {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no  funciono");
		}
		
		@Override
		public void onSuccess(ArrayList<ProductoPedido> result) {
			// TODO Auto-generated method stub
			//Window.alert("funciono :D"+ result.size());
			//Window.alert("poscion 0: "+ result.get(0).getProducto());

			displayproped(result);
		}
		
	});
}
private  void  displayproped(List<ProductoPedido>c){
	
	//Window.alert("entro por aqui");
	int o=0;
	for (ProductoPedido cc:c){		
		//Window.alert("esto es o"+o);
		//Window.alert("el tamano es"+cc.getProducto().size());		 
			
		 for (int  i=0; i<cc.getProducto().size(); i++){
			// Window.alert("entro a esta famoso ciclo");
			 //Window.alert("el tamano de nuevo es"+cc.getProducto().size());
			 //Window.alert("jum"+i);
			 final Button edit= new Button("EDITAR");
			 int p=i+2;
			 edit.setTitle(""+p);
			 final Button eli= new Button("ELIMINAR");
			 eli.setTitle(""+p);
			 edit.setStyleName("editar");
			 eli.setStyleName("eliminar");
			 
					edit.addClickHandler(new ClickHandler() {											
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub							
							int id=Integer.parseInt(edit.getTitle());
							Window.alert("el numero es"+id);
							editarPed(id);
						}
					});
					
					eli.addClickHandler(new ClickHandler() {						
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub	
							
						    int p=Integer.parseInt(eli.getTitle());
						   // Window.alert("la  fila a eliminar es: "+p);
							productoPedido.removeRow(p);						
							organizar();									
						
						
						}
					});
					//Window.alert("i es en la consulta");
					
					 productoPedido.getCellFormatter().addStyleName(i+2, 0, "celdas");
                     productoPedido.getCellFormatter().addStyleName(i+2, 5, "celdas");
                     productoPedido.getCellFormatter().addStyleName(i+2, 10, "celdas");
                     productoPedido.getCellFormatter().addStyleName(i+2, 20, "celdas");
                     productoPedido.getCellFormatter().addStyleName(i+2, 30, "celdas");
                     productoPedido.getCellFormatter().addStyleName(i+2, 40, "celdas");
                     productoPedido.getCellFormatter().addStyleName(i+2, 45, "celdas");
			 productoPedido.setText(i+2, 0,i+1+"");		
			 productoPedido.setText(i+2, 5,cc.getProducto().get(i));
			 productoPedido.setText(i+2, 10,cc.getCantidadProducto().get(i)+"");			 
			 final Date fee = cc.getFechaCubrimiento().get(i);
			 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");		
			 String fechaC=fmtDate.format(fee);			
			 productoPedido.setText(i+2, 20,fechaC);
			 productoPedido.setText(i+2, 30,cc.getCentro().get(i));
			 productoPedido.setText(i+2, 40,cc.getObservaciones().get(i));	
			 productoPedido.setWidget(i+2, 60,edit);
			 productoPedido.setWidget(i+2, 65, eli);		 
			 productoPedido.setWidget(i+3, 55, add);
			 productoPedido.setWidget(i+3, 5, BoxlistProductop);
			 productoPedido.setWidget(i+3, 10, cantidadBox);
			 productoPedido.setWidget(i+3, 20, BoxfechaCubrimiento);
			 productoPedido.setWidget(i+3, 30, BoxlistCentro);
			 productoPedido.setWidget(i+3, 40, observacionesBox);
			
			// Window.alert("el departamento es: "+cc.getDepartamento());
		if(cc.getDepartamento().equalsIgnoreCase("PLANTACION")){
			BoxlistDepto.setItemText(0, "PLANTACION");
			BoxlistDepto.setItemText(1, "EXTRACTORA");
		}
		if(cc.getDepartamento().equalsIgnoreCase("EXTRACTORA")){
			BoxlistDepto.setItemText(0, "EXTRACTORA");
			BoxlistDepto.setItemText(1, "PLANTACION");
		}
			
			
			 
			 final int k=i+2;
			 String producto=productoPedido.getText(i+2, 5);
			  
				productoService.cargarProductico(k,producto, new AsyncCallback<ArrayList<ProductoBase>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("no encontro el saldo del producto");
					}

					@Override
					public void onSuccess(ArrayList<ProductoBase> result) {
						// TODO Auto-generated method stub			 
						
						 productoPedido.setText(k, 45,  result.get(0).getCantidadInventariado()+"");
					}
					
				});
		 }	
		 
			
		 pedidoBox.setText(cc.getCodigoPedido());
		 final Date fePe = cc.getFechaCubrimiento().get(2);
		 DateTimeFormat fmtDate1=DateTimeFormat.getFormat("dd/MM/yyyy");		
		 String fePed=fmtDate1.format(fePe);	
		 fechaped.setText(fePed);
		
		
	}  		
 } 



private void organizar(){
	
	//Window.alert("entro uju");
	
	for(int m=0;m<productoPedido.getRowCount()-3; m++){	

		//Window.alert("m es: "+m);
		//Window.alert("tamano es:  "+ productoPedido.getRowCount());		
		
		final Button edit = new Button("EDITAR");
		final Button eli = new Button("ELIMINAR");
		int p=m+2;
		int q=m+1;
	    edit.setTitle(""+p);
	    eli.setTitle(""+p);
	    edit.setStyleName("editar");
		eli.setStyleName("eliminar");
	    productoPedido.setText(p,0,q+"");
	    productoPedido.setWidget(p,60,edit);
	    productoPedido.setWidget(p,65,eli);
	    
	    eli.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				int t=Integer.parseInt(eli.getTitle());
				productoPedido.removeRow(t);				
				organizar();
			}
		});
	    
	    edit.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				int t=Integer.parseInt(edit.getTitle());
			    editarPed(t);
			}
		});
	    
	}
	
	
}

private  void cargarCentross(){
	 centroService.cargarCentroCostos(new AsyncCallback<ArrayList<CentroCostos>>() {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("error al cargar centros pedidos");
		}

		@Override
		public void onSuccess(ArrayList<CentroCostos> result) {
			// TODO Auto-generated method stub
			displayCentross(result);
		}
	});
} 
private  void  displayCentross(List<CentroCostos>c){
		for (CentroCostos cc:c){			   
			cen.add(cc.getNombreCosto());
			
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

private  void  displayProductoss(List<ProductoBase>p){
		for (ProductoBase pp:p){			   
			pro.add(pp.getDescripcion());
		}  		
	  }  

private void validarProducto(){
	
	 
	 productoService.cargarProducto(new AsyncCallback<ArrayList<ProductoBase>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no logro  cargar los productos");
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
	 String po="";
	 
		for (ProductoBase pp:p){
			
			
		if(pp.getDescripcion().equalsIgnoreCase(pro)){		
			     po="hay algo";			     
				}	
		} 
		
		if(po.equalsIgnoreCase("")|| po==null){
			Window.alert("lo sentimos pero el producto que ingreso no esta inventariado");
			
		}else{
			centroService.cargarCentroCostos(new AsyncCallback<ArrayList<CentroCostos>>() {
				
				@Override
				public void onSuccess(ArrayList<CentroCostos> result) {
					// TODO Auto-generated method stub
					displayCC(result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub					
					Window.alert("No se pudo cargar centro de costo");
				}
			});
			
			
		}
	  } 

private  void  displayCC(List<CentroCostos>p){
	 
	 final String centro= BoxlistCentro.getText().toUpperCase().trim();
	 String po="";
	 
for (CentroCostos pp:p){
	 
		if(pp.getNombreCosto().equalsIgnoreCase(centro)){		
			     po="hay algo";			     
				}	
		}

if(po.equalsIgnoreCase("")|| po==null){
		Window.alert("El centro de costo no existe");
}else{
	 addPedidoPro();
	 }

}



private void addPedidoPro() { 
	 
	     int i=productoPedido.getRowCount();	     
	     //Window.alert("cantidad de filas"+i);
		 final String ped= pedidoBox.getText().toUpperCase().trim();
		 final String pro=BoxlistProductop.getText().toUpperCase().trim();
		 final String c= cantidadBox.getText().toUpperCase().trim();			 
		 final double cant= Double.parseDouble(c); 	 
		 final int l=BoxlistDepto.getSelectedIndex();
		 final String dep=BoxlistDepto.getItemText(l);		
		
		 
		 tipoPedidoService.cargartpd(new AsyncCallback<ArrayList<TipoPedidoDpto>>() {
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Window.alert("no  pudo  traer nada");				
				}
				
				@Override
				public void onSuccess(ArrayList<TipoPedidoDpto> result) {
					// TODO Auto-generated method stub				
					//mostrarTipoDpto(result);		
				 									
					String palabra="";
					 if(ped.length()==5){
						 for(int o=0; o<=2; o++){				 
							 
							 palabra=palabra+ped.charAt(o);
					 }
						
					 }
					 
					if (ped.length()==4){
						 for(int o=0; o<=1; o++){		 
					
							 palabra=palabra+ped.charAt(o);
					 }
					
					}
					int i=0;			
					for (TipoPedidoDpto un:result){						
						
						i=productoPedido.getRowCount();			  
						
						  if(palabra.equalsIgnoreCase(un.getCodigoPedido())&&  dep.equalsIgnoreCase(un.getCodigoDpto())){
							  
							 pedidoBox.setEnabled(false);
							 BoxlistDepto.setEnabled(false);
							 
							  int diasCubrimiento=un.getDiasCubrimiento();							     
							     Date fec=new  Date ();		
								 int f=fec.getDate()+ diasCubrimiento;		
								 Date fee= new  Date(fec.getYear(),fec.getMonth(),f);
								 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");
								 String fechaC=fmtDate.format(fee);								 
								 BoxfechaCubrimiento.setText(fechaC);													
								 
								 final String cc=BoxlistCentro.getText().toUpperCase().trim();
								 final String obs= observacionesBox.getText().toUpperCase().trim();				 
								 final Button edit= new Button("EDITAR");	
								 final Button eli= new Button("ELIMINAR");
								 int y=i-1;
								 edit.setStyleName("editar");
								 eli.setStyleName("eliminar");
								 edit.setTitle(""+y);
								 eli.setTitle(""+y);
								
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
												productoPedido.removeRow(p);			
											
													organizar();						
												
											
											
											}
										});
										
		                        int po=i-2;
		                       // Window.alert("po es: "+po);
		                             productoPedido.getCellFormatter().addStyleName(i-1, 0, "celdas");
		                             productoPedido.getCellFormatter().addStyleName(i-1, 5, "celdas");
		                             productoPedido.getCellFormatter().addStyleName(i-1, 10, "celdas");
		                             productoPedido.getCellFormatter().addStyleName(i-1, 20, "celdas");
		                             productoPedido.getCellFormatter().addStyleName(i-1, 30, "celdas");
		                             productoPedido.getCellFormatter().addStyleName(i-1, 40, "celdas");
		                             productoPedido.getCellFormatter().addStyleName(i-1, 45, "celdas");
		                             
									 productoPedido.setText(i-1, 0,po+"");	
									 productoPedido.setText(i-1, 5, pro);
									 productoPedido.setText(i-1, 10, cant+"");
									 productoPedido.setText(i-1, 20, fechaC);
									 productoPedido.setText(i-1, 30, cc);
									 productoPedido.setText(i-1, 40, obs);
									 productoPedido.setWidget(i-1, 60, edit);
									 productoPedido.setWidget(i-1, 65, eli);
									 productoPedido.setWidget(i, 55, add);
									 productoPedido.setWidget(i, 5,  BoxlistProductop);
									 productoPedido.setWidget(i, 10, cantidadBox);
									 productoPedido.setWidget(i, 20, BoxfechaCubrimiento);
									 productoPedido.setWidget(i, 30, BoxlistCentro);
									 productoPedido.setWidget(i, 40, observacionesBox);
									
									 									
									 
								 i++;
							
								
						  }						 
						 
						  }	
					
			

					 if(i==2){
						  
						   Window.alert("EL DEPARTAMENTO QUE  SELECCIONO NO PERTENECE AL TIPO DE PEDIDO INGRESADO");
				           }					 
				}			 
			});	 
				 
	  } 


int jj=0;
private  void gurad(){
	
	final String pedi=pedidoBox.getText().toUpperCase().trim();
jj=0;
	productopedidoService.buscarProductoPedido(pedi, new AsyncCallback<ProductoPedido>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
		    	
		}

		@Override
		public void onSuccess(ProductoPedido result) {
			// TODO Auto-generated method stub
			jj=0;
		}
	});
	
	//Window.alert("esto tieene la tabla "+productoPedido.getRowCount());
	//Window.alert("esto tiene jj \n"+jj);
	
	ArrayList<String>cen=new ArrayList<String>();
	ArrayList<Double>cantidad=new ArrayList<Double>();
	ArrayList<String>observaciones=new ArrayList<String>();
	ArrayList<String>producto=new ArrayList<String>();	
	ArrayList<Date>fe= new ArrayList<Date>();
	ArrayList<Date>fePed= new ArrayList<Date>();
	/*final String fecho=pedFecha1.getText();
	DateTimeFormat fmtDate1=DateTimeFormat.getFormat("dd/MM/yyyy");
	Date  fechoo=fmtDate1.parse(fecho);*/	 
	 
	final int l=BoxlistDepto.getSelectedIndex();
	final String dep=BoxlistDepto.getItemText(l);	
	
	 
	 for(int k=2; k<=productoPedido.getRowCount()-2; k++){	
		     //Window.alert("el valor de tamano"+productoPedido.getRowCount());
			 //Window.alert("el valor de k"+k);
			 //Window.alert("el valor de jj"+jj);
			 
				cen.add(jj, productoPedido.getText(k,30));
				 
				 String c=productoPedido.getText(k, 10);
				 double cant=Double.parseDouble(c);			 
				 cantidad.add(jj,cant);
				 
				 observaciones.add(jj,productoPedido.getText(k,40));
				 
				 String f= productoPedido.getText(k, 20);
				 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");
				 Date  fecha=fmtDate.parse(f);
				 
				 fe.add(jj, fecha);			
				 
				 Date fu=new Date();
				 DateTimeFormat fmtDate2=DateTimeFormat.getFormat("dd/MM/yyyy");	
				 String feP=fmtDate2.format(fu);
				 fechaped.setText(feP);
				 fePed.add(jj, fu);
				 
				 producto.add(jj,productoPedido.getText(k,5));	 			
				 
				 if(jj==productoPedido.getRowCount()-4){			 
				
					 Window.alert("se guardo satisfactoriamente");
				     gurad(pedi,producto,cantidad,fe,cen,observaciones,dep,fePed);
					 Window.alert("Termino el ciclo for :p"+"\n Pedido: "+pedi+"\n Producto: "+producto+"\n Cantidad: "+cantidad+"\n Fecha Cubrimiento: "+fe+"\n Centro: "+cen+"\n Observacion: "+observaciones+"\n Departamento: "+dep+"\n Fecha Pedido"+fePed+"");
					 
					 
				 }				 
				 jj++;		 
		 } 
} 


private  void gurad(String codigoPedido, ArrayList<String> producto,
			ArrayList<Double> cantidadProducto,
			ArrayList<Date> fechaCubrimiento, ArrayList<String> centro,
			ArrayList<String> observaciones, String departamento,
			ArrayList<Date>fePed){
	 
	 productopedidoService.addProductoPedido(codigoPedido, producto, cantidadProducto, fechaCubrimiento, centro, observaciones, departamento, fePed, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se logro almacenar");
		}
		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub		
			    
			    productoPedido.removeAllRows();
	            filitas();
	            pedidoBox.setText("");
	        	BoxlistProductop.setText("");
	        	BoxfechaCubrimiento.setText("");
	    	    cantidadBox.setText("");    	
	    	    BoxlistCentro.setText("");
	    	    observacionesBox.setText("");	
	    	    pedidoBox.setEnabled(true);
	    	    BoxlistDepto.setEnabled(true);
		}
	});
	 
} 


}




