package xz.idao;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xz.idao.provider.AdvanceSqlProvider;
import xz.idao.provider.BaseSqlProvider;
import xz.model.AssetUser;
import xz.model.wrapper.UserWrapper;

import java.util.List;

public interface UserDao {
    
    @Select({
            "select",
            "id, name, account, password, authority, department, create_time, update_time, ",
            "status",
            "from asset_user",
            "where account = #{str}"
    })
    AssetUser selectByAccount(String str);
    
    @Select({
            "select",
            "id, name, account, password, authority, department, create_time, update_time, ",
            "status",
            "from asset_user",
            "where name like #{str}"
    })
    List<UserWrapper> selectLikeName(String str);
    
    @Select({
            "select",
            "id, name, account, password, authority, department, create_time, update_time, ",
            "status",
            "from asset_user",
            "where id in (${ids})"
    })
    List<AssetUser> selectIdIn(@Param("ids") String ids);
    
    @Select({
            "select",
            "id, name, account, password, authority, department, create_time, update_time, ",
            "status",
            "from asset_user"
    })
    List<UserWrapper> selectAll();
    
    @InsertProvider(type = AdvanceSqlProvider.class, method = "insertSomeUser")
    int insertSome(AssetUser... users);

    @DeleteProvider(type = BaseSqlProvider.class,method ="removeIn")
    int removeInId(String ids);
}