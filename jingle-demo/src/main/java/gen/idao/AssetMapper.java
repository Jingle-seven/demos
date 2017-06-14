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
        "insert into asset (id, sn, type, ",
        "brand, model, info, ",
        "remark, create_time, ",
        "update_time, status)",
        "values (#{id,jdbcType=BIGINT}, #{sn,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{brand,jdbcType=VARCHAR}, #{model,jdbcType=VARCHAR}, #{info,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{status,jdbcType=VARCHAR})"
    })
    int insert(Asset record);

    @Select({
        "select",
        "id, sn, type, brand, model, info, remark, create_time, update_time, status",
        "from asset",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="sn", property="sn", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    Asset selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, sn, type, brand, model, info, remark, create_time, update_time, status",
        "from asset"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="sn", property="sn", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<Asset> selectAll();

    @Update({
        "update asset",
        "set sn = #{sn,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "brand = #{brand,jdbcType=VARCHAR},",
          "model = #{model,jdbcType=VARCHAR},",
          "info = #{info,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Asset record);
}