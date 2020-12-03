package com.javatech.tdd.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.javatech.tdd.dao.UmsAdminDao;
import com.javatech.tdd.dao.UmsAdminRoleRelationDao;
import com.javatech.tdd.dto.UmsAdminDTO;
import com.javatech.tdd.mbg.mapper.UmsAdminMapper;
import com.javatech.tdd.mbg.model.UmsAdmin;
import com.javatech.tdd.mbg.model.UmsAdminExample;
import com.javatech.tdd.mbg.model.UmsPermission;
import com.javatech.tdd.service.UmsAdminCacheService;
import com.javatech.tdd.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author baiyu
 * @Desc
 * @date 2020/11/30
 */
@Service
@Slf4j
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private UmsAdminDao umsAdminDao;

    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    @Autowired
    private UmsAdminCacheService umsAdminCacheService;

    @Override
    public List<UmsAdmin> listAll() {
        return umsAdminMapper.selectByExample(new UmsAdminExample());
    }

    @Override
    public List<UmsAdmin> listByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return umsAdminMapper.selectByExample(new UmsAdminExample());
    }

    @Override
    public UmsAdmin create(UmsAdminDTO umsAdminDTO) {
        UmsAdmin umsAdmin = new UmsAdmin();

        umsAdminMapper.insert(umsAdmin);

        return umsAdmin;
    }

    @Override
    public UmsAdmin update(Integer id, UmsAdmin umsAdmin) {
        umsAdmin.setId(id);
        umsAdminMapper.updateByPrimaryKey(umsAdmin);
        return umsAdmin;
    }

    @Override
    public int delete(Integer id) {
        int updatedRows = umsAdminMapper.deleteByPrimaryKey(id);
        return updatedRows;
    }

    @Override
    public UmsAdmin findOne(Integer id) {
        UmsAdmin umsAdmin = umsAdminMapper.selectByPrimaryKey(id);
        return umsAdmin;
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin umsAdmin = umsAdminCacheService.getAdmin(username);

        if (umsAdmin != null) {
            return umsAdmin;
        }

        umsAdmin = umsAdminDao.selectByUsername(username);

        umsAdminCacheService.setAdmin(umsAdmin);

        return umsAdmin;
    }

    @Override
    public List<UmsPermission> getPermissionAllByAdminId(Integer adminId) {
        List<UmsPermission> permissionList = umsAdminCacheService.getPermissionList(adminId);

        if (CollUtil.isNotEmpty(permissionList)) {
            return permissionList;
        }

        permissionList = umsAdminRoleRelationDao.getPermissionList(adminId);

        umsAdminCacheService.setPermissionList(adminId, permissionList);

        return permissionList;
    }
}