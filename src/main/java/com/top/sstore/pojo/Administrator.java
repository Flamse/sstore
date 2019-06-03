package com.top.sstore.pojo;

public class Administrator {
    private Integer adminiId;

    private String adiminUser;

    private String adminiPassword;

    public Integer getAdminiId() {
        return adminiId;
    }

    public void setAdminiId(Integer adminiId) {
        this.adminiId = adminiId;
    }

    public String getAdiminUser() {
        return adiminUser;
    }

    public void setAdiminUser(String adiminUser) {
        this.adiminUser = adiminUser == null ? null : adiminUser.trim();
    }

    public String getAdminiPassword() {
        return adminiPassword;
    }

    public void setAdminiPassword(String adminiPassword) {
        this.adminiPassword = adminiPassword == null ? null : adminiPassword.trim();
    }
}