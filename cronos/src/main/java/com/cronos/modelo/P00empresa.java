package com.cronos.modelo;
// Generated 6/07/2016 09:47:47 AM by Hibernate Tools 4.3.1.Final


import java.util.HashSet;
import java.util.Set;

/**
 * P00empresa generated by hbm2java
 */
public class P00empresa  implements java.io.Serializable {


     private Integer rowidempresa;
     private String empresa;
     private String descripcion;
     private String nit;
     private Integer digitoverificacion;
     private String direccion;
     private String telefono;
     private String correo;
     private Boolean habilita;
     private String logo1;
     private Set<P10vehiculos> p10vehiculoses = new HashSet<P10vehiculos>(0);
     private Set<P00usuario> p00usuarios = new HashSet<P00usuario>(0);
     private Set<P00perfil> p00perfils = new HashSet<P00perfil>(0);
     private Set<P10clientes> p10clienteses = new HashSet<P10clientes>(0);

    public P00empresa() {
    }

	
    public P00empresa(Integer rowidempresa, String empresa, String descripcion, String nit, Integer digitoverificacion, Boolean habilita) {
        this.rowidempresa = rowidempresa;
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.nit = nit;
        this.digitoverificacion = digitoverificacion;
        this.habilita = habilita;
    }
    public P00empresa(Integer rowidempresa, String empresa, String descripcion, String nit, Integer digitoverificacion, String direccion, String telefono, String correo, Boolean habilita, String logo1, Set<P00usuario> p00usuarios, Set<P00perfil> p00perfils, Set<P10clientes> p10clienteses) {
       this.rowidempresa = rowidempresa;
       this.empresa = empresa;
       this.descripcion = descripcion;
       this.nit = nit;
       this.digitoverificacion = digitoverificacion;
       this.direccion = direccion;
       this.telefono = telefono;
       this.correo = correo;
       this.habilita = habilita;
       this.logo1 = logo1;
       this.p00usuarios = p00usuarios;
       this.p00perfils = p00perfils;
       this.p10clienteses = p10clienteses;
    }
   
    public Integer getRowidempresa() {
        return this.rowidempresa;
    }
    
    public void setRowidempresa(Integer rowidempresa) {
        this.rowidempresa = rowidempresa;
    }
    public String getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNit() {
        return this.nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }
    public Integer getDigitoverificacion() {
        return this.digitoverificacion;
    }
    
    public void setDigitoverificacion(Integer digitoverificacion) {
        this.digitoverificacion = digitoverificacion;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Boolean getHabilita() {
        return this.habilita;
    }
    
    public void setHabilita(Boolean habilita) {
        this.habilita = habilita;
    }
    public String getLogo1() {
        return this.logo1;
    }
    
    public void setLogo1(String logo1) {
        this.logo1 = logo1;
    }
    public Set<P00usuario> getP00usuarios() {
        return this.p00usuarios;
    }
    
    public void setP00usuarios(Set<P00usuario> p00usuarios) {
        this.p00usuarios = p00usuarios;
    }
    public Set<P00perfil> getP00perfils() {
        return this.p00perfils;
    }
    
    public void setP00perfils(Set<P00perfil> p00perfils) {
        this.p00perfils = p00perfils;
    }
    public Set<P10clientes> getP10clienteses() {
        return this.p10clienteses;
    }
    
    public void setP10clienteses(Set<P10clientes> p10clienteses) {
        this.p10clienteses = p10clienteses;
    }

	public Set<P10vehiculos> getP10vehiculoses() {
		return p10vehiculoses;
	}

	public void setP10vehiculoses(Set<P10vehiculos> p10vehiculoses) {
		this.p10vehiculoses = p10vehiculoses;
	}
}

