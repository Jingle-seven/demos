package xz.idao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import xz.model.ItemType;

import java.util.List;

public interface StatusDao {

    @Select({
        "select",
        "id, table_name, item_name, title, comment, status",
        "from item_type",
        "where title = #{key}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="table_name", property="tableName", jdbcType= JdbcType.VARCHAR),
        @Result(column="item_name", property="itemName", jdbcType= JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType= JdbcType.VARCHAR),
        @Result(column="comment", property="comment", jdbcType= JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType= JdbcType.VARCHAR)
    })
    List<ItemType> findByTitle(String key);
    
    @Select({
            "select",
            "id, table_name, item_name, title, comment, status",
            "from item_type",
            "where table_name = #{tbName} and item_name = #{itName}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="table_name", property="tableName", jdbcType= JdbcType.VARCHAR),
            @Result(column="item_name", property="itemName", jdbcType= JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType= JdbcType.VARCHAR),
            @Result(column="comment", property="comment", jdbcType= JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType= JdbcType.VARCHAR)
    })
    List<ItemType> findByTableItem(@Param("tbName") String tbName, @Param("itName") String itName);
}