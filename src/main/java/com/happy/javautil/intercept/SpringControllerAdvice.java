package com.happy.javautil.intercept;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SpringControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> runtimeException(Exception e) {
        e.printStackTrace();
        Map<String,Object> result=new HashMap<>();
        result.put("1",e.getMessage()) ;
        result.put("2","zidingyi") ;
        return result;
    }
}
