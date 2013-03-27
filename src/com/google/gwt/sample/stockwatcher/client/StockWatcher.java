package com.google.gwt.sample.stockwatcher.client;



import java.util.ArrayList;
import java.util.List;
import com.google.gwt.sample.stockwatcher.server.Bodega;
import com.google.gwt.sample.stockwatcher.server.CentroCostos;
import com.google.gwt.sample.stockwatcher.server.Departamento;
import com.google.gwt.sample.stockwatcher.server.Empresa;
import com.google.gwt.sample.stockwatcher.server.Exixtencias;
import com.google.gwt.sample.stockwatcher.server.LugarPedido;
import com.google.gwt.sample.stockwatcher.server.ProductoBase;
import com.google.gwt.sample.stockwatcher.server.ProductoPedido;
import com.google.gwt.sample.stockwatcher.server.TipoPedidoDpto;
import com.google.gwt.sample.stockwatcher.server.TipoUsuario;
import com.google.gwt.sample.stockwatcher.server.UndConsumo;
import com.google.gwt.sample.stockwatcher.server.Usuario;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;

import org.apache.jasper.tagplugins.jstl.core.Remove;

import sun.awt.HorizBagLayout;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;

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




public class StockWatcher implements EntryPoint {

  private VerticalPanel emprePanel= new VerticalPanel();
  private VerticalPanel mainPanel = new VerticalPanel(); 
  private HorizontalPanel addPanel = new HorizontalPanel();
  private HorizontalPanel addPanel1 = new HorizontalPanel();
  private HorizontalPanel addPanel2 = new HorizontalPanel();
  private HorizontalPanel addPanel3 = new HorizontalPanel(); 
  private HorizontalPanel addPanel4 = new HorizontalPanel(); 
  private HorizontalPanel addPanel5 = new HorizontalPanel();  
  private Button crearButon= new Button ("Crear"); 
  private ArrayList<Empresa> empresa=new ArrayList<Empresa>();
  private final UsuarioServiceAsync usuarioService =GWT.create(UsuarioService.class);
  private final TipoPedidoDptoServiceAsync tipoPedidoService=GWT.create(TipoPedidoDptoService.class);
  private final ProductoPedidoServiceAsync productopedidoService=GWT.create(ProductoPedidoService.class);
  private final ExistenciaServiceAsync existenciaService=GWT.create(ExistenciaService.class);
  private final ProductoBaseServiceAsync productoService=GWT.create(ProductoBaseService.class); 
  private final BodegaServiceAsync bodegaService=GWT.create(BodegaService.class);
  private final EmpresaServiceAsync empresaService = GWT.create(EmpresaService.class);
  private final CentroCostoServiceAsync centroService=GWT.create(CentroCostoService.class);
  private final DepartamentoServiceAsync dptoService=GWT.create(DepartamentoService.class);
  private  final LugarPedidoServiceAsync lugarService=GWT.create(LugarPedidoService.class);
  private  final UndConsumoServiceAsync undService=GWT.create(UndConsumoService.class);
  private final TipoUsuarioServiceAsync tipoService=GWT.create(TipoUsuarioService.class);
  private Button apboton = new Button("IR EMPRESAS");
  private Button apboton1 = new Button("IR TIPOS USUARIOS");
  private Button apboton2= new Button("IR CENTRO DE COSTOS");
  private Button dptBoton= new Button("IR DEPARTAMENTOS");
  private Button lugarBoton= new Button("IR LUGAR PEDIDO");
  private Button undconBoton= new Button("IR UNIDAD CONSUMO");
  private Button bodegaBoton= new Button("IR BODEGA");
  private Button productoBoton= new Button("IR PRODUCTO BASE");
  private Button existenciasBoton= new Button("IR EXISTENCIAS");
  private Button pedidoproductoBoton= new Button("IR PRODUCTO PEDIDO");
  private Button usuarioBoton= new Button("IR USUARIOS");

  private Button tipopedidodptpBoton=new Button("IR TIPO PEDIDO DPTO");
  private Button busBoton = new Button("Buscar");

  private LoginInfo loginInfo = null;
  private VerticalPanel loginPanel = new VerticalPanel();
  private Label loginLabel = new Label("Acceder a  su cuenta  de google para utilizar la aplicacion PSFSERVICE");
  private Anchor signInLink = new Anchor("Iniciar Sesión");
  private Anchor signOutLink = new Anchor("Salir");
  
  private Label codigolabel= new Label("Codigo: ");
  private TextBox codigoBox= new TextBox();
  private Label nombrelabel= new Label("Empresa: ");
  private TextBox nombreBox= new TextBox();
  private Button eliminarBoton= new Button("Eliminar");
  private Button modificarEmpresa = new Button("modificar");
  private Button todaEmpresa = new Button("Traer Empresas");
  
  private Label tipolabel= new Label("Codigo: ");
  private TextBox tipoBox= new TextBox();  
  private Label usulabel= new Label("Tipo Usuario: ");
  private TextBox usuBox= new TextBox();
  private Button addTuBoton= new Button("Crear Tipo Usuario");  
  private Button modificarTipoUsu=new Button("Modificar");
  private Button eliminarTipoUsu=new Button("Eliminar");  
  private Button irMenuBoton = new Button("Ir a Menu");    
  private Button buscarTipo= new Button("Buscar");
  
  private Label codlabel= new Label("Codigo: ");
  private TextBox codBox= new TextBox();  
  private Label costoabel= new Label("Centro de Costos: ");
  private TextBox costoBox= new TextBox();
  private Button costoBoton= new Button("Crear"); 
  private Button modificarCentro= new Button("Modificar");
  private Button eliminarCentro= new Button("Eliminar");
  private Button buscarCosto= new Button("Buscar");
  
  
  private Label codeptlabel= new Label("Codigo: ");
  private TextBox codeptBox= new TextBox();  
  private Label deptabel= new Label("Departamento: ");
  private TextBox deptBox= new TextBox();
  private Button crearDptBoton= new Button("Crear Departamento");
  private Button modificarDepto= new Button("Modificar");
  private Button eliminarDepto= new Button("Eliminar"); 
  private Button buscarDepto= new Button("Buscar");
  
  
  private Label idundlabel= new Label("ID Unidad: ");
  private TextBox idundBox= new TextBox();  
  private Label unidadbel= new Label("Unidad Consumo: ");
  private TextBox unidadBox= new TextBox();
  private Button crearundBoton= new Button("Crear Unidad");
  private Button eliminarUnd= new Button("Eliminar");
  private Button modificarUnd= new Button("modificar");
  private Button buscarUnd= new Button("Buscar");
  
  
  private Label codlugarlabel= new Label("Codigo: ");
  private TextBox codlugarBox= new TextBox();  
  private Label lugarlabel= new Label("Lugar: ");
  private TextBox lugtarBox= new TextBox();
  private Button crearlugarBoton= new Button("Crear");
  private Button eliminarLugar= new Button("Eliminar");
  private Button modificarLugar= new Button("Modificar");
  private Button buscarLugar= new Button("Buscar");  
  
  private Label codBodegalabel= new Label("Codigo: ");
  private TextBox codBodegaBox= new TextBox();  
  private Label bodegalabel= new Label("Bodega: ");
  private TextBox bodegaBox= new TextBox();
  private Label  empresalabel= new Label("Empresa: ");
  private ListBox empresaBox= new ListBox();
  private Button crearBodegaBoton= new Button("Crear");
  private Button eliminarBodega= new Button("Eliminar");
  private Button modificarBodega= new Button("Modificar");
  private Button buscarBodega= new Button("Buscar");
  private TextBox pruebabox= new TextBox();  
  
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
    
  private Label ll1= new Label("Bodega: ");
  private ListBox BoxlistBodega= new ListBox();
  private Label ll2= new Label("Producto: ");
  MultiWordSuggestOracle oraculo = new MultiWordSuggestOracle ();  
  private SuggestBox BoxlistProducto= new SuggestBox(oraculo);
  private Label ll3= new Label("Fecha: ");
  private DateBox BoxFecha= new DateBox();  
  private Label ll4= new Label("Cantidad: ");
  
  private  FlexTable existenciaPro = new FlexTable();
  private  Button agregarExistencia= new  Button("Agregar Existencia");
  private TextBox Boxcantidadexi= new TextBox();  
  private Button crearExistenciaBoton= new Button("Guardar");
  private Button eliminarExistencia= new Button("Eliminar");
  private Button modificarExistencia= new Button("Modificar");
  private Button buscarExistencia= new Button("Buscar");
    
 
private  FlexTable productoPedido = new FlexTable();
private  Button add= new  Button("Add");
private  TextBox pedidoBox= new TextBox();
private  TextBox cantidadBox= new TextBox();
private  TextBox observacionesBox= new TextBox();
MultiWordSuggestOracle cen = new MultiWordSuggestOracle ();  
private SuggestBox BoxlistCentro= new SuggestBox(cen) ;
MultiWordSuggestOracle pro = new MultiWordSuggestOracle ();  
private SuggestBox BoxlistProductop= new SuggestBox(pro) ;
private DateBox BoxfechaCubrimiento= new DateBox();
private Label  pedidooo= new Label("Pedido:");
private  Label pedFecha= new Label("Fecha: ");
private  Label pedFecha1= new Label();
private  Label dp = new Label("Departamento: ");
private ListBox BoxlistDepto= new ListBox();

private  Button eliminarProductoPedido=new Button("Consultar");
private Button buscarProductoPedido=new Button("Guardar");
private  Button borrarTodo=new Button("Cancelar Producto Pedido");
private  Button limpiar= new Button("Limpiar");

private Label pedidos= new Label("Pedidos ");
MultiWordSuggestOracle p = new MultiWordSuggestOracle ();  
private SuggestBox BoxlistPedidos= new SuggestBox(p) ;
private Label lugar= new Label("Lugar Pedido: ");
private ListBox BoxlistLugar= new ListBox();
private Label dpto= new Label("Departamentos: ");
private ListBox BoxlistDpto= new ListBox();
private Label empresas= new Label("Empresa ");
private ListBox BoxlistEmpresas= new ListBox();
private Label cubrimiento= new Label("Dias  de  Cubrimiento: ");
private  TextBox BoxCubrimiento= new TextBox();
private Button crearTipoPedidoBoton= new Button("Crear");
private Button eliminarTipoPedido= new Button("Eliminar");
private Button modificarTipoPedido= new Button("Modificar");
private Button buscarTipoPedido= new Button("Buscar");

private Label lempresa= new Label("Gestion de Empresas");
private Label ltipousario= new Label("Gestion de Tipo Usuario");
private Label lcentros= new Label("Gestion de Centro de Costos");
private Label ldepartamento= new Label("Gestion de Departamentos");
private Label lunidadconsumo= new Label("Gestion de Unidad de Consumo");
private Label llugarpedido= new Label("Gestion de LugarPedido");
private Label lbodega= new Label("Gestion de Bodega");
private Label lproductobase= new Label("Gestion de Productos ");

private Label lpedido= new Label("Gestion de Pedido");
private Label lusuario= new Label("Gestion de Usuario");
private Label lexistencias= new Label("Gestion de Existencias");
private Label ltipopedidodpto= new Label("Gestion de Pedidos por Departamentos");

private Label usu= new Label ("Usuario: ");
private Label usuario= new Label ();

private  Label  lusu= new Label("Correo: ");
private  TextBox  boxcorreo= new TextBox();
private  Label  lnombre= new Label ("Nombre: ");
private  TextBox boxnombre= new TextBox();
private  Label  ltipoUsu= new Label ("Tipo Usuario: ");
private CheckBox cbTipo1= new CheckBox("ADMINISTRADOR");
private CheckBox cbTipo2= new CheckBox("ALMACENISTA");
private CheckBox cbTipo3= new CheckBox("RECIBIDOR");


private Button crearUsuario=new Button("Crear");
private Button modificarUsuario=new Button("Modificar");
private Button eliminarUsuario=new Button("Eliminar");
private Button buscarUsuario=new Button("Buscar");


private Button eliminarPedidosButton = new Button("Eliminar");
private TextBox num= new TextBox();
private  TextBox  fechaped= new TextBox();
private  TextBox saldoBox=new TextBox();

private Button gestionPedido= new Button("Gestion Pedido");
private Button gestionConfiguracion= new Button("Gestiod de Configuracion");

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
	  addPanel.add(apboton);
	  addPanel.add(apboton1);
	  addPanel.add(apboton2);	
	  addPanel1.add(dptBoton);
	  addPanel1.add(lugarBoton);
	  addPanel1.add(undconBoton);
	  addPanel2.add(bodegaBoton);
	  addPanel2.add(productoBoton);
	  addPanel2.add(existenciasBoton);
	  addPanel2.add(pedidoproductoBoton);
	  addPanel2.add(tipopedidodptpBoton);
	  addPanel2.add(usuarioBoton);
	  addPanel3.add(usu);
	  addPanel3.add(usuario);
	  mainPanel.add(addPanel);
	  mainPanel.add(addPanel1);
	  mainPanel.add(addPanel2);
	  mainPanel.add(addPanel3); 
	  apboton.setVisible(false);
	  apboton1.setVisible(false);
	  apboton2.setVisible(false);	
	  dptBoton.setVisible(false);
	  lugarBoton.setVisible(false);
	  undconBoton.setVisible(false);
	  bodegaBoton.setVisible(false);
	  productoBoton.setVisible(false);
	  existenciasBoton.setVisible(false);
	  pedidoproductoBoton.setVisible(false);
	  tipopedidodptpBoton.setVisible(false);
	  usuarioBoton.setVisible(false);
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
	  apboton1.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				apboton.setVisible(false);
				apboton1.setVisible(false);
				apboton2.setVisible(false);
				irMenuBoton.setVisible(false);				
				lugarBoton.setVisible(false);
				dptBoton.setVisible(false);
				undconBoton.setVisible(false);
				bodegaBoton.setVisible(false);
				productoBoton.setVisible(false);
				existenciasBoton.setVisible(false);
				pedidoproductoBoton.setVisible(false);
				tipopedidodptpBoton.setVisible(false);
				usuarioBoton.setVisible(false);
				mostrarTipoUsuario();			
			}
		});
	  
	  apboton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				apboton.setVisible(false);
				apboton1.setVisible(false);
				apboton2.setVisible(false);
				irMenuBoton.setVisible(false);				
				lugarBoton.setVisible(false);
				dptBoton.setVisible(false);
				undconBoton.setVisible(false);
				bodegaBoton.setVisible(false);
				productoBoton.setVisible(false);
				existenciasBoton.setVisible(false);
				pedidoproductoBoton.setVisible(false);
				tipopedidodptpBoton.setVisible(false);	
				usuarioBoton.setVisible(false);
				mostrarEmpresa();			
			}
		});
	  
	  apboton2.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				apboton.setVisible(false);
				apboton1.setVisible(false);
				apboton2.setVisible(false);
				irMenuBoton.setVisible(false);				
				lugarBoton.setVisible(false);
				dptBoton.setVisible(false);
				undconBoton.setVisible(false);
				bodegaBoton.setVisible(false);
				productoBoton.setVisible(false);
				existenciasBoton.setVisible(false);
				pedidoproductoBoton.setVisible(false);
				tipopedidodptpBoton.setVisible(false);
				usuarioBoton.setVisible(false);
				mostrarCentroCostos();			
			}
		});
	  
	 dptBoton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				apboton.setVisible(false);
				apboton1.setVisible(false);
				apboton2.setVisible(false);
				irMenuBoton.setVisible(false);				
				lugarBoton.setVisible(false);
				dptBoton.setVisible(false);
				undconBoton.setVisible(false);
				bodegaBoton.setVisible(false);
				productoBoton.setVisible(false);
				existenciasBoton.setVisible(false);
				pedidoproductoBoton.setVisible(false);
				tipopedidodptpBoton.setVisible(false);
				usuarioBoton.setVisible(false);
				mostrarDepartamento();			
			}
		});
	  
	  lugarBoton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				apboton.setVisible(false);
				apboton1.setVisible(false);
				apboton2.setVisible(false);
				irMenuBoton.setVisible(false);				
				lugarBoton.setVisible(false);
				dptBoton.setVisible(false);
				undconBoton.setVisible(false);
				bodegaBoton.setVisible(false);
				productoBoton.setVisible(false);
				existenciasBoton.setVisible(false);
				pedidoproductoBoton.setVisible(false);
				tipopedidodptpBoton.setVisible(false);
				usuarioBoton.setVisible(false);
				mostrarLugar();		
			}
		});
	  
	  undconBoton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				apboton.setVisible(false);
				apboton1.setVisible(false);
				apboton2.setVisible(false);
				irMenuBoton.setVisible(false);				
				lugarBoton.setVisible(false);
				dptBoton.setVisible(false);
				undconBoton.setVisible(false);
				bodegaBoton.setVisible(false);
				productoBoton.setVisible(false);
				existenciasBoton.setVisible(false);
				pedidoproductoBoton.setVisible(false);
                tipopedidodptpBoton.setVisible(false);
                usuarioBoton.setVisible(false);
				mostrarUndConsumo();		
			}
		});
	  bodegaBoton.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			apboton.setVisible(false);
			apboton1.setVisible(false);
			apboton2.setVisible(false);
			irMenuBoton.setVisible(false);				
			lugarBoton.setVisible(false);
			dptBoton.setVisible(false);
			undconBoton.setVisible(false);
			bodegaBoton.setVisible(false);
			productoBoton.setVisible(false);
			existenciasBoton.setVisible(false);
			pedidoproductoBoton.setVisible(false);
			tipopedidodptpBoton.setVisible(false);
			usuarioBoton.setVisible(false);
			mostrarBodega();			
		}
		
		
	});
	  
	  productoBoton.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub			
			apboton.setVisible(false);
			apboton1.setVisible(false);
			apboton2.setVisible(false);
			irMenuBoton.setVisible(false);				
			lugarBoton.setVisible(false);
			dptBoton.setVisible(false);
			undconBoton.setVisible(false);
			bodegaBoton.setVisible(false);
			productoBoton.setVisible(false);
			existenciasBoton.setVisible(false);
			pedidoproductoBoton.setVisible(false);
			tipopedidodptpBoton.setVisible(false);
			usuarioBoton.setVisible(false);
		    mostrarProducto();
			
		}
	});
	  
	 existenciasBoton.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			apboton.setVisible(false);
			apboton1.setVisible(false);
			apboton2.setVisible(false);
			irMenuBoton.setVisible(false);				
			lugarBoton.setVisible(false);
			dptBoton.setVisible(false);
			undconBoton.setVisible(false);
			bodegaBoton.setVisible(false);
			productoBoton.setVisible(false);
			existenciasBoton.setVisible(false);
			pedidoproductoBoton.setVisible(false);
			tipopedidodptpBoton.setVisible(false);
			usuarioBoton.setVisible(false);
			mostrarExistencias();
		}
	});
	 
	 pedidoproductoBoton.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			apboton.setVisible(false);
			apboton1.setVisible(false);
			apboton2.setVisible(false);
			irMenuBoton.setVisible(false);				
			lugarBoton.setVisible(false);
			dptBoton.setVisible(false);
			undconBoton.setVisible(false);
			bodegaBoton.setVisible(false);
			productoBoton.setVisible(false);
			existenciasBoton.setVisible(false);
			pedidoproductoBoton.setVisible(false);
			tipopedidodptpBoton.setVisible(false);
			usuarioBoton.setVisible(false);	      
			/*DialogBox dlg = new Bienevenida();
	        dlg.center();	       
	        dlg.setLayoutData(new HorizontalSplitPanel());
	        dlg.setHeight("100%");
	        dlg.setWidth("100%");*/
			mostrarProductoPedido();	
	        
	        
	  

		}
	});
	 
	 
	 tipopedidodptpBoton.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			apboton.setVisible(false);
			apboton1.setVisible(false);
			apboton2.setVisible(false);
			irMenuBoton.setVisible(false);				
			lugarBoton.setVisible(false);
			dptBoton.setVisible(false);
			undconBoton.setVisible(false);
			bodegaBoton.setVisible(false);
			productoBoton.setVisible(false);
			existenciasBoton.setVisible(false);
			pedidoproductoBoton.setVisible(false);
			tipopedidodptpBoton.setVisible(false);
			usuarioBoton.setVisible(false);
			mostrarTipoPedidoDpto();
		}
	});
	 
	 usuarioBoton.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			apboton.setVisible(false);
			apboton1.setVisible(false);
			apboton2.setVisible(false);
			irMenuBoton.setVisible(false);				
			lugarBoton.setVisible(false);
			dptBoton.setVisible(false);
			undconBoton.setVisible(false);
			bodegaBoton.setVisible(false);
			productoBoton.setVisible(false);
			existenciasBoton.setVisible(false);
			pedidoproductoBoton.setVisible(false);
			tipopedidodptpBoton.setVisible(false);
			usuarioBoton.setVisible(false);
			mostrarUsuario();
		}
	});
	  }


  
  private  void  mostrarUsuario(){	  
	  addPanel.add(lusu);
	  addPanel.add(boxcorreo);
	  addPanel1.add(lnombre);
	  addPanel1.add(boxnombre);
	  addPanel2.add(ltipoUsu);
	  addPanel2.add(cbTipo1);
	  addPanel2.add(cbTipo2);	
	  addPanel2.add(cbTipo3);	
	  addPanel3.add(crearUsuario);
	  addPanel3.add(modificarUsuario);
	  addPanel3.add(eliminarUsuario);
	  addPanel3.add(buscarUsuario);
	  addPanel4.add(usu);
	  addPanel4.add(usuario);
	  mainPanel.add(addPanel);
	  mainPanel.add(addPanel1);
	  mainPanel.add(addPanel2);
	  mainPanel.add(addPanel3);
	  mainPanel.add(addPanel4);		  
	  RootPanel.get("stockList").add(mainPanel);	 
	  cargarTipoUsuario();
	  
	  cbTipo1.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			if( cbTipo1.isChecked()){
				  cbTipo1.setValue(true);
			}else{
				cbTipo1.setValue(false);
			}		
		     
		}
	});
	  
	  cbTipo2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if( cbTipo2.isChecked()){
					  cbTipo2.setValue(true);
				}else{
					cbTipo2.setValue(false);
				}
			}
		});
	  
	  cbTipo3.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if( cbTipo3.isChecked()){
					  cbTipo3.setValue(true);
				}else{
					cbTipo3.setValue(false);
				}
			}
		});
	  crearUsuario.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			addusuario();
		}
	
	});
	  
	  eliminarUsuario.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			eliminarUsuario();
		}
	});
	  
	  buscarUsuario.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			buscarUsuario();
		}
	});

  }
  
  private void buscarUsuario(){
	  final  String correo=boxcorreo.getText();
	  buscarUsuario(correo);
  }
  private   void  buscarUsuario(String  correo){
	  usuarioService.buscarUsuario(correo, new AsyncCallback<Usuario>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no  funciono");
		}

		@Override
		public void onSuccess(Usuario result) {
			// TODO Auto-generated method stub
			Window.alert("encontro con exito");
		}
		  
	});
  }
  
  private  void  eliminarUsuario(){
	  final  String c=boxcorreo.getText();
	  eliminarUsuario(c);	  
  }
  
  private   void  eliminarUsuario(String  correo){
	  usuarioService.elminarUsuario(correo, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se pudo eliminar ");
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se elimino satifactoriamente ");
		}
		  
	});
  }
  
  private  void addusuario(){
	  
	 final  String c=boxcorreo.getText();
	 final  String n=boxnombre.getText().toUpperCase().trim();	
	 ArrayList<String>tipo=   new  ArrayList<String>();
	 String t1="";
     String t2="";
	 String t3="";
	 boolean m=true;
	 
	  if(cbTipo1.isChecked()==m){
		 t1=cbTipo1.getText(); 		
	  }
	  if(cbTipo2.isChecked()==m){
		 t2=cbTipo2.getText(); 		
	  }
	  if(cbTipo3.isChecked()==m){
		 t3=cbTipo3.getText(); 		  
	  }
	  
	 if(t1!=""){
		 tipo.add(t1);
	 }
	 if(t2!=""){
		 tipo.add(t2);
	 }
	 if(t3!=""){
		 tipo.add(t3);
	 }	 
	
	 addusuario(c,n,tipo);
	
  }
  
  private  void addusuario(String cuenta,String nombre,ArrayList<String>tipo){
           usuarioService.addUsuario(cuenta, nombre, tipo, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no  pudo  guardar"+ caught);
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("guardo satisfactoriamente");
			}
        	   
		});
	  
  }
  
  
   private  void  cargarTipoUsuario(){
	  tipoService.cargarTipo(new AsyncCallback<ArrayList<TipoUsuario>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("hubo  erro al cargar tipo usuario");
		}

		@Override
		public void onSuccess(ArrayList<TipoUsuario> result) {
			// TODO Auto-generated method stub
			displayTipoUsu(result);
		}
		  
	});
  }
  private  void  displayTipoUsu(List<TipoUsuario>tip){
		for (TipoUsuario t:tip){			   
			//listTipo.addItem(t.getNombreUsu());		
		}  		
	  }
  
  
  private  void  mostrarTipoPedidoDpto(){
	  addPanel.add(ltipopedidodpto);
	  addPanel1.add(pedidos);
	  addPanel1.add(BoxlistPedidos);
	  addPanel1.add(lugar);
	  addPanel1.add(BoxlistLugar);
	  addPanel2.add(dpto);
	  addPanel2.add(BoxlistDpto);
	  addPanel2.add(empresas);
	  addPanel2.add(BoxlistEmpresas);
	  addPanel3.add(cubrimiento);
	  addPanel3.add(BoxCubrimiento);
	  addPanel4.add(eliminarTipoPedido);
	  addPanel4.add(crearTipoPedidoBoton);
	  addPanel4.add(modificarTipoPedido);
	  addPanel4.add(buscarTipoPedido);
	  addPanel5.add(usu);
	  addPanel5.add(usuario);
	  mainPanel.add(addPanel5);
	  mainPanel.add(addPanel);
	  mainPanel.add(addPanel1);
	  mainPanel.add(addPanel2);
	  mainPanel.add(addPanel3);
	  mainPanel.add(addPanel4);
	  
	  RootPanel.get("stockList").add(mainPanel);
	  cargarDepartamento();
	  cargarEmpresa();
	  cargarLugar();	  
	  
	  crearTipoPedidoBoton.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			crearTipoPedido();
		}
	});
	  modificarTipoPedido.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			modificarTipoPedido();
		}
	});
	  eliminarTipoPedido.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			eliminarTipoPedido();
		}
	});
	  
	  buscarTipoPedido.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			buscarTipoPedido();
		}
	});
	  
  }
  private  void buscarTipoPedido(){
	  String codigoPedido=BoxlistPedidos.getText().toUpperCase().trim();
	  buscarTipoPedido(codigoPedido);
	  
  }
  private  void buscarTipoPedido(String codigoPedido){
	  tipoPedidoService.buscarTipoPedidoDpto(codigoPedido,new AsyncCallback<TipoPedidoDpto>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se encontro ");
		}

		@Override
		public void onSuccess(TipoPedidoDpto result) {
			// TODO Auto-generated method stub
			BoxlistLugar.setItemText(0, result.getLugarPedido());
			BoxlistEmpresas.setItemText(0, result.getCodigoEmpresa());
			BoxlistDpto.setItemText(0, result.getCodigoDpto());
			BoxCubrimiento.setText(result.getDiasCubrimiento()+"");
			
			
		}
	});
	  
  }
  private  void eliminarTipoPedido(){
	  String codigoPedido=BoxlistPedidos.getText().toUpperCase().trim();
	  eliminarTipoPedido(codigoPedido);
  }
  
  private  void eliminarTipoPedido(String codigoPedido){
	  tipoPedidoService.elminarTipoPedidoDpto(codigoPedido, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught){
			// TODO Auto-generated method stub
			Window.alert("no se elimino");
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se elimino con exito");
			BoxlistPedidos.setText("");
			BoxCubrimiento.setText("");
		}
		  
	});
  }
  private  void modificarTipoPedido(){
	  String codigoPedido=BoxlistPedidos.getText().toUpperCase().trim();
	  final int i=BoxlistLugar.getSelectedIndex();
	  final String lugarPedido=BoxlistLugar.getItemText(i);
	  final int j=BoxlistDpto.getSelectedIndex();
	  final String deptoPedido=BoxlistDpto.getItemText(j);
	  final int k=BoxlistEmpresas.getSelectedIndex();
	  final String empresaPedido=BoxlistEmpresas.getItemText(k);
	  final String cu=BoxCubrimiento.getText().toUpperCase().trim();
	  int  cubrimiento=Integer.parseInt(cu);	  
	  modificarTipoPedido(codigoPedido,lugarPedido,deptoPedido,empresaPedido,cubrimiento);
  }
    
  private void modificarTipoPedido(String codigoPedido,String lugarPedido,String deptoPedido,String empresaPedido,int cubrimiento){
	  tipoPedidoService.modificarTipoPedidoDpto(codigoPedido, deptoPedido, lugarPedido, empresaPedido, cubrimiento, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se  logroo modificar hubo  un error  con los  datos");
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("modificado satisfactoriamente el tipo de  pedido");
		}
	});
	  
  }
  
  private  void crearTipoPedido(){	  
	  String codigoPedido=BoxlistPedidos.getText().toUpperCase().trim();
	  final int i=BoxlistLugar.getSelectedIndex();
	  final String lugarPedido=BoxlistLugar.getItemText(i);
	  final int j=BoxlistDpto.getSelectedIndex();
	  final String deptoPedido=BoxlistDpto.getItemText(j);
	  final int k=BoxlistEmpresas.getSelectedIndex();
	  final String empresaPedido=BoxlistEmpresas.getItemText(k);
	  final String cu=BoxCubrimiento.getText().toUpperCase().trim();
	  int  cubrimiento=Integer.parseInt(cu);	  
	  crearTipoPedido(codigoPedido,lugarPedido,deptoPedido,empresaPedido,cubrimiento);
  }
    
  private  void crearTipoPedido(String codigoPedido,String lugarPedido,String deptoPedido,String empresaPedido,int cubrimiento){
	  tipoPedidoService.addTipoPedidoDpto(codigoPedido, deptoPedido, lugarPedido, empresaPedido, cubrimiento, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se pudo guardar hubo  error");
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("guardo tipo pedido der  manera Satisfactoria");
			BoxlistPedidos.setText("");
			BoxCubrimiento.setText("");
			
		}
	});
  }
  

  private  void cargarLugar(){
	  lugarService.cargarLugarPedido(new AsyncCallback<ArrayList<LugarPedido>>() {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("error  al cargar la  lista del lugar");
		}

		@Override
		public void onSuccess(ArrayList<LugarPedido> result) {
			// TODO Auto-generated method stub
			displayLugar(result);
		}
		  
	});
  }
  private  void  displayLugar(List<LugarPedido>lug){
		for (LugarPedido l:lug){			   
			BoxlistLugar.addItem(l.getNombreLugar());		
		}  		
	  }
  private  void cargarEmpresa(){
	  empresaService.cargarEmpresa(new AsyncCallback<ArrayList<Empresa>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no  logro cargar la lista de empresa");
		}

		@Override
		public void onSuccess(ArrayList<Empresa> result) {			
			displayEmpresa(result);
		}
		  
	});
  }
  
  private  void  displayEmpresa(List<Empresa>emp){
		for (Empresa e:emp){			   
			BoxlistEmpresas.addItem(e.getCodigoEmpresa());			
		}  		
	  }
  private  void cargarDepartamento(){
	  dptoService.cargarDepartamento(new AsyncCallback<ArrayList<Departamento>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("error  al cargar lista de departamento ");
		}
		
		@Override
		public void onSuccess(ArrayList<Departamento> result) {
			// TODO Auto-generated method stub
			displayDpto(result);
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
  private  void  displayDpto(List<Departamento>dpto){
		for (Departamento d:dpto){			   
			BoxlistDpto.addItem(d.getNomDpto());			
		}  		
	  }

  private  void  filitas(){	
	     productoPedido.setText(1, 0, "ITEM");
		 productoPedido.setText(1, 5, "PRODUCTO");
		 productoPedido.setText(1, 25,"CANTIDAD");
		 productoPedido.setText(1, 52,"FECHA CUBRIMIENTO");
		 productoPedido.setText(1, 58,"CENTRO DE COSTOS");
		 productoPedido.setText(1, 67,"OBSERVACIONES");		
		 productoPedido.setText(1, 80,"SALDO");	
		 productoPedido.setWidget(2, 90, add);
		 productoPedido.setWidget(2, 5, BoxlistProductop);
		 productoPedido.setWidget(2, 25, cantidadBox);
		 productoPedido.setWidget(2, 52, BoxfechaCubrimiento);
		 productoPedido.setWidget(2, 58, BoxlistCentro);
		 productoPedido.setWidget(2, 67, observacionesBox);
	
  }

  
public  void mostrarProductoPedido(){	
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
	 addPanel5.add(usu);
	 addPanel5.add(usuario);
	 mainPanel.add(addPanel);
	 mainPanel.add(addPanel1);
	 mainPanel.add(addPanel2);
	 mainPanel.add(addPanel3);
	 mainPanel.add(addPanel4);
	 mainPanel.add(addPanel5);
	 RootPanel.get("stockList").add(mainPanel);	
	 cargarCentross();
	 cargarProductoss();	
	 cargarDepartamento1();		 
	 fechaped.setText("DD/MM/YYYY");
	 fechaped.setEnabled(false); 	
	 
	
	 
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
    	    int jj=0;
    	    int h=0;
		}
	});	 
	 } 




private void eliminarPedido(){
	String pedido= pedidoBox.getText().toUpperCase().trim();
	eliminarPedido(pedido);
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
			 productoPedido.setText(m, 25,c);
			 productoPedido.setText(m, 52,fechaC);
		     productoPedido.setText(m, 58,cc);
			 productoPedido.setText(m, 67,obs);			   
	   }
						
		
	
}

public  void act(){
	mostrarProductoPedido();
}

public  void pasar(String pe){
	  Window.alert("pe llego con: "+pe);
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
			Window.alert("funciono :D"+ result.size());
			Window.alert("poscion 0: "+ result.get(0).getProducto());

			displayproped(result);
		}
		
	});
}
private  void  displayproped(List<ProductoPedido>c){
	
	Window.alert("entro por aqui");
	int o=0;
	for (ProductoPedido cc:c){		
		Window.alert("esto es o"+o);
		Window.alert("el tamano es"+cc.getProducto().size());		 
			
		 for (int  i=0; i<cc.getProducto().size(); i++){
			 Window.alert("entro a esta famoso ciclo");
			 Window.alert("el tamano de nuevo es"+cc.getProducto().size());
			 Window.alert("jum"+i);
			 final Button edit= new Button("EDITAR");
			 int p=i+2;
			 edit.setTitle(""+p);
			 final Button eli= new Button("ELIMINAR");
			 eli.setTitle(""+p);
			 
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
						    Window.alert("la  fila a eliminar es: "+p);
							productoPedido.removeRow(p);						
							organizar();									
						
						
						}
					});
					Window.alert("i es en la consulta");
			
			 productoPedido.setText(i+2, 0,i+1+"");		
			 productoPedido.setText(i+2, 5,cc.getProducto().get(i));
			 productoPedido.setText(i+2, 25,cc.getCantidadProducto().get(i)+"");			 
			 final Date fee = cc.getFechaCubrimiento().get(i);
			 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");		
			 String fechaC=fmtDate.format(fee);			
			 productoPedido.setText(i+2, 52,fechaC);
			 productoPedido.setText(i+2, 58,cc.getCentro().get(i));
			 productoPedido.setText(i+2, 67,cc.getObservaciones().get(i));	
			 productoPedido.setWidget(i+2, 100,edit);
			 productoPedido.setWidget(i+2, 120, eli);		 
			 productoPedido.setWidget(i+3, 90, add);
			 productoPedido.setWidget(i+3, 5, BoxlistProductop);
			 productoPedido.setWidget(i+3, 25, cantidadBox);
			 productoPedido.setWidget(i+3, 52, BoxfechaCubrimiento);
			 productoPedido.setWidget(i+3, 58, BoxlistCentro);
			 productoPedido.setWidget(i+3, 67, observacionesBox);
			 
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
						
						 productoPedido.setText(k, 80,  result.get(0).getCantidadInventariado()+"");
					}
					
				});
		 }	
		 
			
		 pedidoBox.setText(cc.getCodigoPedido());
		 final Date fePe = cc.getFechaCubrimiento().get(2);
		 DateTimeFormat fmtDate1=DateTimeFormat.getFormat("dd/MM/yyyy");		
		 String fePed=fmtDate1.format(fePe);	
		 pedFecha.setText(fePed);
		
	}  		
  } 



private void organizar(){
	
	for(int j=2;j<=productoPedido.getRowCount(); j++){			
		Window.alert("entro al ciclo: "+productoPedido.getWidget(j, 120).getTitle());
		Window.alert("j es: "+j);
		//int p=Integer.parseInt(productoPedido.getWidget(j, 120).getTitle());		
		
				final Button eli= new Button("ELIMINAR");
				final Button edit=new Button("EDITAR");
				//Window.alert("p es en organizar:"+p);
				eli.setTitle(""+j);
				edit.setTitle(""+j);
				productoPedido.setWidget(j, 120, eli);
				productoPedido.setWidget(j, 100, edit);				
				int ll=j-1;
				productoPedido.setText(j, 0, ll+"");
				eli.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						  int p=Integer.parseInt(eli.getTitle());
							productoPedido.removeRow(p);
							Window.alert("la  fila a eliminar es: "+p);
							organizar();
					}
				});
				
				edit.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						int id=Integer.parseInt(edit.getTitle());
						Window.alert("el numero es"+id);
						editarPed(id);
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
	 Window.alert("la lista de producto es: "+p);
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
	     
	     Window.alert("cantidad de filas"+i);
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
								 BoxfechaCubrimiento.setValue(fee);	
								 Date fu=new Date();
								 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");		
								 String fechaC=fmtDate.format(fee);
								 String feP=fmtDate.format(fu);
								 
								 final String cc=BoxlistCentro.getText().toUpperCase().trim();
								 final String obs= observacionesBox.getText().toUpperCase().trim();				 
								 final Button edit= new Button("EDITAR");	
								 final Button eli= new Button("ELIMINAR");
								 edit.setTitle(""+i);
								 eli.setTitle(""+i);
								
										edit.addClickHandler(new ClickHandler() {											
											@Override
											public void onClick(ClickEvent event) {
												// TODO Auto-generated method stub
												Window.alert(edit.getText());
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
												productoPedido.removeRow(p);			
											
													organizar();						
												
											
											
											}
										});
										
		                        int po=i-2;
		                        Window.alert("po es: "+po);
									 productoPedido.setText(i-1, 0,po+"");	
									 productoPedido.setText(i-1, 5, pro);
									 productoPedido.setText(i-1, 25, cant+"");
									 productoPedido.setText(i-1, 52, fechaC);
									 productoPedido.setText(i-1, 58, cc);
									 productoPedido.setText(i-1, 67, obs);
									 productoPedido.setWidget(i-1, 100, edit);
									 productoPedido.setWidget(i-1, 120, eli);
									 productoPedido.setWidget(i, 90, add);
									 productoPedido.setWidget(i, 5,  BoxlistProductop);
									 productoPedido.setWidget(i, 25, cantidadBox);
									 productoPedido.setWidget(i, 52, BoxfechaCubrimiento);
									 productoPedido.setWidget(i, 58, BoxlistCentro);
									 productoPedido.setWidget(i, 67, observacionesBox);
									
									 									
									 
								 i++;
							
								
						  }						 
						 
						  }	
					
			

					 if(i==2){
						  
						   Window.alert("EL DEPARTAMENTO QUE  SELECCIONO NO PERTENECE AL TIPO DE PEDIDO INGRESADO");
				           }					 
				}			 
			});	 
				 
	  } 
 

 private void eliminarPed(int m){	
	
		 productoPedido.removeRow(m); 		
	
	
	
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
	
	Window.alert("esto tieene la tabla "+productoPedido.getRowCount());
	Window.alert("esto tiene jj \n"+jj);
	
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
		     Window.alert("el valor de tamano"+productoPedido.getRowCount());
			 Window.alert("el valor de k"+k);
			 Window.alert("el valor de jj"+jj);
			 
				cen.add(jj, productoPedido.getText(k,58));
				 
				 String c=productoPedido.getText(k, 25);
				 double cant=Double.parseDouble(c);			 
				 cantidad.add(jj,cant);
				 
				 observaciones.add(jj,productoPedido.getText(k,67));
				 
				 String f= productoPedido.getText(k, 52);
				 DateTimeFormat fmtDate=DateTimeFormat.getFormat("dd/MM/yyyy");
				 Date  fecha=fmtDate.parse(f);
				 
				 fe.add(jj, fecha);			
				 
				 Date fu=new Date();
				 DateTimeFormat fmtDate2=DateTimeFormat.getFormat("dd/MM/yyyy");	
				 String feP=fmtDate2.format(fu);
				 pedFecha1.setText(feP);
				 fePed.add(jj, fu);
				 
				 producto.add(jj,productoPedido.getText(k,5));	 			
				 
				 if(jj==productoPedido.getRowCount()-4){			 
				
					 Window.alert("se guardo satisfactoriamente");
				     gurad(pedi,producto,cantidad,fe,cen,observaciones,dep,fePed);
					 Window.alert("Termino el ciclo for :p"+"\n Pedido: "+pedi+"\n"+producto+"\n"+cantidad+"\n"+fe+"\n"+cen+"\n"+observaciones+"\n"+dep+"\n"+fePed+"");
					 
					 
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
	    	    cantidadBox.setText("");    	
	    	    BoxlistCentro.setText("");
	    	    observacionesBox.setText("");	
	    	    pedidoBox.setEnabled(true);
	    	    BoxlistDepto.setEnabled(true);
		}
	});
	 
 } 
 
  private  void  mostrarExistencias(){
	  existenciaPro.setText(0, 0, "GESTION DE EXISTENCIAS");
	  existenciaPro.setText(1, 0, "PRODUCTO");
	  existenciaPro.setText(1, 3, "CANTIDAD");
	  existenciaPro.setText(1, 6, "FECHA"); 
		 
	   
		addPanel.add(usu);
		addPanel.add(usuario);
		addPanel1.add(ll1);
		addPanel1.add(BoxlistBodega);
		addPanel2.add(ll2);
		addPanel2.add(BoxlistProducto);
		addPanel2.add(ll3);
		addPanel2.add(BoxFecha);
		addPanel3.add(ll4);
		addPanel3.add(Boxcantidadexi);	
		addPanel4.add(crearExistenciaBoton);
		addPanel4.add(modificarExistencia);
	    addPanel4.add(eliminarExistencia);
		addPanel4.add(buscarExistencia);	
		addPanel5.add(existenciaPro);
		addPanel5.add(agregarExistencia);		
		mainPanel.add(addPanel);	
		mainPanel.add(addPanel1);	
		mainPanel.add(addPanel2);	
		mainPanel.add(addPanel3);	
		mainPanel.add(addPanel4);
		mainPanel.add(addPanel5);
		RootPanel.get("stockList").add(mainPanel);	
	    cargarProductos();
	    cargarBodega();
		
	    
		 agregarExistencia.addClickHandler(new  ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				agregarExistencia();
			}
		});
		  
		crearExistenciaBoton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				crearExistencia();
				
			}
		});		
		
		buscarExistencia.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				buscarExistencia();
			}
		});
  }
   

  private  void buscarExistencia (){
	  final  String produc=BoxlistProducto.getText().toUpperCase().trim();
	  buscarExistencia(produc);
  }
  private   void  buscarExistencia(String  codigoProducto){
	  existenciaService.buscarExistencia(codigoProducto,new AsyncCallback<ArrayList<Exixtencias>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no encontro  nada");
		}

		@Override
		public void onSuccess(ArrayList<Exixtencias> result) {
			// TODO Auto-generated method stub
			Window.alert("encontro");
		}
		  
	});
  }
  
  int  ex=existenciaPro.getRowCount();
  private  void  agregarExistencia(){
	  Window.alert("hay"+ex);
	  final int i=BoxlistBodega.getSelectedIndex();
	  final String bodega=BoxlistBodega.getItemText(i);
	  final  String produc=BoxlistProducto.getText().toUpperCase().trim();	
	  final String nombre=Boxcantidadexi.getText().toUpperCase().trim(); 	  
	  existenciaPro.setText(ex+2, 0, produc);
	  existenciaPro.setText(ex+2, 3, nombre);	
      ex++;      	 	
  }  

  
  private void crearExistencia(){
	  
	  final int i=BoxlistBodega.getSelectedIndex();
	  final String bodega=BoxlistBodega.getItemText(i);
	  final Date fe=BoxFecha.getValue();
	  String pro;
	  String  nombre;
	
	  
		Window.alert("tamno es: "+existenciaPro.getRowCount());
		
		 for(int k=2;k<=existenciaPro.getRowCount(); k++){			 
			 Window.alert("j "+k); 
			 Window.alert("tamno es: "+existenciaPro.getRowCount());
			 pro=existenciaPro.getText(k, 0); 
			 nombre=existenciaPro.getText(k, 3); 
			 double m=Double.parseDouble(nombre);
			 
			 if (j==k){
				 Window.alert("esto  va a guardar: "+bodega+"\n"+pro+"\n"+nombre);
				// crearExistencia(bodega,pro,nombre);
			 }
			
			 }	
  }
  
  
  private  void crearExistencia (String codigoBodega, String codigoProducto,
			String  cantidad,Date fecha){
	 
  }
  
  private  void cargarProductos(){
	  productoService.cargarProducto(new AsyncCallback<ArrayList<ProductoBase>>()
	   {
		  @Override
			public void onFailure(Throwable caught) {
				Window.alert("Hubo  un error  al  cargar  los Productos");			
			}
			@Override
			public void onSuccess(ArrayList<ProductoBase> result) {
				// TODO Auto-generated method stub				
				displayPro(result);				
			
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
  
  private  void  displayPro(List<ProductoBase>pro){
	 
		for (ProductoBase p:pro){	
		   
			oraculo.add(p.getDescripcion());
			
		}  
		
	  }
  
  
  

  private  void cargarBodega(){
	  bodegaService.cargarBodega(new AsyncCallback<ArrayList<Bodega>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("hubo  error al cargar");
		}

		@Override
		public void onSuccess(ArrayList<Bodega> result) {
			// TODO Auto-generated method stub
			displayBodega(result);
		}
	});
	  
  }
  
  private  void  displayBodega(List<Bodega>und){
		for (Bodega un:und){	
			BoxlistBodega.addItem(un.getCodigoBodega());
		
		}  
		
	  }
  

  private  void  mostrarProducto (){
	    addPanel.add(lproductobase);
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
		addPanel5.add(usu);
		addPanel5.add(usuario);
		mainPanel.add(addPanel5);
		mainPanel.add(addPanel);	
		mainPanel.add(addPanel1);	
		mainPanel.add(addPanel2);	
		mainPanel.add(addPanel3);	
		mainPanel.add(addPanel4);	
		RootPanel.get("stockList").add(mainPanel);	
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
  
  private void mostrarBodega(){
	  addPanel.add(lbodega);
	  addPanel1.add(codBodegalabel);
	  addPanel1.add(codBodegaBox);
	  addPanel2.add(bodegalabel);
	  addPanel2.add(bodegaBox);
	  addPanel3.add(empresalabel);
	  addPanel3.add(empresaBox);
	  addPanel3.add(pruebabox);
	  addPanel4.add(crearBodegaBoton);
	  addPanel4.add(modificarBodega);
	  addPanel4.add(eliminarBodega);
	  addPanel4.add(buscarBodega);	
	  addPanel5.add(usu);
	  addPanel5.add(usuario);
	  mainPanel.add(addPanel5);
	  mainPanel.add(addPanel);	 
	  mainPanel.add(addPanel1);	
	  mainPanel.add(addPanel2);	 
	  mainPanel.add(addPanel3);	 
	  mainPanel.add(addPanel4);	 
	  cargarEmpresas();
	  RootPanel.get("stockList").add(mainPanel);	
	 
	 
	
	  crearBodegaBoton.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub			
			crearBodega();			
		}
	});
	  modificarBodega.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			modificarBodega();
			
		}
	});
	  eliminarBodega.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			eliminarBodega();
		}
	});
	  
	  buscarBodega.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			buscarBodega();
		}
	});
    
  }
  
  private  void  cargarEmpresas(){
	  empresaService.listTodos(new AsyncCallback<ArrayList<Empresa>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub			
		}

		@Override
		public void onSuccess(ArrayList<Empresa> result) {
			// TODO Auto-generated method stub
			displayEmpresas(result);
		}
		  
	});
  }
  
  private  void  displayEmpresas(List<Empresa>und){
		for (Empresa un:und){	
		empresaBox.addItem(un.getCodigoEmpresa());			
		}  	
	  }
  
  private  void  buscarBodega(){
	  final String  codigo= codBodegaBox.getText().toUpperCase().trim();
	  buscarBodega(codigo);
  }
  private 	void buscarBodega(String codigo){
	  bodegaService.buscarBodega(codigo,new AsyncCallback<Bodega>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se encontro");
		}
		
		@Override
		public void onSuccess(Bodega result) {
			// TODO Auto-generated method stub			
			bodegaBox.setText(result.getNombre());				
				if(result.getCodigoEmpresa().equalsIgnoreCase("PSF")){
					
					
					empresaBox.setItemText(0, result.getCodigoEmpresa());
					empresaBox.setItemText(1, "EX");
					
				}else{
						
					empresaBox.setItemText(0, result.getCodigoEmpresa());
					empresaBox.setItemText(1, "PSF");
				}
		}	  
		  
	});
  }
  
  private  void eliminarBodega(){
	  final String  codigo= codBodegaBox.getText().toUpperCase().trim();
	  eliminarBodega(codigo);
  }
  
  private  void  eliminarBodega(String  codigo){
	  bodegaService.elminarBodega(codigo, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no  elimino");
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se  elimino  satisfactoriamente");
			codBodegaBox.setText("");
			bodegaBox.setText("");
		}
	});
  }
  
  private void modificarBodega(){
	  final String  codigo= codBodegaBox.getText().toUpperCase().trim();
	  final String  nombre= bodegaBox.getText().toUpperCase().trim();
	  final int i= empresaBox.getSelectedIndex();
	  final String emp=empresaBox.getItemText(i);
	  
	  modificarBodega(codigo,nombre,emp);
  }
  
  private  void modificarBodega(String  codigo,String nombre, String empresa){
	  bodegaService.modificarBodega(codigo, nombre, empresa, new AsyncCallback<Void>() {		
		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se modifico Exitosamente");
			codBodegaBox.setText("");
			bodegaBox.setText("");
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no  se  logro modificar");
		}
	});
  }
  
  private  void crearBodega(){	 
	  final String  codigo= codBodegaBox.getText().toUpperCase().trim();
	  final String  nombre= bodegaBox.getText().toUpperCase().trim();
	  final int i= empresaBox.getSelectedIndex();
	  final String emp=empresaBox.getItemText(i);	 
	  
	  if(emp!="" && codigo!="" && nombre!=""){		  
		   empresaService.e(emp, new AsyncCallback<Empresa>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub		
				Window.alert("llene  los  campos porfavor");
			}
			@Override
			public void onSuccess(Empresa result) {	
				empresa.add(result);
				crearBodega(codigo,nombre,result.getCodigoEmpresa());				
			}			
		});
	  }	else {		  
		  Window.alert("LLenar  los campos");
	  }
  }  
  
  private  void crearBodega(String  codigo,String nombre,String  codigoEmpresa ){
	  	  bodegaService.addBodega(codigo, nombre, codigoEmpresa , new AsyncCallback<Void>() {		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Lo sentimos  pero la  Bodega no pudo ser Almacenada ");
		}
		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("guardo exitosamente");		
			codBodegaBox.setText("");
			bodegaBox.setText("");			
		}
		  
	});
  }
 
 

  private  void mostrarEmpresa(){
	  addPanel.add(lempresa);
	  addPanel1.add(codigolabel);
	  addPanel1.add(codigoBox);
	  addPanel3.add(crearButon);
	  addPanel3.add(busBoton);
	  addPanel2.add(nombrelabel);
	  addPanel2.add(nombreBox);
	  addPanel3.add(irMenuBoton);
	  addPanel3.add(eliminarBoton);
	  addPanel3.add(modificarEmpresa);	
	  addPanel4.add(usu);
	  addPanel4.add(usuario);
	  addPanel4.add(todaEmpresa);
	  mainPanel.add(signOutLink);
	  mainPanel.add(addPanel);
	  mainPanel.add(addPanel1);
	  mainPanel.add(addPanel2);	  
	  mainPanel.add(addPanel3);
	  mainPanel.add(addPanel4);		  
	  RootPanel.get("empresita").add(mainPanel);
	  codigoBox.setFocus(true);	  
	 
	  crearButon.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			addCrear();	
		
		}
	});	  
	  busBoton.addClickHandler(new ClickHandler() {			 
			@Override
			public void onClick(ClickEvent event) {			
			
			mostrar();			
				
				
			}
		});
	  
	  irMenuBoton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				 
			}
		});
	
	  eliminarBoton.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
	      // eliminarEmpresa();
			RootPanel.get("stockList").add(mainPanel);
			
		}
	});
	  
	  modificarEmpresa.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			modificarEmpresa();			
			
		}
	});
	  
	  todaEmpresa.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {			
		 todasEmpresas();
		}
	});
  }   
    private  void  todasEmpresas(){
    	empresaService.listTodos( new AsyncCallback<ArrayList<Empresa>>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("no  funciono");
			}
			@Override
			public void onSuccess(ArrayList<Empresa> result) {
				// TODO Auto-generated method stub
				Window.alert("funciono"+result.toString());
			}    		
		});
    }
    
  private  void mostrar(){
	  final String codigo= codigoBox.getText().toUpperCase().trim();
	  mostrar(codigo);  
  }
  
  private  void mostrar(String codigo){
	  empresaService.e(codigo,new AsyncCallback<Empresa>() {		
		@Override
		public void onSuccess(Empresa result) {
			// TODO Auto-generated method stub			
			codigoBox.setText(result.getCodigoEmpresa());
			nombreBox.setText(result.getNombre());
		}		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub			
		}
	});
  }
  
  private  void modificarEmpresa(){
	  final String codigo= codigoBox.getText().toUpperCase().trim();
	  final String nombre= nombreBox.getText().toUpperCase().trim();
	  
	  modificarEmpresa(codigo,nombre);
  }
  private  void  modificarEmpresa(String codigo, String nombre){
	  empresaService.modificarEmpresa(codigo, nombre,new AsyncCallback<Void>() {
		  
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se  pudo modificar  ya que no existe");
			codigoBox.setText("");
			nombreBox.setText("");
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se modifico  correctamente");
			
		}
	});
	  
  }
 
  
  
 private  void mostrarTipoUsuario (){
	 addPanel.add(ltipousario);
	 addPanel1.add(tipolabel);
	 addPanel1.add(tipoBox);
	 addPanel2.add(usulabel);
	 addPanel2.add(usuBox);
	 addPanel3.add(addTuBoton);
	 addPanel3.add(irMenuBoton);
	 addPanel3.add(modificarTipoUsu);
	 addPanel3.add(eliminarTipoUsu);
	 addPanel3.add(buscarTipo);	
	 addPanel4.add(usu);
	 addPanel4.add(usuario);
	 mainPanel.add(addPanel);
	 mainPanel.add(addPanel1);
	 mainPanel.add(addPanel2);
	 mainPanel.add(addPanel3);
	 mainPanel.add(addPanel4);
	 RootPanel.get("stockList").add(mainPanel);	 
	 tipoBox.setFocus(true); 	 
	
	 addTuBoton.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			 addTipoUsuario();
		}
	});	
	 
	 eliminarTipoUsu.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			eliminarTipo();
		}
	});
	 
	 
	 modificarTipoUsu.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			modificarTipo();			
		}
	});
	 
	 
	 buscarTipo.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			buscarTipo();			
		}
	});
 } 

 private  void buscarTipo (){
	 final String codigo=tipoBox.getText().toUpperCase().trim();
	 buscarTipo(codigo);
 } 
 private void buscarTipo (String codigo){
	 tipoService.t(codigo, new AsyncCallback<TipoUsuario>() {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub			
		}
		@Override
		public void onSuccess(TipoUsuario result) {
			// TODO Auto-generated method stub
			tipoBox.setText(result.getTipo());
			usuBox.setText(result.getNombreUsu());
		}		 
	});
	 }
 
 private  void eliminarTipo(){
	 final String tipo= tipoBox.getText().toUpperCase().trim();
	 eliminarTipo(tipo);	 
 }
 
 private void eliminarTipo(String tipo){
	tipoService.elminarTipoUsuario(tipo,new AsyncCallback<Void>() {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("No se pudo eliminar el Tipo de Usuario");
			}
		
		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("Se elimino satisfactoriamente el Tipo de Usuario");	
		    tipoBox.setText("");
		    usuBox.setText("");
		}
	});
 }
 
 private void modificarTipo(){	 
	 final String tipo= tipoBox.getText().toUpperCase().trim();
	 final String  usu =usuBox.getText().toUpperCase().trim();	 
	 modificarTipo(tipo,usu);
	 } 
 private  void  modificarTipo(String tipo, String tipoUsu){
	 tipoService.modificarTipoUsuario(tipo, tipoUsu,new AsyncCallback<Void>() {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("El Tipo de Usuario no se pudo modificar");			
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("El Tipo de Usuario se Modifico satisfactoriamente");			
		}
	});
	 
 }
 private void mostrarCentroCostos (){
	 addPanel.add(lcentros);
	 addPanel1.add(codlabel);
	 addPanel1.add(codBox);
	 addPanel2.add(costoabel);
	 addPanel2.add(costoBox);
	 addPanel3.add(costoBoton);
	 addPanel3.add(modificarCentro);
	 addPanel3.add(eliminarCentro);
	 addPanel3.add(buscarCosto);
	 addPanel4.add(usu);
	 addPanel4.add(usuario);
	 mainPanel.add(addPanel);
	 mainPanel.add(addPanel1);
	 mainPanel.add(addPanel2);
	 mainPanel.add(addPanel3);
	 mainPanel.add(addPanel4);
	 RootPanel.get("stockList").add(mainPanel);	 
	 codBox.setFocus(true);		 
	
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
 
 
 
 
 private  void mostrarDepartamento (){
	 addPanel.add(ldepartamento);
	 addPanel1.add(codeptlabel);
	 addPanel1.add(codeptBox);
	 addPanel2.add(deptabel);
	 addPanel2.add(deptBox);
	 addPanel3.add(crearDptBoton);
	 addPanel3.add(eliminarDepto);
	 addPanel3.add(modificarDepto);
	 addPanel3.add(buscarDepto); 
	 addPanel4.add(usu);
	 addPanel4.add(usuario);
	 mainPanel.add(addPanel4);
	 mainPanel.add(addPanel);
	 mainPanel.add(addPanel1);
	 mainPanel.add(addPanel2);
	 mainPanel.add(addPanel3);
	 RootPanel.get("stockList").add(mainPanel);	
	 codeptBox.setFocus(true);	
	 	
	 
	 crearDptBoton.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			addDpto();		
			
		}
	});
	 eliminarDepto.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			eliminarDpto();
			
		}
	});
	 
	 modificarDepto.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			modificarDpto();
		}
	});
	 
	 buscarDepto.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			buscarDepto();
		}
	});
 }
 
 private  void buscarDepto(){
	 final String codigo=codeptBox.getText().toUpperCase().trim();
	 buscarDepto(codigo);
 }
 
 private void buscarDepto(String codigo){
	 dptoService.d(codigo,new AsyncCallback<Departamento>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub			
		}		

		@Override
		public void onSuccess(Departamento result) {
			// TODO Auto-generated method stub
			codeptBox.setText(result.getCodDpto());
			deptBox.setText(result.getNomDpto());
		}		 
	});
 }
 
 private void eliminarDpto(){
	 final String codpt= codeptBox.getText().toUpperCase().trim();
	 eliminarDpto(codpt);
 }
 
 private void eliminarDpto(String codpt){
	 dptoService.elminarDepartamento(codpt, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se pudo eliminar el departamento");
		}
		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se  ha  eliminado el departamento satisfactoriamente");	
			codeptBox.setText("");
			deptBox.setText("");
		}
	});
 }
 
 private void modificarDpto(){
	 final String codpt= codeptBox.getText().toUpperCase().trim();
	 final String dpto= deptBox.getText().toUpperCase().trim();
	 modificarDpto(codpt,dpto);
 }
 
 private  void modificarDpto(String codpt,String dpto){
	 dptoService.modificarDepartamento(codpt, dpto,new AsyncCallback<Void>() {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("No se pudo modificar");		
		}
		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("Se modifico satisfactoriamente");
			codeptBox.setText("");
			deptBox.setText("");
		}
	} );
 }
 
 private  void mostrarLugar(){
	 addPanel.add(llugarpedido);
	 addPanel1.add(codlugarlabel);
	 addPanel1.add(codlugarBox);
	 addPanel2.add(lugarlabel);
	 addPanel2.add(lugtarBox);
	 addPanel3.add(crearlugarBoton);
	 addPanel3.add(eliminarLugar);
	 addPanel3.add(modificarLugar);
	 addPanel3.add(buscarLugar);	
	 addPanel4.add(usu);
	 addPanel4.add(usuario);
	 mainPanel.add(addPanel4);
	 mainPanel.add(addPanel);
	 mainPanel.add(addPanel1);
	 mainPanel.add(addPanel2);
	 mainPanel.add(addPanel3);
	 RootPanel.get("stockList").add(mainPanel);	
	 codlugarBox.setFocus(true);
		
	 crearlugarBoton.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {			
			
			addLugar();
		}
	});
	 eliminarLugar.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			eliminarLugar();
			
		}
	});
	 modificarLugar.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			modificarLugar();
			
		}
	});
	 
	 buscarLugar.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
		     buscarLugar();	
		}
	});
	 
 }
 
 private  void buscarLugar(){
	 final String codigo=codlugarBox.getText().toUpperCase().trim();	
	 buscarLugar(codigo);
 }
 private  void buscarLugar(String codigo){
	 lugarService.l(codigo, new AsyncCallback<LugarPedido>() {		 
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("No se  logro Encontrar el Lugar");
		}
		@Override
		public void onSuccess(LugarPedido result) {
			// TODO Auto-generated method stub
			codlugarBox.setText(result.getCodigoLugar());
		    lugtarBox.setText(result.getNombreLugar());			
		}		 
	});
 }
 private void eliminarLugar(){
	 final String codlugar=codlugarBox.getText().toUpperCase().trim();
	 eliminarLugar(codlugar);
 }
 private void eliminarLugar(String codlugar){
	 lugarService.elminarLugarPedido(codlugar, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se pudo eliminar");
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se elimino satisfactoriemnte");	
			codlugarBox.setText("");
			lugtarBox.setText("");	
		}
	});
 }
 
 private  void modificarLugar(){
	 final String codlugar=codlugarBox.getText().toUpperCase().trim();
	 final String lugar=lugtarBox.getText().toUpperCase().trim();
	 modificarLugar(codlugar,lugar);
	 
 }
 
 private  void  modificarLugar(String codLugar,String lugar){
	 lugarService.modificarLugarPedido(codLugar, lugar, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se  pudo modificar");			
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se modifico satisfactoriamente");
			codlugarBox.setText("");
			lugtarBox.setText("");	
		}
		 
	});
 } 
 
 private void mostrarUndConsumo(){
	 addPanel.add(lunidadconsumo);
	 addPanel1.add(idundlabel);
	 addPanel1.add(idundBox);
	 addPanel2.add(unidadbel);
	 addPanel2.add(unidadBox);
	 addPanel3.add(crearundBoton);
	 addPanel3.add(eliminarUnd);
	 addPanel3.add(modificarUnd);
	 addPanel3.add(buscarUnd);
	 addPanel4.add(usu);
	 addPanel4.add(usuario);
	 mainPanel.add(addPanel4);
	 mainPanel.add(addPanel);
	 mainPanel.add(addPanel1);
	 mainPanel.add(addPanel2);
	 mainPanel.add(addPanel3);	 
	 RootPanel.get("stockList").add(mainPanel);	
	 idundBox.setFocus(true);	
	 
	 
	
	 crearundBoton.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			addUnd();			
		}
	});
	 
	 eliminarUnd.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			eliminarUnd();
		}
	});
	 
	 modificarUnd.addClickHandler(new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			modificarUnd();
		}
	});
	 
	 buscarUnd.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
		    buscarUnd();		    
		}
	});
 }
 
 private  void buscarUnd(){
    final  String id=idundBox.getText().toUpperCase().trim();
    buscarUnd(id);
 }
 private  void  buscarUnd(String codigo){
	 undService.u(codigo,new AsyncCallback<UndConsumo>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub		
			Window.alert("No se  logro  Encontrar");
		}

		@Override
		public void onSuccess(UndConsumo result) {
			// TODO Auto-generated method stub			
			idundBox.setText(result.getIdUnd());
			unidadBox.setText(result.getNombreUnd());
			
		}
	});
	 
 }
 private  void  eliminarUnd(){
	 final  String id=idundBox.getText().toUpperCase().trim();
	 eliminarUnd(id);
 }
 
 private  void eliminarUnd(String id){
	 
	 undService.elminarUndConsumo(id,new AsyncCallback<Void>() {
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se pudo eliminar");
		}
		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se elimino satisfactoriamente");
			idundBox.setText("");
			unidadBox.setText("");			
		}
	});
 }
 
 private void modificarUnd (){
	 final  String id=idundBox.getText().toUpperCase().trim();
	 final  String und=unidadBox.getText().toUpperCase().trim();
	 modificarUnd(id,und);
 }
 
 private  void modificarUnd(String id,String und){
	 undService.modificarUndConsumo(id, und, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no se pudo modificar");
		}

		@Override
		public void onSuccess(Void result) {
			// TODO Auto-generated method stub
			Window.alert("se  modifico satisfactoriamente");
			idundBox.setText("");
			unidadBox.setText("");	
		}
	});
 }
 
 

 
 private void addTipoUsuario(){
	 final String tipo = tipoBox.getText().toUpperCase().trim();
	 final String tipousu=usuBox.getText().toUpperCase().trim();
	 tipoBox.setFocus(true);
	 if(!tipo.equalsIgnoreCase("") && !tipousu.equalsIgnoreCase("")){
		 Window.alert("Guardo satisfactoriamente ");       		 
	}else{    	
    	Window.alert("Porfavor  llene los campos"); 
    }	 
	   tipoBox.setText("");	
	   usuBox.setText("");    		
	   addTipoUsuario(tipo,tipousu);	
	 
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
 
 private  void addDpto(){
	 
	 final String codDpto =codeptBox.getText().toUpperCase().trim();
	 final String nomDpto=deptBox.getText().toUpperCase().trim();
	 codeptBox.setFocus(true);
	 if(!codDpto.equalsIgnoreCase("") && !nomDpto.equalsIgnoreCase("")){
		 addDpto(codDpto,nomDpto);
	}else{    	
    	Window.alert("Porfavor  llene los campos"); 
    }   	
	 
	 
 }
 
 private void addLugar (){	 
	 final String codLugar =codlugarBox.getText().toUpperCase().trim();
	 final String nomLugar=lugtarBox.getText().toUpperCase().trim();
	 codlugarBox.setFocus(true);
	 if(!codLugar.equalsIgnoreCase("") && !nomLugar.equalsIgnoreCase("")){
		 addLugar(codLugar,nomLugar); 
	}else{    	
    	Window.alert("Porfavor  llene los campos"); 
    }
	 
 }
 
 private void addUnd(){
	 final String idUnd=idundBox.getText().toUpperCase().trim();
	 final String nomUnd=unidadBox.getText().toUpperCase().trim();	 
	 idundBox.setFocus(true);
	 
	 if(!idUnd.equalsIgnoreCase("") && !nomUnd.equalsIgnoreCase("")){
		 Window.alert("Guardo satisfactoriamente ");       		 
	}else{    	
    	Window.alert("Porfavor  llene los campos"); 
    }	 
	 idundBox.setText("");	
	 unidadBox.setText("");    		
	 addUnd(idUnd,nomUnd);
	 
 }
    private void addCrear(){
    	final String codigo= codigoBox.getText().toUpperCase().trim();
    	final String nombre= nombreBox.getText().toUpperCase().trim();
    	codigoBox.setFocus(true);  	
    	
    	if(!codigo.equalsIgnoreCase("") && !nombre.equalsIgnoreCase("")){
    		 addCrear(codigo,nombre); 
    	}else{
        	
        	Window.alert("Porfavor  llene los campos"); 
        }
    	   		
          		
    	
    }
   
    
       private void eliminarEmpresa (){
    	final String codigo= codigoBox.getText().toUpperCase().trim();
    	eliminarEmpresa(codigo);
    }
    private void eliminarEmpresa(String codigo){
    	empresaService.elminarEmpresa(codigo,new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				codigoBox.setText("");
				Window.alert("**** La empresa que usted  desea no se pudo  eliminar  debe  ser que no  exista o  su codigo  este mal ****");		
			}
			
			@Override
			public void onSuccess(Void result) {
				if (result==null){
					codigoBox.setText("");
					nombreBox.setText("");
					Window.alert("La Empresa se ha Eliminado Satisfactoriamente: ");					
				}	
				
			}
		});
    	
    }
    
   
   
 
    private void addTipoUsuario(final String tipo,final String tipousu){
    	tipoService.addTipoUsuario(tipo, tipousu, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void result) {
				guardarTipo(tipo,tipousu);
				
			}
	
    	});
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
				guardarCentro (codCosto, nomCostos);
				Window.alert("Se Guardo Satisfactoriamente el Centro de Costo");
			}
		});
    	
    }
    
    private void addDpto(final String codDpto, final String nomDpto){
    	dptoService.addDepartamento(codDpto, nomDpto, new AsyncCallback<Void>() {
    		
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("No se logro  Guardar");
				}
			
			@Override
			public void onSuccess(Void result) {
				guardarDpto(codDpto,nomDpto);
				Window.alert("Se guardop  Satisfactoriamente el Departamento");
				 codeptBox.setText("");	
				 costoBox.setText(""); 
			}
		});
    	
    }
    
    private  void addLugar (final String codLugar, final String nombLugar){
       lugarService.addLugarPedidos(codLugar,nombLugar,new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("no  se logro guardar");
		}

		@Override
		public void onSuccess(Void result) {
			guardarLugar(codLugar,nombLugar);
			Window.alert("Se guardo Satisfactoriamente el Lugar");
			codlugarBox.setText("");	
			lugtarBox.setText("");  
		}
	});
    }
    private  void addUnd (final String idUnd, final String nombreUnd){
    	undService.addUndConsumjo(idUnd, nombreUnd, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void result) {
				guardarUnd(idUnd,nombreUnd);
				
			}
		});
    	
    }
    
    private void addCrear(final String codigo, final String nombre) {
    empresaService.addEmpresa(codigo, nombre, new AsyncCallback<String>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			 Window.alert("NO  SE LOGRO  GUARDAR LA EMPRESA");
		}

		@Override
		public void onSuccess(String result) {
			Window.alert("LA  EMPRESA: "+ result+"  HA  SIDO  ALMACENADA  CON EXITO");
			  codigoBox.setText("");	
	    	  nombreBox.setText("");  
		}
    	
	});
      }
    
    public  void guardar (final String codigo, final String nombre){  	 
    
    	
    	
    }
    
 public  void guardarTipo (final String tipo, final String tipousu){   	 
    
    	
    	
    }    
 
 public  void  guardarCentro(final String codCosto, final String nomCostos){
	 
	 
 }
 
 public  void guardarDpto(final String codDpto, final String nombDpto){
	 
	 
 }
 
 public  void guardarLugar(final String codLugar, final String nomLugar){
	 
 }
 
 public  void  guardarUnd(final String idUnd, final String nombreUnd){
	 
 }
    
        
    
    
      
        
        

     
    
}

