package xz.idao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import xz.idao.provider.BaseSqlProvider;
import xz.model.PoolCabinet;

import java.util.List;

public interface BoxDao {
	@SelectProvider(type = BaseSqlProvider.class, method = "find")
	List<PoolCabinet> find(@Param("t") String table, @Param("k") String column, @Param("v") String value);
	
}