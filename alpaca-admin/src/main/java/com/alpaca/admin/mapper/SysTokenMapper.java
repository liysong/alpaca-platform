package com.alpaca.admin.mapper;

import com.alpaca.admin.domain.SysToken;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @ClassName: SysTokenMapper
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 18:59
 * @Version: 1.0.0
 */
public interface SysTokenMapper extends BaseMapper<SysToken> {

    SysToken queryTokenByUserId(String userId);
}
