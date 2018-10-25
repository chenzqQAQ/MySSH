package com.you.dao;

import com.you.Utils.Page;
import com.you.bean.Users;

import java.util.List;

/**
 * UserDao
 * 用户数据库操作
 *
 * @author 陈泽群
 * @date 2018/10/8 16:49
 */
public interface UserDao {
    public void userAdd(Users user);

    public void updateUser(Users user);

    public void delUser(Users user);

    public Users findUser(int id);

    public List<Users> findUsers(Page page);
    public int userCount();
}
