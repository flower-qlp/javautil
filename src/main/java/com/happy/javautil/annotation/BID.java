package com.happy.javautil.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface BID {
    
    String[] files() default {};
    
    String value() default "";
    
    String name() default "";
    
    boolean required() default true;
}
