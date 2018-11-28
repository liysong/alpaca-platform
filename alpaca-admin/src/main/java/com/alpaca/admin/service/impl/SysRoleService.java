package com.alpaca.admin.service.impl;

import com.alpaca.admin.domain.SysRole;
import com.alpaca.admin.domain.SysRoleResource;
import com.alpaca.admin.mapper.SysRoleMapper;
import com.alpaca.admin.service.ISysRoleResourceService;
import com.alpaca.admin.service.ISysRoleService;
import com.alpaca.admin.utils.CustomPage;
import com.alpaca.common.util.IdGenerator;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private ISysRoleResourceService sysRoleResourceService;

    @Override
    public boolean saveSysRole(SysRole sysRole) {
        String roleId = IdGenerator.getNextId();
        sysRole.setId(roleId);
        sysRole.setCreateTime(new Date());
        sysRole.setUpdateTime(new Date());

        List<SysRoleResource> sysRoleResourceList = getRoleResource(sysRole.getResourceIds(),roleId);
        if(sysRoleResourceList !=null){
            sysRoleResourceService.saveBatch(sysRoleResourceList);
            baseMapper.updateById(sysRole);
            return  true;
        }
        return false;
    }

    @Override
    public boolean updateSysRole(SysRole sysRole) {
        String roleId = sysRole.getId();
        sysRole.setUpdateTime(new Date());

        //删除旧的资源列表
        sysRoleResourceService.deleteByRoleId(roleId);
        List<SysRoleResource> sysRoleResourceList = getRoleResource(sysRole.getResourceIds(),roleId);
        if(sysRoleResourceList !=null){
            sysRoleResourceService.saveBatch(sysRoleResourceList);
            baseMapper.updateById(sysRole);
            return  true;
        }


        return false;
    }


    @Override
    public List<SysRole> queryPage(CustomPage<SysRole> page, String name) {
        return baseMapper.queryPage(page,name);
    }

    private  List<SysRoleResource> getRoleResource(List<String> list , String roleId){
        if(list !=null && list.size() >0 ){
            List<SysRoleResource> sysRoleResourceList = new ArrayList<>();
            for(String resourceId: list){
                sysRoleResourceList.add(new SysRoleResource(IdGenerator.getNextId(),roleId,resourceId));
            }
          return  sysRoleResourceList;
        }
        return  null;
    }
}
