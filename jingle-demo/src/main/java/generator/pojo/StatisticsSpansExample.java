package generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class StatisticsSpansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsSpansExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andSpanNameIsNull() {
            addCriterion("span_name is null");
            return (Criteria) this;
        }

        public Criteria andSpanNameIsNotNull() {
            addCriterion("span_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpanNameEqualTo(String value) {
            addCriterion("span_name =", value, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameNotEqualTo(String value) {
            addCriterion("span_name <>", value, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameGreaterThan(String value) {
            addCriterion("span_name >", value, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameGreaterThanOrEqualTo(String value) {
            addCriterion("span_name >=", value, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameLessThan(String value) {
            addCriterion("span_name <", value, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameLessThanOrEqualTo(String value) {
            addCriterion("span_name <=", value, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameLike(String value) {
            addCriterion("span_name like", value, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameNotLike(String value) {
            addCriterion("span_name not like", value, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameIn(List<String> values) {
            addCriterion("span_name in", values, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameNotIn(List<String> values) {
            addCriterion("span_name not in", values, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameBetween(String value1, String value2) {
            addCriterion("span_name between", value1, value2, "spanName");
            return (Criteria) this;
        }

        public Criteria andSpanNameNotBetween(String value1, String value2) {
            addCriterion("span_name not between", value1, value2, "spanName");
            return (Criteria) this;
        }

        public Criteria andCalledNumIsNull() {
            addCriterion("called_num is null");
            return (Criteria) this;
        }

        public Criteria andCalledNumIsNotNull() {
            addCriterion("called_num is not null");
            return (Criteria) this;
        }

        public Criteria andCalledNumEqualTo(String value) {
            addCriterion("called_num =", value, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumNotEqualTo(String value) {
            addCriterion("called_num <>", value, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumGreaterThan(String value) {
            addCriterion("called_num >", value, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumGreaterThanOrEqualTo(String value) {
            addCriterion("called_num >=", value, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumLessThan(String value) {
            addCriterion("called_num <", value, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumLessThanOrEqualTo(String value) {
            addCriterion("called_num <=", value, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumLike(String value) {
            addCriterion("called_num like", value, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumNotLike(String value) {
            addCriterion("called_num not like", value, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumIn(List<String> values) {
            addCriterion("called_num in", values, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumNotIn(List<String> values) {
            addCriterion("called_num not in", values, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumBetween(String value1, String value2) {
            addCriterion("called_num between", value1, value2, "calledNum");
            return (Criteria) this;
        }

        public Criteria andCalledNumNotBetween(String value1, String value2) {
            addCriterion("called_num not between", value1, value2, "calledNum");
            return (Criteria) this;
        }

        public Criteria andAvgTimeIsNull() {
            addCriterion("avg_time is null");
            return (Criteria) this;
        }

        public Criteria andAvgTimeIsNotNull() {
            addCriterion("avg_time is not null");
            return (Criteria) this;
        }

        public Criteria andAvgTimeEqualTo(String value) {
            addCriterion("avg_time =", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeNotEqualTo(String value) {
            addCriterion("avg_time <>", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeGreaterThan(String value) {
            addCriterion("avg_time >", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeGreaterThanOrEqualTo(String value) {
            addCriterion("avg_time >=", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeLessThan(String value) {
            addCriterion("avg_time <", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeLessThanOrEqualTo(String value) {
            addCriterion("avg_time <=", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeLike(String value) {
            addCriterion("avg_time like", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeNotLike(String value) {
            addCriterion("avg_time not like", value, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeIn(List<String> values) {
            addCriterion("avg_time in", values, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeNotIn(List<String> values) {
            addCriterion("avg_time not in", values, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeBetween(String value1, String value2) {
            addCriterion("avg_time between", value1, value2, "avgTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimeNotBetween(String value1, String value2) {
            addCriterion("avg_time not between", value1, value2, "avgTime");
            return (Criteria) this;
        }

        public Criteria andSlowestIdIsNull() {
            addCriterion("slowest_id is null");
            return (Criteria) this;
        }

        public Criteria andSlowestIdIsNotNull() {
            addCriterion("slowest_id is not null");
            return (Criteria) this;
        }

        public Criteria andSlowestIdEqualTo(String value) {
            addCriterion("slowest_id =", value, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdNotEqualTo(String value) {
            addCriterion("slowest_id <>", value, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdGreaterThan(String value) {
            addCriterion("slowest_id >", value, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdGreaterThanOrEqualTo(String value) {
            addCriterion("slowest_id >=", value, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdLessThan(String value) {
            addCriterion("slowest_id <", value, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdLessThanOrEqualTo(String value) {
            addCriterion("slowest_id <=", value, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdLike(String value) {
            addCriterion("slowest_id like", value, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdNotLike(String value) {
            addCriterion("slowest_id not like", value, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdIn(List<String> values) {
            addCriterion("slowest_id in", values, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdNotIn(List<String> values) {
            addCriterion("slowest_id not in", values, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdBetween(String value1, String value2) {
            addCriterion("slowest_id between", value1, value2, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestIdNotBetween(String value1, String value2) {
            addCriterion("slowest_id not between", value1, value2, "slowestId");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeIsNull() {
            addCriterion("slowest_time is null");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeIsNotNull() {
            addCriterion("slowest_time is not null");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeEqualTo(String value) {
            addCriterion("slowest_time =", value, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeNotEqualTo(String value) {
            addCriterion("slowest_time <>", value, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeGreaterThan(String value) {
            addCriterion("slowest_time >", value, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeGreaterThanOrEqualTo(String value) {
            addCriterion("slowest_time >=", value, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeLessThan(String value) {
            addCriterion("slowest_time <", value, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeLessThanOrEqualTo(String value) {
            addCriterion("slowest_time <=", value, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeLike(String value) {
            addCriterion("slowest_time like", value, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeNotLike(String value) {
            addCriterion("slowest_time not like", value, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeIn(List<String> values) {
            addCriterion("slowest_time in", values, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeNotIn(List<String> values) {
            addCriterion("slowest_time not in", values, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeBetween(String value1, String value2) {
            addCriterion("slowest_time between", value1, value2, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestTimeNotBetween(String value1, String value2) {
            addCriterion("slowest_time not between", value1, value2, "slowestTime");
            return (Criteria) this;
        }

        public Criteria andSlowestHostIsNull() {
            addCriterion("slowest_host is null");
            return (Criteria) this;
        }

        public Criteria andSlowestHostIsNotNull() {
            addCriterion("slowest_host is not null");
            return (Criteria) this;
        }

        public Criteria andSlowestHostEqualTo(String value) {
            addCriterion("slowest_host =", value, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostNotEqualTo(String value) {
            addCriterion("slowest_host <>", value, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostGreaterThan(String value) {
            addCriterion("slowest_host >", value, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostGreaterThanOrEqualTo(String value) {
            addCriterion("slowest_host >=", value, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostLessThan(String value) {
            addCriterion("slowest_host <", value, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostLessThanOrEqualTo(String value) {
            addCriterion("slowest_host <=", value, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostLike(String value) {
            addCriterion("slowest_host like", value, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostNotLike(String value) {
            addCriterion("slowest_host not like", value, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostIn(List<String> values) {
            addCriterion("slowest_host in", values, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostNotIn(List<String> values) {
            addCriterion("slowest_host not in", values, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostBetween(String value1, String value2) {
            addCriterion("slowest_host between", value1, value2, "slowestHost");
            return (Criteria) this;
        }

        public Criteria andSlowestHostNotBetween(String value1, String value2) {
            addCriterion("slowest_host not between", value1, value2, "slowestHost");
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