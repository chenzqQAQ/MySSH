/**
 * Copyright (C),2015-2018
 * FileNmae: DocDaoImpl
 * Author:   Administrator
 * Date:     2018/10/17 19:36
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.dao.impl;

import com.you.Utils.Page;
import com.you.bean.Department;
import com.you.bean.Doctor;
import com.you.dao.DocDao;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * DocDaoImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 19:36
 */
@Repository
public class DocDaoImpl extends HibernateDaoSupport implements DocDao {

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Doctor> findDocs(Department department) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        // CriteriaQuery<Tuple> criteria=criteriaBuilder.createTupleQuery();
        CriteriaQuery<Doctor> criteria = criteriaBuilder.createQuery(Doctor.class);
        //选择一个根实体
        Root<Doctor> root = criteria.from(Doctor.class);
        Predicate predicate = null;
        predicate = criteriaBuilder.and(criteriaBuilder.equal(root.get("dep"), department), criteriaBuilder.equal(root.get("flag"), 1));
        criteria.where(criteriaBuilder.equal(root.get("dep"), department));
        Query<Doctor> query = session.createQuery(criteria);
        List<Doctor> list = query.list();
        // List<Doctor> list = query.list();
        return list;
    }

    @Override
    public void docAdd(Doctor doctor) {
        getHibernateTemplate().save(doctor);
    }

    @Override
    public void updateDoc(Doctor doctor) {
        getHibernateTemplate().update(doctor);
    }

    @Override
    public void delDoc(int id) {
        String hql = "update Doctor set flag=1 where docid=:docid";
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("docid", id);
            System.out.println(id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

    }

    @Override
    public Doctor findDoc(int id) {
        return getHibernateTemplate().get(Doctor.class, id);
    }

    @Override
    public int docCount(Doctor doctor) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
        Root<Doctor> root = criteria.from(Doctor.class);
        Root<Department> root1 = criteria.from(Department.class);
        criteria.select(criteriaBuilder.count(root.get("docid")));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("dep"), root1));
        predicates.add(criteriaBuilder.equal(root.get("flag"), 0));
        if (doctor != null) {
            if (doctor.getDocid() != 0) {
                predicates.add(criteriaBuilder.equal(root.get("docid"), doctor.getDocid()));
            }
            if (StringUtils.isNotBlank(doctor.getDoctorname())) {
                predicates.add(criteriaBuilder.like(root.<String>get("doctorname"), String.format("%%%s%%", StringUtils.trim(doctor.getDoctorname()))));
            }
            if (doctor.getDep() != null) {
                // predicates.add(criteriaBuilder.equal(root.get("dep"), doctor.getDep()));
                // criteriaBuilder.
                predicates.add(criteriaBuilder.like(root1.get("depname"), String.format("%%%s%%", StringUtils.trim(doctor.getDep().getDepname()))));
            }
        }
        if (predicates.size() != 0) {
            criteria.where(predicates.toArray(new Predicate[predicates.size()]));
        }
        Long singleResult = session.createQuery(criteria).getSingleResult();
        session.close();
        return singleResult.intValue();
    }

    @Override
    public List<Doctor> findDocs(Doctor doctor, Page page) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Doctor> criteria = criteriaBuilder.createQuery(Doctor.class);
        Root<Doctor> root = criteria.from(Doctor.class);
        Root<Department> root1 = criteria.from(Department.class);
        criteria.select(root);
        List<Predicate> predicates = new ArrayList<>();
        List<Doctor> list = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("dep"), root1));
        predicates.add(criteriaBuilder.equal(root.get("flag"), 0));
        if (doctor != null) {
            if (doctor.getDocid() != 0) {
                predicates.add(criteriaBuilder.equal(root.get("docid"), doctor.getDocid()));
            }
            if (StringUtils.isNotBlank(doctor.getDoctorname())) {
                predicates.add(criteriaBuilder.like(root.<String>get("doctorname"), String.format("%%%s%%", StringUtils.trim(doctor.getDoctorname()))));
            }
            if (doctor.getDep() != null) {
                predicates.add(criteriaBuilder.like(root1.get("depname"), String.format("%%%s%%", StringUtils.trim(doctor.getDep().getDepname()))));
            }
        }
        if (predicates.size() != 0) {
            criteria.where(predicates.toArray(new Predicate[predicates.size()]));
        }
        criteria.orderBy(criteriaBuilder.desc(root.get("docid")));

        Query<Doctor> query = session.createQuery(criteria);
        query.setMaxResults(page.getPageSize());
        query.setFirstResult(page.getOffset());
        list = query.getResultList();
        session.close();
        return list;
    }
}
