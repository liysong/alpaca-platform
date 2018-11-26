package com.alpaca.admin.service.impl;

import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.mapper.SysUserMapper;
import com.alpaca.admin.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author song
 * @since 2018-11-04
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public SysUser querySysUserByLoginName(String loginName) {
        return baseMapper.querySysUserByLoginName(loginName);
    }

    @Override
    public int setStatus(String userId, int status) {
        return baseMapper.setStatus(userId,status);
    }

    @Override
    public int changePwd(String userId, String pwd) {
        return baseMapper.changePwd(userId,pwd);
    }


}