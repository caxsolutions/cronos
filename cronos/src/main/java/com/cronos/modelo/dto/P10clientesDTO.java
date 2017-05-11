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
public class P10clientesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(P10clientesDTO.class);
    private String apellidos;
    private String correopersonal;
    private String descripcionprofesion;
    private String digitoverificacion;
    private String direccion;
    private String direccionempresa;
    private String empresalabora;
    private Date fechanacimiento;
    private Boolean habilita;
    private String nombres;
    private String numeroidentificacion;
    private String razonsocial;
    private Integer rowidcliente;
    private String telefono;
    private String telefonoempresa;
    private Boolean tienehijos;
    private Integer rowidempresa_P00empresa;
    private Integer rowidtipocliente_P00listaopcion;
    private Integer rowidtipoidentificacion_P00listaopcion;
    private Integer rowidsexo_P00listaopcion;
    private Integer rowidestadocivil_P00listaopcion;
    private Integer rowidtipoprofesion_P00listaopcion;
    private String celular;
    private String correoinstitucional;
    private Integer cantidadhijos;
    private Integer titularvivienda;
    private Integer idmunicipio_P00municipio;

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreopersonal() {
        return correopersonal;
    }

    public void setCorreopersonal(String correopersonal) {
        this.correopersonal = correopersonal;
    }

    public String getDescripcionprofesion() {
        return descripcionprofesion;
    }

    public void setDescripcionprofesion(String descripcionprofesion) {
        this.descripcionprofesion = descripcionprofesion;
    }

    public String getDigitoverificacion() {
        return digitoverificacion;
    }

    public void setDigitoverificacion(String digitoverificacion) {
        this.digitoverificacion = digitoverificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionempresa() {
        return direccionempresa;
    }

    public void setDireccionempresa(String direccionempresa) {
        this.direccionempresa = direccionempresa;
    }

    public String getEmpresalabora() {
        return empresalabora;
    }

    public void setEmpresalabora(String empresalabora) {
        this.empresalabora = empresalabora;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Boolean getHabilita() {
        return habilita;
    }

    public void setHabilita(Boolean habilita) {
        this.habilita = habilita;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumeroidentificacion() {
        return numeroidentificacion;
    }

    public void setNumeroidentificacion(String numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public Integer getRowidcliente() {
        return rowidcliente;
    }

    public void setRowidcliente(Integer rowidcliente) {
        this.rowidcliente = rowidcliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoempresa() {
        return telefonoempresa;
    }

    public void setTelefonoempresa(String telefonoempresa) {
        this.telefonoempresa = telefonoempresa;
    }

    public Boolean getTienehijos() {
        return tienehijos;
    }

    public void setTienehijos(Boolean tienehijos) {
        this.tienehijos = tienehijos;
    }

    public Integer getRowidempresa_P00empresa() {
        return rowidempresa_P00empresa;
    }

    public void setRowidempresa_P00empresa(Integer rowidempresa_P00empresa) {
        this.rowidempresa_P00empresa = rowidempresa_P00empresa;
    }

	public Integer getRowidtipocliente_P00listaopcion() {
		return rowidtipocliente_P00listaopcion;
	}

	public void setRowidtipocliente_P00listaopcion(Integer rowidtipocliente_P00listaopcion) {
		this.rowidtipocliente_P00listaopcion = rowidtipocliente_P00listaopcion;
	}

	public Integer getRowidtipoidentificacion_P00listaopcion() {
		return rowidtipoidentificacion_P00listaopcion;
	}

	public void setRowidtipoidentificacion_P00listaopcion(Integer rowidtipoidentificacion_P00listaopcion) {
		this.rowidtipoidentificacion_P00listaopcion = rowidtipoidentificacion_P00listaopcion;
	}

	public Integer getRowidsexo_P00listaopcion() {
		return rowidsexo_P00listaopcion;
	}

	public void setRowidsexo_P00listaopcion(Integer rowidsexo_P00listaopcion) {
		this.rowidsexo_P00listaopcion = rowidsexo_P00listaopcion;
	}

	public Integer getRowidestadocivil_P00listaopcion() {
		return rowidestadocivil_P00listaopcion;
	}

	public void setRowidestadocivil_P00listaopcion(Integer rowidestadocivil_P00listaopcion) {
		this.rowidestadocivil_P00listaopcion = rowidestadocivil_P00listaopcion;
	}

	public Integer getRowidtipoprofesion_P00listaopcion() {
		return rowidtipoprofesion_P00listaopcion;
	}

	public void setRowidtipoprofesion_P00listaopcion(Integer rowidtipoprofesion_P00listaopcion) {
		this.rowidtipoprofesion_P00listaopcion = rowidtipoprofesion_P00listaopcion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreoinstitucional() {
		return correoinstitucional;
	}

	public void setCorreoinstitucional(String correoinstitucional) {
		this.correoinstitucional = correoinstitucional;
	}

	public Integer getCantidadhijos() {
		return cantidadhijos;
	}

	public void setCantidadhijos(Integer cantidadhijos) {
		this.cantidadhijos = cantidadhijos;
	}

	public Integer getTitularvivienda() {
		return titularvivienda;
	}

	public void setTitularvivienda(Integer titularvivienda) {
		this.titularvivienda = titularvivienda;
	}

	public Integer getIdmunicipio_P00municipio() {
		return idmunicipio_P00municipio;
	}

	public void setIdmunicipio_P00municipio(Integer idmunicipio_P00municipio) {
		this.idmunicipio_P00municipio = idmunicipio_P00municipio;
	}
	
}
