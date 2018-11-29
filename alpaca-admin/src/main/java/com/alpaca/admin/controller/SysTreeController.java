package com.alpaca.admin.controller;


import com.alpaca.admin.annotation.OperationLog;
import com.alpaca.admin.domain.SysTree;
import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.service.ISysTreeService;
import com.alpaca.common.state.OperateType;
import com.alpaca.common.system.ResponseMessage;
import com.alpaca.common.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author song
 * @since 2018-11-29
 */
@RestController
@RequestMapping("/sys/tree")
public class SysTreeController {

    @Autowired
    private ISysTreeService sysTreeService;

    @RequestMapping("/save")
    @OperationLog(operationType= OperateType.SAVE,operationName="新增用户")
    public ResponseMessage add(@RequestBody SysTree  sysTree) {
        sysTree.setId(IdGenerator.getNextId());
        sysTree.setCreateTime(new Date());
        sysTreeService.save(sysTree);
        return  ResponseMessage.ok();
    }

    @RequestMapping("/update")
    @OperationLog(operationType= OperateType.SAVE,operationName="新增用户")
    public ResponseMessage update(@RequestBody SysTree  sysTree) {
        sysTree.setId(IdGenerator.getNextId());
        sysTree.setCreateTime(new Date());
        sysTreeService.updateById(sysTree);
        return  ResponseMessage.ok();
    }

    @RequestMapping("/delete")
    @OperationLog(operationType= OperateType.DELETE,operationName="新增用户")
    public ResponseMessage delete(@RequestBody String   id) {

        sysTreeService.removeById(id);
        return  ResponseMessage.ok();
    }


}
