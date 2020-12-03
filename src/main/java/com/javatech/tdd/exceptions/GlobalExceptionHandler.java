package com.javatech.tdd.exceptions;

import com.javatech.tdd.dto.ResponseBody;
import com.javatech.tdd.enums.ResponseStatusCode;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author baiyu
 * @Desc
 * @date 2020/11/30
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseBody<String> MethodArgumentNotValidExceptionHanlder(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResponseBody<>(ResponseStatusCode.INVALID_ARGUMENTS, objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResponseBody<String> APIExceptionHandler(APIException e) {
        return new ResponseBody<>(e.getCode(), e.getMessage());
    }
}
