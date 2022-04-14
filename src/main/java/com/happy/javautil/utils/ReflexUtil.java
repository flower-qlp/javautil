package com.happy.javautil.utils;


import com.alibaba.fastjson.JSON;
import com.happy.javautil.annotation.Search;
import com.happy.javautil.entity.TestEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

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

    private <T> T copy(Object toObject, Class<T> tClass) {
        T t = null;
        try {
            t = tClass.newInstance();

            final Field[] declaredFields = tClass.getDeclaredFields();

            for (Field declaredField : declaredFields) {
                String fileName = declaredField.getName();
                Class fileType = declaredField.getType();
                StringBuilder stringBuilder = new StringBuilder();
                Object value = null;
                try {
                    stringBuilder.append("get");
                    stringBuilder.append(fileName.substring(0, 1).toUpperCase());
                    stringBuilder.append(fileName.substring(1));
                    Method method = toObject.getClass().getMethod(stringBuilder.toString(), null);
                    value = method.invoke(toObject, null);
                } catch (Exception e) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("set");
                    stringBuilder.append(fileName.substring(0, 1).toUpperCase());
                    stringBuilder.append(fileName.substring(1));
                    Method setMethod = tClass.getMethod(stringBuilder.toString(), fileType);
                    setMethod.invoke(t, changeType(null, fileType));
                    continue;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("set");
                stringBuilder.append(fileName.substring(0, 1).toUpperCase());
                stringBuilder.append(fileName.substring(1));
                Method setMethod = tClass.getMethod(stringBuilder.toString(), fileType);
                setMethod.invoke(t, changeType(value, fileType));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    private Object changeType(Object o, Class type) {
        if (null != o && o.getClass() == type) {
            return o;
        }
        if (type == String.class) {
            return null == o ? "" : String.valueOf(o);
        }
        if (type == Integer.class) {
            return null == o ? 0 : o.getClass() == String.class ? Integer.parseInt((String) o) : Integer.parseInt(JSON.toJSONString(o));
        }
        if (type == Long.class) {
            return null == o ? 0 : o.getClass() == String.class ? Long.parseLong((String) o) : Long.parseLong(JSON.toJSONString(o));
        }
        return null;
    }


    public static <T> T param(Object fromObject, Class<T> tClass) {
        T targetObject = null;
        try {
            final Field[] declaredFields = fromObject.getClass().getDeclaredFields();

            if (fromObject.getClass() != tClass) {
                targetObject = tClass.newInstance();
            } else {
                targetObject = (T) fromObject;
            }

            for (Field field : declaredFields) {

                String fileName = field.getName();
                String functionName = fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
                Method getMethod = fromObject.getClass().getMethod("get" + functionName);
                Object value = getMethod.invoke(fromObject, null);
                if (null == value) {
                    continue;
                }
                Search search = field.getAnnotation(Search.class);
                if (null != search) {
                    dealWithSearch(search, value, targetObject);
                    continue;
                }
                if (fromObject.getClass() == tClass) {
                    continue;
                }

                Class resultType = getMethod.getReturnType();
                Method setMethod = targetObject.getClass().getMethod("set" + functionName, resultType);
                setMethod.invoke(targetObject, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetObject;
    }

    private static void dealWithSearch(Search search, Object value, Object targetObject) {
        try {
            String columnNames = search.columnName();
            String compare = search.compare();
            String preStr = search.preStr();
            String afterStr = search.afterStr();
            String paramKey = search.paramKey();
            String getParamMethod = search.getParamMethod();
            String tableName = search.tableName();

            if (StringUtils.isBlank(columnNames)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            String[] columnNameArr = columnNames.split(",");
            stringBuffer.append(" AND ( ");
            for (int index = 0; index < columnNameArr.length; index++) {
                if (StringUtils.isNotBlank(tableName)) {
                    stringBuffer.append(tableName);
                    stringBuffer.append(".");
                }
                stringBuffer.append(columnNameArr[index]);
                stringBuffer.append(" ");
                stringBuffer.append(compare);
                stringBuffer.append(" '");
                stringBuffer.append(preStr);
                stringBuffer.append(value);
                stringBuffer.append(afterStr);
                stringBuffer.append("' ");
                if (index == columnNameArr.length - 1) {
                    stringBuffer.append(" ");
                } else {
                    stringBuffer.append(" or ");
                }
            }
            stringBuffer.append(" )");
            System.out.println("str=" + stringBuffer.toString());

            String setParamMethod = "s" + getParamMethod.substring(1);

            Method getMapMethod = targetObject.getClass().getMethod(getParamMethod);
            Object paramMap = getMapMethod.invoke(targetObject, null);
            Map<String, Object> map = JSON.parseObject(JSON.toJSONString(paramMap), Map.class);
            if (map.containsKey(paramKey)) {
                Object alreadyValue = map.get(paramKey);
                String valueStr = null == alreadyValue ? "" : alreadyValue + stringBuffer.toString();
                map.put(paramKey, valueStr);
            } else {
                map.put(paramKey, stringBuffer.toString());
            }

            boolean canSet = true;
            Class setClass = targetObject.getClass();
            while (canSet) {
                try {
                    if (setClass == Object.class) {
                        canSet = false;
                    }
                    Method setMapMethod = targetObject.getClass().getMethod(setParamMethod, Map.class);
                    setMapMethod.invoke(targetObject, map);
                    canSet = false;
                } catch (Exception e) {
                    canSet = true;
                    setClass = setClass.getSuperclass();
                }
            }
        } catch (Exception e) {
        }
    }


    public static final List<String> INIT_CREATE = Arrays.asList("setCreateTime", "setCreateUser", "setUpdateUser", "setUpdateTime", "setTheState", "setBizState", "setApproveState");

    public static final List<String> INIT_UPDATE = Arrays.asList("setUpdateUser", "setUpdateTime");

    public static final List<String> INIT_CLOSE = Arrays.asList("setUpdateUser", "setUpdateTime", "setCloseDate");

    public static <T> T createEntity(Object fromObject, Class<T> targetClass) {
        try {
            T insertEntity = targetClass.newInstance();
            BeanUtils.copyProperties(fromObject, insertEntity);
            return initBaseEntity(insertEntity, targetClass, INIT_CREATE);
        } catch (Exception e) {
        }
        return null;
    }

    public static <T> T initBaseEntity(Object o, Class<T> tClass, List<String> attributes) {
        T t = JSON.parseObject(JSON.toJSONString(o), tClass);

        for (String attribute : attributes) {
            try {
                String substring = "g" + attribute.substring(1);
                Method getMethod = t.getClass().getMethod(substring);
                Class<?> returnType = getMethod.getReturnType();
                Method method = t.getClass().getMethod(attribute, returnType);
                method.invoke(t, defaultValue(attribute));
            } catch (Exception e) {
            }
        }
        return t;
    }

    public static Object defaultValue(String attribute) {
        switch (attribute) {
            case "setCreateTime":
            case "setUpdateTime":
            case "setCloseDate":
                return new Date();
            case "setCreateUser":
            case "setUpdateUser":
                return "xxxxx";
            case "setTheState":
            case "setBizState":
            case "setApproveState":
                return "0";
            default:
                break;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {


//        TestEntityCopy copy = new TestEntityCopy();
//        copy.setFzzt("小路");
//        copy.setCodes(Arrays.asList("12","3131"));
//        TestEntity extend1Entity = param(copy, TestEntity.class);
//        System.out.println(JSON.toJSONString(extend1Entity));

//        TestEntityCopy testEntityCopy = new TestEntityCopy();
//        testEntityCopy.setFzzt("121212");
//        testEntityCopy.setAge(10);
//        testEntityCopy.setSex(111);

//        TestEntity testEntity = new TestEntity();
//        TestEntity testEntity1 = initBaseEntity(testEntity, TestEntity.class, INIT_CREATE);
//        System.out.println(JSON.toJSONString(testEntity));
//        System.out.println(JSON.toJSONString(testEntity1));
//
//        Boolean name=true;
//
//        assert name:"shibai";
//
//        TestEntity testEntity = createEntity(testEntityCopy, TestEntity.class);
//        System.out.println(JSON.toJSONString(testEntity));

//        TestEntity testEntity=new TestEntity();
//        testEntity.setAge("1212");
//
//        Map map = JSON.parseObject(JSON.toJSONString(testEntity), Map.class);

        List<TestEntity> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TestEntity testEntity = new TestEntity();
            testEntity.setAge("P0" + i);
            if(i==3){
                testEntity.setAge("P");
            }else{
                testEntity.setAge("P0" + i);
            }
            list.add(testEntity);
        }

    }
}
