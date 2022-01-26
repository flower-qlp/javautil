package com.happy.javautil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
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
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put("examineAndVerify", "1");
        list.add(param);
        Integer Deleted = 1;
        long count = list.parallelStream()
                .map(x -> null == x.get("examineAndVerify") ? "" : String.valueOf(x.get("examineAndVerify")))
                .filter(y -> y.equals(Deleted))
                .count();
        for (Map<String, Object> map : list) {
            String examineAndVerify = null == map.get("examineAndVerify") ? "" : String.valueOf(map.get("examineAndVerify"));
            if (examineAndVerify.equals("1")) {
                System.out.println("count=" + 1);
            }
        }
        System.out.println("count=" + count);
    }
}
