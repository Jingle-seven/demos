package xz.idao.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.OperationLog;

import java.util.List;

public interface OperationLogMapper {
    @Delete({
        "delete from operation_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into operation_log (id, datetime, ",
        "user, operation, ",
        "operation_sql, status)",
        "values (#{id,jdbcType=BIGINT}, #{datetime,jdbcType=TIMESTAMP}, ",
        "#{user,jdbcType=VARCHAR}, #{operation,jdbcType=VARCHAR}, ",
        "#{operationSql,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR})"
    })
    int insert(OperationLog record);

    @Select({
        "select",
        "id, datetime, user, operation, operation_sql, status",
        "from operation_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="datetime", property="datetime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="user", property="user", jdbcType= JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType= JdbcType.VARCHAR),
        @Result(column="operation_sql", property="operationSql", jdbcType= JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType= JdbcType.VARCHAR)
    })
    OperationLog selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, datetime, user, operation, operation_sql, status",
        "from operation_log"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="datetime", property="datetime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="user", property="user", jdbcType= JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType= JdbcType.VARCHAR),
        @Result(column="operation_sql", property="operationSql", jdbcType= JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType= JdbcType.VARCHAR)
    })
    List<OperationLog> selectAll();

    @Update({
        "update operation_log",
        "set datetime = #{datetime,jdbcType=TIMESTAMP},",
          "user = #{user,jdbcType=VARCHAR},",
          "operation = #{operation,jdbcType=VARCHAR},",
          "operation_sql = #{operationSql,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OperationLog record);
}