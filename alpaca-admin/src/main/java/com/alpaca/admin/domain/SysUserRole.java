package com.alpaca.admin.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户-角色
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@TableName("SYS_USER_ROLE")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableField("USER_ID")
    private String userId;

    /**
     * 角色编号
     */
    @TableField("ROLE_ID")
    private String roleId;

    @TableField("ID")
    private String id;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
        "userId=" + userId +
        ", roleId=" + roleId +
        ", id=" + id +
        "}";
    }


    public SysUserRole(String id, String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
        this.id = id;
    }

    public SysUserRole() {

    }
}
