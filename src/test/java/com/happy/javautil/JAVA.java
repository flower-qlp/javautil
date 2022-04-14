package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.entity.copy.Extend1Entity;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class JAVA {
    public static void main(String[] args) {

//        CopyEntity copyEntity = new CopyEntity();
//        copyEntity.setCopyId(11111L);
//
//        Extend1Entity entity = new Extend1Entity();
//        entity.setExtend1Id(1L);
//        entity.setExtendId(2L);
//        entity.setBaseId(3L);

//        BeanUtils.copyProperties(entity, copyEntity);
//
//        System.out.println(JSON.toJSONString(copyEntity));
//
//        String divide = new BigDecimal(36L).multiply(new BigDecimal(100)).divide(new BigDecimal(36), 2, RoundingMode.HALF_UP)+"%";
//        System.out.println(""+new BigDecimal(100));
//        System.out.println(""+new BigDecimal("100"));
//        System.out.println(divide);
//
//        String number="10.232332";
//        DecimalFormat decimalFormat=new DecimalFormat("######0");
//        Number n=0;
//        try {
//            n=decimalFormat.parse(number);
//            System.out.println(decimalFormat.format(n));
//        } catch (ParseException e) {
//
//        }
//
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","111");
//        System.out.println(""+JSON.toJSONString(map));

        Extend1Entity entity = new Extend1Entity();
        Extend1Entity extend1Entity= initBaseEntity(entity, Extend1Entity.class,INIT_CREATE);
        System.out.println(JSON.toJSONString(extend1Entity));

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
