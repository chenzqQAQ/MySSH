/**
 * Copyright (C),2015-2018
 * FileNmae: EmpDAOImpl
 * Author:   Administrator
 * Date:     2018/10/9 10:35
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.dao.impl;

import com.you.bean.EmpEntity;
import com.you.dao.EmpDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import test.Test;

import java.io.Serializable;
import java.util.List;

/**
 * EmpDAOImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/9 10:35
 */
public class EmpDAOImpl implements EmpDAO {
    @Override
    public void addEmp(EmpEntity empEntity) {

    }

    @Override
    public void delEmp(Serializable serializable) {

    }

    @Override
    public EmpEntity getEmp(Serializable serializable) {

        //获得一个会话，相当于一个物理连接,用于保存持久类。提供增删改查等操作
        Session session = Test.SESSIONFACTORY.openSession();
        //开启事务
        Transaction transaction = null;
        EmpEntity empEntity = null;
        try {
            transaction = session.beginTransaction();
            empEntity = session.get(EmpEntity.class, serializable);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            //会话关闭,相当于关闭连接
            session.close();
        }
        return empEntity;
    }

    @Override
    public void setEmp(EmpEntity empEntity) {

    }

    @Override
    public List listEmp() {
        //获得一个会话，相当于一个物理连接,用于保存持久类。提供增删改查等操作
        Session session = Test.SESSIONFACTORY.openSession();
        //开启事务
        Transaction transaction = null;
        List list = null;
        try {
            transaction = session.beginTransaction();
            list = session.createQuery("from EmpEntity ").list();
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
