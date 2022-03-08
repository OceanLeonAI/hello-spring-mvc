package com.leon.service.impl;

import com.leon.entity.SysUser;
import com.leon.mapper.SysUserMapper;
import com.leon.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    public SysUserMapper sysUserMapper;

    @Override
    public SysUser getOneById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     *
     * @param sysUser
     * @return
     */
    @Transactional
    @Override
    public boolean insert(SysUser sysUser) {

        sysUser.setUsername("测试事务回滚");

        int insert = sysUserMapper.insert(sysUser);

//        String str = null;
//        str.toString();
//        if (true) {
//            throw new ArrayIndexOutOfBoundsException("故意抛出数组越界异常测试");
//        }

        return insert == 1;
    }
}