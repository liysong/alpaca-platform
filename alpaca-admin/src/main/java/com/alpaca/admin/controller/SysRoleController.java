package com.alpaca.admin.controller;


import com.alpaca.admin.domain.SysResource;
import com.alpaca.admin.domain.SysRole;
import com.alpaca.admin.domain.SysRoleResource;
import com.alpaca.admin.service.ISysRoleResourceService;
import com.alpaca.admin.service.ISysRoleService;
import com.alpaca.admin.utils.CustomPage;
import com.alpaca.common.page.PageUtils;
import com.alpaca.common.system.ResponseMessage;
import com.alpaca.common.util.IdGenerator;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController{

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysRoleResourceService sysRoleResourceService;


    @RequestMapping("/save")
    public ResponseMessage save(@RequestBody SysRole sysRole){
       sysRoleService.saveSysRole(sysRole);
        return  ResponseMessage.ok();

    }



    @RequestMapping("/update")
    public ResponseMessage update(@RequestBody SysRole sysRole){

        sysRoleService.updateSysRole(sysRole);
        return  ResponseMessage.ok();

    }

    @RequestMapping("/delete")
    public ResponseMessage update(@RequestBody String  id){

        sysRoleService.removeById(id);
        return  ResponseMessage.ok();

    }

    @RequestMapping("/list")
    public ResponseMessage update(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageUtils pageUtil = new PageUtils(params);

        //获取map参数
        CustomPage<SysRole> page = new CustomPage<>(pageUtil.getPage(),pageUtil.getLimit());

        String roleName  = null;
        if(params.get("roleName") !=null){
            roleName = params.get("roleName").toString();
        }
        List<SysRole> list= sysRoleService.queryPage(page,roleName);

        page.setRecords(list);
        return ResponseMessage.ok().put("page", page);

    }

    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public ResponseMessage info(@PathVariable("roleId") String roleId){
        SysRole role = sysRoleService.getById(roleId);

        //查询角色对应的菜单
        List<String> menuIdList = sysRoleResourceService.queryResourceIds(roleId);
        role.setResourceIds(menuIdList);

        return ResponseMessage.ok().put("role", role);
    }



}
