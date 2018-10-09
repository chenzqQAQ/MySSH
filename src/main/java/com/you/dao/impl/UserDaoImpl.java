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

import com.you.bean.User;
import com.you.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *UserDaoImpl
 *TODO(描述类的作用)
 *@author 陈泽群
 *@date 2018/10/8 16:50
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

    }
}
