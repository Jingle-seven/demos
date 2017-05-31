package xz.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.TUser;

import java.util.List;

public interface UserMapper {
    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_user (id, name, ",
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
        "from t_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType= JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType= JdbcType.VARCHAR),
        @Result(column="authority", property="authority", jdbcType= JdbcType.TINYINT)
    })
    TUser selectById(Long id);
    
    @Select({
            "select",
            "id, name, account, password, authority",
            "from t_user",
            "where account = #{str}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
            @Result(column="account", property="account", jdbcType= JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType= JdbcType.VARCHAR),
            @Result(column="authority", property="authority", jdbcType= JdbcType.TINYINT)
    })
    TUser selectByAccount(String str);

    @Select({
        "select",
        "id, name, account, password, authority",
        "from t_user"
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
        "update t_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "authority = #{authority,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateById(TUser record);
}