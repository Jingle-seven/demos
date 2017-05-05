package generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class SpansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpansExample() {
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

        public Criteria andSpanIdIsNull() {
            addCriterion("span_id is null");
            return (Criteria) this;
        }

        public Criteria andSpanIdIsNotNull() {
            addCriterion("span_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpanIdEqualTo(Long value) {
            addCriterion("span_id =", value, "spanId");
            return (Criteria) this;
        }

        public Criteria andSpanIdNotEqualTo(Long value) {
            addCriterion("span_id <>", value, "spanId");
            return (Criteria) this;
        }

        public Criteria andSpanIdGreaterThan(Long value) {
            addCriterion("span_id >", value, "spanId");
            return (Criteria) this;
        }

        public Criteria andSpanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("span_id >=", value, "spanId");
            return (Criteria) this;
        }

        public Criteria andSpanIdLessThan(Long value) {
            addCriterion("span_id <", value, "spanId");
            return (Criteria) this;
        }

        public Criteria andSpanIdLessThanOrEqualTo(Long value) {
            addCriterion("span_id <=", value, "spanId");
            return (Criteria) this;
        }

        public Criteria andSpanIdIn(List<Long> values) {
            addCriterion("span_id in", values, "spanId");
            return (Criteria) this;
        }

        public Criteria andSpanIdNotIn(List<Long> values) {
            addCriterion("span_id not in", values, "spanId");
            return (Criteria) this;
        }

        public Criteria andSpanIdBetween(Long value1, Long value2) {
            addCriterion("span_id between", value1, value2, "spanId");
            return (Criteria) this;
        }

        public Criteria andSpanIdNotBetween(Long value1, Long value2) {
            addCriterion("span_id not between", value1, value2, "spanId");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4IsNull() {
            addCriterion("endpoint_ipv4 is null");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4IsNotNull() {
            addCriterion("endpoint_ipv4 is not null");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4EqualTo(Integer value) {
            addCriterion("endpoint_ipv4 =", value, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4NotEqualTo(Integer value) {
            addCriterion("endpoint_ipv4 <>", value, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4GreaterThan(Integer value) {
            addCriterion("endpoint_ipv4 >", value, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4GreaterThanOrEqualTo(Integer value) {
            addCriterion("endpoint_ipv4 >=", value, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4LessThan(Integer value) {
            addCriterion("endpoint_ipv4 <", value, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4LessThanOrEqualTo(Integer value) {
            addCriterion("endpoint_ipv4 <=", value, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4In(List<Integer> values) {
            addCriterion("endpoint_ipv4 in", values, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4NotIn(List<Integer> values) {
            addCriterion("endpoint_ipv4 not in", values, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4Between(Integer value1, Integer value2) {
            addCriterion("endpoint_ipv4 between", value1, value2, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointIpv4NotBetween(Integer value1, Integer value2) {
            addCriterion("endpoint_ipv4 not between", value1, value2, "endpointIpv4");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameIsNull() {
            addCriterion("endpoint_service_name is null");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameIsNotNull() {
            addCriterion("endpoint_service_name is not null");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameEqualTo(String value) {
            addCriterion("endpoint_service_name =", value, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameNotEqualTo(String value) {
            addCriterion("endpoint_service_name <>", value, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameGreaterThan(String value) {
            addCriterion("endpoint_service_name >", value, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("endpoint_service_name >=", value, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameLessThan(String value) {
            addCriterion("endpoint_service_name <", value, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameLessThanOrEqualTo(String value) {
            addCriterion("endpoint_service_name <=", value, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameLike(String value) {
            addCriterion("endpoint_service_name like", value, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameNotLike(String value) {
            addCriterion("endpoint_service_name not like", value, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameIn(List<String> values) {
            addCriterion("endpoint_service_name in", values, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameNotIn(List<String> values) {
            addCriterion("endpoint_service_name not in", values, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameBetween(String value1, String value2) {
            addCriterion("endpoint_service_name between", value1, value2, "endpointServiceName");
            return (Criteria) this;
        }

        public Criteria andEndpointServiceNameNotBetween(String value1, String value2) {
            addCriterion("endpoint_service_name not between", value1, value2, "endpointServiceName");
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

        public Criteria andRecordTsIsNull() {
            addCriterion("record_ts is null");
            return (Criteria) this;
        }

        public Criteria andRecordTsIsNotNull() {
            addCriterion("record_ts is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTsEqualTo(Long value) {
            addCriterion("record_ts =", value, "recordTs");
            return (Criteria) this;
        }

        public Criteria andRecordTsNotEqualTo(Long value) {
            addCriterion("record_ts <>", value, "recordTs");
            return (Criteria) this;
        }

        public Criteria andRecordTsGreaterThan(Long value) {
            addCriterion("record_ts >", value, "recordTs");
            return (Criteria) this;
        }

        public Criteria andRecordTsGreaterThanOrEqualTo(Long value) {
            addCriterion("record_ts >=", value, "recordTs");
            return (Criteria) this;
        }

        public Criteria andRecordTsLessThan(Long value) {
            addCriterion("record_ts <", value, "recordTs");
            return (Criteria) this;
        }

        public Criteria andRecordTsLessThanOrEqualTo(Long value) {
            addCriterion("record_ts <=", value, "recordTs");
            return (Criteria) this;
        }

        public Criteria andRecordTsIn(List<Long> values) {
            addCriterion("record_ts in", values, "recordTs");
            return (Criteria) this;
        }

        public Criteria andRecordTsNotIn(List<Long> values) {
            addCriterion("record_ts not in", values, "recordTs");
            return (Criteria) this;
        }

        public Criteria andRecordTsBetween(Long value1, Long value2) {
            addCriterion("record_ts between", value1, value2, "recordTs");
            return (Criteria) this;
        }

        public Criteria andRecordTsNotBetween(Long value1, Long value2) {
            addCriterion("record_ts not between", value1, value2, "recordTs");
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