/**
 * Copyright (C),2015-2018
 * FileNmae: DeptAction
 * Author:   Administrator
 * Date:     2018/10/15 9:29
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.you.Service.DeptService;
import com.you.bean.DeptEntity;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DeptAction
 * 部门操作
 *
 * @author 陈泽群
 * @date 2018/10/15 9:29
 */
public class DeptAction extends ActionSupport {
    private DeptService deptService;
    private DeptEntity deptEntity;

    private List<DeptEntity> depList;

    public List<DeptEntity> getDepList() {
        return depList;
    }

    public void setDepList(List<DeptEntity> depList) {
        this.depList = depList;
    }

    public DeptEntity getDeptEntity() {
        return deptEntity;
    }
    public void setDeptEntity(DeptEntity deptEntity) {
        this.deptEntity = deptEntity;
    }

    public DeptService getDeptService() {
        return deptService;
    }

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    public String deptAll() {
        /*ValueStack stack = ActionContext.getContext().getValueStack();
        Map<String, Object> context = new HashMap<String, Object>();
        List<DeptEntity> list;
        list = deptService.listDept();
        context.put("depts", list);
        stack.push(context);*/
        depList = deptService.listDept();
        System.out.println(depList.size());
        return SUCCESS;
    }

    public String deptAdd() {
        deptService.addDept(deptEntity);
        return "success";
    }

    public String deptUpdate() {
        deptService.setDept(deptEntity);
        return "success";
    }

    public String deptFind() {
        HttpServletRequest req = ServletActionContext.getRequest();
        long id = Long.parseLong(req.getParameter("deptno"));
        System.out.println("部门编号为" + id);
        ValueStack stack = ActionContext.getContext().getValueStack();
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("dept", deptService.getDept(id));
        stack.push(context);
        return "success";
    }
}
