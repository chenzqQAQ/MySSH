/**
 * Copyright (C),2015-2018
 * FileNmae: UserDaoImpl
 * Author:   Administrator
 * Date:     2018/10/8 16:50
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.dao.impl;

import com.you.Utils.Page;
import com.you.bean.Users;
import com.you.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDaoImpl
 *
 * @author 陈泽群
 * @date 2018/10/8 16:50
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void userAdd(Users user) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void updateUser(Users user) {
        getHibernateTemplate().update(user);
    }

    @Override
    public void delUser(Users user) {
        getHibernateTemplate().delete(user);
    }

    @Override
    public Users findUser(int id) {
        return getHibernateTemplate().get(Users.class, id);
    }

    @Override
    public List<Users> findUsers(Page page) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = criteriaBuilder.createQuery(Users.class);
        Root<Users> root = criteria.from(Users.class);
        criteria.select(root);
        List<Users> list = new ArrayList<>();
        Query<Users> query = session.createQuery(criteria);
        query.setMaxResults(page.getPageSize());
        query.setFirstResult(page.getOffset());
        list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public int userCount() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
        Root<Users> root = criteria.from(Users.class);
        criteria.select(criteriaBuilder.count(root.get("userid")));
        int count = session.createQuery(criteria).getSingleResult().intValue();
        session.close();
        return count;
    }
}
