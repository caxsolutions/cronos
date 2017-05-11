package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P00menu;
import com.cronos.modelo.dto.P00menuDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP00menuLogic {
    public List<P00menu> getP00menu() throws Exception;

    /**
         * Save an new P00menu entity
         */
    public void saveP00menu(P00menu entity) throws Exception;

    /**
         * Delete an existing P00menu entity
         *
         */
    public void deleteP00menu(P00menu entity) throws Exception;

    /**
        * Update an existing P00menu entity
        *
        */
    public void updateP00menu(P00menu entity) throws Exception;

    /**
         * Load an existing P00menu entity
         *
         */
    public P00menu getP00menu(Integer rowidmenu) throws Exception;

    public List<P00menu> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00menu> findPageP00menu(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00menu() throws Exception;

    public List<P00menuDTO> getDataP00menu() throws Exception;
}
