package com.happy.javautil;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Jingjiang {

    public static void main(String[] args) {


        String value="{\"copyEntity\":{\"params\":{},\"age\":\"12\"},\"name\":\"名称\",\"params\":{}}";

        log.info(value.contains("\":\""));
    }

}
