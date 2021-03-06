package com.alpaca.admin.service.impl;

import com.alpaca.admin.domain.SysConfigItem;
import com.alpaca.admin.mapper.SysConfigItemMapper;
import com.alpaca.admin.service.ISysConfigItemService;
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
public class SysConfigItemService extends ServiceImpl<SysConfigItemMapper, SysConfigItem> implements ISysConfigItemService {

    @Override
    public List<SysConfigItem> queryConfigPage(CustomPage<SysConfigItem> page, String name) {
        return baseMapper.queryConfigPage(page,name);
    }

    @Override
    public SysConfigItem queryConfigByCode(String code) {
        return baseMapper.queryConfigByCode(code);
    }

    @Override
    public List<SysConfigItem> queryConfigByGroup(String groupCode) {
        return baseMapper.queryConfigByGroup(groupCode);
    }
}
