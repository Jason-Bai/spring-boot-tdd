package com.javatech.tdd.controller;

import com.javatech.tdd.dto.PageBody;
import com.javatech.tdd.dto.ResponseBody;
import com.javatech.tdd.dto.UmsAdminDTO;
import com.javatech.tdd.mbg.model.UmsAdmin;
import com.javatech.tdd.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
@Api(tags="管理员管理")
@RestController
@RequestMapping("/ums/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("管理员列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ums:admin:read')")
    public List<UmsAdmin> list() {
        return umsAdminService.listAll();
    }

    @ApiOperation("管理员用户")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ums:admin:create')")
    public ResponseBody<UmsAdmin> add(@Valid @RequestBody UmsAdminDTO umsAdminDTO) {
        UmsAdmin umsUser = umsAdminService.create(umsAdminDTO);

        ResponseBody<UmsAdmin> created = ResponseBody.created(umsUser);

        return created;
    }

    @ApiOperation("管理员列表（分页）")
    @GetMapping("/pages")
    @PreAuthorize("hasAuthority('ums:admin:read')")
    public PageBody<UmsAdmin> listByPage(@RequestParam(value = "pageNum", defaultValue = "1")
                                         @ApiParam("页码") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10")
                                         @ApiParam("每页数量") int pageSize) {
        List<UmsAdmin> umsUsers = umsAdminService.listByPage(pageNum, pageSize);

        PageBody<UmsAdmin> pageBody = PageBody.getPageBody(umsUsers);

        return pageBody;
    }


    @ApiOperation("管理员详情")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ums:admin:read')")
    public UmsAdmin detail(@PathVariable("id") Integer id) {
        return umsAdminService.findOne(id);
    }

    @ApiOperation("管理员用户")
    @PatchMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ums:admin:update')")
    public UmsAdmin modify(@PathVariable("id") Integer id, @RequestBody UmsAdmin umsUser) {
        UmsAdmin updatedUmsUser = umsAdminService.update(id, umsUser);
        return updatedUmsUser;
    }

    @ApiOperation("管理员用户")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ums:admin:delete')")
    public int delete(@PathVariable("id") Integer id) {
        return umsAdminService.delete(id);
    }
}
