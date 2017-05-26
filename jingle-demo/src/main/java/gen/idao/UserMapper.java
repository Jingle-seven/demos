package gen.idao;

import gen.pojo.User;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Insert({
        "insert into user (id, name, ",
        "class_id, location)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{classId,jdbcType=INTEGER}, #{location,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @Select({
        "select",
        "id, name, class_id, location",
        "from user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectAll();
}