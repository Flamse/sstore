package com.top.sstore.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Service {
    private Integer servId;

    private BigDecimal price;

    private String describe;

    private Integer servVolume;

    private Integer thirdId;

    private Date servCreatetime;

    private Integer servStatus;

    private Integer labelId;

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
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

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }
}