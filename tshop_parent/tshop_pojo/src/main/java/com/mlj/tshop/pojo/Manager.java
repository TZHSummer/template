package com.mlj.tshop.pojo;

import java.io.Serializable;

/**
 * 2018/12/05：管理员
 *
 * @author mlj
 */
public class Manager implements Serializable {
    /**
     * 管理员id：6位整数
     */
    private Integer id;
    /**
     * 管理员名称：20位以内字符
     */
    private String name;
    /**
     * 管理员密码：16位以内字符
     */
    private String password;
    /**
     * 管理员状态：1表示可用，0表示禁用
     */
    private Integer enable;
    /**
     * 管理员等级：1表示系统管理员，2表示普通管理员
     */
    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                ", level=" + level +
                '}';
    }
}
