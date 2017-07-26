package gen.idao;

import gen.pojo.ItemType;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ItemTypeMapper {
    @Delete({
        "delete from item_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into item_type (id, number, ",
        "table_name, item_name, ",
        "title, comment, ",
        "status)",
        "values (#{id,jdbcType=BIGINT}, #{number,jdbcType=BIGINT}, ",
        "#{tableName,jdbcType=VARCHAR}, #{itemName,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{comment,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(ItemType record);

    @Select({
        "select",
        "id, number, table_name, item_name, title, comment, status",
        "from item_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_name", property="itemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    ItemType selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, number, table_name, item_name, title, comment, status",
        "from item_type"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_name", property="itemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<ItemType> selectAll();

    @Update({
        "update item_type",
        "set number = #{number,jdbcType=BIGINT},",
          "table_name = #{tableName,jdbcType=VARCHAR},",
          "item_name = #{itemName,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemType record);
}