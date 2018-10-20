/**
 * Copyright (C),2015-2018
 * FileNmae: Login
 * Author:   Administrator
 * Date:     2018/10/11 11:54
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.you.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Login
 * 登录验证
 *
 * @author 陈泽群
 * @date 2018/10/11 11:54
 */
public class Login extends ActionSupport {
    private User user;

    @Override
    public String execute() {
        ValueStack stack = ActionContext.getContext().getValueStack();
        Map<String, Object> context = new HashMap<String, Object>();
        System.out.println("输入的名字为" + user.getUserName());
        context.put("message", new String("输入不正确"));
        stack.push(context);
        return ERROR;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
