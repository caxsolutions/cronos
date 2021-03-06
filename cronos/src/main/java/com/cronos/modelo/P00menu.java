package com.cronos.modelo;
// Generated 6/07/2016 09:47:47 AM by Hibernate Tools 4.3.1.Final


import java.util.HashSet;
import java.util.Set;

/**
 * P00menu generated by hbm2java
 */
public class P00menu  implements java.io.Serializable {


     private Integer rowidmenu;
     private String indice;
     private String nombre;
     private String imagen;
     private String habilita;
     private String encabezado;
     private String componentes;
     private String expandido;
     private String instanciamultiple;
     private String validacion;
     private Set<P00perfilmenu> p00perfilmenus = new HashSet<P00perfilmenu>(0);

    public P00menu() {
    }

	
    public P00menu(Integer rowidmenu, String indice, String nombre, String imagen, String habilita, String encabezado, String expandido, String instanciamultiple, String validacion) {
        this.rowidmenu = rowidmenu;
        this.indice = indice;
        this.nombre = nombre;
        this.imagen = imagen;
        this.habilita = habilita;
        this.encabezado = encabezado;
        this.expandido = expandido;
        this.instanciamultiple = instanciamultiple;
        this.validacion = validacion;
    }
    public P00menu(Integer rowidmenu, String indice, String nombre, String imagen, String habilita, String encabezado, String componentes, String expandido, String instanciamultiple, String validacion, Set<P00perfilmenu> p00perfilmenus) {
       this.rowidmenu = rowidmenu;
       this.indice = indice;
       this.nombre = nombre;
       this.imagen = imagen;
       this.habilita = habilita;
       this.encabezado = encabezado;
       this.componentes = componentes;
       this.expandido = expandido;
       this.instanciamultiple = instanciamultiple;
       this.validacion = validacion;
       this.p00perfilmenus = p00perfilmenus;
    }
   
    public Integer getRowidmenu() {
        return this.rowidmenu;
    }
    
    public void setRowidmenu(Integer rowidmenu) {
        this.rowidmenu = rowidmenu;
    }
    public String getIndice() {
        return this.indice;
    }
    
    public void setIndice(String indice) {
        this.indice = indice;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getHabilita() {
        return this.habilita;
    }
    
    public void setHabilita(String habilita) {
        this.habilita = habilita;
    }
    public String getEncabezado() {
        return this.encabezado;
    }
    
    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }
    public String getComponentes() {
        return this.componentes;
    }
    
    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }
    public String getExpandido() {
        return this.expandido;
    }
    
    public void setExpandido(String expandido) {
        this.expandido = expandido;
    }
    public String getInstanciamultiple() {
        return this.instanciamultiple;
    }
    
    public void setInstanciamultiple(String instanciamultiple) {
        this.instanciamultiple = instanciamultiple;
    }
    public String getValidacion() {
        return this.validacion;
    }
    
    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }
    public Set<P00perfilmenu> getP00perfilmenus() {
        return this.p00perfilmenus;
    }
    
    public void setP00perfilmenus(Set<P00perfilmenu> p00perfilmenus) {
        this.p00perfilmenus = p00perfilmenus;
    }




}


