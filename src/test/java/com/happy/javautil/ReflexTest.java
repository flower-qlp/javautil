package com.happy.javautil;

import java.lang.reflect.Method;

public class ReflexTest {

    public static void main(String[] args) {
        try {
            Class c=ReflexTest.class;
            Method method=c.getMethod("print",String.class);
            method.invoke(c,"小子");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void print(String name) {
        System.out.println("------>" + name);
    }

}
