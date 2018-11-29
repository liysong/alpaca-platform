package com.alpaca.admin.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author song
 * @since 2018-11-29
 */
@TableName("SYS_TREE")
public class SysTree implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableField("NAME")
    private String name;

    @TableField("PARENT_ID")
    private String parentId;

    @TableField("CREATE_TIME")
    private Date createTime;

    @TableField("TYPE")
    private Integer type;

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
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SysTree{" +
        "id=" + id +
        ", name=" + name +
        ", parentId=" + parentId +
        ", createTime=" + createTime +
        ", type=" + type +
        "}";
    }
}
