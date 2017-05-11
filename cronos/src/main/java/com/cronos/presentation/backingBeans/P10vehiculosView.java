package com.cronos.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.panel.Panel;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P00listaopcion;
import com.cronos.modelo.P10clientes;
import com.cronos.modelo.P10soat;
import com.cronos.modelo.P10vehiculos;
import com.cronos.modelo.dto.ext.DataSoatVehiculosDTOExt;
import com.cronos.presentation.businessDelegate.IBusinessDelegatorView;
import com.cronos.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class P10vehiculosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P10vehiculosView.class);

    private Integer rowidP10vehiculos;

    private InputText txtNroPLaca;
    private InputText txtCodigoFasecolda;
    
    //**datos del prpietario ******
    private P10clientes p10clientePropietario;
    private List<SelectItem> selTipoIdentificacionPropietarioList;
    private String selTipoIdentificacionPropietario;

    private InputText txtNroIdentificacionPropietario;
    private InputText txtRazonSocialPropietario;

    //**datos del ClaseVehiculo ******
    private List<SelectItem> selClaseVehiculoList;
    private String selClaseVehiculo;

    //**datos del TipoServicio ******
    private List<SelectItem> selTipoServicioList;
    private String selTipoServicio;

    private InputText txtCilindraje;
    private InputText txtModelo;
    private InputText txtNroPasajeros;
    private InputText txtCapacidadToneladas;
    private InputText txtNroMotor;
    private InputText txtNroMotorSerie;
    
    //---------------- campos de generacion de soat -----------------
    private org.primefaces.component.calendar.Calendar calFechaExpedicion;
    private org.primefaces.component.calendar.Calendar calFechaInicioVigencia;
    private org.primefaces.component.calendar.Calendar calFechaFinalVigencia;
    
    private List<SelectItem> selTipoTomadorList;
    private String selTipoTomador;

    private Panel panelTomadorExistente;
    
    //**datos del tomador ******
    private P10clientes p10clienteTomador;
    private List<SelectItem> selTipoIdentificacionTomadorList;
    private String selTipoIdentificacionTomador;

    private InputText txtNroIdentificacionTomador;
    private InputText txtRazonSocialTomador;

    private CommandButton btnCrearTomador;
    
    private List<DataSoatVehiculosDTOExt> dataTableSoatVehiculoList = new ArrayList<DataSoatVehiculosDTOExt>();
    private DataSoatVehiculosDTOExt selDataTableSoatVehiculo = new DataSoatVehiculosDTOExt();
    
    private InputTextarea observacionesinhabiltiarsoat;
    //---------------------------------------------------------------

    private CommandButton btnNuevo;
    private CommandButton btnGuardar;
    private CommandButton btnDelete;
    private CommandButton btnGenerarSOAT;
    
    //****** busqueda principal ******
    private List<P10vehiculos> busquedaPrincipalList;
    private P10vehiculos busquedaPrincipal;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public P10vehiculosView() {
    	
        super();
    }
    
    /**
     * evento boton nuevo
     * @autor CACP - RFAST9 8/07/2016
     */
    public void action_new(){
    	try {

    		rowidP10vehiculos = null;
    		
    		txtNroPLaca.setValue(null);
    		txtCodigoFasecolda.setValue(null);

    		p10clientePropietario = null;
    		selTipoIdentificacionPropietario = null;
    		txtNroIdentificacionPropietario.setValue(null);
    		txtRazonSocialPropietario.setValue(null);
    		
    	    selClaseVehiculo = null;
    	    selTipoServicio = null;

    	    txtCilindraje.setValue(null);
    	    txtModelo.setValue(null);
    	    txtNroPasajeros.setValue(null);
    	    txtCapacidadToneladas.setValue(null);
    	    txtNroMotor.setValue(null);
    	    txtNroMotorSerie.setValue(null);	
    	    
    	    dataTableSoatVehiculoList = new ArrayList<DataSoatVehiculosDTOExt>();
    	    selDataTableSoatVehiculo = null;

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    public void action_save(){
    	try {
			
    		if(rowidP10vehiculos== null){
    			
    			action_create();
    			
    		}else if(rowidP10vehiculos != null){
    			
    			action_modifica();
    		}
    		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    /**
     * metodo que elimina el registro
     * @autor CACP - RFAST9 8/07/2016
     */
    public void action_delete(){
    	try {
			
    		if(rowidP10vehiculos != null){
    			
    			P10vehiculos p10vehiculos = businessDelegatorView.getP10vehiculos(rowidP10vehiculos);
    			
    			if(p10vehiculos != null && p10vehiculos.getRowidvehiculos() != null){
    				businessDelegatorView.deleteP10vehiculos(p10vehiculos);
    			}
    			
    		}else{
    			throw new Exception("Debe seleccionar un registro para elimiarlo.");
    		}
    		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que se encarga de crear un registro
     * @autor CACP - RFAST9 8/07/2016
     */
    public void action_create() throws Exception{
    	try {

    		if(validandoDatos()){
    			
    			P10vehiculos p10vehiculos = new P10vehiculos();
    			
    			p10vehiculos.setP00empresa(businessDelegatorView.getEmpresaUsuario());
    			p10vehiculos.setNumeroplaca(FacesUtils.checkString(txtNroPLaca));
    			p10vehiculos.setCodigofasecolda(FacesUtils.checkString(txtCodigoFasecolda));
    			p10vehiculos.setP10clientes(p10clientePropietario);
    			p10vehiculos.setP00listaopcionByRowidclasevehiculo(businessDelegatorView.getP00listaopcion(Integer.parseInt(selClaseVehiculo)));
    			p10vehiculos.setP00listaopcionByRowidtiposervicio(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoServicio)));
    			p10vehiculos.setCilindraje(FacesUtils.checkString(txtCilindraje));
    			p10vehiculos.setModelo(FacesUtils.checkString(txtModelo));
    			p10vehiculos.setNropasajeros(FacesUtils.checkString(txtNroPasajeros));
    			p10vehiculos.setCapacidadtoneladas(FacesUtils.checkInteger(txtCapacidadToneladas));
    			p10vehiculos.setNromotor(FacesUtils.checkString(txtNroMotor));
    			p10vehiculos.setNrochasis(FacesUtils.checkString(txtNroMotorSerie));
    			
    			businessDelegatorView.saveP10vehiculos(p10vehiculos);
    			
    			rowidP10vehiculos = p10vehiculos.getRowidvehiculos();
    			
    			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
    		}
		} catch (Exception e) {
			throw e;
		}
    }

    /**
     * metodo que se encarga de modificar un registro
     * @autor CACP - RFAST9 8/07/2016
     */
    public void action_modifica() throws Exception{
    	try {

    		if(validandoDatos()){
    			
    			P10vehiculos p10vehiculos = new P10vehiculos();
    			
    			p10vehiculos.setRowidvehiculos(rowidP10vehiculos);
    			p10vehiculos.setP00empresa(businessDelegatorView.getEmpresaUsuario());
    			p10vehiculos.setNumeroplaca(FacesUtils.checkString(txtNroPLaca));
    			p10vehiculos.setCodigofasecolda(FacesUtils.checkString(txtCodigoFasecolda));
    			p10vehiculos.setP10clientes(p10clientePropietario);
    			p10vehiculos.setP00listaopcionByRowidclasevehiculo(businessDelegatorView.getP00listaopcion(Integer.parseInt(selClaseVehiculo)));
    			p10vehiculos.setP00listaopcionByRowidtiposervicio(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoServicio)));
    			p10vehiculos.setCilindraje(FacesUtils.checkString(txtCilindraje));
    			p10vehiculos.setModelo(FacesUtils.checkString(txtModelo));
    			p10vehiculos.setNropasajeros(FacesUtils.checkString(txtNroPasajeros));
    			p10vehiculos.setCapacidadtoneladas(FacesUtils.checkInteger(txtCapacidadToneladas));
    			p10vehiculos.setNromotor(FacesUtils.checkString(txtNroMotor));
    			p10vehiculos.setNrochasis(FacesUtils.checkString(txtNroMotorSerie));
    			
    			businessDelegatorView.updateP10vehiculos(p10vehiculos);
    			
    			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
    		}
		} catch (Exception e) {
			throw e;
		}
    }
    
    /**
     * metodo principal de consulta de datos.
     * @autor CACP - RFAST9 18/07/2016
     */
    public void action_search(){
    	try {
    		
    		busquedaPrincipalList = new ArrayList<P10vehiculos>();
    		
    		List<P10vehiculos> p10vehiculosList = businessDelegatorView.getP10vehiculos();
    		
    		if(p10vehiculosList != null && p10vehiculosList.size() > 0){
    			
    			for (P10vehiculos p10vehiculos : p10vehiculosList) {
    				
    				if(p10vehiculos.getP10clientes() != null){
    					
    					p10vehiculos.setP10clientes(businessDelegatorView.getP10clientes(p10vehiculos.getP10clientes().getRowidcliente()));
    					
    					if(p10vehiculos.getP10clientes().getP00listaopcionByRowidtipoidentificacion() != null){
    						
    						P00listaopcion p00listaopcion = businessDelegatorView.getP00listaopcion(p10vehiculos.getP10clientes().getP00listaopcionByRowidtipoidentificacion().getRowidopcion());
    						p10vehiculos.getP10clientes().setP00listaopcionByRowidtipoidentificacion(p00listaopcion);
    					}
    				}

    				if(p10vehiculos.getP00listaopcionByRowidclasevehiculo() != null){
    					
    					P00listaopcion p00listaopcion= businessDelegatorView.getP00listaopcion(p10vehiculos.getP00listaopcionByRowidclasevehiculo().getRowidopcion());
    					p10vehiculos.setP00listaopcionByRowidclasevehiculo(p00listaopcion);
    				}
    				
    				if(p10vehiculos.getP00listaopcionByRowidtiposervicio() != null){
    					
    					P00listaopcion p00listaopcion = businessDelegatorView.getP00listaopcion(p10vehiculos.getP00listaopcionByRowidtiposervicio().getRowidopcion());
    					p10vehiculos.setP00listaopcionByRowidtiposervicio(p00listaopcion);
    				}
    			}
    			
    			busquedaPrincipalList = p10vehiculosList;
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    /**
     * metodo qe se dispara al seleccionar un registro de la grilla
     * @autor CACP - RFAST9 18/07/2016
     */
    public void onRowSelect(SelectEvent event){
	    try {

	    	if(busquedaPrincipal != null && busquedaPrincipal.getRowidvehiculos() != null){
	    		
	    		action_new();
	    		
	    	    rowidP10vehiculos = busquedaPrincipal.getRowidvehiculos();
	    	    
	    	    if(busquedaPrincipal.getP00listaopcionByRowidclasevehiculo() != null){
	    	    	selClaseVehiculo = busquedaPrincipal.getP00listaopcionByRowidclasevehiculo().getRowidopcion().toString();
	    	    }
	    	    
	    	    if(busquedaPrincipal.getP00listaopcionByRowidclasevehiculo() != null){
	    	    	selClaseVehiculo = busquedaPrincipal.getP00listaopcionByRowidclasevehiculo().getRowidopcion().toString();
	    	    }

	    	    if(busquedaPrincipal.getP00listaopcionByRowidtiposervicio() != null){
	    	    	selTipoServicio = busquedaPrincipal.getP00listaopcionByRowidtiposervicio().getRowidopcion().toString();
	    	    }
	    	    
	    	    if(busquedaPrincipal.getP10clientes() != null){
	    	        p10clientePropietario = busquedaPrincipal.getP10clientes();
	    	        selTipoIdentificacionPropietario = busquedaPrincipal.getP10clientes().getP00listaopcionByRowidtipoidentificacion().getRowidopcion().toString();
	    	        txtNroIdentificacionPropietario.setValue(busquedaPrincipal.getP10clientes().getNumeroidentificacion());
	    	        onRowBuscarPropietario();
	    	    }

	    	    txtNroPLaca.setValue(busquedaPrincipal.getNumeroplaca());
	    	    txtCodigoFasecolda.setValue(busquedaPrincipal.getCodigofasecolda());
	    	    txtCilindraje.setValue(busquedaPrincipal.getCilindraje());
	    	    txtModelo.setValue(busquedaPrincipal.getModelo());
	    	    txtNroPasajeros.setValue(busquedaPrincipal.getNropasajeros());
	    	    
	    	    txtCapacidadToneladas.setValue(busquedaPrincipal.getCapacidadtoneladas());
	    	    txtNroMotor.setValue(busquedaPrincipal.getNromotor());
	    	    txtNroMotorSerie.setValue(busquedaPrincipal.getNrochasis());
	    	    
	    	    cargarGrillaSoatVehiculo(busquedaPrincipal.getRowidvehiculos());
	    	    
	    	}else{
	    		throw new Exception("Error al seleccionar un registro, intente de nuevo.");
	    	}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}	
    }
    
    /**
     * metodo que valida los datos antes de guardar o modificar
     * @autor CACP - RFAST9 8/07/2016
     * @return
     * @throws Exception
     */
    private Boolean validandoDatos()throws Exception{
    	try {

    		if(selClaseVehiculo == null){
    			throw new Exception("Debe seleccionar una clase de vehiculo.");
    		}

    		if(selTipoServicio == null){
    			throw new Exception("Debe seleccionar un tipo de servicio.");
    		}
    		
    		if(FacesUtils.checkString(txtNroPLaca) == null){
    			throw new Exception("Debe digitar un numero de placa.");
    		}
    		
    		if(p10clientePropietario == null || p10clientePropietario.getRowidcliente() == null){
    			throw new Exception("Debe seleccionar un propietario.");
    		}

    		return true;
			
		} catch (Exception e) {
			throw e;
		}
    }
    
    /**
     * carga la grilla de soat del vehiculo
     * @autor CACP - RFAST9 27/07/2016
     * @param idVehiculo
     * @throws Exception
     */
    private void cargarGrillaSoatVehiculo(Integer idVehiculo) throws Exception{
    	try {
			
    		if(idVehiculo != null){
    			
    			dataTableSoatVehiculoList = businessDelegatorView.getDataSoatVehiculosDTOExt(idVehiculo);
    		}
		} catch (Exception e) {
			throw e;
		}
    }

    //******************* reglas del cliente ****************************************

    /**
     * metodo que consulta los datos del propietario segun el tipo de identificacion y el numero de identificacion.
     * @autor CACP - RFAST9 18/07/2016
     */
    public void onRowBuscarPropietario(){
    	try {
    		
    		if(FacesUtils.checkString(txtNroIdentificacionPropietario) != null && (selTipoIdentificacionPropietario != null && !selTipoIdentificacionPropietario.isEmpty() )){
    			
    			Object[] variables = {
    					"numeroidentificacion", true, FacesUtils.checkString(txtNroIdentificacionPropietario), "=",
    					"p00listaopcionByRowidtipoidentificacion.rowidopcion", true, Integer.parseInt(selTipoIdentificacionPropietario), "="
    			};
    			List<P10clientes> p10clientesList = businessDelegatorView.findByCriteriaInP10clientes(variables, null, null);
    			
    			if(p10clientesList != null && p10clientesList.size() > 0){
    				
    				P10clientes p10clientes = p10clientesList.get(p10clientesList.size()-1);
    				cargarDatosPropietario(p10clientes);
    				
    			}else{
    				txtRazonSocialPropietario.setValue(null);
    				throw new Exception("No se encontro ningún cliente con el numero de identificación " + FacesUtils.checkString(txtNroIdentificacionPropietario) + ".");
    			}
    		}else{
    			txtRazonSocialPropietario.setValue(null);
    			p10clientePropietario = null;
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que se encarga de cargar los datos del propietario.
     * @autor CACP - RFAST9 18/07/2016
     * @param p10clientes
     * @throws Exception
     */
    private void cargarDatosPropietario(P10clientes p10clientes)throws Exception{
    	try {

    		if(p10clientes != null && p10clientes.getRowidcliente() != null){
    			
    			p10clientePropietario = p10clientes;
    			txtRazonSocialPropietario.setValue((p10clientes.getRazonsocial() != null ? p10clientes.getRazonsocial() + " - " : "")  + p10clientes.getNombres() + " " + p10clientes.getApellidos());
    		}

		} catch (Exception e) {
			throw e;
		}
    }
    
    /**
     * mtoo que abre el dialogframework para cargar los datos del cliente.
     * @autor CACP - RFAST9 18/07/2016
     */
    public void action_dialogDatosPropietario(){
    	try {

    		if(p10clientePropietario != null && p10clientePropietario.getRowidcliente() != null){

    			cargarDataOpenDialogFramework(p10clientePropietario.getRowidcliente());
    			
    		}else{
    			throw new Exception("Debe seleccionar un cliente para ver los datos.");
    		}
            
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * abre el dialogo para ver la pagina de fasecolda.
     * @autor CACP - RFAST9 22/07/2016
     */
    public void action_buscarDestalleCodigoFasecolda(){
    	try {
    		
    		if(FacesUtils.checkString(txtCodigoFasecolda) != null){
    			FacesUtils.executarComponente("PF('widgetDialogDetalleFasecolda').show()");
    		}else{
    			throw new Exception("Debe seleccionar un codigo fasecolda.");
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * evento que dispara al abrir el dialogo de generacion de SOAT
     * @autor CACP - RFAST9 26/07/2016
     */
    public void action_metodoAbrirDialogGenerarSOAT(){
    	try {
    		
    		if(rowidP10vehiculos != null){
    			
    			calFechaExpedicion.setValue(new Date());
    			calFechaExpedicion.setMindate(new Date());
    			
    			calFechaInicioVigencia.setValue(new Date());
    			calFechaInicioVigencia.setMindate(new Date());
    			
    			Calendar calendar = Calendar.getInstance();
    			calendar.setTime(FacesUtils.checkDate(calFechaInicioVigencia));
    			calendar.add(Calendar.YEAR, 1); 
    			
    			calFechaFinalVigencia.setValue(calendar.getTime());
    			
    			FacesUtils.executarComponente("PF('widgetDialogGenerarSoat').show()");
    		}else{
    			throw new Exception("Debe seleccionar un vehiculo para agregar el SOAT.");
    		}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * evento que se dispara al cambiar la fecha de inicio vigencia de generacion soat
     * @autor CACP - RFAST9 26/07/2016
     */
    public void eventoCambiarFechaInicioVigencia(){
    	try {

    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(FacesUtils.checkDate(calFechaInicioVigencia));
    		calendar.add(Calendar.YEAR, 1); 
    		
    		calFechaFinalVigencia.setValue(calendar.getTime());
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    public void action_cambioTipoTomador(){
    	try {

    		p10clienteTomador = null;
    		selTipoIdentificacionTomador = null;
    		txtNroIdentificacionTomador.setValue(null);
    		txtRazonSocialTomador.setValue(null);

    		if(selTipoTomador != null && selTipoTomador.equals("1")){

    			panelTomadorExistente.setRendered(true);

    			btnCrearTomador.setRendered(false);

    		}else{
    			panelTomadorExistente.setRendered(false);
    			btnCrearTomador.setRendered(true);
    		}
    		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    /**
     * metodo que consulta los datos del tomador segun el tipo de identificacion y el numero de identificacion.
     * @autor CACP - RFAST9 18/07/2016
     */
    public void onRowBuscarTomador(){
    	try {
    		
    		if(FacesUtils.checkString(txtNroIdentificacionTomador) != null && (selTipoIdentificacionTomador != null && !selTipoIdentificacionTomador.isEmpty() )){
    			
    			Object[] variables = {
    					"numeroidentificacion", true, FacesUtils.checkString(txtNroIdentificacionTomador), "=",
    					"p00listaopcionByRowidtipoidentificacion.rowidopcion", true, Integer.parseInt(selTipoIdentificacionTomador), "="
    			};
    			List<P10clientes> p10clientesList = businessDelegatorView.findByCriteriaInP10clientes(variables, null, null);
    			
    			if(p10clientesList != null && p10clientesList.size() > 0){
    				
    				P10clientes p10clientes = p10clientesList.get(p10clientesList.size()-1);
    				cargarDatosTomador(p10clientes);
    				
    			}else{
    				txtRazonSocialTomador.setValue(null);
    				throw new Exception("No se encontro ningún cliente con el numero de identificación " + FacesUtils.checkString(txtNroIdentificacionTomador) + ".");
    			}
    		}else{
    			txtRazonSocialTomador.setValue(null);
    			p10clienteTomador = null;
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que se encarga de cargar los datos del propietario.
     * @autor CACP - RFAST9 18/07/2016
     * @param p10clientes
     * @throws Exception
     */
    private void cargarDatosTomador(P10clientes p10clientes)throws Exception{
    	try {

    		if(p10clientes != null && p10clientes.getRowidcliente() != null){
    			
    			p10clienteTomador = p10clientes;
    	        selTipoIdentificacionPropietario = p10clientes.getP00listaopcionByRowidtipoidentificacion().getRowidopcion().toString();
    	        txtNroIdentificacionPropietario.setValue(p10clientes.getNumeroidentificacion());
    			txtRazonSocialTomador.setValue((p10clientes.getRazonsocial() != null ? p10clientes.getRazonsocial() + " - " : "")  + p10clientes.getNombres() + " " + p10clientes.getApellidos());
    		}

		} catch (Exception e) {
			throw e;
		}
    }

    /**
     * mtoo que abre el dialogframework para cargar los datos del cliente.
     * @autor CACP - RFAST9 18/07/2016
     */
    public void action_dialogDatosTomador(){
    	try {

    		if(p10clienteTomador != null && p10clienteTomador.getRowidcliente() != null){

    			cargarDataOpenDialogFramework(p10clienteTomador.getRowidcliente());
    		}else{
    			throw new Exception("Debe seleccionar un tomador para ver los datos.");
    		}
            
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    public void returnCreateTomador(SelectEvent event){
    	try {
    		
    		P10clientes p10clienteNuevo = (P10clientes) event.getObject();
			
    		if(p10clienteNuevo != null && p10clienteNuevo.getRowidcliente() != null){
    			
    			selTipoTomador = "1";
    			action_cambioTipoTomador();

    			cargarDatosTomador(p10clienteNuevo);

    			RequestContext context = RequestContext.getCurrentInstance();
    			List<String> s = new ArrayList<String>();
    			s.add("formP10vehiculos:panelPrincipaDialogGenerarSOAT");
    			context.update(s);    			
    		}
    		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    public void cargarDataOpenDialogFramework(Integer idCliente)throws Exception{
    	try {

    		String id = idCliente != null ? idCliente.toString() : "null";
    		
			Map<String,List<String>> param = new HashMap<String, List<String>>();
			List<String> data = new ArrayList<String>();
			data.add(id);
			param.put("fnRowidCliente", data);
			
			Map<String,Object> options = new HashMap<String, Object>();
			options.put("modal", true);
			options.put("width", 930);
			options.put("height", 440);
			options.put("contentWidth", "100%");
			options.put("contentHeight", "100%");
			options.put("headerElement", "customheader");
			
			RequestContext.getCurrentInstance().openDialog("/XHTML/p10clientes.xhtml", options, param);

		} catch (Exception e) {
			throw e;
		}
    }
    
    /**
     * metodo que agrega un registro del soat para el vehiculo tabla p10soat.
     * @autor CACP - RFAST9 27/07/2016
     */
    public void action_agregarSoatVehiculo(){
    	try {
    		
    		if(FacesUtils.checkDate(calFechaExpedicion) == null){
    			throw new Exception("Debe digitar una fecha de expedición");
    		}

    		if(FacesUtils.checkDate(calFechaInicioVigencia) == null){
    			throw new Exception("Debe digitar una fecha Inicial de vigencia");
    		}

    		if(FacesUtils.checkDate(calFechaFinalVigencia) == null){
    			throw new Exception("Debe digitar una fecha Final de vigencia");
    		}
    		
    		if(p10clienteTomador == null || p10clienteTomador.getRowidcliente() == null){
    			throw new Exception("Debe digitar un tomador del soat.");
    		}
    		
    		if(rowidP10vehiculos == null){
    			throw new Exception("Debe seleccionar un vehiculo para agregar el SOAT.");
    		}
    		
    		P10soat p10soat = new P10soat();
    		p10soat.setP10vehiculos(businessDelegatorView.getP10vehiculos(rowidP10vehiculos));
    		p10soat.setP10clientes(p10clienteTomador);
    		p10soat.setHabilita(true);
    		p10soat.setFechainiciovigencia(FacesUtils.checkDate(calFechaInicioVigencia));
    		p10soat.setFechaexpedicion(FacesUtils.checkDate(calFechaExpedicion));
    		
    		businessDelegatorView.saveP10soat(p10soat);
    		
    		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
    		
    		cargarGrillaSoatVehiculo(rowidP10vehiculos);

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    public void action_inhabilitarSoat(){
    	try {
			
    		if(selDataTableSoatVehiculo != null && selDataTableSoatVehiculo.getRowidsoat() != null){
    			
    			P10soat p10soat = businessDelegatorView.getP10soat(selDataTableSoatVehiculo.getRowidsoat());
    			p10soat.setObservaciones(FacesUtils.checkString(observacionesinhabiltiarsoat));
    			p10soat.setHabilita(false);
    			
    			businessDelegatorView.updateP10soat(p10soat);
    			
    			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
    			
    			cargarGrillaSoatVehiculo(rowidP10vehiculos);
    			
    			FacesUtils.executarComponente("PF('confirmInhabilitaSoat').hide()");
    			
    		}else{
    			throw new Exception("Debe seleccionar un registro de SOAT para inhabilitar.");
    		}
    		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    //*******************************************************************************
    
    //----------------- get - set ---------------------------- 
    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

	public Integer getRowidP10vehiculos() {
		return rowidP10vehiculos;
	}

	public void setRowidP10vehiculos(Integer rowidP10vehiculos) {
		this.rowidP10vehiculos = rowidP10vehiculos;
	}

	public InputText getTxtNroPLaca() {
		return txtNroPLaca;
	}

	public void setTxtNroPLaca(InputText txtNroPLaca) {
		this.txtNroPLaca = txtNroPLaca;
	}

	public InputText getTxtCodigoFasecolda() {
		return txtCodigoFasecolda;
	}

	public void setTxtCodigoFasecolda(InputText txtCodigoFasecolda) {
		this.txtCodigoFasecolda = txtCodigoFasecolda;
	}

	public P10clientes getP10clientePropietario() {
		return p10clientePropietario;
	}

	public void setP10clientePropietario(P10clientes p10clientePropietario) {
		this.p10clientePropietario = p10clientePropietario;
	}

	public List<SelectItem> getSelTipoIdentificacionPropietarioList() throws Exception{
		selTipoIdentificacionPropietarioList = new ArrayList<SelectItem>();
		Object[] variables = {"variable", true, "tipoIdentificacion", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				selTipoIdentificacionPropietarioList.add(new SelectItem(p00listaopcion.getRowidopcion(), p00listaopcion.getNombre()));
			}
		}

		return selTipoIdentificacionPropietarioList;
	}

	public void setSelTipoIdentificacionPropietarioList(
			List<SelectItem> selTipoIdentificacionPropietarioList) {
		this.selTipoIdentificacionPropietarioList = selTipoIdentificacionPropietarioList;
	}

	public String getSelTipoIdentificacionPropietario() {
		return selTipoIdentificacionPropietario;
	}

	public void setSelTipoIdentificacionPropietario(
			String selTipoIdentificacionPropietario) {
		this.selTipoIdentificacionPropietario = selTipoIdentificacionPropietario;
	}

	public InputText getTxtNroIdentificacionPropietario() {
		return txtNroIdentificacionPropietario;
	}

	public void setTxtNroIdentificacionPropietario(
			InputText txtNroIdentificacionPropietario) {
		this.txtNroIdentificacionPropietario = txtNroIdentificacionPropietario;
	}

	public InputText getTxtRazonSocialPropietario() {
		return txtRazonSocialPropietario;
	}

	public void setTxtRazonSocialPropietario(InputText txtRazonSocialPropietario) {
		this.txtRazonSocialPropietario = txtRazonSocialPropietario;
	}

	public CommandButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(CommandButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}

	public CommandButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(CommandButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public List<P10vehiculos> getBusquedaPrincipalList() {
		return busquedaPrincipalList;
	}

	public void setBusquedaPrincipalList(List<P10vehiculos> busquedaPrincipalList) {
		this.busquedaPrincipalList = busquedaPrincipalList;
	}

	public P10vehiculos getBusquedaPrincipal() {
		return busquedaPrincipal;
	}

	public void setBusquedaPrincipal(P10vehiculos busquedaPrincipal) {
		this.busquedaPrincipal = busquedaPrincipal;
	}

	public List<SelectItem> getSelClaseVehiculoList() throws Exception{
		
		selClaseVehiculoList = new ArrayList<SelectItem>();
		
		Object[] variables = {"variable", true, "tipoVehiculos", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				
				selClaseVehiculoList.add(new SelectItem(p00listaopcion.getRowidopcion().toString(), p00listaopcion.getNombre()));
			}
		}

		return selClaseVehiculoList;
	}

	public void setSelClaseVehiculoList(List<SelectItem> selClaseVehiculoList) {
		this.selClaseVehiculoList = selClaseVehiculoList;
	}

	public String getSelClaseVehiculo() {
		return selClaseVehiculo;
	}

	public void setSelClaseVehiculo(String selClaseVehiculo) {
		this.selClaseVehiculo = selClaseVehiculo;
	}

	public List<SelectItem> getSelTipoServicioList() throws Exception{
		
		selTipoServicioList = new ArrayList<SelectItem>();
		
		Object[] variables = {"variable", true, "tipoServicio", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				
				selTipoServicioList.add(new SelectItem(p00listaopcion.getRowidopcion().toString(), p00listaopcion.getNombre()));
			}
		}

		return selTipoServicioList;
	}

	public void setSelTipoServicioList(List<SelectItem> selTipoServicioList) {
		this.selTipoServicioList = selTipoServicioList;
	}

	public String getSelTipoServicio() {
		return selTipoServicio;
	}

	public void setSelTipoServicio(String selTipoServicio) {
		this.selTipoServicio = selTipoServicio;
	}

	public InputText getTxtCilindraje() {
		return txtCilindraje;
	}

	public void setTxtCilindraje(InputText txtCilindraje) {
		this.txtCilindraje = txtCilindraje;
	}

	public InputText getTxtModelo() {
		return txtModelo;
	}

	public void setTxtModelo(InputText txtModelo) {
		this.txtModelo = txtModelo;
	}

	public InputText getTxtNroPasajeros() {
		return txtNroPasajeros;
	}

	public void setTxtNroPasajeros(InputText txtNroPasajeros) {
		this.txtNroPasajeros = txtNroPasajeros;
	}

	public InputText getTxtCapacidadToneladas() {
		return txtCapacidadToneladas;
	}

	public void setTxtCapacidadToneladas(InputText txtCapacidadToneladas) {
		this.txtCapacidadToneladas = txtCapacidadToneladas;
	}

	public InputText getTxtNroMotor() {
		return txtNroMotor;
	}

	public void setTxtNroMotor(InputText txtNroMotor) {
		this.txtNroMotor = txtNroMotor;
	}

	public InputText getTxtNroMotorSerie() {
		return txtNroMotorSerie;
	}

	public void setTxtNroMotorSerie(InputText txtNroMotorSerie) {
		this.txtNroMotorSerie = txtNroMotorSerie;
	}

	public CommandButton getBtnGenerarSOAT() {
		return btnGenerarSOAT;
	}

	public void setBtnGenerarSOAT(CommandButton btnGenerarSOAT) {
		this.btnGenerarSOAT = btnGenerarSOAT;
	}

	public org.primefaces.component.calendar.Calendar getCalFechaExpedicion() {
		return calFechaExpedicion;
	}

	public void setCalFechaExpedicion(
			org.primefaces.component.calendar.Calendar calFechaExpedicion) {
		this.calFechaExpedicion = calFechaExpedicion;
	}

	public org.primefaces.component.calendar.Calendar getCalFechaInicioVigencia() {
		return calFechaInicioVigencia;
	}

	public void setCalFechaInicioVigencia(
			org.primefaces.component.calendar.Calendar calFechaInicioVigencia) {
		this.calFechaInicioVigencia = calFechaInicioVigencia;
	}

	public org.primefaces.component.calendar.Calendar getCalFechaFinalVigencia() {
		return calFechaFinalVigencia;
	}

	public void setCalFechaFinalVigencia(
			org.primefaces.component.calendar.Calendar calFechaFinalVigencia) {
		this.calFechaFinalVigencia = calFechaFinalVigencia;
	}

	public List<SelectItem> getSelTipoTomadorList()throws Exception {
		selTipoTomadorList = new ArrayList<SelectItem>();
		
		selTipoTomadorList.add(new SelectItem("1", "Tomador existente"));
		selTipoTomadorList.add(new SelectItem("2", "Tomador nuevo"));

		return selTipoTomadorList;
	}

	public void setSelTipoTomadorList(List<SelectItem> selTipoTomadorList) {
		this.selTipoTomadorList = selTipoTomadorList;
	}

	public String getSelTipoTomador() {
		return selTipoTomador;
	}

	public void setSelTipoTomador(String selTipoTomador) {
		this.selTipoTomador = selTipoTomador;
	}

	public Panel getPanelTomadorExistente() {
		return panelTomadorExistente;
	}

	public void setPanelTomadorExistente(Panel panelTomadorExistente) {
		this.panelTomadorExistente = panelTomadorExistente;
	}

	public P10clientes getP10clienteTomador() {
		return p10clienteTomador;
	}

	public void setP10clienteTomador(P10clientes p10clienteTomador) {
		this.p10clienteTomador = p10clienteTomador;
	}

	public List<SelectItem> getSelTipoIdentificacionTomadorList() throws Exception{
		selTipoIdentificacionTomadorList = new ArrayList<SelectItem>();
		Object[] variables = {"variable", true, "tipoIdentificacion", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				selTipoIdentificacionTomadorList.add(new SelectItem(p00listaopcion.getRowidopcion(), p00listaopcion.getNombre()));
			}
		}
		
		return selTipoIdentificacionTomadorList;
	}

	public void setSelTipoIdentificacionTomadorList(
			List<SelectItem> selTipoIdentificacionTomadorList) {
		this.selTipoIdentificacionTomadorList = selTipoIdentificacionTomadorList;
	}

	public String getSelTipoIdentificacionTomador() {
		return selTipoIdentificacionTomador;
	}

	public void setSelTipoIdentificacionTomador(String selTipoIdentificacionTomador) {
		this.selTipoIdentificacionTomador = selTipoIdentificacionTomador;
	}

	public InputText getTxtNroIdentificacionTomador() {
		return txtNroIdentificacionTomador;
	}

	public void setTxtNroIdentificacionTomador(InputText txtNroIdentificacionTomador) {
		this.txtNroIdentificacionTomador = txtNroIdentificacionTomador;
	}

	public InputText getTxtRazonSocialTomador() {
		return txtRazonSocialTomador;
	}

	public void setTxtRazonSocialTomador(InputText txtRazonSocialTomador) {
		this.txtRazonSocialTomador = txtRazonSocialTomador;
	}

	public CommandButton getBtnCrearTomador() {
		return btnCrearTomador;
	}

	public void setBtnCrearTomador(CommandButton btnCrearTomador) {
		this.btnCrearTomador = btnCrearTomador;
	}

	public List<DataSoatVehiculosDTOExt> getDataTableSoatVehiculoList() {
		return dataTableSoatVehiculoList;
	}

	public void setDataTableSoatVehiculoList(
			List<DataSoatVehiculosDTOExt> dataTableSoatVehiculoList) {
		this.dataTableSoatVehiculoList = dataTableSoatVehiculoList;
	}

	public DataSoatVehiculosDTOExt getSelDataTableSoatVehiculo() {
		return selDataTableSoatVehiculo;
	}

	public void setSelDataTableSoatVehiculo(
			DataSoatVehiculosDTOExt selDataTableSoatVehiculo) {
		this.selDataTableSoatVehiculo = selDataTableSoatVehiculo;
	}

	public InputTextarea getObservacionesinhabiltiarsoat() {
		return observacionesinhabiltiarsoat;
	}

	public void setObservacionesinhabiltiarsoat(
			InputTextarea observacionesinhabiltiarsoat) {
		this.observacionesinhabiltiarsoat = observacionesinhabiltiarsoat;
	}
	
}
