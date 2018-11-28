package com.alpaca.admin.mapper;

import com.alpaca.admin.domain.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户-角色 Mapper 接口
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    void  deleteByUser(String userId);
}
