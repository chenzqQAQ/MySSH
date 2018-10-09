/**
 * Copyright (C),2015-2018
 * FileNmae: DeptEntity
 * Author:   Administrator
 * Date:     2018/10/8 17:25
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.bean;

import java.util.Set;

/**
 * DeptEntity
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/8 17:25
 */
public class DeptEntity {
    /**
     * 部门编号
     */
    private long deptno;
    private String dname;
    private String loc;
    private Set<EmpEntity> empEntities;

    public long getDeptno() {
        return deptno;
    }

    public void setDeptno(long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "部门信息{" +
                "部门编号=" + deptno +
                ", 部门名称='" + dname + '\'' +
                ", 地点='" + loc + '\'' +
                ", 员工='" + seeAll() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeptEntity that = (DeptEntity) o;

        if (deptno != that.deptno) return false;
        if (dname != null ? !dname.equals(that.dname) : that.dname != null) return false;
        if (loc != null ? !loc.equals(that.loc) : that.loc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (deptno ^ (deptno >>> 32));
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        result = 31 * result + (loc != null ? loc.hashCode() : 0);
        return result;
    }

    public Set<EmpEntity> getEmpEntities() {
        return empEntities;
    }

    public void setEmpEntities(Set<EmpEntity> empEntities) {
        this.empEntities = empEntities;
    }

    public String seeAll() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        if (empEntities != null) {
            for (EmpEntity e : empEntities) {
                if (i != 0) {
                    stringBuilder.append("、");
                }
                stringBuilder.append(e.getEname());
                i++;
            }
        }
        return stringBuilder.toString();
    }
}
