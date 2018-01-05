package xz.idao.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.ItemType;

import java.util.List;

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
        "status, deletable)",
        "values (#{id,jdbcType=BIGINT}, #{number,jdbcType=BIGINT}, ",
        "#{tableName,jdbcType=VARCHAR}, #{itemName,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{comment,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{deletable,jdbcType=TINYINT})"
    })
    int insert(ItemType record);

    @Select({
        "select",
        "id, number, table_name, item_name, title, comment, status, deletable",
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
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="deletable", property="deletable", jdbcType=JdbcType.TINYINT)
    })
    ItemType selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, number, table_name, item_name, title, comment, status, deletable",
        "from item_type"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_name", property="itemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="deletable", property="deletable", jdbcType=JdbcType.TINYINT)
    })
    List<ItemType> selectAll();

    @Update({
        "update item_type",
        "set number = #{number,jdbcType=BIGINT},",
          "table_name = #{tableName,jdbcType=VARCHAR},",
          "item_name = #{itemName,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "deletable = #{deletable,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemType record);
}