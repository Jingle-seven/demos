package xz.idao.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.IpSection;

import java.util.List;

public interface IpSectionMapper {
    @Delete({
        "delete from ip_section",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ip_section (id, ip, user, ",
        "start_time, expired_time, ",
        "remark, status)",
        "values (#{id,jdbcType=BIGINT}, #{ip,jdbcType=VARCHAR}, #{user,jdbcType=BIGINT}, ",
        "#{startTime,jdbcType=BIGINT}, #{expiredTime,jdbcType=BIGINT}, ",
        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR})"
    })
    int insert(IpSection record);

    @Select({
        "select",
        "id, ip, user, start_time, expired_time, remark, status",
        "from ip_section",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    IpSection selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, ip, user, start_time, expired_time, remark, status",
        "from ip_section"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<IpSection> selectAll();

    @Update({
        "update ip_section",
        "set ip = #{ip,jdbcType=VARCHAR},",
          "user = #{user,jdbcType=BIGINT},",
          "start_time = #{startTime,jdbcType=BIGINT},",
          "expired_time = #{expiredTime,jdbcType=BIGINT},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(IpSection record);
}