package gen.idao;

import gen.pojo.OperationLog;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OperationLogMapper {
    @Delete({
        "delete from operation_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into operation_log (id, datetime, ",
        "user, operation_sql, ",
        "status, operation)",
        "values (#{id,jdbcType=BIGINT}, #{datetime,jdbcType=TIMESTAMP}, ",
        "#{user,jdbcType=VARCHAR}, #{operationSql,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{operation,jdbcType=LONGVARCHAR})"
    })
    int insert(OperationLog record);

    @Select({
        "select",
        "id, datetime, user, operation_sql, status, operation",
        "from operation_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="datetime", property="datetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation_sql", property="operationSql", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.LONGVARCHAR)
    })
    OperationLog selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, datetime, user, operation_sql, status, operation",
        "from operation_log"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="datetime", property="datetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation_sql", property="operationSql", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OperationLog> selectAll();

    @Update({
        "update operation_log",
        "set datetime = #{datetime,jdbcType=TIMESTAMP},",
          "user = #{user,jdbcType=VARCHAR},",
          "operation_sql = #{operationSql,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "operation = #{operation,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OperationLog record);
}