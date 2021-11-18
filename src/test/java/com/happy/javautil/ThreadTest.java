package com.happy.javautil;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Integer index = new Random().nextInt(50);
            System.out.println("+" + index);
        }

//          String name="10120210000018";
//          System.out.println(StringUtils.substring(name,7,13));

//        List<BigDecimal> list=new ArrayList<>();
//        list.add(new BigDecimal("10"));
//        list.add(new BigDecimal("13"));
//        list.add(new BigDecimal("14"));
//        list.add(new BigDecimal("1"));
//        list.add(new BigDecimal("5"));
//
//        BigDecimal sum=list.stream().reduce(BigDecimal.ZERO,BigDecimal::add);
//        System.out.println(sum);

//        List<String> list=new ArrayList<>();
//        TestVo vo=new TestVo();
//        vo.setStr(list);
//        List<String> arr=JSON.parseArray(vo.getStr()+"",String.class);
//        if (null != arr && arr.size() > 0) {
//            System.out.println("=====11111======");
//        }
//       System.out.println("===========");
//
//
//
//        List<Integer> li= Arrays.asList(1,2,34,5);
//        System.out.println(li.contains(1));
    }


}
