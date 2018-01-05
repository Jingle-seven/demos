package gen.idao;

import gen.pojo.Countrylanguage;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface CountrylanguageMapper {
    @Delete({
        "delete from countrylanguage",
        "where CountryCode = #{countrycode,jdbcType=CHAR}",
          "and Language = #{language,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(@Param("countrycode") String countrycode, @Param("language") String language);

    @Insert({
        "insert into countrylanguage (CountryCode, Language, ",
        "IsOfficial, Percentage)",
        "values (#{countrycode,jdbcType=CHAR}, #{language,jdbcType=CHAR}, ",
        "#{isofficial,jdbcType=CHAR}, #{percentage,jdbcType=REAL})"
    })
    int insert(Countrylanguage record);

    @Select({
        "select",
        "CountryCode, Language, IsOfficial, Percentage",
        "from countrylanguage",
        "where CountryCode = #{countrycode,jdbcType=CHAR}",
          "and Language = #{language,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="CountryCode", property="countrycode", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Language", property="language", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="IsOfficial", property="isofficial", jdbcType=JdbcType.CHAR),
        @Result(column="Percentage", property="percentage", jdbcType=JdbcType.REAL)
    })
    Countrylanguage selectByPrimaryKey(@Param("countrycode") String countrycode, @Param("language") String language);

    @Select({
        "select",
        "CountryCode, Language, IsOfficial, Percentage",
        "from countrylanguage"
    })
    @Results({
        @Result(column="CountryCode", property="countrycode", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Language", property="language", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="IsOfficial", property="isofficial", jdbcType=JdbcType.CHAR),
        @Result(column="Percentage", property="percentage", jdbcType=JdbcType.REAL)
    })
    List<Countrylanguage> selectAll();

    @Update({
        "update countrylanguage",
        "set IsOfficial = #{isofficial,jdbcType=CHAR},",
          "Percentage = #{percentage,jdbcType=REAL}",
        "where CountryCode = #{countrycode,jdbcType=CHAR}",
          "and Language = #{language,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Countrylanguage record);
}