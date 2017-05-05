package generator.idao;

import generator.pojo.CloudinsUser;
import generator.pojo.CloudinsUserExample;
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

public interface CloudinsUserMapper {
    @SelectProvider(type=CloudinsUserSqlProvider.class, method="countByExample")
    int countByExample(CloudinsUserExample example);

    @DeleteProvider(type=CloudinsUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(CloudinsUserExample example);

    @Delete({
        "delete from cloudins_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cloudins_user (id, role_id, ",
        "region_id, account, ",
        "name, password, gender, ",
        "mail, company, phone, ",
        "qq, status, remark)",
        "values (#{id,jdbcType=BIGINT}, #{roleId,jdbcType=BIGINT}, ",
        "#{regionId,jdbcType=BIGINT}, #{account,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=CHAR}, #{password,jdbcType=VARCHAR}, #{gender,jdbcType=TINYINT}, ",
        "#{mail,jdbcType=VARCHAR}, #{company,jdbcType=VARCHAR}, #{phone,jdbcType=BIGINT}, ",
        "#{qq,jdbcType=BIGINT}, #{status,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(CloudinsUser record);

    @InsertProvider(type=CloudinsUserSqlProvider.class, method="insertSelective")
    int insertSelective(CloudinsUser record);

    @SelectProvider(type=CloudinsUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="region_id", property="regionId", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.TINYINT),
        @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.BIGINT),
        @Result(column="qq", property="qq", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<CloudinsUser> selectByExample(CloudinsUserExample example);

    @Select({
        "select",
        "id, role_id, region_id, account, name, password, gender, mail, company, phone, ",
        "qq, status, remark",
        "from cloudins_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="region_id", property="regionId", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.TINYINT),
        @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.BIGINT),
        @Result(column="qq", property="qq", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    CloudinsUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=CloudinsUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CloudinsUser record, @Param("example") CloudinsUserExample example);

    @UpdateProvider(type=CloudinsUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CloudinsUser record, @Param("example") CloudinsUserExample example);

    @UpdateProvider(type=CloudinsUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CloudinsUser record);

    @Update({
        "update cloudins_user",
        "set role_id = #{roleId,jdbcType=BIGINT},",
          "region_id = #{regionId,jdbcType=BIGINT},",
          "account = #{account,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=CHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=TINYINT},",
          "mail = #{mail,jdbcType=VARCHAR},",
          "company = #{company,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=BIGINT},",
          "qq = #{qq,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CloudinsUser record);
}