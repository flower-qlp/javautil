package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.entity.vo.RentSyjEnclosureInfoApi;
import com.happy.javautil.entity.vo.RentSyjImgApi;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JAVA {
    
    public static void main(String[] args) {
        
        RentSyjEnclosureInfoApi enclosureInfo = new RentSyjEnclosureInfoApi();
        
        RentSyjImgApi rentSyjImgApi = new RentSyjImgApi();
        rentSyjImgApi.setUrl("123456123");
        enclosureInfo.setDegreeCertArray(Collections.singletonList(rentSyjImgApi));
    
        RentSyjImgApi rentSyjImgApi2 = new RentSyjImgApi();
        rentSyjImgApi2.setUrl("5656");
        enclosureInfo.setLaborContractArray(Collections.singletonList(rentSyjImgApi2));
        
        Field[] declaredFields = enclosureInfo.getClass().getDeclaredFields();
        Arrays.asList(declaredFields).forEach(field -> {
            String name = field.getName();
            Class<?> type = field.getType();
            if (List.class != type) {
                return;
            }
            String head = name.substring(0, 1).toUpperCase();
            try {
                Method method = enclosureInfo.getClass().getMethod("get" + head + name.substring(1));
                Object invoke = method.invoke(enclosureInfo);
                if (null == invoke) {
                    return;
                }
                List<RentSyjImgApi> rentSyjImgApis = JSON.parseArray(JSON.toJSONString(invoke), RentSyjImgApi.class);
                System.out.printf(JSON.toJSONString(rentSyjImgApis));
    
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        
        //        String vasslue=null;
        //
        //        try{
        ////            int i = 1/0;
        //            Integer integer=Integer.parseInt(vasslue);
        //        }catch (Exception e){
        //            throw new RuntimeException("报错",e);
        //        }
        //        String value="0,2,3,4";
        //        List<Long> collect = Stream.of(value.split(",")).map(x -> Long.valueOf(x)).collect(Collectors.toList());
        //        Long[] arr=new Long[collect.size()];
        //        collect.toArray(arr);
        //        System.out.println(JSON.toJSONString(arr));
        
        //        Calendar calendar = Calendar.getInstance();
        //        calendar.setTime(new Date());
        //        calendar.add(Calendar.DAY_OF_YEAR, -Integer.parseInt("2"));
        //        Date date = calendar.getTime();
        //        System.out.println(JSON.toJSONString(date));
        
        //        List<String> list=new ArrayList<>();
        //        list.add("1");
        //        list.add("2");
        //        list.add("3");
        //        list.add("4");
        //
        //        String[] arr=new String[4];
        //        list.toArray(arr);
        //
        //        System.out.println(JSON.toJSONString(arr));
        
        //        Map<String,String> map1=new HashMap<>();
        //        Map<String,String> map2=new HashMap<>();
        //        System.out.println(map1.get(map2.get("1")));
        //        String value=null;
        ////        String[] split = value.split("<<");
        //        System.out.println(Optional.ofNullable(value).orElse("").toUpperCase());
    }
    
    public static final List<String> INIT_CREATE = Arrays.asList("setExtendName");
    
    public static <T> T initBaseEntity(Object o, Class<T> tClass, List<String> attributes) {
        T t = JSON.parseObject(JSON.toJSONString(o), tClass);
        try {
            for (String attribute : attributes) {
                String substring = "g" + attribute.substring(1);
                Method getMethod = t.getClass().getMethod(substring);
                Class<?> returnType = getMethod.getReturnType();
                Method method = t.getClass().getMethod(attribute, returnType);
                method.invoke(t, defaultValue(attribute));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    
    public static Object defaultValue(String attribute) {
        switch (attribute) {
            case "setTheState":
                System.out.println("setExtendName");
                return "0";
            case "setExtendName":
                System.out.println("setExtendName");
                return "dasdasdasdadasd";
            case "setExtend1Number":
                System.out.println("setExtendName");
                return 1;
            default:
                break;
        }
        return "";
    }
    
}
