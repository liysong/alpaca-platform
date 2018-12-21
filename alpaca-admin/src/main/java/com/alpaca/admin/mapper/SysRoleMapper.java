package com.alpaca.admin.mapper;

import com.alpaca.admin.domain.SysRole;
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
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> queryPage(CustomPage<SysRole> page,@Param("name") String name);

    List<SysRole> queryUserRole(@Param("userId")String userId);

}
