package com.alpaca.admin.service.impl;

import com.alpaca.admin.domain.SysOrganization;
import com.alpaca.admin.mapper.SysOrganizationMapper;
import com.alpaca.admin.service.ISysOrganizationService;
import com.alpaca.admin.utils.CustomPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@Service
public class SysOrganizationService extends ServiceImpl<SysOrganizationMapper, SysOrganization> implements ISysOrganizationService {

    @Override
    public List<String> queryOrgIdList(String id) {
        return baseMapper.queryOrgIdList(id);
    }

    @Override
    public List<SysOrganization> queryPage(CustomPage<SysOrganization> page, String name, String orgCode) {
        return baseMapper.queryPage(page,name,orgCode);
    }

    @Override
    public  List<SysOrganization> queryList(String name, String orgCode, String id) {
        return baseMapper.queryList(name,orgCode,id);
    }

    @Override
    public List<SysOrganization> queryOrganizationList(String id) {
        return baseMapper.queryOrganizationList(id);
    }
}
