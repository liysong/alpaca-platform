package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.utils.CustomPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.grace.entity.system.UserVo;


import java.util.List;


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


    List<SysUser> queryUserPage(CustomPage<SysUser> page, String userName, Integer status);

    void  deleteBatchUser(String [] userIds);

    UserVo getUserByLoginName(String loginName);

    UserVo  getUserByMobile(String  mobile);

    UserVo  getUserById(String  id);

}
