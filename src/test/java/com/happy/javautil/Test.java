package com.happy.javautil;

import com.happy.javautil.entity.TestEntity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test {

    public static void change(String name) {
        System.out.println("name=" + name);
    }

    public static  void name(Long value){
        if(value!=null&& 1L == value){
            return;
        }
    }


    public static void main(String[] args) throws ParseException {

        List<TestEntity> list=new ArrayList<>();
        TestEntity entity=new TestEntity();
        entity.setName(null);
        list.add(entity);
    
        TestEntity entity1=new TestEntity();
        entity1.setName("dddd");
        list.add(entity1);
        
    
        String s = list.stream().map(TestEntity::getName)
                .filter(Objects::nonNull).collect(Collectors.joining(","));
    
        System.out.println(s);
        
    
        //       String name="123456";
//        String format = String.format("%-10s", name);
//        System.out.println(format);

        //        StringBuilder builder = new StringBuilder();
//        int index = 29;
//        int size = index / 26;
//        int last = index % 26;
//        if (size == 0) {
//            int i = 'A' + last - 1;
//            Character i1 = (char) i;
//            System.out.println("----"+i1.toString());
//        }else if (size <= 26) {
//            int i = 'A' + size - 1;
//            Character i1 = (char) i;
//            builder.append(i1);
//            if (last > 0) {
//                int second = 'A' + last - 1;
//                Character i2 = (char) second;
//                builder.append(i2);
//            }
//            System.out.println(builder.toString());
//        }


//        Map<String,String> map=new HashMap<>();
//        map.put(null,"121");
//        map.put(null,"2434");
//        System.out.println(JSON.toJSONString(map));
//        String s = map.get(null);System.out.println(s);


//        change(null);
//        change("121212");

//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYMM");
//        String s=simpleDateFormat.format(new Date());
//        System.out.println(s);

//        List<String> list = new ArrayList<>();
//        list.add("C000122051002");
//        list.add("C000122051003");
//        list.add("C000122050302");
//        list.add("C000122050102");
//
////
//        List<String> list2 = new ArrayList<>();
//        list2.add("C000122051002");
//        list2.add("C000122051003");
//        list2.add("C000122050302");
//        list2.add("C000122050102");
//        list2.add("C000122050003");
////        List<String> strings = list2.subList(0, 3);
//        list2.removeAll(list);
//        System.out.println(JSON.toJSONString(list2));
//
//        list2.removeAll(list);
//        System.out.println(JSON.toJSONString(list2));
//
////        String s = list.parallelStream().max(Comparator.comparing(String::valueOf)).orElse("");
//
//        String [] arr=new String[list.size()];
//        list.toArray(arr);
//
//        System.out.println(JSON.toJSONString(arr));

//        TestEntity testEntity = new TestEntity();
//        testEntity.setAge("1212");
//        testEntity.setCreateTime(new Date());
//
//        try {
//            TestEntity clone1 = testEntity.clone();
//            clone1.setPhone(121212);
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            clone1.setCreateTime(format.parse("2020-12-12"));
//
//            TestEntity clone2 = testEntity.clone();
//            clone2.setAge("23659");
//            clone2.setCreateTime(format.parse("1998-12-12"));
//            System.out.println(JSON.toJSONString(testEntity));
//            System.out.println(JSON.toJSONString(clone1));
//            System.out.println(JSON.toJSONString(clone2));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//            Long A=10L;
//            Long B=3L;
//            Integer c= Math.toIntExact((A / B));
//        Integer d= Math.toIntExact((A % B));
//        System.out.println(c);
//        System.out.println(d);

//        TestEntity testEntity2 = new TestEntity();
//        testEntity2.setCreateTime(new Date());
//        TestEntity testEntity3= new TestEntity();
//        testEntity3.setCreateTime(new Date());
//        TestEntity testEntity4 = new TestEntity();
//        testEntity3.setCreateTime(new Date());
//        TestEntity testEntity5 = new TestEntity();
//
//        Calendar calendar=Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.YEAR,5);
//        TestEntity testEntity6 = new TestEntity();
//        testEntity6.setCreateTime(calendar.getTime());
//
//        List<TestEntity> list = new ArrayList<>();
//        list.add(testEntity);
//        list.add(testEntity2);
//        list.add(testEntity6);
//        list.add(testEntity3);
//        list.add(testEntity4);
//        list.add(testEntity5);


//        Optional<Date> lastDeliverTime = list.stream().map(TestEntity::getCreateTime).filter(Objects::nonNull).max(Comparator.naturalOrder());

//        System.out.println(JSON.toJSONString(lastDeliverTime));


//        List<String> names=Arrays.asList(null,null,null,null);
//        long num=names.stream().filter(Objects::isNull).count();
//        if(num<names.size()) {
//            String nameStr = names.stream().filter(Objects::nonNull).distinct().reduce((x1, x2) -> {
//                return x1 + "," + x2;
//            }).get();
//            System.out.println(nameStr);
//        }
//        System.out.println("nameStr");

//        String[] idArr =null;
//        if (ArrayUtils.isEmpty(idArr)) {
//            System.out.println("nameStr");
//        }
//        List<Map<String, Object>> list = new ArrayList<>();
//        Map<String, Object> param = new HashMap<>();
//        param.put("examineAndVerify", "1");
//        list.add(param);
//        Integer Deleted = 1;
//        long count = list.parallelStream()
//                .map(x -> null == x.get("examineAndVerify") ? "" : String.valueOf(x.get("examineAndVerify")))
//                .filter(y -> y.equals(Deleted))
//                .count();
//        for (Map<String, Object> map : list) {
//            String examineAndVerify = null == map.get("examineAndVerify") ? "" : String.valueOf(map.get("examineAndVerify"));
//            if (examineAndVerify.equals("1")) {
//                System.out.println("count=" + 1);
//            }
//        }
//        System.out.println("count=" + count);
//        Date str = exchange(new Date(), Date.class);
//        System.out.println(JSON.toJSONString(str));
    }

    public static int add(Integer i) {
        return i + 1;
    }

    public static <T> T exchange(Object data, Class<T> tClass) {
        T s = null;
        try {
            if (data.getClass() == tClass) {
                s = (T) data;
            }
        } catch (Exception e) {

        }
        return s;
    }
}
