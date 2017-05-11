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
public class P00empresaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P00empresaDTO.class);
    private String correo;
    private String descripcion;
    private Integer digitoverificacion;
    private String direccion;
    private String empresa;
    private Boolean habilita;
    private String logo1;
    private String nit;
    private Integer rowidempresa;
    private String telefono;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDigitoverificacion() {
        return digitoverificacion;
    }

    public void setDigitoverificacion(Integer digitoverificacion) {
        this.digitoverificacion = digitoverificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Boolean getHabilita() {
        return habilita;
    }

    public void setHabilita(Boolean habilita) {
        this.habilita = habilita;
    }

    public String getLogo1() {
        return logo1;
    }

    public void setLogo1(String logo1) {
        this.logo1 = logo1;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getRowidempresa() {
        return rowidempresa;
    }

    public void setRowidempresa(Integer rowidempresa) {
        this.rowidempresa = rowidempresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
