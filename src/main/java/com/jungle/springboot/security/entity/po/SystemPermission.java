package com.jungle.springboot.security.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 *SystemPermission。
 * @author jungle
 * @version 1.0
 * @Description system_permission表的实体类,SystemPermission。
 * 2019-05-28 16:04:05
 */
public class SystemPermission implements Serializable {
    /**
     * 主键id，无实际业务意义。
    * <p> column ==>id</p>
     */
    private Long id;

    /**
     * 权限名称。
    * <p> column ==>name</p>
     */
    private String name;

    /**
     * 权限代码。
    * <p> column ==>code</p>
     */
    private String code;

    /**
     * 创建时间。
    * <p> column ==>create_time</p>
     */
    private Date createTime;

    /**
     * 更新时间。
    * <p> column ==>update_time</p>
     */
    private Date updateTime;

    /**
     * system_permission。
    * <p> table ==>SystemPermission</p>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 主键id，无实际业务意义。
     * @return {@link #id}
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id，无实际业务意义。
     * @param id 主键id，无实际业务意义 {@link #id}
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 权限名称。
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 权限名称。
     * @param name 权限名称 {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 权限代码。
     * @return {@link #code}
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置 权限代码。
     * @param code 权限代码 {@link #code}
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取 创建时间。
     * @return {@link #createTime}
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间。
     * @param createTime 创建时间 {@link #createTime}
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 更新时间。
     * @return {@link #updateTime}
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间。
     * @param updateTime 更新时间 {@link #updateTime}
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}