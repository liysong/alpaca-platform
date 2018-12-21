package com.alpaca.common.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: song
 * @Date: 2018/11/15 16:09
 * @Description:
 * @Version:1.0.0
 */
public class RoleVo implements Serializable {

    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编号,如admin
     */
    private String roleCode;

    /**
     * 角色类型
     */
    private Integer roleType;

    /**
     * 角色状态，是否可用，0:可用,1:不可用
     */
    private Integer status;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 逻辑删除，0: 不删除,1:删除状态
     */
    private Integer flag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    private List<String > resourceIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public List<String> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<String> resourceIds) {
        this.resourceIds = resourceIds;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "id=" + id +
                ", name=" + name +
                ", roleCode=" + roleCode +
                ", roleType=" + roleType +
                ", status=" + status +
                ", description=" + description +
                ", flag=" + flag +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
