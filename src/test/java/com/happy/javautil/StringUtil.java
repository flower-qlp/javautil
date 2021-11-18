package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class StringUtil {

    public static void main(String[] args) {

        BigDecimal bigDecimal=new BigDecimal("12.659");
        System.out.println(JSON.toJSONString(bigDecimal.setScale(0,BigDecimal.ROUND_UP)));
    }

}
