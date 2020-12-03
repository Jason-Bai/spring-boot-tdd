package com.javatech.tdd.service;

import com.javatech.tdd.dto.ResponseBody;

/**
 * SSO服务
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
public interface SSOService {
    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    ResponseBody generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    ResponseBody verifyAuthCode(String telephone, String authCode);
}
