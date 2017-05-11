package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P00municipio;
import com.cronos.modelo.dto.P00municipioDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP00municipioLogic {
    public List<P00municipio> getP00municipio() throws Exception;

    /**
         * Save an new P00municipio entity
         */
    public void saveP00municipio(P00municipio entity) throws Exception;

    /**
         * Delete an existing P00municipio entity
         *
         */
    public void deleteP00municipio(P00municipio entity)
        throws Exception;

    /**
        * Update an existing P00municipio entity
        *
        */
    public void updateP00municipio(P00municipio entity)
        throws Exception;

    /**
         * Load an existing P00municipio entity
         *
         */
    public P00municipio getP00municipio(Integer idmunicipio)
        throws Exception;

    public List<P00municipio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00municipio> findPageP00municipio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00municipio() throws Exception;

    public List<P00municipioDTO> getDataP00municipio()
        throws Exception;
}
