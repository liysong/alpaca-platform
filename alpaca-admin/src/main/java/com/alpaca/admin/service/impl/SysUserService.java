package com.alpaca.admin.service.impl;

import com.alpaca.admin.domain.SysRole;
import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.mapper.SysUserMapper;
import com.alpaca.admin.service.ISysRoleService;
import com.alpaca.admin.service.ISysUserRoleService;
import com.alpaca.admin.service.ISysUserService;
import com.alpaca.admin.utils.CustomPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.grace.entity.system.RoleVo;
import com.grace.entity.system.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

   @Autowired
   private ISysRoleService sysRoleService;

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

    @Override
    public UserVo getUserByLoginName(String loginName) {

        UserVo userVo = baseMapper.getUserByLoginName(loginName);
        List<SysRole> list =  sysRoleService.queryUserRole(userVo.getId());
        if(list !=null && list.size() >0){
            List<RoleVo> roleVos = new ArrayList<>();
            for(SysRole sysRole : list){
                 RoleVo roleVo = new RoleVo();
                 roleVo.setId(sysRole.getId());
                 roleVo.setName(sysRole.getName());
                 roleVo.setRoleCode(sysRole.getRoleCode());
                 roleVo.setRoleType(sysRole.getRoleType());
                 roleVo.setStatus(sysRole.getStatus());
                 roleVo.setResourceIds(sysRole.getResourceIds());
                 roleVos.add(roleVo);
            }
            userVo.setRoleVoList(roleVos);
        }

        return userVo;
    }

    @Override
    public UserVo getUserByMobile(String mobile) {

        UserVo userVo = baseMapper.getUserByMobile(mobile);
        List<SysRole> list =  sysRoleService.queryUserRole(userVo.getId());
        if(list !=null && list.size() >0){
            List<RoleVo> roleVos = new ArrayList<>();
            for(SysRole sysRole : list){
                RoleVo roleVo = new RoleVo();
                roleVo.setId(sysRole.getId());
                roleVo.setName(sysRole.getName());
                roleVo.setRoleCode(sysRole.getRoleCode());
                roleVo.setRoleType(sysRole.getRoleType());
                roleVo.setStatus(sysRole.getStatus());
                roleVo.setResourceIds(sysRole.getResourceIds());
                roleVos.add(roleVo);
            }
            userVo.setRoleVoList(roleVos);
        }
        return userVo;

    }

    @Override
    public UserVo getUserById(String id) {
        UserVo userVo = baseMapper.getUserById(id);
        List<SysRole> list =  sysRoleService.queryUserRole(userVo.getId());
        if(list !=null && list.size() >0){
            List<RoleVo> roleVos = new ArrayList<>();
            for(SysRole sysRole : list){
                RoleVo roleVo = new RoleVo();
                roleVo.setId(sysRole.getId());
                roleVo.setName(sysRole.getName());
                roleVo.setRoleCode(sysRole.getRoleCode());
                roleVo.setRoleType(sysRole.getRoleType());
                roleVo.setStatus(sysRole.getStatus());
                roleVo.setResourceIds(sysRole.getResourceIds());
                roleVos.add(roleVo);
            }
            userVo.setRoleVoList(roleVos);
        }
        return userVo;
    }
}
