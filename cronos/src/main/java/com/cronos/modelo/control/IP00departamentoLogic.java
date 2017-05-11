package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P00departamento;
import com.cronos.modelo.dto.P00departamentoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP00departamentoLogic {
    public List<P00departamento> getP00departamento() throws Exception;

    /**
         * Save an new P00departamento entity
         */
    public void saveP00departamento(P00departamento entity)
        throws Exception;

    /**
         * Delete an existing P00departamento entity
         *
         */
    public void deleteP00departamento(P00departamento entity)
        throws Exception;

    /**
        * Update an existing P00departamento entity
        *
        */
    public void updateP00departamento(P00departamento entity)
        throws Exception;

    /**
         * Load an existing P00departamento entity
         *
         */
    public P00departamento getP00departamento(Integer iddepartamento)
        throws Exception;

    public List<P00departamento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00departamento> findPageP00departamento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberP00departamento() throws Exception;

    public List<P00departamentoDTO> getDataP00departamento()
        throws Exception;
}
