package xz.idao;

import org.apache.ibatis.annotations.*;
import xz.idao.provider.DeviceSqlProvider;
import xz.model.AssetWrapper;
import xz.model.DeviceQuery;

import java.util.List;

public interface DeviceDao {
    
    //初步试验证明列不能自己绑定参数,必须写死
    @Deprecated
    @Select({"select",
            "id, sn, number,type, asset_type, brand, user,model, info, remark, create_time, update_time, status",
            "from asset ",
            "where #{col} = #{val}"})
    List<AssetWrapper> selectSome(@Param("col") String column, @Param("val") String value);

    //使用Provider,可以自己绑定
    @SelectProvider(type = DeviceSqlProvider.class, method = "find")
    List<AssetWrapper> select(@Param("k") String column, @Param("v") String value);

    @SelectProvider(type = DeviceSqlProvider.class, method = "query")
    List<AssetWrapper> query(DeviceQuery value);

    @InsertProvider(type = DeviceSqlProvider.class, method = "insertSome")
    int insertSome(List<AssetWrapper> ass);

    @Select({"select",
            "id, sn, number,type, asset_type, brand, user,model, info, remark, create_time, update_time, status",
            "from asset ",
            "where id in ${ids}"})
    List<AssetWrapper> findIdIn(@Param("ids") String ids);

    @Delete({
            "delete from asset",
            "where id in (${ids})"
    })
    int removeIn(@Param("ids") String ids);
}