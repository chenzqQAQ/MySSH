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
import com.you.Utils.Page;
import com.you.bean.Users;
import com.you.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 9:33
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void userAdd(Users user) {
        userDao.userAdd(user);
    }

    @Override
    public void updateUser(Users user) {
        userDao.updateUser(user);
    }

    @Override
    public void delUser(Users user) {
        userDao.delUser(user);
    }

    @Override
    public Users findUser(int id) {
        return userDao.findUser(id);
    }

    @Override
    public List<Users> findUsers(Page page) {
        return userDao.findUsers(page);
    }

    @Override
    public int userCount() {
        return userDao.userCount();
    }
}
