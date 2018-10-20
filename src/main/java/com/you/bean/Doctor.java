/**
 * Copyright (C),2015-2018
 * FileNmae: Doctor
 * Author:   Administrator
 * Date:     2018/10/17 19:14
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.bean;

import java.sql.Time;

/**
 * Doctor
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 19:14
 */
public class Doctor {
    /**
     * 医生id
     */
    private int docid;
    /**
     * 医生名
     */
    private String doctorname;
    /**
     * 证件类型
     */
    private int identifiertype;
    /**
     * 证件号
     */
    private String identifiernum;
    /**
     * 手机号
     */
    private String phonenum;
    /**
     * 社保号
     */
    private String seatphonenum;
    /**
     * 性别
     */
    private int sex;
    /**
     * 年龄
     */
    private int age;
    /**
     * 生日
     */
    private Time birthday;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 科室
     */
    private Department dep;
    /**
     * 状态
     */
    private int flag;
    /**
     * 备注
     */
    private String remark;

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public int getIdentifiertype() {
        return identifiertype;
    }

    public void setIdentifiertype(int identifiertype) {
        this.identifiertype = identifiertype;
    }

    public String getIdentifiernum() {
        return identifiernum;
    }

    public void setIdentifiernum(String identifiernum) {
        this.identifiernum = identifiernum;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getSeatphonenum() {
        return seatphonenum;
    }

    public void setSeatphonenum(String seatphonenum) {
        this.seatphonenum = seatphonenum;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Time getBirthday() {
        return birthday;
    }

    public void setBirthday(Time birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
