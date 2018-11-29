package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysConfigItem;
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
public interface ISysConfigItemService extends IService<SysConfigItem> {

    List<SysConfigItem>  queryConfigPage(CustomPage<SysConfigItem> page, String name);

    /**
     * 通过code 编码查询一个参数配置
     * @param code
     * @return
     */
    SysConfigItem queryConfigByCode(String code);

    /**
     * 通过 groupCode 来查询一组参数配置
     * @param groupCode
     * @return
     */
    List<SysConfigItem>   queryConfigByGroup(String  groupCode);
}
