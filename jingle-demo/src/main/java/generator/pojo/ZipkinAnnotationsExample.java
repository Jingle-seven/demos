package generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class ZipkinAnnotationsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZipkinAnnotationsExample() {
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

        public Criteria andAKeyIsNull() {
            addCriterion("a_key is null");
            return (Criteria) this;
        }

        public Criteria andAKeyIsNotNull() {
            addCriterion("a_key is not null");
            return (Criteria) this;
        }

        public Criteria andAKeyEqualTo(String value) {
            addCriterion("a_key =", value, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyNotEqualTo(String value) {
            addCriterion("a_key <>", value, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyGreaterThan(String value) {
            addCriterion("a_key >", value, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyGreaterThanOrEqualTo(String value) {
            addCriterion("a_key >=", value, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyLessThan(String value) {
            addCriterion("a_key <", value, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyLessThanOrEqualTo(String value) {
            addCriterion("a_key <=", value, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyLike(String value) {
            addCriterion("a_key like", value, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyNotLike(String value) {
            addCriterion("a_key not like", value, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyIn(List<String> values) {
            addCriterion("a_key in", values, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyNotIn(List<String> values) {
            addCriterion("a_key not in", values, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyBetween(String value1, String value2) {
            addCriterion("a_key between", value1, value2, "aKey");
            return (Criteria) this;
        }

        public Criteria andAKeyNotBetween(String value1, String value2) {
            addCriterion("a_key not between", value1, value2, "aKey");
            return (Criteria) this;
        }

        public Criteria andATypeIsNull() {
            addCriterion("a_type is null");
            return (Criteria) this;
        }

        public Criteria andATypeIsNotNull() {
            addCriterion("a_type is not null");
            return (Criteria) this;
        }

        public Criteria andATypeEqualTo(Integer value) {
            addCriterion("a_type =", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotEqualTo(Integer value) {
            addCriterion("a_type <>", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeGreaterThan(Integer value) {
            addCriterion("a_type >", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_type >=", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeLessThan(Integer value) {
            addCriterion("a_type <", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeLessThanOrEqualTo(Integer value) {
            addCriterion("a_type <=", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeIn(List<Integer> values) {
            addCriterion("a_type in", values, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotIn(List<Integer> values) {
            addCriterion("a_type not in", values, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeBetween(Integer value1, Integer value2) {
            addCriterion("a_type between", value1, value2, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotBetween(Integer value1, Integer value2) {
            addCriterion("a_type not between", value1, value2, "aType");
            return (Criteria) this;
        }

        public Criteria andATimestampIsNull() {
            addCriterion("a_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andATimestampIsNotNull() {
            addCriterion("a_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andATimestampEqualTo(Long value) {
            addCriterion("a_timestamp =", value, "aTimestamp");
            return (Criteria) this;
        }

        public Criteria andATimestampNotEqualTo(Long value) {
            addCriterion("a_timestamp <>", value, "aTimestamp");
            return (Criteria) this;
        }

        public Criteria andATimestampGreaterThan(Long value) {
            addCriterion("a_timestamp >", value, "aTimestamp");
            return (Criteria) this;
        }

        public Criteria andATimestampGreaterThanOrEqualTo(Long value) {
            addCriterion("a_timestamp >=", value, "aTimestamp");
            return (Criteria) this;
        }

        public Criteria andATimestampLessThan(Long value) {
            addCriterion("a_timestamp <", value, "aTimestamp");
            return (Criteria) this;
        }

        public Criteria andATimestampLessThanOrEqualTo(Long value) {
            addCriterion("a_timestamp <=", value, "aTimestamp");
            return (Criteria) this;
        }

        public Criteria andATimestampIn(List<Long> values) {
            addCriterion("a_timestamp in", values, "aTimestamp");
            return (Criteria) this;
        }

        public Criteria andATimestampNotIn(List<Long> values) {
            addCriterion("a_timestamp not in", values, "aTimestamp");
            return (Criteria) this;
        }

        public Criteria andATimestampBetween(Long value1, Long value2) {
            addCriterion("a_timestamp between", value1, value2, "aTimestamp");
            return (Criteria) this;
        }

        public Criteria andATimestampNotBetween(Long value1, Long value2) {
            addCriterion("a_timestamp not between", value1, value2, "aTimestamp");
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

        public Criteria andEndpointPortIsNull() {
            addCriterion("endpoint_port is null");
            return (Criteria) this;
        }

        public Criteria andEndpointPortIsNotNull() {
            addCriterion("endpoint_port is not null");
            return (Criteria) this;
        }

        public Criteria andEndpointPortEqualTo(Short value) {
            addCriterion("endpoint_port =", value, "endpointPort");
            return (Criteria) this;
        }

        public Criteria andEndpointPortNotEqualTo(Short value) {
            addCriterion("endpoint_port <>", value, "endpointPort");
            return (Criteria) this;
        }

        public Criteria andEndpointPortGreaterThan(Short value) {
            addCriterion("endpoint_port >", value, "endpointPort");
            return (Criteria) this;
        }

        public Criteria andEndpointPortGreaterThanOrEqualTo(Short value) {
            addCriterion("endpoint_port >=", value, "endpointPort");
            return (Criteria) this;
        }

        public Criteria andEndpointPortLessThan(Short value) {
            addCriterion("endpoint_port <", value, "endpointPort");
            return (Criteria) this;
        }

        public Criteria andEndpointPortLessThanOrEqualTo(Short value) {
            addCriterion("endpoint_port <=", value, "endpointPort");
            return (Criteria) this;
        }

        public Criteria andEndpointPortIn(List<Short> values) {
            addCriterion("endpoint_port in", values, "endpointPort");
            return (Criteria) this;
        }

        public Criteria andEndpointPortNotIn(List<Short> values) {
            addCriterion("endpoint_port not in", values, "endpointPort");
            return (Criteria) this;
        }

        public Criteria andEndpointPortBetween(Short value1, Short value2) {
            addCriterion("endpoint_port between", value1, value2, "endpointPort");
            return (Criteria) this;
        }

        public Criteria andEndpointPortNotBetween(Short value1, Short value2) {
            addCriterion("endpoint_port not between", value1, value2, "endpointPort");
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