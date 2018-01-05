package xz.idao.provider;

import org.apache.ibatis.jdbc.SQL;
import xz.model.DeviceQuery;
import xz.model.wrapper.AssetWrapper;
import xz.util.WrapperFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static xz.util.LogKit.butlerLogger;
import static xz.util.XKit.isNotEmpty;


/**
 * Created by Jinhua on 2017/6/14 17:04.
 */
public class DeviceSqlProvider {
	
	
	public static final String TABLE_NAME = "asset";
	
	public String find(Map<String, Object> para) {
		String s = new SQL()
				.SELECT("asset.id, type_id, asset_type_id,owner_id, asset.cabinet_id,asset.user_id,is_expired")
				.SELECT("sn, brand_id, model, info, manage_info, asset.remark, asset.number, power")
				.SELECT("start_time, expired_time,asset.create_time, asset.update_time, asset.status")
				.SELECT("item1.status type,item2.status asset_type,item3.status brand ,item4.status status_str")
				.SELECT("user1.name user,user2.name owner")
				.SELECT("pool_cabinet.location")
				.FROM("asset")
				.LEFT_OUTER_JOIN("item_type item1 on item1.number=asset.type_id and item1.title='asset_type'")
				.LEFT_OUTER_JOIN("item_type item2 on item2.number=asset.asset_type_id and item2.title='asset_asset_type'")
				.LEFT_OUTER_JOIN("item_type item3 on item3.number=asset.brand_id and item3.title='asset_brand'")
				.LEFT_OUTER_JOIN("item_type item4 on item4.number=asset.status and item4.title='asset_status'")
				.LEFT_OUTER_JOIN("asset_user user1 on user1.id=asset.user_id")
				.LEFT_OUTER_JOIN("asset_user user2 on user2.id=asset.owner_id")
				.LEFT_OUTER_JOIN("pool_cabinet on pool_cabinet.id=asset.cabinet_id")
				.WHERE(String.format("asset.%s = '%s'", para.get("k"), para.get("v")))
				.toString();
		butlerLogger.fine(s.replace("\n", ""));
		return s;
	}
	
	public String query(DeviceQuery query) {
		SQL sql = new SQL()
				.SELECT("asset.id, type_id, asset_type_id,owner_id, asset.cabinet_id,asset.user_id,is_expired")
				.SELECT("sn, brand_id, model, info, manage_info, asset.remark, asset.number, power")
				.SELECT("start_time, expired_time,asset.create_time, asset.update_time, asset.status")
				.SELECT("item1.status type,item2.status asset_type,item3.status brand ,item4.status status_str")
				.SELECT("user1.name user,user2.name owner")
				.SELECT("pool_cabinet.location")
				.FROM("asset")
				.LEFT_OUTER_JOIN("item_type item1 on item1.number=asset.type_id and item1.title='asset_type'")
				.LEFT_OUTER_JOIN("item_type item2 on item2.number=asset.asset_type_id and item2.title='asset_asset_type'")
				.LEFT_OUTER_JOIN("item_type item3 on item3.number=asset.brand_id and item3.title='asset_brand'")
				.LEFT_OUTER_JOIN("item_type item4 on item4.number=asset.status and item4.title='asset_status'")
				.LEFT_OUTER_JOIN("asset_user user1 on user1.id=asset.user_id")
				.LEFT_OUTER_JOIN("asset_user user2 on user2.id=asset.owner_id")
				.LEFT_OUTER_JOIN("pool_cabinet on pool_cabinet.id=asset.cabinet_id")
				;
		
		if (query.getId() != null)
			sql.WHERE(String.format("asset.id = '%s'", query.getId()));
		if (query.getSn() != null)
			sql.WHERE(String.format("asset.sn = '%s'", query.getSn()));
		if (query.getNumber() != null)
			sql.WHERE(String.format("asset.number = '%s'", query.getNumber()));
		if (query.getExpiredTime() != null)
			sql.WHERE(String.format("asset.expired_time < '%s' and is_expired != 1", query.getExpiredTime()));
		if (isNotEmpty(query.getOwner()))
			sql.WHERE(String.format("asset.owner_id = '%s'", query.getOwner()));
		if (isNotEmpty(query.getUser()))
			sql.WHERE(String.format("asset.user_id = '%s'", query.getUser()));
		if (isNotEmpty(query.getType()))
			sql.WHERE(String.format("asset.type_id = '%s'", query.getType()));
		if (isNotEmpty(query.getStatus()))
			sql.WHERE(String.format("asset.status = '%s'", query.getStatus()));
		if (isNotEmpty(query.getAssetType()))
			sql.WHERE(String.format("asset.asset_type_id = '%s'", query.getAssetType()));
		if (isNotEmpty(query.getCabinetId()))
			sql.WHERE(String.format("asset.cabinet_id = '%s'", query.getCabinetId()));
		butlerLogger.fine(sql.toString().replace("\n", ""));
		return sql.toString();
	}
	public String insertSome(Map<String, List<AssetWrapper>> map) throws IllegalAccessException {
		List<AssetWrapper> ass = map.get("list");
		if(ass==null || ass.isEmpty())
			return "select 0";
		SQL sql = new SQL()
				.INSERT_INTO(TABLE_NAME)
				.INTO_COLUMNS("id", "sn", "type_id","asset_type_id", "status", "owner_id", "cabinet_id", "user_id", "brand_id", "model"
						, "info", "remark", "create_time", "update_time, number, manage_info, power, start_time, expired_time, is_expired");
		StringBuilder sqlBf = new StringBuilder(sql.toString());
		//检查是否有空字段
		List<Field> fs = null;
		for (int i=0;i<ass.size();i++) {
			AssetWrapper as = ass.get(i);
			if(fs==null)
				fs = WrapperFactory.getSuperFields(as);
			for (Field f : fs) {
				f.setAccessible(true);
				if(f.get(as)==null) {
					throw new NullPointerException(" Column '"+ f.getName()+"' cannot be null");
				}
			}
			//values 插入多条记录时,记录之间要加逗号
			if(i==0) {
				sqlBf.append(" VALUES ");
			}else {
				sqlBf.append(",");
			}
			
			sqlBf.append("('")
					.append(as.getId()).append("','")
					.append(as.getSn()).append("','")
					.append(as.getTypeId()).append("','")
					.append(as.getAssetTypeId()).append("','")
					.append(as.getStatus()).append("','")
					.append(as.getOwnerId()).append("','")
					.append(as.getCabinetId()).append("','")
					.append(as.getUserId()).append("','")
					.append(as.getBrandId()).append("','")
					.append(as.getModel()).append("','")
					.append(as.getInfo()).append("','")
					.append(as.getRemark()).append("','")
					.append(as.getCreateTime()).append("','")
					.append(as.getUpdateTime()).append("','")
					.append(as.getNumber()).append("','")
					.append(as.getManageInfo()).append("','")
					.append(as.getPower()).append("','")
					.append(as.getStartTime()).append("','")
					.append(as.getExpiredTime()).append("','")
					.append(as.getIsExpired())
					.append("')");
		}
		return sqlBf.toString();
	}
	
	public String updateBoxIdIn(Map<String, Object> para) {
		SQL sql = new SQL()
				.UPDATE(TABLE_NAME)
				.SET(String.format("cabinet_id = %s",para.get("v")))
				.WHERE(String.format("cabinet_id in (%s)", para.get("ids")));
		return sql.toString();
	}
}
