package com.javatech.tdd.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * admin注册DTO
 * @author baiyu
 * @Desc
 * @date 2020/11/30
 */
@Data
public class UmsAdminDTO {
    @ApiModelProperty(value = "邮箱", required = true)
    @NotNull(message = "用户邮箱不能为空")
    @Email(regexp=".*@.*\\..*", message = "邮箱格式不正确")
    private String email;
    @ApiModelProperty(value = "用户名", required = true)
    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度必须是6-16个字符")
    private String password;
}
