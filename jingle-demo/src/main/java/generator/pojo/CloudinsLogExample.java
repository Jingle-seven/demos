package generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class CloudinsLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CloudinsLogExample() {
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

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andLineIsNull() {
            addCriterion("line is null");
            return (Criteria) this;
        }

        public Criteria andLineIsNotNull() {
            addCriterion("line is not null");
            return (Criteria) this;
        }

        public Criteria andLineEqualTo(Integer value) {
            addCriterion("line =", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotEqualTo(Integer value) {
            addCriterion("line <>", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThan(Integer value) {
            addCriterion("line >", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThanOrEqualTo(Integer value) {
            addCriterion("line >=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThan(Integer value) {
            addCriterion("line <", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThanOrEqualTo(Integer value) {
            addCriterion("line <=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineIn(List<Integer> values) {
            addCriterion("line in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotIn(List<Integer> values) {
            addCriterion("line not in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineBetween(Integer value1, Integer value2) {
            addCriterion("line between", value1, value2, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotBetween(Integer value1, Integer value2) {
            addCriterion("line not between", value1, value2, "line");
            return (Criteria) this;
        }

        public Criteria andDisplayedIsNull() {
            addCriterion("displayed is null");
            return (Criteria) this;
        }

        public Criteria andDisplayedIsNotNull() {
            addCriterion("displayed is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayedEqualTo(Boolean value) {
            addCriterion("displayed =", value, "displayed");
            return (Criteria) this;
        }

        public Criteria andDisplayedNotEqualTo(Boolean value) {
            addCriterion("displayed <>", value, "displayed");
            return (Criteria) this;
        }

        public Criteria andDisplayedGreaterThan(Boolean value) {
            addCriterion("displayed >", value, "displayed");
            return (Criteria) this;
        }

        public Criteria andDisplayedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("displayed >=", value, "displayed");
            return (Criteria) this;
        }

        public Criteria andDisplayedLessThan(Boolean value) {
            addCriterion("displayed <", value, "displayed");
            return (Criteria) this;
        }

        public Criteria andDisplayedLessThanOrEqualTo(Boolean value) {
            addCriterion("displayed <=", value, "displayed");
            return (Criteria) this;
        }

        public Criteria andDisplayedIn(List<Boolean> values) {
            addCriterion("displayed in", values, "displayed");
            return (Criteria) this;
        }

        public Criteria andDisplayedNotIn(List<Boolean> values) {
            addCriterion("displayed not in", values, "displayed");
            return (Criteria) this;
        }

        public Criteria andDisplayedBetween(Boolean value1, Boolean value2) {
            addCriterion("displayed between", value1, value2, "displayed");
            return (Criteria) this;
        }

        public Criteria andDisplayedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("displayed not between", value1, value2, "displayed");
            return (Criteria) this;
        }

        public Criteria andIsreadIsNull() {
            addCriterion("isread is null");
            return (Criteria) this;
        }

        public Criteria andIsreadIsNotNull() {
            addCriterion("isread is not null");
            return (Criteria) this;
        }

        public Criteria andIsreadEqualTo(Boolean value) {
            addCriterion("isread =", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotEqualTo(Boolean value) {
            addCriterion("isread <>", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadGreaterThan(Boolean value) {
            addCriterion("isread >", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isread >=", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadLessThan(Boolean value) {
            addCriterion("isread <", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadLessThanOrEqualTo(Boolean value) {
            addCriterion("isread <=", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadIn(List<Boolean> values) {
            addCriterion("isread in", values, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotIn(List<Boolean> values) {
            addCriterion("isread not in", values, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadBetween(Boolean value1, Boolean value2) {
            addCriterion("isread between", value1, value2, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isread not between", value1, value2, "isread");
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