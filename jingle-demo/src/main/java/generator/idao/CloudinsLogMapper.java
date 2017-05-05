package generator.idao;

import generator.pojo.CloudinsLog;
import generator.pojo.CloudinsLogExample;
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

public interface CloudinsLogMapper {
    @SelectProvider(type=CloudinsLogSqlProvider.class, method="countByExample")
    int countByExample(CloudinsLogExample example);

    @DeleteProvider(type=CloudinsLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(CloudinsLogExample example);

    @Delete({
        "delete from cloudins_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cloudins_log (id, level, method, ",
        "time, line, displayed, ",
        "isread, message)",
        "values (#{id,jdbcType=BIGINT}, #{level,jdbcType=CHAR}, #{method,jdbcType=VARCHAR}, ",
        "#{time,jdbcType=CHAR}, #{line,jdbcType=INTEGER}, #{displayed,jdbcType=BIT}, ",
        "#{isread,jdbcType=BIT}, #{message,jdbcType=LONGVARCHAR})"
    })
    int insert(CloudinsLog record);

    @InsertProvider(type=CloudinsLogSqlProvider.class, method="insertSelective")
    int insertSelective(CloudinsLog record);

    @SelectProvider(type=CloudinsLogSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.CHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.CHAR),
        @Result(column="line", property="line", jdbcType=JdbcType.INTEGER),
        @Result(column="displayed", property="displayed", jdbcType=JdbcType.BIT),
        @Result(column="isread", property="isread", jdbcType=JdbcType.BIT),
        @Result(column="message", property="message", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CloudinsLog> selectByExampleWithBLOBs(CloudinsLogExample example);

    @SelectProvider(type=CloudinsLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.CHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.CHAR),
        @Result(column="line", property="line", jdbcType=JdbcType.INTEGER),
        @Result(column="displayed", property="displayed", jdbcType=JdbcType.BIT),
        @Result(column="isread", property="isread", jdbcType=JdbcType.BIT)
    })
    List<CloudinsLog> selectByExample(CloudinsLogExample example);

    @Select({
        "select",
        "id, level, method, time, line, displayed, isread, message",
        "from cloudins_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.CHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.CHAR),
        @Result(column="line", property="line", jdbcType=JdbcType.INTEGER),
        @Result(column="displayed", property="displayed", jdbcType=JdbcType.BIT),
        @Result(column="isread", property="isread", jdbcType=JdbcType.BIT),
        @Result(column="message", property="message", jdbcType=JdbcType.LONGVARCHAR)
    })
    CloudinsLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=CloudinsLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CloudinsLog record, @Param("example") CloudinsLogExample example);

    @UpdateProvider(type=CloudinsLogSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") CloudinsLog record, @Param("example") CloudinsLogExample example);

    @UpdateProvider(type=CloudinsLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CloudinsLog record, @Param("example") CloudinsLogExample example);

    @UpdateProvider(type=CloudinsLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CloudinsLog record);

    @Update({
        "update cloudins_log",
        "set level = #{level,jdbcType=CHAR},",
          "method = #{method,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=CHAR},",
          "line = #{line,jdbcType=INTEGER},",
          "displayed = #{displayed,jdbcType=BIT},",
          "isread = #{isread,jdbcType=BIT},",
          "message = #{message,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(CloudinsLog record);

    @Update({
        "update cloudins_log",
        "set level = #{level,jdbcType=CHAR},",
          "method = #{method,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=CHAR},",
          "line = #{line,jdbcType=INTEGER},",
          "displayed = #{displayed,jdbcType=BIT},",
          "isread = #{isread,jdbcType=BIT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CloudinsLog record);
}