package xz.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xz.model.Span;

import java.util.List;

public interface ISpanDao {
	/**
	 * 用注解只写接口即可，不必写实现类（mybatis动态生成）,但是需要spring支持
	 */
	// 使用@Insert注解指明add方法要执行的SQL
//	@Insert("insert into span_copy(name,age,location) values(#{name},#{age},#{location})")
//	public int add(Span span);

	// 使用@Delete注解指明deleteByName方法要执行的SQL
//	@Delete("delete from span_copy where name=#{name}")
//	public int deleteByName(String name);

	// 使用@Update注解指明update方法要执行的SQL
//	@Update("update span_copy set name=#{name},age=#{age} where name=#{name}")
//	public int update(Span span);

	// 使用@Select注解指明getByName方法要执行的SQL
	@Select("select * from span_copy where trace_id=#{traceId}")
	List<Span> findByTraceId(Long traceId);

	// 使用@Select注解指明getAll方法要执行的SQL
	@Select("select * from span_copy")
	@Results({
			@Result(column="trace_id", property="traceId", jdbcType= JdbcType.BIGINT, id=true),
			@Result(column="span_id", property="spanId", jdbcType=JdbcType.BIGINT, id=true),
			@Result(column="endpoint_ipv4", property="endpointIpv4", jdbcType=JdbcType.INTEGER),
			@Result(column="endpoint_service_name", property="endpointServiceName", jdbcType=JdbcType.VARCHAR),
			@Result(column="start_ts", property="startTs", jdbcType=JdbcType.BIGINT),
			@Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT),
			@Result(column="record_ts", property="recordTs", jdbcType=JdbcType.BIGINT),
			@Result(column="trace_md5", property="traceMd5", jdbcType=JdbcType.VARCHAR),
			@Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
			@Result(column="parent_ip", property="parentIp", jdbcType=JdbcType.INTEGER),
			@Result(column="parent_endpoint_name", property="parentEndpointName", jdbcType=JdbcType.VARCHAR)
	})
	List<Span> findAll();
}
