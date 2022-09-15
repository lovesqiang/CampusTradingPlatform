package com.qiang.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andCartGoodsIdIsNull() {
            addCriterion("cart_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdIsNotNull() {
            addCriterion("cart_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdEqualTo(Integer value) {
            addCriterion("cart_goods_id =", value, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdNotEqualTo(Integer value) {
            addCriterion("cart_goods_id <>", value, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdGreaterThan(Integer value) {
            addCriterion("cart_goods_id >", value, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_goods_id >=", value, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdLessThan(Integer value) {
            addCriterion("cart_goods_id <", value, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_goods_id <=", value, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdIn(List<Integer> values) {
            addCriterion("cart_goods_id in", values, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdNotIn(List<Integer> values) {
            addCriterion("cart_goods_id not in", values, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_goods_id between", value1, value2, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_goods_id not between", value1, value2, "cartGoodsId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdIsNull() {
            addCriterion("cart_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCartUserIdIsNotNull() {
            addCriterion("cart_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartUserIdEqualTo(Integer value) {
            addCriterion("cart_user_id =", value, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdNotEqualTo(Integer value) {
            addCriterion("cart_user_id <>", value, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdGreaterThan(Integer value) {
            addCriterion("cart_user_id >", value, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_user_id >=", value, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdLessThan(Integer value) {
            addCriterion("cart_user_id <", value, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_user_id <=", value, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdIn(List<Integer> values) {
            addCriterion("cart_user_id in", values, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdNotIn(List<Integer> values) {
            addCriterion("cart_user_id not in", values, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_user_id between", value1, value2, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_user_id not between", value1, value2, "cartUserId");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumIsNull() {
            addCriterion("cart_goods_num is null");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumIsNotNull() {
            addCriterion("cart_goods_num is not null");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumEqualTo(Integer value) {
            addCriterion("cart_goods_num =", value, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumNotEqualTo(Integer value) {
            addCriterion("cart_goods_num <>", value, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumGreaterThan(Integer value) {
            addCriterion("cart_goods_num >", value, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_goods_num >=", value, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumLessThan(Integer value) {
            addCriterion("cart_goods_num <", value, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumLessThanOrEqualTo(Integer value) {
            addCriterion("cart_goods_num <=", value, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumIn(List<Integer> values) {
            addCriterion("cart_goods_num in", values, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumNotIn(List<Integer> values) {
            addCriterion("cart_goods_num not in", values, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumBetween(Integer value1, Integer value2) {
            addCriterion("cart_goods_num between", value1, value2, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_goods_num not between", value1, value2, "cartGoodsNum");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceIsNull() {
            addCriterion("cart_goods_price is null");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceIsNotNull() {
            addCriterion("cart_goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("cart_goods_price =", value, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("cart_goods_price <>", value, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("cart_goods_price >", value, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cart_goods_price >=", value, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceLessThan(BigDecimal value) {
            addCriterion("cart_goods_price <", value, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cart_goods_price <=", value, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("cart_goods_price in", values, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("cart_goods_price not in", values, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cart_goods_price between", value1, value2, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cart_goods_price not between", value1, value2, "cartGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCartTotalIsNull() {
            addCriterion("cart_total is null");
            return (Criteria) this;
        }

        public Criteria andCartTotalIsNotNull() {
            addCriterion("cart_total is not null");
            return (Criteria) this;
        }

        public Criteria andCartTotalEqualTo(String value) {
            addCriterion("cart_total =", value, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalNotEqualTo(String value) {
            addCriterion("cart_total <>", value, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalGreaterThan(String value) {
            addCriterion("cart_total >", value, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalGreaterThanOrEqualTo(String value) {
            addCriterion("cart_total >=", value, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalLessThan(String value) {
            addCriterion("cart_total <", value, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalLessThanOrEqualTo(String value) {
            addCriterion("cart_total <=", value, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalLike(String value) {
            addCriterion("cart_total like", value, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalNotLike(String value) {
            addCriterion("cart_total not like", value, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalIn(List<String> values) {
            addCriterion("cart_total in", values, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalNotIn(List<String> values) {
            addCriterion("cart_total not in", values, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalBetween(String value1, String value2) {
            addCriterion("cart_total between", value1, value2, "cartTotal");
            return (Criteria) this;
        }

        public Criteria andCartTotalNotBetween(String value1, String value2) {
            addCriterion("cart_total not between", value1, value2, "cartTotal");
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