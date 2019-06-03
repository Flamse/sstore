package com.top.sstore.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdministratorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdministratorExample() {
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

        public Criteria andAdminiIdIsNull() {
            addCriterion("admini_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminiIdIsNotNull() {
            addCriterion("admini_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminiIdEqualTo(Integer value) {
            addCriterion("admini_id =", value, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdminiIdNotEqualTo(Integer value) {
            addCriterion("admini_id <>", value, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdminiIdGreaterThan(Integer value) {
            addCriterion("admini_id >", value, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdminiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admini_id >=", value, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdminiIdLessThan(Integer value) {
            addCriterion("admini_id <", value, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdminiIdLessThanOrEqualTo(Integer value) {
            addCriterion("admini_id <=", value, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdminiIdIn(List<Integer> values) {
            addCriterion("admini_id in", values, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdminiIdNotIn(List<Integer> values) {
            addCriterion("admini_id not in", values, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdminiIdBetween(Integer value1, Integer value2) {
            addCriterion("admini_id between", value1, value2, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdminiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admini_id not between", value1, value2, "adminiId");
            return (Criteria) this;
        }

        public Criteria andAdiminUserIsNull() {
            addCriterion("adimin_user is null");
            return (Criteria) this;
        }

        public Criteria andAdiminUserIsNotNull() {
            addCriterion("adimin_user is not null");
            return (Criteria) this;
        }

        public Criteria andAdiminUserEqualTo(String value) {
            addCriterion("adimin_user =", value, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserNotEqualTo(String value) {
            addCriterion("adimin_user <>", value, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserGreaterThan(String value) {
            addCriterion("adimin_user >", value, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserGreaterThanOrEqualTo(String value) {
            addCriterion("adimin_user >=", value, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserLessThan(String value) {
            addCriterion("adimin_user <", value, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserLessThanOrEqualTo(String value) {
            addCriterion("adimin_user <=", value, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserLike(String value) {
            addCriterion("adimin_user like", value, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserNotLike(String value) {
            addCriterion("adimin_user not like", value, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserIn(List<String> values) {
            addCriterion("adimin_user in", values, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserNotIn(List<String> values) {
            addCriterion("adimin_user not in", values, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserBetween(String value1, String value2) {
            addCriterion("adimin_user between", value1, value2, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdiminUserNotBetween(String value1, String value2) {
            addCriterion("adimin_user not between", value1, value2, "adiminUser");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordIsNull() {
            addCriterion("admini_password is null");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordIsNotNull() {
            addCriterion("admini_password is not null");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordEqualTo(String value) {
            addCriterion("admini_password =", value, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordNotEqualTo(String value) {
            addCriterion("admini_password <>", value, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordGreaterThan(String value) {
            addCriterion("admini_password >", value, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("admini_password >=", value, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordLessThan(String value) {
            addCriterion("admini_password <", value, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordLessThanOrEqualTo(String value) {
            addCriterion("admini_password <=", value, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordLike(String value) {
            addCriterion("admini_password like", value, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordNotLike(String value) {
            addCriterion("admini_password not like", value, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordIn(List<String> values) {
            addCriterion("admini_password in", values, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordNotIn(List<String> values) {
            addCriterion("admini_password not in", values, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordBetween(String value1, String value2) {
            addCriterion("admini_password between", value1, value2, "adminiPassword");
            return (Criteria) this;
        }

        public Criteria andAdminiPasswordNotBetween(String value1, String value2) {
            addCriterion("admini_password not between", value1, value2, "adminiPassword");
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