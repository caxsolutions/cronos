package com.cronos.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.cronos.dataaccess.api.HibernateDaoImpl;
import com.cronos.modelo.P10soat;


/**
 * A data access object (DAO) providing persistence and search support for
 * P10soat entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.P10soat
 */
@Scope("singleton")
@Repository("P10soatDAO")
public class P10soatDAO extends HibernateDaoImpl<P10soat, Integer>
    implements IP10soatDAO {
    private static final Logger log = LoggerFactory.getLogger(P10soatDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IP10soatDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IP10soatDAO) ctx.getBean("P10soatDAO");
    }
}
