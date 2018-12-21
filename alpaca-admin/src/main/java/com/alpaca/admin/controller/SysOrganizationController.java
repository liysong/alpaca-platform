package com.alpaca.admin.controller;


import com.alpaca.admin.annotation.OperationLog;
import com.alpaca.admin.domain.SysOrganization;
import com.alpaca.admin.service.ISysOrganizationService;
import com.alpaca.admin.utils.CustomPage;

import com.grace.commons.state.OperateType;
import com.grace.commons.system.ResponseMessage;
import com.grace.commons.system.SystemUser;
import com.grace.commons.util.IdGenerator;
import com.grace.commons.util.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.HashMap;
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
@RequestMapping("/sys/organization")
public class SysOrganizationController extends BaseController {

    @Autowired
    private ISysOrganizationService sysOrganizationService;


    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:organization:save")
    @OperationLog(operationType= OperateType.SAVE,operationName="新增资源")
    public ResponseMessage save(@RequestBody SysOrganization sysOrganization){

        sysOrganization.setCreateTime(new Date());
        sysOrganization.setId(IdGenerator.getNextId());
        sysOrganizationService.save(sysOrganization);

        return ResponseMessage.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:organization:update")
    public ResponseMessage update(@RequestBody  SysOrganization sysOrganization){

        sysOrganizationService.updateById(sysOrganization);

        return ResponseMessage.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:organization:delete")
    public ResponseMessage delete(String  id){
        //判断是否有子部门
      List<String> orgList = sysOrganizationService.queryOrgIdList(id);
        if(orgList.size() > 0){
            return ResponseMessage.error("存在下级单位，请先删除下级单位");
        }

       sysOrganizationService.removeById(id);

        return ResponseMessage.ok();
    }


    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:user:list")
    public   List<SysOrganization>  list(@RequestParam Map<String, Object> params){


        String orgName = null;
        if(params.get("orgName") !=null){
            orgName = params.get("orgName").toString();
        }

        String orgCode = null;
        if(params.get("orgCode") !=null){
            orgCode = params.get("orgCode").toString();
        }
        List<SysOrganization> list= sysOrganizationService.queryList(orgName,orgCode,getOrgId());
        return  list;
    }
   /* @RequestMapping("/list")
    //@RequiresPermissions("sys:user:list")
    public ResponseMessage list(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageUtils pageUtil = new PageUtils(params);

        //获取map参数
        CustomPage<SysOrganization> page = new CustomPage<>(pageUtil.getPage(),pageUtil.getLimit());

        String orgName = null;
        if(params.get("orgName") !=null){
            orgName = params.get("orgName").toString();
        }

        String orgCode = null;
        if(params.get("orgCode") !=null){
            orgCode = params.get("orgCode").toString();
        }
        List<SysOrganization> list= sysOrganizationService.queryPage(page,orgName,orgCode);

        page.setRecords(list);
        return ResponseMessage.ok().put("page", page);
    }*/

    @RequestMapping("/tree")
    //@RequiresPermissions("sys:user:list")
    public   List<SysOrganization>  tree(String id){

        if("".equals(id) || "null".equals(id)){
            id = getOrgId();
        }
        List<SysOrganization> list= sysOrganizationService.queryOrganizationList(id);
        return  list;
    }


    /**
     * 上级部门Id(管理员则为0)
     */
    @RequestMapping("/info")
    @RequiresPermissions("sys:organization:list")
    public ResponseMessage info(){
        String orgId = "1";
        if(getUserId() != SystemUser.ADMIN_ID){
            SysOrganization organization = sysOrganizationService.getById( getOrgId());
            orgId = organization.getParentId();
        }

        return ResponseMessage.ok().put("orgId", getOrgId());
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{deptId}")
    @RequiresPermissions("sys:organization:info")
    public ResponseMessage info(@PathVariable("deptId") String deptId){
        SysOrganization dept = sysOrganizationService.getById(deptId);

        return ResponseMessage.ok().put("dept", dept);
    }


    /**
     * 选择部门(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:organization:select")
    public ResponseMessage select(){

        List<SysOrganization> list= sysOrganizationService.queryList(null,null,getOrgId());

       list.add(sysOrganizationService.getById(getOrgId()));

        return ResponseMessage.ok().put("deptList", list);
    }



}
