package com.alpaca.admin.controller;


import com.alpaca.admin.domain.SysRole;
import com.alpaca.admin.domain.SysRoleResource;
import com.alpaca.admin.service.ISysRoleResourceService;
import com.alpaca.admin.service.ISysRoleService;
import com.alpaca.admin.utils.CustomPage;
import com.alpaca.common.page.PageUtils;
import com.alpaca.common.system.ResponseMessage;
import com.alpaca.common.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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



        return  ResponseMessage.ok();


    }



    @RequestMapping("/update")
    public ResponseMessage update(@RequestBody SysRole sysRole){

        String roleId = sysRole.getId();
        sysRole.setCreateTime(new Date());
        sysRole.setUpdateTime(new Date());

        //删除旧的资源列表

        List<String> list = sysRole.getResourceIds();
        if(list !=null && list.size() >0 ){
            List<SysRoleResource> sysRoleResourceList = new ArrayList<>();
            for(String resourceId: list){
                sysRoleResourceList.add(new SysRoleResource(IdGenerator.getNextId(),roleId,resourceId));
            }
            sysRoleResourceService.saveBatch(sysRoleResourceList);
        }
        sysRoleService.save(sysRole);

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



}
