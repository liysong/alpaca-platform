package com.alpaca.admin.controller;

import com.alpaca.admin.domain.SysUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: BaseController
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 20:43
 * @Version: 1.0.0
 */
public abstract  class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected String getUserId() {
        return getUser().getId();
    }

    protected String  getOrgId() {
        return getUser().getOrgId();
    }
}
