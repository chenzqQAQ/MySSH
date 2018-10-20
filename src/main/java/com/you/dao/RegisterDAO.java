package com.you.dao;

import com.you.Utils.Page;
import com.you.bean.Register;

import java.io.Serializable;
import java.util.List;

/**
 * RegisterDAO
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/16 20:21
 */
public interface RegisterDAO {
    /**
     * 挂号信息添加操作
     *
     * @param register 挂号信息
     * @return int 影响行数
     */
    public Serializable registerAdd(Register register);

    /**
     * 挂号信息修改操作
     *
     * @param register 挂号信息
     * @return
     */
    public void updateRegister(Register register);

    /**
     * 挂号信息删除操作
     *
     * @param id 病历号
     * @return int 影响的行数
     */
    public void delRegister(int id);

    /**
     * 查询所有挂号信息操作
     *
     * @return List<Register> 挂号信息集合
     */
    public List<Register> findAllRegister();

    /**
     * 查询指定病历号的挂号信息
     *
     * @param id 病历号
     * @return 指定病历号的挂号信息
     */
    public Register findRegister(int id);

    /**
     * 分页查询所有挂号信息操作
     *
     * @return List<Register> 挂号信息集合
     */
    public List<Register> PageAllRegister(Page page);

    /**
     * 查询指定医生/科室的挂号信息条数
     *
     * @param register 指定医生/科室
     * @return int
     */
    public int findRegisterCount(Register register);

    /**
     * 分页查询查询指定医生/科室的挂号信息
     *
     * @param page 分页信息
     * @param register 指定医生/科室
     * @return List<Register> 挂号信息集合
     */
    public List<Register> PageAllRegister(Page page, Register register);

    /**
     * 删除选中的挂号信息
     *
     * @param args
     * @return
     */
    public void delAllRegister(int[] args);
    /**
     * 查询选中的挂号信息
     * @param args
     * @return
     */
    public List<Register> findAllRegister(int[] args);
}
