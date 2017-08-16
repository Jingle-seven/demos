package xz.idao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import xz.idao.provider.IpSqlProvider;
import xz.model.wrapper.IpHistWrapper;
import xz.model.wrapper.IpWrapper;

import java.util.List;

public interface IpDao {
	
	@Select({
			"select",
			"ip_history.id, ip_id, ip_history.ip, ip_history.asset_id, ip_history.user_id, ip_history.is_expired, operation,",
			"ip_history.create_time, ip_history.update_time, ip_history.start_time, ip_history.expired_time, ip_history.status, ",
			"asset_user.name user",
			"from ip_history left join asset_user on ip_history.user_id = asset_user.id",
	})
	List<IpHistWrapper> findAllIpHistory();
	
	@Select({
			"select",
			"pool_network.id, pool_network.ip, pool_network.asset_id, pool_network.user_id, pool_network.is_expired, ",
			"pool_network.create_time, pool_network.update_time, pool_network.start_time, pool_network.expired_time, pool_network.status, ",
			"asset_user.name user",
			"from pool_network left join asset_user on pool_network.user_id = asset_user.id",
	})
	List<IpWrapper> findAll();
	
	@Select({
			"select",
			"pool_network.id, pool_network.ip, pool_network.asset_id, pool_network.user_id, pool_network.is_expired, ",
			"pool_network.create_time, pool_network.update_time, pool_network.start_time, pool_network.expired_time, pool_network.status, ",
			"asset_user.name user",
			"from pool_network left join asset_user on pool_network.user_id = asset_user.id",
			"where ip like '%${ip}%' "
	})
	List<IpWrapper> likeIp(@Param("ip") String ip);
	
	@Select({
			"select",
			"pool_network.id, pool_network.ip, pool_network.asset_id, pool_network.user_id, pool_network.is_expired, ",
			"pool_network.create_time, pool_network.update_time, pool_network.start_time, pool_network.expired_time, pool_network.status, ",
			"asset_user.name user",
			"from pool_network left join asset_user on pool_network.user_id = asset_user.id",
			"where ip = #{ip}"
	})
	IpWrapper findByIp(String ip);
	
	@Select({
			"select",
			"id, ip, asset_id, user_id,  is_expired, status",
			"start_time, expired_time, create_time, update_time",
			"from pool_network",
			"where asset_id = #{id}"
	})
	List<IpWrapper> findByAssetId(Long id);
	
	
	@SelectProvider(type = IpSqlProvider.class, method = "findBy")
	List<IpWrapper> findBy(@Param("k") String column, @Param("v") String value);
	
	@SelectProvider(type = IpSqlProvider.class, method = "query")
	List<IpWrapper> query(IpWrapper query);
}