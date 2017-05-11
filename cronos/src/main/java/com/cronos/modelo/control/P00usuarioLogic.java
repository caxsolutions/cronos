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

import com.cronos.dataaccess.dao.IP00usuarioDAO;
import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P00usuario;
import com.cronos.modelo.dto.P00usuarioDTO;
import com.cronos.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("P00usuarioLogic")
public class P00usuarioLogic implements IP00usuarioLogic {
    private static final Logger log = LoggerFactory.getLogger(P00usuarioLogic.class);

    /**
     * DAO injected by Spring that manages P00usuario entities
     *
     */
    @Autowired
    private IP00usuarioDAO p00usuarioDAO;

    /**
    * Logic injected by Spring that manages P00empresa entities
    *
    */
    @Autowired
    IP00empresaLogic logicP00empresa1;

    /**
    * Logic injected by Spring that manages P00perfil entities
    *
    */
    @Autowired
    IP00perfilLogic logicP00perfil2;

    @Transactional(readOnly = true)
    public List<P00usuario> getP00usuario() throws Exception {
        log.debug("finding all P00usuario instances");

        List<P00usuario> list = new ArrayList<P00usuario>();

        try {
            list = p00usuarioDAO.findAll();
        } catch (Exception e) {
            log.error("finding all P00usuario failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "P00usuario");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveP00usuario(P00usuario entity) throws Exception {
        log.debug("saving P00usuario instance");

        try {
            if (entity.getP00empresa() == null) {
                throw new ZMessManager().new ForeignException("p00empresa");
            }

            if (entity.getP00perfil() == null) {
                throw new ZMessManager().new ForeignException("p00perfil");
            }

            if (entity.getCambiacontrasena() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "cambiacontrasena");
            }

            if (entity.getDescripcion() == null) {
                throw new ZMessManager().new EmptyFieldException("descripcion");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if (entity.getRowidusuario() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidusuario");
            }

            if (entity.getUsuario() == null) {
                throw new ZMessManager().new EmptyFieldException("usuario");
            }

            if ((entity.getUsuario() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuario(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException("usuario");
            }

            if ((entity.getValidacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getValidacion(), 32) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "validacion");
            }

            if (entity.getP00empresa().getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidempresa_P00empresa");
            }

            if (entity.getP00perfil().getRowidperfil() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidperfil_P00perfil");
            }

            if (getP00usuario(entity.getRowidusuario()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            p00usuarioDAO.save(entity);

            log.debug("save P00usuario successful");
        } catch (Exception e) {
            log.error("save P00usuario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteP00usuario(P00usuario entity) throws Exception {
        log.debug("deleting P00usuario instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("P00usuario");
        }

        if (entity.getRowidusuario() == null) {
            throw new ZMessManager().new EmptyFieldException("rowidusuario");
        }

        try {
            p00usuarioDAO.delete(entity);

            log.debug("delete P00usuario successful");
        } catch (Exception e) {
            log.error("delete P00usuario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateP00usuario(P00usuario entity) throws Exception {
        log.debug("updating P00usuario instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("P00usuario");
            }

            if (entity.getP00empresa() == null) {
                throw new ZMessManager().new ForeignException("p00empresa");
            }

            if (entity.getP00perfil() == null) {
                throw new ZMessManager().new ForeignException("p00perfil");
            }

            if (entity.getCambiacontrasena() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "cambiacontrasena");
            }

            if (entity.getDescripcion() == null) {
                throw new ZMessManager().new EmptyFieldException("descripcion");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if (entity.getRowidusuario() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidusuario");
            }

            if (entity.getUsuario() == null) {
                throw new ZMessManager().new EmptyFieldException("usuario");
            }

            if ((entity.getUsuario() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuario(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException("usuario");
            }

            if ((entity.getValidacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getValidacion(), 32) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "validacion");
            }

            if (entity.getP00empresa().getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidempresa_P00empresa");
            }

            if (entity.getP00perfil().getRowidperfil() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidperfil_P00perfil");
            }

            p00usuarioDAO.update(entity);

            log.debug("update P00usuario successful");
        } catch (Exception e) {
            log.error("update P00usuario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<P00usuarioDTO> getDataP00usuario() throws Exception {
        try {
            List<P00usuario> p00usuario = p00usuarioDAO.findAll();

            List<P00usuarioDTO> p00usuarioDTO = new ArrayList<P00usuarioDTO>();

            for (P00usuario p00usuarioTmp : p00usuario) {
                P00usuarioDTO p00usuarioDTO2 = new P00usuarioDTO();

                p00usuarioDTO2.setRowidusuario(p00usuarioTmp.getRowidusuario());
                p00usuarioDTO2.setCambiacontrasena((p00usuarioTmp.getCambiacontrasena() != null)
                    ? p00usuarioTmp.getCambiacontrasena() : null);
                p00usuarioDTO2.setDescripcion((p00usuarioTmp.getDescripcion() != null)
                    ? p00usuarioTmp.getDescripcion() : null);
                p00usuarioDTO2.setFechacambio(p00usuarioTmp.getFechacambio());
                p00usuarioDTO2.setHabilita((p00usuarioTmp.getHabilita() != null)
                    ? p00usuarioTmp.getHabilita() : null);
                p00usuarioDTO2.setUsuario((p00usuarioTmp.getUsuario() != null)
                    ? p00usuarioTmp.getUsuario() : null);
                p00usuarioDTO2.setValidacion((p00usuarioTmp.getValidacion() != null)
                    ? p00usuarioTmp.getValidacion() : null);
                p00usuarioDTO2.setRowidempresa_P00empresa((p00usuarioTmp.getP00empresa()
                                                                        .getRowidempresa() != null)
                    ? p00usuarioTmp.getP00empresa().getRowidempresa() : null);
                p00usuarioDTO2.setRowidperfil_P00perfil((p00usuarioTmp.getP00perfil()
                                                                      .getRowidperfil() != null)
                    ? p00usuarioTmp.getP00perfil().getRowidperfil() : null);
                p00usuarioDTO.add(p00usuarioDTO2);
            }

            return p00usuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public P00usuario getP00usuario(Long rowidusuario)
        throws Exception {
        log.debug("getting P00usuario instance");

        P00usuario entity = null;

        try {
            entity = p00usuarioDAO.findById(rowidusuario);
        } catch (Exception e) {
            log.error("get P00usuario failed", e);
            throw new ZMessManager().new FindingException("P00usuario");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<P00usuario> findPageP00usuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<P00usuario> entity = null;

        try {
            entity = p00usuarioDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00usuario Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberP00usuario() throws Exception {
        Long entity = null;

        try {
            entity = p00usuarioDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00usuario Count");
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
    public List<P00usuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<P00usuario> list = new ArrayList<P00usuario>();
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
            list = p00usuarioDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
