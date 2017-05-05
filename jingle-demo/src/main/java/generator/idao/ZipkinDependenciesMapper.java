package generator.idao;

import generator.pojo.ZipkinDependencies;
import generator.pojo.ZipkinDependenciesExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ZipkinDependenciesMapper {
    @SelectProvider(type=ZipkinDependenciesSqlProvider.class, method="countByExample")
    int countByExample(ZipkinDependenciesExample example);

    @DeleteProvider(type=ZipkinDependenciesSqlProvider.class, method="deleteByExample")
    int deleteByExample(ZipkinDependenciesExample example);

    @Insert({
        "insert into zipkin_dependencies (day, parent, ",
        "child, call_count)",
        "values (#{day,jdbcType=DATE}, #{parent,jdbcType=VARCHAR}, ",
        "#{child,jdbcType=VARCHAR}, #{callCount,jdbcType=BIGINT})"
    })
    int insert(ZipkinDependencies record);

    @InsertProvider(type=ZipkinDependenciesSqlProvider.class, method="insertSelective")
    int insertSelective(ZipkinDependencies record);

    @SelectProvider(type=ZipkinDependenciesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="day", property="day", jdbcType=JdbcType.DATE),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="child", property="child", jdbcType=JdbcType.VARCHAR),
        @Result(column="call_count", property="callCount", jdbcType=JdbcType.BIGINT)
    })
    List<ZipkinDependencies> selectByExample(ZipkinDependenciesExample example);

    @UpdateProvider(type=ZipkinDependenciesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ZipkinDependencies record, @Param("example") ZipkinDependenciesExample example);

    @UpdateProvider(type=ZipkinDependenciesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ZipkinDependencies record, @Param("example") ZipkinDependenciesExample example);
}