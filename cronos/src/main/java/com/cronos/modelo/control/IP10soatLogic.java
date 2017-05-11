package com.cronos.modelo.control;

import java.util.List;

import com.cronos.modelo.P10soat;
import com.cronos.modelo.dto.P10soatDTO;
import com.cronos.modelo.dto.ext.DataSoatVehiculosDTOExt;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IP10soatLogic {
    public List<P10soat> getP10soat() throws Exception;

    /**
         * Save an new P10soat entity
         */
    public void saveP10soat(P10soat entity) throws Exception;

    /**
         * Delete an existing P10soat entity
         *
         */
    public void deleteP10soat(P10soat entity) throws Exception;

    /**
        * Update an existing P10soat entity
        *
        */
    public void updateP10soat(P10soat entity) throws Exception;

    /**
         * Load an existing P10soat entity
         *
         */
    public P10soat getP10soat(Integer rowidsoat) throws Exception;

    public List<P10soat> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<P10soat> findPageP10soat(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberP10soat() throws Exception;

    public List<P10soatDTO> getDataP10soat() throws Exception;
    
    public List<DataSoatVehiculosDTOExt> getDataSoatVehiculosDTOExt(Integer idVehiculo)throws Exception;
}
