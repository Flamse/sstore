package com.top.sstore.pojo;

import java.util.ArrayList;
import java.util.List;

public class CartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartExample() {
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

        public Criteria andCartIdIsNull() {
            addCriterion("cart_id is null");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNotNull() {
            addCriterion("cart_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartIdEqualTo(Integer value) {
            addCriterion("cart_id =", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotEqualTo(Integer value) {
            addCriterion("cart_id <>", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThan(Integer value) {
            addCriterion("cart_id >", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_id >=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThan(Integer value) {
            addCriterion("cart_id <", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_id <=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdIn(List<Integer> values) {
            addCriterion("cart_id in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotIn(List<Integer> values) {
            addCriterion("cart_id not in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_id between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_id not between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
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

        public Criteria andServNumberIsNull() {
            addCriterion("serv_number is null");
            return (Criteria) this;
        }

        public Criteria andServNumberIsNotNull() {
            addCriterion("serv_number is not null");
            return (Criteria) this;
        }

        public Criteria andServNumberEqualTo(Integer value) {
            addCriterion("serv_number =", value, "servNumber");
            return (Criteria) this;
        }

        public Criteria andServNumberNotEqualTo(Integer value) {
            addCriterion("serv_number <>", value, "servNumber");
            return (Criteria) this;
        }

        public Criteria andServNumberGreaterThan(Integer value) {
            addCriterion("serv_number >", value, "servNumber");
            return (Criteria) this;
        }

        public Criteria andServNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("serv_number >=", value, "servNumber");
            return (Criteria) this;
        }

        public Criteria andServNumberLessThan(Integer value) {
            addCriterion("serv_number <", value, "servNumber");
            return (Criteria) this;
        }

        public Criteria andServNumberLessThanOrEqualTo(Integer value) {
            addCriterion("serv_number <=", value, "servNumber");
            return (Criteria) this;
        }

        public Criteria andServNumberIn(List<Integer> values) {
            addCriterion("serv_number in", values, "servNumber");
            return (Criteria) this;
        }

        public Criteria andServNumberNotIn(List<Integer> values) {
            addCriterion("serv_number not in", values, "servNumber");
            return (Criteria) this;
        }

        public Criteria andServNumberBetween(Integer value1, Integer value2) {
            addCriterion("serv_number between", value1, value2, "servNumber");
            return (Criteria) this;
        }

        public Criteria andServNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("serv_number not between", value1, value2, "servNumber");
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