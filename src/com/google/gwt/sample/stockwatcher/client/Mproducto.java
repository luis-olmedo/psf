package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.stockwatcher.server.ProductoBase;
import com.google.gwt.sample.stockwatcher.server.UndConsumo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Mproducto implements EntryPoint {	 
	 
	  private HorizontalPanel addPanel1 = new HorizontalPanel();
	  private HorizontalPanel addPanel2 = new HorizontalPanel();
	  private HorizontalPanel addPanel3 = new HorizontalPanel(); 
	  private HorizontalPanel addPanel4 = new HorizontalPanel();	  
	  private final ProductoBaseServiceAsync productoService=GWT.create(ProductoBaseService.class); 
	  private  final UndConsumoServiceAsync undService=GWT.create(UndConsumoService.class);
	  private Label l1= new Label("Codigo: ");
	  private TextBox Boxproducto= new TextBox();  
	  private Label l2= new Label("Descripcion: ");
	  private TextBox Boxdesc= new TextBox();
	  private Label l3= new Label("Cantidad: ");
	  private TextBox Boxcantidad= new TextBox();
	  private Label l4= new Label("Precio: ");
	  private TextBox Boxprecio= new TextBox();
	  private Label  l5= new Label("Unidad de Consumo: ");
	  private ListBox BoxlistUnd= new ListBox();
	  private Button crearProductoBoton= new Button("Crear");
	  private Button eliminarProducto= new Button("Eliminar");
	  private Button modificarProducto= new Button("Modificar");
	  private Button buscarProducto= new Button("Buscar");
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub		 
			addPanel1.add(l1);
			addPanel1.add(Boxproducto);
			addPanel2.add(l2);
			addPanel2.add(Boxdesc);
			addPanel2.add(l3);
			addPanel2.add(Boxcantidad);
			addPanel3.add(l4);
			addPanel3.add(Boxprecio);
			addPanel3.add(l5);
			addPanel3.add(BoxlistUnd);
			addPanel4.add(crearProductoBoton);
			addPanel4.add(modificarProducto);
		    addPanel4.add(eliminarProducto);
			addPanel4.add(buscarProducto);	


			l1.setStyleName("l1");
			Boxproducto.setStyleName("Boxproducto");
			l2.setStyleName("l2");
		    Boxdesc.setStyleName("Boxdesc");
			l3.setStyleName("l3");
			Boxcantidad.setStyleName("Boxcantidad");
			l4.setStyleName("l4");
			Boxprecio.setStyleName("Boxprecio");
			l5.setStyleName("l5");
			BoxlistUnd.setStyleName("BoxlistUnd");
			crearProductoBoton.setStyleName("crearProductoBoton");
			modificarProducto.setStyleName("modificarProducto");
		    eliminarProducto.setStyleName(" eliminarProducto");
			buscarProducto.setStyleName("buscarProducto");
			
			RootPanel.get("pro").add(addPanel1);	
			RootPanel.get("pro1").add(addPanel2);
			RootPanel.get("pro2").add(addPanel3);
			RootPanel.get("pro3").add(addPanel4);
			cargarLista();
			
			 
			  
			crearProductoBoton.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					crearProducto();
									
				}
			});
		  modificarProducto.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				modificarProductoBase();
			}
		});
		  
		  eliminarProducto.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			 eliminarProductoBase();	
			}
		});
		  
		  buscarProducto.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				buscarProductoPedido();
			}
		});
	  }
	  
	  private  void buscarProductoPedido(){
		  String producto=Boxproducto.getText().toUpperCase().trim();
		  buscarProductoPedido(producto);
	  }

	  private  void buscarProductoPedido(String codigo){
		  productoService.buscarProductoBase(codigo,new AsyncCallback<ProductoBase>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se encontro");
			}

			@Override
			public void onSuccess(ProductoBase result) {
				// TODO Auto-generated method stub
				
				Boxdesc.setText(result.getDescripcion());
				Boxcantidad.setText(result.getCantidadInventariado()+"");
				Boxprecio.setText(result.getPrecio()+"");
				BoxlistUnd.setItemText(0, result.getIdUnd());		
					
				
			}	
			
			  
		});
	  }
	  private  void eliminarProductoBase(){
		  String producto=Boxproducto.getText().toUpperCase().trim();
		  eliminarProductoBase(producto);
	  }
	   
	  private  void   eliminarProductoBase(String producto){
		  productoService.elminarProductoBase(producto, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no selogro encontrar el prodcuto");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se elimino el producto");
				Boxproducto.setText("");
				Boxdesc.setText("");
				Boxcantidad.setText("");
				Boxprecio.setText("");
			}
			  
		});
	  }
	  private  void modificarProductoBase(){
		  String producto=Boxproducto.getText().toUpperCase().trim();
		  String descripcion=Boxdesc.getText().toUpperCase().trim();
		  String can=Boxcantidad.getText().toUpperCase().trim();
		  double cantidad=Double.parseDouble(can);
		  String pre=Boxprecio.getText().toUpperCase().trim();
		  double  precio=Double.parseDouble(pre);
		  final int i= BoxlistUnd.getSelectedIndex();
		  final String und=BoxlistUnd.getItemText(i);
		  modificarProductoBase(producto,descripcion,cantidad,precio,und);
	  }
	  
	  private  void modificarProductoBase(String codigoProducto,String descripcion,double cantidad,double precio,String idUnd){
		  productoService.modificarProductoBase(codigoProducto, descripcion, cantidad, precio, idUnd, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no  modifico ");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("modifico satisfactoriamente");
				Boxproducto.setText("");
				Boxdesc.setText("");
				Boxcantidad.setText("");
				Boxprecio.setText("");
			}
		});
	  }
	  
	  private void  crearProducto(){
		  
		  String producto=Boxproducto.getText().toUpperCase().trim();
		  String descripcion=Boxdesc.getText().toUpperCase().trim();
		  String can=Boxcantidad.getText().toUpperCase().trim();
		  double cantidad=Double.parseDouble(can);
		  String pre=Boxprecio.getText().toUpperCase().trim();
		  double  precio=Double.parseDouble(pre);
		  final int i= BoxlistUnd.getSelectedIndex();
		  final String und=BoxlistUnd.getItemText(i);
		  crearProducto(producto,descripcion,cantidad,precio,und);
	  }
	  
	  private  void crearProducto(String producto,String descripcion,double cantidad,double precio,String und){		  
		  productoService.addProductos(producto, descripcion, cantidad, precio, und, new AsyncCallback<Void>() {
			  
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no se pudo  guardar");
			}
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("se guardo  satisfactoriamente");
				Boxproducto.setText("");
				Boxdesc.setText("");
				Boxcantidad.setText("");
				Boxprecio.setText("");
			}		  
		});
	  }  
	  private  void  cargarLista(){
		  undService.cargarUnd(new AsyncCallback<ArrayList<UndConsumo>>() {

			  @Override
				public void onFailure(Throwable caught) {
					Window.alert("Hubo  un  problema  al  cargar  la  lista de  Unidades");			
				}

				@Override
				public void onSuccess(ArrayList<UndConsumo> result) {
					// TODO Auto-generated method stub				
					displayUnd(result);						
				
				}
			});
	  }
	  private  void  displayUnd(List<UndConsumo>und){
			for (UndConsumo un:und){	
			   BoxlistUnd.addItem(un.getIdUnd());	
			}  	
		  }

	}


