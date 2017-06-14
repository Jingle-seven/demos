package gen.idao;

import gen.pojo.PoolNetwork;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface PoolNetworkMapper {
    @Delete({
        "delete from pool_network",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pool_network (id, ip, owner, ",
        "purpose, asset_id, ",
        "cabinet_id, expired_time, ",
        "create_time, update_time, ",
        "status)",
        "values (#{id,jdbcType=BIGINT}, #{ip,jdbcType=VARCHAR}, #{owner,jdbcType=VARCHAR}, ",
        "#{purpose,jdbcType=VARCHAR}, #{assetId,jdbcType=BIGINT}, ",
        "#{cabinetId,jdbcType=BIGINT}, #{expiredTime,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=BIGINT}, #{updateTime,jdbcType=BIGINT}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(PoolNetwork record);

    @Select({
        "select",
        "id, ip, owner, purpose, asset_id, cabinet_id, expired_time, create_time, update_time, ",
        "status",
        "from pool_network",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="purpose", property="purpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="cabinet_id", property="cabinetId", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    PoolNetwork selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, ip, owner, purpose, asset_id, cabinet_id, expired_time, create_time, update_time, ",
        "status",
        "from pool_network"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="purpose", property="purpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="asset_id", property="assetId", jdbcType=JdbcType.BIGINT),
        @Result(column="cabinet_id", property="cabinetId", jdbcType=JdbcType.BIGINT),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<PoolNetwork> selectAll();

    @Update({
        "update pool_network",
        "set ip = #{ip,jdbcType=VARCHAR},",
          "owner = #{owner,jdbcType=VARCHAR},",
          "purpose = #{purpose,jdbcType=VARCHAR},",
          "asset_id = #{assetId,jdbcType=BIGINT},",
          "cabinet_id = #{cabinetId,jdbcType=BIGINT},",
          "expired_time = #{expiredTime,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PoolNetwork record);
}