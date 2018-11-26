package com.alpaca.admin.service;

import com.alpaca.admin.domain.SysDicGroup;
import com.alpaca.admin.domain.SysToken;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
public interface ISysTokenService extends IService<SysToken> {

    SysToken queryByToken(String token);

    SysToken createToken(String id);
}
