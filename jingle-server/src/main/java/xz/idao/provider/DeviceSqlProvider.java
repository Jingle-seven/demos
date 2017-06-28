package xz.idao.provider;

import org.apache.ibatis.jdbc.SQL;
import xz.model.AssetWrapper;
import xz.model.DeviceQuery;

import java.util.List;
import java.util.Map;

import static xz.util.LogKit.xLogger;
import static xz.util.XKit.isNotEmpty;


/**
 * Created by Jinhua on 2017/6/14 17:04.
 */
public class DeviceSqlProvider {
	
	
	public String find(Map<String, Object> para) {
		String s = new SQL()
				.SELECT("id, type, asset_type,create_time, update_time, status,owner,cabinet_id,user")
				.SELECT("sn, brand, model, info, remark, number ")
				.FROM("asset A")
				.WHERE(String.format("%s = '%s'", para.get("k"), para.get("v")))
				.toString();
		xLogger.info(s.replace("\n", ""));
		return s;
	}
	
	public String query(DeviceQuery query) {
		SQL sql = new SQL()
				.SELECT("id, type,asset_type,create_time, update_time, status,owner,cabinet_id,user")
				.SELECT("sn, brand, model, info, remark, number ")
				.FROM("asset A");
		if (query.getId() != null)
			sql.WHERE(String.format("id = '%s'", query.getId()));
		if (query.getSn() != null)
			sql.WHERE(String.format("sn = '%s'", query.getSn()));
		if (query.getNumber() != null)
			sql.WHERE(String.format("number = '%s'", query.getNumber()));
		if (isNotEmpty(query.getOwner()))
			sql.WHERE(String.format("owner = '%s'", query.getOwner()));
		if (isNotEmpty(query.getType()))
			sql.WHERE(String.format("type = '%s'", query.getType()));
		xLogger.info(sql.toString().replace("\n", ""));
		return sql.toString();
	}
	public String insertSome(Map<String, List<AssetWrapper>> map) {
		List<AssetWrapper> ass = map.get("list");
		if(ass==null || ass.isEmpty())
			return "select 0";
		SQL sql = new SQL()
				.INSERT_INTO("asset")
				.INTO_COLUMNS("id", "sn", "type","asset_type", "status", "owner", "cabinet_id", "user", "brand", "model"
						, "info", "remark", "create_time", "update_time, number");
		StringBuilder sqlBf = new StringBuilder(sql.toString());
		
		for (int i=0;i<ass.size();i++) {
			AssetWrapper as = ass.get(i);
			//values 插入多条记录时,记录之间要加逗号
			if(i==0) {
				sqlBf.append(" VALUES ");
			}else {
				sqlBf.append(",");
				
			}
			sqlBf.append("('")
					.append(as.getId()).append("','")
					.append(as.getSn()).append("','")
					.append(as.getType()).append("','")
					.append(as.getAssetType()).append("','")
					.append(as.getStatus()).append("','")
					.append(as.getOwner()).append("','")
					.append(as.getCabinetId()==null?0:as.getCabinetId()).append("','")
					.append(as.getUser()).append("','")
					.append(as.getBrand()).append("','")
					.append(as.getModel()).append("','")
					.append(as.getInfo()).append("','")
					.append(as.getRemark()).append("','")
					.append(as.getCreateTime()).append("','")
					.append(as.getUpdateTime()).append("','")
					.append(as.getNumber())
					.append("')");
		}
		return sqlBf.toString();
	}
	
}
