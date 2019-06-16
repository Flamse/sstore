package com.top.sstore.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andServIdIsNull() {
            addCriterion("serv_id is null");
            return (Criteria) this;
        }

        public Criteria andServIdIsNotNull() {
            addCriterion("serv_id is not null");
            return (Criteria) this;
        }

        public Criteria andServIdEqualTo(Integer value) {
            addCriterion("serv_id =", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotEqualTo(Integer value) {
            addCriterion("serv_id <>", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThan(Integer value) {
            addCriterion("serv_id >", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("serv_id >=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThan(Integer value) {
            addCriterion("serv_id <", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThanOrEqualTo(Integer value) {
            addCriterion("serv_id <=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdIn(List<Integer> values) {
            addCriterion("serv_id in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotIn(List<Integer> values) {
            addCriterion("serv_id not in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdBetween(Integer value1, Integer value2) {
            addCriterion("serv_id between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotBetween(Integer value1, Integer value2) {
            addCriterion("serv_id not between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andServDescribeIsNull() {
            addCriterion("serv_describe is null");
            return (Criteria) this;
        }

        public Criteria andServDescribeIsNotNull() {
            addCriterion("serv_describe is not null");
            return (Criteria) this;
        }

        public Criteria andServDescribeEqualTo(String value) {
            addCriterion("serv_describe =", value, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeNotEqualTo(String value) {
            addCriterion("serv_describe <>", value, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeGreaterThan(String value) {
            addCriterion("serv_describe >", value, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("serv_describe >=", value, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeLessThan(String value) {
            addCriterion("serv_describe <", value, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeLessThanOrEqualTo(String value) {
            addCriterion("serv_describe <=", value, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeLike(String value) {
            addCriterion("serv_describe like", value, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeNotLike(String value) {
            addCriterion("serv_describe not like", value, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeIn(List<String> values) {
            addCriterion("serv_describe in", values, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeNotIn(List<String> values) {
            addCriterion("serv_describe not in", values, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeBetween(String value1, String value2) {
            addCriterion("serv_describe between", value1, value2, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServDescribeNotBetween(String value1, String value2) {
            addCriterion("serv_describe not between", value1, value2, "servDescribe");
            return (Criteria) this;
        }

        public Criteria andServVolumeIsNull() {
            addCriterion("serv_volume is null");
            return (Criteria) this;
        }

        public Criteria andServVolumeIsNotNull() {
            addCriterion("serv_volume is not null");
            return (Criteria) this;
        }

        public Criteria andServVolumeEqualTo(Integer value) {
            addCriterion("serv_volume =", value, "servVolume");
            return (Criteria) this;
        }

        public Criteria andServVolumeNotEqualTo(Integer value) {
            addCriterion("serv_volume <>", value, "servVolume");
            return (Criteria) this;
        }

        public Criteria andServVolumeGreaterThan(Integer value) {
            addCriterion("serv_volume >", value, "servVolume");
            return (Criteria) this;
        }

        public Criteria andServVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("serv_volume >=", value, "servVolume");
            return (Criteria) this;
        }

        public Criteria andServVolumeLessThan(Integer value) {
            addCriterion("serv_volume <", value, "servVolume");
            return (Criteria) this;
        }

        public Criteria andServVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("serv_volume <=", value, "servVolume");
            return (Criteria) this;
        }

        public Criteria andServVolumeIn(List<Integer> values) {
            addCriterion("serv_volume in", values, "servVolume");
            return (Criteria) this;
        }

        public Criteria andServVolumeNotIn(List<Integer> values) {
            addCriterion("serv_volume not in", values, "servVolume");
            return (Criteria) this;
        }

        public Criteria andServVolumeBetween(Integer value1, Integer value2) {
            addCriterion("serv_volume between", value1, value2, "servVolume");
            return (Criteria) this;
        }

        public Criteria andServVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("serv_volume not between", value1, value2, "servVolume");
            return (Criteria) this;
        }

        public Criteria andThirdIdIsNull() {
            addCriterion("third_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdIdIsNotNull() {
            addCriterion("third_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdIdEqualTo(Integer value) {
            addCriterion("third_id =", value, "thirdId");
            return (Criteria) this;
        }

        public Criteria andThirdIdNotEqualTo(Integer value) {
            addCriterion("third_id <>", value, "thirdId");
            return (Criteria) this;
        }

        public Criteria andThirdIdGreaterThan(Integer value) {
            addCriterion("third_id >", value, "thirdId");
            return (Criteria) this;
        }

        public Criteria andThirdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("third_id >=", value, "thirdId");
            return (Criteria) this;
        }

        public Criteria andThirdIdLessThan(Integer value) {
            addCriterion("third_id <", value, "thirdId");
            return (Criteria) this;
        }

        public Criteria andThirdIdLessThanOrEqualTo(Integer value) {
            addCriterion("third_id <=", value, "thirdId");
            return (Criteria) this;
        }

        public Criteria andThirdIdIn(List<Integer> values) {
            addCriterion("third_id in", values, "thirdId");
            return (Criteria) this;
        }

        public Criteria andThirdIdNotIn(List<Integer> values) {
            addCriterion("third_id not in", values, "thirdId");
            return (Criteria) this;
        }

        public Criteria andThirdIdBetween(Integer value1, Integer value2) {
            addCriterion("third_id between", value1, value2, "thirdId");
            return (Criteria) this;
        }

        public Criteria andThirdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("third_id not between", value1, value2, "thirdId");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeIsNull() {
            addCriterion("serv_createtime is null");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeIsNotNull() {
            addCriterion("serv_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeEqualTo(Date value) {
            addCriterion("serv_createtime =", value, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeNotEqualTo(Date value) {
            addCriterion("serv_createtime <>", value, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeGreaterThan(Date value) {
            addCriterion("serv_createtime >", value, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("serv_createtime >=", value, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeLessThan(Date value) {
            addCriterion("serv_createtime <", value, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("serv_createtime <=", value, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeIn(List<Date> values) {
            addCriterion("serv_createtime in", values, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeNotIn(List<Date> values) {
            addCriterion("serv_createtime not in", values, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeBetween(Date value1, Date value2) {
            addCriterion("serv_createtime between", value1, value2, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("serv_createtime not between", value1, value2, "servCreatetime");
            return (Criteria) this;
        }

        public Criteria andServStatusIsNull() {
            addCriterion("serv_status is null");
            return (Criteria) this;
        }

        public Criteria andServStatusIsNotNull() {
            addCriterion("serv_status is not null");
            return (Criteria) this;
        }

        public Criteria andServStatusEqualTo(Integer value) {
            addCriterion("serv_status =", value, "servStatus");
            return (Criteria) this;
        }

        public Criteria andServStatusNotEqualTo(Integer value) {
            addCriterion("serv_status <>", value, "servStatus");
            return (Criteria) this;
        }

        public Criteria andServStatusGreaterThan(Integer value) {
            addCriterion("serv_status >", value, "servStatus");
            return (Criteria) this;
        }

        public Criteria andServStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("serv_status >=", value, "servStatus");
            return (Criteria) this;
        }

        public Criteria andServStatusLessThan(Integer value) {
            addCriterion("serv_status <", value, "servStatus");
            return (Criteria) this;
        }

        public Criteria andServStatusLessThanOrEqualTo(Integer value) {
            addCriterion("serv_status <=", value, "servStatus");
            return (Criteria) this;
        }

        public Criteria andServStatusIn(List<Integer> values) {
            addCriterion("serv_status in", values, "servStatus");
            return (Criteria) this;
        }

        public Criteria andServStatusNotIn(List<Integer> values) {
            addCriterion("serv_status not in", values, "servStatus");
            return (Criteria) this;
        }

        public Criteria andServStatusBetween(Integer value1, Integer value2) {
            addCriterion("serv_status between", value1, value2, "servStatus");
            return (Criteria) this;
        }

        public Criteria andServStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("serv_status not between", value1, value2, "servStatus");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNull() {
            addCriterion("label_id is null");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNotNull() {
            addCriterion("label_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabelIdEqualTo(String value) {
            addCriterion("label_id =", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotEqualTo(String value) {
            addCriterion("label_id <>", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThan(String value) {
            addCriterion("label_id >", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThanOrEqualTo(String value) {
            addCriterion("label_id >=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThan(String value) {
            addCriterion("label_id <", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThanOrEqualTo(String value) {
            addCriterion("label_id <=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLike(String value) {
            addCriterion("label_id like", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotLike(String value) {
            addCriterion("label_id not like", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdIn(List<String> values) {
            addCriterion("label_id in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotIn(List<String> values) {
            addCriterion("label_id not in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdBetween(String value1, String value2) {
            addCriterion("label_id between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotBetween(String value1, String value2) {
            addCriterion("label_id not between", value1, value2, "labelId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}