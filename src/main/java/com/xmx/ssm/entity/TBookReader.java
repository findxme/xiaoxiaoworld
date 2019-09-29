package com.xmx.ssm.entity;

import java.util.Date;

public class TBookReader {
    private Integer bBookReaderId;

    private String bBookNo;

    private String bReaderNo;

    private String bUserNo;

    private Date bBorrowDate;

    private Date bReturnDate;

    private Integer bOverDate;

    private String isReturnBook;

    private Integer bRenewFrequency;

    private Integer bRenewTime;

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

    public String getbUserNo() {
        return bUserNo;
    }

    public void setbUserNo(String bUserNo) {
        this.bUserNo = bUserNo == null ? null : bUserNo.trim();
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

    public String getIsReturnBook() {
        return isReturnBook;
    }

    public void setIsReturnBook(String isReturnBook) {
        this.isReturnBook = isReturnBook == null ? null : isReturnBook.trim();
    }

    public Integer getbRenewFrequency() {
        return bRenewFrequency;
    }

    public void setbRenewFrequency(Integer bRenewFrequency) {
        this.bRenewFrequency = bRenewFrequency;
    }

    public Integer getbRenewTime() {
        return bRenewTime;
    }

    public void setbRenewTime(Integer bRenewTime) {
        this.bRenewTime = bRenewTime;
    }
}