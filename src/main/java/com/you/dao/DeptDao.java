package com.you.dao;

import com.you.bean.DeptEntity;

import java.io.Serializable;
import java.util.List;

/**
 * DeptDao
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/8 17:30
 */
public interface DeptDao {
    /**
     * 增加部门
     *
     * @param deptEntity
     */
    public void addDept(DeptEntity deptEntity);

    /**
     * 删除部门
     *
     * @param serializable
     */
    public void delDept(Serializable serializable);

    /**
     * 查询部门(部门编号)
     *
     * @param serializable
     * @return
     */
    public DeptEntity getDept(Serializable serializable);

    /**
     * 查询部门
     *
     * @param deptEntity
     * @return
     */
    public List<DeptEntity> getDept(DeptEntity deptEntity);

    /**
     * 修改部门信息
     *
     * @param deptEntity
     */
    public void setDept(DeptEntity deptEntity);

    /**
     * 全查部门
     *
     * @return
     */
    public List<DeptEntity> listDept();
}
