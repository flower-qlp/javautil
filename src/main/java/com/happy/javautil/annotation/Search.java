package com.happy.javautil.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author happy
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Search {
    String columnName() default "";

    String compare() default "=";

    String preStr() default "";

    String afterStr() default "";

    String getParamMethod() default "getParams";

    String paramKey() default "keyLikeStr";

    String tableName() default "";
}
