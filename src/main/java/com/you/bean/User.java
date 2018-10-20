/**
 * Copyright (C),2015-2018
 * FileNmae: User
 * Author:   Administrator
 * Date:     2018/10/8 11:17
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.bean;

/**
 *User
 *TODO(描述类的作用)
 *@author 陈泽群
 *@date 2018/10/8 11:17
 */
public class User {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) {
            return false;
        }
        if (password != null ? !password.equals(user.password) : user.password != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
