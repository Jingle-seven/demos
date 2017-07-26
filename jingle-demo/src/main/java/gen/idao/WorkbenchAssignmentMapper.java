package gen.idao;

import gen.pojo.WorkbenchAssignment;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WorkbenchAssignmentMapper {
    @Delete({
        "delete from workbench_assignment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into workbench_assignment (id, user, ",
        "start_time, expire_time, ",
        "remark)",
        "values (#{id,jdbcType=BIGINT}, #{user,jdbcType=BIGINT}, ",
        "#{startTime,jdbcType=BIGINT}, #{expireTime,jdbcType=BIGINT}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(WorkbenchAssignment record);

    @Select({
        "select",
        "id, user, start_time, expire_time, remark",
        "from workbench_assignment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user", property="user", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    WorkbenchAssignment selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, user, start_time, expire_time, remark",
        "from workbench_assignment"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user", property="user", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<WorkbenchAssignment> selectAll();

    @Update({
        "update workbench_assignment",
        "set user = #{user,jdbcType=BIGINT},",
          "start_time = #{startTime,jdbcType=BIGINT},",
          "expire_time = #{expireTime,jdbcType=BIGINT},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WorkbenchAssignment record);
}