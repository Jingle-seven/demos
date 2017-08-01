package gen.idao;

import gen.pojo.Asset;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AssetMapper {
    @Delete({
        "delete from asset",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into asset (id, sn, number, ",
        "type_id, asset_type_id, ",
        "brand_id, model, info, ",
        "power, manage_info, ",
        "remark, user_id, owner_id, ",
        "cabinet_id, create_time, ",
        "update_time, start_time, ",
        "expire_time, is_expired, ",
        "status)",
        "values (#{id,jdbcType=BIGINT}, #{sn,jdbcType=VARCHAR}, #{number,jdbcType=VARCHAR}, ",
        "#{typeId,jdbcType=BIGINT}, #{assetTypeId,jdbcType=BIGINT}, ",
        "#{brandId,jdbcType=BIGINT}, #{model,jdbcType=VARCHAR}, #{info,jdbcType=VARCHAR}, ",
        "#{power,jdbcType=BIGINT}, #{manageInfo,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{userId,jdbcType=BIGINT}, #{ownerId,jdbcType=BIGINT}, ",
        "#{cabinetId,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{startTime,jdbcType=BIGINT}, ",
        "#{expireTime,jdbcType=BIGINT}, #{isExpired,jdbcType=TINYINT}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(Asset record);

    @Select({
        "select",
        "id, sn, number, type_id, asset_type_id, brand_id, model, info, power, manage_info, ",
        "remark, user_id, owner_id, cabinet_id, create_time, update_time, start_time, ",
        "expire_time, is_expired, status",
        "from asset",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.BIGINT),
        @Result(column="is_expired", property="isExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    Asset selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, sn, number, type_id, asset_type_id, brand_id, model, info, power, manage_info, ",
        "remark, user_id, owner_id, cabinet_id, create_time, update_time, start_time, ",
        "expire_time, is_expired, status",
        "from asset"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.BIGINT),
        @Result(column="is_expired", property="isExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<Asset> selectAll();

    @Update({
        "update asset",
        "set sn = #{sn,jdbcType=VARCHAR},",
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
          "expire_time = #{expireTime,jdbcType=BIGINT},",
          "is_expired = #{isExpired,jdbcType=TINYINT},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Asset record);
}