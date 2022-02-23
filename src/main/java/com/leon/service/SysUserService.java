package com.leon.service;

import com.leon.entity.SysUser;

public interface SysUserService {

    SysUser getOneById(Integer id);

    /**
     * 新增
     *
     * @param sysUser
     * @return
     */
    boolean insert(SysUser sysUser);
}