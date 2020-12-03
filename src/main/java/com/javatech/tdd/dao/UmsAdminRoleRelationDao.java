package com.javatech.tdd.dao;

import com.javatech.tdd.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员角色权限扩充
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 通过adminId获取所有权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Integer adminId);
}
