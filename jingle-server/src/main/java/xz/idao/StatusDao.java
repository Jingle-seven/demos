package xz.idao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import xz.idao.provider.BaseSqlProvider;
import xz.model.ItemType;

import java.util.List;

public interface StatusDao {

    @Select({
        "select",
        "id, table_name, item_name, title, comment, status, number, deletable",
        "from item_type",
        "where title = #{key}"
    })
    List<ItemType> findByTitle(String key);
    
    @Select({
            "select",
            "id, table_name, item_name, title, comment, status, number, deletable",
            "from item_type",
            "where table_name = #{tbName} and item_name = #{itName}"
    })
    List<ItemType> findByTableItem(@Param("tbName") String tbName, @Param("itName") String itName);
    
    @SelectProvider(type = BaseSqlProvider.class,method = "findIn")
    List<ItemType> findIn(@Param("t") String table, @Param("k") String key, @Param("v") String value);
    
}