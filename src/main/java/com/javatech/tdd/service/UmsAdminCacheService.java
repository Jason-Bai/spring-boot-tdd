package com.javatech.tdd.service;

import com.javatech.tdd.mbg.model.UmsAdmin;
import com.javatech.tdd.mbg.model.UmsPermission;

import java.util.List;

/**
 * 管理员缓存服务
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
public interface UmsAdminCacheService {
    /**
     * 通过username查看admin
     * @param username
     * @return
     */
    UmsAdmin getAdmin(String username);


    /**
     * 缓存admin
     * @param umsAdmin
     */
    void setAdmin(UmsAdmin umsAdmin);

    /**
     * 通过adminId获取权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Integer adminId);

    /**
     * 缓存permissionList
     * @param permissionList
     */
    void setPermissionList(Integer adminId, List<UmsPermission> permissionList);
}
