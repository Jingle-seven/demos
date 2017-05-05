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

import generator.pojo.ZipkinAnnotations;
import generator.pojo.ZipkinAnnotationsExample.Criteria;
import generator.pojo.ZipkinAnnotationsExample.Criterion;
import generator.pojo.ZipkinAnnotationsExample;
import java.util.List;
import java.util.Map;

public class ZipkinAnnotationsSqlProvider {

    public String countByExample(ZipkinAnnotationsExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("zipkin_annotations");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ZipkinAnnotationsExample example) {
        BEGIN();
        DELETE_FROM("zipkin_annotations");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ZipkinAnnotations record) {
        BEGIN();
        INSERT_INTO("zipkin_annotations");
        
        if (record.getTraceId() != null) {
            VALUES("trace_id", "#{traceId,jdbcType=BIGINT}");
        }
        
        if (record.getSpanId() != null) {
            VALUES("span_id", "#{spanId,jdbcType=BIGINT}");
        }
        
        if (record.getaKey() != null) {
            VALUES("a_key", "#{aKey,jdbcType=VARCHAR}");
        }
        
        if (record.getaType() != null) {
            VALUES("a_type", "#{aType,jdbcType=INTEGER}");
        }
        
        if (record.getaTimestamp() != null) {
            VALUES("a_timestamp", "#{aTimestamp,jdbcType=BIGINT}");
        }
        
        if (record.getEndpointIpv4() != null) {
            VALUES("endpoint_ipv4", "#{endpointIpv4,jdbcType=INTEGER}");
        }
        
        if (record.getEndpointPort() != null) {
            VALUES("endpoint_port", "#{endpointPort,jdbcType=SMALLINT}");
        }
        
        if (record.getEndpointServiceName() != null) {
            VALUES("endpoint_service_name", "#{endpointServiceName,jdbcType=VARCHAR}");
        }
        
        if (record.getaValue() != null) {
            VALUES("a_value", "#{aValue,jdbcType=LONGVARBINARY}");
        }
        
        if (record.getEndpointIpv6() != null) {
            VALUES("endpoint_ipv6", "#{endpointIpv6,jdbcType=BINARY}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(ZipkinAnnotationsExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("trace_id");
        } else {
            SELECT("trace_id");
        }
        SELECT("span_id");
        SELECT("a_key");
        SELECT("a_type");
        SELECT("a_timestamp");
        SELECT("endpoint_ipv4");
        SELECT("endpoint_port");
        SELECT("endpoint_service_name");
        SELECT("a_value");
        SELECT("endpoint_ipv6");
        FROM("zipkin_annotations");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(ZipkinAnnotationsExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("trace_id");
        } else {
            SELECT("trace_id");
        }
        SELECT("span_id");
        SELECT("a_key");
        SELECT("a_type");
        SELECT("a_timestamp");
        SELECT("endpoint_ipv4");
        SELECT("endpoint_port");
        SELECT("endpoint_service_name");
        FROM("zipkin_annotations");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ZipkinAnnotations record = (ZipkinAnnotations) parameter.get("record");
        ZipkinAnnotationsExample example = (ZipkinAnnotationsExample) parameter.get("example");
        
        BEGIN();
        UPDATE("zipkin_annotations");
        
        if (record.getTraceId() != null) {
            SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        }
        
        if (record.getSpanId() != null) {
            SET("span_id = #{record.spanId,jdbcType=BIGINT}");
        }
        
        if (record.getaKey() != null) {
            SET("a_key = #{record.aKey,jdbcType=VARCHAR}");
        }
        
        if (record.getaType() != null) {
            SET("a_type = #{record.aType,jdbcType=INTEGER}");
        }
        
        if (record.getaTimestamp() != null) {
            SET("a_timestamp = #{record.aTimestamp,jdbcType=BIGINT}");
        }
        
        if (record.getEndpointIpv4() != null) {
            SET("endpoint_ipv4 = #{record.endpointIpv4,jdbcType=INTEGER}");
        }
        
        if (record.getEndpointPort() != null) {
            SET("endpoint_port = #{record.endpointPort,jdbcType=SMALLINT}");
        }
        
        if (record.getEndpointServiceName() != null) {
            SET("endpoint_service_name = #{record.endpointServiceName,jdbcType=VARCHAR}");
        }
        
        if (record.getaValue() != null) {
            SET("a_value = #{record.aValue,jdbcType=LONGVARBINARY}");
        }
        
        if (record.getEndpointIpv6() != null) {
            SET("endpoint_ipv6 = #{record.endpointIpv6,jdbcType=BINARY}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("zipkin_annotations");
        
        SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        SET("span_id = #{record.spanId,jdbcType=BIGINT}");
        SET("a_key = #{record.aKey,jdbcType=VARCHAR}");
        SET("a_type = #{record.aType,jdbcType=INTEGER}");
        SET("a_timestamp = #{record.aTimestamp,jdbcType=BIGINT}");
        SET("endpoint_ipv4 = #{record.endpointIpv4,jdbcType=INTEGER}");
        SET("endpoint_port = #{record.endpointPort,jdbcType=SMALLINT}");
        SET("endpoint_service_name = #{record.endpointServiceName,jdbcType=VARCHAR}");
        SET("a_value = #{record.aValue,jdbcType=LONGVARBINARY}");
        SET("endpoint_ipv6 = #{record.endpointIpv6,jdbcType=BINARY}");
        
        ZipkinAnnotationsExample example = (ZipkinAnnotationsExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("zipkin_annotations");
        
        SET("trace_id = #{record.traceId,jdbcType=BIGINT}");
        SET("span_id = #{record.spanId,jdbcType=BIGINT}");
        SET("a_key = #{record.aKey,jdbcType=VARCHAR}");
        SET("a_type = #{record.aType,jdbcType=INTEGER}");
        SET("a_timestamp = #{record.aTimestamp,jdbcType=BIGINT}");
        SET("endpoint_ipv4 = #{record.endpointIpv4,jdbcType=INTEGER}");
        SET("endpoint_port = #{record.endpointPort,jdbcType=SMALLINT}");
        SET("endpoint_service_name = #{record.endpointServiceName,jdbcType=VARCHAR}");
        
        ZipkinAnnotationsExample example = (ZipkinAnnotationsExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    protected void applyWhere(ZipkinAnnotationsExample example, boolean includeExamplePhrase) {
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