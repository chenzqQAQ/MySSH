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

import com.opensymphony.xwork2.ActionSupport;
import com.you.Service.UserService;
import com.you.Utils.Page;
import com.you.bean.Users;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * UserAction
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 9:34
 */
@Controller
@Scope("prototype")
@ParentPackage("struts-default")
public class UserAction extends ActionSupport {
    private Users users;
    private List<Users> usersList;

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

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

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Action(value = "userAdd", results = {@Result(name = "success", location = "/userAll", type = "redirectAction")})
    public String add() {
        userService.userAdd(users);
        return "success";
    }

    @Action(value = "userAll", results = {@Result(name = "success", location = "/User/index.jsp")})
    public String userAll() {
        Page page = new Page();
        page.setPageSize(3);
        page.setTotalCount(userService.userCount());
        usersList = userService.findUsers(page);
        return "success";
    }

    @Action(value = "userFind", results = {@Result(name = "success", location = "/User/editUser.jsp")})
    public String userFind() {
        users = userService.findUser(users.getUserid());
        return "success";
    }

    @Action(value = "userDel", results = {@Result(name = "success", location = "/userAll", type = "redirectAction")})
    public String userDel() {
        userService.delUser(users);
        return "success";
    }

    @Action(value = "userUpdate", results = {@Result(name = "success", location = "/userAll", type = "redirectAction")})
    public String userUpdate() {
        userService.updateUser(users);
        return "success";
    }
}
