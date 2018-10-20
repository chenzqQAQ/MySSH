/**
 * Copyright (C),2015-2018
 * FileNmae: DocAction
 * Author:   Administrator
 * Date:     2018/10/17 20:21
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.you.Service.DocService;
import com.you.Utils.Page;
import com.you.bean.Department;
import com.you.bean.Doctor;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * DocAction
 * 医生操作
 *
 * @author 陈泽群
 * @date 2018/10/17 20:21
 */
@Controller
@ParentPackage("json-default")
public class DocAction extends ActionSupport {
    private DocService docService;

    public DocService getDocService() {
        return docService;
    }

    @Autowired
    public void setDocService(DocService docService) {
        this.docService = docService;
    }

    private Department department;

    private String result;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private Doctor doctor;
    private List<Doctor> doctors;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    /**
     * 异步请求科室全部医生
     *
     * @return
     */
    @Action(value = "docAjax", results = @Result(name = "success", type = "json", params = {"root", "result"}))
    public String docFind() {
        Gson gson = new Gson();
        System.out.println("科室id" + department.getDepid());
        result = gson.toJson(docService.findDocs(department));
        System.out.println(result);
        return "success";
    }

    @Action(value = "docsFind", results = {@Result(name = "success", location = "/doctor/index.jsp")})
    public String docsFind() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Page page = new Page();
        page.setPageSize(3);
        page.setTotalCount(docService.docCount(doctor));
        if (StringUtils.isNotBlank(request.getParameter("pageNo"))) {
            page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
        } else {
            page.setPageNo(1);
        }
        doctors = docService.findDocs(doctor, page);
        for (Doctor doctor1 : doctors) {
            System.out.println(doctor1.getDoctorname());
        }
        request.setAttribute("page", page);
        return SUCCESS;
    }
}
