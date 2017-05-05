package generator.idao;

import generator.pojo.CloudinsUserRegionAppli;
import generator.pojo.CloudinsUserRegionAppliExample;
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

public interface CloudinsUserRegionAppliMapper {
    @SelectProvider(type=CloudinsUserRegionAppliSqlProvider.class, method="countByExample")
    int countByExample(CloudinsUserRegionAppliExample example);

    @DeleteProvider(type=CloudinsUserRegionAppliSqlProvider.class, method="deleteByExample")
    int deleteByExample(CloudinsUserRegionAppliExample example);

    @Delete({
        "delete from cloudins_user_region_appli",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cloudins_user_region_appli (id, user_id, ",
        "user_name, region_id, ",
        "region_name, status, ",
        "appli_msg, reply_msg)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{userName,jdbcType=VARCHAR}, #{regionId,jdbcType=BIGINT}, ",
        "#{regionName,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}, ",
        "#{appliMsg,jdbcType=VARCHAR}, #{replyMsg,jdbcType=VARCHAR})"
    })
    int insert(CloudinsUserRegionAppli record);

    @InsertProvider(type=CloudinsUserRegionAppliSqlProvider.class, method="insertSelective")
    int insertSelective(CloudinsUserRegionAppli record);

    @SelectProvider(type=CloudinsUserRegionAppliSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="region_id", property="regionId", jdbcType=JdbcType.BIGINT),
        @Result(column="region_name", property="regionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="appli_msg", property="appliMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="reply_msg", property="replyMsg", jdbcType=JdbcType.VARCHAR)
    })
    List<CloudinsUserRegionAppli> selectByExample(CloudinsUserRegionAppliExample example);

    @Select({
        "select",
        "id, user_id, user_name, region_id, region_name, status, appli_msg, reply_msg",
        "from cloudins_user_region_appli",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="region_id", property="regionId", jdbcType=JdbcType.BIGINT),
        @Result(column="region_name", property="regionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="appli_msg", property="appliMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="reply_msg", property="replyMsg", jdbcType=JdbcType.VARCHAR)
    })
    CloudinsUserRegionAppli selectByPrimaryKey(Long id);

    @UpdateProvider(type=CloudinsUserRegionAppliSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CloudinsUserRegionAppli record, @Param("example") CloudinsUserRegionAppliExample example);

    @UpdateProvider(type=CloudinsUserRegionAppliSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CloudinsUserRegionAppli record, @Param("example") CloudinsUserRegionAppliExample example);

    @UpdateProvider(type=CloudinsUserRegionAppliSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CloudinsUserRegionAppli record);

    @Update({
        "update cloudins_user_region_appli",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "region_id = #{regionId,jdbcType=BIGINT},",
          "region_name = #{regionName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR},",
          "appli_msg = #{appliMsg,jdbcType=VARCHAR},",
          "reply_msg = #{replyMsg,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CloudinsUserRegionAppli record);
}