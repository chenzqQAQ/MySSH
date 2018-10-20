package com.you.dao;

import com.you.Utils.Page;
import com.you.bean.Department;
import com.you.bean.Doctor;

import java.util.List;

/**
 * DocDao
 * 医生数据库操作
 *
 * @author 陈泽群
 * @date 2018/10/17 19:34
 */
public interface DocDao {
    /**
     * 根据科室查询所属医生
     *
     * @param department 科室信息
     * @return 符合条件医生信息
     */
    public List<Doctor> findDocs(Department department);

    /**
     * 添加医生
     *
     * @param doctor
     */
    public void docAdd(Doctor doctor);

    /**
     * 更新医生信息
     *
     * @param doctor
     */
    public void updateDoc(Doctor doctor);

    /**
     * 删除医生(修改显示状态)
     *
     * @param id
     */
    public void delDoc(int id);

    /**
     * 单查医生信息
     *
     * @param id
     * @return
     */
    public Doctor findDoc(int id);

    /**
     * 查询符合条件的医生信息条数
     *
     * @param doctor
     * @return
     */
    public int docCount(Doctor doctor);

    /**
     * 分页查询符合条件的医生信息
     *
     * @param doctor
     * @param page
     * @return
     */
    public List<Doctor> findDocs(Doctor doctor, Page page);
}
