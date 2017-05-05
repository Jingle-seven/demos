package generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class CloudinsConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CloudinsConfigExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andModuleIsNull() {
            addCriterion("module is null");
            return (Criteria) this;
        }

        public Criteria andModuleIsNotNull() {
            addCriterion("module is not null");
            return (Criteria) this;
        }

        public Criteria andModuleEqualTo(String value) {
            addCriterion("module =", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotEqualTo(String value) {
            addCriterion("module <>", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThan(String value) {
            addCriterion("module >", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThanOrEqualTo(String value) {
            addCriterion("module >=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThan(String value) {
            addCriterion("module <", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThanOrEqualTo(String value) {
            addCriterion("module <=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLike(String value) {
            addCriterion("module like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotLike(String value) {
            addCriterion("module not like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleIn(List<String> values) {
            addCriterion("module in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotIn(List<String> values) {
            addCriterion("module not in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleBetween(String value1, String value2) {
            addCriterion("module between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotBetween(String value1, String value2) {
            addCriterion("module not between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andParmAliasIsNull() {
            addCriterion("parm_alias is null");
            return (Criteria) this;
        }

        public Criteria andParmAliasIsNotNull() {
            addCriterion("parm_alias is not null");
            return (Criteria) this;
        }

        public Criteria andParmAliasEqualTo(String value) {
            addCriterion("parm_alias =", value, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasNotEqualTo(String value) {
            addCriterion("parm_alias <>", value, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasGreaterThan(String value) {
            addCriterion("parm_alias >", value, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasGreaterThanOrEqualTo(String value) {
            addCriterion("parm_alias >=", value, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasLessThan(String value) {
            addCriterion("parm_alias <", value, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasLessThanOrEqualTo(String value) {
            addCriterion("parm_alias <=", value, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasLike(String value) {
            addCriterion("parm_alias like", value, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasNotLike(String value) {
            addCriterion("parm_alias not like", value, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasIn(List<String> values) {
            addCriterion("parm_alias in", values, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasNotIn(List<String> values) {
            addCriterion("parm_alias not in", values, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasBetween(String value1, String value2) {
            addCriterion("parm_alias between", value1, value2, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmAliasNotBetween(String value1, String value2) {
            addCriterion("parm_alias not between", value1, value2, "parmAlias");
            return (Criteria) this;
        }

        public Criteria andParmNameIsNull() {
            addCriterion("parm_name is null");
            return (Criteria) this;
        }

        public Criteria andParmNameIsNotNull() {
            addCriterion("parm_name is not null");
            return (Criteria) this;
        }

        public Criteria andParmNameEqualTo(String value) {
            addCriterion("parm_name =", value, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameNotEqualTo(String value) {
            addCriterion("parm_name <>", value, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameGreaterThan(String value) {
            addCriterion("parm_name >", value, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameGreaterThanOrEqualTo(String value) {
            addCriterion("parm_name >=", value, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameLessThan(String value) {
            addCriterion("parm_name <", value, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameLessThanOrEqualTo(String value) {
            addCriterion("parm_name <=", value, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameLike(String value) {
            addCriterion("parm_name like", value, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameNotLike(String value) {
            addCriterion("parm_name not like", value, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameIn(List<String> values) {
            addCriterion("parm_name in", values, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameNotIn(List<String> values) {
            addCriterion("parm_name not in", values, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameBetween(String value1, String value2) {
            addCriterion("parm_name between", value1, value2, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmNameNotBetween(String value1, String value2) {
            addCriterion("parm_name not between", value1, value2, "parmName");
            return (Criteria) this;
        }

        public Criteria andParmValueIsNull() {
            addCriterion("parm_value is null");
            return (Criteria) this;
        }

        public Criteria andParmValueIsNotNull() {
            addCriterion("parm_value is not null");
            return (Criteria) this;
        }

        public Criteria andParmValueEqualTo(String value) {
            addCriterion("parm_value =", value, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueNotEqualTo(String value) {
            addCriterion("parm_value <>", value, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueGreaterThan(String value) {
            addCriterion("parm_value >", value, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueGreaterThanOrEqualTo(String value) {
            addCriterion("parm_value >=", value, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueLessThan(String value) {
            addCriterion("parm_value <", value, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueLessThanOrEqualTo(String value) {
            addCriterion("parm_value <=", value, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueLike(String value) {
            addCriterion("parm_value like", value, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueNotLike(String value) {
            addCriterion("parm_value not like", value, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueIn(List<String> values) {
            addCriterion("parm_value in", values, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueNotIn(List<String> values) {
            addCriterion("parm_value not in", values, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueBetween(String value1, String value2) {
            addCriterion("parm_value between", value1, value2, "parmValue");
            return (Criteria) this;
        }

        public Criteria andParmValueNotBetween(String value1, String value2) {
            addCriterion("parm_value not between", value1, value2, "parmValue");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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