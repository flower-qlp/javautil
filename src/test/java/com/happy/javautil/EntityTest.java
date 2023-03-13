package com.happy.javautil;

import com.happy.javautil.entity.TestEntity;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
public class EntityTest {

    public static void main(String[] args) throws ParseException {

        String name="2012-11-12 15:32:13>>32678769318764>>425432543523000012>>借>>30000000>>0>>30000000>>张三贷款>>6100114070600011>>01>>129839983918332131311>>1<<<2012-11-12 17:30:17>>32678769318765>>425432543523000013>>借>>10000000>>0>>10000000>>李四贷款>>6100114070600012>>02>>129839983918332131312>>1|";
        String[] split = name.split("\\|");
        System.out.println(name.contains(">>"));

        //        TestEntity t1 = new TestEntity();
//        t1.setPhone(456);
//        t1.setName("123456");
//        System.out.println(JSON.parseObject(JSON.toJSONString(t1), TestEntityCopy.class));

//        System.out.println( t1 instanceof TestEntity);
//        System.out.println( !(t1 instanceof TestEntity));
//        System.out.println( (TestEntity.class.isInstance(t1) ));
//        System.out.println( !(TestEntity.class.isInstance(t1) ));


//        String _name="";
//        RespVo respVo=new RespVo();
//        respVo.setCode("13");
//        TestEntity entity=new TestEntity();
//        entity.setName("测试名称");
//        entity.setAge("132123");
//
//        List<TestEntity> list=new ArrayList<>();
//        list.add(entity);
//        respVo.setData(list);
//        System.out.println("list2.size()="+respVo.getData());
//
//        List<TestEntity> list2=JSON.parseArray(respVo.getData()+"",TestEntity.class);
//
//       System.out.println(list2.size());
//        CertificateInVO certificateInVO1=new CertificateInVO();
//        certificateInVO1.setBdcfzsj("1111");
//        certificateInVO1.setDjzt("2222");
//        CertificateInVO certificateInVO2=new CertificateInVO();
//        certificateInVO2.setFzzt("3333");
//        certificateInVO2.setHtbh("444");
//        BeanUtils.copyProperties(certificateInVO1,certificateInVO2);
//
//        System.out.println(JSON.toJSONString(certificateInVO2));
//
//
//        Calendar calendar=Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.HOUR_OF_DAY,10);
//        System.out.println(JSON.toJSONString(calendar.getTime()));
//        Date nowDate=new Date();
//        System.out.println(nowDate.compareTo(calendar.getTime()));
//        List<TestEntity> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            TestEntity entity = new TestEntity();
//            if (i % 2 == 1) {
//                entity.setName("測試人員" + i);
//            }
//            entity.setAmount(new BigDecimal(100));
//            list.add(entity);
//        }
//        TestEntity entity = new TestEntity();
//        entity.setName(null);
//        entity.setAmount(new BigDecimal(100));
//        list.remove(entity);
//        System.out.println(list.contains(entity));
//
//
//        setEntity(entity);
//        System.out.println(JSON.toJSONString(entity));

        // System.out.println(JSON.toJSONString(entity));
//        List<TestEntity> entityList=new ArrayList<>();
//        for(int i=0;i<20;i++){
//            TestEntity entity=new TestEntity();
//            entity.setAge(i+"");
//            if(i<3) {
//                entity.setName("i=" + i);
//            }
//            entityList.add(entity);
//        }
//
//        entityList=entityList.parallelStream().filter(x->x.getAge().contains("1")).collect(Collectors.toList());

//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        Date lastDate=simpleDateFormat.parse("2022-10-18");
//        Date nowDate=simpleDateFormat.parse(simpleDateFormat.format(new Date()));
//
//        System.out.println(nowDate.compareTo(lastDate));

        String name1="鲍中山";
        char[] chars = name1.toCharArray();
        StringBuilder middle = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i != 0 && i != (chars.length - 1)) {
                middle.append("*");
            }
        }
        String result11= chars[0] + middle.toString() + chars[chars.length - 1];
        System.out.println(result11);

        //        List<String> buyilType1=new ArrayList<>();
//        buyilType1.add("2");
//        buyilType1.add("3");
//        buyilType1.add("4");
//        buyilType1.add("5");
//        buyilType1.add("46");
//
//        boolean b = buyilType1.stream().anyMatch(x -> x.equals("2"));
//        Assert.isTrue(!b,"存在2");
        //        List<String> buyilType2=new ArrayList<>();
//        buyilType2.add("4");
//        buyilType2.add("4");

//        buyilType1.removeAll(buyilType2);

//        System.out.println(JSON.toJSONString(buyilType1));


    }

    private static void setEntity(TestEntity entity,Object list) {
        entity.setName("ceshi");
        entity.setAge("123");
    }
}
