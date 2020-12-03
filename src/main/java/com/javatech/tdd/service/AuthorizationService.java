package com.javatech.tdd.service;

import com.javatech.tdd.dto.UmsAdminDTO;
import com.javatech.tdd.mbg.model.UmsAdmin;

/**
 * 授权服务
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
public interface AuthorizationService {
    /**
     * 用户注册
     * @param umsAdminDTO
     * @return
     */
    UmsAdmin register(UmsAdminDTO umsAdminDTO);

    /**
     * 用户名和密码生成token
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);
}
