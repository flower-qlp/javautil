package com.happy.javautil.aop;

import com.happy.javautil.annotation.StringFormat;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author happy
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Log4j2
public class StringFormatAsp {

    @Pointcut("@annotation(com.happy.javautil.annotation.ExternalInterface)")
    public void stringFormat() {
    }

    @Around("stringFormat()")
    public Object exchangeField(ProceedingJoinPoint proceedingJoinPoint) {
        Object obj = null;
        log.info("----------------拦截 StringFormatAsp start-------------");
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("执行失败");
        }
        assert obj != null;
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Object finalObj = obj;
        Arrays.asList(declaredFields)
                .forEach(x -> {
                    StringFormat annotation = x.getAnnotation(StringFormat.class);
                    if (null == annotation) {
                        return;
                    }
                    int length = annotation.length();
                    if (length <= 0) {
                        return;
                    }
                    String methodName = x.getName().substring(0, 1).toUpperCase() + x.getName().substring(1);
                    String value = "";
                    try {
                        Method method = finalObj.getClass().getMethod("get" + methodName);
                        value = (String) method.invoke(finalObj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(StringUtils.isBlank(value)||value.length()==length){
                        return;
                    }
                    String resultValue = null;
                    if(value.length()>length){
                        resultValue= value.substring(0,length);
                    }else{
                       resultValue=String.format("%-"+length+"s",value);
                    }
                    try {
                        Method setMethod = finalObj.getClass().getMethod("set" + methodName, String.class);
                        setMethod.invoke(finalObj, resultValue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        log.info("----------------拦截 StringFormatAsp end-------------");
        return finalObj;
    }
}
