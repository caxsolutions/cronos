package com.cronos.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.cronos.modelo.dto.ext.DataAdicionTabPrincipalDTOExt;
import com.cronos.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class ViewportView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String pathIncludeMenu;
	private List<DataAdicionTabPrincipalDTOExt> adicionTabPrincipalDTOExtList = new ArrayList<DataAdicionTabPrincipalDTOExt>();
	private String page;
    
    public ViewportView() {
        super();
    }

    @PostConstruct
    public void initLoad(){
    	try {
    		//CmpTabPrincipalContenedorView cmpTabPrincipalContenedorView = (CmpTabPrincipalContenedorView) FacesUtils.getManagedBean("cmpTabPrincipalContenedorView");
    		//cmpTabPrincipalContenedorView.preCondiciones("formViewport");

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    /**
     * metodo que agrga los tab en el contenedor principal
     * @autor CACP - RFAST9 7/07/2016
     */
    public void adicionarTab(Integer indTab){
    	try {
			
    		if(indTab != null){
    			
    			DataAdicionTabPrincipalDTOExt adicionTabPrincipalDTOExt = new DataAdicionTabPrincipalDTOExt();

				adicionTabPrincipalDTOExt.setNombreXhtml("/XHTML/p13clientes.xhtml");
				adicionTabPrincipalDTOExt.setTitulo("Clientes");

    			adicionTabPrincipalDTOExtList.add(adicionTabPrincipalDTOExt);
    			
    			RequestContext context = RequestContext.getCurrentInstance();
    			List<String> s = new ArrayList<String>();
    			s.add("formViewportMenu");
    			context.update(s);
    		}
    			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    public void renderInclude(Integer indTab){
		switch (indTab) {
		case 1:
			
			pathIncludeMenu = "/XHTML/p10clientes.xhtml";

    		break;
		case 2:

			pathIncludeMenu = "/XHTML/p00empresa.xhtml";

    		break;
		case 3:

			pathIncludeMenu = "/XHTML/p00usuario.xhtml";

    		break;
		default:
			break;
		}
    }
    
	public List<DataAdicionTabPrincipalDTOExt> getAdicionTabPrincipalDTOExtList() {
		return adicionTabPrincipalDTOExtList;
	}

	public void setAdicionTabPrincipalDTOExtList(
			List<DataAdicionTabPrincipalDTOExt> adicionTabPrincipalDTOExtList) {
		this.adicionTabPrincipalDTOExtList = adicionTabPrincipalDTOExtList;
	}

	public String getPathIncludeMenu() {
		return pathIncludeMenu;
	}

	public void setPathIncludeMenu(String pathIncludeMenu) {
		this.pathIncludeMenu = pathIncludeMenu;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
}
