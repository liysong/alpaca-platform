package com.alpaca.admin.controller;


import com.alpaca.admin.annotation.OperationLog;
import com.alpaca.admin.domain.SysResource;
import com.alpaca.admin.service.ISysResourceService;
import com.alpaca.admin.shiro.service.IShiroService;
import com.alpaca.common.state.DataState;
import com.alpaca.common.state.OperateType;
import com.alpaca.common.system.ResponseMessage;
import com.alpaca.common.util.IdGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统资源表(菜单) 前端控制器
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

    @RequestMapping("/save")
    @RequiresPermissions("sys:menu:save")
    @OperationLog(operationType= OperateType.SAVE,operationName="新增资源")
    public  ResponseMessage save(@RequestBody SysResource sysResource){

        sysResource.setId(IdGenerator.getNextId());
        sysResource.setFlag(DataState.ENABLE.getCode());
        sysResourceService.save(sysResource);
        return  ResponseMessage.ok();

    }

    @RequestMapping("/update")
    @RequiresPermissions("sys:menu:update")
    @OperationLog(operationType= OperateType.UPDATE,operationName="更新资源")
    public  ResponseMessage update(@RequestBody SysResource sysResource){

        //sysResource.setId(IdGenerator.getNextId());
        sysResource.setFlag(DataState.ENABLE.getCode());
        sysResourceService.updateById(sysResource);
        return  ResponseMessage.ok();

    }

    /**
     * 菜单信息
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("sys:menu:info")
    @OperationLog(operationType= OperateType.QUERY,operationName="查询资源")
    public ResponseMessage info(@PathVariable("menuId") String menuId){
        SysResource menu =  sysResourceService.getById(menuId);
        return ResponseMessage.ok().put("sysResource", menu);
    }

    @RequestMapping("/select")
    @RequiresPermissions("sys:menu:select")
    public ResponseMessage select(){
        List<SysResource> list = sysResourceService.queryNotButtonList();
        return  ResponseMessage.ok().put("menuList",list);
    }


    /**
     * 所有菜单列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    @OperationLog(operationType= OperateType.QUERY,operationName="查询资源列表")
    public List<SysResource> list(){
        List<SysResource> menuList = sysResourceService.list(new QueryWrapper<>());

        return menuList;
    }

}
