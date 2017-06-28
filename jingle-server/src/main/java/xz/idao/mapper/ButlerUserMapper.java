package xz.idao.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.TUser;

import java.util.List;

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
    int insert(TUser record);

    @Select({
        "select",
        "id, name, account, password, authority",
        "from butler_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType= JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType= JdbcType.VARCHAR),
        @Result(column="authority", property="authority", jdbcType= JdbcType.TINYINT)
    })
    TUser selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, name, account, password, authority",
        "from butler_user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType= JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType= JdbcType.VARCHAR),
        @Result(column="authority", property="authority", jdbcType= JdbcType.TINYINT)
    })
    List<TUser> selectAll();

    @Update({
        "update butler_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "authority = #{authority,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TUser record);
}