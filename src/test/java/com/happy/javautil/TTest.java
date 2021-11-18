package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.annotation.ApiByToken;
import com.happy.javautil.entity.TestEntity;
import org.apache.poi.ss.formula.functions.T;
import org.json.JSONString;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;


public class TTest {

    public static void main(String[] args) {
        TestEntity entity = new TestEntity();
        entity.setAmount(new BigDecimal(45465));
        entity.setName("16556");

        Object obj = entity;

        Field[] files = obj.getClass().getDeclaredFields();
        for (int i = 0; i < files.length; i++) {

            if (files[i].getType() == String.class) {
                System.out.println("type is string");
            }
            if (files[i].getType() == BigDecimal.class) {
                System.out.println("BigDecimal is string");
            }
            ApiByToken apiByTokens=files[i].getAnnotation(ApiByToken.class);
            if(null==apiByTokens){
                System.out.println("没有注解");
            }else{

                System.out.println("有助解"+apiByTokens.isCheck());
            }
            System.out.println(files[i].getName());
            try {
                String fileName = "get" + files[i].getName().substring(0, 1).toUpperCase() + files[i].getName().substring(1);
                Method method = obj.getClass().getMethod(fileName, new Class[]{});
                Object val = method.invoke(obj, new Object[]{});
                System.out.println(JSON.toJSONString(val));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    public String exchange(JSONString jsonString, Class<T> tClass) {

        return null;
    }
}
