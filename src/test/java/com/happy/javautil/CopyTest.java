package com.happy.javautil;

import com.happy.javautil.annotation.CopyColumn;
import com.happy.javautil.entity.TestEntity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CopyTest {

    public static void main(String[] args) {

//        TestEntity testEntity = new TestEntity();
//        testEntity.setName("name1");
//        testEntity.setPhone(123);
//
//        TestEntity testEntity1 = new TestEntity();
//        testEntity1.setAge("123");

//        BeanUtils.copyProperties(testEntity1, testEntity,"name","phone");
//        System.out.println(JSON.toJSONString(testEntity));

        List<TestEntity> li = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            TestEntity testEntity = new TestEntity();
            testEntity.setName(i + "");
            testEntity.setPhone(i);
            testEntity.setAge(i + "");
            li.add(testEntity);
        }
        ThreadLocal<StringBuffer> local = new ThreadLocal<>();
        List<TestEntity> collect = li.parallelStream().map(x -> {
            TestEntity testEntity = new TestEntity();
            local.set(new StringBuffer());
            StringBuffer stringBuffer = local.get();
            stringBuffer.append(x.getName());
            stringBuffer.append(x.getAge());
            stringBuffer.append(x.getPhone());
            testEntity.setFzzt(stringBuffer.toString());
            return testEntity;
        }).collect(Collectors.toList());

        collect.forEach(x -> {
            System.out.println(x.getFzzt());
            System.out.println();
        });


//        int loopIndex = li.size() % 100 > 0 ? li.size() / 100 + 1 : li.size()/100;
//        List<TestEntity> testEntities = li.subList(0, loopIndex * 100);
//        System.out.println("----->" + loopIndex);
//        System.out.println("----->" + JSON.toJSONString(testEntities));

//        List<TestEntity> testEntities = li.subList(5, 7);
//        System.out.println(JSON.toJSONString(testEntities));
//
//        List<TestEntity> result = new ArrayList<>();
//        Long start = System.currentTimeMillis();
//        System.out.println("===============start==========" + start);
//        li.stream()
//                .forEach(x -> {
//                    TestEntity testEntity = new TestEntity();
//                    BeanUtils.copyProperties(x, testEntity);
//                    result.add(testEntity);
//                });
//
//        Long end = System.currentTimeMillis();
//        System.out.println("============end=============" + end);
//
//        System.out.println("============cha=============" + (end - start));


//        TestEntity testEntity = new TestEntity();
//        testEntity.setPhone(12);
//        testEntity.setName("asdasda");
//        TestEntity testEntity2 = new TestEntity();
//        copyColumn(testEntity, testEntity2);
//        System.out.println(JSON.toJSONString(testEntity2));

//        String value="1室1厅1卫";
//        String patternStr="\\d+室+\\d+厅+\\d卫+";
//        boolean matches = Pattern.matches(patternStr, value);
//        System.out.println(matches);
//
//        int indexS = value.indexOf("室");
//        int indexT = value.indexOf("厅");
//        int indexW = value.indexOf("卫");
//
//        String substring = value.substring(0, indexS);
//        String substring1 = value.substring(indexS+1, indexT);
//        String substring2 = value.substring(indexT+1, indexW);
//        System.out.println(substring);
//        System.out.println(substring1);
//        System.out.println(substring2);

    }


    public static void copyColumn(Object fromObject, Object toObject) {
        if (null == fromObject || null == toObject) {
            return;
        }
        Field[] declaredFields = toObject.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            CopyColumn annotation = field.getAnnotation(CopyColumn.class);
            Class<?> type = field.getType();
            if (annotation == null) {
                continue;
            }
            String fileName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            try {
                Method getMethod = fromObject.getClass().getMethod("get" + fileName);
                Object invoke = getMethod.invoke(fromObject, null);

                Method setMethod = toObject.getClass().getMethod("set" + fileName, type);
                setMethod.invoke(toObject, invoke);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
