package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.entity.TestEntity;
import com.happy.javautil.entity.vo.CertificateInVO;
import com.happy.javautil.entity.vo.RespVo;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.stream.Collectors;

@SpringBootTest
public class EntityTest {

    public static void main(String[] args) {

        TestEntity t1=new TestEntity();

        System.out.println( t1 instanceof TestEntity);
        System.out.println( !(t1 instanceof TestEntity));
        System.out.println( (TestEntity.class.isInstance(t1) ));
        System.out.println( !(TestEntity.class.isInstance(t1) ));



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
        List<TestEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestEntity entity = new TestEntity();
            if (i % 2 == 1) {
                entity.setName("測試人員" + i);
            }
            entity.setAmount(new BigDecimal(100));
            list.add(entity);
        }
        TestEntity entity = new TestEntity();
        entity.setName(null);
        entity.setAmount(new BigDecimal(100));
        list.remove(entity);
        System.out.println(list.contains(entity));


        setEntity(entity);
        System.out.println(JSON.toJSONString(entity));

        // System.out.println(JSON.toJSONString(entity));
//        List<TestEntity> entityList=new ArrayList<>();
//        for(int i=0;i<20;i++){
//            TestEntity entity=new TestEntity();
//            entity.setAge(i+"");
//            entity.setName("i="+i);
//            entityList.add(entity);
//        }
//        entityList=entityList.parallelStream().filter(x->x.getAge().contains("1")).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(entityList));
    }

    private static void setEntity(TestEntity entity) {
        entity.setName("ceshi");
        entity.setAge("123");
    }
}
