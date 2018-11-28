package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysRoleResource;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
