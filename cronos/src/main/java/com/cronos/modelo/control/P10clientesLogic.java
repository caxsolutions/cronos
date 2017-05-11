package com.cronos.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cronos.dataaccess.dao.IP10clientesDAO;
import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P10clientes;
import com.cronos.modelo.dto.P10clientesDTO;
import com.cronos.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("P10clientesLogic")
public class P10clientesLogic implements IP10clientesLogic {
    private static final Logger log = LoggerFactory.getLogger(P10clientesLogic.class);

    /**
     * DAO injected by Spring that manages P10clientes entities
     *
     */
    @Autowired
    private IP10clientesDAO p10clientesDAO;

    /**
    * Logic injected by Spring that manages P00empresa entities
    *
    */
    @Autowired
    IP00empresaLogic logicP00empresa1;

    /**
    * Logic injected by Spring that manages P00listaopcion entities
    *
    */
    @Autowired
    IP00listaopcionLogic logicP00listaopcion2;

    /**
    * Logic injected by Spring that manages P00listaopcion entities
    *
    */
    @Autowired
    IP00listaopcionLogic logicP00listaopcion3;

    /**
    * Logic injected by Spring that manages P00listaopcion entities
    *
    */
    @Autowired
    IP00listaopcionLogic logicP00listaopcion4;

    /**
    * Logic injected by Spring that manages P00listaopcion entities
    *
    */
    @Autowired
    IP00listaopcionLogic logicP00listaopcion5;

    /**
    * Logic injected by Spring that manages P00listaopcion entities
    *
    */
    @Autowired
    IP00listaopcionLogic logicP00listaopcion6;

    /**
    * Logic injected by Spring that manages P00municipio entities
    *
    */
    @Autowired
    IP00municipioLogic logicP00municipio7;

    @Transactional(readOnly = true)
    public List<P10clientes> getP10clientes() throws Exception {
        log.debug("finding all P10clientes instances");

        List<P10clientes> list = new ArrayList<P10clientes>();

        try {
            list = p10clientesDAO.findAll();
        } catch (Exception e) {
            log.error("finding all P10clientes failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "P10clientes");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveP10clientes(P10clientes entity) throws Exception {
        log.debug("saving P10clientes instance");

        try {
            if (entity.getP00empresa() == null) {
                throw new ZMessManager().new ForeignException("p00empresa");
            }

            if (entity.getP00listaopcionByRowidestadocivil() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidestadocivil");
            }

            if (entity.getP00listaopcionByRowidsexo() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidsexo");
            }

            if (entity.getP00listaopcionByRowidtipocliente() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidtipocliente");
            }

            if (entity.getP00listaopcionByRowidtipoidentificacion() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidtipoidentificacion");
            }

            if (entity.getP00listaopcionByRowidtipoprofesion() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidtipoprofesion");
            }

            if (entity.getP00municipio() == null) {
                throw new ZMessManager().new ForeignException("p00municipio");
            }

            if (entity.getApellidos() == null) {
                throw new ZMessManager().new EmptyFieldException("apellidos");
            }

            if ((entity.getApellidos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getApellidos(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "apellidos");
            }

            if ((entity.getCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCelular(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException("celular");
            }

            if ((entity.getCorreoinstitucional() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCorreoinstitucional(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "correoinstitucional");
            }

            if ((entity.getCorreopersonal() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCorreopersonal(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "correopersonal");
            }

            if ((entity.getDescripcionprofesion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcionprofesion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcionprofesion");
            }

            if (entity.getDigitoverificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "digitoverificacion");
            }

            if ((entity.getDigitoverificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDigitoverificacion(), 2) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "digitoverificacion");
            }

            if ((entity.getDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDireccion(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "direccion");
            }

            if ((entity.getDireccionempresa() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDireccionempresa(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "direccionempresa");
            }

            if ((entity.getEmpresalabora() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEmpresalabora(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "empresalabora");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if (entity.getNombres() == null) {
                throw new ZMessManager().new EmptyFieldException("nombres");
            }

            if ((entity.getNombres() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNombres(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombres");
            }

            if (entity.getNumeroidentificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "numeroidentificacion");
            }

            if ((entity.getNumeroidentificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNumeroidentificacion(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numeroidentificacion");
            }

            if ((entity.getRazonsocial() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getRazonsocial(), 120) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "razonsocial");
            }

            if ((entity.getTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefono(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException("telefono");
            }

            if ((entity.getTelefonoempresa() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefonoempresa(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "telefonoempresa");
            }

            if (entity.getTienehijos() == null) {
                throw new ZMessManager().new EmptyFieldException("tienehijos");
            }

            if (entity.getP00empresa().getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidempresa_P00empresa");
            }

            if (entity.getP00listaopcionByRowidestadocivil().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidsexo().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidtipocliente().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidtipoidentificacion().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidtipoprofesion().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00municipio().getIdmunicipio() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idmunicipio_P00municipio");
            }

            p10clientesDAO.save(entity);

            log.debug("save P10clientes successful");
        } catch (Exception e) {
            log.error("save P10clientes failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteP10clientes(P10clientes entity) throws Exception {
        log.debug("deleting P10clientes instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("P10clientes");
        }

        if (entity.getRowidcliente() == null) {
            throw new ZMessManager().new EmptyFieldException("rowidcliente");
        }

        try {
            p10clientesDAO.delete(entity);

            log.debug("delete P10clientes successful");
        } catch (Exception e) {
            log.error("delete P10clientes failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateP10clientes(P10clientes entity) throws Exception {
        log.debug("updating P10clientes instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("P10clientes");
            }

            if (entity.getP00empresa() == null) {
                throw new ZMessManager().new ForeignException("p00empresa");
            }

            if (entity.getP00listaopcionByRowidestadocivil() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidestadocivil");
            }

            if (entity.getP00listaopcionByRowidsexo() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidsexo");
            }

            if (entity.getP00listaopcionByRowidtipocliente() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidtipocliente");
            }

            if (entity.getP00listaopcionByRowidtipoidentificacion() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidtipoidentificacion");
            }

            if (entity.getP00listaopcionByRowidtipoprofesion() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidtipoprofesion");
            }

            if (entity.getP00municipio() == null) {
                throw new ZMessManager().new ForeignException("p00municipio");
            }

            if (entity.getApellidos() == null) {
                throw new ZMessManager().new EmptyFieldException("apellidos");
            }

            if ((entity.getApellidos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getApellidos(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "apellidos");
            }

            if ((entity.getCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCelular(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException("celular");
            }

            if ((entity.getCorreoinstitucional() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCorreoinstitucional(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "correoinstitucional");
            }

            if ((entity.getCorreopersonal() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCorreopersonal(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "correopersonal");
            }

            if ((entity.getDescripcionprofesion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcionprofesion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcionprofesion");
            }

            if (entity.getDigitoverificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "digitoverificacion");
            }

            if ((entity.getDigitoverificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDigitoverificacion(), 2) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "digitoverificacion");
            }

            if ((entity.getDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDireccion(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "direccion");
            }

            if ((entity.getDireccionempresa() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDireccionempresa(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "direccionempresa");
            }

            if ((entity.getEmpresalabora() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEmpresalabora(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "empresalabora");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if (entity.getNombres() == null) {
                throw new ZMessManager().new EmptyFieldException("nombres");
            }

            if ((entity.getNombres() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNombres(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombres");
            }

            if (entity.getNumeroidentificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "numeroidentificacion");
            }

            if ((entity.getNumeroidentificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNumeroidentificacion(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numeroidentificacion");
            }

            if ((entity.getRazonsocial() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getRazonsocial(), 120) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "razonsocial");
            }

            if (entity.getRowidcliente() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidcliente");
            }

            if ((entity.getTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefono(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException("telefono");
            }

            if ((entity.getTelefonoempresa() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefonoempresa(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "telefonoempresa");
            }

            if (entity.getTienehijos() == null) {
                throw new ZMessManager().new EmptyFieldException("tienehijos");
            }

            if (entity.getP00empresa().getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidempresa_P00empresa");
            }

            if (entity.getP00listaopcionByRowidestadocivil().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidsexo().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidtipocliente().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidtipoidentificacion().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidtipoprofesion().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }
            
            if (entity.getP00municipio().getIdmunicipio() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idmunicipio_P00municipio");
            }

            p10clientesDAO.update(entity);

            log.debug("update P10clientes successful");
        } catch (Exception e) {
            log.error("update P10clientes failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<P10clientesDTO> getDataP10clientes() throws Exception {
        try {
            List<P10clientes> p10clientes = p10clientesDAO.findAll();

            List<P10clientesDTO> p10clientesDTO = new ArrayList<P10clientesDTO>();

            for (P10clientes p10clientesTmp : p10clientes) {
                P10clientesDTO p10clientesDTO2 = new P10clientesDTO();

                p10clientesDTO2.setRowidcliente(p10clientesTmp.getRowidcliente());
                p10clientesDTO2.setApellidos((p10clientesTmp.getApellidos() != null)
                    ? p10clientesTmp.getApellidos() : null);
                p10clientesDTO2.setCorreopersonal((p10clientesTmp.getCorreopersonal() != null)
                    ? p10clientesTmp.getCorreopersonal() : null);
                p10clientesDTO2.setDescripcionprofesion((p10clientesTmp.getDescripcionprofesion() != null)
                    ? p10clientesTmp.getDescripcionprofesion() : null);
                p10clientesDTO2.setDigitoverificacion((p10clientesTmp.getDigitoverificacion() != null)
                    ? p10clientesTmp.getDigitoverificacion() : null);
                p10clientesDTO2.setDireccion((p10clientesTmp.getDireccion() != null)
                    ? p10clientesTmp.getDireccion() : null);
                p10clientesDTO2.setDireccionempresa((p10clientesTmp.getDireccionempresa() != null)
                    ? p10clientesTmp.getDireccionempresa() : null);
                p10clientesDTO2.setEmpresalabora((p10clientesTmp.getEmpresalabora() != null)
                    ? p10clientesTmp.getEmpresalabora() : null);
                p10clientesDTO2.setFechanacimiento(p10clientesTmp.getFechanacimiento());
                p10clientesDTO2.setHabilita((p10clientesTmp.getHabilita() != null)
                    ? p10clientesTmp.getHabilita() : null);
                p10clientesDTO2.setNombres((p10clientesTmp.getNombres() != null)
                    ? p10clientesTmp.getNombres() : null);
                p10clientesDTO2.setNumeroidentificacion((p10clientesTmp.getNumeroidentificacion() != null)
                    ? p10clientesTmp.getNumeroidentificacion() : null);
                p10clientesDTO2.setRazonsocial((p10clientesTmp.getRazonsocial() != null)
                    ? p10clientesTmp.getRazonsocial() : null);
                p10clientesDTO2.setTelefono((p10clientesTmp.getTelefono() != null)
                    ? p10clientesTmp.getTelefono() : null);
                p10clientesDTO2.setTelefonoempresa((p10clientesTmp.getTelefonoempresa() != null)
                    ? p10clientesTmp.getTelefonoempresa() : null);
                p10clientesDTO2.setTienehijos((p10clientesTmp.getTienehijos() != null)
                    ? p10clientesTmp.getTienehijos() : null);
                p10clientesDTO2.setRowidempresa_P00empresa((p10clientesTmp.getP00empresa()
                                                                          .getRowidempresa() != null)
                    ? p10clientesTmp.getP00empresa().getRowidempresa() : null);
                p10clientesDTO2.setRowidestadocivil_P00listaopcion((p10clientesTmp.getP00listaopcionByRowidestadocivil().getRowidopcion() != null)
                    ? p10clientesTmp.getP00listaopcionByRowidestadocivil().getRowidopcion() : null);
                p10clientesDTO2.setRowidsexo_P00listaopcion((p10clientesTmp.getP00listaopcionByRowidsexo().getRowidopcion() != null)
                        ? p10clientesTmp.getP00listaopcionByRowidsexo().getRowidopcion() : null);
                p10clientesDTO2.setRowidtipocliente_P00listaopcion((p10clientesTmp.getP00listaopcionByRowidtipocliente().getRowidopcion() != null)
                        ? p10clientesTmp.getP00listaopcionByRowidtipocliente().getRowidopcion() : null);
                p10clientesDTO2.setRowidtipoidentificacion_P00listaopcion((p10clientesTmp.getP00listaopcionByRowidtipoidentificacion().getRowidopcion() != null)
                        ? p10clientesTmp.getP00listaopcionByRowidtipoidentificacion().getRowidopcion() : null);
                p10clientesDTO2.setRowidtipoprofesion_P00listaopcion((p10clientesTmp.getP00listaopcionByRowidtipoprofesion().getRowidopcion() != null)
                        ? p10clientesTmp.getP00listaopcionByRowidtipoprofesion().getRowidopcion() : null);
                p10clientesDTO2.setCelular((p10clientesTmp.getCelular() != null)
                        ? p10clientesTmp.getCelular() : null);
                p10clientesDTO2.setCorreoinstitucional((p10clientesTmp.getCorreoinstitucional() != null)
                        ? p10clientesTmp.getCorreoinstitucional() : null);
                p10clientesDTO2.setCantidadhijos((p10clientesTmp.getCantidadhijos() != null)
                        ? p10clientesTmp.getCantidadhijos() : null);
                p10clientesDTO2.setTitularvivienda((p10clientesTmp.getTitularvivienda() != null)
                        ? p10clientesTmp.getTitularvivienda() : null);

                if (p10clientesTmp.getP00municipio() != null) {
                    p10clientesDTO2.setIdmunicipio_P00municipio(p10clientesTmp.getP00municipio().getIdmunicipio());
                } else {
                    p10clientesDTO2.setIdmunicipio_P00municipio(null);
                }

                p10clientesDTO.add(p10clientesDTO2);
            }

            return p10clientesDTO;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Transactional(readOnly = true)
    public P10clientes getP10clientes(Integer rowidcliente)
        throws Exception {
        log.debug("getting P10clientes instance");

        P10clientes entity = null;

        try {
            entity = p10clientesDAO.findById(rowidcliente);
        } catch (Exception e) {
            log.error("get P10clientes failed", e);
            throw new ZMessManager().new FindingException("P10clientes");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<P10clientes> findPageP10clientes(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<P10clientes> entity = null;

        try {
            entity = p10clientesDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P10clientes Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberP10clientes() throws Exception {
        Long entity = null;

        try {
            entity = p10clientesDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P10clientes Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<P10clientes> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<P10clientes> list = new ArrayList<P10clientes>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = p10clientesDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
