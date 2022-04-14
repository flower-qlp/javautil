package com.happy.javautil.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HouseGroupVo {

    private String buildingId;

    private String buildingECode;

    private String purpose;

    private String completedDtlCode;

    private BigDecimal actualArea;

    private BigDecimal totalCount;

    private BigDecimal contractStateCount;

}
