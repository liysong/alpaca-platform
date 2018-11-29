package com.alpaca.admin.mapper;

import com.alpaca.admin.domain.SysConfigItem;
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
public interface SysConfigItemMapper extends BaseMapper<SysConfigItem> {

    List<SysConfigItem> queryConfigPage(CustomPage<SysConfigItem> page, @Param("name") String name);

    SysConfigItem queryConfigByCode(String code);

    List<SysConfigItem>   queryConfigByGroup(String  groupCode);
}
