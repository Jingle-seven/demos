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

import generator.pojo.AlarmMessage;
import generator.pojo.AlarmMessageExample.Criteria;
import generator.pojo.AlarmMessageExample.Criterion;
import generator.pojo.AlarmMessageExample;
import java.util.List;
import java.util.Map;

public class AlarmMessageSqlProvider {

    public String countByExample(AlarmMessageExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("alarm_message");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(AlarmMessageExample example) {
        BEGIN();
        DELETE_FROM("alarm_message");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(AlarmMessage record) {
        BEGIN();
        INSERT_INTO("alarm_message");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getTraceId() != null) {
            VALUES("trace_id", "#{traceId,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            VALUES("region", "#{region,jdbcType=BIGINT}");
        }
        
        if (record.getTime() != null) {
            VALUES("time", "#{time,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=SMALLINT}");
        }
        
        if (record.getMessage() != null) {
            VALUES("message", "#{message,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(AlarmMessageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("trace_id");
        SELECT("region");
        SELECT("time");
        SELECT("status");
        SELECT("message");
        FROM("alarm_message");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(AlarmMessageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("trace_id");
        SELECT("region");
        SELECT("time");
        SELECT("status");
        FROM("alarm_message");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AlarmMessage record = (AlarmMessage) parameter.get("record");
        AlarmMessageExample example = (AlarmMessageExample) parameter.get("example");
        
        BEGIN();
        UPDATE("alarm_message");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTraceId() != null) {
            SET("trace_id = #{record.traceId,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            SET("region = #{record.region,jdbcType=BIGINT}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{record.time,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=SMALLINT}");
        }
        
        if (record.getMessage() != null) {
            SET("message = #{record.message,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("alarm_message");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("trace_id = #{record.traceId,jdbcType=VARCHAR}");
        SET("region = #{record.region,jdbcType=BIGINT}");
        SET("time = #{record.time,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=SMALLINT}");
        SET("message = #{record.message,jdbcType=LONGVARCHAR}");
        
        AlarmMessageExample example = (AlarmMessageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("alarm_message");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("trace_id = #{record.traceId,jdbcType=VARCHAR}");
        SET("region = #{record.region,jdbcType=BIGINT}");
        SET("time = #{record.time,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=SMALLINT}");
        
        AlarmMessageExample example = (AlarmMessageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(AlarmMessage record) {
        BEGIN();
        UPDATE("alarm_message");
        
        if (record.getTraceId() != null) {
            SET("trace_id = #{traceId,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            SET("region = #{region,jdbcType=BIGINT}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{time,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=SMALLINT}");
        }
        
        if (record.getMessage() != null) {
            SET("message = #{message,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(AlarmMessageExample example, boolean includeExamplePhrase) {
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