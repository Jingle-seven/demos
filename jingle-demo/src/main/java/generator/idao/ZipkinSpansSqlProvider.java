package generator.idao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import generator.pojo.ZipkinSpans;
import generator.pojo.ZipkinSpansExample.Criteria;
import generator.pojo.ZipkinSpansExample.Criterion;
import generator.pojo.ZipkinSpansExample;
import java.util.List;
import java.util.Map;

public class ZipkinSpansSqlProvider {

    public String countByExample(ZipkinSpansExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("zipkin_spans");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ZipkinSpansExample example) {
        BEGIN();
        DELETE_FROM("zipkin_spans");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ZipkinSpans record) {
        BEGIN();
        INSERT_INTO("zipkin_spans");
        
        if (record.getTraceId() != null) {
            VALUES("trace_id", "#{traceId,jdbcType=BIGINT}");
        }
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getDebug() != null) {
            VALUES("debug", "#{debug,jdbcType=BIT}");
        }
        
        if (record.getStartTs() != null) {
            VALUES("start_ts", "#{startTs,jdbcType=BIGINT}");
        }
        
        if (record.getRecordTs() != null) {
            VALUES("record_ts", "#{recordTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            VALUES("duration", "#{duration,jdbcType=BIGINT}");
        }
        
        return SQL();
    }

    public String selectByExample(ZipkinSpansExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("trace_id");
        } else {
            SELECT("trace_id");
        }
        SELECT("id");
        SELECT("name");
        SELECT("parent_id");
        SELECT("debug");
        SELECT("start_ts");
        SELECT("record_ts");
        SELECT("duration");
        FROM("zipkin_spans");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ZipkinSpans record = (ZipkinSpans) parameter.get("record");
        ZipkinSpansExample example = (ZipkinSpansExample) parameter.get("example");
        
        BEGIN();
        UPDATE("zipkin_spans");
        
        if (record.getTraceId() != null) {
            SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        }
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getDebug() != null) {
            SET("debug = #{record.debug,jdbcType=BIT}");
        }
        
        if (record.getStartTs() != null) {
            SET("start_ts = #{record.startTs,jdbcType=BIGINT}");
        }
        
        if (record.getRecordTs() != null) {
            SET("record_ts = #{record.recordTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            SET("duration = #{record.duration,jdbcType=BIGINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("zipkin_spans");
        
        SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        SET("debug = #{record.debug,jdbcType=BIT}");
        SET("start_ts = #{record.startTs,jdbcType=BIGINT}");
        SET("record_ts = #{record.recordTs,jdbcType=BIGINT}");
        SET("duration = #{record.duration,jdbcType=BIGINT}");
        
        ZipkinSpansExample example = (ZipkinSpansExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    protected void applyWhere(ZipkinSpansExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}