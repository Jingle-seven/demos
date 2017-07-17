package gen.idao;

import gen.pojo.PoolCabinet;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface PoolCabinetMapper {
    @Delete({
        "delete from pool_cabinet",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pool_cabinet (id, number, ",
        "location, create_time, ",
        "update_time, status)",
        "values (#{id,jdbcType=BIGINT}, #{number,jdbcType=VARCHAR}, ",
        "#{location,jdbcType=VARCHAR}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{status,jdbcType=VARCHAR})"
    })
    int insert(PoolCabinet record);

    @Select({
        "select",
        "id, number, location, create_time, update_time, status",
        "from pool_cabinet",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    PoolCabinet selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, number, location, create_time, update_time, status",
        "from pool_cabinet"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<PoolCabinet> selectAll();

    @Update({
        "update pool_cabinet",
        "set number = #{number,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PoolCabinet record);
}