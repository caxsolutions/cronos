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
public class P00perfilDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P00perfilDTO.class);
    private Integer diasvigencia;
    private Boolean habilita;
    private String nombre;
    private String perfil;
    private Integer rowidperfil;
    private Integer rowidempresa_P00empresa;

    public Integer getDiasvigencia() {
        return diasvigencia;
    }

    public void setDiasvigencia(Integer diasvigencia) {
        this.diasvigencia = diasvigencia;
    }

    public Boolean getHabilita() {
        return habilita;
    }

    public void setHabilita(Boolean habilita) {
        this.habilita = habilita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Integer getRowidperfil() {
        return rowidperfil;
    }

    public void setRowidperfil(Integer rowidperfil) {
        this.rowidperfil = rowidperfil;
    }

    public Integer getRowidempresa_P00empresa() {
        return rowidempresa_P00empresa;
    }

    public void setRowidempresa_P00empresa(Integer rowidempresa_P00empresa) {
        this.rowidempresa_P00empresa = rowidempresa_P00empresa;
    }
}
