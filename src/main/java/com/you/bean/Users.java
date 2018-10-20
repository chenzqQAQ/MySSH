/**
 * Copyright (C),2015-2018
 * FileNmae: Users
 * Author:   Administrator
 * Date:     2018/10/17 8:59
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.bean;

/**
 * Users
 * 用户实体
 *
 * @author 陈泽群
 * @date 2018/10/17 8:59
 */
public class Users {
    /**
     * 用户id
     */
    private int userid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String userpassword;
    /**
     * 修改时间
     */
    private String modifytime;
    /**
     * 角色id
     */
    private int roleid;
    /**
     * 状态
     */
    private Long flag;
    /**
     * 真实名
     */
    private String realname;
    /**
     * 电子邮箱
     */
    private String email;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Long getFlag() {
        return flag;
    }

    public void setFlag(Long flag) {
        this.flag = flag;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userid != users.userid) return false;
        if (roleid != users.roleid) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (userpassword != null ? !userpassword.equals(users.userpassword) : users.userpassword != null) return false;
        if (modifytime != null ? !modifytime.equals(users.modifytime) : users.modifytime != null) return false;
        if (flag != null ? !flag.equals(users.flag) : users.flag != null) return false;
        if (realname != null ? !realname.equals(users.realname) : users.realname != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userpassword != null ? userpassword.hashCode() : 0);
        result = 31 * result + (modifytime != null ? modifytime.hashCode() : 0);
        result = 31 * result + roleid;
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (realname != null ? realname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
