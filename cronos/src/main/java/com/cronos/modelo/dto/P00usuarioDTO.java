package com.cronos.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class P00usuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P00usuarioDTO.class);
    private Boolean cambiacontrasena;
    private String descripcion;
    private Date fechacambio;
    private Boolean habilita;
    private Long rowidusuario;
    private String usuario;
    private String validacion;
    private Integer rowidempresa_P00empresa;
    private Integer rowidperfil_P00perfil;

    public Boolean getCambiacontrasena() {
        return cambiacontrasena;
    }

    public void setCambiacontrasena(Boolean cambiacontrasena) {
        this.cambiacontrasena = cambiacontrasena;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechacambio() {
        return fechacambio;
    }

    public void setFechacambio(Date fechacambio) {
        this.fechacambio = fechacambio;
    }

    public Boolean getHabilita() {
        return habilita;
    }

    public void setHabilita(Boolean habilita) {
        this.habilita = habilita;
    }

    public Long getRowidusuario() {
        return rowidusuario;
    }

    public void setRowidusuario(Long rowidusuario) {
        this.rowidusuario = rowidusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    public Integer getRowidempresa_P00empresa() {
        return rowidempresa_P00empresa;
    }

    public void setRowidempresa_P00empresa(Integer rowidempresa_P00empresa) {
        this.rowidempresa_P00empresa = rowidempresa_P00empresa;
    }

    public Integer getRowidperfil_P00perfil() {
        return rowidperfil_P00perfil;
    }

    public void setRowidperfil_P00perfil(Integer rowidperfil_P00perfil) {
        this.rowidperfil_P00perfil = rowidperfil_P00perfil;
    }
}
