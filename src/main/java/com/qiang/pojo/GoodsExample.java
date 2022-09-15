package com.qiang.pojo;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(String value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(String value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(String value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(String value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(String value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(String value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLike(String value) {
            addCriterion("goods_price like", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotLike(String value) {
            addCriterion("goods_price not like", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<String> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<String> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(String value1, String value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(String value1, String value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsImageIsNull() {
            addCriterion("goods_image is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImageIsNotNull() {
            addCriterion("goods_image is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImageEqualTo(String value) {
            addCriterion("goods_image =", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotEqualTo(String value) {
            addCriterion("goods_image <>", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageGreaterThan(String value) {
            addCriterion("goods_image >", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageGreaterThanOrEqualTo(String value) {
            addCriterion("goods_image >=", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageLessThan(String value) {
            addCriterion("goods_image <", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageLessThanOrEqualTo(String value) {
            addCriterion("goods_image <=", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageLike(String value) {
            addCriterion("goods_image like", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotLike(String value) {
            addCriterion("goods_image not like", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageIn(List<String> values) {
            addCriterion("goods_image in", values, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotIn(List<String> values) {
            addCriterion("goods_image not in", values, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageBetween(String value1, String value2) {
            addCriterion("goods_image between", value1, value2, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotBetween(String value1, String value2) {
            addCriterion("goods_image not between", value1, value2, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionIsNull() {
            addCriterion("goods_description is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionIsNotNull() {
            addCriterion("goods_description is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionEqualTo(String value) {
            addCriterion("goods_description =", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotEqualTo(String value) {
            addCriterion("goods_description <>", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionGreaterThan(String value) {
            addCriterion("goods_description >", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("goods_description >=", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionLessThan(String value) {
            addCriterion("goods_description <", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionLessThanOrEqualTo(String value) {
            addCriterion("goods_description <=", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionLike(String value) {
            addCriterion("goods_description like", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotLike(String value) {
            addCriterion("goods_description not like", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionIn(List<String> values) {
            addCriterion("goods_description in", values, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotIn(List<String> values) {
            addCriterion("goods_description not in", values, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionBetween(String value1, String value2) {
            addCriterion("goods_description between", value1, value2, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotBetween(String value1, String value2) {
            addCriterion("goods_description not between", value1, value2, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeIsNull() {
            addCriterion("goods_degree is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeIsNotNull() {
            addCriterion("goods_degree is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeEqualTo(String value) {
            addCriterion("goods_degree =", value, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeNotEqualTo(String value) {
            addCriterion("goods_degree <>", value, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeGreaterThan(String value) {
            addCriterion("goods_degree >", value, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_degree >=", value, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeLessThan(String value) {
            addCriterion("goods_degree <", value, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeLessThanOrEqualTo(String value) {
            addCriterion("goods_degree <=", value, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeLike(String value) {
            addCriterion("goods_degree like", value, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeNotLike(String value) {
            addCriterion("goods_degree not like", value, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeIn(List<String> values) {
            addCriterion("goods_degree in", values, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeNotIn(List<String> values) {
            addCriterion("goods_degree not in", values, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeBetween(String value1, String value2) {
            addCriterion("goods_degree between", value1, value2, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsDegreeNotBetween(String value1, String value2) {
            addCriterion("goods_degree not between", value1, value2, "goodsDegree");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(Integer value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(Integer value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(Integer value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(Integer value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<Integer> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<Integer> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(Integer value1, Integer value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdIsNull() {
            addCriterion("goods_user_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdIsNotNull() {
            addCriterion("goods_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdEqualTo(Integer value) {
            addCriterion("goods_user_id =", value, "goodsUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdNotEqualTo(Integer value) {
            addCriterion("goods_user_id <>", value, "goodsUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdGreaterThan(Integer value) {
            addCriterion("goods_user_id >", value, "goodsUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_user_id >=", value, "goodsUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdLessThan(Integer value) {
            addCriterion("goods_user_id <", value, "goodsUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_user_id <=", value, "goodsUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdIn(List<Integer> values) {
            addCriterion("goods_user_id in", values, "goodsUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdNotIn(List<Integer> values) {
            addCriterion("goods_user_id not in", values, "goodsUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_user_id between", value1, value2, "goodsUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_user_id not between", value1, value2, "goodsUserId");
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