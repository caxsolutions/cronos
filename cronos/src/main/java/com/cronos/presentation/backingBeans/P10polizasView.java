package com.cronos.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cronos.modelo.P00listaopcion;
import com.cronos.modelo.P10clientes;
import com.cronos.presentation.businessDelegate.IBusinessDelegatorView;
import com.cronos.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class P10polizasView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P10polizasView.class);

    private Integer rowidP10polizas;
    
    //**datos del tomador ******
    private P10clientes p10clientesTomador;
    private List<SelectItem> selTipoIdentificacionTomadorList;
    private String selTipoIdentificacionTomador;

    private InputText txtNroIdentificacionTomador;
    private InputText txtRazonSocialTomador;
    
    //**datos del asegurado ******
    private P10clientes p10clientesAsegurado;
    private List<SelectItem> selTipoIdentificacionAseguradoList;
    private String selTipoIdentificacionAsegurado;

    private InputText txtNroIdentificacionAsegurado;
    private InputText txtRazonSocialAsegurado;
    
    //**datos del beneficiario ******
    private P10clientes p10clientesBeneficiario;
    private List<SelectItem> selTipoIdentificacionBeneficiarioList;
    private String selTipoIdentificacionBeneficiario;

    private InputText txtNroIdentificacionBeneficiario;
    private InputText txtRazonSocialBeneficiario;
    
    //**** datos de aseguradora *********/
    private InputText txtNroPoliza;
    private List<SelectItem> tipoAseguradoraList;
    private String tipoAseguradora;

    private List<SelectItem> tipoAseguradoraRamoList;
    private String tipoAseguradoraRamo;

    private org.primefaces.component.calendar.Calendar calFechaInicioVigencia;
    private org.primefaces.component.calendar.Calendar calFechaFinalVigencia;

    private Double monValorRiesgoAsegurado = new Double(0);
    private Double monValorPrima = new Double(0);
    private Double monValorGastos = new Double(0);
    private Double monValorIVA = new Double(0);
    private Double monValorTotalPrima = new Double(0);

    //*** formas de pago ****/
    private List<SelectItem> selTipoFormasPagoList;
    private String selTipoFormasPago;

    private SelectOneRadio rdFormaPagoContado;
    private Boolean renderRdFormaPagoContado;
    
    private CommandButton btnNuevo;
    private CommandButton btnGuardar;
    private CommandButton btnDelete;
    
    //****** busqueda principal ******
    private List<P10clientes> busquedaPrincipalList;
    private P10clientes busquedaPrincipal;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public P10polizasView() {
        super();
    }
    
    @PostConstruct
    public void inicializar(){
    	try {
			
    		calFechaInicioVigencia = new org.primefaces.component.calendar.Calendar();
    		calFechaFinalVigencia = new org.primefaces.component.calendar.Calendar();
    		
			calFechaInicioVigencia.setValue(new Date());
			calFechaInicioVigencia.setMindate(new Date());

			eventoCambiarFechaInicioVigencia();
			
		} catch (Exception e) {
			FacesUtils.checkString(e.getMessage());
		}
    }
    
    /**
     * evento boton nuevo
     * @autor CACP - RFAST9 8/07/2016
     */
    public void action_new(){
    	try {
			
    	    selTipoIdentificacionTomador = null;
    	    txtNroIdentificacionTomador.setValue(null);
    	    txtRazonSocialTomador.setValue(null);

    	    selTipoIdentificacionAsegurado = null;
    	    txtNroIdentificacionAsegurado.setValue(null);
    	    txtRazonSocialAsegurado.setValue(null);

    	    selTipoIdentificacionBeneficiario = null;
    	    txtNroIdentificacionBeneficiario.setValue(null);
    	    txtRazonSocialBeneficiario.setValue(null);
    	    
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    public void action_save(){
    	try {
			
    		if(rowidP10polizas== null){
    			
    			action_create();
    			
    		}else if(rowidP10polizas != null){
    			
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
			
    		if(rowidP10polizas != null){
    			
    			//P10clientes p10clientes = businessDelegatorView.getP10clientes(rowidP10polizas);
    			
    			//if(p10clientes != null && p10clientes.getRowidcliente() != null){
    			//	businessDelegatorView.deleteP10clientes(p10clientes);
    			//}
    			
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
			/*
    		if(validandoDatos()){
    			
    			P10clientes p10clientes = new P10clientes();
    			p10clientes.setP00empresa(businessDelegatorView.getEmpresaUsuario());
    			p10clientes.setP00listaopcionByRowidtipocliente(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoCliente)));
    			p10clientes.setP00listaopcionByRowidtipoidentificacion(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoIdentificacion)));
    			p10clientes.setNumeroidentificacion(FacesUtils.checkString(txtNroIdentificacion));
    			p10clientes.setDigitoverificacion(FacesUtils.checkString(txtDigitoVerificacion));
    			p10clientes.setRazonsocial(FacesUtils.checkString(txtRazonSocial));
    			p10clientes.setNombres(FacesUtils.checkString(txtNombres));
    			p10clientes.setApellidos(FacesUtils.checkString(txtApellidos));
    			p10clientes.setFechanacimiento(calFechaNacimiento);
    			p10clientes.setP00listaopcionByRowidsexo(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoGenero)));
    			p10clientes.setP00listaopcionByRowidestadocivil(selTipoEstadoCivil != null ? businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoEstadoCivil)) : null);
    			p10clientes.setDireccion(FacesUtils.checkString(txtDireccion));
    			p10clientes.setTelefono(FacesUtils.checkString(txtTelefonos));
    			p10clientes.setCelular(FacesUtils.checkString(txtCelular));
    			p10clientes.setCorreopersonal(FacesUtils.checkString(txtCorreopersonal));
    			p10clientes.setCorreoinstitucional(FacesUtils.checkString(txtCorreoinstitucional));
    			p10clientes.setTienehijos(chHijos.getValue() != null ? (Boolean)chHijos.getValue() : false );
    			p10clientes.setCantidadhijos(FacesUtils.checkInteger(numCantidadHijos));
    			p10clientes.setTitularvivienda(rdTitularvivienda);
    			p10clientes.setP00listaopcionByRowidtipoprofesion(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoProfesion)));
    			p10clientes.setDescripcionprofesion(FacesUtils.checkString(txtDescProfesion));
    			p10clientes.setEmpresalabora(FacesUtils.checkString(txtEmpresa));
    			p10clientes.setDireccionempresa(FacesUtils.checkString(txtDireccionEmpresa));
    			p10clientes.setTelefonoempresa(FacesUtils.checkString(txtTelefonosEmpresa));
    			p10clientes.setHabilita(true);
    			p10clientes.setP00municipio(businessDelegatorView.getP00municipio(Integer.parseInt(selMunicipio)));
    			
    			businessDelegatorView.saveP10clientes(p10clientes);
    			
    			rowidP10clientes = p10clientes.getRowidcliente();
    			
    			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
    		}
    		*/
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
			/*
    		if(validandoDatos()){
    			
    			P10clientes p10clientes = new P10clientes();
    			p10clientes.setRowidcliente(rowidP10clientes);
    			p10clientes.setP00empresa(businessDelegatorView.getEmpresaUsuario());
    			p10clientes.setP00listaopcionByRowidtipocliente(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoCliente)));
    			p10clientes.setP00listaopcionByRowidtipoidentificacion(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoIdentificacion)));
    			p10clientes.setNumeroidentificacion(FacesUtils.checkString(txtNroIdentificacion));
    			p10clientes.setDigitoverificacion(FacesUtils.checkString(txtDigitoVerificacion));
    			p10clientes.setRazonsocial(FacesUtils.checkString(txtRazonSocial));
    			p10clientes.setNombres(FacesUtils.checkString(txtNombres));
    			p10clientes.setApellidos(FacesUtils.checkString(txtApellidos));
    			p10clientes.setFechanacimiento(calFechaNacimiento);
    			p10clientes.setP00listaopcionByRowidsexo(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoGenero)));
    			p10clientes.setP00listaopcionByRowidestadocivil(selTipoEstadoCivil != null ? businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoEstadoCivil)) : null);
    			p10clientes.setDireccion(FacesUtils.checkString(txtDireccion));
    			p10clientes.setTelefono(FacesUtils.checkString(txtTelefonos));
    			p10clientes.setCelular(FacesUtils.checkString(txtCelular));
    			p10clientes.setCorreopersonal(FacesUtils.checkString(txtCorreopersonal));
    			p10clientes.setCorreoinstitucional(FacesUtils.checkString(txtCorreoinstitucional));
    			p10clientes.setTienehijos(chHijos.getValue() != null ? (Boolean)chHijos.getValue() : false );
    			p10clientes.setCantidadhijos(FacesUtils.checkInteger(numCantidadHijos));
    			p10clientes.setTitularvivienda(rdTitularvivienda);
    			p10clientes.setP00listaopcionByRowidtipoprofesion(businessDelegatorView.getP00listaopcion(Integer.parseInt(selTipoProfesion)));
    			p10clientes.setDescripcionprofesion(FacesUtils.checkString(txtDescProfesion));
    			p10clientes.setEmpresalabora(FacesUtils.checkString(txtEmpresa));
    			p10clientes.setDireccionempresa(FacesUtils.checkString(txtDireccionEmpresa));
    			p10clientes.setTelefonoempresa(FacesUtils.checkString(txtTelefonosEmpresa));
    			p10clientes.setHabilita(true);
    			p10clientes.setP00municipio(businessDelegatorView.getP00municipio(Integer.parseInt(selMunicipio)));
    			
    			businessDelegatorView.updateP10clientes(p10clientes);
    			
    			rowidP10clientes = p10clientes.getRowidcliente();
    			
    			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
    		}
    		*/
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
    		
    		busquedaPrincipalList = new ArrayList<P10clientes>();
    		
    		List<P10clientes> p10clienteList = businessDelegatorView.getP10clientes();
    		
    		if(p10clienteList != null && p10clienteList.size() > 0){
    			
    			for (P10clientes p10clientes : p10clienteList) {
    				
    				if(p10clientes.getP00listaopcionByRowidtipoidentificacion() != null){
    				
    					P00listaopcion p00listaopcion = businessDelegatorView.getP00listaopcion(p10clientes.getP00listaopcionByRowidtipoidentificacion().getRowidopcion());
    					p10clientes.setP00listaopcionByRowidtipoidentificacion(p00listaopcion);
    				}
    			}
    			
    			busquedaPrincipalList = p10clienteList;
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
			/*
	    	if(busquedaPrincipal != null && busquedaPrincipal.getRowidcliente() != null){
	    		
	    		action_new();
	    		
	    	    rowidP10clientes = busquedaPrincipal.getRowidcliente();
	    	    
	    	    if(busquedaPrincipal.getP00listaopcionByRowidtipocliente() != null){
	    	    	selTipoCliente = busquedaPrincipal.getP00listaopcionByRowidtipocliente().getRowidopcion().toString();

	    	    	P00listaopcion p00listaopcion = habilitaTipoIdentificacion(busquedaPrincipal.getP00listaopcionByRowidtipocliente().getRowidopcion());
	    	    	
	    	    	if(busquedaPrincipal.getP00listaopcionByRowidtipoidentificacion() != null){
	    	    		
	    	    		cmbtipoIdentificacion.setValue(busquedaPrincipal.getP00listaopcionByRowidtipoidentificacion().getRowidopcion());
	    	    	}
	    	    	validarTipoPersona(p00listaopcion.getValor());
	    	    	
	    	    	txtRazonSocial.setValue(busquedaPrincipal.getRazonsocial());
	    	    }
	    	    
	    	    txtNroIdentificacion.setValue(busquedaPrincipal.getNumeroidentificacion());
	    	    onCalcularDigitoVerificacion();
	    	    
	    	    txtNombres.setValue(busquedaPrincipal.getNombres());
	    	    txtApellidos.setValue(busquedaPrincipal.getApellidos());
	    	    
	    	    calFechaNacimiento = busquedaPrincipal.getFechanacimiento();
	    	    
	    	    if(busquedaPrincipal.getP00listaopcionByRowidsexo() != null){
	    	    	selTipoGenero = busquedaPrincipal.getP00listaopcionByRowidsexo().getRowidopcion().toString();
	    	    }

	    	    if(busquedaPrincipal.getP00listaopcionByRowidestadocivil() != null){
	    	    	selTipoEstadoCivil = busquedaPrincipal.getP00listaopcionByRowidestadocivil().getRowidopcion().toString();
	    	    }

	    	    txtDireccion.setValue(busquedaPrincipal.getDireccion());
	    	    txtTelefonos.setValue(busquedaPrincipal.getTelefono());
	    	    txtCelular.setValue(busquedaPrincipal.getCelular());
	    	    txtCorreopersonal.setValue(busquedaPrincipal.getCorreopersonal());
	    	    txtCorreoinstitucional.setValue(busquedaPrincipal.getCorreoinstitucional());
	    	    chHijos.setValue(busquedaPrincipal.getTienehijos());
	    	    onCambioTieneHijos();
	    	    numCantidadHijos.setValue(busquedaPrincipal.getCantidadhijos());
	    	    
	    	    rdTitularvivienda = busquedaPrincipal.getTitularvivienda();
	    	    
	    	    if(busquedaPrincipal.getP00listaopcionByRowidtipoprofesion() != null){
	    	    	selTipoProfesion = busquedaPrincipal.getP00listaopcionByRowidtipoprofesion().getRowidopcion().toString();
	    	    }

	    	    txtDescProfesion.setValue(busquedaPrincipal.getDescripcionprofesion());
	    	    txtEmpresa.setValue(busquedaPrincipal.getEmpresalabora());
	    	    txtDireccionEmpresa.setValue(busquedaPrincipal.getDireccionempresa());
	    	    txtTelefonosEmpresa.setValue(busquedaPrincipal.getTelefonoempresa());

	    	    if(busquedaPrincipal.getP00municipio() != null){
	    	    	
	    	    	P00municipio p00municipio = businessDelegatorView.getP00municipio(busquedaPrincipal.getP00municipio().getIdmunicipio());
	    	    	
	    	    	if(p00municipio.getP00departamento() != null){
	    	    		
	    	    		P00departamento p00departamento = businessDelegatorView.getP00departamento(p00municipio.getP00departamento().getIddepartamento());
	    	    		selDepartamento = p00departamento.getIddepartamento().toString();
	    	    		
	    	    		onRowSelDepartamento();
	    	    		
	    	    		selMunicipio = busquedaPrincipal.getP00municipio().getIdmunicipio().toString();
	    	    	}
	    	    }
	    		
	    	}else{
	    		throw new Exception("Error al seleccionar un registro, intente de nuevo.");
	    	}
	    	*/
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
    		/*
    		if(selTipoCliente == null){
    			throw new Exception("Debe seleccionar un tipo de cliente.");
    		}

    		if(selTipoIdentificacion == null){
    			throw new Exception("Debe seleccionar un tipo de identificacion.");
    		}
    		
    		if(FacesUtils.checkString(txtNroIdentificacion) == null){
    			throw new Exception("Debe digitar un numero de identificación.");
    		}

    		if(FacesUtils.checkString(txtDigitoVerificacion) == null){
    			throw new Exception("Debe digitar el digito de verificacion.");
    		}

    		if(FacesUtils.checkString(txtNombres) == null){
    			throw new Exception("Debe digitar un nombre.");
    		}

    		if(FacesUtils.checkString(txtApellidos) == null){
    			throw new Exception("Debe digitar un apellido.");
    		}

    		if(selTipoGenero == null){
    			throw new Exception("Debe seleccionar el genero del cliente.");
    		}

    		if(selTipoProfesion == null){
    			throw new Exception("Debe seleccionar el tipo de profesion del cliente.");
    		}

    		if(selMunicipio == null){
    			throw new Exception("Debe seleccionar el Municipio.");
    		}
			*/
    		return true;
			
		} catch (Exception e) {
			throw e;
		}
    }

    //******************* reglas del cliente ****************************************

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
    			p10clientesTomador = null;
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que se encarga de cargar los datos del tomador.
     * @autor CACP - RFAST9 18/07/2016
     * @param p10clientes
     * @throws Exception
     */
    private void cargarDatosTomador(P10clientes p10clientes)throws Exception{
    	try {

    		if(p10clientes != null && p10clientes.getRowidcliente() != null){
    			
    			txtRazonSocialTomador.setValue((p10clientes.getRazonsocial() != null ? p10clientes.getRazonsocial() + " - " : "")  + p10clientes.getNombres() + " " + p10clientes.getApellidos());
    			p10clientesTomador = p10clientes;
    		}

		} catch (Exception e) {
			throw e;
		}
    }
    
    /**
     * metodo que consulta los datos del asegurado segun el tipo de identificacion y el numero de identificacion.
     * @autor CACP - RFAST9 18/07/2016
     */
    public void onRowBuscarAsegurado(){
    	try {
    		
    		if(FacesUtils.checkString(txtNroIdentificacionAsegurado) != null && (selTipoIdentificacionAsegurado != null && !selTipoIdentificacionAsegurado.isEmpty())){
    			
    			Object[] variables = {
    					"numeroidentificacion", true, FacesUtils.checkString(txtNroIdentificacionAsegurado), "=",
    					"p00listaopcionByRowidtipoidentificacion.rowidopcion", true, Integer.parseInt(selTipoIdentificacionAsegurado), "="
    			};
    			List<P10clientes> p10clientesList = businessDelegatorView.findByCriteriaInP10clientes(variables, null, null);
    			
    			if(p10clientesList != null && p10clientesList.size() > 0){
    				
    				P10clientes p10clientes = p10clientesList.get(p10clientesList.size()-1);
    				cargarDatosAsegurado(p10clientes);
    				
    			}else{
    				txtRazonSocialAsegurado.setValue(null);
    				throw new Exception("No se encontro ningún cliente con el numero de identificación " + FacesUtils.checkString(txtNroIdentificacionAsegurado) + ".");
    			}
    		}else{
    			txtRazonSocialAsegurado.setValue(null);
    			p10clientesAsegurado = null;
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que se encarga de cargar los datos del asegurado.
     * @autor CACP - RFAST9 18/07/2016
     * @param p10clientes
     * @throws Exception
     */
    private void cargarDatosAsegurado(P10clientes p10clientes)throws Exception{
    	try {

    		if(p10clientes != null && p10clientes.getRowidcliente() != null){
    			
    			txtRazonSocialAsegurado.setValue((p10clientes.getRazonsocial() != null ? p10clientes.getRazonsocial() + " - " : "")  + p10clientes.getNombres() + " " + p10clientes.getApellidos());
    			p10clientesAsegurado= p10clientes;
    		}

		} catch (Exception e) {
			throw e;
		}
    }    
    
    /**
     * metodo que consulta los datos del asegurado segun el tipo de identificacion y el numero de identificacion.
     * @autor CACP - RFAST9 18/07/2016
     */
    public void onRowBuscarBeneficiario(){
    	try {
    		
    		if(FacesUtils.checkString(txtNroIdentificacionBeneficiario) != null && (selTipoIdentificacionBeneficiario != null && !selTipoIdentificacionBeneficiario.isEmpty())){
    			
    			Object[] variables = {
    					"numeroidentificacion", true, FacesUtils.checkString(txtNroIdentificacionBeneficiario), "=",
    					"p00listaopcionByRowidtipoidentificacion.rowidopcion", true, Integer.parseInt(selTipoIdentificacionBeneficiario), "="
    			};
    			List<P10clientes> p10clientesList = businessDelegatorView.findByCriteriaInP10clientes(variables, null, null);
    			
    			if(p10clientesList != null && p10clientesList.size() > 0){
    				
    				P10clientes p10clientes = p10clientesList.get(p10clientesList.size()-1);
    				cargarDatosBeneficiario(p10clientes);
    				
    			}else{
    				txtRazonSocialBeneficiario.setValue(null);
    				throw new Exception("No se encontro ningún cliente con el numero de identificación " + FacesUtils.checkString(txtNroIdentificacionBeneficiario) + ".");
    			}
    		}else{
    			txtRazonSocialBeneficiario.setValue(null);
    			p10clientesBeneficiario = null;
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que se encarga de cargar los datos del asegurado.
     * @autor CACP - RFAST9 18/07/2016
     * @param p10clientes
     * @throws Exception
     */
    private void cargarDatosBeneficiario(P10clientes p10clientes)throws Exception{
    	try {

    		if(p10clientes != null && p10clientes.getRowidcliente() != null){
    			
    			txtRazonSocialBeneficiario.setValue((p10clientes.getRazonsocial() != null ? p10clientes.getRazonsocial() + " - " : "")  + p10clientes.getNombres() + " " + p10clientes.getApellidos());
    			p10clientesBeneficiario = p10clientes;
    		}

		} catch (Exception e) {
			throw e;
		}
    }   
    
    /**
     * mtoo que abre el dialogframework para cargar los datos del cliente.
     * @param 1: tomador, 2: asegurado, 3: beneficiario.
     * @autor CACP - RFAST9 18/07/2016
     */
    public void action_dialogDatosCliente(Integer indDatos){
    	try {

    		P10clientes p10clientes = new P10clientes();
    		
    		if(indDatos != null){

    			switch (indDatos) {
				case 1:
					
					p10clientes = p10clientesTomador;
					break;
				case 2:
					
					p10clientes = p10clientesAsegurado;
					break;
				case 3:
					
					p10clientes = p10clientesBeneficiario;
					break;

				default:
					break;
				}
    		}
    		
    		if(p10clientes != null && p10clientes.getRowidcliente() != null){

    			Map<String,List<String>> param = new HashMap<String, List<String>>();
    			List<String> data = new ArrayList<String>();
    			data.add(p10clientes.getRowidcliente().toString());
    			param.put("fnRowidCliente", data);
    			
    			Map<String,Object> options = new HashMap<String, Object>();
    			options.put("modal", true);
    			options.put("width", 930);
    			options.put("height", 440);
    			options.put("contentWidth", "100%");
    			options.put("contentHeight", "100%");
    			options.put("headerElement", "customheader");
    			
    			RequestContext.getCurrentInstance().openDialog("/XHTML/p10clientes.xhtml", options, param);
    		}else{
    			throw new Exception("Debe seleccionar un cliente para ver los datos.");
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

    /**
     * metodo que habilita controles para la forma de pago de la poliza
     * @autor CACP - RFAST9 29/07/2016
     */
    public void action_tipoFormaPago(){
    	try {
			
    		switch (selTipoFormasPago) {
			case "1":
				//rdFormaPagoContado.setRendererType("true");
				setRenderRdFormaPagoContado(true);
				break;
			case "2":
				//rdFormaPagoContado.setRendererType("false");
				setRenderRdFormaPagoContado(false);
				break;
			case "3":
				//rdFormaPagoContado.setRendererType("true");
				renderRdFormaPagoContado = true;
				break;
			default:
				break;
			}
    		
    		//RequestContext context = RequestContext.getCurrentInstance();
    		//context.update("formP10polizas:rdFormaPagoContado");
    		
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

	public void setSelTipoIdentificacionTomadorList(List<SelectItem> selTipoIdentificacionTomadorList) {
		this.selTipoIdentificacionTomadorList = selTipoIdentificacionTomadorList;
	}

	public String getSelTipoIdentificacionTomador() {
		return selTipoIdentificacionTomador;
	}

	public void setSelTipoIdentificacionTomador(String selTipoIdentificacionTomador) {
		this.selTipoIdentificacionTomador = selTipoIdentificacionTomador;
	}

	public Integer getRowidP10polizas() {
		return rowidP10polizas;
	}

	public void setRowidP10polizas(Integer rowidP10polizas) {
		this.rowidP10polizas = rowidP10polizas;
	}

	public InputText getTxtRazonSocialTomador() {
		return txtRazonSocialTomador;
	}

	public void setTxtRazonSocialTomador(InputText txtRazonSocialTomador) {
		this.txtRazonSocialTomador = txtRazonSocialTomador;
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

	public List<P10clientes> getBusquedaPrincipalList() {
		return busquedaPrincipalList;
	}

	public void setBusquedaPrincipalList(List<P10clientes> busquedaPrincipalList) {
		this.busquedaPrincipalList = busquedaPrincipalList;
	}

	public P10clientes getBusquedaPrincipal() {
		return busquedaPrincipal;
	}

	public void setBusquedaPrincipal(P10clientes busquedaPrincipal) {
		this.busquedaPrincipal = busquedaPrincipal;
	}

	public InputText getTxtNroIdentificacionTomador() {
		return txtNroIdentificacionTomador;
	}

	public void setTxtNroIdentificacionTomador(InputText txtNroIdentificacionTomador) {
		this.txtNroIdentificacionTomador = txtNroIdentificacionTomador;
	}

	public List<SelectItem> getSelTipoIdentificacionAseguradoList() throws Exception{
		selTipoIdentificacionAseguradoList = new ArrayList<SelectItem>();
		Object[] variables = {"variable", true, "tipoIdentificacion", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				selTipoIdentificacionAseguradoList.add(new SelectItem(p00listaopcion.getRowidopcion(), p00listaopcion.getNombre()));
			}
		}
		
		return selTipoIdentificacionAseguradoList;
	}

	public void setSelTipoIdentificacionAseguradoList(
			List<SelectItem> selTipoIdentificacionAseguradoList) {
		this.selTipoIdentificacionAseguradoList = selTipoIdentificacionAseguradoList;
	}

	public String getSelTipoIdentificacionAsegurado() {
		return selTipoIdentificacionAsegurado;
	}

	public void setSelTipoIdentificacionAsegurado(
			String selTipoIdentificacionAsegurado) {
		this.selTipoIdentificacionAsegurado = selTipoIdentificacionAsegurado;
	}

	public InputText getTxtNroIdentificacionAsegurado() {
		return txtNroIdentificacionAsegurado;
	}

	public void setTxtNroIdentificacionAsegurado(
			InputText txtNroIdentificacionAsegurado) {
		this.txtNroIdentificacionAsegurado = txtNroIdentificacionAsegurado;
	}

	public InputText getTxtRazonSocialAsegurado() {
		return txtRazonSocialAsegurado;
	}

	public void setTxtRazonSocialAsegurado(InputText txtRazonSocialAsegurado) {
		this.txtRazonSocialAsegurado = txtRazonSocialAsegurado;
	}

	public List<SelectItem> getSelTipoIdentificacionBeneficiarioList() throws Exception{
		selTipoIdentificacionBeneficiarioList = new ArrayList<SelectItem>();
		Object[] variables = {"variable", true, "tipoIdentificacion", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				selTipoIdentificacionBeneficiarioList.add(new SelectItem(p00listaopcion.getRowidopcion(), p00listaopcion.getNombre()));
			}
		}
		
		return selTipoIdentificacionBeneficiarioList;
	}

	public void setSelTipoIdentificacionBeneficiarioList(
			List<SelectItem> selTipoIdentificacionBeneficiarioList) {
		this.selTipoIdentificacionBeneficiarioList = selTipoIdentificacionBeneficiarioList;
	}

	public String getSelTipoIdentificacionBeneficiario() {
		return selTipoIdentificacionBeneficiario;
	}

	public void setSelTipoIdentificacionBeneficiario(
			String selTipoIdentificacionBeneficiario) {
		this.selTipoIdentificacionBeneficiario = selTipoIdentificacionBeneficiario;
	}

	public InputText getTxtNroIdentificacionBeneficiario() {
		return txtNroIdentificacionBeneficiario;
	}

	public void setTxtNroIdentificacionBeneficiario(
			InputText txtNroIdentificacionBeneficiario) {
		this.txtNroIdentificacionBeneficiario = txtNroIdentificacionBeneficiario;
	}

	public InputText getTxtRazonSocialBeneficiario() {
		return txtRazonSocialBeneficiario;
	}

	public void setTxtRazonSocialBeneficiario(InputText txtRazonSocialBeneficiario) {
		this.txtRazonSocialBeneficiario = txtRazonSocialBeneficiario;
	}

	public P10clientes getP10clientesTomador() {
		return p10clientesTomador;
	}

	public void setP10clientesTomador(P10clientes p10clientesTomador) {
		this.p10clientesTomador = p10clientesTomador;
	}

	public P10clientes getP10clientesAsegurado() {
		return p10clientesAsegurado;
	}

	public void setP10clientesAsegurado(P10clientes p10clientesAsegurado) {
		this.p10clientesAsegurado = p10clientesAsegurado;
	}

	public P10clientes getP10clientesBeneficiario() {
		return p10clientesBeneficiario;
	}

	public void setP10clientesBeneficiario(P10clientes p10clientesBeneficiario) {
		this.p10clientesBeneficiario = p10clientesBeneficiario;
	}

	public List<SelectItem> getTipoAseguradoraList() {
		return tipoAseguradoraList;
	}

	public void setTipoAseguradoraList(List<SelectItem> tipoAseguradoraList) {
		this.tipoAseguradoraList = tipoAseguradoraList;
	}

	public String getTipoAseguradora() {
		return tipoAseguradora;
	}

	public void setTipoAseguradora(String tipoAseguradora) {
		this.tipoAseguradora = tipoAseguradora;
	}

	public List<SelectItem> getTipoAseguradoraRamoList() {
		return tipoAseguradoraRamoList;
	}

	public void setTipoAseguradoraRamoList(List<SelectItem> tipoAseguradoraRamoList) {
		this.tipoAseguradoraRamoList = tipoAseguradoraRamoList;
	}

	public String getTipoAseguradoraRamo() {
		return tipoAseguradoraRamo;
	}

	public void setTipoAseguradoraRamo(String tipoAseguradoraRamo) {
		this.tipoAseguradoraRamo = tipoAseguradoraRamo;
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

	public InputText getTxtNroPoliza() {
		return txtNroPoliza;
	}

	public void setTxtNroPoliza(InputText txtNroPoliza) {
		this.txtNroPoliza = txtNroPoliza;
	}

	public Double getMonValorRiesgoAsegurado() {
		return monValorRiesgoAsegurado;
	}

	public void setMonValorRiesgoAsegurado(Double monValorRiesgoAsegurado) {
		this.monValorRiesgoAsegurado = monValorRiesgoAsegurado;
	}

	public Double getMonValorPrima() {
		return monValorPrima;
	}

	public void setMonValorPrima(Double monValorPrima) {
		this.monValorPrima = monValorPrima;
	}

	public Double getMonValorGastos() {
		return monValorGastos;
	}

	public void setMonValorGastos(Double monValorGastos) {
		this.monValorGastos = monValorGastos;
	}

	public Double getMonValorIVA() {
		return monValorIVA;
	}

	public void setMonValorIVA(Double monValorIVA) {
		this.monValorIVA = monValorIVA;
	}

	public Double getMonValorTotalPrima() {
		return monValorTotalPrima;
	}

	public void setMonValorTotalPrima(Double monValorTotalPrima) {
		this.monValorTotalPrima = monValorTotalPrima;
	}

	public List<SelectItem> getSelTipoFormasPagoList() {
		
		selTipoFormasPagoList = new ArrayList<SelectItem>();
		
		selTipoFormasPagoList.add(new  SelectItem("1", "Contado"));
		selTipoFormasPagoList.add(new  SelectItem("2", "Tarjeta de credito"));
		selTipoFormasPagoList.add(new  SelectItem("3", "Financiado"));
		
		return selTipoFormasPagoList;
	}

	public void setSelTipoFormasPagoList(List<SelectItem> selTipoFormasPagoList) {
		this.selTipoFormasPagoList = selTipoFormasPagoList;
	}

	public String getSelTipoFormasPago() {
		return selTipoFormasPago;
	}

	public void setSelTipoFormasPago(String selTipoFormasPago) {
		this.selTipoFormasPago = selTipoFormasPago;
	}

	public SelectOneRadio getRdFormaPagoContado() {
		return rdFormaPagoContado;
	}

	public void setRdFormaPagoContado(SelectOneRadio rdFormaPagoContado) {
		this.rdFormaPagoContado = rdFormaPagoContado;
	}

	public Boolean getRenderRdFormaPagoContado() {
		return renderRdFormaPagoContado;
	}

	public void setRenderRdFormaPagoContado(Boolean renderRdFormaPagoContado) {
		this.renderRdFormaPagoContado = renderRdFormaPagoContado;
	}

}
