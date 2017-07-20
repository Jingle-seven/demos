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
        "insert into asset_history (id, sn, number, ",
        "type, asset_type, ",
        "brand, model, info, ",
        "remark, user, owner, ",
        "cabinet_id, create_time, ",
        "update_time, status)",
        "values (#{id,jdbcType=BIGINT}, #{sn,jdbcType=VARCHAR}, #{number,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{assetType,jdbcType=VARCHAR}, ",
        "#{brand,jdbcType=VARCHAR}, #{model,jdbcType=VARCHAR}, #{info,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{user,jdbcType=VARCHAR}, #{owner,jdbcType=VARCHAR}, ",
        "#{cabinetId,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{status,jdbcType=VARCHAR})"
    })
    int insert(AssetHistory record);

    @Select({
        "select",
        "id, sn, number, type, asset_type, brand, model, info, remark, user, owner, cabinet_id, ",
        "create_time, update_time, status",
        "from asset_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="sn", property="sn", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_type", property="assetType", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="cabinet_id", property="cabinetId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    AssetHistory selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, sn, number, type, asset_type, brand, model, info, remark, user, owner, cabinet_id, ",
        "create_time, update_time, status",
        "from asset_history"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="sn", property="sn", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_type", property="assetType", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="cabinet_id", property="cabinetId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<AssetHistory> selectAll();

    @Update({
        "update asset_history",
        "set sn = #{sn,jdbcType=VARCHAR},",
          "number = #{number,jdbcType=VARCHAR},",
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
    int updateByPrimaryKey(AssetHistory record);
}