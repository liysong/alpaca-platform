package com.alpaca.common.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: song
 * @Date: 2018/11/15 16:10
 * @Description:
 * @Version:1.0.0
 */
public class OrganizationVo implements Serializable {

    private String id;

    /**
     * 机构单位信息描述
     */

    private String description;

    /**
     * 单位的layer
     */
    private String orgLayer;

    /**
     * 机构单位名称
     */

    private String orgName;

    /**
     * 机构单位排序
     */
    private Long orgSort;

    /**
     * 0:直管,1:代管
     */
    private Integer orgOwner;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 父级机构单位id
     */
    private String parentId;

    /**
     * 机构单位状态0:不可用,1:可用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 机构单位层级1:顶级部门，2:子级部门
     */
    private Integer orgLevel;

    /**
     * 机构单位编码
     */
    private String orgCode;

    /**
     * 逻辑删除；1:可用，0:逻辑删除状态
     */

    private Integer flag;

    /**
     * 机构单位类型
     */

    private String orgType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrgLayer() {
        return orgLayer;
    }

    public void setOrgLayer(String orgLayer) {
        this.orgLayer = orgLayer;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getOrgSort() {
        return orgSort;
    }

    public void setOrgSort(Long orgSort) {
        this.orgSort = orgSort;
    }

    public Integer getOrgOwner() {
        return orgOwner;
    }

    public void setOrgOwner(Integer orgOwner) {
        this.orgOwner = orgOwner;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    @Override
    public String toString() {
        return "OrganizationVo{" +
                "id=" + id +
                ", description=" + description +
                ", orgLayer=" + orgLayer +
                ", orgName=" + orgName +
                ", orgSort=" + orgSort +
                ", orgOwner=" + orgOwner +
                ", createUser=" + createUser +
                ", parentId=" + parentId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", orgLevel=" + orgLevel +
                ", orgCode=" + orgCode +
                ", flag=" + flag +
                ", orgType=" + orgType +
                "}";
    }

}
