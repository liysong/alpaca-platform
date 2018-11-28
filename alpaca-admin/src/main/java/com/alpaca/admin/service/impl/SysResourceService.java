package com.alpaca.admin.service.impl;

import com.alpaca.admin.domain.SysResource;
import com.alpaca.admin.mapper.SysResourceMapper;
import com.alpaca.admin.service.ISysResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统资源表 服务实现类
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@Service
public class SysResourceService extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

    @Override
    public List<String> queryAllPerpermissionCodesByUserId(String userId) {
        return baseMapper.queryAllPermissionCodesByUserId(userId);
    }

    @Override
    public List<SysResource> queryAllSysResourceByUserId(String uerId) {
       List<SysResource> list = baseMapper.queryAllSysResourceByUserId(uerId);

       return   getTreeList( list);
    }


    @Override
    public List<SysResource> queryNotButtonList() {
        return baseMapper.queryNotButtonList();
    }

    private List<SysResource>  getTreeList(List<SysResource> list){


        List<SysResource> resourcesList = new ArrayList<>();
        for(SysResource resource : list){
            if(resource.getType() == 0 ){
                 for(SysResource child : list){
                     if(child.getParentId().equals(resource.getId())){
                         resource.getList().add(child);
                         resource.setList(resource.getList());
                     }
                 }
                 resourcesList.add(resource);
            }
        }

        return  resourcesList;
    }
}
