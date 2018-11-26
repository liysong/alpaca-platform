package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author song
 * @since 2018-11-04
 */
public interface ISysUserService extends IService<SysUser> {

    SysUser querySysUserByLoginName(String loginName);

    int setStatus(String userId, int status);

    /**
     * 修改密码
     */
    int changePwd(String userId, String pwd);


}
