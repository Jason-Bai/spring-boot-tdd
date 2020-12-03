package com.javatech.tdd.annotation;

import java.lang.annotation.*;

/**
 * 标注某些带有缓存功能的方法，如果出现异常需要对外抛出异常，而不是记录错误
 * @author baiyu
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
