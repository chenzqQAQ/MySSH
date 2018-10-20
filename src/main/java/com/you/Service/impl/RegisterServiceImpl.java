/**
 * Copyright (C),2015-2018
 * FileNmae: RegisterServiceImpl
 * Author:   Administrator
 * Date:     2018/10/16 20:27
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.Service.impl;

import com.you.Service.RegisterService;
import com.you.Utils.Page;
import com.you.bean.Register;
import com.you.dao.RegisterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * RegisterServiceImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/16 20:27
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    private RegisterDAO registerDAO;

    public RegisterDAO getRegisterDAO() {
        return registerDAO;
    }

    @Autowired
    public void setRegisterDAO( RegisterDAO registerDAO) {
        this.registerDAO = registerDAO;
    }

    @Override
    public Serializable registerAdd(Register register) {
        return registerDAO.registerAdd(register);
    }

    @Override
    public int updateRegister(Register register) {
        registerDAO.updateRegister(register);
        return 0;
    }

    @Override
    public int delRegister(int id) {
        return 0;
    }

    @Override
    public List<Register> findAllRegister() {
        return registerDAO.findAllRegister();
    }

    @Override
    public Register findRegister(int id) {
        return registerDAO.findRegister(id);
    }

    @Override
    public List<Register> PageAllRegister(Page page) {
        return null;
    }

    @Override
    public int findRegisterCount(Register register) {
        return 0;
    }

    @Override
    public List<Register> PageAllRegister(Page page, Register register) {
        return null;
    }

    @Override
    public int delAllRegister(int[] args) {
        return 0;
    }

    @Override
    public List<Register> findAllRegister(int[] args) {
        return null;
    }
}
