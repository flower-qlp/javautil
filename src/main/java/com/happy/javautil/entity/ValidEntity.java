package com.happy.javautil.entity;

import com.happy.javautil.entity.vo.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author happy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidEntity extends BaseVo {

    private String productCode;

    @NotNull(message = "名称等于空了！")
    private String productName;

    private BigDecimal price;

    @Max(value = 12)
    private Integer number;

    private Boolean enable;

    private TestEntity testEntity;

    public void init() {
        this.productCode = "";
        this.productName = "";
        this.price = BigDecimal.ZERO;
        this.number = 0;
        this.enable = false;
        this.testEntity = new TestEntity();
    }

}
