package xz.idao.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.Workbench;

import java.util.List;

public interface WorkbenchMapper {
    @Delete({
        "delete from workbench",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into workbench (id, number, ",
        "description, status)",
        "values (#{id,jdbcType=BIGINT}, #{number,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR})"
    })
    int insert(Workbench record);

    @Select({
        "select",
        "id, number, description, status",
        "from workbench",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    Workbench selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, number, description, status",
        "from workbench"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<Workbench> selectAll();

    @Update({
        "update workbench",
        "set number = #{number,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Workbench record);
}