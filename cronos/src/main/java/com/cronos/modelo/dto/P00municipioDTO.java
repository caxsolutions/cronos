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
public class P00municipioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P00municipioDTO.class);
    private Integer idmunicipio;
    private String municipio;
    private String nombre;
    private Integer iddepartamento_P00departamento;

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIddepartamento_P00departamento() {
        return iddepartamento_P00departamento;
    }

    public void setIddepartamento_P00departamento(
        Integer iddepartamento_P00departamento) {
        this.iddepartamento_P00departamento = iddepartamento_P00departamento;
    }
}
