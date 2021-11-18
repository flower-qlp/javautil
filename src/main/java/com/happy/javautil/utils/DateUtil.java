package com.happy.javautil.utils;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date date = simpleDateFormat.parse("20101212121212");
            System.out.println(JSON.toJSONString(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
