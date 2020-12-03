package com.javatech.tdd.service.impl;

import com.javatech.tdd.mbg.model.UmsAdmin;
import com.javatech.tdd.mbg.model.UmsPermission;
import com.javatech.tdd.service.RedisService;
import com.javatech.tdd.service.UmsAdminCacheService;
import com.javatech.tdd.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private RedisService redisService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Integer REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.permissionList}")
    private String REDIS_KEY_PERMISSION_LIST;

    @Override
    public UmsAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin umsAdmin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + umsAdmin.getUsername();
        redisService.set(key, umsAdmin, REDIS_EXPIRE);
    }

    @Override
    public List<UmsPermission> getPermissionList(Integer adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_PERMISSION_LIST + ":" + adminId;
        return (List<UmsPermission>) redisService.get(key);
    }

    @Override
    public void setPermissionList(Integer adminId, List<UmsPermission> permissionList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_PERMISSION_LIST + ":" + adminId;
        redisService.set(key, permissionList, REDIS_EXPIRE);
    }
}
