package com.cronos.presentation.businessDelegate;

import java.util.List;

import com.cronos.modelo.P00departamento;
import com.cronos.modelo.P00empresa;
import com.cronos.modelo.P00listaopcion;
import com.cronos.modelo.P00menu;
import com.cronos.modelo.P00municipio;
import com.cronos.modelo.P00perfil;
import com.cronos.modelo.P00perfilmenu;
import com.cronos.modelo.P00usuario;
import com.cronos.modelo.P10clientes;
import com.cronos.modelo.P10soat;
import com.cronos.modelo.P10vehiculos;
import com.cronos.modelo.dto.P00departamentoDTO;
import com.cronos.modelo.dto.P00empresaDTO;
import com.cronos.modelo.dto.P00listaopcionDTO;
import com.cronos.modelo.dto.P00menuDTO;
import com.cronos.modelo.dto.P00municipioDTO;
import com.cronos.modelo.dto.P00perfilDTO;
import com.cronos.modelo.dto.P00perfilmenuDTO;
import com.cronos.modelo.dto.P00usuarioDTO;
import com.cronos.modelo.dto.P10clientesDTO;
import com.cronos.modelo.dto.P10soatDTO;
import com.cronos.modelo.dto.P10vehiculosDTO;
import com.cronos.modelo.dto.ext.DataSoatVehiculosDTOExt;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<P00departamento> getP00departamento() throws Exception;

    public void saveP00departamento(P00departamento entity)
        throws Exception;

    public void deleteP00departamento(P00departamento entity)
        throws Exception;

    public void updateP00departamento(P00departamento entity)
        throws Exception;

    public P00departamento getP00departamento(Integer iddepartamento)
        throws Exception;

    public List<P00departamento> findByCriteriaInP00departamento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<P00departamento> findPageP00departamento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberP00departamento() throws Exception;

    public List<P00departamentoDTO> getDataP00departamento()
        throws Exception;

    public List<P00empresa> getP00empresa() throws Exception;

    public void saveP00empresa(P00empresa entity) throws Exception;

    public void deleteP00empresa(P00empresa entity) throws Exception;

    public void updateP00empresa(P00empresa entity) throws Exception;

    public P00empresa getP00empresa(Integer rowidempresa)
        throws Exception;

    public List<P00empresa> findByCriteriaInP00empresa(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00empresa> findPageP00empresa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00empresa() throws Exception;

    public List<P00empresaDTO> getDataP00empresa() throws Exception;

    public List<P00listaopcion> getP00listaopcion() throws Exception;

    public void saveP00listaopcion(P00listaopcion entity)
        throws Exception;

    public void deleteP00listaopcion(P00listaopcion entity)
        throws Exception;

    public void updateP00listaopcion(P00listaopcion entity)
        throws Exception;

    public P00listaopcion getP00listaopcion(Integer rowidopcion)
        throws Exception;

    public List<P00listaopcion> findByCriteriaInP00listaopcion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<P00listaopcion> findPageP00listaopcion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00listaopcion() throws Exception;

    public List<P00listaopcionDTO> getDataP00listaopcion()
        throws Exception;

    public List<P00menu> getP00menu() throws Exception;

    public void saveP00menu(P00menu entity) throws Exception;

    public void deleteP00menu(P00menu entity) throws Exception;

    public void updateP00menu(P00menu entity) throws Exception;

    public P00menu getP00menu(Integer rowidmenu) throws Exception;

    public List<P00menu> findByCriteriaInP00menu(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00menu> findPageP00menu(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00menu() throws Exception;

    public List<P00menuDTO> getDataP00menu() throws Exception;

    public List<P00municipio> getP00municipio() throws Exception;

    public void saveP00municipio(P00municipio entity) throws Exception;

    public void deleteP00municipio(P00municipio entity)
        throws Exception;

    public void updateP00municipio(P00municipio entity)
        throws Exception;

    public P00municipio getP00municipio(Integer idmunicipio)
        throws Exception;

    public List<P00municipio> findByCriteriaInP00municipio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00municipio> findPageP00municipio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00municipio() throws Exception;

    public List<P00municipioDTO> getDataP00municipio()
        throws Exception;

    public List<P00perfil> getP00perfil() throws Exception;

    public void saveP00perfil(P00perfil entity) throws Exception;

    public void deleteP00perfil(P00perfil entity) throws Exception;

    public void updateP00perfil(P00perfil entity) throws Exception;

    public P00perfil getP00perfil(Integer rowidperfil)
        throws Exception;

    public List<P00perfil> findByCriteriaInP00perfil(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00perfil> findPageP00perfil(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00perfil() throws Exception;

    public List<P00perfilDTO> getDataP00perfil() throws Exception;

    public List<P00perfilmenu> getP00perfilmenu() throws Exception;

    public void saveP00perfilmenu(P00perfilmenu entity)
        throws Exception;

    public void deleteP00perfilmenu(P00perfilmenu entity)
        throws Exception;

    public void updateP00perfilmenu(P00perfilmenu entity)
        throws Exception;

    public P00perfilmenu getP00perfilmenu(Integer rowidperfilmenu)
        throws Exception;

    public List<P00perfilmenu> findByCriteriaInP00perfilmenu(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<P00perfilmenu> findPageP00perfilmenu(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00perfilmenu() throws Exception;

    public List<P00perfilmenuDTO> getDataP00perfilmenu()
        throws Exception;

    public List<P00usuario> getP00usuario() throws Exception;

    public void saveP00usuario(P00usuario entity) throws Exception;

    public void deleteP00usuario(P00usuario entity) throws Exception;

    public void updateP00usuario(P00usuario entity) throws Exception;

    public P00usuario getP00usuario(Long rowidusuario)
        throws Exception;

    public List<P00usuario> findByCriteriaInP00usuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00usuario> findPageP00usuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00usuario() throws Exception;

    public List<P00usuarioDTO> getDataP00usuario() throws Exception;

    public List<P10clientes> getP10clientes() throws Exception;

    public void saveP10clientes(P10clientes entity) throws Exception;

    public void deleteP10clientes(P10clientes entity) throws Exception;

    public void updateP10clientes(P10clientes entity) throws Exception;

    public P10clientes getP10clientes(Integer rowidcliente)
        throws Exception;

    public List<P10clientes> findByCriteriaInP10clientes(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P10clientes> findPageP10clientes(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP10clientes() throws Exception;

    public List<P10clientesDTO> getDataP10clientes() throws Exception;
    
public void destroySession()throws Exception;
    
	public P00empresa getEmpresaUsuario();
    
	public P00usuario getUsuarioLogin();
    
	public Boolean cambiarPasswordUserLogin(String passChange)throws Exception;

    public List<P10vehiculos> getP10vehiculos() throws Exception;

    public void saveP10vehiculos(P10vehiculos entity) throws Exception;

    public void deleteP10vehiculos(P10vehiculos entity)
        throws Exception;

    public void updateP10vehiculos(P10vehiculos entity)
        throws Exception;

    public P10vehiculos getP10vehiculos(Integer rowidvehiculos)
        throws Exception;

    public List<P10vehiculos> findByCriteriaInP10vehiculos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P10vehiculos> findPageP10vehiculos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP10vehiculos() throws Exception;

    public List<P10vehiculosDTO> getDataP10vehiculos()
        throws Exception;
    public List<P10soat> getP10soat() throws Exception;

    public void saveP10soat(P10soat entity) throws Exception;

    public void deleteP10soat(P10soat entity) throws Exception;

    public void updateP10soat(P10soat entity) throws Exception;

    public P10soat getP10soat(Integer rowidsoat) throws Exception;

    public List<P10soat> findByCriteriaInP10soat(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P10soat> findPageP10soat(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP10soat() throws Exception;

    public List<P10soatDTO> getDataP10soat() throws Exception;
    
    public List<DataSoatVehiculosDTOExt> getDataSoatVehiculosDTOExt(Integer idVehiculo)throws Exception;
}
