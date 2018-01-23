package xz.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import xz.model.Weibo;

import java.util.List;

public interface WeiboMapper {
    @Insert({
        "insert into weibo (id, time, ",
        "image, user, ts, ",
        "weibo)",
        "values (#{id,jdbcType=BIGINT}, #{time,jdbcType=VARCHAR}, ",
        "#{image,jdbcType=VARCHAR}, #{user,jdbcType=VARCHAR}, #{ts,jdbcType=BIGINT}, ",
        "#{weibo,jdbcType=LONGVARCHAR})"
    })
    int insert(Weibo record);

    @Select({
        "select",
        "id, time, image, user, ts, weibo",
        "from weibo"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="ts", property="ts", jdbcType=JdbcType.BIGINT),
        @Result(column="weibo", property="weibo", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Weibo> selectAll();
}