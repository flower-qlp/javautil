package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.entity.vo.CertificateInVO;
import com.happy.javautil.entity.vo.CertificateInfoResponse;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
class JavautilApplicationTests {

    public static String str =
            "[\n" +
                    "        {\n" +
                    "            \"cfxx\": [\n" +
                    "                {\n" +
                    "                    \"cfdbrq\": \"2019-07-25 09:37:23\",\n" +
                    "                    \"cfdw\": \"靖江市人民法院\",\n" +
                    "                    \"cfwh\": \"(2019)苏1282民初4684号\",\n" +
                    "                    \"cfwj\": \"裁定书\",\n" +
                    "                    \"dqsj\": \"2022-07-23 00:00:00\",\n" +
                    "                    \"jfzh\": \"\",\n" +
                    "                    \"kssj\": \"2019-07-24 00:00:00\",\n" +
                    "                    \"slbh\": \"201907240088-1\",\n" +
                    "                    \"tstybm\": \"FC_12832\",\n" +
                    "                    \"zt\": \"历史\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"cfdbrq\": \"2019-08-26 14:35:01\",\n" +
                    "                    \"cfdw\": \"靖江市人民法院\",\n" +
                    "                    \"cfwh\": \"(2019)苏1282民初5951号\",\n" +
                    "                    \"cfwj\": \"裁定书\",\n" +
                    "                    \"dqsj\": \"2022-08-22 00:00:00\",\n" +
                    "                    \"jfzh\": \"\",\n" +
                    "                    \"kssj\": \"2019-08-23 00:00:00\",\n" +
                    "                    \"slbh\": \"201908230072-5\",\n" +
                    "                    \"tstybm\": \"FC_12832\",\n" +
                    "                    \"zt\": \"历史\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"cfdbrq\": \"2019-09-17 09:28:13\",\n" +
                    "                    \"cfdw\": \"靖江市人民法院\",\n" +
                    "                    \"cfwh\": \"（2019）苏1282民初6228号\",\n" +
                    "                    \"cfwj\": \"民事裁定书\",\n" +
                    "                    \"dqsj\": \"2022-09-15 00:00:00\",\n" +
                    "                    \"jfzh\": \"\",\n" +
                    "                    \"kssj\": \"2019-09-16 00:00:00\",\n" +
                    "                    \"slbh\": \"201909160074-3\",\n" +
                    "                    \"tstybm\": \"FC_12832\",\n" +
                    "                    \"zt\": \"历史\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"cfdbrq\": \"2019-09-17 10:03:50\",\n" +
                    "                    \"cfdw\": \"靖江市人民法院\",\n" +
                    "                    \"cfwh\": \"（2019）苏1282民初6230号之一\",\n" +
                    "                    \"cfwj\": \"裁定书\",\n" +
                    "                    \"dqsj\": \"2022-09-15 00:00:00\",\n" +
                    "                    \"jfzh\": \"\",\n" +
                    "                    \"kssj\": \"2019-09-16 00:00:00\",\n" +
                    "                    \"slbh\": \"201909160082-3\",\n" +
                    "                    \"tstybm\": \"FC_12832\",\n" +
                    "                    \"zt\": \"历史\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"cfdbrq\": \"2020-07-01 10:28:20\",\n" +
                    "                    \"cfdw\": \"靖江市人民法院\",\n" +
                    "                    \"cfwh\": \"(2020)苏1282执1767号\",\n" +
                    "                    \"cfwj\": \"裁定书\",\n" +
                    "                    \"dqsj\": \"2023-06-23 00:00:00\",\n" +
                    "                    \"jfzh\": \"\",\n" +
                    "                    \"kssj\": \"2020-06-24 00:00:00\",\n" +
                    "                    \"slbh\": \"202006240108-2\",\n" +
                    "                    \"tstybm\": \"FC_12832\",\n" +
                    "                    \"zt\": \"历史\"\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"cqzh\": \"苏(2021)靖江不动产权第0000982号\",\n" +
                    "            \"dh\": \"\",\n" +
                    "            \"djlx\": \"转移登记\",\n" +
                    "            \"djsj\": \"2021-01-13 17:39:39\",\n" +
                    "            \"dscs\": \"5\",\n" +
                    "            \"dyxx\": [\n" +
                    "                {\n" +
                    "                    \"dbfw\": \"详见抵押合同\",\n" +
                    "                    \"dbje\": \"4500000\",\n" +
                    "                    \"djlx\": \"抵押登记\",\n" +
                    "                    \"dydbrq\": \"2019-01-03 15:13:49\",\n" +
                    "                    \"jssj\": \"2021-12-29 00:00:00\",\n" +
                    "                    \"qlrlx\": \"抵押权人\",\n" +
                    "                    \"qssj\": \"2018-12-29 00:00:00\",\n" +
                    "                    \"slbh\": \"201812290074\",\n" +
                    "                    \"tstybm\": \"FC_12832\",\n" +
                    "                    \"txqh\": \"苏(2019)靖江不动产证明第0000053号\",\n" +
                    "                    \"txqr\": \"上海浦东发展银行股份有限公司泰州分行\",\n" +
                    "                    \"yyqh\": \"010100083653,靖国用(2010)第0012150039-1-2号,010100083654,010100083655\",\n" +
                    "                    \"zt\": \"历史\",\n" +
                    "                    \"zxslbh\": \"202012171048\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"dbfw\": \"\",\n" +
                    "                    \"dbje\": \"2250000\",\n" +
                    "                    \"djlx\": \"最高额抵押权登记              \",\n" +
                    "                    \"dydbrq\": \"2010-11-12 10:27:41\",\n" +
                    "                    \"jssj\": \"2013-11-03 00:00:00\",\n" +
                    "                    \"qlrlx\": \"抵押权人\",\n" +
                    "                    \"qssj\": \"2010-11-04 00:00:00\",\n" +
                    "                    \"slbh\": \"FC_101105105236-28510\",\n" +
                    "                    \"tstybm\": \"FC_12832\",\n" +
                    "                    \"txqh\": \"070100038667\",\n" +
                    "                    \"txqr\": \"龚祖修\",\n" +
                    "                    \"yyqh\": \"010100083653\",\n" +
                    "                    \"zt\": \"历史\",\n" +
                    "                    \"zxslbh\": \"\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"dbfw\": \"\",\n" +
                    "                    \"dbje\": \"1700000\",\n" +
                    "                    \"djlx\": \"最高额抵押权登记              \",\n" +
                    "                    \"dydbrq\": \"2015-12-25 09:58:56\",\n" +
                    "                    \"jssj\": \"2018-12-21 00:00:00\",\n" +
                    "                    \"qlrlx\": \"抵押权人\",\n" +
                    "                    \"qssj\": \"2015-12-21 15:35:00\",\n" +
                    "                    \"slbh\": \"FC_151221153515-324362\",\n" +
                    "                    \"tstybm\": \"FC_12832\",\n" +
                    "                    \"txqh\": \"070100097188\",\n" +
                    "                    \"txqr\": \"上海浦东发展银行股份有限公司靖江支行\",\n" +
                    "                    \"yyqh\": \"010100083653\",\n" +
                    "                    \"zt\": \"历史\",\n" +
                    "                    \"zxslbh\": \"201812290071\"\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"ftmj\": \"\",\n" +
                    "            \"fwbh\": \"FC_12832\",\n" +
                    "            \"fwjg\": \"\",\n" +
                    "            \"fwxz\": \"存量房\",\n" +
                    "            \"fwzl\": \"靖城镇骥江西路571号1幢\",\n" +
                    "            \"ghyt\": \"住宅\",\n" +
                    "            \"jcnd\": \"\",\n" +
                    "            \"jzmj\": \"412.35\",\n" +
                    "            \"qdfs\": \"买卖\",\n" +
                    "            \"qlrmc\": \"陈燕,王钲,陈泽宇\",\n" +
                    "            \"sfzh\": \"321282198608083826,321282198702090838,321282201105290019\",\n" +
                    "            \"syqdjxx\": [\n" +
                    "                {\n" +
                    "                    \"djlx\": \"新建原始房屋登记(初始登记)                  \",\n" +
                    "                    \"dprq\": \"2010-09-16 00:00:00\",\n" +
                    "                    \"gyfe\": \"\",\n" +
                    "                    \"gyqk\": \"单独所有\",\n" +
                    "                    \"qlr\": \"江鸿臻\",\n" +
                    "                    \"qzhm\": \"010100083653\",\n" +
                    "                    \"slbh\": \"FC_100831154412-79397\",\n" +
                    "                    \"ywlx\": \"新建原始房屋登记(初始登记)                  \",\n" +
                    "                    \"zt\": \"历史\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"djlx\": \"变更登记\",\n" +
                    "                    \"dprq\": \"2020-12-21 15:51:10\",\n" +
                    "                    \"gyfe\": \"\",\n" +
                    "                    \"gyqk\": \"单独所有\",\n" +
                    "                    \"qlr\": \"江鸿臻\",\n" +
                    "                    \"qzhm\": \"苏(2020)靖江不动产权第0036063号\",\n" +
                    "                    \"slbh\": \"202012171277-1\",\n" +
                    "                    \"ywlx\": \"变更\",\n" +
                    "                    \"zt\": \"历史\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"djlx\": \"转移登记\",\n" +
                    "                    \"dprq\": \"2021-01-13 17:39:39\",\n" +
                    "                    \"gyfe\": \"5%,5%,90%\",\n" +
                    "                    \"gyqk\": \"按份共有,按份共有,按份共有\",\n" +
                    "                    \"qlr\": \"陈燕,王钲,陈泽宇\",\n" +
                    "                    \"qzhm\": \"苏(2021)靖江不动产权第0000982号\",\n" +
                    "                    \"slbh\": \"202101130242\",\n" +
                    "                    \"ywlx\": \"买卖\",\n" +
                    "                    \"zt\": \"现势\"\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"syqx\": \"40年\",\n" +
                    "            \"tdxz\": \"出让\",\n" +
                    "            \"tdyt\": \"商住\",\n" +
                    "            \"tnmj\": \"\",\n" +
                    "            \"tstybm\": \"FC_12832\",\n" +
                    "            \"yyxx\": [],\n" +
                    "            \"zt\": \"现势\"\n" +
                    "        }\n" +
                    "    ]";

    private String info = "{\"fwhyinfo\":{\"allHousingRegisterCode\":\"200412199,044135\",\"code\":\"200\",\"dissent\":\"0\",\"errormsg\":\"不动产接口不通.\"," +
            "\"fwinfo\":[{\"LandAcqMethod\":\"\",\"LandAcquisiteMethod\":\"\",\"actualArea\":\"35.70\",\"buildingName\":\"瑞祥花苑\",\"buildingStructure\":\"混合\"," +
            "\"floor\":\"1\",\"houseType\":\"商业用房\",\"innerconsArea\":\"35.70\",\"planningPurpose\":\"营业\",\"position\":\"繁荣路18号瑞祥花苑综合楼10室\"," +
            "\"projectName\":\"瑞祥花苑\",\"roomName\":\"10\",\"shareconsArea\":\"\",\"stopLandUseDate\":\"\",\"unitName\":\"\",\"yearBuiltHouses\":\"\"}]," +
            "\"isLease\":\"0\",\"isMortgage\":\"0\",\"keycode\":\"2004092021020\",\"limitState\":\"0\",\"otherRemark\":\"\"," +
            "\"qlrinfo\":[{\"JointShare\":\"\",\"JointTypeName\":\"共同共有\",\"poContactNo\":\"\",\"poIdCardNo\":\"320724197008122746\",\"poIdCardTypeName\":\"身份证\",\"ponationalityName\":\"中国\",\"propertyOwner\":\"王兆俊\"}," +
            "{\"JointShare\":\"\",\"JointTypeName\":\"共同共有\",\"poContactNo\":\"\",\"poIdCardNo\":\"320822197212132733\",\"poIdCardTypeName\":\"身份证\",\"ponationalityName\":\"中国\",\"propertyOwner\":\"倪庆华\"}," +
            "{\"JointShare\":\"\",\"JointTypeName\":\"共同共有\",\"poContactNo\":\"\",\"poIdCardNo\":\"320821197206027156\",\"poIdCardTypeName\":\"身份证\",\"ponationalityName\":\"中国\",\"propertyOwner\":\"包红军\"}," +
            "{\"JointShare\":\"\",\"JointTypeName\":\"共同共有\",\"poContactNo\":\"\",\"poIdCardNo\":\"320821196812111708\",\"poIdCardTypeName\":\"身份证\",\"ponationalityName\":\"中国\",\"propertyOwner\":\"左红梅\"}]," +
            "\"qzinfo\":[{\"JointTypeName\":\"0.00\",\"ProRightCerIssuedTime\":\"2004-09-20 00:00:00\",\"ProRightCerTypeName\":\"共有权证\",\"propertyOwner\":\"倪庆华 王兆俊\",\"titleCertificateCode\":\"044135\"}," +
            "{\"JointTypeName\":\"0.00\",\"ProRightCerIssuedTime\":\"2004-09-20 00:00:00\",\"ProRightCerTypeName\":\"所有权证\",\"propertyOwner\":\"包红军 左红梅\",\"titleCertificateCode\":\"200412199\"}]," +
            "\"rentinfo\":[{\"contracteeCode\":\"\",\"leaseRegistrationTime\":\"\",\"lessee\":\"\",\"tenantTermB\":\"\",\"tenantTermE\":\"\"}]}" +
            "}";

    public static String mssage = "{\"ycqzh\":\"原产权证号\",\"xcqzh\":\"新产权证号\",\"htbh\":\"合同编号\",\"bdcfzsj\":\"2021-12-12 12:12:12\",\"fzzt\":\"2\"," +
            "\"djzt\":\"1\",\"txqzh\":\"他项权证号\",\"txqzhfzsj\":\"2020-12-12 12:12:12\"}";

    public static Object szStr="{\"msg\":\"0\",\"code\":\"0\",\"data\":\"[{\"bdcfzsj\":\"2012-02-29 00:00:00.0\",\"djzt\":\"现势\",\"fzzt\":\"现势\",\"htbh\":\"\",\"txqzh\":\"\",\"txqzhfzsj\":\"\",\"xcqzh\":\"010100113020,010100113021\",\"ycqzh\":\"010100113020,010100113021\"}]\"}";
    @Test
    void contextLoads() {
//        List<TestEntity> list=new ArrayList<>();
//        TestEntity entity=new TestEntity();
//        entity.setAge("01");
//        entity.setName("01");
//        list.add(entity);
//        list.add(entity);
//        list.add(entity);
//        list.add(entity);
//        List<TestEntity> newList=list.parallelStream().map(x->new TestEntity(x)).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(newList));

    }


    public static void main(String[] args) {

        CertificateInfoResponse response = JSON.parseObject(JSON.toJSONString(szStr), CertificateInfoResponse.class);
        CertificateInVO data = null;
        if (null != response.getData()) {
            List<CertificateInVO> listVo = JSON.parseArray(JSON.toJSONString(response.getData()), CertificateInVO.class);
            data = listVo.get(0);
        }
        System.out.println("-------------");

//          String mssage="{\"ycqzh\":\"原产权证号\",\"xcqzh\":\"新产权证号\",\"htbh\":\"合同编号\",\"bdcfzsj\":\"2021-12-12 12:12:12\",\"fzzt\":\"2\"," +
//                "\"djzt\":\"1\",\"txqzh\":\"他项权证号\",\"txqzhfzsj\":\"2020-12-12 12:12:12\"}";
//             System.out.println(JSON.toJSONString(mssage));

//        List<String> houseCodeList = Arrays.asList("0","1","2","3","4","5");
//
//        int num = houseCodeList.size() / 3;
//        System.out.println(num);
//        for (int i = 0; i <=num; i++) {
//            int start = 3*i;
//            int end = 3 * (i + 1) > houseCodeList.size() ? houseCodeList.size() : 3 * (i + 1);
//            System.out.println(start+"--"+end);
//            List<String> childList = houseCodeList.subList(start, end);
//            System.out.println(JSON.toJSONString(childList));
//        }


//        Map<String,String> map=new HashMap<>();
//        setMap(map,"test", BigDecimal.ZERO);
//        setMap(map,"test1", "BigDecimal.ZERO");
//        System.out.println(map.get("test"));
//        System.out.println(map.get("test1"));
//        System.out.println(map.get("test2"));
//        char charStr = (char) Math.round(Math.random() * 25 + 65);
//        String name="111122233344556wwweerrt1234";
//        char[] charArr= name.toCharArray();
//        charArr[charArr.length-1]=charStr;
//        String names=org.apache.commons.lang3.StringUtils.join(Arrays.asList(charArr),"");
//        System.out.println(names);

        String name="123456 \n" +
                "6wwweerrt1234";
        System.out.println(name);
    }

    public static void setMap(Map<String, String> map, String key, Object value) {
        if (value instanceof String) {
            map.put(key, (String) value);
        }
        if (value instanceof BigDecimal) {
            BigDecimal newVale = new BigDecimal(String.valueOf(value));
            synchronized (map) {
                String oldVale = map.get(key);
                if (StringUtils.isBlank(oldVale)) {
                    map.put(key, value.toString());
                } else {
                    BigDecimal result = new BigDecimal(String.valueOf(value)).add(new BigDecimal(oldVale));
                    map.put(key, result.toString());
                }
            }
        }

    }

}
