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

import generator.pojo.SpanCopy;
import generator.pojo.SpanCopyExample.Criteria;
import generator.pojo.SpanCopyExample.Criterion;
import generator.pojo.SpanCopyExample;
import java.util.List;
import java.util.Map;

public class SpanCopySqlProvider {

    public String countByExample(SpanCopyExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("span_copy");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(SpanCopyExample example) {
        BEGIN();
        DELETE_FROM("span_copy");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(SpanCopy record) {
        BEGIN();
        INSERT_INTO("span_copy");
        
        if (record.getTraceId() != null) {
            VALUES("trace_id", "#{traceId,jdbcType=BIGINT}");
        }
        
        if (record.getSpanId() != null) {
            VALUES("span_id", "#{spanId,jdbcType=BIGINT}");
        }
        
        if (record.getEndpointIpv4() != null) {
            VALUES("endpoint_ipv4", "#{endpointIpv4,jdbcType=INTEGER}");
        }
        
        if (record.getEndpointServiceName() != null) {
            VALUES("endpoint_service_name", "#{endpointServiceName,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTs() != null) {
            VALUES("start_ts", "#{startTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            VALUES("duration", "#{duration,jdbcType=BIGINT}");
        }
        
        if (record.getRecordTs() != null) {
            VALUES("record_ts", "#{recordTs,jdbcType=BIGINT}");
        }
        
        if (record.getTraceMd5() != null) {
            VALUES("trace_md5", "#{traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getParentIp() != null) {
            VALUES("parent_ip", "#{parentIp,jdbcType=INTEGER}");
        }
        
        if (record.getParentEndpointName() != null) {
            VALUES("parent_endpoint_name", "#{parentEndpointName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(SpanCopyExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("trace_id");
        } else {
            SELECT("trace_id");
        }
        SELECT("span_id");
        SELECT("endpoint_ipv4");
        SELECT("endpoint_service_name");
        SELECT("start_ts");
        SELECT("duration");
        SELECT("record_ts");
        SELECT("trace_md5");
        SELECT("parent_id");
        SELECT("parent_ip");
        SELECT("parent_endpoint_name");
        FROM("span_copy");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SpanCopy record = (SpanCopy) parameter.get("record");
        SpanCopyExample example = (SpanCopyExample) parameter.get("example");
        
        BEGIN();
        UPDATE("span_copy");
        
        if (record.getTraceId() != null) {
            SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        }
        
        if (record.getSpanId() != null) {
            SET("span_id = #{record.spanId,jdbcType=BIGINT}");
        }
        
        if (record.getEndpointIpv4() != null) {
            SET("endpoint_ipv4 = #{record.endpointIpv4,jdbcType=INTEGER}");
        }
        
        if (record.getEndpointServiceName() != null) {
            SET("endpoint_service_name = #{record.endpointServiceName,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTs() != null) {
            SET("start_ts = #{record.startTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            SET("duration = #{record.duration,jdbcType=BIGINT}");
        }
        
        if (record.getRecordTs() != null) {
            SET("record_ts = #{record.recordTs,jdbcType=BIGINT}");
        }
        
        if (record.getTraceMd5() != null) {
            SET("trace_md5 = #{record.traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getParentIp() != null) {
            SET("parent_ip = #{record.parentIp,jdbcType=INTEGER}");
        }
        
        if (record.getParentEndpointName() != null) {
            SET("parent_endpoint_name = #{record.parentEndpointName,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("span_copy");
        
        SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        SET("span_id = #{record.spanId,jdbcType=BIGINT}");
        SET("endpoint_ipv4 = #{record.endpointIpv4,jdbcType=INTEGER}");
        SET("endpoint_service_name = #{record.endpointServiceName,jdbcType=VARCHAR}");
        SET("start_ts = #{record.startTs,jdbcType=BIGINT}");
        SET("duration = #{record.duration,jdbcType=BIGINT}");
        SET("record_ts = #{record.recordTs,jdbcType=BIGINT}");
        SET("trace_md5 = #{record.traceMd5,jdbcType=VARCHAR}");
        SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        SET("parent_ip = #{record.parentIp,jdbcType=INTEGER}");
        SET("parent_endpoint_name = #{record.parentEndpointName,jdbcType=VARCHAR}");
        
        SpanCopyExample example = (SpanCopyExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpanCopy record) {
        BEGIN();
        UPDATE("span_copy");
        
        if (record.getEndpointIpv4() != null) {
            SET("endpoint_ipv4 = #{endpointIpv4,jdbcType=INTEGER}");
        }
        
        if (record.getEndpointServiceName() != null) {
            SET("endpoint_service_name = #{endpointServiceName,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTs() != null) {
            SET("start_ts = #{startTs,jdbcType=BIGINT}");
        }
        
        if (record.getDuration() != null) {
            SET("duration = #{duration,jdbcType=BIGINT}");
        }
        
        if (record.getRecordTs() != null) {
            SET("record_ts = #{recordTs,jdbcType=BIGINT}");
        }
        
        if (record.getTraceMd5() != null) {
            SET("trace_md5 = #{traceMd5,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getParentIp() != null) {
            SET("parent_ip = #{parentIp,jdbcType=INTEGER}");
        }
        
        if (record.getParentEndpointName() != null) {
            SET("parent_endpoint_name = #{parentEndpointName,jdbcType=VARCHAR}");
        }
        
        WHERE("trace_id = #{traceId,jdbcType=BIGINT}");
        WHERE("span_id = #{spanId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(SpanCopyExample example, boolean includeExamplePhrase) {
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