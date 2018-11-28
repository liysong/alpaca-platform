package com.alpaca.admin.mapper;

import com.alpaca.admin.domain.SysRoleResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色-资源 Mapper 接口
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
public interface SysRoleResourceMapper extends BaseMapper<SysRoleResource> {

    void  deleteByRoleId(String roleId);

    List<String> queryResourceIds(String roleId);
}
