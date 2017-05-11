package com.cronos.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.cronos.dataaccess.api.HibernateDaoImpl;
import com.cronos.modelo.P10clientes;


/**
 * A data access object (DAO) providing persistence and search support for
 * P10clientes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.P10clientes
 */
@Scope("singleton")
@Repository("P10clientesDAO")
public class P10clientesDAO extends HibernateDaoImpl<P10clientes, Integer>
    implements IP10clientesDAO {
    private static final Logger log = LoggerFactory.getLogger(P10clientesDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IP10clientesDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IP10clientesDAO) ctx.getBean("P10clientesDAO");
    }
}
