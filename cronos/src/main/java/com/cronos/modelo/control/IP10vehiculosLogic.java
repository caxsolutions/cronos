package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P10vehiculos;
import com.cronos.modelo.dto.P10vehiculosDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP10vehiculosLogic {
    public List<P10vehiculos> getP10vehiculos() throws Exception;

    /**
         * Save an new P10vehiculos entity
         */
    public void saveP10vehiculos(P10vehiculos entity) throws Exception;

    /**
         * Delete an existing P10vehiculos entity
         *
         */
    public void deleteP10vehiculos(P10vehiculos entity)
        throws Exception;

    /**
        * Update an existing P10vehiculos entity
        *
        */
    public void updateP10vehiculos(P10vehiculos entity)
        throws Exception;

    /**
         * Load an existing P10vehiculos entity
         *
         */
    public P10vehiculos getP10vehiculos(Integer rowidvehiculos)
        throws Exception;

    public List<P10vehiculos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P10vehiculos> findPageP10vehiculos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP10vehiculos() throws Exception;

    public List<P10vehiculosDTO> getDataP10vehiculos()
        throws Exception;
}
