package generator.idao;

import generator.pojo.Traces;
import generator.pojo.TracesExample;
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

public interface TracesMapper {
    @SelectProvider(type=TracesSqlProvider.class, method="countByExample")
    int countByExample(TracesExample example);

    @DeleteProvider(type=TracesSqlProvider.class, method="deleteByExample")
    int deleteByExample(TracesExample example);

    @Delete({
        "delete from traces",
        "where trace_id = #{traceId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long traceId);

    @Insert({
        "insert into traces (trace_id, trace_md5, ",
        "start_ts, duration, ",
        "end_ts, team_code)",
        "values (#{traceId,jdbcType=BIGINT}, #{traceMd5,jdbcType=VARCHAR}, ",
        "#{startTs,jdbcType=BIGINT}, #{duration,jdbcType=BIGINT}, ",
        "#{endTs,jdbcType=BIGINT}, #{teamCode,jdbcType=SMALLINT})"
    })
    int insert(Traces record);

    @InsertProvider(type=TracesSqlProvider.class, method="insertSelective")
    int insertSelective(Traces record);

    @SelectProvider(type=TracesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trace_md5", property="traceMd5", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.BIGINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT),
        @Result(column="end_ts", property="endTs", jdbcType=JdbcType.BIGINT),
        @Result(column="team_code", property="teamCode", jdbcType=JdbcType.SMALLINT)
    })
    List<Traces> selectByExample(TracesExample example);

    @Select({
        "select",
        "trace_id, trace_md5, start_ts, duration, end_ts, team_code",
        "from traces",
        "where trace_id = #{traceId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trace_md5", property="traceMd5", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.BIGINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT),
        @Result(column="end_ts", property="endTs", jdbcType=JdbcType.BIGINT),
        @Result(column="team_code", property="teamCode", jdbcType=JdbcType.SMALLINT)
    })
    Traces selectByPrimaryKey(Long traceId);

    @UpdateProvider(type=TracesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Traces record, @Param("example") TracesExample example);

    @UpdateProvider(type=TracesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Traces record, @Param("example") TracesExample example);

    @UpdateProvider(type=TracesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Traces record);

    @Update({
        "update traces",
        "set trace_md5 = #{traceMd5,jdbcType=VARCHAR},",
          "start_ts = #{startTs,jdbcType=BIGINT},",
          "duration = #{duration,jdbcType=BIGINT},",
          "end_ts = #{endTs,jdbcType=BIGINT},",
          "team_code = #{teamCode,jdbcType=SMALLINT}",
        "where trace_id = #{traceId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Traces record);
}