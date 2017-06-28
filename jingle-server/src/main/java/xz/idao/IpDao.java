package xz.idao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.idao.provider.IpSqlProvider;
import xz.model.PoolNetwork;

import java.util.List;

public interface IpDao {
	
	@Select({
			"select",
			"id, ip, owner, purpose, asset_id, cabinet_id, expired_time, create_time, update_time, ",
			"status",
			"from pool_network",
			"where ip like #{ip}"
	})
	List<PoolNetwork> likeIp(String ip);
	
	@Select({
			"select",
			"id, ip, owner, purpose, asset_id, expired_time, create_time, update_time, ",
			"status",
			"from pool_network",
			"where ip = #{ip}"
	})
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "ip", property = "ip", jdbcType = JdbcType.VARCHAR),
			@Result(column = "owner", property = "owner", jdbcType = JdbcType.VARCHAR),
			@Result(column = "purpose", property = "purpose", jdbcType = JdbcType.VARCHAR),
			@Result(column = "asset_id", property = "assetId", jdbcType = JdbcType.BIGINT),
			@Result(column = "expired_time", property = "expiredTime", jdbcType = JdbcType.BIGINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
			@Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR)
	})
	PoolNetwork findByIp(String ip);
	
	@Select({
			"select",
			"id, ip, owner, purpose, asset_id, expired_time, create_time, update_time, ",
			"status",
			"from pool_network",
			"where asset_id = #{id}"
	})
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "ip", property = "ip", jdbcType = JdbcType.VARCHAR),
			@Result(column = "owner", property = "owner", jdbcType = JdbcType.VARCHAR),
			@Result(column = "purpose", property = "purpose", jdbcType = JdbcType.VARCHAR),
			@Result(column = "asset_id", property = "assetId", jdbcType = JdbcType.BIGINT),
			@Result(column = "expired_time", property = "expiredTime", jdbcType = JdbcType.BIGINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
			@Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR)
	})
	List<PoolNetwork> findByAssetId(Long id);
	
	@SelectProvider(type = IpSqlProvider.class, method = "find")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "ip", property = "ip", jdbcType = JdbcType.VARCHAR),
			@Result(column = "owner", property = "owner", jdbcType = JdbcType.VARCHAR),
			@Result(column = "purpose", property = "purpose", jdbcType = JdbcType.VARCHAR),
			@Result(column = "asset_id", property = "assetId", jdbcType = JdbcType.BIGINT),
			@Result(column = "expired_time", property = "expiredTime", jdbcType = JdbcType.BIGINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
			@Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR)
	})
	List<PoolNetwork> findBy(@Param("k") String column, @Param("v") String value);
	
}