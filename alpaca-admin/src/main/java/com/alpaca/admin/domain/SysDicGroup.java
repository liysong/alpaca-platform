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
@TableName("SYS_DIC_GROUP")
public class SysDicGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 分类树id
     */
    @TableField("TREE_ID")
    private String treeId;

    /**
     * 字典组名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 字典组编码
     */
    @TableField("CODE")
    private String code;

    /**
     * 是否只读，0:不是可编辑 1:只读
     */
    @TableField("IS_READER")
    private Integer isReader;

    /**
     * 字典组信息描述
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
    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Integer getIsReader() {
        return isReader;
    }

    public void setIsReader(Integer isReader) {
        this.isReader = isReader;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SysDicGroup{" +
        "id=" + id +
        ", updateTime=" + updateTime +
        ", treeId=" + treeId +
        ", name=" + name +
        ", code=" + code +
        ", isReader=" + isReader +
        ", description=" + description +
        "}";
    }
}
