package gen.idao;

import gen.pojo.ButlerUser;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ButlerUserMapper {
    @Delete({
        "delete from butler_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into butler_user (id, name, ",
        "account, password, ",
        "authority)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{account,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{authority,jdbcType=TINYINT})"
    })
    int insert(ButlerUser record);

    @Select({
        "select",
        "id, name, account, password, authority",
        "from butler_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="authority", property="authority", jdbcType=JdbcType.TINYINT)
    })
    ButlerUser selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, name, account, password, authority",
        "from butler_user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="authority", property="authority", jdbcType=JdbcType.TINYINT)
    })
    List<ButlerUser> selectAll();

    @Update({
        "update butler_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "authority = #{authority,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ButlerUser record);
}