package com.you.Service;

import com.you.Utils.Page;
import com.you.bean.Users;

import java.util.List;

/**
 * UserService
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/17 9:33
 */
public interface UserService {
    public void userAdd(Users user);

    public void updateUser(Users user);

    public void delUser(Users user);

    public Users findUser(int id);

    public List<Users> findUsers(Page page);

    public int userCount();
}
