package com.javatech.tdd.dao;

import com.javatech.tdd.mbg.model.UmsAdmin;

/**
 * 管理员dao的扩充
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
public interface UmsAdminDao {

    /**
     * 通过用户名查看umsadmin
     * @param username
     * @return
     */
    UmsAdmin selectByUsername(String username);
}
