/**
 * Copyright (C),2015-2018
 * FileNmae: UserServiceImpl
 * Author:   Administrator
 * Date:     2018/10/17 9:33
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.Service.impl;

import com.you.Service.UserService;
import com.you.bean.Users;
import com.you.dao.UserDao;

/**
 * UserServiceImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 9:33
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(Users user) {
        userDao.add(user);
    }
}
