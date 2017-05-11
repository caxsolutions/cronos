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
public class P10soatDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P10soatDTO.class);
    private Date fechaexpedicion;
    private Date fechainiciovigencia;
    private Boolean habilita;
    private Integer rowidsoat;
    private Integer rowidcliente_P10clientes;
    private Integer rowidvehiculos_P10vehiculos;
    private String observaciones;
    
    public Date getFechaexpedicion() {
        return fechaexpedicion;
    }

    public void setFechaexpedicion(Date fechaexpedicion) {
        this.fechaexpedicion = fechaexpedicion;
    }

    public Date getFechainiciovigencia() {
        return fechainiciovigencia;
    }

    public void setFechainiciovigencia(Date fechainiciovigencia) {
        this.fechainiciovigencia = fechainiciovigencia;
    }

    public Boolean getHabilita() {
        return habilita;
    }

    public void setHabilita(Boolean habilita) {
        this.habilita = habilita;
    }

    public Integer getRowidsoat() {
        return rowidsoat;
    }

    public void setRowidsoat(Integer rowidsoat) {
        this.rowidsoat = rowidsoat;
    }

    public Integer getRowidcliente_P10clientes() {
        return rowidcliente_P10clientes;
    }

    public void setRowidcliente_P10clientes(Integer rowidcliente_P10clientes) {
        this.rowidcliente_P10clientes = rowidcliente_P10clientes;
    }

    public Integer getRowidvehiculos_P10vehiculos() {
        return rowidvehiculos_P10vehiculos;
    }

    public void setRowidvehiculos_P10vehiculos(
        Integer rowidvehiculos_P10vehiculos) {
        this.rowidvehiculos_P10vehiculos = rowidvehiculos_P10vehiculos;
    }

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
    
}
