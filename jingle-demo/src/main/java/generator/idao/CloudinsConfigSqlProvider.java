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

import generator.pojo.CloudinsConfig;
import generator.pojo.CloudinsConfigExample.Criteria;
import generator.pojo.CloudinsConfigExample.Criterion;
import generator.pojo.CloudinsConfigExample;
import java.util.List;
import java.util.Map;

public class CloudinsConfigSqlProvider {

    public String countByExample(CloudinsConfigExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("cloudins_config");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CloudinsConfigExample example) {
        BEGIN();
        DELETE_FROM("cloudins_config");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CloudinsConfig record) {
        BEGIN();
        INSERT_INTO("cloudins_config");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct() != null) {
            VALUES("product", "#{product,jdbcType=VARCHAR}");
        }
        
        if (record.getModule() != null) {
            VALUES("module", "#{module,jdbcType=VARCHAR}");
        }
        
        if (record.getParmAlias() != null) {
            VALUES("parm_alias", "#{parmAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getParmName() != null) {
            VALUES("parm_name", "#{parmName,jdbcType=VARCHAR}");
        }
        
        if (record.getParmValue() != null) {
            VALUES("parm_value", "#{parmValue,jdbcType=VARCHAR}");
        }
        
        if (record.getFlag() != null) {
            VALUES("flag", "#{flag,jdbcType=INTEGER}");
        }
        
        if (record.getComment() != null) {
            VALUES("comment", "#{comment,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(CloudinsConfigExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("product");
        SELECT("module");
        SELECT("parm_alias");
        SELECT("parm_name");
        SELECT("parm_value");
        SELECT("flag");
        SELECT("comment");
        FROM("cloudins_config");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CloudinsConfig record = (CloudinsConfig) parameter.get("record");
        CloudinsConfigExample example = (CloudinsConfigExample) parameter.get("example");
        
        BEGIN();
        UPDATE("cloudins_config");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getProduct() != null) {
            SET("product = #{record.product,jdbcType=VARCHAR}");
        }
        
        if (record.getModule() != null) {
            SET("module = #{record.module,jdbcType=VARCHAR}");
        }
        
        if (record.getParmAlias() != null) {
            SET("parm_alias = #{record.parmAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getParmName() != null) {
            SET("parm_name = #{record.parmName,jdbcType=VARCHAR}");
        }
        
        if (record.getParmValue() != null) {
            SET("parm_value = #{record.parmValue,jdbcType=VARCHAR}");
        }
        
        if (record.getFlag() != null) {
            SET("flag = #{record.flag,jdbcType=INTEGER}");
        }
        
        if (record.getComment() != null) {
            SET("comment = #{record.comment,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("cloudins_config");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("product = #{record.product,jdbcType=VARCHAR}");
        SET("module = #{record.module,jdbcType=VARCHAR}");
        SET("parm_alias = #{record.parmAlias,jdbcType=VARCHAR}");
        SET("parm_name = #{record.parmName,jdbcType=VARCHAR}");
        SET("parm_value = #{record.parmValue,jdbcType=VARCHAR}");
        SET("flag = #{record.flag,jdbcType=INTEGER}");
        SET("comment = #{record.comment,jdbcType=VARCHAR}");
        
        CloudinsConfigExample example = (CloudinsConfigExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CloudinsConfig record) {
        BEGIN();
        UPDATE("cloudins_config");
        
        if (record.getProduct() != null) {
            SET("product = #{product,jdbcType=VARCHAR}");
        }
        
        if (record.getModule() != null) {
            SET("module = #{module,jdbcType=VARCHAR}");
        }
        
        if (record.getParmAlias() != null) {
            SET("parm_alias = #{parmAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getParmName() != null) {
            SET("parm_name = #{parmName,jdbcType=VARCHAR}");
        }
        
        if (record.getParmValue() != null) {
            SET("parm_value = #{parmValue,jdbcType=VARCHAR}");
        }
        
        if (record.getFlag() != null) {
            SET("flag = #{flag,jdbcType=INTEGER}");
        }
        
        if (record.getComment() != null) {
            SET("comment = #{comment,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CloudinsConfigExample example, boolean includeExamplePhrase) {
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