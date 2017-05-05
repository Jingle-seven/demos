package generator.idao;

import generator.pojo.SpanInfos;
import generator.pojo.SpanInfosExample;
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

public interface SpanInfosMapper {
    @SelectProvider(type=SpanInfosSqlProvider.class, method="countByExample")
    int countByExample(SpanInfosExample example);

    @DeleteProvider(type=SpanInfosSqlProvider.class, method="deleteByExample")
    int deleteByExample(SpanInfosExample example);

    @Delete({
        "delete from span_infos",
        "where name = #{name,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String name);

    @Insert({
        "insert into span_infos (name, alias, ",
        "def_baseline, cust_baseline)",
        "values (#{name,jdbcType=VARCHAR}, #{alias,jdbcType=VARCHAR}, ",
        "#{defBaseline,jdbcType=VARCHAR}, #{custBaseline,jdbcType=VARCHAR})"
    })
    int insert(SpanInfos record);

    @InsertProvider(type=SpanInfosSqlProvider.class, method="insertSelective")
    int insertSelective(SpanInfos record);

    @SelectProvider(type=SpanInfosSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="alias", property="alias", jdbcType=JdbcType.VARCHAR),
        @Result(column="def_baseline", property="defBaseline", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_baseline", property="custBaseline", jdbcType=JdbcType.VARCHAR)
    })
    List<SpanInfos> selectByExample(SpanInfosExample example);

    @Select({
        "select",
        "name, alias, def_baseline, cust_baseline",
        "from span_infos",
        "where name = #{name,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="alias", property="alias", jdbcType=JdbcType.VARCHAR),
        @Result(column="def_baseline", property="defBaseline", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_baseline", property="custBaseline", jdbcType=JdbcType.VARCHAR)
    })
    SpanInfos selectByPrimaryKey(String name);

    @UpdateProvider(type=SpanInfosSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SpanInfos record, @Param("example") SpanInfosExample example);

    @UpdateProvider(type=SpanInfosSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SpanInfos record, @Param("example") SpanInfosExample example);

    @UpdateProvider(type=SpanInfosSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpanInfos record);

    @Update({
        "update span_infos",
        "set alias = #{alias,jdbcType=VARCHAR},",
          "def_baseline = #{defBaseline,jdbcType=VARCHAR},",
          "cust_baseline = #{custBaseline,jdbcType=VARCHAR}",
        "where name = #{name,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SpanInfos record);
}