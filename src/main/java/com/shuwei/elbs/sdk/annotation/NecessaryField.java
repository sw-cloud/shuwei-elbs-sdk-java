package com.shuwei.elbs.sdk.annotation;

import java.lang.annotation.*;

/**
 * 该注解用来标识请求参数是否是必传参数
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface NecessaryField {
}
