package com.happy.javautil.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class BaseVo
{
    @NotBlank(message = "主键不可以为空")
    private String id;

    private Date createDate;
}
