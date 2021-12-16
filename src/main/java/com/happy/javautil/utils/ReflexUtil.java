package com.happy.javautil.utils;


import com.happy.javautil.entity.TestEntity;
import com.happy.javautil.entity.ValidEntity;
import org.apache.poi.ss.formula.functions.T;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author happy
 */
public class ReflexUtil {

    public static Map<String, Object> objectToMap(Object target) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();
        Class targetClass = target.getClass();
        while (targetClass != Object.class) {
            exchange(target, paramMap, targetClass);
            targetClass = targetClass.getSuperclass();
        }
        return null;
    }

    public static void exchange(Object target, Map<String, Object> paramMap, Class<T> tClass) {
        Field[] files = tClass.getDeclaredFields();
        StringBuilder stringBuilder = null;
        for (Field field : files) {
            String fileName = field.getName();
            stringBuilder = new StringBuilder();
            stringBuilder.append("get");
            stringBuilder.append(fileName.substring(0, 1).toUpperCase());
            stringBuilder.append(fileName.substring(1));
            String methodName = stringBuilder.toString();
            Method method = null;
            try {
                method = tClass.getMethod(methodName, null);
                Object value = method.invoke(target, null);
                if (value == null) {
                    continue;
                }
                if (value instanceof String) {
                    if ("".equals(value)) {
                        continue;
                    }
                }
                paramMap.put(fileName, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void test(Object target) throws Exception {
        Field[] files = target.getClass().getDeclaredFields();

        Annotation[] annotations = target.getClass().getDeclaredAnnotations();

        Method[] methods = target.getClass().getDeclaredMethods();

        Class c = target.getClass().getSuperclass();

        Field[] parentFiles = c.getDeclaredFields();

        Method method = c.getMethod("getId", null);
        String id = (String) method.invoke(target, null);
    }

    public static void main(String[] args) throws Exception {
        ValidEntity validEntity = new ValidEntity();
        validEntity.init();
        validEntity.setId("789865464");

        TestEntity testEntity = new TestEntity();
        testEntity.setAmount(new BigDecimal(78931));
        testEntity.setPhone(896);
        validEntity.setTestEntity(testEntity);
        objectToMap(validEntity);
    }
}
