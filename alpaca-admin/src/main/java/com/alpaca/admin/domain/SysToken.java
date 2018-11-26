package com.alpaca.admin.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: SysToken
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 18:55
 * @Version: 1.0.0
 */
@TableName("SYS_TOKEN")
public class SysToken implements Serializable {

    @TableField("ID")
    private String id;

    //用户ID
    @TableField("USER_ID")
    private String userId;
    //token
    @TableField("TOKEN")
    private String token;
    //过期时间
    @TableField("EXPIRE_TIME")
    private Date expireTime;
    //更新时间
    @TableField("UPDATE_TIME")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
