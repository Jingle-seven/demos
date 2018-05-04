package xz.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.Book;

import java.util.List;

public interface BookMapper {
    @Delete({
        "delete from book",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into book (id, order_id, ",
        "name, time, remark, ",
        "user_id, user_name)",
        "values (#{id,jdbcType=CHAR}, #{orderId,jdbcType=SMALLINT}, ",
        "#{name,jdbcType=VARCHAR}, #{time,jdbcType=DATE}, #{remark,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=INTEGER}, #{userName,jdbcType=CHAR})"
    })
    int insert(Book record);

    @Select({
        "select",
        "id, order_id, name, time, remark, user_id, user_name",
        "from book",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.SMALLINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.CHAR)
    })
    Book selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, order_id, name, time, remark, user_id, user_name",
        "from book"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.SMALLINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.CHAR)
    })
    List<Book> selectAll();

    @Update({
        "update book",
        "set order_id = #{orderId,jdbcType=SMALLINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=DATE},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "user_name = #{userName,jdbcType=CHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Book record);
}