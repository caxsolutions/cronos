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

import com.cronos.dataaccess.dao.IP00menuDAO;
import com.cronos.dataaccess.dao.IP00perfilmenuDAO;
import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P00menu;
import com.cronos.modelo.P00perfilmenu;
import com.cronos.modelo.dto.P00menuDTO;
import com.cronos.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("P00menuLogic")
public class P00menuLogic implements IP00menuLogic {
    private static final Logger log = LoggerFactory.getLogger(P00menuLogic.class);

    /**
     * DAO injected by Spring that manages P00menu entities
     *
     */
    @Autowired
    private IP00menuDAO p00menuDAO;

    /**
    * DAO injected by Spring that manages P00perfilmenu entities
    *
    */
    @Autowired
    private IP00perfilmenuDAO p00perfilmenuDAO;

    @Transactional(readOnly = true)
    public List<P00menu> getP00menu() throws Exception {
        log.debug("finding all P00menu instances");

        List<P00menu> list = new ArrayList<P00menu>();

        try {
            list = p00menuDAO.findAll();
        } catch (Exception e) {
            log.error("finding all P00menu failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "P00menu");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveP00menu(P00menu entity) throws Exception {
        log.debug("saving P00menu instance");

        try {
            if ((entity.getComponentes() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getComponentes(), 80) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "componentes");
            }

            if (entity.getEncabezado() == null) {
                throw new ZMessManager().new EmptyFieldException("encabezado");
            }

            if ((entity.getEncabezado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEncabezado(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "encabezado");
            }

            if (entity.getExpandido() == null) {
                throw new ZMessManager().new EmptyFieldException("expandido");
            }

            if ((entity.getExpandido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getExpandido(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "expandido");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if ((entity.getHabilita() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getHabilita(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException("habilita");
            }

            if (entity.getImagen() == null) {
                throw new ZMessManager().new EmptyFieldException("imagen");
            }

            if ((entity.getImagen() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getImagen(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("imagen");
            }

            if (entity.getIndice() == null) {
                throw new ZMessManager().new EmptyFieldException("indice");
            }

            if ((entity.getIndice() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getIndice(),
                        20) == false)) {
                throw new ZMessManager().new NotValidFormatException("indice");
            }

            if (entity.getInstanciamultiple() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "instanciamultiple");
            }

            if ((entity.getInstanciamultiple() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInstanciamultiple(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "instanciamultiple");
            }

            if (entity.getNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("nombre");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        80) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if (entity.getRowidmenu() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidmenu");
            }

            if (entity.getValidacion() == null) {
                throw new ZMessManager().new EmptyFieldException("validacion");
            }

            if ((entity.getValidacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getValidacion(), 32) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "validacion");
            }

            if (getP00menu(entity.getRowidmenu()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            p00menuDAO.save(entity);

            log.debug("save P00menu successful");
        } catch (Exception e) {
            log.error("save P00menu failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteP00menu(P00menu entity) throws Exception {
        log.debug("deleting P00menu instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("P00menu");
        }

        if (entity.getRowidmenu() == null) {
            throw new ZMessManager().new EmptyFieldException("rowidmenu");
        }

        List<P00perfilmenu> p00perfilmenus = null;

        try {
            p00perfilmenus = p00perfilmenuDAO.findByProperty("p00menu.rowidmenu",
                    entity.getRowidmenu());

            if (Utilities.validationsList(p00perfilmenus) == true) {
                throw new ZMessManager().new DeletingException("p00perfilmenus");
            }

            p00menuDAO.delete(entity);

            log.debug("delete P00menu successful");
        } catch (Exception e) {
            log.error("delete P00menu failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateP00menu(P00menu entity) throws Exception {
        log.debug("updating P00menu instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("P00menu");
            }

            if ((entity.getComponentes() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getComponentes(), 80) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "componentes");
            }

            if (entity.getEncabezado() == null) {
                throw new ZMessManager().new EmptyFieldException("encabezado");
            }

            if ((entity.getEncabezado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEncabezado(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "encabezado");
            }

            if (entity.getExpandido() == null) {
                throw new ZMessManager().new EmptyFieldException("expandido");
            }

            if ((entity.getExpandido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getExpandido(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "expandido");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if ((entity.getHabilita() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getHabilita(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException("habilita");
            }

            if (entity.getImagen() == null) {
                throw new ZMessManager().new EmptyFieldException("imagen");
            }

            if ((entity.getImagen() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getImagen(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("imagen");
            }

            if (entity.getIndice() == null) {
                throw new ZMessManager().new EmptyFieldException("indice");
            }

            if ((entity.getIndice() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getIndice(),
                        20) == false)) {
                throw new ZMessManager().new NotValidFormatException("indice");
            }

            if (entity.getInstanciamultiple() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "instanciamultiple");
            }

            if ((entity.getInstanciamultiple() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInstanciamultiple(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "instanciamultiple");
            }

            if (entity.getNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("nombre");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        80) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if (entity.getRowidmenu() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidmenu");
            }

            if (entity.getValidacion() == null) {
                throw new ZMessManager().new EmptyFieldException("validacion");
            }

            if ((entity.getValidacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getValidacion(), 32) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "validacion");
            }

            p00menuDAO.update(entity);

            log.debug("update P00menu successful");
        } catch (Exception e) {
            log.error("update P00menu failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<P00menuDTO> getDataP00menu() throws Exception {
        try {
            List<P00menu> p00menu = p00menuDAO.findAll();

            List<P00menuDTO> p00menuDTO = new ArrayList<P00menuDTO>();

            for (P00menu p00menuTmp : p00menu) {
                P00menuDTO p00menuDTO2 = new P00menuDTO();

                p00menuDTO2.setRowidmenu(p00menuTmp.getRowidmenu());
                p00menuDTO2.setComponentes((p00menuTmp.getComponentes() != null)
                    ? p00menuTmp.getComponentes() : null);
                p00menuDTO2.setEncabezado((p00menuTmp.getEncabezado() != null)
                    ? p00menuTmp.getEncabezado() : null);
                p00menuDTO2.setExpandido((p00menuTmp.getExpandido() != null)
                    ? p00menuTmp.getExpandido() : null);
                p00menuDTO2.setHabilita((p00menuTmp.getHabilita() != null)
                    ? p00menuTmp.getHabilita() : null);
                p00menuDTO2.setImagen((p00menuTmp.getImagen() != null)
                    ? p00menuTmp.getImagen() : null);
                p00menuDTO2.setIndice((p00menuTmp.getIndice() != null)
                    ? p00menuTmp.getIndice() : null);
                p00menuDTO2.setInstanciamultiple((p00menuTmp.getInstanciamultiple() != null)
                    ? p00menuTmp.getInstanciamultiple() : null);
                p00menuDTO2.setNombre((p00menuTmp.getNombre() != null)
                    ? p00menuTmp.getNombre() : null);
                p00menuDTO2.setValidacion((p00menuTmp.getValidacion() != null)
                    ? p00menuTmp.getValidacion() : null);
                p00menuDTO.add(p00menuDTO2);
            }

            return p00menuDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public P00menu getP00menu(Integer rowidmenu) throws Exception {
        log.debug("getting P00menu instance");

        P00menu entity = null;

        try {
            entity = p00menuDAO.findById(rowidmenu);
        } catch (Exception e) {
            log.error("get P00menu failed", e);
            throw new ZMessManager().new FindingException("P00menu");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<P00menu> findPageP00menu(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<P00menu> entity = null;

        try {
            entity = p00menuDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00menu Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberP00menu() throws Exception {
        Long entity = null;

        try {
            entity = p00menuDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00menu Count");
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
    public List<P00menu> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<P00menu> list = new ArrayList<P00menu>();
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
            list = p00menuDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
