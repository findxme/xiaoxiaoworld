package com.xmx.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class TBookTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBookTypeExample() {
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

        public Criteria andBBookTypeIdIsNull() {
            addCriterion("b_book_type_id is null");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdIsNotNull() {
            addCriterion("b_book_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdEqualTo(Integer value) {
            addCriterion("b_book_type_id =", value, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdNotEqualTo(Integer value) {
            addCriterion("b_book_type_id <>", value, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdGreaterThan(Integer value) {
            addCriterion("b_book_type_id >", value, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_book_type_id >=", value, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdLessThan(Integer value) {
            addCriterion("b_book_type_id <", value, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_book_type_id <=", value, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdIn(List<Integer> values) {
            addCriterion("b_book_type_id in", values, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdNotIn(List<Integer> values) {
            addCriterion("b_book_type_id not in", values, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("b_book_type_id between", value1, value2, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_book_type_id not between", value1, value2, "bBookTypeId");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoIsNull() {
            addCriterion("b_book_type_no is null");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoIsNotNull() {
            addCriterion("b_book_type_no is not null");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoEqualTo(String value) {
            addCriterion("b_book_type_no =", value, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoNotEqualTo(String value) {
            addCriterion("b_book_type_no <>", value, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoGreaterThan(String value) {
            addCriterion("b_book_type_no >", value, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoGreaterThanOrEqualTo(String value) {
            addCriterion("b_book_type_no >=", value, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoLessThan(String value) {
            addCriterion("b_book_type_no <", value, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoLessThanOrEqualTo(String value) {
            addCriterion("b_book_type_no <=", value, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoLike(String value) {
            addCriterion("b_book_type_no like", value, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoNotLike(String value) {
            addCriterion("b_book_type_no not like", value, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoIn(List<String> values) {
            addCriterion("b_book_type_no in", values, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoNotIn(List<String> values) {
            addCriterion("b_book_type_no not in", values, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoBetween(String value1, String value2) {
            addCriterion("b_book_type_no between", value1, value2, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNoNotBetween(String value1, String value2) {
            addCriterion("b_book_type_no not between", value1, value2, "bBookTypeNo");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIsNull() {
            addCriterion("b_book_type is null");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIsNotNull() {
            addCriterion("b_book_type is not null");
            return (Criteria) this;
        }

        public Criteria andBBookTypeEqualTo(String value) {
            addCriterion("b_book_type =", value, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNotEqualTo(String value) {
            addCriterion("b_book_type <>", value, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeGreaterThan(String value) {
            addCriterion("b_book_type >", value, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeGreaterThanOrEqualTo(String value) {
            addCriterion("b_book_type >=", value, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeLessThan(String value) {
            addCriterion("b_book_type <", value, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeLessThanOrEqualTo(String value) {
            addCriterion("b_book_type <=", value, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeLike(String value) {
            addCriterion("b_book_type like", value, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNotLike(String value) {
            addCriterion("b_book_type not like", value, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeIn(List<String> values) {
            addCriterion("b_book_type in", values, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNotIn(List<String> values) {
            addCriterion("b_book_type not in", values, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeBetween(String value1, String value2) {
            addCriterion("b_book_type between", value1, value2, "bBookType");
            return (Criteria) this;
        }

        public Criteria andBBookTypeNotBetween(String value1, String value2) {
            addCriterion("b_book_type not between", value1, value2, "bBookType");
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