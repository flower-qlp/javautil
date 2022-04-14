package com.happy.javautil.entity;


import com.happy.javautil.annotation.ApiByToken;
import com.happy.javautil.annotation.Search;
import com.happy.javautil.entity.copy.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
public class TestEntityCopy extends BaseEntity {

    @NotBlank(message = "姓名不能为空！")
    @ApiByToken(isCheck = true)
    private String name;
    @NotBlank(message = "年龄！")
    private Integer age;

    @NotNull(message = "手机号不能为空")
    private Integer phone;

    @ApiByToken(isCheck = true)
    private BigDecimal amount;

    private Long id;

    private Integer sex;

    private Long htbh;

    private List<String> codes;

    @Search(columnName = "column1,column2,column3,column4",compare = "like",preStr = "%",afterStr = "%",tableName = "table")
    private String fzzt;


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String || obj instanceof BigDecimal || obj instanceof Date) {
            return super.equals(obj);
        }
        TestEntityCopy target = (TestEntityCopy) obj;
        return Optional.ofNullable(target.getName()).orElse("").equals(Optional.ofNullable(this.name).orElse(""));
    }

    public TestEntityCopy() {
    }

}
