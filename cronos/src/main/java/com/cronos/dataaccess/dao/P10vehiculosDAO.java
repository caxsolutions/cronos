package com.cronos.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.cronos.dataaccess.api.HibernateDaoImpl;
import com.cronos.modelo.P10vehiculos;


/**
 * A data access object (DAO) providing persistence and search support for
 * P10vehiculos entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.P10vehiculos
 */
@Scope("singleton")
@Repository("P10vehiculosDAO")
public class P10vehiculosDAO extends HibernateDaoImpl<P10vehiculos, Integer>
    implements IP10vehiculosDAO {
    private static final Logger log = LoggerFactory.getLogger(P10vehiculosDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IP10vehiculosDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IP10vehiculosDAO) ctx.getBean("P10vehiculosDAO");
    }
}
