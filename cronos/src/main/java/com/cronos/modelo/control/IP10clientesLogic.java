package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P10clientes;
import com.cronos.modelo.dto.P10clientesDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP10clientesLogic {
    public List<P10clientes> getP10clientes() throws Exception;

    /**
         * Save an new P10clientes entity
         */
    public void saveP10clientes(P10clientes entity) throws Exception;

    /**
         * Delete an existing P10clientes entity
         *
         */
    public void deleteP10clientes(P10clientes entity) throws Exception;

    /**
        * Update an existing P10clientes entity
        *
        */
    public void updateP10clientes(P10clientes entity) throws Exception;

    /**
         * Load an existing P10clientes entity
         *
         */
    public P10clientes getP10clientes(Integer rowidcliente)
        throws Exception;

    public List<P10clientes> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P10clientes> findPageP10clientes(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP10clientes() throws Exception;

    public List<P10clientesDTO> getDataP10clientes() throws Exception;
}
