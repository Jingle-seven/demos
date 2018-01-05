package xz.idao;

import org.apache.ibatis.annotations.*;
import xz.idao.provider.DeviceSqlProvider;
import xz.model.DeviceQuery;
import xz.model.wrapper.AssetHistWrapper;
import xz.model.wrapper.AssetWrapper;

import java.util.List;

public interface DeviceDao {
    
    //初步试验证明列不能自己绑定参数,必须写死
    //使用Provider,可以自己绑定列名
    @SelectProvider(type = DeviceSqlProvider.class, method = "find")
    List<AssetWrapper> select(@Param("k") String column, @Param("v") String value);
    
    @SelectProvider(type = DeviceSqlProvider.class, method = "query")
    List<AssetWrapper> query(DeviceQuery value);
    
    @Select({"select",
            "asset.id, type_id, asset_type_id,owner_id, asset.cabinet_id,asset.user_id, is_expired, ",
            "sn, brand_id, model, info, manage_info, asset.remark, asset.number, power, ",
            "start_time, expired_time,asset.create_time, asset.update_time, asset.status, ",
            "item1.status type,item2.status asset_type,item3.status brand, item4.status status_str,",
            "user1.name user,user2.name owner, ",
            "pool_cabinet.location",
            "from asset ",
            "left join item_type item1 on item1.number=asset.type_id and item1.title='asset_type'",
            "left join item_type item2 on item2.number=asset.asset_type_id and item2.title='asset_asset_type'",
            "left join item_type item3 on item3.number=asset.brand_id and item3.title='asset_brand'",
            "left join item_type item4 on item4.number=asset.status and item4.title='asset_status'",
            "left join asset_user user1 on user1.id=asset.user_id",
            "left join asset_user user2 on user2.id=asset.owner_id",
            "left join pool_cabinet on pool_cabinet.id=asset.cabinet_id",
            "where asset.id in (${ids})"})
    List<AssetWrapper> findIdIn(@Param("ids") String ids);
    
    @Select({"select",
            "asset_history.id, type_id, asset_type_id,owner_id, cabinet_id,user_id, asset_id,operation,",
            "sn, brand_id, model, info, manage_info, asset_history.remark, asset_history.number, power, ",
            "start_time, expired_time,asset_history.create_time, asset_history.update_time, asset_history.status, ",
            "item1.status type,item2.status asset_type,item3.status brand, item4.status status_str,",
            "user1.name user,user2.name owner, ",
            "pool_cabinet.location",
            "from asset_history ",
            "left join item_type item1 on item1.number=asset_history.type_id and item1.title='asset_type'",
            "left join item_type item2 on item2.number=asset_history.asset_type_id and item2.title='asset_asset_type'",
            "left join item_type item3 on item3.number=asset_history.brand_id and item3.title='asset_brand'",
            "left join item_type item4 on item4.number=asset_history.status and item4.title='asset_status'",
            "left join asset_user user1 on user1.id=asset_history.user_id",
            "left join asset_user user2 on user2.id=asset_history.owner_id",
            "left join pool_cabinet on pool_cabinet.id=asset_history.cabinet_id",
            "order by asset_history.update_time desc"})
    List<AssetHistWrapper> findAllAssetHistory();
    
    @InsertProvider(type = DeviceSqlProvider.class, method = "insertSome")
    int insertSome(List<AssetWrapper> ass);
    
    @Delete({
            "delete from asset",
            "where id in (${ids})"
    })
    int removeIn(@Param("ids") String ids);
    
    @UpdateProvider(type=DeviceSqlProvider.class,method = "updateBoxIdIn")
    int updateCabinetId(@Param("v") Long value, @Param("ids") String ids);
    
    @Update({
            "update asset",
            "set user = #{v}",
            "where user in ${names}"
    })
    int updateUser(@Param("v") String value, @Param("names") String names);
    @Update({
            "update asset",
            "set owner = #{v}",
            "where owner in ${names}"
    })
    int updateOwner(@Param("v") String value, @Param("names") String names);
}