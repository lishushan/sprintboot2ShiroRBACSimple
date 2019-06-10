package com.jungle.springboot.security.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 *SystemUser。
 * @author jungle
 * @version 1.0
 * @Description system_user表的实体类,SystemUser。
 * 2019-05-28 16:16:56
 */
public class SystemUser implements Serializable {
    /**
     * 主键id。
    * <p> column ==>id</p>
     */
    private Long id;

    /**
     * 使能状态：1-启用；0-禁用；。
    * <p> column ==>enabled</p>
     */
    private Integer enabled;

    /**
     * 用户名。
    * <p> column ==>username</p>
     */
    private String username;

    /**
     * 密文密码。
    * <p> column ==>password</p>
     */
    private String password;

    /**
     * 用户组id。
    * <p> column ==>group_id</p>
     */
    private Long groupId;

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
     * system_user。
    * <p> table ==>SystemUser</p>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 主键id。
     * @return {@link #id}
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id。
     * @param id 主键id {@link #id}
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 使能状态：1-启用；0-禁用；。
     * @return {@link #enabled}
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * 设置 使能状态：1-启用；0-禁用；。
     * @param enabled 使能状态：1-启用；0-禁用； {@link #enabled}
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取 用户名。
     * @return {@link #username}
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名。
     * @param username 用户名 {@link #username}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取 密文密码。
     * @return {@link #password}
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 密文密码。
     * @param password 密文密码 {@link #password}
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取 用户组id。
     * @return {@link #groupId}
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置 用户组id。
     * @param groupId 用户组id {@link #groupId}
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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