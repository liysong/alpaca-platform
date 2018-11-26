package com.alpaca.admin.mapper;

import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.utils.CustomPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author song
 * @since 2018-11-04
 */
public interface SysUserMapper extends BaseMapper<SysUser> {


     SysUser querySysUserByLoginName(String loginName);

    int setStatus(@Param("userId") String userId, @Param("status") int status);

    /**
     * 修改密码
     */
    int changePwd(@Param("userId") String userId, @Param("pwd") String pwd);


    List<SysUser> queryUserPage(CustomPage<SysUser> page, @Param("userName") String userName, @Param("status")Integer status);




}
