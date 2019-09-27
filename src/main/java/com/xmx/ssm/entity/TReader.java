package com.xmx.ssm.entity;

public class TReader {
    private Integer bReaderId;

    private String bReaderNo;

    private String bReaderName;

    private String bReaderEmail;

    private String bReaderPassword;

    private Integer bReaderBorrowNumber;

    private Integer bReaderBorrowAlreadyNumber;

    private String bReaderBorrowTime;

    private String bReaderMoile;

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
        this.bReaderNo = bReaderNo == null ? null : bReaderNo.trim();
    }

    public String getbReaderName() {
        return bReaderName;
    }

    public void setbReaderName(String bReaderName) {
        this.bReaderName = bReaderName == null ? null : bReaderName.trim();
    }

    public String getbReaderEmail() {
        return bReaderEmail;
    }

    public void setbReaderEmail(String bReaderEmail) {
        this.bReaderEmail = bReaderEmail == null ? null : bReaderEmail.trim();
    }

    public String getbReaderPassword() {
        return bReaderPassword;
    }

    public void setbReaderPassword(String bReaderPassword) {
        this.bReaderPassword = bReaderPassword == null ? null : bReaderPassword.trim();
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

    public String getbReaderBorrowTime() {
        return bReaderBorrowTime;
    }

    public void setbReaderBorrowTime(String bReaderBorrowTime) {
        this.bReaderBorrowTime = bReaderBorrowTime == null ? null : bReaderBorrowTime.trim();
    }

    public String getbReaderMoile() {
        return bReaderMoile;
    }

    public void setbReaderMoile(String bReaderMoile) {
        this.bReaderMoile = bReaderMoile == null ? null : bReaderMoile.trim();
    }
}