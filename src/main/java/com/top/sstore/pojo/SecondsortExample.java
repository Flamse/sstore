package com.top.sstore.pojo;

import java.util.ArrayList;
import java.util.List;

public class SecondsortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecondsortExample() {
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

        public Criteria andSecondIdIsNull() {
            addCriterion("second_id is null");
            return (Criteria) this;
        }

        public Criteria andSecondIdIsNotNull() {
            addCriterion("second_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecondIdEqualTo(Integer value) {
            addCriterion("second_id =", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotEqualTo(Integer value) {
            addCriterion("second_id <>", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdGreaterThan(Integer value) {
            addCriterion("second_id >", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_id >=", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdLessThan(Integer value) {
            addCriterion("second_id <", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdLessThanOrEqualTo(Integer value) {
            addCriterion("second_id <=", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdIn(List<Integer> values) {
            addCriterion("second_id in", values, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotIn(List<Integer> values) {
            addCriterion("second_id not in", values, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdBetween(Integer value1, Integer value2) {
            addCriterion("second_id between", value1, value2, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotBetween(Integer value1, Integer value2) {
            addCriterion("second_id not between", value1, value2, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondNameIsNull() {
            addCriterion("second_name is null");
            return (Criteria) this;
        }

        public Criteria andSecondNameIsNotNull() {
            addCriterion("second_name is not null");
            return (Criteria) this;
        }

        public Criteria andSecondNameEqualTo(String value) {
            addCriterion("second_name =", value, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameNotEqualTo(String value) {
            addCriterion("second_name <>", value, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameGreaterThan(String value) {
            addCriterion("second_name >", value, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameGreaterThanOrEqualTo(String value) {
            addCriterion("second_name >=", value, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameLessThan(String value) {
            addCriterion("second_name <", value, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameLessThanOrEqualTo(String value) {
            addCriterion("second_name <=", value, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameLike(String value) {
            addCriterion("second_name like", value, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameNotLike(String value) {
            addCriterion("second_name not like", value, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameIn(List<String> values) {
            addCriterion("second_name in", values, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameNotIn(List<String> values) {
            addCriterion("second_name not in", values, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameBetween(String value1, String value2) {
            addCriterion("second_name between", value1, value2, "secondName");
            return (Criteria) this;
        }

        public Criteria andSecondNameNotBetween(String value1, String value2) {
            addCriterion("second_name not between", value1, value2, "secondName");
            return (Criteria) this;
        }

        public Criteria andFirstIdIsNull() {
            addCriterion("first_id is null");
            return (Criteria) this;
        }

        public Criteria andFirstIdIsNotNull() {
            addCriterion("first_id is not null");
            return (Criteria) this;
        }

        public Criteria andFirstIdEqualTo(Integer value) {
            addCriterion("first_id =", value, "firstId");
            return (Criteria) this;
        }

        public Criteria andFirstIdNotEqualTo(Integer value) {
            addCriterion("first_id <>", value, "firstId");
            return (Criteria) this;
        }

        public Criteria andFirstIdGreaterThan(Integer value) {
            addCriterion("first_id >", value, "firstId");
            return (Criteria) this;
        }

        public Criteria andFirstIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_id >=", value, "firstId");
            return (Criteria) this;
        }

        public Criteria andFirstIdLessThan(Integer value) {
            addCriterion("first_id <", value, "firstId");
            return (Criteria) this;
        }

        public Criteria andFirstIdLessThanOrEqualTo(Integer value) {
            addCriterion("first_id <=", value, "firstId");
            return (Criteria) this;
        }

        public Criteria andFirstIdIn(List<Integer> values) {
            addCriterion("first_id in", values, "firstId");
            return (Criteria) this;
        }

        public Criteria andFirstIdNotIn(List<Integer> values) {
            addCriterion("first_id not in", values, "firstId");
            return (Criteria) this;
        }

        public Criteria andFirstIdBetween(Integer value1, Integer value2) {
            addCriterion("first_id between", value1, value2, "firstId");
            return (Criteria) this;
        }

        public Criteria andFirstIdNotBetween(Integer value1, Integer value2) {
            addCriterion("first_id not between", value1, value2, "firstId");
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