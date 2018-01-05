package xz.idao.provider;

import org.apache.ibatis.jdbc.SQL;
import xz.model.AssetUser;
import xz.util.WrapperFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static xz.util.LogKit.butlerLogger;


/**
 * Created by Jinhua on 2017/6/14 17:04.
 */
public class AdvanceSqlProvider {
	
	public String findBox(Map<String, Object> para) {
		String s = new SQL()
				.SELECT("asset.id asset_id")
				.SELECT("pool_cabinet.number,pool_cabinet.location,pool_cabinet.status ")
				.SELECT("pool_cabinet.id, pool_cabinet.create_time, pool_cabinet.update_time")
				.FROM("pool_cabinet")
				.LEFT_OUTER_JOIN("asset on asset.cabinet_id = pool_cabinet.id")
				.WHERE(String.format("pool_cabinet.%s = '%s'", para.get("k"), para.get("v")))
				.toString();
		butlerLogger.info(s.replace("\n",""));
		return s;
	}
	
	public String insertSomeUser(Map<String, AssetUser[]> map) throws IllegalAccessException {
		AssetUser[] users = map.get("array");
		if(users==null || users.length==0)
			return "select 0";
		SQL sql = new SQL()
				.INSERT_INTO("asset_user")
				.INTO_COLUMNS("id","name","account","password","authority","department",
						"create_time","update_time","status");
		StringBuilder sqlBf = new StringBuilder(sql.toString());
		//检查是否有空字段
		List<Field> fs = null;
		for (int i=0;i<users.length;i++) {
			AssetUser user = users[i];
			if(fs==null)
				fs = WrapperFactory.getFields(user);
			for (Field f : fs) {
				f.setAccessible(true);
				if(f.get(user)==null) {
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
					.append(user.getId()).append("','")
					.append(user.getName()).append("','")
					.append(user.getAccount()).append("','")
					.append(user.getPassword()).append("','")
					.append(user.getAuthority()).append("','")
					.append(user.getDepartment()).append("','")
					.append(user.getCreateTime()).append("','")
					.append(user.getUpdateTime()).append("','")
					.append(user.getStatus())
					.append("')");
		}
		return sqlBf.toString();
	}
}
