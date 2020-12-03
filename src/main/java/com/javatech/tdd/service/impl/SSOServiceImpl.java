package com.javatech.tdd.service.impl;

import com.javatech.tdd.annotation.CacheException;
import com.javatech.tdd.dto.ResponseBody;
import com.javatech.tdd.service.RedisService;
import com.javatech.tdd.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author baiyu
 * @Desc
 * @date 2020/12/2
 */
@Service
public class SSOServiceImpl implements SSOService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @CacheException
    @Override
    public ResponseBody generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }

        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);

        return ResponseBody.success(sb.toString());
    }

    @CacheException
    @Override
    public ResponseBody verifyAuthCode(String telephone, String authCode) {
        if (authCode == null || authCode.isEmpty()) {
            return ResponseBody.failed("请输入验证码");
        }

        String realAuthCode = (String) redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);

        boolean result = authCode.equals(realAuthCode);

        if (result) {
            return ResponseBody.success("验证码校验成功");
        }

        return ResponseBody.failed("验证码不正确");
    }
}
