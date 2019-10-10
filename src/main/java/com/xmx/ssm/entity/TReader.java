package com.xmx.ssm.entity;

import java.util.Date;

public class TReader {
    private Integer bReaderId;

    private String bReaderNo;

    private String bReaderName;

    private String bReaderEmail;

    private String bReaderPassword;

    private Integer bReaderBorrowNumber;

    private Integer bReaderBorrowAlreadyNumber;

    private Date bReaderBorrowTime;

    private String bReaderMobile;

    private String bReaderRemarks;

    public Integer getbReaderId() {
        return bReaderId;
    }

    public void setbReaderId(Integer bReaderId) {
        this.bReaderId = bReaderId;
    }

    public String getbReaderNo() {
        return bReaderNo;
    }

    public void setbReaderNo(String bReaderNo) {
        this.bReaderNo = bReaderNo;
    }

    public String getbReaderName() {
        return bReaderName;
    }

    public void setbReaderName(String bReaderName) {
        this.bReaderName = bReaderName;
    }

    public String getbReaderEmail() {
        return bReaderEmail;
    }

    public void setbReaderEmail(String bReaderEmail) {
        this.bReaderEmail = bReaderEmail;
    }

    public String getbReaderPassword() {
        return bReaderPassword;
    }

    public void setbReaderPassword(String bReaderPassword) {
        this.bReaderPassword = bReaderPassword;
    }

    public Integer getbReaderBorrowNumber() {
        return bReaderBorrowNumber;
    }

    public void setbReaderBorrowNumber(Integer bReaderBorrowNumber) {
        this.bReaderBorrowNumber = bReaderBorrowNumber;
    }

    public Integer getbReaderBorrowAlreadyNumber() {
        return bReaderBorrowAlreadyNumber;
    }

    public void setbReaderBorrowAlreadyNumber(Integer bReaderBorrowAlreadyNumber) {
        this.bReaderBorrowAlreadyNumber = bReaderBorrowAlreadyNumber;
    }

    public Date getbReaderBorrowTime() {
        return bReaderBorrowTime;
    }

    public void setbReaderBorrowTime(Date bReaderBorrowTime) {
        this.bReaderBorrowTime = bReaderBorrowTime;
    }

    public String getbReaderMobile() {
        return bReaderMobile;
    }

    public void setbReaderMobile(String bReaderMobile) {
        this.bReaderMobile = bReaderMobile;
    }

    public String getbReaderRemarks() {
        return bReaderRemarks;
    }

    public void setbReaderRemarks(String bReaderRemarks) {
        this.bReaderRemarks = bReaderRemarks;
    }
}