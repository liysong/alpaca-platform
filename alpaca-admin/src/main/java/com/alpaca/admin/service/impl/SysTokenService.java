package com.alpaca.admin.service.impl;


import com.alpaca.admin.domain.SysToken;
import com.alpaca.admin.mapper.SysTokenMapper;
import com.alpaca.admin.oauth2.TokenGenerator;
import com.alpaca.admin.service.ISysTokenService;
import com.grace.commons.util.IdGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@Service
public class SysTokenService extends ServiceImpl<SysTokenMapper, SysToken> implements ISysTokenService {

    private final static int EXPIRE = 3600 * 12;

    @Override
    public SysToken queryByToken(String token) {
        return baseMapper.selectOne(new QueryWrapper<SysToken>().eq("token",token));
    }

    @Override
    public SysToken createToken(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        SysToken tokenEntity = baseMapper.queryTokenByUserId(userId);
        if(tokenEntity == null){
            tokenEntity = new SysToken();
            tokenEntity.setId(IdGenerator.getNextId());
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            baseMapper.insert(tokenEntity);
        }else{
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            baseMapper.updateById(tokenEntity);

        }
        return tokenEntity;
    }
}
