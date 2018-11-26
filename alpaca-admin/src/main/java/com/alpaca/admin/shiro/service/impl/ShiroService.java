package com.alpaca.admin.shiro.service.impl;

import com.alpaca.admin.domain.SysResource;
import com.alpaca.admin.domain.SysToken;
import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.service.ISysResourceService;
import com.alpaca.admin.service.ISysRoleService;
import com.alpaca.admin.service.ISysTokenService;
import com.alpaca.admin.service.ISysUserService;
import com.alpaca.admin.shiro.service.IShiroService;
import com.alpaca.common.system.SystemUser;
import com.alpaca.common.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: ShiroService
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 19:36
 * @Version: 1.0.0
 */
@Service
public class ShiroService implements IShiroService {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysResourceService sysResourceService;

    @Autowired
    private ISysTokenService sysTokenService;

    @Override
    public Set<String> getUserPermissions(String userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(SystemUser.ADMIN_ID.equals(userId)){
            List<SysResource> resourceList = sysResourceService.list(new QueryWrapper<SysResource>().eq("TYPE","2"));
            permsList = new ArrayList<>(resourceList.size());
            for(SysResource resource : resourceList){
                permsList.add(resource.getPermissionCode());
            }
        }else{
            permsList =  sysResourceService.queryAllPerpermissionCodesByUserId(userId);
                    //sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysToken queryByToken(String token) {
        return sysTokenService.queryByToken(token);
    }

    @Override
    public SysUser queryUser(String userId) {
        return sysUserService.getById(userId);
    }
}
