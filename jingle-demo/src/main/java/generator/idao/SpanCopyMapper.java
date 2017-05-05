package generator.idao;

import generator.pojo.SpanCopy;
import generator.pojo.SpanCopyExample;
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

public interface SpanCopyMapper {
    @SelectProvider(type=SpanCopySqlProvider.class, method="countByExample")
    int countByExample(SpanCopyExample example);

    @DeleteProvider(type=SpanCopySqlProvider.class, method="deleteByExample")
    int deleteByExample(SpanCopyExample example);

    @Delete({
        "delete from span_copy",
        "where trace_id = #{traceId,jdbcType=BIGINT}",
          "and span_id = #{spanId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(@Param("traceId") Long traceId, @Param("spanId") Long spanId);

    @Insert({
        "insert into span_copy (trace_id, span_id, ",
        "endpoint_ipv4, endpoint_service_name, ",
        "start_ts, duration, ",
        "record_ts, trace_md5, ",
        "parent_id, parent_ip, ",
        "parent_endpoint_name)",
        "values (#{traceId,jdbcType=BIGINT}, #{spanId,jdbcType=BIGINT}, ",
        "#{endpointIpv4,jdbcType=INTEGER}, #{endpointServiceName,jdbcType=VARCHAR}, ",
        "#{startTs,jdbcType=BIGINT}, #{duration,jdbcType=BIGINT}, ",
        "#{recordTs,jdbcType=BIGINT}, #{traceMd5,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=BIGINT}, #{parentIp,jdbcType=INTEGER}, ",
        "#{parentEndpointName,jdbcType=VARCHAR})"
    })
    int insert(SpanCopy record);

    @InsertProvider(type=SpanCopySqlProvider.class, method="insertSelective")
    int insertSelective(SpanCopy record);

    @SelectProvider(type=SpanCopySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="span_id", property="spanId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="endpoint_ipv4", property="endpointIpv4", jdbcType=JdbcType.INTEGER),
        @Result(column="endpoint_service_name", property="endpointServiceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.BIGINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT),
        @Result(column="record_ts", property="recordTs", jdbcType=JdbcType.BIGINT),
        @Result(column="trace_md5", property="traceMd5", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="parent_ip", property="parentIp", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_endpoint_name", property="parentEndpointName", jdbcType=JdbcType.VARCHAR)
    })
    List<SpanCopy> selectByExample(SpanCopyExample example);

    @Select({
        "select",
        "trace_id, span_id, endpoint_ipv4, endpoint_service_name, start_ts, duration, ",
        "record_ts, trace_md5, parent_id, parent_ip, parent_endpoint_name",
        "from span_copy",
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
        @Result(column="record_ts", property="recordTs", jdbcType=JdbcType.BIGINT),
        @Result(column="trace_md5", property="traceMd5", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="parent_ip", property="parentIp", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_endpoint_name", property="parentEndpointName", jdbcType=JdbcType.VARCHAR)
    })
    SpanCopy selectByPrimaryKey(@Param("traceId") Long traceId, @Param("spanId") Long spanId);

    @UpdateProvider(type=SpanCopySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SpanCopy record, @Param("example") SpanCopyExample example);

    @UpdateProvider(type=SpanCopySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SpanCopy record, @Param("example") SpanCopyExample example);

    @UpdateProvider(type=SpanCopySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpanCopy record);

    @Update({
        "update span_copy",
        "set endpoint_ipv4 = #{endpointIpv4,jdbcType=INTEGER},",
          "endpoint_service_name = #{endpointServiceName,jdbcType=VARCHAR},",
          "start_ts = #{startTs,jdbcType=BIGINT},",
          "duration = #{duration,jdbcType=BIGINT},",
          "record_ts = #{recordTs,jdbcType=BIGINT},",
          "trace_md5 = #{traceMd5,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=BIGINT},",
          "parent_ip = #{parentIp,jdbcType=INTEGER},",
          "parent_endpoint_name = #{parentEndpointName,jdbcType=VARCHAR}",
        "where trace_id = #{traceId,jdbcType=BIGINT}",
          "and span_id = #{spanId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SpanCopy record);
}