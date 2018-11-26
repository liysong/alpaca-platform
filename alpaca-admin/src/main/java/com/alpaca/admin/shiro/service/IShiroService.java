package com.alpaca.admin.shiro.service;

import com.alpaca.admin.domain.SysToken;
import com.alpaca.admin.domain.SysUser;

import java.util.Set;

/**
 * @ClassName: IShiroService
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 19:35
 * @Version: 1.0.0
 */
public interface IShiroService {

    Set<String> getUserPermissions(String userId);

    SysToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUser queryUser(String userId);
}
