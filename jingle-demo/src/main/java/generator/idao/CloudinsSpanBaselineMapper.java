package generator.idao;

import generator.pojo.CloudinsSpanBaseline;
import generator.pojo.CloudinsSpanBaselineExample;
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

public interface CloudinsSpanBaselineMapper {
    @SelectProvider(type=CloudinsSpanBaselineSqlProvider.class, method="countByExample")
    int countByExample(CloudinsSpanBaselineExample example);

    @DeleteProvider(type=CloudinsSpanBaselineSqlProvider.class, method="deleteByExample")
    int deleteByExample(CloudinsSpanBaselineExample example);

    @Delete({
        "delete from cloudins_span_baseline",
        "where trace_id = #{traceId,jdbcType=BIGINT}",
          "and id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(@Param("traceId") Long traceId, @Param("id") Long id);

    @Insert({
        "insert into cloudins_span_baseline (trace_id, id, ",
        "trace_md5, name, ",
        "parent_id, start_ts, ",
        "duration)",
        "values (#{traceId,jdbcType=BIGINT}, #{id,jdbcType=BIGINT}, ",
        "#{traceMd5,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=BIGINT}, #{startTs,jdbcType=BIGINT}, ",
        "#{duration,jdbcType=BIGINT})"
    })
    int insert(CloudinsSpanBaseline record);

    @InsertProvider(type=CloudinsSpanBaselineSqlProvider.class, method="insertSelective")
    int insertSelective(CloudinsSpanBaseline record);

    @SelectProvider(type=CloudinsSpanBaselineSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trace_md5", property="traceMd5", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.BIGINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT)
    })
    List<CloudinsSpanBaseline> selectByExample(CloudinsSpanBaselineExample example);

    @Select({
        "select",
        "trace_id, id, trace_md5, name, parent_id, start_ts, duration",
        "from cloudins_span_baseline",
        "where trace_id = #{traceId,jdbcType=BIGINT}",
          "and id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trace_md5", property="traceMd5", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.BIGINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT)
    })
    CloudinsSpanBaseline selectByPrimaryKey(@Param("traceId") Long traceId, @Param("id") Long id);

    @UpdateProvider(type=CloudinsSpanBaselineSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CloudinsSpanBaseline record, @Param("example") CloudinsSpanBaselineExample example);

    @UpdateProvider(type=CloudinsSpanBaselineSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CloudinsSpanBaseline record, @Param("example") CloudinsSpanBaselineExample example);

    @UpdateProvider(type=CloudinsSpanBaselineSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CloudinsSpanBaseline record);

    @Update({
        "update cloudins_span_baseline",
        "set trace_md5 = #{traceMd5,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=BIGINT},",
          "start_ts = #{startTs,jdbcType=BIGINT},",
          "duration = #{duration,jdbcType=BIGINT}",
        "where trace_id = #{traceId,jdbcType=BIGINT}",
          "and id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CloudinsSpanBaseline record);
}