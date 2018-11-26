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
@TableName("SYS_ORGANIZATION")
public class SysOrganization implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    /**
     * 机构单位信息描述
     */
    @TableField("DESCRIPTION")
    private String description;

    /**
     * 单位的layer
     */
    @TableField("ORG_LAYER")
    private String orgLayer;

    /**
     * 机构单位名称
     */
    @TableField("ORG_NAME")
    private String orgName;

    /**
     * 机构单位排序
     */
    @TableField("ORG_SORT")
    private Long orgSort;

    /**
     * 0:直管,1:代管
     */
    @TableField("ORG_OWNER")
    private Integer orgOwner;

    /**
     * 创建人
     */
    @TableField("CREATE_USER")
    private String createUser;

    /**
     * 父级机构单位id
     */
    @TableField("PARENT_ID")
    private String parentId;

    /**
     * 机构单位状态1:可用,0:不可用
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 机构单位层级1:顶级部门，2:子级部门
     */
    @TableField("ORG_LEVEL")
    private Integer orgLevel;

    /**
     * 机构单位编码
     */
    @TableField("ORG_CODE")
    private String orgCode;

    /**
     * 逻辑删除；1:可用，0:逻辑删除状态
     */
    @TableField("FLAG")
    private Integer flag;

    /**
     * 机构单位类型
     */
    @TableField("ORG_TYPE")
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
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
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
        return "SysOrganization{" +
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
