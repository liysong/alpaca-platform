package com.alpaca.admin.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author song
 * @since 2018-11-04
 */
@TableName("SYS_USER")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    /**
     * 登录名，也叫账户名称
     */
    @TableField("LOGIN_NAME")
    private String loginName;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 用户名
     */
    @TableField("NAME")
    private String name;

    /**
     * 性别，0:女，1:男
     */
    @TableField("SEX")
    private Integer sex;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 创建者的id
     */
    @TableField("CREATE_USER")
    private String createUser;

    /**
     * 手机号码或者电话号码
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 账户类型
     */
    @TableField("USER_TYPE")
    private String userType;

    /**
     * 账户描述
     */
    @TableField("DESCRIPTION")
    private String description;

    /**
     * 逻辑删除；0:逻辑删除状态不可用，1:可用正常数据状态
     */
    @TableField("FLAG")
    private Integer flag;

    /**
     * 盐，用于加密密码
     */
    @TableField("SALT")
    private String salt;

    /**
     * 状态0:不可用,1:可用
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 机构id
     */
    @TableField("ORG_ID")
    private String orgId;

    /**
     * 机构的路径，根据需要是否来填写
     */
    @TableField("ORG_PATH")
    private String orgPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "id=" + id +
        ", loginName=" + loginName +
        ", password=" + password +
        ", name=" + name +
        ", sex=" + sex +
        ", email=" + email +
        ", createUser=" + createUser +
        ", mobile=" + mobile +
        ", userType=" + userType +
        ", description=" + description +
        ", flag=" + flag +
        ", salt=" + salt +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", orgId=" + orgId +
        ", orgPath=" + orgPath +
        "}";
    }
}
