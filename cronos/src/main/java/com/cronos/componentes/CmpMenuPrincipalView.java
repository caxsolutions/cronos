package com.cronos.componentes;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.cronos.modelo.P00perfil;
import com.cronos.modelo.P00usuario;
import com.cronos.presentation.businessDelegate.IBusinessDelegatorView;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *
 */
@ManagedBean
@ViewScoped
public class CmpMenuPrincipalView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private MenuModel modelMenuPrincipal;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public CmpMenuPrincipalView() {
        super();
    }
    
    @PostConstruct
    public void init(){
    	try {
    		cargarMenuPrincipalDinamico();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }    
    
    private void cargarMenuPrincipalDinamico()throws Exception{
    	
    	P00usuario usuarioLogin =  businessDelegatorView.getUsuarioLogin();
    	
    	if(usuarioLogin != null && usuarioLogin.getRowidusuario() != null){
    		
    		if(usuarioLogin.getP00perfil() != null){
    		
    			P00perfil perfileLogin = businessDelegatorView.getP00perfil(usuarioLogin.getP00perfil().getRowidperfil());
    			
    	    	modelMenuPrincipal = new DefaultMenuModel();
    	        
    	    	//PBX submenu
    	        DefaultSubMenu pbxSubmenu = new DefaultSubMenu("Parámetros");
    	        
    	        DefaultMenuItem item = new DefaultMenuItem();
    	        
    	        //------------- Clientes -----------
    	        item = new DefaultMenuItem("Clientes");
    	        item.setUrl("/XHTML/denied.xhtml");
    	        item.setIcon("ui-icon-contact");

    	        //if(perfileLogin.getF0011Fop()){
        	        item.setUrl("/XHTML/p10clientes.xhtml");
    	        //}
    	        pbxSubmenu.addElement(item);

    	        //------------- Polizas -----------
    	        item = new DefaultMenuItem("Polizas");
    	        item.setUrl("/XHTML/denied.xhtml");
    	        item.setIcon("ui-icon-contact");

    	        //if(perfileLogin.getF0011Fop()){
        	        item.setUrl("/XHTML/p10polizas.xhtml");
    	        //}
    	        pbxSubmenu.addElement(item);

    	        //----------------------------- configurcion ---------------------------
    	        DefaultSubMenu configSubmenu = new DefaultSubMenu("Configuración");

    	        modelMenuPrincipal.addElement(pbxSubmenu);
    	        modelMenuPrincipal.addElement(configSubmenu);
    		}
    	}
    }

	public MenuModel getModelMenuPrincipal() {
		return modelMenuPrincipal;
	}

	public void setModelMenuPrincipal(MenuModel modelMenuPrincipal) {
		this.modelMenuPrincipal = modelMenuPrincipal;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
}
