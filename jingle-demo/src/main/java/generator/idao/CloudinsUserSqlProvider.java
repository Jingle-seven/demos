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

import generator.pojo.CloudinsUser;
import generator.pojo.CloudinsUserExample.Criteria;
import generator.pojo.CloudinsUserExample.Criterion;
import generator.pojo.CloudinsUserExample;
import java.util.List;
import java.util.Map;

public class CloudinsUserSqlProvider {

    public String countByExample(CloudinsUserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("cloudins_user");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CloudinsUserExample example) {
        BEGIN();
        DELETE_FROM("cloudins_user");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CloudinsUser record) {
        BEGIN();
        INSERT_INTO("cloudins_user");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            VALUES("role_id", "#{roleId,jdbcType=BIGINT}");
        }
        
        if (record.getRegionId() != null) {
            VALUES("region_id", "#{regionId,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            VALUES("account", "#{account,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=CHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            VALUES("gender", "#{gender,jdbcType=TINYINT}");
        }
        
        if (record.getMail() != null) {
            VALUES("mail", "#{mail,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            VALUES("company", "#{company,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=BIGINT}");
        }
        
        if (record.getQq() != null) {
            VALUES("qq", "#{qq,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(CloudinsUserExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("role_id");
        SELECT("region_id");
        SELECT("account");
        SELECT("name");
        SELECT("password");
        SELECT("gender");
        SELECT("mail");
        SELECT("company");
        SELECT("phone");
        SELECT("qq");
        SELECT("status");
        SELECT("remark");
        FROM("cloudins_user");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CloudinsUser record = (CloudinsUser) parameter.get("record");
        CloudinsUserExample example = (CloudinsUserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("cloudins_user");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            SET("role_id = #{record.roleId,jdbcType=BIGINT}");
        }
        
        if (record.getRegionId() != null) {
            SET("region_id = #{record.regionId,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            SET("account = #{record.account,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=CHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{record.gender,jdbcType=TINYINT}");
        }
        
        if (record.getMail() != null) {
            SET("mail = #{record.mail,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            SET("company = #{record.company,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{record.phone,jdbcType=BIGINT}");
        }
        
        if (record.getQq() != null) {
            SET("qq = #{record.qq,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("cloudins_user");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("role_id = #{record.roleId,jdbcType=BIGINT}");
        SET("region_id = #{record.regionId,jdbcType=BIGINT}");
        SET("account = #{record.account,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=CHAR}");
        SET("password = #{record.password,jdbcType=VARCHAR}");
        SET("gender = #{record.gender,jdbcType=TINYINT}");
        SET("mail = #{record.mail,jdbcType=VARCHAR}");
        SET("company = #{record.company,jdbcType=VARCHAR}");
        SET("phone = #{record.phone,jdbcType=BIGINT}");
        SET("qq = #{record.qq,jdbcType=BIGINT}");
        SET("status = #{record.status,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        
        CloudinsUserExample example = (CloudinsUserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CloudinsUser record) {
        BEGIN();
        UPDATE("cloudins_user");
        
        if (record.getRoleId() != null) {
            SET("role_id = #{roleId,jdbcType=BIGINT}");
        }
        
        if (record.getRegionId() != null) {
            SET("region_id = #{regionId,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            SET("account = #{account,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=CHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{gender,jdbcType=TINYINT}");
        }
        
        if (record.getMail() != null) {
            SET("mail = #{mail,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            SET("company = #{company,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=BIGINT}");
        }
        
        if (record.getQq() != null) {
            SET("qq = #{qq,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CloudinsUserExample example, boolean includeExamplePhrase) {
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