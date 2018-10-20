package com.you.dao;

import com.you.bean.Department;

import java.util.List;

/**
 * DepartmentDao
 * 科室数据库操作
 *
 * @author 陈泽群
 * @date 2018/10/17 19:17
 */
public interface DepartmentDao {
    /**
     * 查全部科室
     * @return
     */
    public List<Department> allDep();
}
