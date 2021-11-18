package com.happy.javautil.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author happy
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ValidAsp {
}
