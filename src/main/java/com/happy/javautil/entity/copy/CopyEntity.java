package com.happy.javautil.entity.copy;

public class CopyEntity extends BaseEntity{

    private Long copyId;

    private Long extendId;

    private String extendName;

    private Long extend1Id;

    public Long getCopyId() {
        return copyId;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }

    public Long getExtendId() {
        return extendId;
    }

    public void setExtendId(Long extendId) {
        this.extendId = extendId;
    }

    public String getExtendName() {
        return extendName;
    }

    public void setExtendName(String extendName) {
        this.extendName = extendName;
    }

    public Long getExtend1Id() {
        return extend1Id;
    }

    public void setExtend1Id(Long extend1Id) {
        this.extend1Id = extend1Id;
    }
}
