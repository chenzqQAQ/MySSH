/**
 * Copyright (C),2015-2018
 * FileNmae: DepartmentDaoImpl
 * Author:   Administrator
 * Date:     2018/10/17 19:29
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.dao.impl;

import com.you.bean.Department;
import com.you.dao.DepartmentDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DepartmentDaoImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 19:29
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Department> allDep() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Department> list = null;
        try {
            transaction = session.beginTransaction();
            Query<Department> query =
                    session.createQuery("from Department order by depid", Department.class);
            list = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                list = null;
            }
            e.printStackTrace();
        } finally {
            //会话关闭,相当于关闭连接
            session.close();
        }
        return list;
    }
}
