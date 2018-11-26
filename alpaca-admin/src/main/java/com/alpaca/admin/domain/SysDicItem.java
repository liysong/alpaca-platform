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
@TableName("SYS_DIC_ITEM")
public class SysDicItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 字典组code
     */
    @TableField("GROUP_CODE")
    private String groupCode;

    /**
     * 父级id
     */
    @TableField("PARENT_ID")
    private String parentId;

    /**
     * 字典名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 字典值
     */
    @TableField("VALUE")
    private String value;

    /**
     * 字典logo
     */
    @TableField("LOGO")
    private String logo;

    /**
     * 颜色
     */
    @TableField("COLOUR")
    private String colour;

    /**
     * 字典描述
     */
    @TableField("DESCRIPTION")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SysDicItem{" +
        "id=" + id +
        ", updateTime=" + updateTime +
        ", groupCode=" + groupCode +
        ", parentId=" + parentId +
        ", name=" + name +
        ", value=" + value +
        ", logo=" + logo +
        ", colour=" + colour +
        ", description=" + description +
        "}";
    }
}
