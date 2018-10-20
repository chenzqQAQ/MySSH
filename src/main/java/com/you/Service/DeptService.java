/**
 * Copyright (C),2015-2018
 * FileNmae: DeptService
 * Author:   Administrator
 * Date:     2018/10/15 9:30
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.Service;

import com.you.bean.DeptEntity;
import com.you.dao.DeptDao;

import java.io.Serializable;
import java.util.List;

/**
 * DeptService
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/15 9:30
 */
public class DeptService {
    public DeptDao deptDao;

    public DeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    /**
     * 全查部门
     *
     * @return
     */
    public List<DeptEntity> listDept() {
        System.out.println("全查部门");
        return deptDao.listDept();
    }

    /**
     * 增加部门
     *
     * @param deptEntity
     */
    public void addDept(DeptEntity deptEntity) {
        deptDao.addDept(deptEntity);
    }

    /**
     * 删除部门
     *
     * @param serializable
     */
    public void delDept(Serializable serializable) {
        deptDao.delDept(serializable);
    }

    /**
     * 查询部门(部门编号)
     *
     * @param serializable
     * @return
     */
    public DeptEntity getDept(Serializable serializable) {
        return deptDao.getDept(serializable);
    }

    /**
     * 查询部门
     *
     * @param deptEntity
     * @return
     */
    public List<DeptEntity> getDept(DeptEntity deptEntity) {
        return deptDao.getDept(deptEntity);
    }

    /**
     * 修改部门信息
     *
     * @param deptEntity
     */
    public void setDept(DeptEntity deptEntity) {
        deptDao.setDept(deptEntity);
    }
}
