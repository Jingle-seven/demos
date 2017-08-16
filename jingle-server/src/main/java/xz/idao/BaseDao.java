package xz.idao;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import xz.idao.provider.BaseSqlProvider;

import java.util.List;
import java.util.Map;

public interface BaseDao {
	
	@SelectProvider(type = BaseSqlProvider.class, method = "findBy")
	List<Map<String,Object>> findBy(@Param("t") String table, @Param("k") String column, @Param("v") String value);
	
	@SelectProvider(type = BaseSqlProvider.class,method = "findIn")
	List<Map<String,Object>> findInId(@Param("t") String table, @Param("k") String key, @Param("v") String value);
	
	@DeleteProvider(type = BaseSqlProvider.class, method = "removeIn")
	int removeIn(@Param("t") String table, @Param("k") String column, @Param("v") String value);
	
	@UpdateProvider(type = BaseSqlProvider.class, method = "updateInId")
	int updateInId(@Param("t") String table, @Param("k") String column, @Param("v") String value, @Param("ids") String ids);
	
	@UpdateProvider(type = BaseSqlProvider.class, method = "update")
	int update(@Param("t") String table, @Param("k") String column, @Param("v") String value,
               @Param("ok") String oldKey, @Param("ov") String oldValue);
}