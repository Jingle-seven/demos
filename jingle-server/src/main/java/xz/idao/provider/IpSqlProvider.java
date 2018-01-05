package xz.idao.provider;

import org.apache.ibatis.jdbc.SQL;
import xz.model.wrapper.IpWrapper;

import java.util.Map;

import static xz.util.LogKit.butlerLogger;
import static xz.util.XKit.isNotEmpty;


/**
 * Created by Jinhua on 2017/6/14 17:04.
 */
public class IpSqlProvider {
	
	
	public String findBy(Map<String, Object> para) {
		String s = new SQL()
				.SELECT("pool_network.id, pool_network.ip, pool_network.asset_id, pool_network.user_id,pool_network.is_expired")
				.SELECT("pool_network.start_time, pool_network.expired_time, pool_network.create_time, pool_network.update_time")
				.SELECT("pool_network.status")
				.SELECT("asset_user.name user")
				.FROM("pool_network left join asset_user on pool_network.user_id = asset_user.id")
				.WHERE(String.format("pool_network.%s = '%s'", para.get("k"), para.get("v")))
				.toString();
		butlerLogger.info(s.replace("\n",""));
		return s;
	}
	public String query(IpWrapper query) {
		SQL sql = new SQL()
				.SELECT("pool_network.id, pool_network.ip, pool_network.asset_id, pool_network.user_id,pool_network.is_expired")
				.SELECT("pool_network.start_time, pool_network.expired_time, pool_network.create_time, pool_network.update_time")
				.SELECT("pool_network.status")
				.SELECT("asset_user.name user")
				.FROM("pool_network")
				.LEFT_OUTER_JOIN("asset_user on pool_network.user_id = asset_user.id");
		
		if (query.getUser()!=null)
			sql.WHERE(String.format("asset_user.name like '%%%s%%'", query.getUser()));
		if(query.getUserId()!=null)
			sql.WHERE(String.format("pool_network.user_id = '%s'", query.getUserId()));
		if (query.getExpiredTime() != null)
			sql.WHERE(String.format("pool_network.expired_time < '%s' and is_expired != 1", query.getExpiredTime()));
		if(isNotEmpty(query.getStatus()))
			sql.WHERE(String.format("pool_network.status = '%s'", query.getStatus()));
		if(isNotEmpty(query.getIp()))
			sql.WHERE(String.format("pool_network.ip = '%s'", query.getIp()));
		return sql.toString();
	}
}
