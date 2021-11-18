package com.happy.javautil.service;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TestService {

    private List<String> names = new ArrayList<>();

    public void initList() {
        names.clear();
    }

    public void test() {
        this.initList();
        Integer i = new Random().nextInt();
        names.add("" + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i===" + i + "===name===" + JSON.toJSONString(names));

        AtomicInteger ii= new AtomicInteger(12);
        names.forEach(x->{
            ii.getAndIncrement();
        });
    }

    public String getNo(String noHeard){
        Integer i=new Random().nextInt(10);
        return noHeard+i;
    }
}
