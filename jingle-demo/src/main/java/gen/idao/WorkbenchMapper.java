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