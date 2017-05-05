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

import generator.pojo.TraceInfos;
import generator.pojo.TraceInfosExample.Criteria;
import generator.pojo.TraceInfosExample.Criterion;
import generator.pojo.TraceInfosExample;
import java.util.List;
import java.util.Map;

public class TraceInfosSqlProvider {

    public String countByExample(TraceInfosExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("trace_infos");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TraceInfosExample example) {
        BEGIN();
        DELETE_FROM("trace_infos");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TraceInfos record) {
        BEGIN();
        INSERT_INTO("trace_infos");
        
        if (record.getTraceMd5() != null) {
            VALUES("trace_md5", "#{traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getRootName() != null) {
            VALUES("root_name", "#{rootName,jdbcType=VARCHAR}");
        }
        
        if (record.getTraceName() != null) {
            VALUES("trace_name", "#{traceName,jdbcType=VARCHAR}");
        }
        
        if (record.getSpanCount() != null) {
            VALUES("span_count", "#{spanCount,jdbcType=SMALLINT}");
        }
        
        if (record.getTraceAlias() != null) {
            VALUES("trace_alias", "#{traceAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getBaseTraceId() != null) {
            VALUES("base_trace_id", "#{baseTraceId,jdbcType=BIGINT}");
        }
        
        if (record.getWarningDuration() != null) {
            VALUES("warning_duration", "#{warningDuration,jdbcType=BIGINT}");
        }
        
        if (record.getWarningPercentage() != null) {
            VALUES("warning_percentage", "#{warningPercentage,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(TraceInfosExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("trace_md5");
        } else {
            SELECT("trace_md5");
        }
        SELECT("root_name");
        SELECT("trace_name");
        SELECT("span_count");
        SELECT("trace_alias");
        SELECT("base_trace_id");
        SELECT("warning_duration");
        SELECT("warning_percentage");
        FROM("trace_infos");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TraceInfos record = (TraceInfos) parameter.get("record");
        TraceInfosExample example = (TraceInfosExample) parameter.get("example");
        
        BEGIN();
        UPDATE("trace_infos");
        
        if (record.getTraceMd5() != null) {
            SET("trace_md5 = #{record.traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getRootName() != null) {
            SET("root_name = #{record.rootName,jdbcType=VARCHAR}");
        }
        
        if (record.getTraceName() != null) {
            SET("trace_name = #{record.traceName,jdbcType=VARCHAR}");
        }
        
        if (record.getSpanCount() != null) {
            SET("span_count = #{record.spanCount,jdbcType=SMALLINT}");
        }
        
        if (record.getTraceAlias() != null) {
            SET("trace_alias = #{record.traceAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getBaseTraceId() != null) {
            SET("base_trace_id = #{record.baseTraceId,jdbcType=BIGINT}");
        }
        
        if (record.getWarningDuration() != null) {
            SET("warning_duration = #{record.warningDuration,jdbcType=BIGINT}");
        }
        
        if (record.getWarningPercentage() != null) {
            SET("warning_percentage = #{record.warningPercentage,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("trace_infos");
        
        SET("trace_md5 = #{record.traceMd5,jdbcType=VARCHAR}");
        SET("root_name = #{record.rootName,jdbcType=VARCHAR}");
        SET("trace_name = #{record.traceName,jdbcType=VARCHAR}");
        SET("span_count = #{record.spanCount,jdbcType=SMALLINT}");
        SET("trace_alias = #{record.traceAlias,jdbcType=VARCHAR}");
        SET("base_trace_id = #{record.baseTraceId,jdbcType=BIGINT}");
        SET("warning_duration = #{record.warningDuration,jdbcType=BIGINT}");
        SET("warning_percentage = #{record.warningPercentage,jdbcType=INTEGER}");
        
        TraceInfosExample example = (TraceInfosExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TraceInfos record) {
        BEGIN();
        UPDATE("trace_infos");
        
        if (record.getRootName() != null) {
            SET("root_name = #{rootName,jdbcType=VARCHAR}");
        }
        
        if (record.getTraceName() != null) {
            SET("trace_name = #{traceName,jdbcType=VARCHAR}");
        }
        
        if (record.getSpanCount() != null) {
            SET("span_count = #{spanCount,jdbcType=SMALLINT}");
        }
        
        if (record.getTraceAlias() != null) {
            SET("trace_alias = #{traceAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getBaseTraceId() != null) {
            SET("base_trace_id = #{baseTraceId,jdbcType=BIGINT}");
        }
        
        if (record.getWarningDuration() != null) {
            SET("warning_duration = #{warningDuration,jdbcType=BIGINT}");
        }
        
        if (record.getWarningPercentage() != null) {
            SET("warning_percentage = #{warningPercentage,jdbcType=INTEGER}");
        }
        
        WHERE("trace_md5 = #{traceMd5,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(TraceInfosExample example, boolean includeExamplePhrase) {
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