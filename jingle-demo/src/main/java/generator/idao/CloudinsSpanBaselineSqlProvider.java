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

import generator.pojo.CloudinsSpanBaseline;
import generator.pojo.CloudinsSpanBaselineExample.Criteria;
import generator.pojo.CloudinsSpanBaselineExample.Criterion;
import generator.pojo.CloudinsSpanBaselineExample;
import java.util.List;
import java.util.Map;

public class CloudinsSpanBaselineSqlProvider {

    public String countByExample(CloudinsSpanBaselineExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("cloudins_span_baseline");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CloudinsSpanBaselineExample example) {
        BEGIN();
        DELETE_FROM("cloudins_span_baseline");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CloudinsSpanBaseline record) {
        BEGIN();
        INSERT_INTO("cloudins_span_baseline");
        
        if (record.getTraceId() != null) {
            VALUES("trace_id", "#{traceId,jdbcType=BIGINT}");
        }
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getTraceMd5() != null) {
            VALUES("trace_md5", "#{traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getStartTs() != null) {
            VALUES("start_ts", "#{startTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            VALUES("duration", "#{duration,jdbcType=BIGINT}");
        }
        
        return SQL();
    }

    public String selectByExample(CloudinsSpanBaselineExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("trace_id");
        } else {
            SELECT("trace_id");
        }
        SELECT("id");
        SELECT("trace_md5");
        SELECT("name");
        SELECT("parent_id");
        SELECT("start_ts");
        SELECT("duration");
        FROM("cloudins_span_baseline");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CloudinsSpanBaseline record = (CloudinsSpanBaseline) parameter.get("record");
        CloudinsSpanBaselineExample example = (CloudinsSpanBaselineExample) parameter.get("example");
        
        BEGIN();
        UPDATE("cloudins_span_baseline");
        
        if (record.getTraceId() != null) {
            SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        }
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTraceMd5() != null) {
            SET("trace_md5 = #{record.traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getStartTs() != null) {
            SET("start_ts = #{record.startTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            SET("duration = #{record.duration,jdbcType=BIGINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("cloudins_span_baseline");
        
        SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("trace_md5 = #{record.traceMd5,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        SET("start_ts = #{record.startTs,jdbcType=BIGINT}");
        SET("duration = #{record.duration,jdbcType=BIGINT}");
        
        CloudinsSpanBaselineExample example = (CloudinsSpanBaselineExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CloudinsSpanBaseline record) {
        BEGIN();
        UPDATE("cloudins_span_baseline");
        
        if (record.getTraceMd5() != null) {
            SET("trace_md5 = #{traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getStartTs() != null) {
            SET("start_ts = #{startTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            SET("duration = #{duration,jdbcType=BIGINT}");
        }
        
        WHERE("trace_id = #{traceId,jdbcType=BIGINT}");
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CloudinsSpanBaselineExample example, boolean includeExamplePhrase) {
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