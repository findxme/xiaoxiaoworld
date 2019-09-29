package com.xmx.ssm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TBookReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBookReaderExample() {
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

        public Criteria andBBookReaderIdIsNull() {
            addCriterion("b_book_reader_id is null");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdIsNotNull() {
            addCriterion("b_book_reader_id is not null");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdEqualTo(Integer value) {
            addCriterion("b_book_reader_id =", value, "bBookReaderId");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdNotEqualTo(Integer value) {
            addCriterion("b_book_reader_id <>", value, "bBookReaderId");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdGreaterThan(Integer value) {
            addCriterion("b_book_reader_id >", value, "bBookReaderId");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_book_reader_id >=", value, "bBookReaderId");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdLessThan(Integer value) {
            addCriterion("b_book_reader_id <", value, "bBookReaderId");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_book_reader_id <=", value, "bBookReaderId");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdIn(List<Integer> values) {
            addCriterion("b_book_reader_id in", values, "bBookReaderId");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdNotIn(List<Integer> values) {
            addCriterion("b_book_reader_id not in", values, "bBookReaderId");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdBetween(Integer value1, Integer value2) {
            addCriterion("b_book_reader_id between", value1, value2, "bBookReaderId");
            return (Criteria) this;
        }

        public Criteria andBBookReaderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_book_reader_id not between", value1, value2, "bBookReaderId");
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

        public Criteria andBUserNoIsNull() {
            addCriterion("b_user_no is null");
            return (Criteria) this;
        }

        public Criteria andBUserNoIsNotNull() {
            addCriterion("b_user_no is not null");
            return (Criteria) this;
        }

        public Criteria andBUserNoEqualTo(String value) {
            addCriterion("b_user_no =", value, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoNotEqualTo(String value) {
            addCriterion("b_user_no <>", value, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoGreaterThan(String value) {
            addCriterion("b_user_no >", value, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("b_user_no >=", value, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoLessThan(String value) {
            addCriterion("b_user_no <", value, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoLessThanOrEqualTo(String value) {
            addCriterion("b_user_no <=", value, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoLike(String value) {
            addCriterion("b_user_no like", value, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoNotLike(String value) {
            addCriterion("b_user_no not like", value, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoIn(List<String> values) {
            addCriterion("b_user_no in", values, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoNotIn(List<String> values) {
            addCriterion("b_user_no not in", values, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoBetween(String value1, String value2) {
            addCriterion("b_user_no between", value1, value2, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBUserNoNotBetween(String value1, String value2) {
            addCriterion("b_user_no not between", value1, value2, "bUserNo");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateIsNull() {
            addCriterion("b_borrow_date is null");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateIsNotNull() {
            addCriterion("b_borrow_date is not null");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateEqualTo(Date value) {
            addCriterionForJDBCDate("b_borrow_date =", value, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("b_borrow_date <>", value, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateGreaterThan(Date value) {
            addCriterionForJDBCDate("b_borrow_date >", value, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_borrow_date >=", value, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateLessThan(Date value) {
            addCriterionForJDBCDate("b_borrow_date <", value, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_borrow_date <=", value, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateIn(List<Date> values) {
            addCriterionForJDBCDate("b_borrow_date in", values, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("b_borrow_date not in", values, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_borrow_date between", value1, value2, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBBorrowDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_borrow_date not between", value1, value2, "bBorrowDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateIsNull() {
            addCriterion("b_return_date is null");
            return (Criteria) this;
        }

        public Criteria andBReturnDateIsNotNull() {
            addCriterion("b_return_date is not null");
            return (Criteria) this;
        }

        public Criteria andBReturnDateEqualTo(Date value) {
            addCriterionForJDBCDate("b_return_date =", value, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("b_return_date <>", value, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateGreaterThan(Date value) {
            addCriterionForJDBCDate("b_return_date >", value, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_return_date >=", value, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateLessThan(Date value) {
            addCriterionForJDBCDate("b_return_date <", value, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_return_date <=", value, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateIn(List<Date> values) {
            addCriterionForJDBCDate("b_return_date in", values, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("b_return_date not in", values, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_return_date between", value1, value2, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBReturnDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_return_date not between", value1, value2, "bReturnDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateIsNull() {
            addCriterion("b_over_date is null");
            return (Criteria) this;
        }

        public Criteria andBOverDateIsNotNull() {
            addCriterion("b_over_date is not null");
            return (Criteria) this;
        }

        public Criteria andBOverDateEqualTo(Integer value) {
            addCriterion("b_over_date =", value, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateNotEqualTo(Integer value) {
            addCriterion("b_over_date <>", value, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateGreaterThan(Integer value) {
            addCriterion("b_over_date >", value, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_over_date >=", value, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateLessThan(Integer value) {
            addCriterion("b_over_date <", value, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateLessThanOrEqualTo(Integer value) {
            addCriterion("b_over_date <=", value, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateIn(List<Integer> values) {
            addCriterion("b_over_date in", values, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateNotIn(List<Integer> values) {
            addCriterion("b_over_date not in", values, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateBetween(Integer value1, Integer value2) {
            addCriterion("b_over_date between", value1, value2, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andBOverDateNotBetween(Integer value1, Integer value2) {
            addCriterion("b_over_date not between", value1, value2, "bOverDate");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookIsNull() {
            addCriterion("is_return_book is null");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookIsNotNull() {
            addCriterion("is_return_book is not null");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookEqualTo(String value) {
            addCriterion("is_return_book =", value, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookNotEqualTo(String value) {
            addCriterion("is_return_book <>", value, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookGreaterThan(String value) {
            addCriterion("is_return_book >", value, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookGreaterThanOrEqualTo(String value) {
            addCriterion("is_return_book >=", value, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookLessThan(String value) {
            addCriterion("is_return_book <", value, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookLessThanOrEqualTo(String value) {
            addCriterion("is_return_book <=", value, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookLike(String value) {
            addCriterion("is_return_book like", value, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookNotLike(String value) {
            addCriterion("is_return_book not like", value, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookIn(List<String> values) {
            addCriterion("is_return_book in", values, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookNotIn(List<String> values) {
            addCriterion("is_return_book not in", values, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookBetween(String value1, String value2) {
            addCriterion("is_return_book between", value1, value2, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andIsReturnBookNotBetween(String value1, String value2) {
            addCriterion("is_return_book not between", value1, value2, "isReturnBook");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyIsNull() {
            addCriterion("b_renew_frequency is null");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyIsNotNull() {
            addCriterion("b_renew_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyEqualTo(Integer value) {
            addCriterion("b_renew_frequency =", value, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyNotEqualTo(Integer value) {
            addCriterion("b_renew_frequency <>", value, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyGreaterThan(Integer value) {
            addCriterion("b_renew_frequency >", value, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_renew_frequency >=", value, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyLessThan(Integer value) {
            addCriterion("b_renew_frequency <", value, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("b_renew_frequency <=", value, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyIn(List<Integer> values) {
            addCriterion("b_renew_frequency in", values, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyNotIn(List<Integer> values) {
            addCriterion("b_renew_frequency not in", values, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("b_renew_frequency between", value1, value2, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("b_renew_frequency not between", value1, value2, "bRenewFrequency");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeIsNull() {
            addCriterion("b_renew_time is null");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeIsNotNull() {
            addCriterion("b_renew_time is not null");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeEqualTo(Integer value) {
            addCriterion("b_renew_time =", value, "bRenewTime");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeNotEqualTo(Integer value) {
            addCriterion("b_renew_time <>", value, "bRenewTime");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeGreaterThan(Integer value) {
            addCriterion("b_renew_time >", value, "bRenewTime");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_renew_time >=", value, "bRenewTime");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeLessThan(Integer value) {
            addCriterion("b_renew_time <", value, "bRenewTime");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeLessThanOrEqualTo(Integer value) {
            addCriterion("b_renew_time <=", value, "bRenewTime");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeIn(List<Integer> values) {
            addCriterion("b_renew_time in", values, "bRenewTime");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeNotIn(List<Integer> values) {
            addCriterion("b_renew_time not in", values, "bRenewTime");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeBetween(Integer value1, Integer value2) {
            addCriterion("b_renew_time between", value1, value2, "bRenewTime");
            return (Criteria) this;
        }

        public Criteria andBRenewTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("b_renew_time not between", value1, value2, "bRenewTime");
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