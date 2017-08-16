package xz.idao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import xz.idao.provider.AdvanceSqlProvider;
import xz.idao.provider.BaseSqlProvider;
import xz.model.PoolCabinet;
import xz.model.wrapper.BoxWrapper;

import java.util.List;

public interface BoxDao {
	@SelectProvider(type = BaseSqlProvider.class, method = "findBy")
	List<PoolCabinet> find(@Param("t") String table, @Param("k") String column, @Param("v") String value);
	
	@SelectProvider(type = AdvanceSqlProvider.class, method = "findBox")
	List<BoxWrapper> findBy(@Param("k") String column, @Param("v") String value);
	
	@Select({
			"select asset.id asset_id,",
			"ip.id, ip.number,ip.location, ip.create_time, ip.update_time, ip.status",
			"from pool_cabinet ip ",
			"left join asset on asset.cabinet_id = ip.id "
	})
	List<BoxWrapper> findAll();
	
	@Select({
			"select ",
			"id, number,  location, create_time, update_time, status",
			"from pool_cabinet ",
			"where id in (${ids})"
	})
	List<BoxWrapper> findInId(@Param("ids") String ids);
	
	@Update({
			"update pool_cabinet set",
			"status = #{status}",
			"where id in (${ids})"
	})
	int updateStatusInId(@Param("status") String status, @Param("ids") String ids);
}