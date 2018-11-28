package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysRole;
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
public interface ISysRoleService extends IService<SysRole> {

    public boolean  saveSysRole(SysRole sysRole);


    public boolean  updateSysRole(SysRole sysRole);

    public List<SysRole> queryPage(CustomPage<SysRole> page, String name);

}
