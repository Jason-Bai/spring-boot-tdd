package com.javatech.tdd.dto;

import com.javatech.tdd.mbg.model.UmsPermission;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 暂时没用
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationDTO {
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "注册时间")
    private Date createTime;
    @ApiModelProperty(value = "0->禁用；1->启用")
    private Boolean status;
    @ApiModelProperty(value = "权限列表")
    private List<UmsPermission> permissionList;
}
