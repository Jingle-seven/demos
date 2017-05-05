package generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class SpanInfosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpanInfosExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAliasIsNull() {
            addCriterion("alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("alias not between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andDefBaselineIsNull() {
            addCriterion("def_baseline is null");
            return (Criteria) this;
        }

        public Criteria andDefBaselineIsNotNull() {
            addCriterion("def_baseline is not null");
            return (Criteria) this;
        }

        public Criteria andDefBaselineEqualTo(String value) {
            addCriterion("def_baseline =", value, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineNotEqualTo(String value) {
            addCriterion("def_baseline <>", value, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineGreaterThan(String value) {
            addCriterion("def_baseline >", value, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineGreaterThanOrEqualTo(String value) {
            addCriterion("def_baseline >=", value, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineLessThan(String value) {
            addCriterion("def_baseline <", value, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineLessThanOrEqualTo(String value) {
            addCriterion("def_baseline <=", value, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineLike(String value) {
            addCriterion("def_baseline like", value, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineNotLike(String value) {
            addCriterion("def_baseline not like", value, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineIn(List<String> values) {
            addCriterion("def_baseline in", values, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineNotIn(List<String> values) {
            addCriterion("def_baseline not in", values, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineBetween(String value1, String value2) {
            addCriterion("def_baseline between", value1, value2, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andDefBaselineNotBetween(String value1, String value2) {
            addCriterion("def_baseline not between", value1, value2, "defBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineIsNull() {
            addCriterion("cust_baseline is null");
            return (Criteria) this;
        }

        public Criteria andCustBaselineIsNotNull() {
            addCriterion("cust_baseline is not null");
            return (Criteria) this;
        }

        public Criteria andCustBaselineEqualTo(String value) {
            addCriterion("cust_baseline =", value, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineNotEqualTo(String value) {
            addCriterion("cust_baseline <>", value, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineGreaterThan(String value) {
            addCriterion("cust_baseline >", value, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineGreaterThanOrEqualTo(String value) {
            addCriterion("cust_baseline >=", value, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineLessThan(String value) {
            addCriterion("cust_baseline <", value, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineLessThanOrEqualTo(String value) {
            addCriterion("cust_baseline <=", value, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineLike(String value) {
            addCriterion("cust_baseline like", value, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineNotLike(String value) {
            addCriterion("cust_baseline not like", value, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineIn(List<String> values) {
            addCriterion("cust_baseline in", values, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineNotIn(List<String> values) {
            addCriterion("cust_baseline not in", values, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineBetween(String value1, String value2) {
            addCriterion("cust_baseline between", value1, value2, "custBaseline");
            return (Criteria) this;
        }

        public Criteria andCustBaselineNotBetween(String value1, String value2) {
            addCriterion("cust_baseline not between", value1, value2, "custBaseline");
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