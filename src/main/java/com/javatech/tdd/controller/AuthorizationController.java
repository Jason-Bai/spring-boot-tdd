package com.javatech.tdd.controller;

import com.javatech.tdd.dto.ResponseBody;
import com.javatech.tdd.dto.UmsAdminDTO;
import com.javatech.tdd.dto.UmsAdminLoginDTO;
import com.javatech.tdd.mbg.model.UmsAdmin;
import com.javatech.tdd.service.AuthorizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author baiyu
 * @Desc
 * @date 2020/11/30
 */
@Api(tags = "授权管理")
@RestController
@RequestMapping("/auth")
public class AuthorizationController {
    @Autowired
    private AuthorizationService authorizationService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResponseBody<UmsAdmin> register(@Valid @RequestBody UmsAdminDTO umsAdminDTO) {
        UmsAdmin umsAdmin = authorizationService.register(umsAdminDTO);
        return ResponseBody.created(umsAdmin);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResponseBody login(@Valid @RequestBody UmsAdminLoginDTO umsAdminLoginDTO) {
        String token =  authorizationService.login(umsAdminLoginDTO.getUsername(), umsAdminLoginDTO.getPassword());
        if (token == null) {
            return ResponseBody.invalidArguments("用户名或密码错误");
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);

        return ResponseBody.success(tokenMap);
    }
}
