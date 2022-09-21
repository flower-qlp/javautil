package com.happy.javautil.entity.copy;

import java.util.HashMap;
import java.util.Map;

public class BaseEntity {

    private Long baseId;

    private String baseName;

    private String baseCode;

    private Map params;

    public Map getParams() {
        if (null == params) {
            System.out.println("-----");
            params = new HashMap();
        }
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }
}
