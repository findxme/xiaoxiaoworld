package com.xmx.ssm.entity;

public class TReader {
    private Integer bReaderId;

    private String bReaderNo;

    private String bReaderName;

    private String bReaderEmail;

    private String bReaderPassword;

    private Integer bReaderBorrowNumber;

    private Integer bReaderBorrowAlreadyNumber;

    private Double bReaderBorrowTime;

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
        this.bReaderNo = bReaderNo == null ? null : bReaderNo.trim();
    }

    public String getbReaderName() {
        return bReaderName;
    }

    @Override
    public String toString() {
        return "TReader{" +
                "bReaderId=" + bReaderId +
                ", bReaderNo='" + bReaderNo + '\'' +
                ", bReaderName='" + bReaderName + '\'' +
                ", bReaderEmail='" + bReaderEmail + '\'' +
                ", bReaderPassword='" + bReaderPassword + '\'' +
                ", bReaderBorrowNumber=" + bReaderBorrowNumber +
                ", bReaderBorrowAlreadyNumber=" + bReaderBorrowAlreadyNumber +
                ", bReaderBorrowTime=" + bReaderBorrowTime +
                ", bReaderMobile='" + bReaderMobile + '\'' +
                ", bReaderRemarks='" + bReaderRemarks + '\'' +
                '}';
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

    public Double getbReaderBorrowTime() {
        return bReaderBorrowTime;
    }

    public void setbReaderBorrowTime(Double bReaderBorrowTime) {
        this.bReaderBorrowTime = bReaderBorrowTime;
    }

    public String getbReaderMobile() {
        return bReaderMobile;
    }

    public void setbReaderMobile(String bReaderMobile) {
        this.bReaderMobile = bReaderMobile == null ? null : bReaderMobile.trim();
    }

    public String getbReaderRemarks() {
        return bReaderRemarks;
    }

    public void setbReaderRemarks(String bReaderRemarks) {
        this.bReaderRemarks = bReaderRemarks == null ? null : bReaderRemarks.trim();
    }
}