package com.alpaca.admin.service.impl;

import com.alpaca.admin.domain.SysOperationLog;
import com.alpaca.admin.mapper.SysOperationLogMapper;
import com.alpaca.admin.service.ISysOperationLogService;
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
public class SysOperationLogService extends ServiceImpl<SysOperationLogMapper, SysOperationLog> implements ISysOperationLogService {

    @Override
    public List<SysOperationLog> queryPage(CustomPage<SysOperationLog> page, String name) {
        return baseMapper.queryPage(page,name);
    }
}
