package com.happy.javautil.aop;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.annotation.ApiByToken;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author happy
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnnotationAsp {

    @Pointcut(value = "@annotation(com.happy.javautil.annotation.ApiByToken)")
    public void loginPoint() {
    }


    @Around("loginPoint()")
    public Object handleController(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("--------------进入切面---------------");
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ApiByToken apiByToken=method.getAnnotation(ApiByToken.class);
        if(apiByToken.isCheck()){
            System.out.println("need check token !");
        }
        Object[] args = Arrays.stream(proceedingJoinPoint.getArgs())
                .filter(x -> !(x instanceof HttpServletResponse)
                        && !(x instanceof HttpServletRequest))
                .toArray();
        System.out.println("入参：" + JSON.toJSONString(args));
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}
