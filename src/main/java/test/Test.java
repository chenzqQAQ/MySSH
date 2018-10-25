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

import com.you.Utils.Page;
import com.you.bean.DeptEntity;
import com.you.bean.Doctor;
import com.you.dao.DeptDao;
import com.you.dao.DocDao;
import com.you.dao.EmpDAO;
import com.you.dao.impl.DeptDaoImpl;
import com.you.dao.impl.DocDaoImpl;
import com.you.dao.impl.EmpDAOImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
    public static final Configuration CONFIGURATION;
    public static final SessionFactory SESSIONFACTORY;

    static {
        //加载hibernate.properties文件
        CONFIGURATION = new Configuration();
        //加载xml文件
        CONFIGURATION.configure();
        //创建session工厂
        SESSIONFACTORY = CONFIGURATION.buildSessionFactory();
    }

    public static void main(String[] args) {
        DocDao docDao = new DocDaoImpl();
        Page page = new Page();
        ((DocDaoImpl) docDao).setSuperSessionFactory(SESSIONFACTORY);
        Doctor doctor = new Doctor();
        // doctor.setDocid(8121);
        docDao.delDoc(8121);
        // Department department = new Department();
        // department.setDepname("内科");
        // doctor.setDep(department);
        // doctor.setDoctorname("  1 ");
        // doctor.setDocid(10);
        // int count = docDao.docCount(doctor);
        // page.setPageSize(3);
        // page.setTotalCount(count);
        // page.setPageNo(1);
        // if (count != 0) {
        //     List<Doctor> list = docDao.findDocs(doctor, page);
        //     System.out.println("查询结果");
        //     for (Doctor doctor1 : list) {
        //         System.out.println(String.format("医生姓名%s,医生id%d", doctor1.getDoctorname(), doctor1.getDocid()));
        //     }
        // }
        // System.out.println("总条数" + count);
        // ApplicationContext ac=new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        // TestService ts= (TestService) ac.getBean("testService");
        // ts.hello();
        //DeptEntity deptEntity = new DeptEntity();
        // list();
        // deptEntity.setDeptno(20L);
        // deptEntity.setDname("发");
        // System.out.println(deptDao.getDept(deptEntity).toString());
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
       /* DeptEntity deptEntity = new DeptEntity();
        deptEntity.setDname("小卖部");
        Set<EmpEntity> set = new HashSet<EmpEntity>();
        EmpEntity e1 = new EmpEntity();
        e1.setEname("abc1");
        e1.setSal(200L);
        EmpEntity e2 = new EmpEntity();
        e2.setEname("abc2");
        e2.setSal(400L);
        EmpEntity e3 = new EmpEntity();
        e3.setEname("abc3");
        e3.setSal(500L);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        deptEntity.setEmpEntities(set);
        deptDao.addDept(deptEntity);*/


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
