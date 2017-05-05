package generator.idao;

import generator.pojo.ZipkinSpans;
import generator.pojo.ZipkinSpansExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ZipkinSpansMapper {
    @SelectProvider(type=ZipkinSpansSqlProvider.class, method="countByExample")
    int countByExample(ZipkinSpansExample example);

    @DeleteProvider(type=ZipkinSpansSqlProvider.class, method="deleteByExample")
    int deleteByExample(ZipkinSpansExample example);

    @Insert({
        "insert into zipkin_spans (trace_id, id, ",
        "name, parent_id, debug, ",
        "start_ts, record_ts, ",
        "duration)",
        "values (#{traceId,jdbcType=BIGINT}, #{id,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{parentId,jdbcType=BIGINT}, #{debug,jdbcType=BIT}, ",
        "#{startTs,jdbcType=BIGINT}, #{recordTs,jdbcType=BIGINT}, ",
        "#{duration,jdbcType=BIGINT})"
    })
    int insert(ZipkinSpans record);

    @InsertProvider(type=ZipkinSpansSqlProvider.class, method="insertSelective")
    int insertSelective(ZipkinSpans record);

    @SelectProvider(type=ZipkinSpansSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT),
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="debug", property="debug", jdbcType=JdbcType.BIT),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.BIGINT),
        @Result(column="record_ts", property="recordTs", jdbcType=JdbcType.BIGINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT)
    })
    List<ZipkinSpans> selectByExample(ZipkinSpansExample example);

    @UpdateProvider(type=ZipkinSpansSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ZipkinSpans record, @Param("example") ZipkinSpansExample example);

    @UpdateProvider(type=ZipkinSpansSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ZipkinSpans record, @Param("example") ZipkinSpansExample example);
}