package generator.idao;

import generator.pojo.AlarmMessage;
import generator.pojo.AlarmMessageExample;
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

public interface AlarmMessageMapper {
    @SelectProvider(type=AlarmMessageSqlProvider.class, method="countByExample")
    int countByExample(AlarmMessageExample example);

    @DeleteProvider(type=AlarmMessageSqlProvider.class, method="deleteByExample")
    int deleteByExample(AlarmMessageExample example);

    @Delete({
        "delete from alarm_message",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into alarm_message (id, trace_id, ",
        "region, time, status, ",
        "message)",
        "values (#{id,jdbcType=BIGINT}, #{traceId,jdbcType=VARCHAR}, ",
        "#{region,jdbcType=BIGINT}, #{time,jdbcType=VARCHAR}, #{status,jdbcType=SMALLINT}, ",
        "#{message,jdbcType=LONGVARCHAR})"
    })
    int insert(AlarmMessage record);

    @InsertProvider(type=AlarmMessageSqlProvider.class, method="insertSelective")
    int insertSelective(AlarmMessage record);

    @SelectProvider(type=AlarmMessageSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="region", property="region", jdbcType=JdbcType.BIGINT),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
        @Result(column="message", property="message", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<AlarmMessage> selectByExampleWithBLOBs(AlarmMessageExample example);

    @SelectProvider(type=AlarmMessageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="region", property="region", jdbcType=JdbcType.BIGINT),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT)
    })
    List<AlarmMessage> selectByExample(AlarmMessageExample example);

    @Select({
        "select",
        "id, trace_id, region, time, status, message",
        "from alarm_message",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="region", property="region", jdbcType=JdbcType.BIGINT),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
        @Result(column="message", property="message", jdbcType=JdbcType.LONGVARCHAR)
    })
    AlarmMessage selectByPrimaryKey(Long id);

    @UpdateProvider(type=AlarmMessageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AlarmMessage record, @Param("example") AlarmMessageExample example);

    @UpdateProvider(type=AlarmMessageSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") AlarmMessage record, @Param("example") AlarmMessageExample example);

    @UpdateProvider(type=AlarmMessageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AlarmMessage record, @Param("example") AlarmMessageExample example);

    @UpdateProvider(type=AlarmMessageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AlarmMessage record);

    @Update({
        "update alarm_message",
        "set trace_id = #{traceId,jdbcType=VARCHAR},",
          "region = #{region,jdbcType=BIGINT},",
          "time = #{time,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=SMALLINT},",
          "message = #{message,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(AlarmMessage record);

    @Update({
        "update alarm_message",
        "set trace_id = #{traceId,jdbcType=VARCHAR},",
          "region = #{region,jdbcType=BIGINT},",
          "time = #{time,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=SMALLINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AlarmMessage record);
}