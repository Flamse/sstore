package com.top.sstore.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Service {
    private Integer servId;

    private BigDecimal price;

    private String servDescribe;

    private Integer servVolume;

    private Integer thirdId;

    private Date servCreatetime;

    private Integer servStatus;

    private String labelId;

    public Integer getServId() {
        return servId;
    }

    public void setServId(Integer servId) {
        this.servId = servId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getServDescribe() {
        return servDescribe;
    }

    public void setServDescribe(String servDescribe) {
        this.servDescribe = servDescribe == null ? null : servDescribe.trim();
    }

    public Integer getServVolume() {
        return servVolume;
    }

    public void setServVolume(Integer servVolume) {
        this.servVolume = servVolume;
    }

    public Integer getThirdId() {
        return thirdId;
    }

    public void setThirdId(Integer thirdId) {
        this.thirdId = thirdId;
    }

    public Date getServCreatetime() {
        return servCreatetime;
    }

    public void setServCreatetime(Date servCreatetime) {
        this.servCreatetime = servCreatetime;
    }

    public Integer getServStatus() {
        return servStatus;
    }

    public void setServStatus(Integer servStatus) {
        this.servStatus = servStatus;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId == null ? null : labelId.trim();
    }
}