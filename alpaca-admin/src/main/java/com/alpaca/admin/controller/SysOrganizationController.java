package com.alpaca.admin.controller;


import com.alpaca.admin.domain.SysOrganization;
import com.alpaca.admin.service.ISysOrganizationService;
import com.alpaca.admin.utils.CustomPage;
import com.alpaca.common.page.PageUtils;
import com.alpaca.common.system.ResponseMessage;
import com.alpaca.common.system.SystemUser;
import com.alpaca.common.util.IdGenerator;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/sys/organization")
public class SysOrganizationController extends BaseController {

    @Autowired
    private ISysOrganizationService sysOrganizationService;


    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:dept:save")
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
    @RequiresPermissions("sys:dept:update")
    public ResponseMessage update(@RequestBody  SysOrganization sysOrganization){

        sysOrganizationService.updateById(sysOrganization);

        return ResponseMessage.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dept:delete")
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
    public ResponseMessage list(@RequestParam Map<String, Object> params){


        String orgName = null;
        if(params.get("orgName") !=null){
            orgName = params.get("orgName").toString();
        }

        String orgCode = null;
        if(params.get("orgCode") !=null){
            orgCode = params.get("orgCode").toString();
        }
        List<SysOrganization> list= sysOrganizationService.queryList(orgName,orgCode,null);

        return ResponseMessage.ok(list);
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

    /**
     * 上级部门Id(管理员则为0)
     */
    @RequestMapping("/info")
    @RequiresPermissions("sys:dept:list")
    public ResponseMessage info(){
        String orgId = "1";
        if(getUserId() != SystemUser.ADMIN_ID){
            SysOrganization organization = sysOrganizationService.getById( getOrgId());
            orgId = organization.getParentId();
        }

        return ResponseMessage.ok().put("orgId", getOrgId());
    }



}
