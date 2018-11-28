package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysOrganization;
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
public interface ISysOrganizationService extends IService<SysOrganization> {

    List<String> queryOrgIdList(String id);

    List<SysOrganization> queryPage(CustomPage<SysOrganization> page,String  name,String orgCode);

    List<SysOrganization> queryList(String  name,String orgCode,String id);

    /**
     * 通过组织机构id，构造树形结构
     * @param id
     * @return
     */
    List<SysOrganization> queryOrganizationList(String id);

}
