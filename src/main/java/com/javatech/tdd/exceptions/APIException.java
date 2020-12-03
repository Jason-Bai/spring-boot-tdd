package com.javatech.tdd.exceptions;

import com.javatech.tdd.enums.ResponseStatusCode;
import lombok.Getter;

/**
 * 统一API Exception
 * @author baiyu
 * @Desc
 * @date 2020/11/30
 */
@Getter
public class APIException extends RuntimeException {
    private String code;
    private String message;

    public APIException(String message) {
        this.code = "2000";
        this.message = message;
    }

    public APIException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public APIException(ResponseStatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }
}
