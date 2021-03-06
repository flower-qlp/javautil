package com.happy.javautil.entity;


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
public class TestEntity extends BaseEntity {

    @NotBlank(message = "姓名不能为空！")
    private String name;
    @NotBlank(message = "年龄！")
    private String age;

    @NotNull(message = "手机号不能为空")
    private Integer phone;

    private BigDecimal amount;

    private Long id;

    private Integer sex;

    private Long htbh;

    private String theState;

    private Date createTime;

    private List<String> codes;

    @Search(columnName = "column_name1,column_name1", compare = "like", preStr = "%", afterStr = "%")
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
        TestEntity target = (TestEntity) obj;
        return Optional.ofNullable(target.getName()).orElse("").equals(Optional.ofNullable(this.name).orElse(""));
    }

    public TestEntity() {
    }

    public TestEntity(String name, String age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public TestEntity(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
        this.id = 123456L;
    }

    public TestEntity(TestEntity t) {
        this.name = t.getName();
        this.age = String.valueOf(Integer.valueOf(t.getAge()));
    }

}
