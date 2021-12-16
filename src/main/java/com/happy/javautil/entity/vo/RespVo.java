package com.happy.javautil.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespVo {

    private String code;

    private String msg;

    private Object data;
}
