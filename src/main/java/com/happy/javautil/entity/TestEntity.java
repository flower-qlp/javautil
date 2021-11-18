package com.happy.javautil.entity;


import com.happy.javautil.annotation.ApiByToken;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public class TestEntity {

    @NotBlank(message = "姓名不能为空！")
    @ApiByToken(isCheck = true)
    private String name;
    @NotBlank(message = "年龄！")
    private String age;

    @NotNull(message = "手机号不能为空")
    private Integer phone;

    @ApiByToken(isCheck = true)
    private BigDecimal amount;


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

    public TestEntity(TestEntity t) {
        this.name = t.getName();
        this.age = String.valueOf(Integer.valueOf(t.getAge()));
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
