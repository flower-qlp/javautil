package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.entity.TestEntity;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringUtil {

    public static void main(String[] args) {
//        List<TestEntity> list=new ArrayList<>();
//        list.add(new TestEntity("1","1",1, BigDecimal.ONE));
//        list.add(new TestEntity("2","1",1, BigDecimal.ONE));
//        TestEntity test=list.stream().filter(x->x.getName().equals("3")).findFirst().orElse(null);
        String name = "ê°";
        TestEntity testEntity = new TestEntity();
        String format = String.format(name, "UTF-8");
        testEntity.setName(format);
        String str = JSON.toJSONString(testEntity);
        TestEntity testEntity1 = JSON.parseObject(str, TestEntity.class);
        System.out.println(testEntity1.getName());

    }

}
