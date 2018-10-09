/**
 * Copyright (C),2015-2018
 * FileNmae: DeptDaoImpl
 * Author:   Administrator
 * Date:     2018/10/8 17:30
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.dao.impl;

import com.you.bean.DeptEntity;
import com.you.dao.DeptDao;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.List;

/**
 * DeptDaoImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/8 17:30
 */
public class DeptDaoImpl implements DeptDao {

    @Override
    public void addDept(DeptEntity deptEntity) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        System.out.println(deptEntity.toString());
        try {
            transaction = session.beginTransaction();
            System.out.println("保存成功：" + session.save(deptEntity));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("添加失败");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public void delDept(Serializable serializable) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            DeptEntity deptEntity = session.get(DeptEntity.class, serializable);
            session.delete(deptEntity);
            // Query query=session.createQuery("delete DeptEntity where deptno> :deptno");
            // query.setParameter("deptno",50L);
            // query.executeUpdate();
            System.out.println("删除成功");
            transaction.commit();
        } catch (Exception e) {
            System.out.println("删除失败");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    @Override
    public DeptEntity getDept(Serializable serializable) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        DeptEntity deptEntity = null;
        try {
            deptEntity = session.get(DeptEntity.class, serializable);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        return deptEntity;
    }

    @Override
    public List<DeptEntity> getDept(DeptEntity deptEntity) {
        //加载hibernate.properties文件
        Configuration configuration = new Configuration();
        //加载xml文件
        configuration.configure();
        //创建session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获得一个会话，相当于一个物理连接,用于保存持久类。提供增删改查等操作
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = null;
        List<DeptEntity> list = null;
        try {
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<DeptEntity> criteriaQuery = criteriaBuilder.createQuery(DeptEntity.class);
            Root<DeptEntity> root = criteriaQuery.from(DeptEntity.class);
            Path<String> dname = root.get("dname");
            criteriaQuery.select(root);
            Predicate predicate = null;
            if (deptEntity.getDeptno() != 0) {
                predicate = criteriaBuilder.equal(root.get("deptno"), deptEntity.getDeptno());
            }
            if (StringUtils.isNotBlank(deptEntity.getDname())) {
                if (predicate != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(dname, "%" + deptEntity.getDname() + "%"));
                } else {
                    predicate = criteriaBuilder.like(dname, "%" + deptEntity.getDname() + "%");
                }
            }
            criteriaQuery.where(predicate);
            list = session.createQuery(criteriaQuery).getResultList();
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
        return list;

    }

    @Override
    public void setDept(DeptEntity deptEntity) {
        //加载hibernate.properties文件
        Configuration configuration = new Configuration();
        //加载xml文件
        configuration.configure();
        //创建session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获得一个会话，相当于一个物理连接,用于保存持久类。提供增删改查等操作
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(deptEntity);
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

    }

    @Override
    public List<DeptEntity> listDept() {
        //加载hibernate.properties文件
        Configuration configuration = new Configuration();
        //加载xml文件
        configuration.configure();
        //创建session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获得一个会话，相当于一个物理连接,用于保存持久类。提供增删改查等操作
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = null;
        List list = null;
        try {
            transaction = session.beginTransaction();
            list = session.createQuery("from DeptEntity ").list();
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
