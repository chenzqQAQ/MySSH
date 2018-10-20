/**
 * Copyright (C),2015-2018
 * FileNmae: Register
 * Author:   Administrator
 * Date:     2018/10/16 20:15
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.bean;

/**
 * Register
 * 挂号信息
 *
 * @author 陈泽群
 * @date 2018/10/16 20:15
 */
public class Register {
    /**
     * 病历号
     */
    private int medicalnum;
    /**
     * 病患名字
     */
    private String registername;
    /**
     * 证件类型
     */
    private Long identifiertype;
    /**
     * 证件号
     */
    private String identifiernum;
    /**
     * 社保号
     */
    private String socialsecuritynum;
    /**
     * 手机号
     */
    private String phonenum;
    /**
     * 是否自费
     */
    private Long expenseflag;
    /**
     * 性别
     */
    private Long sex;
    /**
     * 年龄
     */
    private Long age;
    /**
     * 职业
     */
    private String profession;
    /**
     * 初复诊状态
     */
    private Long czflag;
    /**
     * 医生id
     */
    private Long doctorid;
    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * 状态
     */
    private Long flag;
    /**
     * 备注
     */
    private String remark;

    public int getMedicalnum() {
        return medicalnum;
    }

    public void setMedicalnum(int medicalnum) {
        this.medicalnum = medicalnum;
    }

    public String getRegistername() {
        return registername;
    }

    public void setRegistername(String registername) {
        this.registername = registername;
    }

    public Long getIdentifiertype() {
        return identifiertype;
    }

    public void setIdentifiertype(Long identifiertype) {
        this.identifiertype = identifiertype;
    }

    public String getIdentifiernum() {
        return identifiernum;
    }

    public void setIdentifiernum(String identifiernum) {
        this.identifiernum = identifiernum;
    }

    public String getSocialsecuritynum() {
        return socialsecuritynum;
    }

    public void setSocialsecuritynum(String socialsecuritynum) {
        this.socialsecuritynum = socialsecuritynum;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Long getExpenseflag() {
        return expenseflag;
    }

    public void setExpenseflag(Long expenseflag) {
        this.expenseflag = expenseflag;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Long getCzflag() {
        return czflag;
    }

    public void setCzflag(Long czflag) {
        this.czflag = czflag;
    }

    public Long getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Long doctorid) {
        this.doctorid = doctorid;
    }

    public Long getFlag() {
        return flag;
    }

    public void setFlag(Long flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
