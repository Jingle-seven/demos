package xz.idao.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.AssetUser;

import java.util.List;

public interface AssetUserMapper {
    @Delete({
        "delete from asset_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into asset_user (id, name, ",
        "account, password, ",
        "authority, department, ",
        "create_time, update_time, ",
        "status)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{account,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{authority,jdbcType=TINYINT}, #{department,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=BIGINT}, #{updateTime,jdbcType=BIGINT}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(AssetUser record);

    @Select({
        "select",
        "id, name, account, password, authority, department, create_time, update_time, ",
        "status",
        "from asset_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="authority", property="authority", jdbcType=JdbcType.TINYINT),
        @Result(column="department", property="department", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    AssetUser selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, name, account, password, authority, department, create_time, update_time, ",
        "status",
        "from asset_user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="authority", property="authority", jdbcType=JdbcType.TINYINT),
        @Result(column="department", property="department", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<AssetUser> selectAll();

    @Update({
        "update asset_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "authority = #{authority,jdbcType=TINYINT},",
          "department = #{department,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AssetUser record);
}