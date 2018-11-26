package com.alpaca.admin.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@TableName("SYS_LOGIN")
public class SysLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableField("USER_ID")
    private String userId;

    @TableField("LOGIN_NUM")
    private Integer loginNum;

    @TableField("LOGIN_TIME")
    private LocalDateTime loginTime;

    @TableField("IS_LOCK")
    private String isLock;

    @TableField("LOGIN_EXIT_TIME")
    private LocalDateTime loginExitTime;

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
    public Integer getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }
    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }
    public LocalDateTime getLoginExitTime() {
        return loginExitTime;
    }

    public void setLoginExitTime(LocalDateTime loginExitTime) {
        this.loginExitTime = loginExitTime;
    }

    @Override
    public String toString() {
        return "SysLogin{" +
        "id=" + id +
        ", userId=" + userId +
        ", loginNum=" + loginNum +
        ", loginTime=" + loginTime +
        ", isLock=" + isLock +
        ", loginExitTime=" + loginExitTime +
        "}";
    }
}
