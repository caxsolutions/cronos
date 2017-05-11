package com.cronos.presentation.businessDelegate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
import com.cronos.modelo.control.IP00departamentoLogic;
import com.cronos.modelo.control.IP00empresaLogic;
import com.cronos.modelo.control.IP00listaopcionLogic;
import com.cronos.modelo.control.IP00menuLogic;
import com.cronos.modelo.control.IP00municipioLogic;
import com.cronos.modelo.control.IP00perfilLogic;
import com.cronos.modelo.control.IP00perfilmenuLogic;
import com.cronos.modelo.control.IP00usuarioLogic;
import com.cronos.modelo.control.IP10clientesLogic;
import com.cronos.modelo.control.IP10soatLogic;
import com.cronos.modelo.control.IP10vehiculosLogic;
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
import com.cronos.security.ISeguridadLogin;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IP00departamentoLogic p00departamentoLogic;
    @Autowired
    private IP00empresaLogic p00empresaLogic;
    @Autowired
    private IP00listaopcionLogic p00listaopcionLogic;
    @Autowired
    private IP00menuLogic p00menuLogic;
    @Autowired
    private IP00municipioLogic p00municipioLogic;
    @Autowired
    private IP00perfilLogic p00perfilLogic;
    @Autowired
    private IP00perfilmenuLogic p00perfilmenuLogic;
    @Autowired
    private IP00usuarioLogic p00usuarioLogic;
    @Autowired
    private IP10clientesLogic p10clientesLogic;
    @Autowired
    private ISeguridadLogin logicSeguridad;  
    @Autowired
    private IP10vehiculosLogic p10vehiculosLogic;
    @Autowired
    private IP10soatLogic p10soatLogic;
    

    public List<P00departamento> getP00departamento() throws Exception {
        return p00departamentoLogic.getP00departamento();
    }

    public void saveP00departamento(P00departamento entity)
        throws Exception {
        p00departamentoLogic.saveP00departamento(entity);
    }

    public void deleteP00departamento(P00departamento entity)
        throws Exception {
        p00departamentoLogic.deleteP00departamento(entity);
    }

    public void updateP00departamento(P00departamento entity)
        throws Exception {
        p00departamentoLogic.updateP00departamento(entity);
    }

    public P00departamento getP00departamento(Integer iddepartamento)
        throws Exception {
        P00departamento p00departamento = null;

        try {
            p00departamento = p00departamentoLogic.getP00departamento(iddepartamento);
        } catch (Exception e) {
            throw e;
        }

        return p00departamento;
    }

    public List<P00departamento> findByCriteriaInP00departamento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return p00departamentoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P00departamento> findPageP00departamento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return p00departamentoLogic.findPageP00departamento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberP00departamento() throws Exception {
        return p00departamentoLogic.findTotalNumberP00departamento();
    }

    public List<P00departamentoDTO> getDataP00departamento()
        throws Exception {
        return p00departamentoLogic.getDataP00departamento();
    }

    public List<P00empresa> getP00empresa() throws Exception {
        return p00empresaLogic.getP00empresa();
    }

    public void saveP00empresa(P00empresa entity) throws Exception {
        p00empresaLogic.saveP00empresa(entity);
    }

    public void deleteP00empresa(P00empresa entity) throws Exception {
        p00empresaLogic.deleteP00empresa(entity);
    }

    public void updateP00empresa(P00empresa entity) throws Exception {
        p00empresaLogic.updateP00empresa(entity);
    }

    public P00empresa getP00empresa(Integer rowidempresa)
        throws Exception {
        P00empresa p00empresa = null;

        try {
            p00empresa = p00empresaLogic.getP00empresa(rowidempresa);
        } catch (Exception e) {
            throw e;
        }

        return p00empresa;
    }

    public List<P00empresa> findByCriteriaInP00empresa(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return p00empresaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P00empresa> findPageP00empresa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p00empresaLogic.findPageP00empresa(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberP00empresa() throws Exception {
        return p00empresaLogic.findTotalNumberP00empresa();
    }

    public List<P00empresaDTO> getDataP00empresa() throws Exception {
        return p00empresaLogic.getDataP00empresa();
    }

    public List<P00listaopcion> getP00listaopcion() throws Exception {
        return p00listaopcionLogic.getP00listaopcion();
    }

    public void saveP00listaopcion(P00listaopcion entity)
        throws Exception {
        p00listaopcionLogic.saveP00listaopcion(entity);
    }

    public void deleteP00listaopcion(P00listaopcion entity)
        throws Exception {
        p00listaopcionLogic.deleteP00listaopcion(entity);
    }

    public void updateP00listaopcion(P00listaopcion entity)
        throws Exception {
        p00listaopcionLogic.updateP00listaopcion(entity);
    }

    public P00listaopcion getP00listaopcion(Integer rowidopcion)
        throws Exception {
        P00listaopcion p00listaopcion = null;

        try {
            p00listaopcion = p00listaopcionLogic.getP00listaopcion(rowidopcion);
        } catch (Exception e) {
            throw e;
        }

        return p00listaopcion;
    }

    public List<P00listaopcion> findByCriteriaInP00listaopcion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return p00listaopcionLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P00listaopcion> findPageP00listaopcion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p00listaopcionLogic.findPageP00listaopcion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberP00listaopcion() throws Exception {
        return p00listaopcionLogic.findTotalNumberP00listaopcion();
    }

    public List<P00listaopcionDTO> getDataP00listaopcion()
        throws Exception {
        return p00listaopcionLogic.getDataP00listaopcion();
    }

    public List<P00menu> getP00menu() throws Exception {
        return p00menuLogic.getP00menu();
    }

    public void saveP00menu(P00menu entity) throws Exception {
        p00menuLogic.saveP00menu(entity);
    }

    public void deleteP00menu(P00menu entity) throws Exception {
        p00menuLogic.deleteP00menu(entity);
    }

    public void updateP00menu(P00menu entity) throws Exception {
        p00menuLogic.updateP00menu(entity);
    }

    public P00menu getP00menu(Integer rowidmenu) throws Exception {
        P00menu p00menu = null;

        try {
            p00menu = p00menuLogic.getP00menu(rowidmenu);
        } catch (Exception e) {
            throw e;
        }

        return p00menu;
    }

    public List<P00menu> findByCriteriaInP00menu(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return p00menuLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P00menu> findPageP00menu(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p00menuLogic.findPageP00menu(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberP00menu() throws Exception {
        return p00menuLogic.findTotalNumberP00menu();
    }

    public List<P00menuDTO> getDataP00menu() throws Exception {
        return p00menuLogic.getDataP00menu();
    }

    public List<P00municipio> getP00municipio() throws Exception {
        return p00municipioLogic.getP00municipio();
    }

    public void saveP00municipio(P00municipio entity) throws Exception {
        p00municipioLogic.saveP00municipio(entity);
    }

    public void deleteP00municipio(P00municipio entity)
        throws Exception {
        p00municipioLogic.deleteP00municipio(entity);
    }

    public void updateP00municipio(P00municipio entity)
        throws Exception {
        p00municipioLogic.updateP00municipio(entity);
    }

    public P00municipio getP00municipio(Integer idmunicipio)
        throws Exception {
        P00municipio p00municipio = null;

        try {
            p00municipio = p00municipioLogic.getP00municipio(idmunicipio);
        } catch (Exception e) {
            throw e;
        }

        return p00municipio;
    }

    public List<P00municipio> findByCriteriaInP00municipio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return p00municipioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P00municipio> findPageP00municipio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p00municipioLogic.findPageP00municipio(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberP00municipio() throws Exception {
        return p00municipioLogic.findTotalNumberP00municipio();
    }

    public List<P00municipioDTO> getDataP00municipio()
        throws Exception {
        return p00municipioLogic.getDataP00municipio();
    }

    public List<P00perfil> getP00perfil() throws Exception {
        return p00perfilLogic.getP00perfil();
    }

    public void saveP00perfil(P00perfil entity) throws Exception {
        p00perfilLogic.saveP00perfil(entity);
    }

    public void deleteP00perfil(P00perfil entity) throws Exception {
        p00perfilLogic.deleteP00perfil(entity);
    }

    public void updateP00perfil(P00perfil entity) throws Exception {
        p00perfilLogic.updateP00perfil(entity);
    }

    public P00perfil getP00perfil(Integer rowidperfil)
        throws Exception {
        P00perfil p00perfil = null;

        try {
            p00perfil = p00perfilLogic.getP00perfil(rowidperfil);
        } catch (Exception e) {
            throw e;
        }

        return p00perfil;
    }

    public List<P00perfil> findByCriteriaInP00perfil(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return p00perfilLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P00perfil> findPageP00perfil(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p00perfilLogic.findPageP00perfil(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberP00perfil() throws Exception {
        return p00perfilLogic.findTotalNumberP00perfil();
    }

    public List<P00perfilDTO> getDataP00perfil() throws Exception {
        return p00perfilLogic.getDataP00perfil();
    }

    public List<P00perfilmenu> getP00perfilmenu() throws Exception {
        return p00perfilmenuLogic.getP00perfilmenu();
    }

    public void saveP00perfilmenu(P00perfilmenu entity)
        throws Exception {
        p00perfilmenuLogic.saveP00perfilmenu(entity);
    }

    public void deleteP00perfilmenu(P00perfilmenu entity)
        throws Exception {
        p00perfilmenuLogic.deleteP00perfilmenu(entity);
    }

    public void updateP00perfilmenu(P00perfilmenu entity)
        throws Exception {
        p00perfilmenuLogic.updateP00perfilmenu(entity);
    }

    public P00perfilmenu getP00perfilmenu(Integer rowidperfilmenu)
        throws Exception {
        P00perfilmenu p00perfilmenu = null;

        try {
            p00perfilmenu = p00perfilmenuLogic.getP00perfilmenu(rowidperfilmenu);
        } catch (Exception e) {
            throw e;
        }

        return p00perfilmenu;
    }

    public List<P00perfilmenu> findByCriteriaInP00perfilmenu(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return p00perfilmenuLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P00perfilmenu> findPageP00perfilmenu(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p00perfilmenuLogic.findPageP00perfilmenu(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberP00perfilmenu() throws Exception {
        return p00perfilmenuLogic.findTotalNumberP00perfilmenu();
    }

    public List<P00perfilmenuDTO> getDataP00perfilmenu()
        throws Exception {
        return p00perfilmenuLogic.getDataP00perfilmenu();
    }

    public List<P00usuario> getP00usuario() throws Exception {
        return p00usuarioLogic.getP00usuario();
    }

    public void saveP00usuario(P00usuario entity) throws Exception {
        p00usuarioLogic.saveP00usuario(entity);
    }

    public void deleteP00usuario(P00usuario entity) throws Exception {
        p00usuarioLogic.deleteP00usuario(entity);
    }

    public void updateP00usuario(P00usuario entity) throws Exception {
        p00usuarioLogic.updateP00usuario(entity);
    }

    public P00usuario getP00usuario(Long rowidusuario)
        throws Exception {
        P00usuario p00usuario = null;

        try {
            p00usuario = p00usuarioLogic.getP00usuario(rowidusuario);
        } catch (Exception e) {
            throw e;
        }

        return p00usuario;
    }

    public List<P00usuario> findByCriteriaInP00usuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return p00usuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P00usuario> findPageP00usuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p00usuarioLogic.findPageP00usuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberP00usuario() throws Exception {
        return p00usuarioLogic.findTotalNumberP00usuario();
    }

    public List<P00usuarioDTO> getDataP00usuario() throws Exception {
        return p00usuarioLogic.getDataP00usuario();
    }

    public List<P10clientes> getP10clientes() throws Exception {
        return p10clientesLogic.getP10clientes();
    }

    public void saveP10clientes(P10clientes entity) throws Exception {
        p10clientesLogic.saveP10clientes(entity);
    }

    public void deleteP10clientes(P10clientes entity) throws Exception {
        p10clientesLogic.deleteP10clientes(entity);
    }

    public void updateP10clientes(P10clientes entity) throws Exception {
        p10clientesLogic.updateP10clientes(entity);
    }

    public P10clientes getP10clientes(Integer rowidcliente)
        throws Exception {
        P10clientes p10clientes = null;

        try {
            p10clientes = p10clientesLogic.getP10clientes(rowidcliente);
        } catch (Exception e) {
            throw e;
        }

        return p10clientes;
    }

    public List<P10clientes> findByCriteriaInP10clientes(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return p10clientesLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P10clientes> findPageP10clientes(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p10clientesLogic.findPageP10clientes(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberP10clientes() throws Exception {
        return p10clientesLogic.findTotalNumberP10clientes();
    }

    public List<P10clientesDTO> getDataP10clientes() throws Exception {
        return p10clientesLogic.getDataP10clientes();
    }
    
	public void destroySession()throws Exception{
		logicSeguridad.destroySession();
    }
    
	public P00empresa getEmpresaUsuario(){
		return logicSeguridad.getEmpresaUsuario();
	}
    
	public P00usuario getUsuarioLogin(){
		return logicSeguridad.getUsuarioLogin();
	}
    
	public Boolean cambiarPasswordUserLogin(String passChange)throws Exception{
		return logicSeguridad.cambiarPasswordUserLogin(passChange);
	}
    public List<P10vehiculos> getP10vehiculos() throws Exception {
        return p10vehiculosLogic.getP10vehiculos();
    }

    public void saveP10vehiculos(P10vehiculos entity) throws Exception {
        p10vehiculosLogic.saveP10vehiculos(entity);
    }

    public void deleteP10vehiculos(P10vehiculos entity)
        throws Exception {
        p10vehiculosLogic.deleteP10vehiculos(entity);
    }

    public void updateP10vehiculos(P10vehiculos entity)
        throws Exception {
        p10vehiculosLogic.updateP10vehiculos(entity);
    }

    public P10vehiculos getP10vehiculos(Integer rowidvehiculos)
        throws Exception {
        P10vehiculos p10vehiculos = null;

        try {
            p10vehiculos = p10vehiculosLogic.getP10vehiculos(rowidvehiculos);
        } catch (Exception e) {
            throw e;
        }

        return p10vehiculos;
    }

    public List<P10vehiculos> findByCriteriaInP10vehiculos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return p10vehiculosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P10vehiculos> findPageP10vehiculos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p10vehiculosLogic.findPageP10vehiculos(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberP10vehiculos() throws Exception {
        return p10vehiculosLogic.findTotalNumberP10vehiculos();
    }

    public List<P10vehiculosDTO> getDataP10vehiculos()
        throws Exception {
        return p10vehiculosLogic.getDataP10vehiculos();
    }
    public List<P10soat> getP10soat() throws Exception {
        return p10soatLogic.getP10soat();
    }

    public void saveP10soat(P10soat entity) throws Exception {
        p10soatLogic.saveP10soat(entity);
    }

    public void deleteP10soat(P10soat entity) throws Exception {
        p10soatLogic.deleteP10soat(entity);
    }

    public void updateP10soat(P10soat entity) throws Exception {
        p10soatLogic.updateP10soat(entity);
    }

    public P10soat getP10soat(Integer rowidsoat) throws Exception {
        P10soat p10soat = null;

        try {
            p10soat = p10soatLogic.getP10soat(rowidsoat);
        } catch (Exception e) {
            throw e;
        }

        return p10soat;
    }

    public List<P10soat> findByCriteriaInP10soat(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return p10soatLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<P10soat> findPageP10soat(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return p10soatLogic.findPageP10soat(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberP10soat() throws Exception {
        return p10soatLogic.findTotalNumberP10soat();
    }

    public List<P10soatDTO> getDataP10soat() throws Exception {
        return p10soatLogic.getDataP10soat();
    }

    public List<DataSoatVehiculosDTOExt> getDataSoatVehiculosDTOExt(Integer idVehiculo)throws Exception{
    	return p10soatLogic.getDataSoatVehiculosDTOExt(idVehiculo);
    }
}
