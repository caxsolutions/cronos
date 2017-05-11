package com.cronos.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.cronos.dataaccess.api.HibernateDaoImpl;
import com.cronos.modelo.P00perfil;


/**
 * A data access object (DAO) providing persistence and search support for
 * P00perfil entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.P00perfil
 */
@Scope("singleton")
@Repository("P00perfilDAO")
public class P00perfilDAO extends HibernateDaoImpl<P00perfil, Integer>
    implements IP00perfilDAO {
    private static final Logger log = LoggerFactory.getLogger(P00perfilDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IP00perfilDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IP00perfilDAO) ctx.getBean("P00perfilDAO");
    }
}
