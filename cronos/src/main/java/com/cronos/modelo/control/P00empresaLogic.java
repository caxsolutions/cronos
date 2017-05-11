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

import com.cronos.dataaccess.dao.IP00empresaDAO;
import com.cronos.dataaccess.dao.IP00perfilDAO;
import com.cronos.dataaccess.dao.IP00usuarioDAO;
import com.cronos.dataaccess.dao.IP10clientesDAO;
import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P00empresa;
import com.cronos.modelo.P00perfil;
import com.cronos.modelo.P00usuario;
import com.cronos.modelo.P10clientes;
import com.cronos.modelo.dto.P00empresaDTO;
import com.cronos.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("P00empresaLogic")
public class P00empresaLogic implements IP00empresaLogic {
    private static final Logger log = LoggerFactory.getLogger(P00empresaLogic.class);

    /**
     * DAO injected by Spring that manages P00empresa entities
     *
     */
    @Autowired
    private IP00empresaDAO p00empresaDAO;

    /**
    * DAO injected by Spring that manages P00perfil entities
    *
    */
    @Autowired
    private IP00perfilDAO p00perfilDAO;

    /**
    * DAO injected by Spring that manages P00usuario entities
    *
    */
    @Autowired
    private IP00usuarioDAO p00usuarioDAO;

    /**
    * DAO injected by Spring that manages P10clientes entities
    *
    */
    @Autowired
    private IP10clientesDAO p10clientesDAO;

    @Transactional(readOnly = true)
    public List<P00empresa> getP00empresa() throws Exception {
        log.debug("finding all P00empresa instances");

        List<P00empresa> list = new ArrayList<P00empresa>();

        try {
            list = p00empresaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all P00empresa failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "P00empresa");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveP00empresa(P00empresa entity) throws Exception {
        log.debug("saving P00empresa instance");

        try {
            if ((entity.getCorreo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCorreo(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("correo");
            }

            if (entity.getDescripcion() == null) {
                throw new ZMessManager().new EmptyFieldException("descripcion");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if (entity.getDigitoverificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "digitoverificacion");
            }

            if ((entity.getDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDireccion(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "direccion");
            }

            if (entity.getEmpresa() == null) {
                throw new ZMessManager().new EmptyFieldException("empresa");
            }

            if ((entity.getEmpresa() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEmpresa(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("empresa");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if ((entity.getLogo1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getLogo1(),
                        255) == false)) {
                throw new ZMessManager().new NotValidFormatException("logo1");
            }

            if (entity.getNit() == null) {
                throw new ZMessManager().new EmptyFieldException("nit");
            }

            if ((entity.getNit() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNit(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("nit");
            }

            if (entity.getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidempresa");
            }

            if ((entity.getTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefono(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException("telefono");
            }

            if (getP00empresa(entity.getRowidempresa()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            p00empresaDAO.save(entity);

            log.debug("save P00empresa successful");
        } catch (Exception e) {
            log.error("save P00empresa failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteP00empresa(P00empresa entity) throws Exception {
        log.debug("deleting P00empresa instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("P00empresa");
        }

        if (entity.getRowidempresa() == null) {
            throw new ZMessManager().new EmptyFieldException("rowidempresa");
        }

        List<P00perfil> p00perfils = null;
        List<P00usuario> p00usuarios = null;
        List<P10clientes> p10clienteses = null;

        try {
            p00perfils = p00perfilDAO.findByProperty("p00empresa.rowidempresa",
                    entity.getRowidempresa());

            if (Utilities.validationsList(p00perfils) == true) {
                throw new ZMessManager().new DeletingException("p00perfils");
            }

            p00usuarios = p00usuarioDAO.findByProperty("p00empresa.rowidempresa",
                    entity.getRowidempresa());

            if (Utilities.validationsList(p00usuarios) == true) {
                throw new ZMessManager().new DeletingException("p00usuarios");
            }

            p10clienteses = p10clientesDAO.findByProperty("p00empresa.rowidempresa",
                    entity.getRowidempresa());

            if (Utilities.validationsList(p10clienteses) == true) {
                throw new ZMessManager().new DeletingException("p10clienteses");
            }

            p00empresaDAO.delete(entity);

            log.debug("delete P00empresa successful");
        } catch (Exception e) {
            log.error("delete P00empresa failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateP00empresa(P00empresa entity) throws Exception {
        log.debug("updating P00empresa instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("P00empresa");
            }

            if ((entity.getCorreo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCorreo(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("correo");
            }

            if (entity.getDescripcion() == null) {
                throw new ZMessManager().new EmptyFieldException("descripcion");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if (entity.getDigitoverificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "digitoverificacion");
            }

            if ((entity.getDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDireccion(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "direccion");
            }

            if (entity.getEmpresa() == null) {
                throw new ZMessManager().new EmptyFieldException("empresa");
            }

            if ((entity.getEmpresa() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEmpresa(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("empresa");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if ((entity.getLogo1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getLogo1(),
                        255) == false)) {
                throw new ZMessManager().new NotValidFormatException("logo1");
            }

            if (entity.getNit() == null) {
                throw new ZMessManager().new EmptyFieldException("nit");
            }

            if ((entity.getNit() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNit(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("nit");
            }

            if (entity.getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidempresa");
            }

            if ((entity.getTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefono(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException("telefono");
            }

            p00empresaDAO.update(entity);

            log.debug("update P00empresa successful");
        } catch (Exception e) {
            log.error("update P00empresa failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<P00empresaDTO> getDataP00empresa() throws Exception {
        try {
            List<P00empresa> p00empresa = p00empresaDAO.findAll();

            List<P00empresaDTO> p00empresaDTO = new ArrayList<P00empresaDTO>();

            for (P00empresa p00empresaTmp : p00empresa) {
                P00empresaDTO p00empresaDTO2 = new P00empresaDTO();

                p00empresaDTO2.setRowidempresa(p00empresaTmp.getRowidempresa());
                p00empresaDTO2.setCorreo((p00empresaTmp.getCorreo() != null)
                    ? p00empresaTmp.getCorreo() : null);
                p00empresaDTO2.setDescripcion((p00empresaTmp.getDescripcion() != null)
                    ? p00empresaTmp.getDescripcion() : null);
                p00empresaDTO2.setDigitoverificacion((p00empresaTmp.getDigitoverificacion() != null)
                    ? p00empresaTmp.getDigitoverificacion() : null);
                p00empresaDTO2.setDireccion((p00empresaTmp.getDireccion() != null)
                    ? p00empresaTmp.getDireccion() : null);
                p00empresaDTO2.setEmpresa((p00empresaTmp.getEmpresa() != null)
                    ? p00empresaTmp.getEmpresa() : null);
                p00empresaDTO2.setHabilita((p00empresaTmp.getHabilita() != null)
                    ? p00empresaTmp.getHabilita() : null);
                p00empresaDTO2.setLogo1((p00empresaTmp.getLogo1() != null)
                    ? p00empresaTmp.getLogo1() : null);
                p00empresaDTO2.setNit((p00empresaTmp.getNit() != null)
                    ? p00empresaTmp.getNit() : null);
                p00empresaDTO2.setTelefono((p00empresaTmp.getTelefono() != null)
                    ? p00empresaTmp.getTelefono() : null);
                p00empresaDTO.add(p00empresaDTO2);
            }

            return p00empresaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public P00empresa getP00empresa(Integer rowidempresa)
        throws Exception {
        log.debug("getting P00empresa instance");

        P00empresa entity = null;

        try {
            entity = p00empresaDAO.findById(rowidempresa);
        } catch (Exception e) {
            log.error("get P00empresa failed", e);
            throw new ZMessManager().new FindingException("P00empresa");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<P00empresa> findPageP00empresa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<P00empresa> entity = null;

        try {
            entity = p00empresaDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00empresa Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberP00empresa() throws Exception {
        Long entity = null;

        try {
            entity = p00empresaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00empresa Count");
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
    public List<P00empresa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<P00empresa> list = new ArrayList<P00empresa>();
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
            list = p00empresaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
