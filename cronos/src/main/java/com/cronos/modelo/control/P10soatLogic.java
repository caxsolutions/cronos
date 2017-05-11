package com.cronos.modelo.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cronos.dataaccess.dao.IP10soatDAO;
import com.cronos.exceptions.ZMessManager;
import com.cronos.modelo.P10soat;
import com.cronos.modelo.dto.P10soatDTO;
import com.cronos.modelo.dto.ext.DataSoatVehiculosDTOExt;
import com.cronos.utilities.FacesUtils;
import com.cronos.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("P10soatLogic")
public class P10soatLogic implements IP10soatLogic {
    private static final Logger log = LoggerFactory.getLogger(P10soatLogic.class);

    /**
     * DAO injected by Spring that manages P10soat entities
     *
     */
    @Autowired
    private IP10soatDAO p10soatDAO;

    /**
    * Logic injected by Spring that manages P10clientes entities
    *
    */
    @Autowired
    IP10clientesLogic logicP10clientes1;

    /**
    * Logic injected by Spring that manages P10vehiculos entities
    *
    */
    @Autowired
    IP10vehiculosLogic logicP10vehiculos2;

    @Transactional(readOnly = true)
    public List<P10soat> getP10soat() throws Exception {
        log.debug("finding all P10soat instances");

        List<P10soat> list = new ArrayList<P10soat>();

        try {
            list = p10soatDAO.findAll();
        } catch (Exception e) {
            log.error("finding all P10soat failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "P10soat");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveP10soat(P10soat entity) throws Exception {
        log.debug("saving P10soat instance");

        try {
            if (entity.getP10clientes() == null) {
                throw new ZMessManager().new ForeignException("p10clientes");
            }

            if (entity.getP10vehiculos() == null) {
                throw new ZMessManager().new ForeignException("p10vehiculos");
            }

            if (entity.getFechaexpedicion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaexpedicion");
            }

            if (entity.getFechainiciovigencia() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechainiciovigencia");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if (entity.getP10clientes().getRowidcliente() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidcliente_P10clientes");
            }

            if (entity.getP10vehiculos().getRowidvehiculos() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidvehiculos_P10vehiculos");
            }

            p10soatDAO.save(entity);

            log.debug("save P10soat successful");
        } catch (Exception e) {
            log.error("save P10soat failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteP10soat(P10soat entity) throws Exception {
        log.debug("deleting P10soat instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("P10soat");
        }

        if (entity.getRowidsoat() == null) {
            throw new ZMessManager().new EmptyFieldException("rowidsoat");
        }

        try {
            p10soatDAO.delete(entity);

            log.debug("delete P10soat successful");
        } catch (Exception e) {
            log.error("delete P10soat failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateP10soat(P10soat entity) throws Exception {
        log.debug("updating P10soat instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("P10soat");
            }

            if (entity.getP10clientes() == null) {
                throw new ZMessManager().new ForeignException("p10clientes");
            }

            if (entity.getP10vehiculos() == null) {
                throw new ZMessManager().new ForeignException("p10vehiculos");
            }

            if (entity.getFechaexpedicion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaexpedicion");
            }

            if (entity.getFechainiciovigencia() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechainiciovigencia");
            }

            if (entity.getHabilita() == null) {
                throw new ZMessManager().new EmptyFieldException("habilita");
            }

            if (entity.getRowidsoat() == null) {
                throw new ZMessManager().new EmptyFieldException("rowidsoat");
            }

            if (entity.getP10clientes().getRowidcliente() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidcliente_P10clientes");
            }

            if (entity.getP10vehiculos().getRowidvehiculos() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "rowidvehiculos_P10vehiculos");
            }

            p10soatDAO.update(entity);

            log.debug("update P10soat successful");
        } catch (Exception e) {
            log.error("update P10soat failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<P10soatDTO> getDataP10soat() throws Exception {
        try {
            List<P10soat> p10soat = p10soatDAO.findAll();

            List<P10soatDTO> p10soatDTO = new ArrayList<P10soatDTO>();

            for (P10soat p10soatTmp : p10soat) {
                P10soatDTO p10soatDTO2 = new P10soatDTO();

                p10soatDTO2.setRowidsoat(p10soatTmp.getRowidsoat());
                p10soatDTO2.setFechaexpedicion(p10soatTmp.getFechaexpedicion());
                p10soatDTO2.setFechainiciovigencia(p10soatTmp.getFechainiciovigencia());
                p10soatDTO2.setObservaciones(p10soatTmp.getObservaciones());
                p10soatDTO2.setHabilita((p10soatTmp.getHabilita() != null)
                    ? p10soatTmp.getHabilita() : null);
                p10soatDTO2.setRowidcliente_P10clientes((p10soatTmp.getP10clientes()
                                                                   .getRowidcliente() != null)
                    ? p10soatTmp.getP10clientes().getRowidcliente() : null);
                p10soatDTO2.setRowidvehiculos_P10vehiculos((p10soatTmp.getP10vehiculos()
                                                                      .getRowidvehiculos() != null)
                    ? p10soatTmp.getP10vehiculos().getRowidvehiculos() : null);
                p10soatDTO.add(p10soatDTO2);
            }

            return p10soatDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public P10soat getP10soat(Integer rowidsoat) throws Exception {
        log.debug("getting P10soat instance");

        P10soat entity = null;

        try {
            entity = p10soatDAO.findById(rowidsoat);
        } catch (Exception e) {
            log.error("get P10soat failed", e);
            throw new ZMessManager().new FindingException("P10soat");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<P10soat> findPageP10soat(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<P10soat> entity = null;

        try {
            entity = p10soatDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P10soat Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberP10soat() throws Exception {
        Long entity = null;

        try {
            entity = p10soatDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("P10soat Count");
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
    public List<P10soat> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<P10soat> list = new ArrayList<P10soat>();
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
            list = p10soatDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<DataSoatVehiculosDTOExt> getDataSoatVehiculosDTOExt(Integer idVehiculo)throws Exception{
    	try {
    		
    		if(idVehiculo != null){
    		
    			List<DataSoatVehiculosDTOExt> dataSoatVehiculosDTOExtList = new ArrayList<DataSoatVehiculosDTOExt>();
    			
    			Object[] variables = {"p10vehiculos.rowidvehiculos", false, idVehiculo, "="};
    			List<P10soat> p10soatList = findByCriteria(variables, null, null);
    			
    			if(p10soatList != null && p10soatList.size() > 0){
    				
    				for (P10soat p10soat : p10soatList) {
    					
    		    		Calendar calendar = Calendar.getInstance();
    		    		calendar.setTime(p10soat.getFechainiciovigencia());
    		    		calendar.add(Calendar.YEAR, 1);
    					
    					DataSoatVehiculosDTOExt dataSoatVehiculosDTOExt = new DataSoatVehiculosDTOExt();
    					dataSoatVehiculosDTOExt.setRowidsoat(p10soat.getRowidsoat());
    					dataSoatVehiculosDTOExt.setP10vehiculos(p10soat.getP10vehiculos() != null ? logicP10vehiculos2.getP10vehiculos(p10soat.getP10vehiculos().getRowidvehiculos()) : null);
    					dataSoatVehiculosDTOExt.setP10clientes(p10soat.getP10clientes() != null ? logicP10clientes1.getP10clientes(p10soat.getP10clientes().getRowidcliente()) : null);
    					dataSoatVehiculosDTOExt.setHabilita(p10soat.getHabilita());
    					dataSoatVehiculosDTOExt.setFechaexpedicion(p10soat.getFechaexpedicion());
    					dataSoatVehiculosDTOExt.setFechainiciovigencia(p10soat.getFechainiciovigencia());
    					dataSoatVehiculosDTOExt.setFechafinalvigencia(calendar.getTime());
    					dataSoatVehiculosDTOExt.setObservaciones(p10soat.getObservaciones());
    					dataSoatVehiculosDTOExt.setEstadosoat(p10soat.getHabilita() != null ? p10soat.getHabilita() ? "Habilitado" : "Inhabilitado" : "");
    					dataSoatVehiculosDTOExt.setEstadovigencia(calendar.getTime().after(new Date()) ? "Activo" : "Vencido");
    					
    					
    					dataSoatVehiculosDTOExtList.add(dataSoatVehiculosDTOExt);
					}
    			}
    			
    			return dataSoatVehiculosDTOExtList;
    		}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
    } 
}
