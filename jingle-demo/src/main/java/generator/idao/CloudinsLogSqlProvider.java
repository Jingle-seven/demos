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

import generator.pojo.CloudinsLog;
import generator.pojo.CloudinsLogExample.Criteria;
import generator.pojo.CloudinsLogExample.Criterion;
import generator.pojo.CloudinsLogExample;
import java.util.List;
import java.util.Map;

public class CloudinsLogSqlProvider {

    public String countByExample(CloudinsLogExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("cloudins_log");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CloudinsLogExample example) {
        BEGIN();
        DELETE_FROM("cloudins_log");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CloudinsLog record) {
        BEGIN();
        INSERT_INTO("cloudins_log");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getLevel() != null) {
            VALUES("level", "#{level,jdbcType=CHAR}");
        }
        
        if (record.getMethod() != null) {
            VALUES("method", "#{method,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            VALUES("time", "#{time,jdbcType=CHAR}");
        }
        
        if (record.getLine() != null) {
            VALUES("line", "#{line,jdbcType=INTEGER}");
        }
        
        if (record.getDisplayed() != null) {
            VALUES("displayed", "#{displayed,jdbcType=BIT}");
        }
        
        if (record.getIsread() != null) {
            VALUES("isread", "#{isread,jdbcType=BIT}");
        }
        
        if (record.getMessage() != null) {
            VALUES("message", "#{message,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(CloudinsLogExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("level");
        SELECT("method");
        SELECT("time");
        SELECT("line");
        SELECT("displayed");
        SELECT("isread");
        SELECT("message");
        FROM("cloudins_log");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(CloudinsLogExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("level");
        SELECT("method");
        SELECT("time");
        SELECT("line");
        SELECT("displayed");
        SELECT("isread");
        FROM("cloudins_log");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CloudinsLog record = (CloudinsLog) parameter.get("record");
        CloudinsLogExample example = (CloudinsLogExample) parameter.get("example");
        
        BEGIN();
        UPDATE("cloudins_log");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getLevel() != null) {
            SET("level = #{record.level,jdbcType=CHAR}");
        }
        
        if (record.getMethod() != null) {
            SET("method = #{record.method,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{record.time,jdbcType=CHAR}");
        }
        
        if (record.getLine() != null) {
            SET("line = #{record.line,jdbcType=INTEGER}");
        }
        
        if (record.getDisplayed() != null) {
            SET("displayed = #{record.displayed,jdbcType=BIT}");
        }
        
        if (record.getIsread() != null) {
            SET("isread = #{record.isread,jdbcType=BIT}");
        }
        
        if (record.getMessage() != null) {
            SET("message = #{record.message,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("cloudins_log");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("level = #{record.level,jdbcType=CHAR}");
        SET("method = #{record.method,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=CHAR}");
        SET("line = #{record.line,jdbcType=INTEGER}");
        SET("displayed = #{record.displayed,jdbcType=BIT}");
        SET("isread = #{record.isread,jdbcType=BIT}");
        SET("message = #{record.message,jdbcType=LONGVARCHAR}");
        
        CloudinsLogExample example = (CloudinsLogExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("cloudins_log");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("level = #{record.level,jdbcType=CHAR}");
        SET("method = #{record.method,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=CHAR}");
        SET("line = #{record.line,jdbcType=INTEGER}");
        SET("displayed = #{record.displayed,jdbcType=BIT}");
        SET("isread = #{record.isread,jdbcType=BIT}");
        
        CloudinsLogExample example = (CloudinsLogExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CloudinsLog record) {
        BEGIN();
        UPDATE("cloudins_log");
        
        if (record.getLevel() != null) {
            SET("level = #{level,jdbcType=CHAR}");
        }
        
        if (record.getMethod() != null) {
            SET("method = #{method,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{time,jdbcType=CHAR}");
        }
        
        if (record.getLine() != null) {
            SET("line = #{line,jdbcType=INTEGER}");
        }
        
        if (record.getDisplayed() != null) {
            SET("displayed = #{displayed,jdbcType=BIT}");
        }
        
        if (record.getIsread() != null) {
            SET("isread = #{isread,jdbcType=BIT}");
        }
        
        if (record.getMessage() != null) {
            SET("message = #{message,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CloudinsLogExample example, boolean includeExamplePhrase) {
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