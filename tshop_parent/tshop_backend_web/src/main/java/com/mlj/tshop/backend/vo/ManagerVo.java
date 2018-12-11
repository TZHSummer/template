package com.mlj.tshop.backend.vo;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 2018/12/10：管理员Value Object
 *
 * @author mlj
 */
public class ManagerVo {

    @NotNull(message = "用户名不能为空！")
    @NotEmpty(message = "用户名不能为空！")
    @NotBlank(message = "用户名不能为空！")
    @Size(min = 6, max = 20, message = "用户名长度应介于6-20个字符之间")
    private String username;
    @NotNull(message = "密码不能为空！")
    @NotEmpty(message = "密码不能为空！")
    @NotBlank(message = "密码不能为空！")
    @Size(min = 6, max = 16, message = "密码长度应介于6-20个字符之间")
    private String password;
    @NotNull(message = "重复密码不能为空！")
    @NotEmpty(message = "重复密码不能为空！")
    @NotBlank(message = "重复密码不能为空！")
    @Size(min = 6, max = 16, message = "重复密码长度应介于6-20个字符之间")
    private String repassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    @Override
    public String toString() {
        return "ManagerVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                '}';
    }
}
