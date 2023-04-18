package com.happy.javautil.entity;

import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.math.BigDecimal;

@Data
public class HouseGroupVo implements Externalizable {

    private transient String buildingId;

    private String buildingECode;

    private String purpose;

    private String completedDtlCode;

    private BigDecimal actualArea;

    private BigDecimal totalCount;

    private BigDecimal contractStateCount;
    
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(buildingId);
        out.writeObject(buildingECode);
        out.writeObject(purpose);
    }
    
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Object o = in.readObject();
        
    }
}
