package com.happy.javautil;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JAVA {
    public static void main(String[] args) {

        Map<String,String> map1=new HashMap<>();
        Map<String,String> map2=new HashMap<>();
        System.out.println(map1.get(map2.get("1")));
    }

    public static final List<String> INIT_CREATE = Arrays.asList("setExtendName");

    public static <T>T initBaseEntity(Object o, Class<T> tClass, List<String> attributes) {
        T t = JSON.parseObject(JSON.toJSONString(o), tClass);
        try {
            for (String attribute : attributes) {
                String substring ="g"+ attribute.substring(1);
                Method getMethod=t.getClass().getMethod(substring);
                Class<?> returnType = getMethod.getReturnType();
                Method method = t.getClass().getMethod(attribute, returnType);
                method.invoke(t, defaultValue(attribute));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static Object defaultValue(String attribute){
        switch (attribute) {
            case "setTheState": System.out.println("setExtendName"); return "0";
            case "setExtendName":
                System.out.println("setExtendName");return "dasdasdasdadasd";
            case "setExtend1Number": System.out.println("setExtendName"); return 1;
            default: break;
        }
        return "";
    }

}
