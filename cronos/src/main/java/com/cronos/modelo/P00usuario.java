package com.cronos.modelo;
// Generated 6/07/2016 09:47:47 AM by Hibernate Tools 4.3.1.Final


import java.util.Date;

/**
 * P00usuario generated by hbm2java
 */
public class P00usuario  implements java.io.Serializable {


     private Long rowidusuario;
     private P00empresa p00empresa;
     private P00perfil p00perfil;
     private String usuario;
     private String descripcion;
     private String validacion;
     private Boolean cambiacontrasena;
     private Date fechacambio;
     private Boolean habilita;

    public P00usuario() {
    }

	
    public P00usuario(Long rowidusuario, P00empresa p00empresa, P00perfil p00perfil, String usuario, String descripcion, Boolean cambiacontrasena, Boolean habilita) {
        this.rowidusuario = rowidusuario;
        this.p00empresa = p00empresa;
        this.p00perfil = p00perfil;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.cambiacontrasena = cambiacontrasena;
        this.habilita = habilita;
    }
    public P00usuario(Long rowidusuario, P00empresa p00empresa, P00perfil p00perfil, String usuario, String descripcion, String validacion, Boolean cambiacontrasena, Date fechacambio, Boolean habilita) {
       this.rowidusuario = rowidusuario;
       this.p00empresa = p00empresa;
       this.p00perfil = p00perfil;
       this.usuario = usuario;
       this.descripcion = descripcion;
       this.validacion = validacion;
       this.cambiacontrasena = cambiacontrasena;
       this.fechacambio = fechacambio;
       this.habilita = habilita;
    }
   
    public Long getRowidusuario() {
        return this.rowidusuario;
    }
    
    public void setRowidusuario(Long rowidusuario) {
        this.rowidusuario = rowidusuario;
    }
    public P00empresa getP00empresa() {
        return this.p00empresa;
    }
    
    public void setP00empresa(P00empresa p00empresa) {
        this.p00empresa = p00empresa;
    }
    public P00perfil getP00perfil() {
        return this.p00perfil;
    }
    
    public void setP00perfil(P00perfil p00perfil) {
        this.p00perfil = p00perfil;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getValidacion() {
        return this.validacion;
    }
    
    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }
    public Boolean getCambiacontrasena() {
        return this.cambiacontrasena;
    }
    
    public void setCambiacontrasena(Boolean cambiacontrasena) {
        this.cambiacontrasena = cambiacontrasena;
    }
    public Date getFechacambio() {
        return this.fechacambio;
    }
    
    public void setFechacambio(Date fechacambio) {
        this.fechacambio = fechacambio;
    }
    public Boolean getHabilita() {
        return this.habilita;
    }
    
    public void setHabilita(Boolean habilita) {
        this.habilita = habilita;
    }




}


