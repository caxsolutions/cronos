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

import com.cronos.dataaccess.dao.IP00perfilmenuDAO;
import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P00perfilmenu;
import com.cronos.modelo.dto.P00perfilmenuDTO;
import com.cronos.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("P00perfilmenuLogic")
public class P00perfilmenuLogic implements IP00perfilmenuLogic {
    private static final Logger log = LoggerFactory.getLogger(P00perfilmenuLogic.class);

    /**
     * DAO injected by Spring that manages P00perfilmenu entities
     *
     */
    @Autowired
    private IP00perfilmenuDAO p00perfilmenuDAO;

    /**
    * Logic injected by Spring that manages P00menu entities
    *
    */
    @Autowired
    IP00menuLogic logicP00menu1;

    /**
    * Logic injected by Spring that manages P00perfil entities
    *
    */
    @Autowired
    IP00perfilLogic logicP00perfil2;

    @Transactional(readOnly = true)
    public List<P00perfilmenu> getP00perfilmenu() throws Exception {
        log.debug("finding all P00perfilmenu instances");

        List<P00perfilmenu> list = new ArrayList<P00perfilmenu>();

        try {
            list = p00perfilmenuDAO.findAll();
        } catch (Exception e) {
            log.error("finding all P00perfilmenu failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "P00perfilmenu");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveP00perfilmenu(P00perfilmenu entity)
        throws Exception {
        log.debug("saving P00perfilmenu instance");

        try {
            if (entity.getP00menu() == null) {
                throw new ZMessManager().new ForeignException("p00menu");
            }

            if (entity.getP00perfil() == null) {
                throw new ZMessManager().new ForeignException("p00perfil");
            }

            if (entity.getRowidperfilmenu() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidperfilmenu");
            }

            if (entity.getP00menu().getRowidmenu() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidmenu_P00menu");
            }

            if (entity.getP00perfil().getRowidperfil() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidperfil_P00perfil");
            }

            if (getP00perfilmenu(entity.getRowidperfilmenu()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            p00perfilmenuDAO.save(entity);

            log.debug("save P00perfilmenu successful");
        } catch (Exception e) {
            log.error("save P00perfilmenu failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteP00perfilmenu(P00perfilmenu entity)
        throws Exception {
        log.debug("deleting P00perfilmenu instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("P00perfilmenu");
        }

        if (entity.getRowidperfilmenu() == null) {
            throw new ZMessManager().new EmptyFieldException("rowidperfilmenu");
        }

        try {
            p00perfilmenuDAO.delete(entity);

            log.debug("delete P00perfilmenu successful");
        } catch (Exception e) {
            log.error("delete P00perfilmenu failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateP00perfilmenu(P00perfilmenu entity)
        throws Exception {
        log.debug("updating P00perfilmenu instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "P00perfilmenu");
            }

            if (entity.getP00menu() == null) {
                throw new ZMessManager().new ForeignException("p00menu");
            }

            if (entity.getP00perfil() == null) {
                throw new ZMessManager().new ForeignException("p00perfil");
            }

            if (entity.getRowidperfilmenu() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidperfilmenu");
            }

            if (entity.getP00menu().getRowidmenu() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidmenu_P00menu");
            }

            if (entity.getP00perfil().getRowidperfil() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidperfil_P00perfil");
            }

            p00perfilmenuDAO.update(entity);

            log.debug("update P00perfilmenu successful");
        } catch (Exception e) {
            log.error("update P00perfilmenu failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<P00perfilmenuDTO> getDataP00perfilmenu()
        throws Exception {
        try {
            List<P00perfilmenu> p00perfilmenu = p00perfilmenuDAO.findAll();

            List<P00perfilmenuDTO> p00perfilmenuDTO = new ArrayList<P00perfilmenuDTO>();

            for (P00perfilmenu p00perfilmenuTmp : p00perfilmenu) {
                P00perfilmenuDTO p00perfilmenuDTO2 = new P00perfilmenuDTO();

                p00perfilmenuDTO2.setRowidperfilmenu(p00perfilmenuTmp.getRowidperfilmenu());
                p00perfilmenuDTO2.setRowidmenu_P00menu((p00perfilmenuTmp.getP00menu()
                                                                        .getRowidmenu() != null)
                    ? p00perfilmenuTmp.getP00menu().getRowidmenu() : null);
                p00perfilmenuDTO2.setRowidperfil_P00perfil((p00perfilmenuTmp.getP00perfil()
                                                                            .getRowidperfil() != null)
                    ? p00perfilmenuTmp.getP00perfil().getRowidperfil() : null);
                p00perfilmenuDTO.add(p00perfilmenuDTO2);
            }

            return p00perfilmenuDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public P00perfilmenu getP00perfilmenu(Integer rowidperfilmenu)
        throws Exception {
        log.debug("getting P00perfilmenu instance");

        P00perfilmenu entity = null;

        try {
            entity = p00perfilmenuDAO.findById(rowidperfilmenu);
        } catch (Exception e) {
            log.error("get P00perfilmenu failed", e);
            throw new ZMessManager().new FindingException("P00perfilmenu");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<P00perfilmenu> findPageP00perfilmenu(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<P00perfilmenu> entity = null;

        try {
            entity = p00perfilmenuDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00perfilmenu Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberP00perfilmenu() throws Exception {
        Long entity = null;

        try {
            entity = p00perfilmenuDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00perfilmenu Count");
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
    public List<P00perfilmenu> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<P00perfilmenu> list = new ArrayList<P00perfilmenu>();
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
            list = p00perfilmenuDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
