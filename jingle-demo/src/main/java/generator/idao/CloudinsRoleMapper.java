package generator.idao;

import generator.pojo.CloudinsRole;
import generator.pojo.CloudinsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CloudinsRoleMapper {
    @SelectProvider(type=CloudinsRoleSqlProvider.class, method="countByExample")
    int countByExample(CloudinsRoleExample example);

    @DeleteProvider(type=CloudinsRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(CloudinsRoleExample example);

    @Delete({
        "delete from cloudins_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cloudins_role (id, name, ",
        "auth, remark)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{auth,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(CloudinsRole record);

    @InsertProvider(type=CloudinsRoleSqlProvider.class, method="insertSelective")
    int insertSelective(CloudinsRole record);

    @SelectProvider(type=CloudinsRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="auth", property="auth", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<CloudinsRole> selectByExample(CloudinsRoleExample example);

    @Select({
        "select",
        "id, name, auth, remark",
        "from cloudins_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="auth", property="auth", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    CloudinsRole selectByPrimaryKey(Long id);

    @UpdateProvider(type=CloudinsRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CloudinsRole record, @Param("example") CloudinsRoleExample example);

    @UpdateProvider(type=CloudinsRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CloudinsRole record, @Param("example") CloudinsRoleExample example);

    @UpdateProvider(type=CloudinsRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CloudinsRole record);

    @Update({
        "update cloudins_role",
        "set name = #{name,jdbcType=VARCHAR},",
          "auth = #{auth,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CloudinsRole record);
}