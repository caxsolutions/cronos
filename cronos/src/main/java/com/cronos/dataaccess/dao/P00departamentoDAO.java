package com.cronos.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.cronos.dataaccess.api.HibernateDaoImpl;
import com.cronos.modelo.P00departamento;


/**
 * A data access object (DAO) providing persistence and search support for
 * P00departamento entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.P00departamento
 */
@Scope("singleton")
@Repository("P00departamentoDAO")
public class P00departamentoDAO extends HibernateDaoImpl<P00departamento, Integer>
    implements IP00departamentoDAO {
    private static final Logger log = LoggerFactory.getLogger(P00departamentoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IP00departamentoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IP00departamentoDAO) ctx.getBean("P00departamentoDAO");
    }
}
