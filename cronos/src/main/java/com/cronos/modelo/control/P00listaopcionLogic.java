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

import com.cronos.dataaccess.dao.IP00listaopcionDAO;
import com.cronos.dataaccess.dao.IP10clientesDAO;
import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P00listaopcion;
import com.cronos.modelo.dto.P00listaopcionDTO;
import com.cronos.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("P00listaopcionLogic")
public class P00listaopcionLogic implements IP00listaopcionLogic {
    private static final Logger log = LoggerFactory.getLogger(P00listaopcionLogic.class);

    /**
     * DAO injected by Spring that manages P00listaopcion entities
     *
     */
    @Autowired
    private IP00listaopcionDAO p00listaopcionDAO;

    /**
    * DAO injected by Spring that manages P10clientes entities
    *
    */
    @Autowired
    private IP10clientesDAO p10clientesDAO;

    @Transactional(readOnly = true)
    public List<P00listaopcion> getP00listaopcion() throws Exception {
        log.debug("finding all P00listaopcion instances");

        List<P00listaopcion> list = new ArrayList<P00listaopcion>();

        try {
            list = p00listaopcionDAO.findAll();
        } catch (Exception e) {
            log.error("finding all P00listaopcion failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "P00listaopcion");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveP00listaopcion(P00listaopcion entity)
        throws Exception {
        log.debug("saving P00listaopcion instance");

        try {


            log.debug("save P00listaopcion successful");
        } catch (Exception e) {
            log.error("save P00listaopcion failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteP00listaopcion(P00listaopcion entity)
        throws Exception {
        log.debug("deleting P00listaopcion instance");

        try {


            log.debug("delete P00listaopcion successful");
        } catch (Exception e) {
            log.error("delete P00listaopcion failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateP00listaopcion(P00listaopcion entity)
        throws Exception {
        log.debug("updating P00listaopcion instance");

        try {


            log.debug("update P00listaopcion successful");
        } catch (Exception e) {
            log.error("update P00listaopcion failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<P00listaopcionDTO> getDataP00listaopcion()
        throws Exception {
        try {
            List<P00listaopcion> p00listaopcion = p00listaopcionDAO.findAll();

            List<P00listaopcionDTO> p00listaopcionDTO = new ArrayList<P00listaopcionDTO>();

            for (P00listaopcion p00listaopcionTmp : p00listaopcion) {
                P00listaopcionDTO p00listaopcionDTO2 = new P00listaopcionDTO();

                p00listaopcionDTO2.setRowidopcion(p00listaopcionTmp.getRowidopcion());
                p00listaopcionDTO2.setAbreviacion((p00listaopcionTmp.getAbreviacion() != null)
                    ? p00listaopcionTmp.getAbreviacion() : null);
                p00listaopcionDTO2.setCondicion((p00listaopcionTmp.getCondicion() != null)
                    ? p00listaopcionTmp.getCondicion() : null);
                p00listaopcionDTO2.setDescripcion((p00listaopcionTmp.getDescripcion() != null)
                    ? p00listaopcionTmp.getDescripcion() : null);
                p00listaopcionDTO2.setHabilita((p00listaopcionTmp.getHabilita() != null)
                    ? p00listaopcionTmp.getHabilita() : null);
                p00listaopcionDTO2.setNombre((p00listaopcionTmp.getNombre() != null)
                    ? p00listaopcionTmp.getNombre() : null);
                p00listaopcionDTO2.setValidacion((p00listaopcionTmp.getValidacion() != null)
                    ? p00listaopcionTmp.getValidacion() : null);
                p00listaopcionDTO2.setValor((p00listaopcionTmp.getValor() != null)
                    ? p00listaopcionTmp.getValor() : null);
                p00listaopcionDTO2.setVariable((p00listaopcionTmp.getVariable() != null)
                    ? p00listaopcionTmp.getVariable() : null);
                p00listaopcionDTO.add(p00listaopcionDTO2);
            }

            return p00listaopcionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public P00listaopcion getP00listaopcion(Integer rowidopcion)
        throws Exception {
        log.debug("getting P00listaopcion instance");

        P00listaopcion entity = null;

        try {
            entity = p00listaopcionDAO.findById(rowidopcion);
        } catch (Exception e) {
            log.error("get P00listaopcion failed", e);
            throw new ZMessManager().new FindingException("P00listaopcion");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<P00listaopcion> findPageP00listaopcion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<P00listaopcion> entity = null;

        try {
            entity = p00listaopcionDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "P00listaopcion Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberP00listaopcion() throws Exception {
        Long entity = null;

        try {
            entity = p00listaopcionDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "P00listaopcion Count");
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
    public List<P00listaopcion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<P00listaopcion> list = new ArrayList<P00listaopcion>();
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
            list = p00listaopcionDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
