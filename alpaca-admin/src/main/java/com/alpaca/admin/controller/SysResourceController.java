package com.alpaca.admin.controller;


import com.alpaca.admin.domain.SysResource;
import com.alpaca.admin.service.ISysResourceService;
import com.alpaca.admin.shiro.service.IShiroService;
import com.alpaca.common.system.ResponseMessage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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


    /**
     * 所有菜单列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public List<SysResource> list(){
        List<SysResource> menuList = sysResourceService.list(new QueryWrapper<>());

        return menuList;
    }

}
