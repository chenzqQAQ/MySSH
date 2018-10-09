package com.you.dao;

import com.you.bean.EmpEntity;

import java.io.Serializable;
import java.util.List;

/**
 * EmpDAO
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/9 10:33
 */
public interface EmpDAO {
    /**
     * 增加员工
     *
     * @param empEntity
     */
    public void addEmp(EmpEntity empEntity);

    /**
     * 删除员工
     *
     * @param serializable
     */
    public void delEmp(Serializable serializable);

    /**
     * 查询员工(员工编号)
     *
     * @param serializable
     * @return
     */
    public EmpEntity getEmp(Serializable serializable);

    /**
     * 修改员工信息
     *
     * @param empEntity
     */
    public void setEmp(EmpEntity empEntity);

    /**
     * 全查员工
     *
     * @return
     */
    public List listEmp();
}
