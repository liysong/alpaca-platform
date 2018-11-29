package com.alpaca.admin.controller;


import com.alpaca.admin.annotation.OperationLog;
import com.alpaca.admin.domain.SysOperationLog;
import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.service.ISysOperationLogService;
import com.alpaca.admin.utils.CustomPage;
import com.alpaca.common.page.PageUtils;
import com.alpaca.common.state.OperateType;
import com.alpaca.common.system.ResponseMessage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/sys/log")
public class SysOperationLogController {

    @Autowired
    private ISysOperationLogService sysOperationLogService;

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:log:list")
    public ResponseMessage list(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageUtils pageUtil = new PageUtils(params);

        //获取map参数
        CustomPage<SysOperationLog> page = new CustomPage<>(pageUtil.getPage(),pageUtil.getLimit());

        String name = null;
        if(params.get("name") !=null){
            name = params.get("name").toString();
        }
        List<SysOperationLog> list= sysOperationLogService.queryPage(page,name);

        page.setRecords(list);
        return ResponseMessage.ok().put("page", page);
    }


}
