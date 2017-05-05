package generator.idao;

import generator.pojo.TraceInfos;
import generator.pojo.TraceInfosExample;
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

public interface TraceInfosMapper {
    @SelectProvider(type=TraceInfosSqlProvider.class, method="countByExample")
    int countByExample(TraceInfosExample example);

    @DeleteProvider(type=TraceInfosSqlProvider.class, method="deleteByExample")
    int deleteByExample(TraceInfosExample example);

    @Delete({
        "delete from trace_infos",
        "where trace_md5 = #{traceMd5,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String traceMd5);

    @Insert({
        "insert into trace_infos (trace_md5, root_name, ",
        "trace_name, span_count, ",
        "trace_alias, base_trace_id, ",
        "warning_duration, warning_percentage)",
        "values (#{traceMd5,jdbcType=VARCHAR}, #{rootName,jdbcType=VARCHAR}, ",
        "#{traceName,jdbcType=VARCHAR}, #{spanCount,jdbcType=SMALLINT}, ",
        "#{traceAlias,jdbcType=VARCHAR}, #{baseTraceId,jdbcType=BIGINT}, ",
        "#{warningDuration,jdbcType=BIGINT}, #{warningPercentage,jdbcType=INTEGER})"
    })
    int insert(TraceInfos record);

    @InsertProvider(type=TraceInfosSqlProvider.class, method="insertSelective")
    int insertSelective(TraceInfos record);

    @SelectProvider(type=TraceInfosSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="trace_md5", property="traceMd5", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="root_name", property="rootName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trace_name", property="traceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="span_count", property="spanCount", jdbcType=JdbcType.SMALLINT),
        @Result(column="trace_alias", property="traceAlias", jdbcType=JdbcType.VARCHAR),
        @Result(column="base_trace_id", property="baseTraceId", jdbcType=JdbcType.BIGINT),
        @Result(column="warning_duration", property="warningDuration", jdbcType=JdbcType.BIGINT),
        @Result(column="warning_percentage", property="warningPercentage", jdbcType=JdbcType.INTEGER)
    })
    List<TraceInfos> selectByExample(TraceInfosExample example);

    @Select({
        "select",
        "trace_md5, root_name, trace_name, span_count, trace_alias, base_trace_id, warning_duration, ",
        "warning_percentage",
        "from trace_infos",
        "where trace_md5 = #{traceMd5,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="trace_md5", property="traceMd5", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="root_name", property="rootName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trace_name", property="traceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="span_count", property="spanCount", jdbcType=JdbcType.SMALLINT),
        @Result(column="trace_alias", property="traceAlias", jdbcType=JdbcType.VARCHAR),
        @Result(column="base_trace_id", property="baseTraceId", jdbcType=JdbcType.BIGINT),
        @Result(column="warning_duration", property="warningDuration", jdbcType=JdbcType.BIGINT),
        @Result(column="warning_percentage", property="warningPercentage", jdbcType=JdbcType.INTEGER)
    })
    TraceInfos selectByPrimaryKey(String traceMd5);

    @UpdateProvider(type=TraceInfosSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TraceInfos record, @Param("example") TraceInfosExample example);

    @UpdateProvider(type=TraceInfosSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TraceInfos record, @Param("example") TraceInfosExample example);

    @UpdateProvider(type=TraceInfosSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TraceInfos record);

    @Update({
        "update trace_infos",
        "set root_name = #{rootName,jdbcType=VARCHAR},",
          "trace_name = #{traceName,jdbcType=VARCHAR},",
          "span_count = #{spanCount,jdbcType=SMALLINT},",
          "trace_alias = #{traceAlias,jdbcType=VARCHAR},",
          "base_trace_id = #{baseTraceId,jdbcType=BIGINT},",
          "warning_duration = #{warningDuration,jdbcType=BIGINT},",
          "warning_percentage = #{warningPercentage,jdbcType=INTEGER}",
        "where trace_md5 = #{traceMd5,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TraceInfos record);
}