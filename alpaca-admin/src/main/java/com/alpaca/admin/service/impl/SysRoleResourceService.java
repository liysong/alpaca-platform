package com.alpaca.admin.service.impl;

import com.alpaca.admin.domain.SysRoleResource;
import com.alpaca.admin.mapper.SysRoleResourceMapper;
import com.alpaca.admin.service.ISysRoleResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色-资源 服务实现类
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@Service
public class SysRoleResourceService extends ServiceImpl<SysRoleResourceMapper, SysRoleResource> implements ISysRoleResourceService {

    @Override
    public void deleteByRoleId(String roleId) {
        baseMapper.deleteByRoleId(roleId);
    }

    @Override
    public List<String> queryResourceIds(String roleId) {
        return baseMapper.queryResourceIds(roleId);
    }
}
