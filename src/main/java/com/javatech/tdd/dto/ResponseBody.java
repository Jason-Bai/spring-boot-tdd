package com.javatech.tdd.dto;

import com.javatech.tdd.enums.ResponseStatusCode;
import lombok.Getter;

/**
 * 统一Response Body
 *
 * @author baiyu
 * @Desc
 * @date 2020/11/30
 */
@Getter
public class ResponseBody<T> {
    /**
     * 状态码
     */
    private final String code;

    /**
     * 响应信息
     */
    private final String message;

    /**
     * 响应数据
     */
    private final T data;

    public ResponseBody(String code, String message) {
        this(code, message, null);
    }

    public ResponseBody(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseBody(T data) {
        this(ResponseStatusCode.SUCCESS, data);
    }

    public ResponseBody(ResponseStatusCode responseStatusCode, T data) {
        this.code = responseStatusCode.getCode();
        this.message = responseStatusCode.getMessage();
        this.data = data;
    }

    /**
     * 请求成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> success(T data) {
        ResponseBody<T> responseBody = new ResponseBody<T>(ResponseStatusCode.SUCCESS, data);
        return responseBody;
    }

    /**
     * 创建成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> created(T data) {
        ResponseBody<T> responseBody = new ResponseBody<T>(ResponseStatusCode.CREATED, data);
        return responseBody;
    }

    /**
     * 请求失败
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> failed(T data) {
        ResponseBody<T> responseBody = new ResponseBody<T>(ResponseStatusCode.CREATED, data);
        return responseBody;
    }

    public static <T> ResponseBody<T> unauthorized(T data) {
        ResponseBody<T> responseBody = new ResponseBody<T>(ResponseStatusCode.UNAUTHORIZED, data);
        return responseBody;
    }

    public static <T> ResponseBody<T> forbidden(T data) {
        ResponseBody<T> responseBody = new ResponseBody<T>(ResponseStatusCode.UNAUTHORIZED, data);
        return responseBody;
    }

    /**
     * 无效的参数
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> invalidArguments(T data) {
        ResponseBody<T> responseBody = new ResponseBody<T>(ResponseStatusCode.INVALID_ARGUMENTS, data);
        return responseBody;
    }

    /**
     * 未找到
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> notFound(T data) {
        ResponseBody<T> responseBody = new ResponseBody<T>(ResponseStatusCode.CREATED, data);
        return responseBody;
    }

    /**
     * 内部错误
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> error(T data) {
        ResponseBody<T> responseBody = new ResponseBody<T>(ResponseStatusCode.CREATED, data);
        return responseBody;
    }
}
