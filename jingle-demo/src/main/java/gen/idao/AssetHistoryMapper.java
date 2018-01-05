package gen.idao;

import gen.pojo.AssetHistory;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AssetHistoryMapper {
    @Delete({
        "delete from asset_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into asset_history (id, asset_id, ",
        "sn, number, type_id, ",
        "asset_type_id, brand_id, ",
        "model, info, power, ",
        "manage_info, remark, ",
        "user_id, owner_id, cabinet_id, ",
        "create_time, update_time, ",
        "start_time, expired_time, ",
        "status, operation)",
        "values (#{id,jdbcType=BIGINT}, #{assetId,jdbcType=BIGINT}, ",
        "#{sn,jdbcType=VARCHAR}, #{number,jdbcType=VARCHAR}, #{typeId,jdbcType=BIGINT}, ",
        "#{assetTypeId,jdbcType=BIGINT}, #{brandId,jdbcType=BIGINT}, ",
        "#{model,jdbcType=VARCHAR}, #{info,jdbcType=VARCHAR}, #{power,jdbcType=BIGINT}, ",
        "#{manageInfo,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=BIGINT}, #{ownerId,jdbcType=BIGINT}, #{cabinetId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT}, #{updateTime,jdbcType=BIGINT}, ",
        "#{startTime,jdbcType=BIGINT}, #{expiredTime,jdbcType=BIGINT}, ",
        "#{status,jdbcType=VARCHAR}, #{operation,jdbcType=VARCHAR})"
    })
    int insert(AssetHistory record);

    @Select({
        "select",
        "id, asset_id, sn, number, type_id, asset_type_id, brand_id, model, info, power, ",
        "manage_info, remark, user_id, owner_id, cabinet_id, create_time, update_time, ",
        "start_time, expired_time, status, operation",
        "from asset_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="sn", property="sn", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="asset_type_id", property="assetTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="brand_id", property="brandId", jdbcType=JdbcType.BIGINT),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="power", property="power", jdbcType=JdbcType.BIGINT),
        @Result(column="manage_info", property="manageInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="owner_id", property="ownerId", jdbcType=JdbcType.BIGINT),
        @Result(column="cabinet_id", property="cabinetId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR)
    })
    AssetHistory selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, asset_id, sn, number, type_id, asset_type_id, brand_id, model, info, power, ",
        "manage_info, remark, user_id, owner_id, cabinet_id, create_time, update_time, ",
        "start_time, expired_time, status, operation",
        "from asset_history"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="sn", property="sn", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="asset_type_id", property="assetTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="brand_id", property="brandId", jdbcType=JdbcType.BIGINT),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="power", property="power", jdbcType=JdbcType.BIGINT),
        @Result(column="manage_info", property="manageInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="owner_id", property="ownerId", jdbcType=JdbcType.BIGINT),
        @Result(column="cabinet_id", property="cabinetId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation", property="operation", jdbcType=JdbcType.VARCHAR)
    })
    List<AssetHistory> selectAll();

    @Update({
        "update asset_history",
        "set asset_id = #{assetId,jdbcType=BIGINT},",
          "sn = #{sn,jdbcType=VARCHAR},",
          "number = #{number,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "asset_type_id = #{assetTypeId,jdbcType=BIGINT},",
          "brand_id = #{brandId,jdbcType=BIGINT},",
          "model = #{model,jdbcType=VARCHAR},",
          "info = #{info,jdbcType=VARCHAR},",
          "power = #{power,jdbcType=BIGINT},",
          "manage_info = #{manageInfo,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "owner_id = #{ownerId,jdbcType=BIGINT},",
          "cabinet_id = #{cabinetId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "start_time = #{startTime,jdbcType=BIGINT},",
          "expired_time = #{expiredTime,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR},",
          "operation = #{operation,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AssetHistory record);
}