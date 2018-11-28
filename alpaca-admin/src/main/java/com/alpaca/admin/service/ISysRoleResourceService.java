package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysRoleResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色-资源 服务类
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
public interface ISysRoleResourceService extends IService<SysRoleResource> {

    void   deleteByRoleId(String roleId);

    /**
     * 通过角色来查询当前角色所拥有的资源权限
     * @param roleId
     * @return
     */
    List<String> queryResourceIds(String roleId);
}
