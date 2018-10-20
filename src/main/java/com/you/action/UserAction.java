/**
 * Copyright (C),2015-2018
 * FileNmae: UserAction
 * Author:   Administrator
 * Date:     2018/10/17 9:34
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.action;

import com.you.Service.UserService;
import com.you.bean.Users;

/**
 * UserAction
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 9:34
 */
public class UserAction {
    private Users users;
    private UserService userService;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String add() {
        userService.add(users);
        System.out.println("aaaa");
        return "success";
    }
}
