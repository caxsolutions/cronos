package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P00usuario;
import com.cronos.modelo.dto.P00usuarioDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP00usuarioLogic {
    public List<P00usuario> getP00usuario() throws Exception;

    /**
         * Save an new P00usuario entity
         */
    public void saveP00usuario(P00usuario entity) throws Exception;

    /**
         * Delete an existing P00usuario entity
         *
         */
    public void deleteP00usuario(P00usuario entity) throws Exception;

    /**
        * Update an existing P00usuario entity
        *
        */
    public void updateP00usuario(P00usuario entity) throws Exception;

    /**
         * Load an existing P00usuario entity
         *
         */
    public P00usuario getP00usuario(Long rowidusuario)
        throws Exception;

    public List<P00usuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00usuario> findPageP00usuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00usuario() throws Exception;

    public List<P00usuarioDTO> getDataP00usuario() throws Exception;
}
