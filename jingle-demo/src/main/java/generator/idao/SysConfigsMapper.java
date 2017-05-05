package generator.idao;

import generator.pojo.SysConfigs;
import generator.pojo.SysConfigsExample;
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

public interface SysConfigsMapper {
    @SelectProvider(type=SysConfigsSqlProvider.class, method="countByExample")
    int countByExample(SysConfigsExample example);

    @DeleteProvider(type=SysConfigsSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysConfigsExample example);

    @Delete({
        "delete from sys_configs",
        "where config_name = #{configName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String configName);

    @Insert({
        "insert into sys_configs (config_name, config_value)",
        "values (#{configName,jdbcType=VARCHAR}, #{configValue,jdbcType=VARCHAR})"
    })
    int insert(SysConfigs record);

    @InsertProvider(type=SysConfigsSqlProvider.class, method="insertSelective")
    int insertSelective(SysConfigs record);

    @SelectProvider(type=SysConfigsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="config_name", property="configName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="config_value", property="configValue", jdbcType=JdbcType.VARCHAR)
    })
    List<SysConfigs> selectByExample(SysConfigsExample example);

    @Select({
        "select",
        "config_name, config_value",
        "from sys_configs",
        "where config_name = #{configName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="config_name", property="configName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="config_value", property="configValue", jdbcType=JdbcType.VARCHAR)
    })
    SysConfigs selectByPrimaryKey(String configName);

    @UpdateProvider(type=SysConfigsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysConfigs record, @Param("example") SysConfigsExample example);

    @UpdateProvider(type=SysConfigsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysConfigs record, @Param("example") SysConfigsExample example);

    @UpdateProvider(type=SysConfigsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysConfigs record);

    @Update({
        "update sys_configs",
        "set config_value = #{configValue,jdbcType=VARCHAR}",
        "where config_name = #{configName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysConfigs record);
}