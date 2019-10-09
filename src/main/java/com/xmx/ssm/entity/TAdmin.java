package com.xmx.ssm.entity;

import java.util.Date;

public class TAdmin {
    private Integer bAdminId;

    private String bAdminName;

    private String bAdminEmail;

    private String bAdminNo;

    private String bAdminPassword;

    private String bAdminType;

    private Date bAdminCreateDate;

    private Date bAdminStopDate;

    private String bAdminRemarks;

    public Integer getbAdminId() {
        return bAdminId;
    }

    public void setbAdminId(Integer bAdminId) {
        this.bAdminId = bAdminId;
    }

    public String getbAdminName() {
        return bAdminName;
    }

    public void setbAdminName(String bAdminName) {
        this.bAdminName = bAdminName == null ? null : bAdminName.trim();
    }

    public String getbAdminEmail() {
        return bAdminEmail;
    }

    public void setbAdminEmail(String bAdminEmail) {
        this.bAdminEmail = bAdminEmail == null ? null : bAdminEmail.trim();
    }

    public String getbAdminNo() {
        return bAdminNo;
    }

    public void setbAdminNo(String bAdminNo) {
        this.bAdminNo = bAdminNo == null ? null : bAdminNo.trim();
    }

    public String getbAdminPassword() {
        return bAdminPassword;
    }

    public void setbAdminPassword(String bAdminPassword) {
        this.bAdminPassword = bAdminPassword == null ? null : bAdminPassword.trim();
    }

    public String getbAdminType() {
        return bAdminType;
    }

    public void setbAdminType(String bAdminType) {
        this.bAdminType = bAdminType == null ? null : bAdminType.trim();
    }

    public Date getbAdminCreateDate() {
        return bAdminCreateDate;
    }

    public void setbAdminCreateDate(Date bAdminCreateDate) {
        this.bAdminCreateDate = bAdminCreateDate;
    }

    public Date getbAdminStopDate() {
        return bAdminStopDate;
    }

    public void setbAdminStopDate(Date bAdminStopDate) {
        this.bAdminStopDate = bAdminStopDate;
    }

    public String getbAdminRemarks() {
        return bAdminRemarks;
    }

    public void setbAdminRemarks(String bAdminRemarks) {
        this.bAdminRemarks = bAdminRemarks == null ? null : bAdminRemarks.trim();
    }

    @Override
    public String toString() {
        return "TAdmin{" +
                "bAdminId=" + bAdminId +
                ", bAdminName='" + bAdminName + '\'' +
                ", bAdminEmail='" + bAdminEmail + '\'' +
                ", bAdminNo='" + bAdminNo + '\'' +
                ", bAdminPassword='" + bAdminPassword + '\'' +
                ", bAdminType='" + bAdminType + '\'' +
                ", bAdminCreateDate=" + bAdminCreateDate +
                ", bAdminStopDate=" + bAdminStopDate +
                ", bAdminRemarks='" + bAdminRemarks + '\'' +
                '}';
    }
}