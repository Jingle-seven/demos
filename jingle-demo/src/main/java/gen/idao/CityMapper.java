package gen.idao;

import gen.pojo.City;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface CityMapper {
    @Delete({
        "delete from city",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into city (ID, Name, CountryCode, ",
        "District, Population)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=CHAR}, #{countrycode,jdbcType=CHAR}, ",
        "#{district,jdbcType=CHAR}, #{population,jdbcType=INTEGER})"
    })
    int insert(City record);

    @Select({
        "select",
        "ID, Name, CountryCode, District, Population",
        "from city",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="CountryCode", property="countrycode", jdbcType=JdbcType.CHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.CHAR),
        @Result(column="Population", property="population", jdbcType=JdbcType.INTEGER)
    })
    City selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "ID, Name, CountryCode, District, Population",
        "from city"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="CountryCode", property="countrycode", jdbcType=JdbcType.CHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.CHAR),
        @Result(column="Population", property="population", jdbcType=JdbcType.INTEGER)
    })
    List<City> selectAll();

    @Update({
        "update city",
        "set Name = #{name,jdbcType=CHAR},",
          "CountryCode = #{countrycode,jdbcType=CHAR},",
          "District = #{district,jdbcType=CHAR},",
          "Population = #{population,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(City record);
}