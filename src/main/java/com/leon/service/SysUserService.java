package com.leon.service;

import com.leon.entity.SysUser;

import java.util.List;

public interface SysUserService {

    SysUser getOneById(Integer id);

    /**
     * 新增
     *
     * @param sysUser
     * @return
     */
    boolean insert(SysUser sysUser);


    /**
     * 查询所有用户信息
     *
     * @param sysUser
     * @return
     */
    List<SysUser> selectAll(SysUser sysUser);
}