/**
 * Copyright (C),2015-2018
 * FileNmae: RegisterDAOImpl
 * Author:   Administrator
 * Date:     2018/10/16 20:24
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.dao.impl;

import com.you.Utils.Page;
import com.you.bean.Register;
import com.you.dao.RegisterDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * RegisterDAOImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/16 20:24
 */
@Repository
public class RegisterDAOImpl extends HibernateDaoSupport implements RegisterDAO {
    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public Serializable registerAdd(Register register) {
        if (register != null) {
            return getHibernateTemplate().save(register);
        }
        return 0;
       /* Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Serializable i = 0;
        // System.out.println(deptEntity.toString());
        try {
            transaction = session.beginTransaction();
            i = session.save(register);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("添加失败");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return i;*/
    }

    @Override
    public void updateRegister(Register register) {
        if (register != null) {
            getHibernateTemplate().update(register);
        }
        /*Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(register);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("添加失败");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }*/
    }

    @Override
    public void delRegister(int id) {
        getHibernateTemplate().delete(id);
    }

    @Override
    public List<Register> findAllRegister() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        List<Register> list = null;
        Query<Register> query = session.createQuery("from Register order by id desc ");
        list = query.list();
        // Session session = sessionFactory.openSession();
        // Transaction transaction = null;
        // List<Register> list = null;

        // CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        // CriteriaQuery<Register> criteriaQuery = criteriaBuilder.createQuery(Register.class);
        // try {
        //     transaction = session.beginTransaction();
        //     Query<Register> query = session.createQuery("from Register order by id desc ");
        //     list = query.list();
        //     transaction.commit();
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     if (transaction != null) {
        //         transaction.rollback();
        //     }
        //     e.printStackTrace();
        // } finally {
        //     session.close();
        // }
        return list;
    }

    @Override
    public Register findRegister(int id) {
        return getHibernateTemplate().get(Register.class, id);
   /*     Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Register register = null;
        // CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        // CriteriaQuery<Register> criteriaQuery = criteriaBuilder.createQuery(Register.class);
        try {
            transaction = session.beginTransaction();
            register = session.get(Register.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return register;*/
    }

    @Override
    public List<Register> PageAllRegister(Page page) {
        return null;
    }

    @Override
    public int findRegisterCount(Register register) {
        return 0;
    }

    @Override
    public List<Register> PageAllRegister(Page page, Register register) {
        return null;
    }

    @Override
    public void delAllRegister(int[] args) {

    }

    @Override
    public List<Register> findAllRegister(int[] args) {
        return null;
    }
}
