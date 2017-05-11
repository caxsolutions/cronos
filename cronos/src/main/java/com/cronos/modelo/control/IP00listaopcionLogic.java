package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P00listaopcion;
import com.cronos.modelo.dto.P00listaopcionDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP00listaopcionLogic {
    public List<P00listaopcion> getP00listaopcion() throws Exception;

    /**
         * Save an new P00listaopcion entity
         */
    public void saveP00listaopcion(P00listaopcion entity)
        throws Exception;

    /**
         * Delete an existing P00listaopcion entity
         *
         */
    public void deleteP00listaopcion(P00listaopcion entity)
        throws Exception;

    /**
        * Update an existing P00listaopcion entity
        *
        */
    public void updateP00listaopcion(P00listaopcion entity)
        throws Exception;

    /**
         * Load an existing P00listaopcion entity
         *
         */
    public P00listaopcion getP00listaopcion(Integer rowidopcion)
        throws Exception;

    public List<P00listaopcion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00listaopcion> findPageP00listaopcion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00listaopcion() throws Exception;

    public List<P00listaopcionDTO> getDataP00listaopcion()
        throws Exception;
}
