package generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class TracesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TracesExample() {
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

        public Criteria andTraceIdIsNull() {
            addCriterion("trace_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceIdIsNotNull() {
            addCriterion("trace_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceIdEqualTo(Long value) {
            addCriterion("trace_id =", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdNotEqualTo(Long value) {
            addCriterion("trace_id <>", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdGreaterThan(Long value) {
            addCriterion("trace_id >", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("trace_id >=", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdLessThan(Long value) {
            addCriterion("trace_id <", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdLessThanOrEqualTo(Long value) {
            addCriterion("trace_id <=", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdIn(List<Long> values) {
            addCriterion("trace_id in", values, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdNotIn(List<Long> values) {
            addCriterion("trace_id not in", values, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdBetween(Long value1, Long value2) {
            addCriterion("trace_id between", value1, value2, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdNotBetween(Long value1, Long value2) {
            addCriterion("trace_id not between", value1, value2, "traceId");
            return (Criteria) this;
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

        public Criteria andStartTsIsNull() {
            addCriterion("start_ts is null");
            return (Criteria) this;
        }

        public Criteria andStartTsIsNotNull() {
            addCriterion("start_ts is not null");
            return (Criteria) this;
        }

        public Criteria andStartTsEqualTo(Long value) {
            addCriterion("start_ts =", value, "startTs");
            return (Criteria) this;
        }

        public Criteria andStartTsNotEqualTo(Long value) {
            addCriterion("start_ts <>", value, "startTs");
            return (Criteria) this;
        }

        public Criteria andStartTsGreaterThan(Long value) {
            addCriterion("start_ts >", value, "startTs");
            return (Criteria) this;
        }

        public Criteria andStartTsGreaterThanOrEqualTo(Long value) {
            addCriterion("start_ts >=", value, "startTs");
            return (Criteria) this;
        }

        public Criteria andStartTsLessThan(Long value) {
            addCriterion("start_ts <", value, "startTs");
            return (Criteria) this;
        }

        public Criteria andStartTsLessThanOrEqualTo(Long value) {
            addCriterion("start_ts <=", value, "startTs");
            return (Criteria) this;
        }

        public Criteria andStartTsIn(List<Long> values) {
            addCriterion("start_ts in", values, "startTs");
            return (Criteria) this;
        }

        public Criteria andStartTsNotIn(List<Long> values) {
            addCriterion("start_ts not in", values, "startTs");
            return (Criteria) this;
        }

        public Criteria andStartTsBetween(Long value1, Long value2) {
            addCriterion("start_ts between", value1, value2, "startTs");
            return (Criteria) this;
        }

        public Criteria andStartTsNotBetween(Long value1, Long value2) {
            addCriterion("start_ts not between", value1, value2, "startTs");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Long value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Long value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Long value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Long value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Long value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Long> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Long> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Long value1, Long value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Long value1, Long value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andEndTsIsNull() {
            addCriterion("end_ts is null");
            return (Criteria) this;
        }

        public Criteria andEndTsIsNotNull() {
            addCriterion("end_ts is not null");
            return (Criteria) this;
        }

        public Criteria andEndTsEqualTo(Long value) {
            addCriterion("end_ts =", value, "endTs");
            return (Criteria) this;
        }

        public Criteria andEndTsNotEqualTo(Long value) {
            addCriterion("end_ts <>", value, "endTs");
            return (Criteria) this;
        }

        public Criteria andEndTsGreaterThan(Long value) {
            addCriterion("end_ts >", value, "endTs");
            return (Criteria) this;
        }

        public Criteria andEndTsGreaterThanOrEqualTo(Long value) {
            addCriterion("end_ts >=", value, "endTs");
            return (Criteria) this;
        }

        public Criteria andEndTsLessThan(Long value) {
            addCriterion("end_ts <", value, "endTs");
            return (Criteria) this;
        }

        public Criteria andEndTsLessThanOrEqualTo(Long value) {
            addCriterion("end_ts <=", value, "endTs");
            return (Criteria) this;
        }

        public Criteria andEndTsIn(List<Long> values) {
            addCriterion("end_ts in", values, "endTs");
            return (Criteria) this;
        }

        public Criteria andEndTsNotIn(List<Long> values) {
            addCriterion("end_ts not in", values, "endTs");
            return (Criteria) this;
        }

        public Criteria andEndTsBetween(Long value1, Long value2) {
            addCriterion("end_ts between", value1, value2, "endTs");
            return (Criteria) this;
        }

        public Criteria andEndTsNotBetween(Long value1, Long value2) {
            addCriterion("end_ts not between", value1, value2, "endTs");
            return (Criteria) this;
        }

        public Criteria andTeamCodeIsNull() {
            addCriterion("team_code is null");
            return (Criteria) this;
        }

        public Criteria andTeamCodeIsNotNull() {
            addCriterion("team_code is not null");
            return (Criteria) this;
        }

        public Criteria andTeamCodeEqualTo(Short value) {
            addCriterion("team_code =", value, "teamCode");
            return (Criteria) this;
        }

        public Criteria andTeamCodeNotEqualTo(Short value) {
            addCriterion("team_code <>", value, "teamCode");
            return (Criteria) this;
        }

        public Criteria andTeamCodeGreaterThan(Short value) {
            addCriterion("team_code >", value, "teamCode");
            return (Criteria) this;
        }

        public Criteria andTeamCodeGreaterThanOrEqualTo(Short value) {
            addCriterion("team_code >=", value, "teamCode");
            return (Criteria) this;
        }

        public Criteria andTeamCodeLessThan(Short value) {
            addCriterion("team_code <", value, "teamCode");
            return (Criteria) this;
        }

        public Criteria andTeamCodeLessThanOrEqualTo(Short value) {
            addCriterion("team_code <=", value, "teamCode");
            return (Criteria) this;
        }

        public Criteria andTeamCodeIn(List<Short> values) {
            addCriterion("team_code in", values, "teamCode");
            return (Criteria) this;
        }

        public Criteria andTeamCodeNotIn(List<Short> values) {
            addCriterion("team_code not in", values, "teamCode");
            return (Criteria) this;
        }

        public Criteria andTeamCodeBetween(Short value1, Short value2) {
            addCriterion("team_code between", value1, value2, "teamCode");
            return (Criteria) this;
        }

        public Criteria andTeamCodeNotBetween(Short value1, Short value2) {
            addCriterion("team_code not between", value1, value2, "teamCode");
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