package gen.idao;

import gen.pojo.IpHistory;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface IpHistoryMapper {
    @Delete({
        "delete from ip_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ip_history (id, ip_id, ",
        "ip, asset_id, vm_id, ",
        "user_id, floor, remark, ",
        "create_time, update_time, ",
        "start_time, expired_time, ",
        "is_expired, status, ",
        "operation)",
        "values (#{id,jdbcType=BIGINT}, #{ipId,jdbcType=BIGINT}, ",
        "#{ip,jdbcType=VARCHAR}, #{assetId,jdbcType=BIGINT}, #{vmId,jdbcType=BIGINT}, ",
        "#{userId,jdbcType=BIGINT}, #{floor,jdbcType=BIGINT}, #{remark,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=BIGINT}, #{updateTime,jdbcType=BIGINT}, ",
        "#{startTime,jdbcType=BIGINT}, #{expiredTime,jdbcType=BIGINT}, ",
        "#{isExpired,jdbcType=TINYINT}, #{status,jdbcType=VARCHAR}, ",
        "#{operation,jdbcType=VARCHAR})"
    })
    int insert(IpHistory record);

    @Select({
        "select",
        "id, ip_id, ip, asset_id, vm_id, user_id, floor, remark, create_time, update_time, ",
        "start_time, expired_time, is_expired, status, operation",
        "from ip_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip_id", property="ipId", jdbcType=JdbcType.BIGINT),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="vm_id", property="vmId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="floor", property="floor", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="is_expired", property="isExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR)
    })
    IpHistory selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, ip_id, ip, asset_id, vm_id, user_id, floor, remark, create_time, update_time, ",
        "start_time, expired_time, is_expired, status, operation",
        "from ip_history"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip_id", property="ipId", jdbcType=JdbcType.BIGINT),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="vm_id", property="vmId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="floor", property="floor", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="is_expired", property="isExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR)
    })
    List<IpHistory> selectAll();

    @Update({
        "update ip_history",
        "set ip_id = #{ipId,jdbcType=BIGINT},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "asset_id = #{assetId,jdbcType=BIGINT},",
          "vm_id = #{vmId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "floor = #{floor,jdbcType=BIGINT},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "start_time = #{startTime,jdbcType=BIGINT},",
          "expired_time = #{expiredTime,jdbcType=BIGINT},",
          "is_expired = #{isExpired,jdbcType=TINYINT},",
          "status = #{status,jdbcType=VARCHAR},",
          "operation = #{operation,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(IpHistory record);
}