package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysOperationLog;
import com.alpaca.admin.utils.CustomPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
public interface ISysOperationLogService extends IService<SysOperationLog> {

    List<SysOperationLog> queryPage(CustomPage<SysOperationLog> page,String name);
}
