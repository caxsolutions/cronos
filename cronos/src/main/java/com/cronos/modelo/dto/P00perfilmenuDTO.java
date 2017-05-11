package com.cronos.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class P00perfilmenuDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P00perfilmenuDTO.class);
    private Integer rowidperfilmenu;
    private Integer rowidmenu_P00menu;
    private Integer rowidperfil_P00perfil;

    public Integer getRowidperfilmenu() {
        return rowidperfilmenu;
    }

    public void setRowidperfilmenu(Integer rowidperfilmenu) {
        this.rowidperfilmenu = rowidperfilmenu;
    }

    public Integer getRowidmenu_P00menu() {
        return rowidmenu_P00menu;
    }

    public void setRowidmenu_P00menu(Integer rowidmenu_P00menu) {
        this.rowidmenu_P00menu = rowidmenu_P00menu;
    }

    public Integer getRowidperfil_P00perfil() {
        return rowidperfil_P00perfil;
    }

    public void setRowidperfil_P00perfil(Integer rowidperfil_P00perfil) {
        this.rowidperfil_P00perfil = rowidperfil_P00perfil;
    }
}
