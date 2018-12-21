package com.alpaca.admin.controller;


import com.alpaca.admin.annotation.OperationLog;
import com.alpaca.admin.domain.SysConfigItem;
import com.alpaca.admin.service.ISysConfigItemService;
import com.alpaca.admin.utils.CustomPage;

import com.grace.commons.state.OperateType;
import com.grace.commons.system.ResponseMessage;
import com.grace.commons.util.IdGenerator;
import com.grace.page.util.PageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
@RequestMapping("/sys/config")
public class SysConfigItemController {


    @Autowired
    private ISysConfigItemService sysConfigItemService;

    @OperationLog(operationType= OperateType.SAVE,operationName="新增")
    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public ResponseMessage save(@RequestBody SysConfigItem sysConfigItem){

        sysConfigItem.setId(IdGenerator.getNextId());
        sysConfigItemService.save(sysConfigItem);

        return  ResponseMessage.ok();
    }

    @OperationLog(operationType= OperateType.UPDATE,operationName="更新")
    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public ResponseMessage update(@RequestBody SysConfigItem sysConfigItem){

        sysConfigItemService.updateById(sysConfigItem);

        return  ResponseMessage.ok();
    }

    @OperationLog(operationType= OperateType.LOGIC_DELETE,operationName="逻辑删除")
    @RequestMapping("logicDelete")
    public ResponseMessage logicDelete(String id){

      //  sysConfigItemService.logicDelete(id);

        return  ResponseMessage.ok();
    }

    @OperationLog(operationType= OperateType.QUERY,operationName="查询")
    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public ResponseMessage list(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageUtils pageUtil = new PageUtils(params);

        //获取map参数
        CustomPage<SysConfigItem> page = new CustomPage<>(pageUtil.getPage(),pageUtil.getLimit());

        String name = null;
        if(params.get("name") !=null){
            name   = params.get("name").toString();
        }

        List<SysConfigItem> list=  sysConfigItemService.queryConfigPage(page,name);

        page.setRecords(list);
        return ResponseMessage.ok().put("page", page);
    }

    /**
     * 通过id 获取参数
     * @param id
     * @return
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public ResponseMessage info(@PathVariable("id") String id){
        SysConfigItem config =  sysConfigItemService.getById(id);

        return ResponseMessage.ok().put("config", config);
    }

    /**
     * 删除参数配置
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    @OperationLog(operationType= OperateType.DELETE,operationName="删除参数")
    public ResponseMessage delete(@PathVariable("id") String id){
       sysConfigItemService.removeById(id);
        return ResponseMessage.ok();
    }

}
