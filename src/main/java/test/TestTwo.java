/**
 * Copyright (C),2015-2018
 * FileNmae: TestTwo
 * Author:   Administrator
 * Date:     2018/10/17 10:21
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package test;

import com.you.bean.Department;
import com.you.bean.Doctor;
import com.you.dao.impl.DocDaoImpl;

import java.util.List;

/**
 * TestTwo
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 10:21
 */
public class TestTwo {
    public static void main(String[] args) {
        /*DepartmentDao departmentDao = new DepartmentDaoImpl();
        List<Department> departments = departmentDao.allDep();
        for (int i = 0; i < departments.size(); i++) {
            Department department = departments.get(i);
            System.out.println(String.format("%d,%s", department.getDepid(), department.getDepname()));
        }*/
        DocDaoImpl docDao = new DocDaoImpl();
        Department department = new Department();
        department.setDepid(1);
        List<Doctor> list = docDao.findDocs(department);
        for (int i = 0; i < list.size(); i++) {
            Doctor doctor = list.get(i);
            System.out.println(String.format("%d,%s", doctor.getDocid(), doctor.getDoctorname()));
        }
    }
}
