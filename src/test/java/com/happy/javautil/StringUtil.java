package com.happy.javautil;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.entity.HouseGroupVo;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
public class StringUtil {

    static String str = "[{\"actualArea\":348.99,\"buildingECode\":\"LZ6512\",\"buildingId\":\"E0DF49F7B3B74B61BDC63485E7AD0AD7\",\"completedDtlCode\":\"XMSPDTL0309019560655301\",\"contractStateCount\":0,\"totalCount\":1},{\"actualArea\":460.4,\"buildingECode\":\"LZ6393\",\"buildingId\":\"039F182FF12A410E9FC7BBDBF56D1582\",\"completedDtlCode\":\"XMSPDTL0309015405272401\",\"contractStateCount\":4,\"purpose\":\"036\",\"totalCount\":4},{\"actualArea\":141.22,\"buildingECode\":\"LZ6512\",\"buildingId\":\"E0DF49F7B3B74B61BDC63485E7AD0AD7\",\"completedDtlCode\":\"XMSPDTL0309019560655301\",\"contractStateCount\":0,\"purpose\":\"009\",\"totalCount\":11},{\"actualArea\":8622.5,\"buildingECode\":\"LZ6393\",\"buildingId\":\"039F182FF12A410E9FC7BBDBF56D1582\",\"completedDtlCode\":\"XMSPDTL0309015405272401\",\"contractStateCount\":38,\"purpose\":\"001\",\"totalCount\":60},{\"actualArea\":328.2,\"buildingECode\":\"LZ6393\",\"buildingId\":\"039F182FF12A410E9FC7BBDBF56D1582\",\"completedDtlCode\":\"XMSPDTL0309015405272401\",\"contractStateCount\":0,\"totalCount\":1},{\"actualArea\":8622.5,\"buildingECode\":\"LZ6512\",\"buildingId\":\"E0DF49F7B3B74B61BDC63485E7AD0AD7\",\"completedDtlCode\":\"XMSPDTL0309019560655301\",\"contractStateCount\":43,\"purpose\":\"001\",\"totalCount\":60},{\"actualArea\":460.4,\"buildingECode\":\"LZ6512\",\"buildingId\":\"E0DF49F7B3B74B61BDC63485E7AD0AD7\",\"completedDtlCode\":\"XMSPDTL0309019560655301\",\"contractStateCount\":2,\"purpose\":\"036\",\"totalCount\":4},{\"actualArea\":161.98,\"buildingECode\":\"LZ6393\",\"buildingId\":\"039F182FF12A410E9FC7BBDBF56D1582\",\"completedDtlCode\":\"XMSPDTL0309015405272401\",\"contractStateCount\":0,\"purpose\":\"009\",\"totalCount\":12},{\"actualArea\":36.14,\"buildingECode\":\"LZ6393\",\"buildingId\":\"039F182FF12A410E9FC7BBDBF56D1582\",\"completedDtlCode\":\"XMSPDTL0309015405272401\",\"contractStateCount\":0,\"purpose\":\"023\",\"totalCount\":1},{\"actualArea\":36.14,\"buildingECode\":\"LZ6512\",\"buildingId\":\"E0DF49F7B3B74B61BDC63485E7AD0AD7\",\"completedDtlCode\":\"XMSPDTL0309019560655301\",\"contractStateCount\":0,\"purpose\":\"023\",\"totalCount\":1}]";

    public static void main(String[] args) {
        List<HouseGroupVo> houseGroupVos = JSON.parseArray(str, HouseGroupVo.class);

        Map<String, BigDecimal> totalActualAreaMap = houseGroupVos.parallelStream()
                .collect(Collectors.groupingBy(HouseGroupVo::getCompletedDtlCode,
                        Collectors.mapping(HouseGroupVo::getActualArea, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));

        Map<String, Map<String, BigDecimal>> purposeMap = houseGroupVos.parallelStream()
                .collect(Collectors.groupingBy(HouseGroupVo::getCompletedDtlCode,
                        Collectors.groupingBy(x -> Optional.ofNullable(x.getPurpose()).orElse("-"),
                                Collectors.mapping(HouseGroupVo::getActualArea, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)))));

        Map<String, BigDecimal> totalCountMap = houseGroupVos.stream()
                .collect(Collectors.groupingBy(HouseGroupVo::getCompletedDtlCode,
                        Collectors.mapping(HouseGroupVo::getTotalCount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));

        Map<String, BigDecimal> saleMap = houseGroupVos.stream()
                .collect(Collectors.groupingBy(HouseGroupVo::getCompletedDtlCode,
                        Collectors.mapping(HouseGroupVo::getContractStateCount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));

        Map<String, Map<String, BigDecimal>> contractByPurposeMap = houseGroupVos.parallelStream()
                .collect(Collectors.groupingBy(HouseGroupVo::getCompletedDtlCode,
                        Collectors.groupingBy(x -> Optional.ofNullable(x.getPurpose()).orElse("-"),
                                Collectors.mapping(HouseGroupVo::getContractStateCount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)))));

        Map<String, String> buildingCodeMap = houseGroupVos.parallelStream()
                .collect(Collectors.toMap(HouseGroupVo::getCompletedDtlCode,
                        HouseGroupVo::getBuildingECode, (s1, s2) -> s2));

        List<String> buildingECodes = houseGroupVos.parallelStream().map(HouseGroupVo::getBuildingECode).collect(Collectors.toList());
        Map<String, String> idCodeMap = houseGroupVos.parallelStream()
                .collect(Collectors.toMap(HouseGroupVo::getBuildingId, HouseGroupVo::getBuildingECode, (s1, s2) -> s2));
    }

}
