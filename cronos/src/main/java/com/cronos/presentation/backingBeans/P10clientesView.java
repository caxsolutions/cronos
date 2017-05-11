package com.cronos.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.panel.Panel;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P00departamento;
import com.cronos.modelo.P00listaopcion;
import com.cronos.modelo.P00municipio;
import com.cronos.modelo.P10clientes;
import com.cronos.presentation.businessDelegate.IBusinessDelegatorView;
import com.cronos.utilities.FacesUtils;
import com.cronos.utilities.Utilities;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class P10clientesView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P10clientesView.class);

    private Integer rowidP10clientes;
    private String fnRowidCliente;
    
    //**combo tipo de cliente ******
    private List<SelectItem> selTipoClienteList;
    private String selTipoCliente;

    private InputText txtRazonSocial;
    private Panel panelRazonsocial;
    
    //**combo tipo de identificacion ******
    private List<SelectItem> selTipoIdentificacionList;
    private String selTipoIdentificacion;
    private SelectOneMenu cmbtipoIdentificacion;

    private InputText txtNroIdentificacion;
    private InputText txtDigitoVerificacion;
    
    private InputText txtNombres;
    private InputText txtApellidos;
    
    private Date calFechaNacimiento;
    
    //**combo tipo de genero ******
    private List<SelectItem> selTipoGeneroList;
    private String selTipoGenero;

    //**combo tipo estaod civil ******
    private List<SelectItem> selTipoEstadoCivilList;
    private String selTipoEstadoCivil;

    private InputText txtDireccion;
    private InputText txtTelefonos;
    private InputText txtCelular;
    private InputText txtCorreopersonal;
    private InputText txtCorreoinstitucional;
    private SelectBooleanCheckbox chHijos;
    private Spinner numCantidadHijos;
    
    private Integer rdTitularvivienda;
    
    //**combo tipo profesion ******
    private List<SelectItem> selTipoProfesionList;
    private String selTipoProfesion;

    private InputText txtDescProfesion;
    private InputText txtEmpresa;
    private InputText txtDireccionEmpresa;
    private InputText txtTelefonosEmpresa;

    private String selDepartamento;   
    private List<SelectItem> selDepartamentoList;

    private String selMunicipio;   
    private List<SelectItem> selMunicipioList;
    private SelectOneMenu cbSelMunicipio;

    private CommandButton btnNuevo;
    private CommandButton btnGuardar;
    private CommandButton btnDelete;
    private CommandButton btnBuscar;
    
    //****** busqueda principal ******
    private List<P10clientes> busquedaPrincipalList;
    private P10clientes busquedaPrincipal;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public P10clientesView() {
    	
        super();
    }
    
	public void onloadView() throws Exception{
		try {
			if(!FacesContext.getCurrentInstance().isPostback()){
				
				Integer rowidClientes = fnRowidCliente != null && !fnRowidCliente.equals("null") && !fnRowidCliente.isEmpty() ? Integer.parseInt(fnRowidCliente) : null;
				
				if(rowidClientes != null){
					cargarDatosCliente(rowidClientes);
					habilitarBotonesToolbar(false);
				}else{
					habilitarBotonesToolbar(true);
				}
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}

    
    /**
     * evento boton nuevo
     * @autor CACP - RFAST9 8/07/2016
     */
    public void action_new(){
    	try {
			
    	    selTipoCliente = null;

    	    txtRazonSocial.setValue(null);
    	    panelRazonsocial.setVisible(false);
    	    
    	    cmbtipoIdentificacion.setValue(null);

    	    txtNroIdentificacion.setValue(null);
    	    txtDigitoVerificacion.setValue(null);
    	    
    	    txtNombres.setValue(null);
    	    txtApellidos.setValue(null);
    	    
    	    calFechaNacimiento = null;
    	    
    	    selTipoGenero = null;

    	    selTipoEstadoCivil = null;

    	    txtDireccion.setValue(null);
    	    txtTelefonos.setValue(null);
    	    txtCelular.setValue(null);
    	    txtCorreopersonal.setValue(null);
    	    txtCorreoinstitucional.setValue(null);
    	    chHijos.setValue(false);
    	    rdTitularvivienda = (null);
    	    
    	    selTipoProfesion = null;
    	    
    	    selDepartamento = null;
    	    onRowSelDepartamento();

    	    txtDescProfesion.setValue(null);
    	    txtEmpresa.setValue(null);
    	    txtDireccionEmpresa.setValue(null);
    	    txtTelefonosEmpresa.setValue(null);
    		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    public void action_save(){
    	try {
			
    		if(rowidP10clientes == null){
    			
    			action_create();
    			
    		}else if(rowidP10clientes != null){
    			
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
			
    		if(rowidP10clientes != null){
    			
    			P10clientes p10clientes = businessDelegatorView.getP10clientes(rowidP10clientes);
    			
    			if(p10clientes != null && p10clientes.getRowidcliente() != null){
    				businessDelegatorView.deleteP10clientes(p10clientes);
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
    			
    			returnDialogFramework(p10clientes);
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
			
	    	cargarDatosFormulario();
	    	
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}	
    }

    private void cargarDatosFormulario() throws Exception{
    	try {
			
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
		} catch (Exception e) {
			throw e;
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

    		return true;
			
		} catch (Exception e) {
			throw e;
		}
    }

    private void returnDialogFramework(P10clientes p10clientes){
    	
    	Integer rowidClientes = fnRowidCliente != null && !fnRowidCliente.equals("null") && !fnRowidCliente.isEmpty() ? Integer.parseInt(fnRowidCliente) : null;
    	
    	if(rowidClientes == null){
    		RequestContext.getCurrentInstance().closeDialog(p10clientes);
    	}
    }
    
    //******************* reglas del cliente ****************************************
    /**
     * evento que al seleccionar un departamento habilita y filtra los municipios por departamento
     * @autor CACP - RFAST9 18/07/2016
     */
    public void onRowSelDepartamento(){
    	try {
    		
    		if(selDepartamento != null && !selDepartamento.isEmpty()){
    			
				selMunicipioList = new ArrayList<SelectItem>();
				
				Object[] variables = {"p00departamento.iddepartamento", false, Integer.parseInt(selDepartamento), "="};
				List<P00municipio> p00municipioList = businessDelegatorView.findByCriteriaInP00municipio(variables, null, null);
				
				if(p00municipioList != null && p00municipioList.size() > 0){
					for (P00municipio p00municipio : p00municipioList) {
						selMunicipioList.add(new SelectItem(p00municipio.getIdmunicipio(), "[" + p00municipio.getMunicipio() + "] " + p00municipio.getNombre()));
					}
				}
    			
				selMunicipio = null;
    			cbSelMunicipio.setDisabled(false);
    			
    		}else{
    			selMunicipio = null;
    			cbSelMunicipio.setDisabled(true);
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * se dispara al seleccionar el chec de tiene hijos para especificar la cantidad de hijos.
     * @autor CACP - RFAST9 18/07/2016
     */
    public void onCambioTieneHijos(){
    	try {
		
    		Boolean estadoTieneHijos = (Boolean)chHijos.getValue();

    		if(estadoTieneHijos){
    			numCantidadHijos.setDisabled(false);
    			
    		}else{
    			numCantidadHijos.setDisabled(true);
    			numCantidadHijos.setValue(0);
    		}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que calcular el digito de verificacion
     * @autor CACP - RFAST9 18/07/2016
     */
    public void onCalcularDigitoVerificacion(){
    	try {
			
    		if(FacesUtils.checkString(txtNroIdentificacion) != null){
    			txtDigitoVerificacion.setValue(Utilities.validarDigitoVerificacion(FacesUtils.checkString(txtNroIdentificacion)));
    		}
    		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que se dispara al seleccionar un tipo de cliente
     * @autor CACP - RFAST9 8/07/2016
     */
    public void onRowSelTipoCliente()throws Exception{
    	try {
			
    		Integer rowidTipoCliente = selTipoCliente != null && !selTipoCliente.isEmpty() ? Integer.parseInt(selTipoCliente) : null;
    		
    		P00listaopcion p00listaopcion = habilitaTipoIdentificacion(rowidTipoCliente);
    		
			if(p00listaopcion != null && p00listaopcion.getRowidopcion() != null){
				
				//persona juridica
				if(p00listaopcion.getValor() == 2){
					
					Object[] variables = {"variable", true, "tipoIdentificacion", "=", "valor", false, 3, "="};
					List<P00listaopcion> p00listaopcionlist = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
					
					if(p00listaopcionlist != null && p00listaopcionlist.size() > 0){
						
						selTipoIdentificacion = p00listaopcionlist.get(p00listaopcionlist.size()-1).getRowidopcion().toString();
						cmbtipoIdentificacion.setValue(p00listaopcionlist.get(p00listaopcionlist.size()-1).getRowidopcion());
					}
				}
				
				validarTipoPersona(p00listaopcion.getValor());
			}
    		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que habilita o deshabiita el combo de tipo de identificacion.
     * @autor CACP - RFAST9 18/07/2016
     * @param rowidTipoCliente
     * @throws Exception
     */
    private P00listaopcion habilitaTipoIdentificacion(Integer rowidTipoCliente) throws Exception{
    	try {
    		P00listaopcion p00listaopcion = new P00listaopcion();
    		
    		if(rowidTipoCliente != null){
    			p00listaopcion = businessDelegatorView.getP00listaopcion(rowidTipoCliente);
    			
    			if(p00listaopcion != null && p00listaopcion.getRowidopcion() != null){
    				
    				//persona juridica
    				if(p00listaopcion.getValor() == 2){
    					
						cmbtipoIdentificacion.setDisabled(true);
    				}else{
    					cmbtipoIdentificacion.setDisabled(false);
    				}
    			}
    		}
    		
    		return p00listaopcion;
    		
		} catch (Exception e) {
			throw e;
		}
    }
    
    /**
     * metodo que valid el tipo de cliente y muestra o no la razon social.
     * @autor CACP - RFAST9 8/07/2016
     */
    private void validarTipoPersona(Integer idTipoCliente)throws Exception{
    	try {
			
    		txtRazonSocial.setValue(null);
    		
    		if(idTipoCliente != null && idTipoCliente == 2){

    		    panelRazonsocial.setVisible(true);
    		}else{
    			panelRazonsocial.setVisible(false);
    		}
    		
		} catch (Exception e) {
			throw e;
		}
    }
    
    /**
     * metodo que habilita o deshabilita lso botones del toolbar principal
     * @autor CACP - RFAST9 22/07/2016
     * @param estado
     * @throws Exception
     */
	private void habilitarBotonesToolbar(Boolean estado)throws Exception{
		try {
			
			btnDelete =  new CommandButton();
			btnGuardar =  new CommandButton();
			btnNuevo =  new CommandButton();
			btnBuscar =  new CommandButton();
			
			btnDelete.setDisabled(!estado);
			btnGuardar.setDisabled(!estado);
			btnNuevo.setDisabled(!estado);
			btnBuscar.setDisabled(!estado);
			
			RequestContext context = RequestContext.getCurrentInstance();
			List<String> s = new ArrayList<String>();
			s.add("formP10clientes:btnDelete");
			s.add("formP10clientes:btnGuardar");
			s.add("formP10clientes:btnNuevo");
			s.add("formP10clientes:btnBuscar");
			context.update(s);			
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * metodo que se dispara al llamarlo desde otro form con dialogframework. buscar los datos del cliente y los carga
	 * @autor CACP - RFAST9 22/07/2016
	 * @param rowidClientes
	 * @throws Exception
	 */
	private void cargarDatosCliente(Integer rowidClientes)throws Exception{
		try {
			
			if(rowidClientes != null){

				P10clientes p10clientes = businessDelegatorView.getP10clientes(rowidClientes);
				
				if(p10clientes != null && p10clientes.getRowidcliente() != null){
					
					busquedaPrincipal = p10clientes;
					cargarDatosFormulario();
				}
			}
			
		} catch (Exception e) {
			throw e;
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

	public List<SelectItem> getSelTipoClienteList() throws Exception{
		
		selTipoClienteList = new ArrayList<SelectItem>();
		Object[] variables = {"variable", true, "tipoCliente", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				selTipoClienteList.add(new SelectItem(p00listaopcion.getRowidopcion(), p00listaopcion.getNombre()));
			}
		}
		
		return selTipoClienteList;
	}

	public void setSelTipoClienteList(List<SelectItem> selTipoClienteList) {
		this.selTipoClienteList = selTipoClienteList;
	}

	public String getSelTipoCliente() {
		return selTipoCliente;
	}

	public void setSelTipoCliente(String selTipoCliente) {
		this.selTipoCliente = selTipoCliente;
	}

	public List<SelectItem> getSelTipoIdentificacionList() throws Exception {

		selTipoIdentificacionList = new ArrayList<SelectItem>();
		Object[] variables = {"variable", true, "tipoIdentificacion", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				selTipoIdentificacionList.add(new SelectItem(p00listaopcion.getRowidopcion(), "[" + p00listaopcion.getAbreviacion() + "] " + p00listaopcion.getNombre()));
			}
		}

		return selTipoIdentificacionList;
	}

	public void setSelTipoIdentificacionList(
			List<SelectItem> selTipoIdentificacionList) {
		this.selTipoIdentificacionList = selTipoIdentificacionList;
	}

	public String getSelTipoIdentificacion() {
		return selTipoIdentificacion;
	}

	public void setSelTipoIdentificacion(String selTipoIdentificacion) {
		this.selTipoIdentificacion = selTipoIdentificacion;
	}

	public SelectOneMenu getCmbtipoIdentificacion() {
		return cmbtipoIdentificacion;
	}

	public void setCmbtipoIdentificacion(SelectOneMenu cmbtipoIdentificacion) {
		this.cmbtipoIdentificacion = cmbtipoIdentificacion;
	}

	public InputText getTxtNroIdentificacion() {
		return txtNroIdentificacion;
	}

	public void setTxtNroIdentificacion(InputText txtNroIdentificacion) {
		this.txtNroIdentificacion = txtNroIdentificacion;
	}

	public InputText getTxtDigitoVerificacion() {
		return txtDigitoVerificacion;
	}

	public void setTxtDigitoVerificacion(InputText txtDigitoVerificacion) {
		this.txtDigitoVerificacion = txtDigitoVerificacion;
	}

	public InputText getTxtNombres() {
		return txtNombres;
	}

	public void setTxtNombres(InputText txtNombres) {
		this.txtNombres = txtNombres;
	}

	public InputText getTxtApellidos() {
		return txtApellidos;
	}

	public void setTxtApellidos(InputText txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public Date getCalFechaNacimiento() {
		return calFechaNacimiento;
	}

	public void setCalFechaNacimiento(Date calFechaNacimiento) {
		this.calFechaNacimiento = calFechaNacimiento;
	}

	public List<SelectItem> getSelTipoGeneroList() throws Exception{
		
		selTipoGeneroList = new ArrayList<SelectItem>();
		Object[] variables = {"variable", true, "tipoGenero", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				selTipoGeneroList.add(new SelectItem(p00listaopcion.getRowidopcion(), p00listaopcion.getNombre()));
			}
		}
		
		return selTipoGeneroList;
	}

	public void setSelTipoGeneroList(List<SelectItem> selTipoGeneroList) {
		this.selTipoGeneroList = selTipoGeneroList;
	}

	public String getSelTipoGenero() {
		return selTipoGenero;
	}

	public void setSelTipoGenero(String selTipoGenero) {
		this.selTipoGenero = selTipoGenero;
	}

	public List<SelectItem> getSelTipoEstadoCivilList() throws Exception{
		
		selTipoEstadoCivilList = new ArrayList<SelectItem>();
		Object[] variables = {"variable", true, "tipoEstadoCivil", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				selTipoEstadoCivilList.add(new SelectItem(p00listaopcion.getRowidopcion(), p00listaopcion.getNombre()));
			}
		}

		return selTipoEstadoCivilList;
	}

	public void setSelTipoEstadoCivilList(List<SelectItem> selTipoEstadoCivilList) {
		this.selTipoEstadoCivilList = selTipoEstadoCivilList;
	}

	public String getSelTipoEstadoCivil(){
		return selTipoEstadoCivil;
	}

	public void setSelTipoEstadoCivil(String selTipoEstadoCivil) {
		this.selTipoEstadoCivil = selTipoEstadoCivil;
	}

	public InputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public InputText getTxtTelefonos() {
		return txtTelefonos;
	}

	public void setTxtTelefonos(InputText txtTelefonos) {
		this.txtTelefonos = txtTelefonos;
	}


	public InputText getTxtCorreoinstitucional() {
		return txtCorreoinstitucional;
	}

	public void setTxtCorreoinstitucional(InputText txtCorreoinstitucional) {
		this.txtCorreoinstitucional = txtCorreoinstitucional;
	}

	public SelectBooleanCheckbox getChHijos() {
		return chHijos;
	}

	public void setChHijos(SelectBooleanCheckbox chHijos) {
		this.chHijos = chHijos;
	}

	public List<SelectItem> getSelTipoProfesionList() throws Exception{
		
		selTipoProfesionList = new ArrayList<SelectItem>();
		Object[] variables = {"variable", true, "tipoProfesion", "="};
		List<P00listaopcion> p00listaopcionList = businessDelegatorView.findByCriteriaInP00listaopcion(variables, null, null);
		
		if(p00listaopcionList != null && p00listaopcionList.size() > 0){
			for (P00listaopcion p00listaopcion : p00listaopcionList) {
				selTipoProfesionList.add(new SelectItem(p00listaopcion.getRowidopcion(), p00listaopcion.getNombre()));
			}
		}
		
		return selTipoProfesionList;
	}

	public void setSelTipoProfesionList(List<SelectItem> selTipoProfesionList) {
		this.selTipoProfesionList = selTipoProfesionList;
	}

	public String getSelTipoProfesion() {
		return selTipoProfesion;
	}

	public void setSelTipoProfesion(String selTipoProfesion) {
		this.selTipoProfesion = selTipoProfesion;
	}

	public InputText getTxtDescProfesion() {
		return txtDescProfesion;
	}

	public void setTxtDescProfesion(InputText txtDescProfesion) {
		this.txtDescProfesion = txtDescProfesion;
	}

	public InputText getTxtEmpresa() {
		return txtEmpresa;
	}

	public void setTxtEmpresa(InputText txtEmpresa) {
		this.txtEmpresa = txtEmpresa;
	}

	public InputText getTxtDireccionEmpresa() {
		return txtDireccionEmpresa;
	}

	public void setTxtDireccionEmpresa(InputText txtDireccionEmpresa) {
		this.txtDireccionEmpresa = txtDireccionEmpresa;
	}

	public InputText getTxtTelefonosEmpresa() {
		return txtTelefonosEmpresa;
	}

	public void setTxtTelefonosEmpresa(InputText txtTelefonosEmpresa) {
		this.txtTelefonosEmpresa = txtTelefonosEmpresa;
	}

	public InputText getTxtRazonSocial() {
		return txtRazonSocial;
	}

	public void setTxtRazonSocial(InputText txtRazonSocial) {
		this.txtRazonSocial = txtRazonSocial;
	}

	public Panel getPanelRazonsocial() {
		return panelRazonsocial;
	}

	public void setPanelRazonsocial(Panel panelRazonsocial) {
		this.panelRazonsocial = panelRazonsocial;
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

	public Integer getRowidP10clientes() {
		return rowidP10clientes;
	}

	public void setRowidP10clientes(Integer rowidP10clientes) {
		this.rowidP10clientes = rowidP10clientes;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public InputText getTxtCelular() {
		return txtCelular;
	}

	public void setTxtCelular(InputText txtCelular) {
		this.txtCelular = txtCelular;
	}

	public InputText getTxtCorreopersonal() {
		return txtCorreopersonal;
	}

	public void setTxtCorreopersonal(InputText txtCorreopersonal) {
		this.txtCorreopersonal = txtCorreopersonal;
	}

	public Spinner getNumCantidadHijos() {
		return numCantidadHijos;
	}

	public void setNumCantidadHijos(Spinner numCantidadHijos) {
		this.numCantidadHijos = numCantidadHijos;
	}

	public Integer getRdTitularvivienda() {
		return rdTitularvivienda;
	}

	public void setRdTitularvivienda(Integer rdTitularvivienda) {
		this.rdTitularvivienda = rdTitularvivienda;
	}

	public String getSelDepartamento() {
		return selDepartamento;
	}

	public void setSelDepartamento(String selDepartamento) {
		this.selDepartamento = selDepartamento;
	}

	public List<SelectItem> getSelDepartamentoList() throws Exception{
		
		if(selDepartamentoList == null){
			
			selDepartamentoList = new ArrayList<SelectItem>();
			
			List<P00departamento> p00departamentoList = businessDelegatorView.getP00departamento();
			
			if(p00departamentoList != null && p00departamentoList.size() > 0){
				for (P00departamento p00departamento : p00departamentoList) {
					selDepartamentoList.add(new SelectItem(p00departamento.getIddepartamento(), "[" + p00departamento.getDepartamento() + "] " + p00departamento.getNombre()));
				}
			}
		}

		return selDepartamentoList;
	}

	public void setSelDepartamentoList(List<SelectItem> selDepartamentoList) {
		this.selDepartamentoList = selDepartamentoList;
	}

	public String getSelMunicipio() {
		return selMunicipio;
	}

	public void setSelMunicipio(String selMunicipio) {
		this.selMunicipio = selMunicipio;
	}

	public List<SelectItem> getSelMunicipioList() throws Exception{
		return selMunicipioList;
	}

	public void setSelMunicipioList(List<SelectItem> selMunicipioList) {
		this.selMunicipioList = selMunicipioList;
	}

	public SelectOneMenu getCbSelMunicipio() {
		return cbSelMunicipio;
	}

	public void setCbSelMunicipio(SelectOneMenu cbSelMunicipio) {
		this.cbSelMunicipio = cbSelMunicipio;
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

	public String getFnRowidCliente() {
		return fnRowidCliente;
	}

	public void setFnRowidCliente(String fnRowidCliente) {
		this.fnRowidCliente = fnRowidCliente;
	}

	public CommandButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(CommandButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	
}
