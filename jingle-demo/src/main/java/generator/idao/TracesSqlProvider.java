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

import generator.pojo.Traces;
import generator.pojo.TracesExample.Criteria;
import generator.pojo.TracesExample.Criterion;
import generator.pojo.TracesExample;
import java.util.List;
import java.util.Map;

public class TracesSqlProvider {

    public String countByExample(TracesExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("traces");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TracesExample example) {
        BEGIN();
        DELETE_FROM("traces");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Traces record) {
        BEGIN();
        INSERT_INTO("traces");
        
        if (record.getTraceId() != null) {
            VALUES("trace_id", "#{traceId,jdbcType=BIGINT}");
        }
        
        if (record.getTraceMd5() != null) {
            VALUES("trace_md5", "#{traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTs() != null) {
            VALUES("start_ts", "#{startTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            VALUES("duration", "#{duration,jdbcType=BIGINT}");
        }
        
        if (record.getEndTs() != null) {
            VALUES("end_ts", "#{endTs,jdbcType=BIGINT}");
        }
        
        if (record.getTeamCode() != null) {
            VALUES("team_code", "#{teamCode,jdbcType=SMALLINT}");
        }
        
        return SQL();
    }

    public String selectByExample(TracesExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("trace_id");
        } else {
            SELECT("trace_id");
        }
        SELECT("trace_md5");
        SELECT("start_ts");
        SELECT("duration");
        SELECT("end_ts");
        SELECT("team_code");
        FROM("traces");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Traces record = (Traces) parameter.get("record");
        TracesExample example = (TracesExample) parameter.get("example");
        
        BEGIN();
        UPDATE("traces");
        
        if (record.getTraceId() != null) {
            SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        }
        
        if (record.getTraceMd5() != null) {
            SET("trace_md5 = #{record.traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTs() != null) {
            SET("start_ts = #{record.startTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            SET("duration = #{record.duration,jdbcType=BIGINT}");
        }
        
        if (record.getEndTs() != null) {
            SET("end_ts = #{record.endTs,jdbcType=BIGINT}");
        }
        
        if (record.getTeamCode() != null) {
            SET("team_code = #{record.teamCode,jdbcType=SMALLINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("traces");
        
        SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        SET("trace_md5 = #{record.traceMd5,jdbcType=VARCHAR}");
        SET("start_ts = #{record.startTs,jdbcType=BIGINT}");
        SET("duration = #{record.duration,jdbcType=BIGINT}");
        SET("end_ts = #{record.endTs,jdbcType=BIGINT}");
        SET("team_code = #{record.teamCode,jdbcType=SMALLINT}");
        
        TracesExample example = (TracesExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Traces record) {
        BEGIN();
        UPDATE("traces");
        
        if (record.getTraceMd5() != null) {
            SET("trace_md5 = #{traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTs() != null) {
            SET("start_ts = #{startTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            SET("duration = #{duration,jdbcType=BIGINT}");
        }
        
        if (record.getEndTs() != null) {
            SET("end_ts = #{endTs,jdbcType=BIGINT}");
        }
        
        if (record.getTeamCode() != null) {
            SET("team_code = #{teamCode,jdbcType=SMALLINT}");
        }
        
        WHERE("trace_id = #{traceId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(TracesExample example, boolean includeExamplePhrase) {
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