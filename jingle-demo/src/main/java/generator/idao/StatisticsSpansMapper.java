package generator.idao;

import generator.pojo.StatisticsSpans;
import generator.pojo.StatisticsSpansExample;
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

public interface StatisticsSpansMapper {
    @SelectProvider(type=StatisticsSpansSqlProvider.class, method="countByExample")
    int countByExample(StatisticsSpansExample example);

    @DeleteProvider(type=StatisticsSpansSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatisticsSpansExample example);

    @Delete({
        "delete from statistics_spans",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into statistics_spans (id, start_time, ",
        "end_time, span_name, ",
        "called_num, avg_time, ",
        "slowest_id, slowest_time, ",
        "slowest_host)",
        "values (#{id,jdbcType=INTEGER}, #{startTime,jdbcType=VARCHAR}, ",
        "#{endTime,jdbcType=VARCHAR}, #{spanName,jdbcType=VARCHAR}, ",
        "#{calledNum,jdbcType=VARCHAR}, #{avgTime,jdbcType=VARCHAR}, ",
        "#{slowestId,jdbcType=VARCHAR}, #{slowestTime,jdbcType=VARCHAR}, ",
        "#{slowestHost,jdbcType=VARCHAR})"
    })
    int insert(StatisticsSpans record);

    @InsertProvider(type=StatisticsSpansSqlProvider.class, method="insertSelective")
    int insertSelective(StatisticsSpans record);

    @SelectProvider(type=StatisticsSpansSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="span_name", property="spanName", jdbcType=JdbcType.VARCHAR),
        @Result(column="called_num", property="calledNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="avg_time", property="avgTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="slowest_id", property="slowestId", jdbcType=JdbcType.VARCHAR),
        @Result(column="slowest_time", property="slowestTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="slowest_host", property="slowestHost", jdbcType=JdbcType.VARCHAR)
    })
    List<StatisticsSpans> selectByExample(StatisticsSpansExample example);

    @Select({
        "select",
        "id, start_time, end_time, span_name, called_num, avg_time, slowest_id, slowest_time, ",
        "slowest_host",
        "from statistics_spans",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="span_name", property="spanName", jdbcType=JdbcType.VARCHAR),
        @Result(column="called_num", property="calledNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="avg_time", property="avgTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="slowest_id", property="slowestId", jdbcType=JdbcType.VARCHAR),
        @Result(column="slowest_time", property="slowestTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="slowest_host", property="slowestHost", jdbcType=JdbcType.VARCHAR)
    })
    StatisticsSpans selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StatisticsSpansSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatisticsSpans record, @Param("example") StatisticsSpansExample example);

    @UpdateProvider(type=StatisticsSpansSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatisticsSpans record, @Param("example") StatisticsSpansExample example);

    @UpdateProvider(type=StatisticsSpansSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatisticsSpans record);

    @Update({
        "update statistics_spans",
        "set start_time = #{startTime,jdbcType=VARCHAR},",
          "end_time = #{endTime,jdbcType=VARCHAR},",
          "span_name = #{spanName,jdbcType=VARCHAR},",
          "called_num = #{calledNum,jdbcType=VARCHAR},",
          "avg_time = #{avgTime,jdbcType=VARCHAR},",
          "slowest_id = #{slowestId,jdbcType=VARCHAR},",
          "slowest_time = #{slowestTime,jdbcType=VARCHAR},",
          "slowest_host = #{slowestHost,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StatisticsSpans record);
}