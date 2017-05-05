package generator.idao;

import generator.pojo.CloudinsConfig;
import generator.pojo.CloudinsConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CloudinsConfigMapper {
    @SelectProvider(type=CloudinsConfigSqlProvider.class, method="countByExample")
    int countByExample(CloudinsConfigExample example);

    @DeleteProvider(type=CloudinsConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(CloudinsConfigExample example);

    @Delete({
        "delete from cloudins_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cloudins_config (id, product, ",
        "module, parm_alias, ",
        "parm_name, parm_value, ",
        "flag, comment)",
        "values (#{id,jdbcType=BIGINT}, #{product,jdbcType=VARCHAR}, ",
        "#{module,jdbcType=VARCHAR}, #{parmAlias,jdbcType=VARCHAR}, ",
        "#{parmName,jdbcType=VARCHAR}, #{parmValue,jdbcType=VARCHAR}, ",
        "#{flag,jdbcType=INTEGER}, #{comment,jdbcType=VARCHAR})"
    })
    int insert(CloudinsConfig record);

    @InsertProvider(type=CloudinsConfigSqlProvider.class, method="insertSelective")
    int insertSelective(CloudinsConfig record);

    @SelectProvider(type=CloudinsConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product", property="product", jdbcType=JdbcType.VARCHAR),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="parm_alias", property="parmAlias", jdbcType=JdbcType.VARCHAR),
        @Result(column="parm_name", property="parmName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parm_value", property="parmValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR)
    })
    List<CloudinsConfig> selectByExample(CloudinsConfigExample example);

    @Select({
        "select",
        "id, product, module, parm_alias, parm_name, parm_value, flag, comment",
        "from cloudins_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product", property="product", jdbcType=JdbcType.VARCHAR),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="parm_alias", property="parmAlias", jdbcType=JdbcType.VARCHAR),
        @Result(column="parm_name", property="parmName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parm_value", property="parmValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR)
    })
    CloudinsConfig selectByPrimaryKey(Long id);

    @UpdateProvider(type=CloudinsConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CloudinsConfig record, @Param("example") CloudinsConfigExample example);

    @UpdateProvider(type=CloudinsConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CloudinsConfig record, @Param("example") CloudinsConfigExample example);

    @UpdateProvider(type=CloudinsConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CloudinsConfig record);

    @Update({
        "update cloudins_config",
        "set product = #{product,jdbcType=VARCHAR},",
          "module = #{module,jdbcType=VARCHAR},",
          "parm_alias = #{parmAlias,jdbcType=VARCHAR},",
          "parm_name = #{parmName,jdbcType=VARCHAR},",
          "parm_value = #{parmValue,jdbcType=VARCHAR},",
          "flag = #{flag,jdbcType=INTEGER},",
          "comment = #{comment,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CloudinsConfig record);
}