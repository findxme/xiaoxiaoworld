package com.xmx.ssm.entity;

import java.util.Date;

public class TBookReader {
    private Integer bBookReaderId;

    private String bBookNo;

    private String bReaderNo;

    private Date bBorrowDate;

    private Date bReturnDate;

    private Integer bOverDate;

    public Integer getbBookReaderId() {
        return bBookReaderId;
    }

    public void setbBookReaderId(Integer bBookReaderId) {
        this.bBookReaderId = bBookReaderId;
    }

    public String getbBookNo() {
        return bBookNo;
    }

    public void setbBookNo(String bBookNo) {
        this.bBookNo = bBookNo == null ? null : bBookNo.trim();
    }

    public String getbReaderNo() {
        return bReaderNo;
    }

    public void setbReaderNo(String bReaderNo) {
        this.bReaderNo = bReaderNo == null ? null : bReaderNo.trim();
    }

    public Date getbBorrowDate() {
        return bBorrowDate;
    }

    public void setbBorrowDate(Date bBorrowDate) {
        this.bBorrowDate = bBorrowDate;
    }

    public Date getbReturnDate() {
        return bReturnDate;
    }

    public void setbReturnDate(Date bReturnDate) {
        this.bReturnDate = bReturnDate;
    }

    public Integer getbOverDate() {
        return bOverDate;
    }

    public void setbOverDate(Integer bOverDate) {
        this.bOverDate = bOverDate;
    }
}