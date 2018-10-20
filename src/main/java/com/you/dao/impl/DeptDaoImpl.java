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
import org.hibernate.query.Query;

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
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDept(DeptEntity deptEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        // System.out.println(deptEntity.toString());
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
        }
    }

    @Override
    public void delDept(Serializable serializable) {
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
        }

    }

    @Override
    public DeptEntity getDept(Serializable serializable) {
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
        }
        return deptEntity;
    }

    @Override
    public List<DeptEntity> getDept(DeptEntity deptEntity) {
        //获得一个会话，相当于一个物理连接,用于保存持久类。提供增删改查等操作
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = null;
        List<DeptEntity> list = null;
        //离线查询，web层凭借查询条件，传个DetachedCriteria回来个
        //DetachedCriteria dc=DetachedCriteria.forClass(DeptEntity.class);
        try {
            transaction = session.beginTransaction();
            //获取查询条件
            //Criteria criteria=dc.getExecutableCriteria(session);
            /**
             * QEC hibernate5在线查询
             */
            //使用Citeria查询(条件查询,标准查询),创建一个Citeria所需要内容的工厂
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            //hibernate5，将原有的CiteriaAPI移植到了JPA下的CriteriaQuery
            //创建一个CriteriaQuery
            CriteriaQuery<DeptEntity> criteriaQuery = criteriaBuilder.createQuery(DeptEntity.class);
            //选择一个根实体
            Root<DeptEntity> root = criteriaQuery.from(DeptEntity.class);
            //选择一个参数属性
            Path<String> dname = root.get("dname");
            criteriaQuery.select(root);
            //查询条件
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
            if (predicate != null) {
                criteriaQuery.where(predicate);
            }
            //获取查询结果队列
            Query<DeptEntity> query = session.createQuery(criteriaQuery);
            //设置分页信息
            query.setFirstResult(0);
            query.setMaxResults(5);
            list = query.getResultList();
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
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = null;
        List list = null;
        try {
            transaction = session.beginTransaction();
            list = session.createQuery("from DeptEntity order by deptno").list();
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
