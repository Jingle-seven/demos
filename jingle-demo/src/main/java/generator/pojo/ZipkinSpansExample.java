package generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class ZipkinSpansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZipkinSpansExample() {
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andDebugIsNull() {
            addCriterion("debug is null");
            return (Criteria) this;
        }

        public Criteria andDebugIsNotNull() {
            addCriterion("debug is not null");
            return (Criteria) this;
        }

        public Criteria andDebugEqualTo(Boolean value) {
            addCriterion("debug =", value, "debug");
            return (Criteria) this;
        }

        public Criteria andDebugNotEqualTo(Boolean value) {
            addCriterion("debug <>", value, "debug");
            return (Criteria) this;
        }

        public Criteria andDebugGreaterThan(Boolean value) {
            addCriterion("debug >", value, "debug");
            return (Criteria) this;
        }

        public Criteria andDebugGreaterThanOrEqualTo(Boolean value) {
            addCriterion("debug >=", value, "debug");
            return (Criteria) this;
        }

        public Criteria andDebugLessThan(Boolean value) {
            addCriterion("debug <", value, "debug");
            return (Criteria) this;
        }

        public Criteria andDebugLessThanOrEqualTo(Boolean value) {
            addCriterion("debug <=", value, "debug");
            return (Criteria) this;
        }

        public Criteria andDebugIn(List<Boolean> values) {
            addCriterion("debug in", values, "debug");
            return (Criteria) this;
        }

        public Criteria andDebugNotIn(List<Boolean> values) {
            addCriterion("debug not in", values, "debug");
            return (Criteria) this;
        }

        public Criteria andDebugBetween(Boolean value1, Boolean value2) {
            addCriterion("debug between", value1, value2, "debug");
            return (Criteria) this;
        }

        public Criteria andDebugNotBetween(Boolean value1, Boolean value2) {
            addCriterion("debug not between", value1, value2, "debug");
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