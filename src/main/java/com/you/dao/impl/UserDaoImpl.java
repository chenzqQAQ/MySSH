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

import com.you.bean.Users;
import com.you.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * UserDaoImpl
 *
 *
 * @author 陈泽群
 * @date 2018/10/8 16:50
 */
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Users user) {
        Session session = sessionFactory.openSession();
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
}
