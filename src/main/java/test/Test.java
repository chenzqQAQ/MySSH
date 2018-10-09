/**
 * Copyright (C),2015-2018
 * FileNmae: Test
 * Author:   Administrator
 * Date:     2018/10/8 9:40
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package test;

import com.you.bean.DeptEntity;
import com.you.dao.DeptDao;
import com.you.dao.EmpDAO;
import com.you.dao.impl.DeptDaoImpl;
import com.you.dao.impl.EmpDAOImpl;

import java.io.Serializable;
import java.util.List;

/**
 * Test
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/8 9:40
 */
public class Test {
    static DeptDao deptDao = new DeptDaoImpl();
    static EmpDAO empDAO = new EmpDAOImpl();

    public static void main(String[] args) {
        // ApplicationContext ac=new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        // TestService ts= (TestService) ac.getBean("testService");
        // ts.hello();
        DeptEntity deptEntity = new DeptEntity();
        // list();
        // deptEntity.setDeptno(20L);
        deptEntity.setDname("S");
        System.out.println(deptDao.getDept(deptEntity).toString());
        // list();
        // deptEntity.setDname("人事部改");
        // set(deptEntity);
        // find(10L);
        // System.out.println(empDAO.getEmp(7369L).toString());
        // del(60L);
        // list();
        // List list = empDAO.listEmp();
        // System.out.println("全查结果");
        // if (list != null) {
        //     for (int i = 0; i < list.size(); i++) {
        //         System.out.println(list.get(i).toString());
        //     }
        // }


    }

    public static void add(DeptEntity deptEntity) {
        System.out.println("添加");
        deptDao.addDept(deptEntity);
    }

    public static void del(Serializable serializable) {
        System.out.println("删除");
        deptDao.delDept(serializable);
    }

    public static void set(DeptEntity deptEntity) {
        System.out.println("修改");
        deptDao.setDept(deptEntity);
    }

    public static void find(Serializable serializable) {
        DeptEntity deptEntity = deptDao.getDept(serializable);
        System.out.println("单查");
        if (deptEntity != null) {
            System.out.println(deptEntity.toString());
        } else {
            System.out.println("部门不存在");
        }
    }

    public static void list() {
        List list = deptDao.listDept();
        System.out.println("全查结果");
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        }
    }
}
