package generator.idao;

import generator.pojo.ZipkinAnnotations;
import generator.pojo.ZipkinAnnotationsExample;
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

public interface ZipkinAnnotationsMapper {
    @SelectProvider(type=ZipkinAnnotationsSqlProvider.class, method="countByExample")
    int countByExample(ZipkinAnnotationsExample example);

    @DeleteProvider(type=ZipkinAnnotationsSqlProvider.class, method="deleteByExample")
    int deleteByExample(ZipkinAnnotationsExample example);

    @Insert({
        "insert into zipkin_annotations (trace_id, span_id, ",
        "a_key, a_type, a_timestamp, ",
        "endpoint_ipv4, endpoint_port, ",
        "endpoint_service_name, a_value, ",
        "endpoint_ipv6)",
        "values (#{traceId,jdbcType=BIGINT}, #{spanId,jdbcType=BIGINT}, ",
        "#{aKey,jdbcType=VARCHAR}, #{aType,jdbcType=INTEGER}, #{aTimestamp,jdbcType=BIGINT}, ",
        "#{endpointIpv4,jdbcType=INTEGER}, #{endpointPort,jdbcType=SMALLINT}, ",
        "#{endpointServiceName,jdbcType=VARCHAR}, #{aValue,jdbcType=LONGVARBINARY}, ",
        "#{endpointIpv6,jdbcType=BINARY})"
    })
    int insert(ZipkinAnnotations record);

    @InsertProvider(type=ZipkinAnnotationsSqlProvider.class, method="insertSelective")
    int insertSelective(ZipkinAnnotations record);

    @SelectProvider(type=ZipkinAnnotationsSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT),
        @Result(column="span_id", property="spanId", jdbcType=JdbcType.BIGINT),
        @Result(column="a_key", property="aKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="a_type", property="aType", jdbcType=JdbcType.INTEGER),
        @Result(column="a_timestamp", property="aTimestamp", jdbcType=JdbcType.BIGINT),
        @Result(column="endpoint_ipv4", property="endpointIpv4", jdbcType=JdbcType.INTEGER),
        @Result(column="endpoint_port", property="endpointPort", jdbcType=JdbcType.SMALLINT),
        @Result(column="endpoint_service_name", property="endpointServiceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="a_value", property="aValue", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="endpoint_ipv6", property="endpointIpv6", jdbcType=JdbcType.BINARY)
    })
    List<ZipkinAnnotations> selectByExampleWithBLOBs(ZipkinAnnotationsExample example);

    @SelectProvider(type=ZipkinAnnotationsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="trace_id", property="traceId", jdbcType=JdbcType.BIGINT),
        @Result(column="span_id", property="spanId", jdbcType=JdbcType.BIGINT),
        @Result(column="a_key", property="aKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="a_type", property="aType", jdbcType=JdbcType.INTEGER),
        @Result(column="a_timestamp", property="aTimestamp", jdbcType=JdbcType.BIGINT),
        @Result(column="endpoint_ipv4", property="endpointIpv4", jdbcType=JdbcType.INTEGER),
        @Result(column="endpoint_port", property="endpointPort", jdbcType=JdbcType.SMALLINT),
        @Result(column="endpoint_service_name", property="endpointServiceName", jdbcType=JdbcType.VARCHAR)
    })
    List<ZipkinAnnotations> selectByExample(ZipkinAnnotationsExample example);

    @UpdateProvider(type=ZipkinAnnotationsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ZipkinAnnotations record, @Param("example") ZipkinAnnotationsExample example);

    @UpdateProvider(type=ZipkinAnnotationsSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ZipkinAnnotations record, @Param("example") ZipkinAnnotationsExample example);

    @UpdateProvider(type=ZipkinAnnotationsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ZipkinAnnotations record, @Param("example") ZipkinAnnotationsExample example);
}