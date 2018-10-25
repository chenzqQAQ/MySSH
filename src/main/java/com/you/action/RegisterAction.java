/**
 * Copyright (C),2015-2018
 * FileNmae: RegisterAction
 * Author:   Administrator
 * Date:     2018/10/16 20:28
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.action;

import com.opensymphony.xwork2.ActionSupport;
import com.you.Service.RegisterService;
import com.you.bean.Register;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * RegisterAction
 * 挂号信息操作
 *
 * @author 陈泽群
 * @date 2018/10/16 20:28
 */
@Controller
@Scope("prototype")
@ParentPackage("struts-default")
public class RegisterAction extends ActionSupport {
    private Register register;
    private RegisterService registerService;

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public RegisterService getRegisterService() {
        return registerService;
    }

    @Autowired
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }


    public List<Register> registerList;

    public List<Register> getRegisterList() {
        return registerList;
    }

    public void setRegisterList(List<Register> registerList) {
        this.registerList = registerList;
    }

    /**
     * 挂号
     *
     * @return
     */
    @Action(value = "registerAdd", results = {
            @Result(name = "success", location = "/registerList", type = "redirectAction")
    })
    public String registerAdd() {
        registerService.registerAdd(register);
        return "success";
    }

    /**
     * 全部挂号信息
     *
     * @return
     */
    @Action(value = "registerList", results = {
            @Result(name = "success", location = "/registration/index.jsp")
    })
    public String registerAll() {
        registerList = registerService.findAllRegister();
        return "success";
    }

    @Action(value = "registerFind", results = {
            @Result(name = "success", location = "/registration/edit.jsp")
    })
    public String registerFind() {
        register = registerService.findRegister(register.getMedicalnum());
        return "success";
    }

    @Action(value = "registerUpdate", results = {
            @Result(name = "success", location = "/registerList", type = "redirectAction")
    })
    public String registerUpdate() {
        registerService.updateRegister(register);
        return "success";
    }
}
