/**
 * Copyright (C),2015-2018
 * FileNmae: Department
 * Author:   Administrator
 * Date:     2018/10/17 19:14
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.bean;

import java.util.List;

/**
 * Department
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 19:14
 */
public class Department {
    /**
     * 科室id
     */
    private int depid;
    /**
     * 科室编号
     */
    private String depnum;
    /**
     * 科室名
     */
    private String depname;
    private List<Doctor> docList;

    public List<Doctor> getDocList() {
        return docList;
    }

    public void setDocList(List<Doctor> docList) {
        this.docList = docList;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getDepnum() {
        return depnum;
    }

    public void setDepnum(String depnum) {
        this.depnum = depnum;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }
}
