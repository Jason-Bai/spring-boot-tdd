package com.javatech.tdd.controller;

import com.javatech.tdd.dto.ResponseBody;
import com.javatech.tdd.service.SSOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author baiyu
 * @Desc
 * @date 2020/12/2
 */
@Api(tags = "SSO管理")
@RestController
@RequestMapping("/sso")
public class SSOController {

    @Autowired
    private SSOService memberService;

    @ApiOperation("获取验证码")
    @GetMapping("/authCode")
    public ResponseBody getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @GetMapping("/verifyAuthCode")
    public ResponseBody updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }
}
