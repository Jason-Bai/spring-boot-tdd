package com.javatech.tdd.service;

import com.javatech.tdd.dto.UmsAdminDTO;
import com.javatech.tdd.mbg.model.UmsAdmin;
import com.javatech.tdd.mbg.model.UmsPermission;

import java.util.List;

/**
 * 管理员服务
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
public interface UmsAdminService {
    /**
     * admin列表
     * @return
     */
    List<UmsAdmin> listAll();

    /**
     * admin列表（分页）
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UmsAdmin> listByPage(int pageNum, int pageSize);

    /**
     * 创建admin
      * @param umsUser
     * @return
     */
    UmsAdmin create(UmsAdminDTO umsUser);


    /**
     * 更新admin
     * @param id
     * @param umsUser
     * @return
     */
    UmsAdmin update(Integer id, UmsAdmin umsUser);


    /**
     * 删除admin
     * @param id
     * @return
     */
    int delete(Integer id);


    /**
     * admin详情（用户ID）
     * @param id
     * @return
     */
    UmsAdmin findOne(Integer id);

    /**
     * 通过username获取admin
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 通过adminId获取permission
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionAllByAdminId(Integer adminId);
}
