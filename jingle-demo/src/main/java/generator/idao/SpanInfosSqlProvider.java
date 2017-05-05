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

import generator.pojo.SpanInfos;
import generator.pojo.SpanInfosExample.Criteria;
import generator.pojo.SpanInfosExample.Criterion;
import generator.pojo.SpanInfosExample;
import java.util.List;
import java.util.Map;

public class SpanInfosSqlProvider {

    public String countByExample(SpanInfosExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("span_infos");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(SpanInfosExample example) {
        BEGIN();
        DELETE_FROM("span_infos");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(SpanInfos record) {
        BEGIN();
        INSERT_INTO("span_infos");
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAlias() != null) {
            VALUES("alias", "#{alias,jdbcType=VARCHAR}");
        }
        
        if (record.getDefBaseline() != null) {
            VALUES("def_baseline", "#{defBaseline,jdbcType=VARCHAR}");
        }
        
        if (record.getCustBaseline() != null) {
            VALUES("cust_baseline", "#{custBaseline,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(SpanInfosExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("name");
        } else {
            SELECT("name");
        }
        SELECT("alias");
        SELECT("def_baseline");
        SELECT("cust_baseline");
        FROM("span_infos");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SpanInfos record = (SpanInfos) parameter.get("record");
        SpanInfosExample example = (SpanInfosExample) parameter.get("example");
        
        BEGIN();
        UPDATE("span_infos");
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getAlias() != null) {
            SET("alias = #{record.alias,jdbcType=VARCHAR}");
        }
        
        if (record.getDefBaseline() != null) {
            SET("def_baseline = #{record.defBaseline,jdbcType=VARCHAR}");
        }
        
        if (record.getCustBaseline() != null) {
            SET("cust_baseline = #{record.custBaseline,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("span_infos");
        
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("alias = #{record.alias,jdbcType=VARCHAR}");
        SET("def_baseline = #{record.defBaseline,jdbcType=VARCHAR}");
        SET("cust_baseline = #{record.custBaseline,jdbcType=VARCHAR}");
        
        SpanInfosExample example = (SpanInfosExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpanInfos record) {
        BEGIN();
        UPDATE("span_infos");
        
        if (record.getAlias() != null) {
            SET("alias = #{alias,jdbcType=VARCHAR}");
        }
        
        if (record.getDefBaseline() != null) {
            SET("def_baseline = #{defBaseline,jdbcType=VARCHAR}");
        }
        
        if (record.getCustBaseline() != null) {
            SET("cust_baseline = #{custBaseline,jdbcType=VARCHAR}");
        }
        
        WHERE("name = #{name,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(SpanInfosExample example, boolean includeExamplePhrase) {
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