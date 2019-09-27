package com.xmx.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class TReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TReaderExample() {
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

        public Criteria andBReaderIdIsNull() {
            addCriterion("b_reader_id is null");
            return (Criteria) this;
        }

        public Criteria andBReaderIdIsNotNull() {
            addCriterion("b_reader_id is not null");
            return (Criteria) this;
        }

        public Criteria andBReaderIdEqualTo(Integer value) {
            addCriterion("b_reader_id =", value, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderIdNotEqualTo(Integer value) {
            addCriterion("b_reader_id <>", value, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderIdGreaterThan(Integer value) {
            addCriterion("b_reader_id >", value, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_reader_id >=", value, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderIdLessThan(Integer value) {
            addCriterion("b_reader_id <", value, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_reader_id <=", value, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderIdIn(List<Integer> values) {
            addCriterion("b_reader_id in", values, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderIdNotIn(List<Integer> values) {
            addCriterion("b_reader_id not in", values, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderIdBetween(Integer value1, Integer value2) {
            addCriterion("b_reader_id between", value1, value2, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_reader_id not between", value1, value2, "bReaderId");
            return (Criteria) this;
        }

        public Criteria andBReaderNoIsNull() {
            addCriterion("b_reader_no is null");
            return (Criteria) this;
        }

        public Criteria andBReaderNoIsNotNull() {
            addCriterion("b_reader_no is not null");
            return (Criteria) this;
        }

        public Criteria andBReaderNoEqualTo(String value) {
            addCriterion("b_reader_no =", value, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoNotEqualTo(String value) {
            addCriterion("b_reader_no <>", value, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoGreaterThan(String value) {
            addCriterion("b_reader_no >", value, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoGreaterThanOrEqualTo(String value) {
            addCriterion("b_reader_no >=", value, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoLessThan(String value) {
            addCriterion("b_reader_no <", value, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoLessThanOrEqualTo(String value) {
            addCriterion("b_reader_no <=", value, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoLike(String value) {
            addCriterion("b_reader_no like", value, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoNotLike(String value) {
            addCriterion("b_reader_no not like", value, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoIn(List<String> values) {
            addCriterion("b_reader_no in", values, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoNotIn(List<String> values) {
            addCriterion("b_reader_no not in", values, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoBetween(String value1, String value2) {
            addCriterion("b_reader_no between", value1, value2, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNoNotBetween(String value1, String value2) {
            addCriterion("b_reader_no not between", value1, value2, "bReaderNo");
            return (Criteria) this;
        }

        public Criteria andBReaderNameIsNull() {
            addCriterion("b_reader_name is null");
            return (Criteria) this;
        }

        public Criteria andBReaderNameIsNotNull() {
            addCriterion("b_reader_name is not null");
            return (Criteria) this;
        }

        public Criteria andBReaderNameEqualTo(String value) {
            addCriterion("b_reader_name =", value, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameNotEqualTo(String value) {
            addCriterion("b_reader_name <>", value, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameGreaterThan(String value) {
            addCriterion("b_reader_name >", value, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("b_reader_name >=", value, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameLessThan(String value) {
            addCriterion("b_reader_name <", value, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameLessThanOrEqualTo(String value) {
            addCriterion("b_reader_name <=", value, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameLike(String value) {
            addCriterion("b_reader_name like", value, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameNotLike(String value) {
            addCriterion("b_reader_name not like", value, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameIn(List<String> values) {
            addCriterion("b_reader_name in", values, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameNotIn(List<String> values) {
            addCriterion("b_reader_name not in", values, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameBetween(String value1, String value2) {
            addCriterion("b_reader_name between", value1, value2, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderNameNotBetween(String value1, String value2) {
            addCriterion("b_reader_name not between", value1, value2, "bReaderName");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailIsNull() {
            addCriterion("b_reader_email is null");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailIsNotNull() {
            addCriterion("b_reader_email is not null");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailEqualTo(String value) {
            addCriterion("b_reader_email =", value, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailNotEqualTo(String value) {
            addCriterion("b_reader_email <>", value, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailGreaterThan(String value) {
            addCriterion("b_reader_email >", value, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailGreaterThanOrEqualTo(String value) {
            addCriterion("b_reader_email >=", value, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailLessThan(String value) {
            addCriterion("b_reader_email <", value, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailLessThanOrEqualTo(String value) {
            addCriterion("b_reader_email <=", value, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailLike(String value) {
            addCriterion("b_reader_email like", value, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailNotLike(String value) {
            addCriterion("b_reader_email not like", value, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailIn(List<String> values) {
            addCriterion("b_reader_email in", values, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailNotIn(List<String> values) {
            addCriterion("b_reader_email not in", values, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailBetween(String value1, String value2) {
            addCriterion("b_reader_email between", value1, value2, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderEmailNotBetween(String value1, String value2) {
            addCriterion("b_reader_email not between", value1, value2, "bReaderEmail");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordIsNull() {
            addCriterion("b_reader_password is null");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordIsNotNull() {
            addCriterion("b_reader_password is not null");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordEqualTo(String value) {
            addCriterion("b_reader_password =", value, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordNotEqualTo(String value) {
            addCriterion("b_reader_password <>", value, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordGreaterThan(String value) {
            addCriterion("b_reader_password >", value, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("b_reader_password >=", value, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordLessThan(String value) {
            addCriterion("b_reader_password <", value, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordLessThanOrEqualTo(String value) {
            addCriterion("b_reader_password <=", value, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordLike(String value) {
            addCriterion("b_reader_password like", value, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordNotLike(String value) {
            addCriterion("b_reader_password not like", value, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordIn(List<String> values) {
            addCriterion("b_reader_password in", values, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordNotIn(List<String> values) {
            addCriterion("b_reader_password not in", values, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordBetween(String value1, String value2) {
            addCriterion("b_reader_password between", value1, value2, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderPasswordNotBetween(String value1, String value2) {
            addCriterion("b_reader_password not between", value1, value2, "bReaderPassword");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberIsNull() {
            addCriterion("b_reader_borrow_number is null");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberIsNotNull() {
            addCriterion("b_reader_borrow_number is not null");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberEqualTo(Integer value) {
            addCriterion("b_reader_borrow_number =", value, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberNotEqualTo(Integer value) {
            addCriterion("b_reader_borrow_number <>", value, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberGreaterThan(Integer value) {
            addCriterion("b_reader_borrow_number >", value, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_reader_borrow_number >=", value, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberLessThan(Integer value) {
            addCriterion("b_reader_borrow_number <", value, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberLessThanOrEqualTo(Integer value) {
            addCriterion("b_reader_borrow_number <=", value, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberIn(List<Integer> values) {
            addCriterion("b_reader_borrow_number in", values, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberNotIn(List<Integer> values) {
            addCriterion("b_reader_borrow_number not in", values, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberBetween(Integer value1, Integer value2) {
            addCriterion("b_reader_borrow_number between", value1, value2, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("b_reader_borrow_number not between", value1, value2, "bReaderBorrowNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberIsNull() {
            addCriterion("b_reader_borrow_already_number is null");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberIsNotNull() {
            addCriterion("b_reader_borrow_already_number is not null");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberEqualTo(Integer value) {
            addCriterion("b_reader_borrow_already_number =", value, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberNotEqualTo(Integer value) {
            addCriterion("b_reader_borrow_already_number <>", value, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberGreaterThan(Integer value) {
            addCriterion("b_reader_borrow_already_number >", value, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_reader_borrow_already_number >=", value, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberLessThan(Integer value) {
            addCriterion("b_reader_borrow_already_number <", value, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberLessThanOrEqualTo(Integer value) {
            addCriterion("b_reader_borrow_already_number <=", value, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberIn(List<Integer> values) {
            addCriterion("b_reader_borrow_already_number in", values, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberNotIn(List<Integer> values) {
            addCriterion("b_reader_borrow_already_number not in", values, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberBetween(Integer value1, Integer value2) {
            addCriterion("b_reader_borrow_already_number between", value1, value2, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowAlreadyNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("b_reader_borrow_already_number not between", value1, value2, "bReaderBorrowAlreadyNumber");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeIsNull() {
            addCriterion("b_reader_borrow_time is null");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeIsNotNull() {
            addCriterion("b_reader_borrow_time is not null");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeEqualTo(String value) {
            addCriterion("b_reader_borrow_time =", value, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeNotEqualTo(String value) {
            addCriterion("b_reader_borrow_time <>", value, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeGreaterThan(String value) {
            addCriterion("b_reader_borrow_time >", value, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeGreaterThanOrEqualTo(String value) {
            addCriterion("b_reader_borrow_time >=", value, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeLessThan(String value) {
            addCriterion("b_reader_borrow_time <", value, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeLessThanOrEqualTo(String value) {
            addCriterion("b_reader_borrow_time <=", value, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeLike(String value) {
            addCriterion("b_reader_borrow_time like", value, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeNotLike(String value) {
            addCriterion("b_reader_borrow_time not like", value, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeIn(List<String> values) {
            addCriterion("b_reader_borrow_time in", values, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeNotIn(List<String> values) {
            addCriterion("b_reader_borrow_time not in", values, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeBetween(String value1, String value2) {
            addCriterion("b_reader_borrow_time between", value1, value2, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderBorrowTimeNotBetween(String value1, String value2) {
            addCriterion("b_reader_borrow_time not between", value1, value2, "bReaderBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileIsNull() {
            addCriterion("b_reader_moile is null");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileIsNotNull() {
            addCriterion("b_reader_moile is not null");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileEqualTo(String value) {
            addCriterion("b_reader_moile =", value, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileNotEqualTo(String value) {
            addCriterion("b_reader_moile <>", value, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileGreaterThan(String value) {
            addCriterion("b_reader_moile >", value, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileGreaterThanOrEqualTo(String value) {
            addCriterion("b_reader_moile >=", value, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileLessThan(String value) {
            addCriterion("b_reader_moile <", value, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileLessThanOrEqualTo(String value) {
            addCriterion("b_reader_moile <=", value, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileLike(String value) {
            addCriterion("b_reader_moile like", value, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileNotLike(String value) {
            addCriterion("b_reader_moile not like", value, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileIn(List<String> values) {
            addCriterion("b_reader_moile in", values, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileNotIn(List<String> values) {
            addCriterion("b_reader_moile not in", values, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileBetween(String value1, String value2) {
            addCriterion("b_reader_moile between", value1, value2, "bReaderMoile");
            return (Criteria) this;
        }

        public Criteria andBReaderMoileNotBetween(String value1, String value2) {
            addCriterion("b_reader_moile not between", value1, value2, "bReaderMoile");
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