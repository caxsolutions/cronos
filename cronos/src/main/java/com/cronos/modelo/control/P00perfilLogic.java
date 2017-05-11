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

import com.cronos.dataaccess.dao.IP00perfilDAO;
import com.cronos.dataaccess.dao.IP00perfilmenuDAO;
import com.cronos.dataaccess.dao.IP00usuarioDAO;
import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P00perfil;
import com.cronos.modelo.P00perfilmenu;
import com.cronos.modelo.P00usuario;
import com.cronos.modelo.dto.P00perfilDTO;
import com.cronos.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("P00perfilLogic")
public class P00perfilLogic implements IP00perfilLogic {
    private static final Logger log = LoggerFactory.getLogger(P00perfilLogic.class);

    /**
     * DAO injected by Spring that manages P00perfil entities
     *
     */
    @Autowired
    private IP00perfilDAO p00perfilDAO;

    /**
    * DAO injected by Spring that manages P00perfilmenu entities
    *
    */
    @Autowired
    private IP00perfilmenuDAO p00perfilmenuDAO;

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

    @Transactional(readOnly = true)
    public List<P00perfil> getP00perfil() throws Exception {
        log.debug("finding all P00perfil instances");

        List<P00perfil> list = new ArrayList<P00perfil>();

        try {
            list = p00perfilDAO.findAll();
        } catch (Exception e) {
            log.error("finding all P00perfil failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "P00perfil");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveP00perfil(P00perfil entity) throws Exception {
        log.debug("saving P00perfil instance");

        try {
            if (entity.getP00empresa() == null) {
                throw new ZMessManager().new ForeignException("p00empresa");
            }

            if (entity.getDiasvigencia() == null) {
                throw new ZMessManager().new EmptyFieldException("diasvigencia");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if (entity.getNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("nombre");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if (entity.getPerfil() == null) {
                throw new ZMessManager().new EmptyFieldException("perfil");
            }

            if ((entity.getPerfil() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getPerfil(), 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("perfil");
            }

            if (entity.getRowidperfil() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidperfil");
            }

            if (entity.getP00empresa().getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidempresa_P00empresa");
            }

            if (getP00perfil(entity.getRowidperfil()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            p00perfilDAO.save(entity);

            log.debug("save P00perfil successful");
        } catch (Exception e) {
            log.error("save P00perfil failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteP00perfil(P00perfil entity) throws Exception {
        log.debug("deleting P00perfil instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("P00perfil");
        }

        if (entity.getRowidperfil() == null) {
            throw new ZMessManager().new EmptyFieldException("rowidperfil");
        }

        List<P00perfilmenu> p00perfilmenus = null;
        List<P00usuario> p00usuarios = null;

        try {
            p00perfilmenus = p00perfilmenuDAO.findByProperty("p00perfil.rowidperfil",
                    entity.getRowidperfil());

            if (Utilities.validationsList(p00perfilmenus) == true) {
                throw new ZMessManager().new DeletingException("p00perfilmenus");
            }

            p00usuarios = p00usuarioDAO.findByProperty("p00perfil.rowidperfil",
                    entity.getRowidperfil());

            if (Utilities.validationsList(p00usuarios) == true) {
                throw new ZMessManager().new DeletingException("p00usuarios");
            }

            p00perfilDAO.delete(entity);

            log.debug("delete P00perfil successful");
        } catch (Exception e) {
            log.error("delete P00perfil failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateP00perfil(P00perfil entity) throws Exception {
        log.debug("updating P00perfil instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("P00perfil");
            }

            if (entity.getP00empresa() == null) {
                throw new ZMessManager().new ForeignException("p00empresa");
            }

            if (entity.getDiasvigencia() == null) {
                throw new ZMessManager().new EmptyFieldException("diasvigencia");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if (entity.getNombre() == null) {
                throw new ZMessManager().new EmptyFieldException("nombre");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if (entity.getPerfil() == null) {
                throw new ZMessManager().new EmptyFieldException("perfil");
            }

            if ((entity.getPerfil() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getPerfil(), 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("perfil");
            }

            if (entity.getRowidperfil() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidperfil");
            }

            if (entity.getP00empresa().getRowidempresa() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidempresa_P00empresa");
            }

            p00perfilDAO.update(entity);

            log.debug("update P00perfil successful");
        } catch (Exception e) {
            log.error("update P00perfil failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<P00perfilDTO> getDataP00perfil() throws Exception {
        try {
            List<P00perfil> p00perfil = p00perfilDAO.findAll();

            List<P00perfilDTO> p00perfilDTO = new ArrayList<P00perfilDTO>();

            for (P00perfil p00perfilTmp : p00perfil) {
                P00perfilDTO p00perfilDTO2 = new P00perfilDTO();

                p00perfilDTO2.setRowidperfil(p00perfilTmp.getRowidperfil());
                p00perfilDTO2.setDiasvigencia((p00perfilTmp.getDiasvigencia() != null)
                    ? p00perfilTmp.getDiasvigencia() : null);
                p00perfilDTO2.setHabilita((p00perfilTmp.getHabilita() != null)
                    ? p00perfilTmp.getHabilita() : null);
                p00perfilDTO2.setNombre((p00perfilTmp.getNombre() != null)
                    ? p00perfilTmp.getNombre() : null);
                p00perfilDTO2.setPerfil((p00perfilTmp.getPerfil() != null)
                    ? p00perfilTmp.getPerfil() : null);
                p00perfilDTO2.setRowidempresa_P00empresa((p00perfilTmp.getP00empresa()
                                                                      .getRowidempresa() != null)
                    ? p00perfilTmp.getP00empresa().getRowidempresa() : null);
                p00perfilDTO.add(p00perfilDTO2);
            }

            return p00perfilDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public P00perfil getP00perfil(Integer rowidperfil)
        throws Exception {
        log.debug("getting P00perfil instance");

        P00perfil entity = null;

        try {
            entity = p00perfilDAO.findById(rowidperfil);
        } catch (Exception e) {
            log.error("get P00perfil failed", e);
            throw new ZMessManager().new FindingException("P00perfil");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<P00perfil> findPageP00perfil(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<P00perfil> entity = null;

        try {
            entity = p00perfilDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00perfil Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberP00perfil() throws Exception {
        Long entity = null;

        try {
            entity = p00perfilDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P00perfil Count");
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
    public List<P00perfil> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<P00perfil> list = new ArrayList<P00perfil>();
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
            list = p00perfilDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
