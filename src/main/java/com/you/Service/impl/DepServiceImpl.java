/**
 * Copyright (C),2015-2018
 * FileNmae: DepServiceImpl
 * Author:   Administrator
 * Date:     2018/10/17 20:19
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.Service.impl;

import com.you.Service.DepService;
import com.you.bean.Department;
import com.you.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DepServiceImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 20:19
 */
@Service
public class DepServiceImpl implements DepService {
    private DepartmentDao departmentDao;

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> allDep() {
        return departmentDao.allDep();
    }
}
