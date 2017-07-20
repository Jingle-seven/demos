package gen.idao;

import gen.pojo.Workbench;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WorkbenchMapper {
    @Delete({
        "delete from workbench",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into workbench (id, number, ",
        "user, description, ",
        "start_time, expire_time, ",
        "remark, status)",
        "values (#{id,jdbcType=BIGINT}, #{number,jdbcType=VARCHAR}, ",
        "#{user,jdbcType=BIGINT}, #{description,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=BIGINT}, #{expireTime,jdbcType=BIGINT}, ",
        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR})"
    })
    int insert(Workbench record);

    @Select({
        "select",
        "id, number, user, description, start_time, expire_time, remark, status",
        "from workbench",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType=JdbcType.BIGINT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    Workbench selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, number, user, description, start_time, expire_time, remark, status",
        "from workbench"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType=JdbcType.BIGINT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<Workbench> selectAll();

    @Update({
        "update workbench",
        "set number = #{number,jdbcType=VARCHAR},",
          "user = #{user,jdbcType=BIGINT},",
          "description = #{description,jdbcType=VARCHAR},",
          "start_time = #{startTime,jdbcType=BIGINT},",
          "expire_time = #{expireTime,jdbcType=BIGINT},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Workbench record);
}