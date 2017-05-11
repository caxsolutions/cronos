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

import com.cronos.dataaccess.dao.IP10vehiculosDAO;
import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P10vehiculos;
import com.cronos.modelo.dto.P10vehiculosDTO;
import com.cronos.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("P10vehiculosLogic")
public class P10vehiculosLogic implements IP10vehiculosLogic {
    private static final Logger log = LoggerFactory.getLogger(P10vehiculosLogic.class);

    /**
     * DAO injected by Spring that manages P10vehiculos entities
     *
     */
    @Autowired
    private IP10vehiculosDAO p10vehiculosDAO;

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
    * Logic injected by Spring that manages P10clientes entities
    *
    */
    @Autowired
    IP10clientesLogic logicP10clientes4;

    @Transactional(readOnly = true)
    public List<P10vehiculos> getP10vehiculos() throws Exception {
        log.debug("finding all P10vehiculos instances");

        List<P10vehiculos> list = new ArrayList<P10vehiculos>();

        try {
            list = p10vehiculosDAO.findAll();
        } catch (Exception e) {
            log.error("finding all P10vehiculos failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "P10vehiculos");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveP10vehiculos(P10vehiculos entity) throws Exception {
        log.debug("saving P10vehiculos instance");

        try {
            if (entity.getP00empresa() == null) {
                throw new ZMessManager().new ForeignException("p00empresa");
            }

            if (entity.getP00listaopcionByRowidclasevehiculo() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidclasevehiculo");
            }

            if (entity.getP00listaopcionByRowidtiposervicio() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidtiposervicio");
            }

            if (entity.getP10clientes() == null) {
                throw new ZMessManager().new ForeignException("p10clientes");
            }

            if ((entity.getCilindraje() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCilindraje(), 10) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cilindraje");
            }

            if ((entity.getCodigofasecolda() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCodigofasecolda(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "codigofasecolda");
            }

            if ((entity.getModelo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getModelo(), 6) == false)) {
                throw new ZMessManager().new NotValidFormatException("modelo");
            }

            if ((entity.getNrochasis() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNrochasis(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nrochasis");
            }

            if ((entity.getNromotor() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNromotor(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException("nromotor");
            }

            if ((entity.getNropasajeros() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNropasajeros(), 6) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nropasajeros");
            }

            if (entity.getNumeroplaca() == null) {
                throw new ZMessManager().new EmptyFieldException("numeroplaca");
            }

            if ((entity.getNumeroplaca() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNumeroplaca(), 6) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numeroplaca");
            }

            if (entity.getP00empresa().getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidempresa_P00empresa");
            }

            if (entity.getP00listaopcionByRowidclasevehiculo().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidtiposervicio().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP10clientes().getRowidcliente() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidcliente_P10clientes");
            }

            p10vehiculosDAO.save(entity);

            log.debug("save P10vehiculos successful");
        } catch (Exception e) {
            log.error("save P10vehiculos failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteP10vehiculos(P10vehiculos entity)
        throws Exception {
        log.debug("deleting P10vehiculos instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("P10vehiculos");
        }

        if (entity.getRowidvehiculos() == null) {
            throw new ZMessManager().new EmptyFieldException("rowidvehiculos");
        }

        try {
            p10vehiculosDAO.delete(entity);

            log.debug("delete P10vehiculos successful");
        } catch (Exception e) {
            log.error("delete P10vehiculos failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateP10vehiculos(P10vehiculos entity)
        throws Exception {
        log.debug("updating P10vehiculos instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("P10vehiculos");
            }

            if (entity.getP00empresa() == null) {
                throw new ZMessManager().new ForeignException("p00empresa");
            }

            if (entity.getP00listaopcionByRowidclasevehiculo() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidclasevehiculo");
            }

            if (entity.getP00listaopcionByRowidtiposervicio() == null) {
                throw new ZMessManager().new ForeignException(
                    "p00listaopcionByRowidtiposervicio");
            }

            if (entity.getP10clientes() == null) {
                throw new ZMessManager().new ForeignException("p10clientes");
            }

            if ((entity.getCilindraje() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCilindraje(), 10) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cilindraje");
            }

            if ((entity.getCodigofasecolda() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCodigofasecolda(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "codigofasecolda");
            }

            if ((entity.getModelo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getModelo(), 6) == false)) {
                throw new ZMessManager().new NotValidFormatException("modelo");
            }

            if ((entity.getNrochasis() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNrochasis(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nrochasis");
            }

            if ((entity.getNromotor() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNromotor(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException("nromotor");
            }

            if ((entity.getNropasajeros() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNropasajeros(), 6) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nropasajeros");
            }

            if (entity.getNumeroplaca() == null) {
                throw new ZMessManager().new EmptyFieldException("numeroplaca");
            }

            if ((entity.getNumeroplaca() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNumeroplaca(), 6) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numeroplaca");
            }

            if (entity.getRowidvehiculos() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidvehiculos");
            }

            if (entity.getP00empresa().getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidempresa_P00empresa");
            }

            if (entity.getP00listaopcionByRowidclasevehiculo().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP00listaopcionByRowidtiposervicio().getRowidopcion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidopcion_P00listaopcion");
            }

            if (entity.getP10clientes().getRowidcliente() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidcliente_P10clientes");
            }

            p10vehiculosDAO.update(entity);

            log.debug("update P10vehiculos successful");
        } catch (Exception e) {
            log.error("update P10vehiculos failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<P10vehiculosDTO> getDataP10vehiculos()
        throws Exception {
        try {
            List<P10vehiculos> p10vehiculos = p10vehiculosDAO.findAll();

            List<P10vehiculosDTO> p10vehiculosDTO = new ArrayList<P10vehiculosDTO>();

            for (P10vehiculos p10vehiculosTmp : p10vehiculos) {
                P10vehiculosDTO p10vehiculosDTO2 = new P10vehiculosDTO();

                p10vehiculosDTO2.setRowidvehiculos(p10vehiculosTmp.getRowidvehiculos());
                p10vehiculosDTO2.setCapacidadtoneladas((p10vehiculosTmp.getCapacidadtoneladas() != null)
                    ? p10vehiculosTmp.getCapacidadtoneladas() : null);
                p10vehiculosDTO2.setCilindraje((p10vehiculosTmp.getCilindraje() != null)
                    ? p10vehiculosTmp.getCilindraje() : null);
                p10vehiculosDTO2.setCodigofasecolda((p10vehiculosTmp.getCodigofasecolda() != null)
                    ? p10vehiculosTmp.getCodigofasecolda() : null);
                p10vehiculosDTO2.setModelo((p10vehiculosTmp.getModelo() != null)
                    ? p10vehiculosTmp.getModelo() : null);
                p10vehiculosDTO2.setNrochasis((p10vehiculosTmp.getNrochasis() != null)
                    ? p10vehiculosTmp.getNrochasis() : null);
                p10vehiculosDTO2.setNromotor((p10vehiculosTmp.getNromotor() != null)
                    ? p10vehiculosTmp.getNromotor() : null);
                p10vehiculosDTO2.setNropasajeros((p10vehiculosTmp.getNropasajeros() != null)
                    ? p10vehiculosTmp.getNropasajeros() : null);
                p10vehiculosDTO2.setNumeroplaca((p10vehiculosTmp.getNumeroplaca() != null)
                    ? p10vehiculosTmp.getNumeroplaca() : null);
                p10vehiculosDTO2.setRowidempresa_P00empresa((p10vehiculosTmp.getP00empresa()
                                                                            .getRowidempresa() != null)
                    ? p10vehiculosTmp.getP00empresa().getRowidempresa() : null);
                p10vehiculosDTO2.setRowidopcion_P00listaopcionclasevehiculo((p10vehiculosTmp.getP00listaopcionByRowidclasevehiculo().getRowidopcion() != null)
                    ? p10vehiculosTmp.getP00listaopcionByRowidclasevehiculo().getRowidopcion() : null);
                p10vehiculosDTO2.setRowidopcion_P00listaopciontiposervicio((p10vehiculosTmp.getP00listaopcionByRowidtiposervicio().getRowidopcion() != null)
                        ? p10vehiculosTmp.getP00listaopcionByRowidtiposervicio().getRowidopcion() : null);
                p10vehiculosDTO2.setRowidcliente_P10clientes((p10vehiculosTmp.getP10clientes()
                                                                             .getRowidcliente() != null)
                    ? p10vehiculosTmp.getP10clientes().getRowidcliente() : null);
                p10vehiculosDTO.add(p10vehiculosDTO2);
            }

            return p10vehiculosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public P10vehiculos getP10vehiculos(Integer rowidvehiculos)
        throws Exception {
        log.debug("getting P10vehiculos instance");

        P10vehiculos entity = null;

        try {
            entity = p10vehiculosDAO.findById(rowidvehiculos);
        } catch (Exception e) {
            log.error("get P10vehiculos failed", e);
            throw new ZMessManager().new FindingException("P10vehiculos");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<P10vehiculos> findPageP10vehiculos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<P10vehiculos> entity = null;

        try {
            entity = p10vehiculosDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P10vehiculos Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberP10vehiculos() throws Exception {
        Long entity = null;

        try {
            entity = p10vehiculosDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P10vehiculos Count");
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
    public List<P10vehiculos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<P10vehiculos> list = new ArrayList<P10vehiculos>();
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
            list = p10vehiculosDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
