package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.entity.TestEntity;

import java.util.*;

public class LaTest {

    public static void main(String[] args) {
//        List<TestEntity> list=new ArrayList<>();
//        TestEntity testEntity=new TestEntity();
//        testEntity.setName("1");
//        testEntity.setAge("2");
//
//        TestEntity testEntity2=new TestEntity();
//        testEntity2.setName("2");
//        testEntity2.setAge("3");
//
//        list.add(testEntity);
//        list.add(testEntity2);
//
//        List<TestEntity> list2=new ArrayList<>();
//        TestEntity testEntity3=new TestEntity();
//        testEntity3.setName("2");
//        list2.add(testEntity3);
//        System.out.println(JSON.toJSONString(list));
//        System.out.println(JSON.toJSONString(list2));
//        boolean b1 = list.removeAll(list2);
//        System.out.println(JSON.toJSONString(list));

        Map<String, String> map = new HashMap<>();
        map.put("name1", "11111");
        map.put("name2", "2222");

        List<TestEntity> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            TestEntity testEntity = new TestEntity();
            if (i % 3 == 0) {
                testEntity.setName("name1");
            } else {
                testEntity.setName("name2");
            }
            list.add(testEntity);

        }
        list.parallelStream().peek(x -> x.setAge(map.get(x.getName()))).forEach(y -> {
            System.out.println(JSON.toJSONString(y));
            try {
                Thread.sleep((long) new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


//        List<TestEntity> collect = list.parallelStream().distinct().collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(collect));
//
//        Map<String,String> param=new HashMap<>();
//        param.put("1","2");
//        param.put("2","2");
//        param.put("3","2");
//        param.put("4","2");
//        System.out.println(JSON.toJSONString(new ArrayList<>(param.keySet())));

//        List<String> aaa=new ArrayList<>();
//        aaa.add("1");
//        aaa.add("2");
//        aaa.add("3");
//        aaa.add("4");
//
//        List<String> bbb=new ArrayList<>();
//        bbb.add("1");
//        bbb.add("2");
//        bbb.add("3");
//        bbb.add("6");
//        bbb.add("5");
//        boolean b = aaa.removeAll(bbb);
//        System.out.println(JSON.toJSONString(aaa));

//        List<TestEntity> list = new ArrayList<>();
//        Map<Integer, Map<String, String>> map1 = new HashMap<>();
//        for (int i = 0; i < 2; i++) {
//            Map<String, String> sex = new HashMap<>();
//            for (int j = 0; j < 2; j++) {
//                sex.put(String.valueOf(j), "name" + j);
//            }
//            map1.put(i, sex);
//        }
//        System.out.println(JSON.toJSONString(map1));
//        List<TestEntity> collect = map1.keySet().stream()
//                .flatMap(y -> map1.get(y).keySet().stream()
//                        .map(z -> new TestEntity(map1.get(y).get(z), z, y)).collect(Collectors.toList()).stream()
//                ).collect(Collectors.toList());
//
//        System.out.println(JSON.toJSONString(collect));

//        for (int i = 0; i < 100; i++) {
//            System.out.println(show());
//        }

//        list.add(new TestEntity("gg", BigDecimal.ONE));
//        list.add(new TestEntity("gg", BigDecimal.ONE));
//        list.add(new TestEntity("gg", BigDecimal.ONE));
//        list.add(new TestEntity("gg", BigDecimal.ONE));
//        list.add(new TestEntity("gg", BigDecimal.ONE));
//        list.add(new TestEntity("dd", BigDecimal.ONE));
//        list.add(new TestEntity("dd", BigDecimal.ONE));
//        list.add(new TestEntity("dd", BigDecimal.ONE));
//        list.add(new TestEntity("dd", BigDecimal.ONE));
//        list.add(new TestEntity("dd", BigDecimal.ZERO));
//
//        for (TestEntity testEntity : list) {
//            testEntity.setName("11111" + new Random().nextInt());
//        }
//        System.out.println(JSON.toJSONString(list));
//
//        Map<String, Object> map = list.stream()
//                .collect(Collectors.toMap(TestEntity::getName, Function.identity(), (a, b) -> b));
//        System.out.println(JSON.toJSONString(map));
//
//
//        Map<Long, BigDecimal> result = list.parallelStream()
//                .collect(Collectors.groupingBy(TestEntity::getId,
//                        Collectors.mapping(TestEntity::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
//
//        Set mapSet = result.keySet();
//        for (Object id : mapSet) {
//            System.out.println("-->" + Long.valueOf(String.valueOf(id)));
//            System.out.println("-->" + result.get(id));
//        }
//        System.out.println(JSON.toJSONString(result));
//
//        String leaseType = "1,1,1,1,12,3,4,5,6";
//        leaseType = leaseType.contains(",") ? Arrays.stream(leaseType.split(",")).distinct().collect(Collectors.joining(",")) : leaseType;
//        System.out.println(leaseType);
//        String name = "001测试asd9019";
//        final String reg = "[^(0-9)]";
//        Pattern pat = Pattern.compile(reg);
//        Matcher mat = pat.matcher(name);
//        String name1 = mat.replaceAll("");
//        System.out.println(JSON.toJSONString(name1));
    }

    public static synchronized String show() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() + "";
    }
}
