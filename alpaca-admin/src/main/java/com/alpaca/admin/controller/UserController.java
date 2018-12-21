package com.alpaca.admin.controller;

import com.alpaca.admin.service.ISysUserService;
import com.grace.commons.util.FastJsonUtils;
import com.grace.entity.system.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: song
 * @Date: 2018/12/19 14:50
 * @Description:  对外提供接口，便于其他模块调用
 * @Version:1.0.0
 */
@RestController
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/getUserByLoginName/{loginName}")
    public String getUserByLoginName(@PathVariable("loginName")String loginName){
        return FastJsonUtils.getBeanToJson(sysUserService.getUserByLoginName(loginName));
    }

    @RequestMapping("/getUserByMobile/{mobile}")
    public UserVo getUserByMobile(@PathVariable("mobile")String  mobile){
        return  sysUserService.getUserByMobile(mobile);
    }
}
