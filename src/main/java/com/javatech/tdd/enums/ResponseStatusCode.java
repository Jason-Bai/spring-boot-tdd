package com.javatech.tdd.enums;

import lombok.Getter;

/**
 * 返回状态码
 * @author baiyu
 */
@Getter
public enum ResponseStatusCode {
    SUCCESS("2000", "请求成功"),
    CREATED("2001", "创建成功"),
    FAILED("4000", "请求失败"),
    UNAUTHORIZED("4001", "未授权"),
    FORIBIDDEN("4003", "禁止访问"),
    NOT_FOUND("4004", "不存在"),
    INVALID_ARGUMENTS("4009", "参数校验失败"),
    ERROR("5000", "未知错误");

    private final String code;
    private final String message;

    ResponseStatusCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
