package com.alpaca.admin.controller;


import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.domain.SysUserRole;
import com.alpaca.admin.service.ISysUserRoleService;
import com.alpaca.admin.service.ISysUserService;
import com.alpaca.admin.shiro.ShiroUtils;
import com.alpaca.admin.utils.CustomPage;
import com.alpaca.common.page.PageUtils;
import com.alpaca.common.state.DataState;
import com.alpaca.common.system.ResponseMessage;
import com.alpaca.common.util.IdGenerator;
import com.alpaca.common.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/sys/user/")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /**
     * 添加管理员
     */
    @RequestMapping("add")
  //  @OperationLog(operationType= OperateType.ADD,operationName="新增用户")
    public ResponseMessage add(@Valid SysUser user, String[] roleIds) {


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

        //获取角色id集合
        if(roleIds !=null && roleIds.length >0){
            List<SysUserRole> list = new ArrayList<>();
            for(String roleId: roleIds){
                list.add(new SysUserRole(IdGenerator.getNextId(),user.getId(),roleId));
            }
            sysUserRoleService.saveBatch(list);
        }
        sysUserService.save(user);
        return ResponseMessage.ok();
    }


    @RequestMapping("update")
   // @OperationLog(operationType= OperateType.UPDATE,operationName="更新用户")
    public ResponseMessage  update(@Valid SysUser sysUser){

        if(sysUser != null){
            sysUserService.updateById(sysUser);
            return  ResponseMessage.ok();
        }
        return  ResponseMessage.error();
    }


    @RequestMapping("delete")
   // @OperationLog(operationType= OperateType.DELETE,operationName="删除用户")
    @ResponseBody
    public ResponseMessage  delete(String id){

        if(id !=null){
            //删除该用户下拥有的角色

            sysUserService.removeById(id);

            return  ResponseMessage.ok();
        }
        return  ResponseMessage.error();
    }

  //  @OperationLog(operationType= OperateType.UPDATE,operationName="更改用户密码")
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


   // @OperationLog(operationType= OperateType.UPDATE,operationName="改变用户状态")
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
    public ResponseMessage list(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageUtils pageUtil = new PageUtils(params);

        //获取map参数
        CustomPage<SysUser> page = new CustomPage<>(pageUtil.getPage(),pageUtil.getLimit());

        List<SysUser> list= sysUserService.queryUserPage(page,null,1);

        page.setRecords(list);
        return ResponseMessage.ok().put("page", page);
    }


}
