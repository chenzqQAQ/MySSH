/**
 * Copyright (C),2015-2018
 * FileNmae: DepartAction
 * Author:   Administrator
 * Date:     2018/10/17 20:20
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.action;

import com.google.gson.Gson;
import com.you.Service.DepService;
import com.you.bean.Department;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * DepartAction
 * 科室操作
 *
 * @author 陈泽群
 * @date 2018/10/17 20:20
 */
@Controller
@Scope("prototype")
@ParentPackage("json-default")
public class DepartAction {
    private DepService depService;

    public DepService getDepService() {
        return depService;
    }

    @Autowired
    public void setDepService(DepService depService) {
        this.depService = depService;
    }

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 异步显示全部科室
     *
     * @return
     */
    @Action(value = "depAjax", results = @Result(name = "success", type = "json", params = {"root", "result"}))
    public String allDep() {
        Gson gson = new Gson();
        List<Department> list = depService.allDep();
        result = gson.toJson(list);
        System.out.println(result);
        return "success";
    }
}
