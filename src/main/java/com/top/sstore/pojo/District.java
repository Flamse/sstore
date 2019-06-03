package com.top.sstore.pojo;

public class District {
    private Short disrictId;

    private String name;

    private Short parentId;

    private String code;

    private Byte order;

    public Short getDisrictId() {
        return disrictId;
    }

    public void setDisrictId(Short disrictId) {
        this.disrictId = disrictId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Byte getOrder() {
        return order;
    }

    public void setOrder(Byte order) {
        this.order = order;
    }
}