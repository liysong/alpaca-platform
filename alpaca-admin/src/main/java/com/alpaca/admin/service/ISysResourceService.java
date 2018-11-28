package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统资源表 服务类
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
public interface ISysResourceService extends IService<SysResource> {

    /**
     * 查询
     */
    List<String> queryAllPerpermissionCodesByUserId(String userId);


    List<SysResource> queryAllSysResourceByUserId(String uerId);

    /**
     * 查询无按钮菜单，构建在创建资源
     * @return
     */
    List<SysResource> queryNotButtonList();

}
