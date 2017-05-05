package generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class TraceInfosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TraceInfosExample() {
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

        public Criteria andTraceMd5IsNull() {
            addCriterion("trace_md5 is null");
            return (Criteria) this;
        }

        public Criteria andTraceMd5IsNotNull() {
            addCriterion("trace_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andTraceMd5EqualTo(String value) {
            addCriterion("trace_md5 =", value, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5NotEqualTo(String value) {
            addCriterion("trace_md5 <>", value, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5GreaterThan(String value) {
            addCriterion("trace_md5 >", value, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5GreaterThanOrEqualTo(String value) {
            addCriterion("trace_md5 >=", value, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5LessThan(String value) {
            addCriterion("trace_md5 <", value, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5LessThanOrEqualTo(String value) {
            addCriterion("trace_md5 <=", value, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5Like(String value) {
            addCriterion("trace_md5 like", value, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5NotLike(String value) {
            addCriterion("trace_md5 not like", value, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5In(List<String> values) {
            addCriterion("trace_md5 in", values, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5NotIn(List<String> values) {
            addCriterion("trace_md5 not in", values, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5Between(String value1, String value2) {
            addCriterion("trace_md5 between", value1, value2, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andTraceMd5NotBetween(String value1, String value2) {
            addCriterion("trace_md5 not between", value1, value2, "traceMd5");
            return (Criteria) this;
        }

        public Criteria andRootNameIsNull() {
            addCriterion("root_name is null");
            return (Criteria) this;
        }

        public Criteria andRootNameIsNotNull() {
            addCriterion("root_name is not null");
            return (Criteria) this;
        }

        public Criteria andRootNameEqualTo(String value) {
            addCriterion("root_name =", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameNotEqualTo(String value) {
            addCriterion("root_name <>", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameGreaterThan(String value) {
            addCriterion("root_name >", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameGreaterThanOrEqualTo(String value) {
            addCriterion("root_name >=", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameLessThan(String value) {
            addCriterion("root_name <", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameLessThanOrEqualTo(String value) {
            addCriterion("root_name <=", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameLike(String value) {
            addCriterion("root_name like", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameNotLike(String value) {
            addCriterion("root_name not like", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameIn(List<String> values) {
            addCriterion("root_name in", values, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameNotIn(List<String> values) {
            addCriterion("root_name not in", values, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameBetween(String value1, String value2) {
            addCriterion("root_name between", value1, value2, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameNotBetween(String value1, String value2) {
            addCriterion("root_name not between", value1, value2, "rootName");
            return (Criteria) this;
        }

        public Criteria andTraceNameIsNull() {
            addCriterion("trace_name is null");
            return (Criteria) this;
        }

        public Criteria andTraceNameIsNotNull() {
            addCriterion("trace_name is not null");
            return (Criteria) this;
        }

        public Criteria andTraceNameEqualTo(String value) {
            addCriterion("trace_name =", value, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameNotEqualTo(String value) {
            addCriterion("trace_name <>", value, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameGreaterThan(String value) {
            addCriterion("trace_name >", value, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameGreaterThanOrEqualTo(String value) {
            addCriterion("trace_name >=", value, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameLessThan(String value) {
            addCriterion("trace_name <", value, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameLessThanOrEqualTo(String value) {
            addCriterion("trace_name <=", value, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameLike(String value) {
            addCriterion("trace_name like", value, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameNotLike(String value) {
            addCriterion("trace_name not like", value, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameIn(List<String> values) {
            addCriterion("trace_name in", values, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameNotIn(List<String> values) {
            addCriterion("trace_name not in", values, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameBetween(String value1, String value2) {
            addCriterion("trace_name between", value1, value2, "traceName");
            return (Criteria) this;
        }

        public Criteria andTraceNameNotBetween(String value1, String value2) {
            addCriterion("trace_name not between", value1, value2, "traceName");
            return (Criteria) this;
        }

        public Criteria andSpanCountIsNull() {
            addCriterion("span_count is null");
            return (Criteria) this;
        }

        public Criteria andSpanCountIsNotNull() {
            addCriterion("span_count is not null");
            return (Criteria) this;
        }

        public Criteria andSpanCountEqualTo(Short value) {
            addCriterion("span_count =", value, "spanCount");
            return (Criteria) this;
        }

        public Criteria andSpanCountNotEqualTo(Short value) {
            addCriterion("span_count <>", value, "spanCount");
            return (Criteria) this;
        }

        public Criteria andSpanCountGreaterThan(Short value) {
            addCriterion("span_count >", value, "spanCount");
            return (Criteria) this;
        }

        public Criteria andSpanCountGreaterThanOrEqualTo(Short value) {
            addCriterion("span_count >=", value, "spanCount");
            return (Criteria) this;
        }

        public Criteria andSpanCountLessThan(Short value) {
            addCriterion("span_count <", value, "spanCount");
            return (Criteria) this;
        }

        public Criteria andSpanCountLessThanOrEqualTo(Short value) {
            addCriterion("span_count <=", value, "spanCount");
            return (Criteria) this;
        }

        public Criteria andSpanCountIn(List<Short> values) {
            addCriterion("span_count in", values, "spanCount");
            return (Criteria) this;
        }

        public Criteria andSpanCountNotIn(List<Short> values) {
            addCriterion("span_count not in", values, "spanCount");
            return (Criteria) this;
        }

        public Criteria andSpanCountBetween(Short value1, Short value2) {
            addCriterion("span_count between", value1, value2, "spanCount");
            return (Criteria) this;
        }

        public Criteria andSpanCountNotBetween(Short value1, Short value2) {
            addCriterion("span_count not between", value1, value2, "spanCount");
            return (Criteria) this;
        }

        public Criteria andTraceAliasIsNull() {
            addCriterion("trace_alias is null");
            return (Criteria) this;
        }

        public Criteria andTraceAliasIsNotNull() {
            addCriterion("trace_alias is not null");
            return (Criteria) this;
        }

        public Criteria andTraceAliasEqualTo(String value) {
            addCriterion("trace_alias =", value, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasNotEqualTo(String value) {
            addCriterion("trace_alias <>", value, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasGreaterThan(String value) {
            addCriterion("trace_alias >", value, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasGreaterThanOrEqualTo(String value) {
            addCriterion("trace_alias >=", value, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasLessThan(String value) {
            addCriterion("trace_alias <", value, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasLessThanOrEqualTo(String value) {
            addCriterion("trace_alias <=", value, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasLike(String value) {
            addCriterion("trace_alias like", value, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasNotLike(String value) {
            addCriterion("trace_alias not like", value, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasIn(List<String> values) {
            addCriterion("trace_alias in", values, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasNotIn(List<String> values) {
            addCriterion("trace_alias not in", values, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasBetween(String value1, String value2) {
            addCriterion("trace_alias between", value1, value2, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andTraceAliasNotBetween(String value1, String value2) {
            addCriterion("trace_alias not between", value1, value2, "traceAlias");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdIsNull() {
            addCriterion("base_trace_id is null");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdIsNotNull() {
            addCriterion("base_trace_id is not null");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdEqualTo(Long value) {
            addCriterion("base_trace_id =", value, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdNotEqualTo(Long value) {
            addCriterion("base_trace_id <>", value, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdGreaterThan(Long value) {
            addCriterion("base_trace_id >", value, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("base_trace_id >=", value, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdLessThan(Long value) {
            addCriterion("base_trace_id <", value, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdLessThanOrEqualTo(Long value) {
            addCriterion("base_trace_id <=", value, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdIn(List<Long> values) {
            addCriterion("base_trace_id in", values, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdNotIn(List<Long> values) {
            addCriterion("base_trace_id not in", values, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdBetween(Long value1, Long value2) {
            addCriterion("base_trace_id between", value1, value2, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andBaseTraceIdNotBetween(Long value1, Long value2) {
            addCriterion("base_trace_id not between", value1, value2, "baseTraceId");
            return (Criteria) this;
        }

        public Criteria andWarningDurationIsNull() {
            addCriterion("warning_duration is null");
            return (Criteria) this;
        }

        public Criteria andWarningDurationIsNotNull() {
            addCriterion("warning_duration is not null");
            return (Criteria) this;
        }

        public Criteria andWarningDurationEqualTo(Long value) {
            addCriterion("warning_duration =", value, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningDurationNotEqualTo(Long value) {
            addCriterion("warning_duration <>", value, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningDurationGreaterThan(Long value) {
            addCriterion("warning_duration >", value, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("warning_duration >=", value, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningDurationLessThan(Long value) {
            addCriterion("warning_duration <", value, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningDurationLessThanOrEqualTo(Long value) {
            addCriterion("warning_duration <=", value, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningDurationIn(List<Long> values) {
            addCriterion("warning_duration in", values, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningDurationNotIn(List<Long> values) {
            addCriterion("warning_duration not in", values, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningDurationBetween(Long value1, Long value2) {
            addCriterion("warning_duration between", value1, value2, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningDurationNotBetween(Long value1, Long value2) {
            addCriterion("warning_duration not between", value1, value2, "warningDuration");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageIsNull() {
            addCriterion("warning_percentage is null");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageIsNotNull() {
            addCriterion("warning_percentage is not null");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageEqualTo(Integer value) {
            addCriterion("warning_percentage =", value, "warningPercentage");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageNotEqualTo(Integer value) {
            addCriterion("warning_percentage <>", value, "warningPercentage");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageGreaterThan(Integer value) {
            addCriterion("warning_percentage >", value, "warningPercentage");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageGreaterThanOrEqualTo(Integer value) {
            addCriterion("warning_percentage >=", value, "warningPercentage");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageLessThan(Integer value) {
            addCriterion("warning_percentage <", value, "warningPercentage");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageLessThanOrEqualTo(Integer value) {
            addCriterion("warning_percentage <=", value, "warningPercentage");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageIn(List<Integer> values) {
            addCriterion("warning_percentage in", values, "warningPercentage");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageNotIn(List<Integer> values) {
            addCriterion("warning_percentage not in", values, "warningPercentage");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageBetween(Integer value1, Integer value2) {
            addCriterion("warning_percentage between", value1, value2, "warningPercentage");
            return (Criteria) this;
        }

        public Criteria andWarningPercentageNotBetween(Integer value1, Integer value2) {
            addCriterion("warning_percentage not between", value1, value2, "warningPercentage");
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