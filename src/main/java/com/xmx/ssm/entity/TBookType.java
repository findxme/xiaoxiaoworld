package com.xmx.ssm.entity;

public class TBookType {
    private Integer bBookTypeId;

    private String bBookTypeNo;

    private String bBookType;

    public Integer getbBookTypeId() {
        return bBookTypeId;
    }

    public void setbBookTypeId(Integer bBookTypeId) {
        this.bBookTypeId = bBookTypeId;
    }

    public String getbBookTypeNo() {
        return bBookTypeNo;
    }

    public void setbBookTypeNo(String bBookTypeNo) {
        this.bBookTypeNo = bBookTypeNo == null ? null : bBookTypeNo.trim();
    }

    public String getbBookType() {
        return bBookType;
    }

    public void setbBookType(String bBookType) {
        this.bBookType = bBookType == null ? null : bBookType.trim();
    }
}