package com.alpaca.admin.controller;


import com.alpaca.admin.annotation.OperationLog;
import com.alpaca.admin.domain.SysRole;
import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.domain.SysUserRole;
import com.alpaca.admin.service.ISysRoleService;
import com.alpaca.admin.service.ISysUserRoleService;
import com.alpaca.admin.service.ISysUserService;
import com.alpaca.admin.shiro.ShiroUtils;
import com.alpaca.admin.utils.CustomPage;

import com.grace.commons.state.DataState;
import com.grace.commons.state.OperateType;
import com.grace.commons.system.ResponseMessage;
import com.grace.commons.util.IdGenerator;
import com.grace.commons.util.StringUtils;

import com.grace.page.util.PageUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户-角色 前端控制器
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 添加管理员
     */
    @RequestMapping("/save")
    @OperationLog(operationType= OperateType.SAVE,operationName="新增用户")
    public ResponseMessage add(@RequestBody SysUser user) {


        // 判断账号是否重复
        SysUser theUser = sysUserService.querySysUserByLoginName(user.getLoginName());

        if (theUser != null) {
            // throw new ServiceException(BizExceptionEnum.USER_ALREADY_REG);
            ResponseMessage.error("该账号已存在，请重新填写");
        }

        // 完善账号信息
        user.setId(IdGenerator.getNextId());
        user.setSalt(ShiroUtils.getRandomSalt(5));
        user.setPassword(ShiroUtils.md5(user.getPassword(), user.getSalt()));
        user.setStatus(DataState.ENABLE.getCode());
        user.setCreateTime(new Date());
        user.setCreateUser(getUserId());

        List<String> roleIds = user.getRoleIds();
        //获取角色id集合
        if(roleIds !=null && roleIds.size() >0){
            List<SysUserRole> list = new ArrayList<>();
            for(String roleId: roleIds){
                list.add(new SysUserRole(IdGenerator.getNextId(),user.getId(),roleId));
            }
            sysUserRoleService.saveBatch(list);
        }
        sysUserService.save(user);
        return ResponseMessage.ok();
    }


    @RequestMapping("/update")
    @OperationLog(operationType= OperateType.UPDATE,operationName="更新用户")
    public ResponseMessage  update(@Valid SysUser sysUser){

        if(sysUser != null){
            sysUserService.updateById(sysUser);
            return  ResponseMessage.ok();
        }
        return  ResponseMessage.error();
    }


    @RequestMapping("/delete")
    @OperationLog(operationType= OperateType.DELETE,operationName="删除用户")
    @ResponseBody
    public ResponseMessage  delete(@RequestBody String[] userIds){

        if(userIds !=null && userIds.length >0){
            //删除该用户下拥有的角色
            if(ArrayUtils.contains(userIds, 1L)){
                return ResponseMessage.error("系统管理员不能删除");
            }

            if(ArrayUtils.contains(userIds, getUserId())){
                return ResponseMessage.error("当前用户不能删除");
            }

            sysUserService.deleteBatchUser(userIds);

            return  ResponseMessage.ok();
        }
        return  ResponseMessage.error();
    }

    @OperationLog(operationType= OperateType.UPDATE,operationName="更改用户密码")
    @RequestMapping("/changePwd")
    public ResponseMessage changePwd(String oldPassword, String newPassword){

        if(StringUtils.isEmpty(newPassword)){
            return ResponseMessage.error("新密码不能为空");
        }

        String userId = ShiroUtils.getUserEntity().getId();
        SysUser user = sysUserService.getById(userId);
        String oldMd5 = ShiroUtils.md5(oldPassword, user.getSalt());
        if (user.getPassword().equals(oldMd5)) {
            String newMd5 = ShiroUtils.md5(newPassword, user.getSalt());
            //user.setPassword(newMd5);
            sysUserService.changePwd(userId,newMd5);
            return ResponseMessage.ok();
        } else {
            return ResponseMessage.error("旧密码不正确");
        }


    }


    @OperationLog(operationType= OperateType.UPDATE,operationName="改变用户状态")
    @RequestMapping("/changeStatus")
    @ResponseBody
    public ResponseMessage changeStatus(int status){

        String userId = ShiroUtils.getUserEntity().getId();

        sysUserService.setStatus(userId,status);

        return ResponseMessage.ok();
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info")
    public ResponseMessage info(){
        return ResponseMessage.ok().put("user", getUser());
    }


    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    @OperationLog(operationType= OperateType.QUERY,operationName="查询列表信息")
    public ResponseMessage list(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageUtils pageUtil = new PageUtils(params);

        //获取map参数
        CustomPage<SysUser> page = new CustomPage<>(pageUtil.getPage(),pageUtil.getLimit());

        List<SysUser> list= sysUserService.queryUserPage(page,null,1);

        page.setRecords(list);
        return ResponseMessage.ok().put("page", page);
    }

    /**
     * 角色信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:user:info")
    public ResponseMessage info(@PathVariable("id") String id){

        SysUser sysUser = sysUserService.getById(id);
        List<SysRole> sysRoles = sysRoleService.queryUserRole(id);
        if(sysRoles  !=null ){
            List<String> listRoleIds = new ArrayList<>();
            for(SysRole role : sysRoles){
                listRoleIds.add(role.getId());
            }
            sysUser.setRoleIdList(listRoleIds);
        }


        return ResponseMessage.ok().put("user", sysUser);
    }

 /*   @RequestMapping("getUserByLoginName/{loginName}")
    public UserVo getUserByLoginName(@PathVariable("loginName")String loginName){
        return  sysUserService.getUserByLoginName(loginName);
    }*/

}
