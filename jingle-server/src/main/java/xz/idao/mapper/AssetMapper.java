package xz.idao.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.Asset;

import java.util.List;

public interface AssetMapper {
    @Delete({
        "delete from asset",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into asset (id, sn, number, ",
        "type, asset_type, ",
        "brand, model, info, ",
        "remark, user, owner, ",
        "cabinet_id, create_time, ",
        "update_time, status)",
        "values (#{id,jdbcType=BIGINT}, #{sn,jdbcType=VARCHAR}, #{number,jdbcType=BIGINT}, ",
        "#{type,jdbcType=VARCHAR}, #{assetType,jdbcType=VARCHAR}, ",
        "#{brand,jdbcType=VARCHAR}, #{model,jdbcType=VARCHAR}, #{info,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{user,jdbcType=VARCHAR}, #{owner,jdbcType=VARCHAR}, ",
        "#{cabinetId,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{status,jdbcType=VARCHAR})"
    })
    int insert(Asset record);

    @Select({
        "select",
        "id, sn, number, type, asset_type, brand, model, info, remark, user, owner, cabinet_id, ",
        "create_time, update_time, status",
        "from asset",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="sn", property="sn", jdbcType= JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType= JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType= JdbcType.VARCHAR),
        @Result(column="asset_type", property="assetType", jdbcType= JdbcType.VARCHAR),
        @Result(column="brand", property="brand", jdbcType= JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType= JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType= JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType= JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType= JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType= JdbcType.VARCHAR),
        @Result(column="cabinet_id", property="cabinetId", jdbcType= JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType= JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType= JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType= JdbcType.VARCHAR)
    })
    Asset selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, sn, number, type, asset_type, brand, model, info, remark, user, owner, cabinet_id, ",
        "create_time, update_time, status",
        "from asset"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="sn", property="sn", jdbcType= JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType= JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType= JdbcType.VARCHAR),
        @Result(column="asset_type", property="assetType", jdbcType= JdbcType.VARCHAR),
        @Result(column="brand", property="brand", jdbcType= JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType= JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType= JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType= JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType= JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType= JdbcType.VARCHAR),
        @Result(column="cabinet_id", property="cabinetId", jdbcType= JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType= JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType= JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType= JdbcType.VARCHAR)
    })
    List<Asset> selectAll();

    @Update({
        "update asset",
        "set sn = #{sn,jdbcType=VARCHAR},",
          "number = #{number,jdbcType=BIGINT},",
          "type = #{type,jdbcType=VARCHAR},",
          "asset_type = #{assetType,jdbcType=VARCHAR},",
          "brand = #{brand,jdbcType=VARCHAR},",
          "model = #{model,jdbcType=VARCHAR},",
          "info = #{info,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "user = #{user,jdbcType=VARCHAR},",
          "owner = #{owner,jdbcType=VARCHAR},",
          "cabinet_id = #{cabinetId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Asset record);
}