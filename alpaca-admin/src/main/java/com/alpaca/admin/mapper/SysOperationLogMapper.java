package com.alpaca.admin.mapper;

import com.alpaca.admin.domain.SysOperationLog;
import com.alpaca.admin.utils.CustomPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
public interface SysOperationLogMapper extends BaseMapper<SysOperationLog> {

    List<SysOperationLog> queryPage(CustomPage<SysOperationLog> page, @Param("name") String name);
}
