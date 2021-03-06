package xz.idao.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.PoolNetwork;

import java.util.List;

import static org.codehaus.groovy.tools.shell.util.Logger.io;

public interface PoolNetworkMapper {
    @Delete({
        "delete from pool_network",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pool_network (id, ip, asset_id, ",
        "user_id, start_time, ",
        "expired_time, create_time, ",
        "update_time, is_expired, ",
        "status)",
        "values (#{id,jdbcType=BIGINT}, #{ip,jdbcType=VARCHAR}, #{assetId,jdbcType=BIGINT}, ",
        "#{userId,jdbcType=BIGINT}, #{startTime,jdbcType=BIGINT}, ",
        "#{expiredTime,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{isExpired,jdbcType=TINYINT}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(PoolNetwork record);

    @Select({
        "select",
        "id, ip, asset_id, user_id, start_time, expired_time, create_time, update_time, ",
        "is_expired, status",
        "from pool_network",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="is_expired", property="isExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    PoolNetwork selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, ip, asset_id, user_id, start_time, expired_time, create_time, update_time, ",
        "is_expired, status",
        "from pool_network"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="is_expired", property="isExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<PoolNetwork> selectAll();

    @Update({
        "update pool_network",
        "set ip = #{ip,jdbcType=VARCHAR},",
          "asset_id = #{assetId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "start_time = #{startTime,jdbcType=BIGINT},",
          "expired_time = #{expiredTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "is_expired = #{isExpired,jdbcType=TINYINT},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PoolNetwork record);
}