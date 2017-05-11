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
public class P00menuDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P00menuDTO.class);
    private String componentes;
    private String encabezado;
    private String expandido;
    private String habilita;
    private String imagen;
    private String indice;
    private String instanciamultiple;
    private String nombre;
    private Integer rowidmenu;
    private String validacion;

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getExpandido() {
        return expandido;
    }

    public void setExpandido(String expandido) {
        this.expandido = expandido;
    }

    public String getHabilita() {
        return habilita;
    }

    public void setHabilita(String habilita) {
        this.habilita = habilita;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getInstanciamultiple() {
        return instanciamultiple;
    }

    public void setInstanciamultiple(String instanciamultiple) {
        this.instanciamultiple = instanciamultiple;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRowidmenu() {
        return rowidmenu;
    }

    public void setRowidmenu(Integer rowidmenu) {
        this.rowidmenu = rowidmenu;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }
}
