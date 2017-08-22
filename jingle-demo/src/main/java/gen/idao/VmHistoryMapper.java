package gen.idao;

import gen.pojo.VmHistory;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface VmHistoryMapper {
    @Delete({
        "delete from vm_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into vm_history (id, vm_id, ",
        "name, asset_id, user_id, ",
        "info, remark, create_time, ",
        "update_time, start_time, ",
        "expired_time, is_expired, ",
        "status, operation)",
        "values (#{id,jdbcType=BIGINT}, #{vmId,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{assetId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{info,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{startTime,jdbcType=BIGINT}, ",
        "#{expiredTime,jdbcType=BIGINT}, #{isExpired,jdbcType=TINYINT}, ",
        "#{status,jdbcType=VARCHAR}, #{operation,jdbcType=VARCHAR})"
    })
    int insert(VmHistory record);

    @Select({
        "select",
        "id, vm_id, name, asset_id, user_id, info, remark, create_time, update_time, ",
        "start_time, expired_time, is_expired, status, operation",
        "from vm_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="vm_id", property="vmId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="is_expired", property="isExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR)
    })
    VmHistory selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, vm_id, name, asset_id, user_id, info, remark, create_time, update_time, ",
        "start_time, expired_time, is_expired, status, operation",
        "from vm_history"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="vm_id", property="vmId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="is_expired", property="isExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR)
    })
    List<VmHistory> selectAll();

    @Update({
        "update vm_history",
        "set vm_id = #{vmId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "asset_id = #{assetId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "info = #{info,jdbcType=VARCHAR},",
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
    int updateByPrimaryKey(VmHistory record);
}