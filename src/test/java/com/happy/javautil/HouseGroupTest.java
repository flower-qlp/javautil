package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.entity.HouseGroupVo;

public class HouseGroupTest {
    
    public static void main(String[] args) {
        HouseGroupVo houseGroupVo=new HouseGroupVo();
        houseGroupVo.setBuildingId("123456");
        houseGroupVo.setPurpose("456");
        houseGroupVo.setCompletedDtlCode("789456");
    
        System.out.printf(JSON.toJSONString(houseGroupVo));
        
        
    }
}
