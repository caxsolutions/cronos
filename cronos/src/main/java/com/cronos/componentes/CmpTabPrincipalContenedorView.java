package com.cronos.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabCloseEvent;

import com.cronos.modelo.dto.ext.DataAdicionTabPrincipalDTOExt;
import com.cronos.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class CmpTabPrincipalContenedorView implements Serializable {

	private static final long serialVersionUID = 1L;

	private TabView contendorTabView;
	private String idFormCmpTpc;
    private List<DataAdicionTabPrincipalDTOExt> adicionTabPrincipalDTOExtList = new ArrayList<DataAdicionTabPrincipalDTOExt>(); 
    
    public CmpTabPrincipalContenedorView() {
        super();
    }

    /**
     * Metodo para establecer precondiciones
     * @param idForm : Id del formulario que contiene al componente de captura de documento interno
     * @throws Exception 
     */
    public void preCondiciones(String idForm) throws Exception{
    	
    	this.idFormCmpTpc = idForm;
		updateFormularioContenedor();
    }

	/**
	 * Metodo llamado desde la presentacion cuando se cierra la caja de dialogo
	 */
	public void updateFormularioContenedor() {
		if(idFormCmpTpc != null){
			RequestContext context = RequestContext.getCurrentInstance();
			context.update(this.idFormCmpTpc.trim());
		}
	} 	

    /**
     * metodo que agrga los tab en el contenedor principal
     * @autor CACP - RFAST9 7/07/2016
     */
    public void adicionarTab(Integer idTab, String titulo, String nombrexhtml){
    	try {
    		
    		if(idTab != null){
    			
    			Boolean agregar = true;
    			Integer index = 0;
    			
    			if(adicionTabPrincipalDTOExtList != null && adicionTabPrincipalDTOExtList.size() > 0){
    				for (int i = 0; i < adicionTabPrincipalDTOExtList.size() ; i++) {
						
    					DataAdicionTabPrincipalDTOExt dataAdicionTabPrincipalDTOExt = adicionTabPrincipalDTOExtList.get(i);
    					
    					if(dataAdicionTabPrincipalDTOExt.getIndTab().equals(idTab)){
    						agregar = false;
    						index = i;
    					}
					}
    			}
    			
    			if(agregar){
    				
    				DataAdicionTabPrincipalDTOExt adicionTabPrincipalDTOExt = new DataAdicionTabPrincipalDTOExt();
    				adicionTabPrincipalDTOExt.setNombreXhtml("XHTML/" + nombrexhtml + ".xhtml");
    				adicionTabPrincipalDTOExt.setTitulo(titulo);
    				adicionTabPrincipalDTOExt.setIndTab(idTab);
    				
    				adicionTabPrincipalDTOExtList.add(adicionTabPrincipalDTOExt);
    				contendorTabView.setActiveIndex(adicionTabPrincipalDTOExtList.size()-1);
    			}else{
    				contendorTabView.setActiveIndex(index);
    			}
    			
    			RequestContext context = RequestContext.getCurrentInstance();
    			List<String> s = new ArrayList<String>();
    			s.add(this.idFormCmpTpc.trim() + ":tabViewPrincipal");
    			context.update(s);
    		}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    /**
     * cierra tab evento
     */
    public void onTabClose(TabCloseEvent event){
    	try {
			
    		DataAdicionTabPrincipalDTOExt adicionTabPrincipalDTOExt = (DataAdicionTabPrincipalDTOExt)event.getData();
    		
    		Iterator<DataAdicionTabPrincipalDTOExt> iterator = adicionTabPrincipalDTOExtList.iterator();
    		
    		while (iterator.hasNext()) {
				
    			DataAdicionTabPrincipalDTOExt dataAdicionTabPrincipalDTOExt = (DataAdicionTabPrincipalDTOExt) iterator.next();
				
    			if(dataAdicionTabPrincipalDTOExt.getIndTab().equals(adicionTabPrincipalDTOExt.getIndTab())){
    				iterator.remove();
    			}
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    //---------------------------- get - set ---------------------------------------
	public String getidFormCmpTpc() {
		return idFormCmpTpc;
	}

	public void setidFormCmpTpc(String idFormCmpTpc) {
		this.idFormCmpTpc = idFormCmpTpc;
	}

	public String getIdFormCmpTpc() {
		return idFormCmpTpc;
	}

	public void setIdFormCmpTpc(String idFormCmpTpc) {
		this.idFormCmpTpc = idFormCmpTpc;
	}

	public List<DataAdicionTabPrincipalDTOExt> getAdicionTabPrincipalDTOExtList() {
		return adicionTabPrincipalDTOExtList;
	}

	public void setAdicionTabPrincipalDTOExtList(
			List<DataAdicionTabPrincipalDTOExt> adicionTabPrincipalDTOExtList) {
		this.adicionTabPrincipalDTOExtList = adicionTabPrincipalDTOExtList;
	}

	public TabView getContendorTabView() {
		return contendorTabView;
	}

	public void setContendorTabView(TabView contendorTabView) {
		this.contendorTabView = contendorTabView;
	}
	
}
