package com.top.sstore.pojo;

public class Thirdsort {
    private Integer thirdId;

    private String thirdName;

    private Integer secondId;

    public Integer getThirdId() {
        return thirdId;
    }

    public void setThirdId(Integer thirdId) {
        this.thirdId = thirdId;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName == null ? null : thirdName.trim();
    }

    public Integer getSecondId() {
        return secondId;
    }

    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }
}