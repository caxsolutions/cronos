package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P00perfilmenu;
import com.cronos.modelo.dto.P00perfilmenuDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP00perfilmenuLogic {
    public List<P00perfilmenu> getP00perfilmenu() throws Exception;

    /**
         * Save an new P00perfilmenu entity
         */
    public void saveP00perfilmenu(P00perfilmenu entity)
        throws Exception;

    /**
         * Delete an existing P00perfilmenu entity
         *
         */
    public void deleteP00perfilmenu(P00perfilmenu entity)
        throws Exception;

    /**
        * Update an existing P00perfilmenu entity
        *
        */
    public void updateP00perfilmenu(P00perfilmenu entity)
        throws Exception;

    /**
         * Load an existing P00perfilmenu entity
         *
         */
    public P00perfilmenu getP00perfilmenu(Integer rowidperfilmenu)
        throws Exception;

    public List<P00perfilmenu> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00perfilmenu> findPageP00perfilmenu(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00perfilmenu() throws Exception;

    public List<P00perfilmenuDTO> getDataP00perfilmenu()
        throws Exception;
}
