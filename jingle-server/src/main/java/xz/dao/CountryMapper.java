package xz.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.Country;

import java.util.List;

public interface CountryMapper {
    @Delete({
        "delete from country",
        "where Code = #{code,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String code);

    @Insert({
        "insert into country (Code, Name, Continent, ",
        "Region, SurfaceArea, IndepYear, ",
        "Population, LifeExpectancy, ",
        "GNP, GNPOld, LocalName, ",
        "GovernmentForm, HeadOfState, ",
        "Capital, Code2)",
        "values (#{code,jdbcType=CHAR}, #{name,jdbcType=CHAR}, #{continent,jdbcType=CHAR}, ",
        "#{region,jdbcType=CHAR}, #{surfacearea,jdbcType=REAL}, #{indepyear,jdbcType=SMALLINT}, ",
        "#{population,jdbcType=INTEGER}, #{lifeexpectancy,jdbcType=REAL}, ",
        "#{gnp,jdbcType=REAL}, #{gnpold,jdbcType=REAL}, #{localname,jdbcType=CHAR}, ",
        "#{governmentform,jdbcType=CHAR}, #{headofstate,jdbcType=CHAR}, ",
        "#{capital,jdbcType=INTEGER}, #{code2,jdbcType=CHAR})"
    })
    int insert(Country record);

    @Select({
        "select",
        "Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, ",
        "GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2",
        "from country",
        "where Code = #{code,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="Code", property="code", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="Continent", property="continent", jdbcType=JdbcType.CHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.CHAR),
        @Result(column="SurfaceArea", property="surfacearea", jdbcType=JdbcType.REAL),
        @Result(column="IndepYear", property="indepyear", jdbcType=JdbcType.SMALLINT),
        @Result(column="Population", property="population", jdbcType=JdbcType.INTEGER),
        @Result(column="LifeExpectancy", property="lifeexpectancy", jdbcType=JdbcType.REAL),
        @Result(column="GNP", property="gnp", jdbcType=JdbcType.REAL),
        @Result(column="GNPOld", property="gnpold", jdbcType=JdbcType.REAL),
        @Result(column="LocalName", property="localname", jdbcType=JdbcType.CHAR),
        @Result(column="GovernmentForm", property="governmentform", jdbcType=JdbcType.CHAR),
        @Result(column="HeadOfState", property="headofstate", jdbcType=JdbcType.CHAR),
        @Result(column="Capital", property="capital", jdbcType=JdbcType.INTEGER),
        @Result(column="Code2", property="code2", jdbcType=JdbcType.CHAR)
    })
    Country selectByPrimaryKey(String code);

    @Select({
        "select",
        "Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, ",
        "GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2",
        "from country"
    })
    @Results({
        @Result(column="Code", property="code", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="Continent", property="continent", jdbcType=JdbcType.CHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.CHAR),
        @Result(column="SurfaceArea", property="surfacearea", jdbcType=JdbcType.REAL),
        @Result(column="IndepYear", property="indepyear", jdbcType=JdbcType.SMALLINT),
        @Result(column="Population", property="population", jdbcType=JdbcType.INTEGER),
        @Result(column="LifeExpectancy", property="lifeexpectancy", jdbcType=JdbcType.REAL),
        @Result(column="GNP", property="gnp", jdbcType=JdbcType.REAL),
        @Result(column="GNPOld", property="gnpold", jdbcType=JdbcType.REAL),
        @Result(column="LocalName", property="localname", jdbcType=JdbcType.CHAR),
        @Result(column="GovernmentForm", property="governmentform", jdbcType=JdbcType.CHAR),
        @Result(column="HeadOfState", property="headofstate", jdbcType=JdbcType.CHAR),
        @Result(column="Capital", property="capital", jdbcType=JdbcType.INTEGER),
        @Result(column="Code2", property="code2", jdbcType=JdbcType.CHAR)
    })
    List<Country> selectAll();

    @Update({
        "update country",
        "set Name = #{name,jdbcType=CHAR},",
          "Continent = #{continent,jdbcType=CHAR},",
          "Region = #{region,jdbcType=CHAR},",
          "SurfaceArea = #{surfacearea,jdbcType=REAL},",
          "IndepYear = #{indepyear,jdbcType=SMALLINT},",
          "Population = #{population,jdbcType=INTEGER},",
          "LifeExpectancy = #{lifeexpectancy,jdbcType=REAL},",
          "GNP = #{gnp,jdbcType=REAL},",
          "GNPOld = #{gnpold,jdbcType=REAL},",
          "LocalName = #{localname,jdbcType=CHAR},",
          "GovernmentForm = #{governmentform,jdbcType=CHAR},",
          "HeadOfState = #{headofstate,jdbcType=CHAR},",
          "Capital = #{capital,jdbcType=INTEGER},",
          "Code2 = #{code2,jdbcType=CHAR}",
        "where Code = #{code,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Country record);
}