package com.xmx.ssm.entity;

import java.util.Date;

public class TBook {
    private Integer bBookId;

    private String bBookNo;

    private String bBookName;

    private String bBookAuthor;

    private Integer bBookNumber;

    private String bBookType;

    private Date bBookCreatedate;

    private Date bStopDate;

    public Integer getbBookId() {
        return bBookId;
    }

    public void setbBookId(Integer bBookId) {
        this.bBookId = bBookId;
    }

    public String getbBookNo() {
        return bBookNo;
    }

    public void setbBookNo(String bBookNo) {
        this.bBookNo = bBookNo == null ? null : bBookNo.trim();
    }

    public String getbBookName() {
        return bBookName;
    }

    public void setbBookName(String bBookName) {
        this.bBookName = bBookName == null ? null : bBookName.trim();
    }

    public String getbBookAuthor() {
        return bBookAuthor;
    }

    public void setbBookAuthor(String bBookAuthor) {
        this.bBookAuthor = bBookAuthor == null ? null : bBookAuthor.trim();
    }

    public Integer getbBookNumber() {
        return bBookNumber;
    }

    public void setbBookNumber(Integer bBookNumber) {
        this.bBookNumber = bBookNumber;
    }

    public String getbBookType() {
        return bBookType;
    }

    public void setbBookType(String bBookType) {
        this.bBookType = bBookType == null ? null : bBookType.trim();
    }

    public Date getbBookCreatedate() {
        return bBookCreatedate;
    }

    public void setbBookCreatedate(Date bBookCreatedate) {
        this.bBookCreatedate = bBookCreatedate;
    }

    public Date getbStopDate() {
        return bStopDate;
    }

    public void setbStopDate(Date bStopDate) {
        this.bStopDate = bStopDate;
    }
}