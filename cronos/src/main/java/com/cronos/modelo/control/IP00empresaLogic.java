package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P00empresa;
import com.cronos.modelo.dto.P00empresaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP00empresaLogic {
    public List<P00empresa> getP00empresa() throws Exception;

    /**
         * Save an new P00empresa entity
         */
    public void saveP00empresa(P00empresa entity) throws Exception;

    /**
         * Delete an existing P00empresa entity
         *
         */
    public void deleteP00empresa(P00empresa entity) throws Exception;

    /**
        * Update an existing P00empresa entity
        *
        */
    public void updateP00empresa(P00empresa entity) throws Exception;

    /**
         * Load an existing P00empresa entity
         *
         */
    public P00empresa getP00empresa(Integer rowidempresa)
        throws Exception;

    public List<P00empresa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00empresa> findPageP00empresa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00empresa() throws Exception;

    public List<P00empresaDTO> getDataP00empresa() throws Exception;
}
