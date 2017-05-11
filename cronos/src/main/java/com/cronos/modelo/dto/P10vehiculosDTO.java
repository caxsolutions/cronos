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
public class P10vehiculosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P10vehiculosDTO.class);
    private Integer capacidadtoneladas;
    private String cilindraje;
    private String codigofasecolda;
    private String modelo;
    private String nrochasis;
    private String nromotor;
    private String nropasajeros;
    private String numeroplaca;
    private Integer rowidvehiculos;
    private Integer rowidempresa_P00empresa;
    private Integer rowidopcion_P00listaopcionclasevehiculo;
    private Integer rowidopcion_P00listaopciontiposervicio;
    private Integer rowidcliente_P10clientes;

    public Integer getCapacidadtoneladas() {
        return capacidadtoneladas;
    }

    public void setCapacidadtoneladas(Integer capacidadtoneladas) {
        this.capacidadtoneladas = capacidadtoneladas;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getCodigofasecolda() {
        return codigofasecolda;
    }

    public void setCodigofasecolda(String codigofasecolda) {
        this.codigofasecolda = codigofasecolda;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNrochasis() {
        return nrochasis;
    }

    public void setNrochasis(String nrochasis) {
        this.nrochasis = nrochasis;
    }

    public String getNromotor() {
        return nromotor;
    }

    public void setNromotor(String nromotor) {
        this.nromotor = nromotor;
    }

    public String getNropasajeros() {
        return nropasajeros;
    }

    public void setNropasajeros(String nropasajeros) {
        this.nropasajeros = nropasajeros;
    }

    public String getNumeroplaca() {
        return numeroplaca;
    }

    public void setNumeroplaca(String numeroplaca) {
        this.numeroplaca = numeroplaca;
    }

    public Integer getRowidvehiculos() {
        return rowidvehiculos;
    }

    public void setRowidvehiculos(Integer rowidvehiculos) {
        this.rowidvehiculos = rowidvehiculos;
    }

    public Integer getRowidempresa_P00empresa() {
        return rowidempresa_P00empresa;
    }

    public void setRowidempresa_P00empresa(Integer rowidempresa_P00empresa) {
        this.rowidempresa_P00empresa = rowidempresa_P00empresa;
    }

    public Integer getRowidopcion_P00listaopcionclasevehiculo() {
		return rowidopcion_P00listaopcionclasevehiculo;
	}

	public void setRowidopcion_P00listaopcionclasevehiculo(
			Integer rowidopcion_P00listaopcionclasevehiculo) {
		this.rowidopcion_P00listaopcionclasevehiculo = rowidopcion_P00listaopcionclasevehiculo;
	}

	public Integer getRowidopcion_P00listaopciontiposervicio() {
		return rowidopcion_P00listaopciontiposervicio;
	}

	public void setRowidopcion_P00listaopciontiposervicio(
			Integer rowidopcion_P00listaopciontiposervicio) {
		this.rowidopcion_P00listaopciontiposervicio = rowidopcion_P00listaopciontiposervicio;
	}

	public Integer getRowidcliente_P10clientes() {
        return rowidcliente_P10clientes;
    }

    public void setRowidcliente_P10clientes(Integer rowidcliente_P10clientes) {
        this.rowidcliente_P10clientes = rowidcliente_P10clientes;
    }
}
