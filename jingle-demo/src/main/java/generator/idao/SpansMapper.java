package generator.idao;

import generator.pojo.Spans;
import generator.pojo.SpansExample;
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

public interface SpansMapper {
    @SelectProvider(type=SpansSqlProvider.class, method="countByExample")
    int countByExample(SpansExample example);

    @DeleteProvider(type=SpansSqlProvider.class, method="deleteByExample")
    int deleteByExample(SpansExample example);

    @Delete({
        "delete from spans",
        "where trace_id = #{traceId,jdbcType=BIGINT}",
          "and span_id = #{spanId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(@Param("traceId") Long traceId, @Param("spanId") Long spanId);

    @Insert({
        "insert into spans (trace_id, span_id, ",
        "endpoint_ipv4, endpoint_service_name, ",
        "start_ts, duration, ",
        "record_ts)",
        "values (#{traceId,jdbcType=BIGINT}, #{spanId,jdbcType=BIGINT}, ",
        "#{endpointIpv4,jdbcType=INTEGER}, #{endpointServiceName,jdbcType=VARCHAR}, ",
        "#{startTs,jdbcType=BIGINT}, #{duration,jdbcType=BIGINT}, ",
        "#{recordTs,jdbcType=BIGINT})"
    })
    int insert(Spans record);

    @InsertProvider(type=SpansSqlProvider.class, method="insertSelective")
    int insertSelective(Spans record);

    @SelectProvider(type=SpansSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="span_id", property="spanId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="endpoint_ipv4", property="endpointIpv4", jdbcType=JdbcType.INTEGER),
        @Result(column="endpoint_service_name", property="endpointServiceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.BIGINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT),
        @Result(column="record_ts", property="recordTs", jdbcType=JdbcType.BIGINT)
    })
    List<Spans> selectByExample(SpansExample example);

    @Select({
        "select",
        "trace_id, span_id, endpoint_ipv4, endpoint_service_name, start_ts, duration, ",
        "record_ts",
        "from spans",
        "where trace_id = #{traceId,jdbcType=BIGINT}",
          "and span_id = #{spanId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="span_id", property="spanId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="endpoint_ipv4", property="endpointIpv4", jdbcType=JdbcType.INTEGER),
        @Result(column="endpoint_service_name", property="endpointServiceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.BIGINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT),
        @Result(column="record_ts", property="recordTs", jdbcType=JdbcType.BIGINT)
    })
    Spans selectByPrimaryKey(@Param("traceId") Long traceId, @Param("spanId") Long spanId);

    @UpdateProvider(type=SpansSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Spans record, @Param("example") SpansExample example);

    @UpdateProvider(type=SpansSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Spans record, @Param("example") SpansExample example);

    @UpdateProvider(type=SpansSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Spans record);

    @Update({
        "update spans",
        "set endpoint_ipv4 = #{endpointIpv4,jdbcType=INTEGER},",
          "endpoint_service_name = #{endpointServiceName,jdbcType=VARCHAR},",
          "start_ts = #{startTs,jdbcType=BIGINT},",
          "duration = #{duration,jdbcType=BIGINT},",
          "record_ts = #{recordTs,jdbcType=BIGINT}",
        "where trace_id = #{traceId,jdbcType=BIGINT}",
          "and span_id = #{spanId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Spans record);
}