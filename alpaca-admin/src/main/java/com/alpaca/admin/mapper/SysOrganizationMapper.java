package com.alpaca.admin.mapper;

import com.alpaca.admin.domain.SysOrganization;
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
public interface SysOrganizationMapper extends BaseMapper<SysOrganization> {

    List<String> queryOrgIdList(String id);

    List<SysOrganization> queryPage(CustomPage<SysOrganization> page, @Param("orgName") String  orgName, @Param("orgCode")String orgCode);

    List<SysOrganization> queryList(@Param("orgName") String  orgName, @Param("orgCode")String orgCode ,@Param("id")String id);
}
