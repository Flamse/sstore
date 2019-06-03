package com.top.sstore.pojo;

import java.util.ArrayList;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityPictureIsNull() {
            addCriterion("activity_picture is null");
            return (Criteria) this;
        }

        public Criteria andActivityPictureIsNotNull() {
            addCriterion("activity_picture is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPictureEqualTo(String value) {
            addCriterion("activity_picture =", value, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureNotEqualTo(String value) {
            addCriterion("activity_picture <>", value, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureGreaterThan(String value) {
            addCriterion("activity_picture >", value, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureGreaterThanOrEqualTo(String value) {
            addCriterion("activity_picture >=", value, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureLessThan(String value) {
            addCriterion("activity_picture <", value, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureLessThanOrEqualTo(String value) {
            addCriterion("activity_picture <=", value, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureLike(String value) {
            addCriterion("activity_picture like", value, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureNotLike(String value) {
            addCriterion("activity_picture not like", value, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureIn(List<String> values) {
            addCriterion("activity_picture in", values, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureNotIn(List<String> values) {
            addCriterion("activity_picture not in", values, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureBetween(String value1, String value2) {
            addCriterion("activity_picture between", value1, value2, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityPictureNotBetween(String value1, String value2) {
            addCriterion("activity_picture not between", value1, value2, "activityPicture");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeIsNull() {
            addCriterion("activity_describe is null");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeIsNotNull() {
            addCriterion("activity_describe is not null");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeEqualTo(String value) {
            addCriterion("activity_describe =", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeNotEqualTo(String value) {
            addCriterion("activity_describe <>", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeGreaterThan(String value) {
            addCriterion("activity_describe >", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("activity_describe >=", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeLessThan(String value) {
            addCriterion("activity_describe <", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeLessThanOrEqualTo(String value) {
            addCriterion("activity_describe <=", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeLike(String value) {
            addCriterion("activity_describe like", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeNotLike(String value) {
            addCriterion("activity_describe not like", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeIn(List<String> values) {
            addCriterion("activity_describe in", values, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeNotIn(List<String> values) {
            addCriterion("activity_describe not in", values, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeBetween(String value1, String value2) {
            addCriterion("activity_describe between", value1, value2, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeNotBetween(String value1, String value2) {
            addCriterion("activity_describe not between", value1, value2, "activityDescribe");
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