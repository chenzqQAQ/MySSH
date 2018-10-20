/**
 * Copyright (C),2015-2018
 * FileNmae: DocServiceImpl
 * Author:   Administrator
 * Date:     2018/10/18 8:53
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.Service.impl;

import com.you.Service.DocService;
import com.you.Utils.Page;
import com.you.bean.Department;
import com.you.bean.Doctor;
import com.you.dao.DocDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DocServiceImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/18 8:53
 */
@Service
public class DocServiceImpl implements DocService {
    private DocDao docDao;

    public DocDao getDocDao() {
        return docDao;
    }

    @Autowired
    public void setDocDao(DocDao docDao) {
        this.docDao = docDao;
    }

    @Override
    public List<Doctor> findDocs(Department department) {
        return docDao.findDocs(department);
    }

    @Override
    public void docAdd(Doctor doctor) {
        docDao.docAdd(doctor);
    }

    @Override
    public void updateDoc(Doctor doctor) {
        docDao.updateDoc(doctor);
    }

    @Override
    public void delDoc(int id) {
        docDao.delDoc(id);
    }

    @Override
    public Doctor findDoc(int id) {
        return docDao.findDoc(id);
    }

    @Override
    public int docCount(Doctor doctor) {
        return docDao.docCount(doctor);
    }

    @Override
    public List<Doctor> findDocs(Doctor doctor, Page page) {
        return docDao.findDocs(doctor, page);
    }
}
