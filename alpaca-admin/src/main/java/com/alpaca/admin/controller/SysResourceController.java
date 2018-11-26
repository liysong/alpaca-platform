package com.alpaca.admin.controller;


import com.alpaca.admin.domain.SysResource;
import com.alpaca.admin.service.ISysResourceService;
import com.alpaca.admin.shiro.service.IShiroService;
import com.alpaca.common.system.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统资源表 前端控制器
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@RestController
@RequestMapping("/sys/menu")
public class SysResourceController extends BaseController {

    @Autowired
    private ISysResourceService sysResourceService;

    @Autowired
    private IShiroService shiroService;

    @RequestMapping("/nav")
    public ResponseMessage nav(){
        List<SysResource> menuList = sysResourceService.queryAllSysResourceByUserId(getUserId());
        Set<String> permissions = shiroService.getUserPermissions(getUserId());
        return ResponseMessage.ok().put("menuList", menuList).put("permissions", permissions);
    }

}
