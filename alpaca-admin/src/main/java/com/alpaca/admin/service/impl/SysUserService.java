package com.alpaca.admin.service.impl;

import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.mapper.SysUserMapper;
import com.alpaca.admin.service.ISysUserRoleService;
import com.alpaca.admin.service.ISysUserService;
import com.alpaca.admin.utils.CustomPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

   @Autowired
   private ISysUserRoleService sysUserRoleService;

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


    @Override
    public List<SysUser> queryUserPage(CustomPage<SysUser> page, String userName, Integer status) {
        return baseMapper.queryUserPage(page,userName,status);
    }

    @Override
    @Transactional
    public void deleteBatchUser(String[] userIds) {
        /*
         * 这样写效率不高
         */
        for(String userId: userIds){
              sysUserRoleService.deleteByUser(userId);
              baseMapper.deleteById(userId);
        }
    }
}
