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

import generator.pojo.StatisticsSpans;
import generator.pojo.StatisticsSpansExample.Criteria;
import generator.pojo.StatisticsSpansExample.Criterion;
import generator.pojo.StatisticsSpansExample;
import java.util.List;
import java.util.Map;

public class StatisticsSpansSqlProvider {

    public String countByExample(StatisticsSpansExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("statistics_spans");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(StatisticsSpansExample example) {
        BEGIN();
        DELETE_FROM("statistics_spans");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(StatisticsSpans record) {
        BEGIN();
        INSERT_INTO("statistics_spans");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            VALUES("start_time", "#{startTime,jdbcType=VARCHAR}");
        }
        
        if (record.getEndTime() != null) {
            VALUES("end_time", "#{endTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSpanName() != null) {
            VALUES("span_name", "#{spanName,jdbcType=VARCHAR}");
        }
        
        if (record.getCalledNum() != null) {
            VALUES("called_num", "#{calledNum,jdbcType=VARCHAR}");
        }
        
        if (record.getAvgTime() != null) {
            VALUES("avg_time", "#{avgTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSlowestId() != null) {
            VALUES("slowest_id", "#{slowestId,jdbcType=VARCHAR}");
        }
        
        if (record.getSlowestTime() != null) {
            VALUES("slowest_time", "#{slowestTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSlowestHost() != null) {
            VALUES("slowest_host", "#{slowestHost,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(StatisticsSpansExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("start_time");
        SELECT("end_time");
        SELECT("span_name");
        SELECT("called_num");
        SELECT("avg_time");
        SELECT("slowest_id");
        SELECT("slowest_time");
        SELECT("slowest_host");
        FROM("statistics_spans");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StatisticsSpans record = (StatisticsSpans) parameter.get("record");
        StatisticsSpansExample example = (StatisticsSpansExample) parameter.get("example");
        
        BEGIN();
        UPDATE("statistics_spans");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            SET("start_time = #{record.startTime,jdbcType=VARCHAR}");
        }
        
        if (record.getEndTime() != null) {
            SET("end_time = #{record.endTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSpanName() != null) {
            SET("span_name = #{record.spanName,jdbcType=VARCHAR}");
        }
        
        if (record.getCalledNum() != null) {
            SET("called_num = #{record.calledNum,jdbcType=VARCHAR}");
        }
        
        if (record.getAvgTime() != null) {
            SET("avg_time = #{record.avgTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSlowestId() != null) {
            SET("slowest_id = #{record.slowestId,jdbcType=VARCHAR}");
        }
        
        if (record.getSlowestTime() != null) {
            SET("slowest_time = #{record.slowestTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSlowestHost() != null) {
            SET("slowest_host = #{record.slowestHost,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("statistics_spans");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("start_time = #{record.startTime,jdbcType=VARCHAR}");
        SET("end_time = #{record.endTime,jdbcType=VARCHAR}");
        SET("span_name = #{record.spanName,jdbcType=VARCHAR}");
        SET("called_num = #{record.calledNum,jdbcType=VARCHAR}");
        SET("avg_time = #{record.avgTime,jdbcType=VARCHAR}");
        SET("slowest_id = #{record.slowestId,jdbcType=VARCHAR}");
        SET("slowest_time = #{record.slowestTime,jdbcType=VARCHAR}");
        SET("slowest_host = #{record.slowestHost,jdbcType=VARCHAR}");
        
        StatisticsSpansExample example = (StatisticsSpansExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(StatisticsSpans record) {
        BEGIN();
        UPDATE("statistics_spans");
        
        if (record.getStartTime() != null) {
            SET("start_time = #{startTime,jdbcType=VARCHAR}");
        }
        
        if (record.getEndTime() != null) {
            SET("end_time = #{endTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSpanName() != null) {
            SET("span_name = #{spanName,jdbcType=VARCHAR}");
        }
        
        if (record.getCalledNum() != null) {
            SET("called_num = #{calledNum,jdbcType=VARCHAR}");
        }
        
        if (record.getAvgTime() != null) {
            SET("avg_time = #{avgTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSlowestId() != null) {
            SET("slowest_id = #{slowestId,jdbcType=VARCHAR}");
        }
        
        if (record.getSlowestTime() != null) {
            SET("slowest_time = #{slowestTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSlowestHost() != null) {
            SET("slowest_host = #{slowestHost,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(StatisticsSpansExample example, boolean includeExamplePhrase) {
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