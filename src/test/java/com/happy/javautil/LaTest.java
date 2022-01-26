package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.entity.TestEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LaTest {

    public static void main(String[] args) {
        List<TestEntity> list = new ArrayList<>();
        list.add(new TestEntity("gg", BigDecimal.ONE));
        list.add(new TestEntity("gg", BigDecimal.ONE));
        list.add(new TestEntity("gg", BigDecimal.ONE));
        list.add(new TestEntity("gg", BigDecimal.ONE));
        list.add(new TestEntity("gg", BigDecimal.ONE));
        list.add(new TestEntity("dd", BigDecimal.ONE));
        list.add(new TestEntity("dd", BigDecimal.ONE));
        list.add(new TestEntity("dd", BigDecimal.ONE));
        list.add(new TestEntity("dd", BigDecimal.ONE));
        list.add(new TestEntity("dd", BigDecimal.ZERO));


        Map<String, BigDecimal> result = list.parallelStream()
                .collect(Collectors.groupingBy(TestEntity::getName,
                        Collectors.mapping(TestEntity::getAmount,Collectors.reducing(BigDecimal.ZERO,BigDecimal::add))));
        System.out.println(JSON.toJSONString(result));

    }
}
