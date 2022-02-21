package com.leon.service.impl;

import com.leon.dao.SysUserMapper;
import com.leon.entity.SysUser;
import com.leon.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    public SysUserMapper sysUserMapper;

    @Override
    public SysUser getOneById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
}