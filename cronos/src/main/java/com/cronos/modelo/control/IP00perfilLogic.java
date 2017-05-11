package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P00perfil;
import com.cronos.modelo.dto.P00perfilDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP00perfilLogic {
    public List<P00perfil> getP00perfil() throws Exception;

    /**
         * Save an new P00perfil entity
         */
    public void saveP00perfil(P00perfil entity) throws Exception;

    /**
         * Delete an existing P00perfil entity
         *
         */
    public void deleteP00perfil(P00perfil entity) throws Exception;

    /**
        * Update an existing P00perfil entity
        *
        */
    public void updateP00perfil(P00perfil entity) throws Exception;

    /**
         * Load an existing P00perfil entity
         *
         */
    public P00perfil getP00perfil(Integer rowidperfil)
        throws Exception;

    public List<P00perfil> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P00perfil> findPageP00perfil(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP00perfil() throws Exception;

    public List<P00perfilDTO> getDataP00perfil() throws Exception;
}
