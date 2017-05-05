package generator.idao;

import generator.pojo.CloudinsRegion;
import generator.pojo.CloudinsRegionExample;
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

public interface CloudinsRegionMapper {
    @SelectProvider(type=CloudinsRegionSqlProvider.class, method="countByExample")
    int countByExample(CloudinsRegionExample example);

    @DeleteProvider(type=CloudinsRegionSqlProvider.class, method="deleteByExample")
    int deleteByExample(CloudinsRegionExample example);

    @Delete({
        "delete from cloudins_region",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cloudins_region (id, name, ",
        "manager_id, manager_name, ",
        "host_ip, host_username, ",
        "host_password, company, ",
        "remark)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{managerId,jdbcType=BIGINT}, #{managerName,jdbcType=VARCHAR}, ",
        "#{hostIp,jdbcType=VARCHAR}, #{hostUsername,jdbcType=VARCHAR}, ",
        "#{hostPassword,jdbcType=VARCHAR}, #{company,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(CloudinsRegion record);

    @InsertProvider(type=CloudinsRegionSqlProvider.class, method="insertSelective")
    int insertSelective(CloudinsRegion record);

    @SelectProvider(type=CloudinsRegionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.BIGINT),
        @Result(column="manager_name", property="managerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_ip", property="hostIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_username", property="hostUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_password", property="hostPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<CloudinsRegion> selectByExample(CloudinsRegionExample example);

    @Select({
        "select",
        "id, name, manager_id, manager_name, host_ip, host_username, host_password, company, ",
        "remark",
        "from cloudins_region",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.BIGINT),
        @Result(column="manager_name", property="managerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_ip", property="hostIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_username", property="hostUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_password", property="hostPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    CloudinsRegion selectByPrimaryKey(Long id);

    @UpdateProvider(type=CloudinsRegionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CloudinsRegion record, @Param("example") CloudinsRegionExample example);

    @UpdateProvider(type=CloudinsRegionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CloudinsRegion record, @Param("example") CloudinsRegionExample example);

    @UpdateProvider(type=CloudinsRegionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CloudinsRegion record);

    @Update({
        "update cloudins_region",
        "set name = #{name,jdbcType=VARCHAR},",
          "manager_id = #{managerId,jdbcType=BIGINT},",
          "manager_name = #{managerName,jdbcType=VARCHAR},",
          "host_ip = #{hostIp,jdbcType=VARCHAR},",
          "host_username = #{hostUsername,jdbcType=VARCHAR},",
          "host_password = #{hostPassword,jdbcType=VARCHAR},",
          "company = #{company,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CloudinsRegion record);
}