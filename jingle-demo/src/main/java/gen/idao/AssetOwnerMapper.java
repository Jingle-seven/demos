package gen.idao;

import gen.pojo.AssetOwner;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AssetOwnerMapper {
    @Delete({
        "delete from asset_owner",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into asset_owner (id, asset_number, ",
        "owner, acquire, ",
        "aquire_time, create_time, ",
        "update_time, status)",
        "values (#{id,jdbcType=BIGINT}, #{assetNumber,jdbcType=BIGINT}, ",
        "#{owner,jdbcType=VARCHAR}, #{acquire,jdbcType=VARCHAR}, ",
        "#{aquireTime,jdbcType=VARCHAR}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{status,jdbcType=VARCHAR})"
    })
    int insert(AssetOwner record);

    @Select({
        "select",
        "id, asset_number, owner, acquire, aquire_time, create_time, update_time, status",
        "from asset_owner",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="asset_number", property="assetNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="acquire", property="acquire", jdbcType=JdbcType.VARCHAR),
        @Result(column="aquire_time", property="aquireTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    AssetOwner selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, asset_number, owner, acquire, aquire_time, create_time, update_time, status",
        "from asset_owner"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="asset_number", property="assetNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="acquire", property="acquire", jdbcType=JdbcType.VARCHAR),
        @Result(column="aquire_time", property="aquireTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<AssetOwner> selectAll();

    @Update({
        "update asset_owner",
        "set asset_number = #{assetNumber,jdbcType=BIGINT},",
          "owner = #{owner,jdbcType=VARCHAR},",
          "acquire = #{acquire,jdbcType=VARCHAR},",
          "aquire_time = #{aquireTime,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AssetOwner record);
}