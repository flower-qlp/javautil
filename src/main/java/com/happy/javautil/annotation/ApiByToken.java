package com.happy.javautil.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * @author happy
 * 不能继承其它接口或者注解
 * Target 若不存在 则默认全部适用 若存在则适用指定的范围
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
public @interface ApiByToken {

    boolean isCheck() default false;

    String name() default "";

    @AliasFor("path")
    String[] value() default {};

    @AliasFor("value")
    String[] path() default {};

    RequestMethod[] method() default {};

    String[] headers() default {};

    String[] consumes() default {};

    String[] produces() default {};
}
