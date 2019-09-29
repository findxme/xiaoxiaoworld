package com.xmx.ssm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TBookExample {


    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBookExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBBookIdIsNull() {
            addCriterion("b_book_id is null");
            return (Criteria) this;
        }

        public Criteria andBBookIdIsNotNull() {
            addCriterion("b_book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBBookIdEqualTo(Integer value) {
            addCriterion("b_book_id =", value, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookIdNotEqualTo(Integer value) {
            addCriterion("b_book_id <>", value, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookIdGreaterThan(Integer value) {
            addCriterion("b_book_id >", value, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_book_id >=", value, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookIdLessThan(Integer value) {
            addCriterion("b_book_id <", value, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_book_id <=", value, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookIdIn(List<Integer> values) {
            addCriterion("b_book_id in", values, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookIdNotIn(List<Integer> values) {
            addCriterion("b_book_id not in", values, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookIdBetween(Integer value1, Integer value2) {
            addCriterion("b_book_id between", value1, value2, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_book_id not between", value1, value2, "bBookId");
            return (Criteria) this;
        }

        public Criteria andBBookNoIsNull() {
            addCriterion("b_book_no is null");
            return (Criteria) this;
        }

        public Criteria andBBookNoIsNotNull() {
            addCriterion("b_book_no is not null");
            return (Criteria) this;
        }

        public Criteria andBBookNoEqualTo(String value) {
            addCriterion("b_book_no =", value, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoNotEqualTo(String value) {
            addCriterion("b_book_no <>", value, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoGreaterThan(String value) {
            addCriterion("b_book_no >", value, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoGreaterThanOrEqualTo(String value) {
            addCriterion("b_book_no >=", value, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoLessThan(String value) {
            addCriterion("b_book_no <", value, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoLessThanOrEqualTo(String value) {
            addCriterion("b_book_no <=", value, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoLike(String value) {
            addCriterion("b_book_no like", value, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoNotLike(String value) {
            addCriterion("b_book_no not like", value, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoIn(List<String> values) {
            addCriterion("b_book_no in", values, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoNotIn(List<String> values) {
            addCriterion("b_book_no not in", values, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoBetween(String value1, String value2) {
            addCriterion("b_book_no between", value1, value2, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNoNotBetween(String value1, String value2) {
            addCriterion("b_book_no not between", value1, value2, "bBookNo");
            return (Criteria) this;
        }

        public Criteria andBBookNameIsNull() {
            addCriterion("b_book_name is null");
            return (Criteria) this;
        }

        public Criteria andBBookNameIsNotNull() {
            addCriterion("b_book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBBookNameEqualTo(String value) {
            addCriterion("b_book_name =", value, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameNotEqualTo(String value) {
            addCriterion("b_book_name <>", value, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameGreaterThan(String value) {
            addCriterion("b_book_name >", value, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("b_book_name >=", value, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameLessThan(String value) {
            addCriterion("b_book_name <", value, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameLessThanOrEqualTo(String value) {
            addCriterion("b_book_name <=", value, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameLike(String value) {
            addCriterion("b_book_name like", value, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameNotLike(String value) {
            addCriterion("b_book_name not like", value, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameIn(List<String> values) {
            addCriterion("b_book_name in", values, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameNotIn(List<String> values) {
            addCriterion("b_book_name not in", values, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameBetween(String value1, String value2) {
            addCriterion("b_book_name between", value1, value2, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookNameNotBetween(String value1, String value2) {
            addCriterion("b_book_name not between", value1, value2, "bBookName");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorIsNull() {
            addCriterion("b_book_author is null");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorIsNotNull() {
            addCriterion("b_book_author is not null");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorEqualTo(String value) {
            addCriterion("b_book_author =", value, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorNotEqualTo(String value) {
            addCriterion("b_book_author <>", value, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorGreaterThan(String value) {
            addCriterion("b_book_author >", value, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("b_book_author >=", value, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorLessThan(String value) {
            addCriterion("b_book_author <", value, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("b_book_author <=", value, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorLike(String value) {
            addCriterion("b_book_author like", value, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorNotLike(String value) {
            addCriterion("b_book_author not like", value, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorIn(List<String> values) {
            addCriterion("b_book_author in", values, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorNotIn(List<String> values) {
            addCriterion("b_book_author not in", values, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorBetween(String value1, String value2) {
            addCriterion("b_book_author between", value1, value2, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookAuthorNotBetween(String value1, String value2) {
            addCriterion("b_book_author not between", value1, value2, "bBookAuthor");
            return (Criteria) this;
        }

        public Criteria andBBookNumberIsNull() {
            addCriterion("b_book_number is null");
            return (Criteria) this;
        }

        public Criteria andBBookNumberIsNotNull() {
            addCriterion("b_book_number is not null");
            return (Criteria) this;
        }

        public Criteria andBBookNumberEqualTo(Integer value) {
            addCriterion("b_book_number =", value, "bBookNumber");
            return (Criteria) this;
        }

        public Criteria andBBookNumberNotEqualTo(Integer value) {
            addCriterion("b_book_number <>", value, "bBookNumber");
            return (Criteria) this;
        }

        public Criteria andBBookNumberGreaterThan(Integer value) {
            addCriterion("b_book_number >", value, "bBookNumber");
            return (Criteria) this;
        }

        public Criteria andBBookNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_book_number >=", value, "bBookNumber");
            return (Criteria) this;
        }

        public Criteria andBBookNumberLessThan(Integer value) {
            addCriterion("b_book_number <", value, "bBookNumber");
            return (Criteria) this;
        }

        public Criteria andBBookNumberLessThanOrEqualTo(Integer value) {
            addCriterion("b_book_number <=", value, "bBookNumber");
            return (Criteria) this;
        }

        public Criteria andBBookNumberIn(List<Integer> values) {
            addCriterion("b_book_number in", values, "bBookNumber");
            return (Criteria) this;
        }

        public Criteria andBBookNumberNotIn(List<Integer> values) {
            addCriterion("b_book_number not in", values, "bBookNumber");
            return (Criteria) this;
        }

        public Criteria andBBookNumberBetween(Integer value1, Integer value2) {
            addCriterion("b_book_number between", value1, value2, "bBookNumber");
            return (Criteria) this;
        }

        public Criteria andBBookNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("b_book_number not between", value1, value2, "bBookNumber");
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

        public Criteria andBBookCreatedateIsNull() {
            addCriterion("b_book_createDate is null");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateIsNotNull() {
            addCriterion("b_book_createDate is not null");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("b_book_createDate =", value, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("b_book_createDate <>", value, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("b_book_createDate >", value, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_book_createDate >=", value, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateLessThan(Date value) {
            addCriterionForJDBCDate("b_book_createDate <", value, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_book_createDate <=", value, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("b_book_createDate in", values, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("b_book_createDate not in", values, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_book_createDate between", value1, value2, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBBookCreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_book_createDate not between", value1, value2, "bBookCreatedate");
            return (Criteria) this;
        }

        public Criteria andBStopDateIsNull() {
            addCriterion("b_stop_date is null");
            return (Criteria) this;
        }

        public Criteria andBStopDateIsNotNull() {
            addCriterion("b_stop_date is not null");
            return (Criteria) this;
        }

        public Criteria andBStopDateEqualTo(Date value) {
            addCriterionForJDBCDate("b_stop_date =", value, "bStopDate");
            return (Criteria) this;
        }

        public Criteria andBStopDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("b_stop_date <>", value, "bStopDate");
            return (Criteria) this;
        }

        public Criteria andBStopDateGreaterThan(Date value) {
            addCriterionForJDBCDate("b_stop_date >", value, "bStopDate");
            return (Criteria) this;
        }

        public Criteria andBStopDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_stop_date >=", value, "bStopDate");
            return (Criteria) this;
        }

        public Criteria andBStopDateLessThan(Date value) {
            addCriterionForJDBCDate("b_stop_date <", value, "bStopDate");
            return (Criteria) this;
        }

        public Criteria andBStopDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_stop_date <=", value, "bStopDate");
            return (Criteria) this;
        }

        public Criteria andBStopDateIn(List<Date> values) {
            addCriterionForJDBCDate("b_stop_date in", values, "bStopDate");
            return (Criteria) this;
        }

        public Criteria andBStopDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("b_stop_date not in", values, "bStopDate");
            return (Criteria) this;
        }

        public Criteria andBStopDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_stop_date between", value1, value2, "bStopDate");
            return (Criteria) this;
        }

        public Criteria andBStopDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_stop_date not between", value1, value2, "bStopDate");
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