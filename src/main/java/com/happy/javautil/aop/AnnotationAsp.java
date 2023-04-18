package com.happy.javautil.aop;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.annotation.ApiByToken;
import com.happy.javautil.annotation.Search;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author happy
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnnotationAsp {
    
    private Pattern pattern = Pattern.compile("[^1-9]*");
    
    @Pointcut(value = "@annotation(com.happy.javautil.annotation.ApiByToken)")
    public void loginPoint() {
    }
    
    @Pointcut(value = "@annotation(com.happy.javautil.annotation.Search)")
    public void searchPoint() {
    }
    
    @Around("searchPoint()")
    public Object handleSearchController(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("--------------进入切面---------------");
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Search search = method.getAnnotation(Search.class);
        
        Object[] args = Arrays.stream(proceedingJoinPoint.getArgs())
                .filter(x -> !(x instanceof HttpServletResponse) && !(x instanceof HttpServletRequest)).toArray();
        System.out.println("入参：" + JSON.toJSONString(args));
        
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
    
    
    @Around("loginPoint()")
    public Object handleController(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("--------------进入切面---------------");
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ApiByToken apiByToken = method.getAnnotation(ApiByToken.class);
        if (apiByToken.isCheck()) {
            System.out.println("need check token !");
        }
        String name = apiByToken.name();
        Object[] args = Arrays.stream(proceedingJoinPoint.getArgs())
                .filter(x -> !(x instanceof HttpServletResponse) && !(x instanceof HttpServletRequest)).toArray();
        System.out.println("入参：" + JSON.toJSONString(args));
        
        for (Object o : args) {
            Class<?> aClass = o.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            Arrays.asList(declaredFields).forEach(filed -> {
                String fileName = filed.getName();
                if (fileName.equals(name)) {
                    Class<?> type = filed.getType();
                    if (type == Long.class) {
                        try {
                            filed.setAccessible(true);
                            String value = (String) filed.get(o);
                            String s = pattern.matcher(value).replaceAll("");
                            filed.set(o, s);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        }
        
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}
