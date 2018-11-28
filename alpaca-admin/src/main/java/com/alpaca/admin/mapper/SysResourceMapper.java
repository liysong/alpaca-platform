package com.alpaca.admin.mapper;

import com.alpaca.admin.domain.SysResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统资源表 Mapper 接口
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

    List<String> queryAllPermissionCodesByUserId(String userId);


    List<SysResource> queryAllSysResourceByUserId(String uerId);

    /**
     * 查询无按钮菜单
     * @return
     */
    List<SysResource> queryNotButtonList();

}
