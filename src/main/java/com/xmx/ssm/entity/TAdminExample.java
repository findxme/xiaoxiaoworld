package com.xmx.ssm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TAdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAdminExample() {
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

        public Criteria andBAdminIdIsNull() {
            addCriterion("b_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andBAdminIdIsNotNull() {
            addCriterion("b_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminIdEqualTo(Integer value) {
            addCriterion("b_admin_id =", value, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminIdNotEqualTo(Integer value) {
            addCriterion("b_admin_id <>", value, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminIdGreaterThan(Integer value) {
            addCriterion("b_admin_id >", value, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_admin_id >=", value, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminIdLessThan(Integer value) {
            addCriterion("b_admin_id <", value, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_admin_id <=", value, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminIdIn(List<Integer> values) {
            addCriterion("b_admin_id in", values, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminIdNotIn(List<Integer> values) {
            addCriterion("b_admin_id not in", values, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("b_admin_id between", value1, value2, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_admin_id not between", value1, value2, "bAdminId");
            return (Criteria) this;
        }

        public Criteria andBAdminNameIsNull() {
            addCriterion("b_admin_name is null");
            return (Criteria) this;
        }

        public Criteria andBAdminNameIsNotNull() {
            addCriterion("b_admin_name is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminNameEqualTo(String value) {
            addCriterion("b_admin_name =", value, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameNotEqualTo(String value) {
            addCriterion("b_admin_name <>", value, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameGreaterThan(String value) {
            addCriterion("b_admin_name >", value, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("b_admin_name >=", value, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameLessThan(String value) {
            addCriterion("b_admin_name <", value, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameLessThanOrEqualTo(String value) {
            addCriterion("b_admin_name <=", value, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameLike(String value) {
            addCriterion("b_admin_name like", value, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameNotLike(String value) {
            addCriterion("b_admin_name not like", value, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameIn(List<String> values) {
            addCriterion("b_admin_name in", values, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameNotIn(List<String> values) {
            addCriterion("b_admin_name not in", values, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameBetween(String value1, String value2) {
            addCriterion("b_admin_name between", value1, value2, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminNameNotBetween(String value1, String value2) {
            addCriterion("b_admin_name not between", value1, value2, "bAdminName");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailIsNull() {
            addCriterion("b_admin_email is null");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailIsNotNull() {
            addCriterion("b_admin_email is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailEqualTo(String value) {
            addCriterion("b_admin_email =", value, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailNotEqualTo(String value) {
            addCriterion("b_admin_email <>", value, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailGreaterThan(String value) {
            addCriterion("b_admin_email >", value, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailGreaterThanOrEqualTo(String value) {
            addCriterion("b_admin_email >=", value, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailLessThan(String value) {
            addCriterion("b_admin_email <", value, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailLessThanOrEqualTo(String value) {
            addCriterion("b_admin_email <=", value, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailLike(String value) {
            addCriterion("b_admin_email like", value, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailNotLike(String value) {
            addCriterion("b_admin_email not like", value, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailIn(List<String> values) {
            addCriterion("b_admin_email in", values, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailNotIn(List<String> values) {
            addCriterion("b_admin_email not in", values, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailBetween(String value1, String value2) {
            addCriterion("b_admin_email between", value1, value2, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminEmailNotBetween(String value1, String value2) {
            addCriterion("b_admin_email not between", value1, value2, "bAdminEmail");
            return (Criteria) this;
        }

        public Criteria andBAdminNoIsNull() {
            addCriterion("b_admin_no is null");
            return (Criteria) this;
        }

        public Criteria andBAdminNoIsNotNull() {
            addCriterion("b_admin_no is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminNoEqualTo(String value) {
            addCriterion("b_admin_no =", value, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoNotEqualTo(String value) {
            addCriterion("b_admin_no <>", value, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoGreaterThan(String value) {
            addCriterion("b_admin_no >", value, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoGreaterThanOrEqualTo(String value) {
            addCriterion("b_admin_no >=", value, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoLessThan(String value) {
            addCriterion("b_admin_no <", value, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoLessThanOrEqualTo(String value) {
            addCriterion("b_admin_no <=", value, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoLike(String value) {
            addCriterion("b_admin_no like", value, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoNotLike(String value) {
            addCriterion("b_admin_no not like", value, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoIn(List<String> values) {
            addCriterion("b_admin_no in", values, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoNotIn(List<String> values) {
            addCriterion("b_admin_no not in", values, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoBetween(String value1, String value2) {
            addCriterion("b_admin_no between", value1, value2, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminNoNotBetween(String value1, String value2) {
            addCriterion("b_admin_no not between", value1, value2, "bAdminNo");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordIsNull() {
            addCriterion("b_admin_password is null");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordIsNotNull() {
            addCriterion("b_admin_password is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordEqualTo(String value) {
            addCriterion("b_admin_password =", value, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordNotEqualTo(String value) {
            addCriterion("b_admin_password <>", value, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordGreaterThan(String value) {
            addCriterion("b_admin_password >", value, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("b_admin_password >=", value, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordLessThan(String value) {
            addCriterion("b_admin_password <", value, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordLessThanOrEqualTo(String value) {
            addCriterion("b_admin_password <=", value, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordLike(String value) {
            addCriterion("b_admin_password like", value, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordNotLike(String value) {
            addCriterion("b_admin_password not like", value, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordIn(List<String> values) {
            addCriterion("b_admin_password in", values, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordNotIn(List<String> values) {
            addCriterion("b_admin_password not in", values, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordBetween(String value1, String value2) {
            addCriterion("b_admin_password between", value1, value2, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminPasswordNotBetween(String value1, String value2) {
            addCriterion("b_admin_password not between", value1, value2, "bAdminPassword");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeIsNull() {
            addCriterion("b_admin_type is null");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeIsNotNull() {
            addCriterion("b_admin_type is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeEqualTo(String value) {
            addCriterion("b_admin_type =", value, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeNotEqualTo(String value) {
            addCriterion("b_admin_type <>", value, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeGreaterThan(String value) {
            addCriterion("b_admin_type >", value, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeGreaterThanOrEqualTo(String value) {
            addCriterion("b_admin_type >=", value, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeLessThan(String value) {
            addCriterion("b_admin_type <", value, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeLessThanOrEqualTo(String value) {
            addCriterion("b_admin_type <=", value, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeLike(String value) {
            addCriterion("b_admin_type like", value, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeNotLike(String value) {
            addCriterion("b_admin_type not like", value, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeIn(List<String> values) {
            addCriterion("b_admin_type in", values, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeNotIn(List<String> values) {
            addCriterion("b_admin_type not in", values, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeBetween(String value1, String value2) {
            addCriterion("b_admin_type between", value1, value2, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminTypeNotBetween(String value1, String value2) {
            addCriterion("b_admin_type not between", value1, value2, "bAdminType");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateIsNull() {
            addCriterion("b_admin_create_date is null");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateIsNotNull() {
            addCriterion("b_admin_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("b_admin_create_date =", value, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("b_admin_create_date <>", value, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("b_admin_create_date >", value, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_admin_create_date >=", value, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("b_admin_create_date <", value, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_admin_create_date <=", value, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("b_admin_create_date in", values, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("b_admin_create_date not in", values, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_admin_create_date between", value1, value2, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_admin_create_date not between", value1, value2, "bAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateIsNull() {
            addCriterion("b_admin_stop_date is null");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateIsNotNull() {
            addCriterion("b_admin_stop_date is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateEqualTo(Date value) {
            addCriterionForJDBCDate("b_admin_stop_date =", value, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("b_admin_stop_date <>", value, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateGreaterThan(Date value) {
            addCriterionForJDBCDate("b_admin_stop_date >", value, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_admin_stop_date >=", value, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateLessThan(Date value) {
            addCriterionForJDBCDate("b_admin_stop_date <", value, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_admin_stop_date <=", value, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateIn(List<Date> values) {
            addCriterionForJDBCDate("b_admin_stop_date in", values, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("b_admin_stop_date not in", values, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_admin_stop_date between", value1, value2, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminStopDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_admin_stop_date not between", value1, value2, "bAdminStopDate");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksIsNull() {
            addCriterion("b_admin_Remarks is null");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksIsNotNull() {
            addCriterion("b_admin_Remarks is not null");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksEqualTo(String value) {
            addCriterion("b_admin_Remarks =", value, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksNotEqualTo(String value) {
            addCriterion("b_admin_Remarks <>", value, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksGreaterThan(String value) {
            addCriterion("b_admin_Remarks >", value, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("b_admin_Remarks >=", value, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksLessThan(String value) {
            addCriterion("b_admin_Remarks <", value, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksLessThanOrEqualTo(String value) {
            addCriterion("b_admin_Remarks <=", value, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksLike(String value) {
            addCriterion("b_admin_Remarks like", value, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksNotLike(String value) {
            addCriterion("b_admin_Remarks not like", value, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksIn(List<String> values) {
            addCriterion("b_admin_Remarks in", values, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksNotIn(List<String> values) {
            addCriterion("b_admin_Remarks not in", values, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksBetween(String value1, String value2) {
            addCriterion("b_admin_Remarks between", value1, value2, "bAdminRemarks");
            return (Criteria) this;
        }

        public Criteria andBAdminRemarksNotBetween(String value1, String value2) {
            addCriterion("b_admin_Remarks not between", value1, value2, "bAdminRemarks");
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