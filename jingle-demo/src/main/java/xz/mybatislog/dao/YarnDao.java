/**
 * package xz.mybatislog.dao;

import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;
import zipkin.*;
import zipkin.internal.*;
import zipkin.yarn_model.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static zipkin.storage.mysql.MySQLSpanStore.ANNOTATION_FIELDS_WITHOUT_IPV6;
import static zipkin.storage.mysql.internal.generated.Tables.ZIPKIN_ANNOTATIONS;
import static zipkin.storage.mysql.internal.generated.Tables.ZIPKIN_SPANS;
import static zipkin.storage.mysql.internal.generated.tables.CloudInsConfigs.CLOUDINS_CONFIGS;

import org.jooq.TableField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class YarnDao {
	private final DataSource ds;
	private final DSLContexts ctx;
	//数据源 & Jooq上下文类
	public YarnDao(DataSource ds, DSLContexts ctx) {
		this.ds = ds;
		this.ctx = ctx;
	}

	public Result<Record> queryWithCondition(TableImpl<Record> table, Condition...cdtn){
		try (Connection conn = ds.getConnection()) {
			Result<Record> rcds = ctx.get(conn)
					.selectFrom(table)
					.where(cdtn)
					.fetch();

			return rcds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
	}
	
	public Result<Record> queryWithCondition(TableImpl<Record> table, int limit, int offset , Condition...cdtn){
		try (Connection conn = ds.getConnection()) {
			Result<Record> rcds = ctx.get(conn)
					.selectFrom(table)
					.where(cdtn)
					.limit(limit)
					.offset(offset)
					.fetch();
			
			return rcds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
	}
	
	//取出几条记录group by field
	public Result<Record> queryWithCondition(TableImpl<Record> table, TableField groupField, Condition...cdtn){
		try (Connection conn = ds.getConnection()) {
			Result<Record> rcds = ctx.get(conn)
					.selectFrom(table)
					.where(cdtn)
					.groupBy(groupField)
					.fetch();
			
			return rcds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
	}
	public Result<Record> queryWithCondition(TableField selectField, Condition...cdtn){
		try (Connection conn = ds.getConnection()) {
			Result rcds = ctx.get(conn)
					.select(selectField,selectField.count())
					.from(selectField.getTable())
					.where(cdtn)
					.groupBy(selectField)
					.fetch();
			
			return rcds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
	}
	public Result<Record> queryWithConditionGroup(TableField<Record,String> selectField, TableField<Record,Long> countField, Condition...cdtn){
		try (Connection conn = ds.getConnection()) {
			Result rcds = ctx.get(conn)
					.select(selectField,countField.avg(),countField.min(),countField.max(),countField.count())
					.from(selectField.getTable())
					.where(cdtn)
					.groupBy(selectField)
					.fetch();
			
			return rcds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
	}
	public Result<Record> queryAllWithConditionGroup(TableField<Record,String> selectField, TableField<Record,Long> countField, Condition...cdtn){
		try (Connection conn = ds.getConnection()) {
			Result rcds = ctx.get(conn)
					.selectFrom(selectField.getTable())
					.where(cdtn)
					.groupBy(selectField)
					.fetch();
			
			return rcds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
	}
	public Result<Record> joinWithCondition(TableField selectField,
											TableImpl<Record> joinTable, Condition joinCdtn, Condition...cdtn){
		try (Connection conn = ds.getConnection()) {
			Result rcds = ctx.get(conn)
					.select(selectField)
					.from(selectField.getTable())
					.join(joinTable).on(joinCdtn)
					.where(cdtn)
					.fetch();
			
			return rcds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
	}
	public Result<Record> joinWithCondition(TableField<Record,String> selectField,
											TableField<Record,Long> countField,
											TableImpl<Record> joinTable,
											TableField<Record,String> groupField,
											Condition joinCdtn, Condition...cdtn){
		try (Connection conn = ds.getConnection()) {
			Result rcds = ctx.get(conn)
					.select(selectField,countField.avg(),countField.min(),countField.max(),countField.count())
					.from(selectField.getTable())
					.join(joinTable).on(joinCdtn)
					.where(cdtn)
					.groupBy(groupField)
					.fetch();
			
			return rcds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
	}
	
	//按field参数倒序取出topNum条记录
	public Result<Record> top(TableImpl<Record> table, int topNum, TableField<Record, Long> field){
		try (Connection conn = ds.getConnection()) {
			Result<Record> rcds = ctx.get(conn)
					.selectFrom(table)
					.orderBy(field.desc())
					.limit(topNum)
					.fetch();
			
			return rcds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
	}
	
	public List<List<Span>> getTracesOrderbyStartTs(List<Long> traceIds, int limit, int page, boolean raw) {
		final Map<Long, List<Span>> spansWithoutAnnotations;
		final Map<Pair<?>, List<Record>> dbAnnotations;
		try (Connection conn = ds.getConnection()) {
			Condition traceIdCondition;
				traceIdCondition = ZIPKIN_SPANS.TRACE_ID.in(traceIds);
			spansWithoutAnnotations = ctx.get(conn)
					.selectFrom(ZIPKIN_SPANS).where(traceIdCondition)
					.orderBy(ZIPKIN_SPANS.START_TS)//此两行为新增
					.limit(limit).offset(limit *page)// by xjh
					.stream()
					.map(r -> Span.builder()
							.traceId(r.getValue(ZIPKIN_SPANS.TRACE_ID))
							.name(r.getValue(ZIPKIN_SPANS.NAME))
							.id(r.getValue(ZIPKIN_SPANS.ID))
							.parentId(r.getValue(ZIPKIN_SPANS.PARENT_ID))
							.timestamp(r.getValue(ZIPKIN_SPANS.START_TS))
							.duration(r.getValue(ZIPKIN_SPANS.DURATION))
							.debug(r.getValue(ZIPKIN_SPANS.DEBUG))
							.build())
					.collect(
							groupingBy((Span s) -> s.traceId, LinkedHashMap::new, Collectors.<Span>toList()));
			
			dbAnnotations = ctx.get(conn)
					.select(ANNOTATION_FIELDS_WITHOUT_IPV6)
					.from(ZIPKIN_ANNOTATIONS)
					.where(ZIPKIN_ANNOTATIONS.TRACE_ID.in(spansWithoutAnnotations.keySet()))
					.orderBy(ZIPKIN_ANNOTATIONS.A_TIMESTAMP.asc(), ZIPKIN_ANNOTATIONS.A_KEY.asc())
					.stream()
					.collect(groupingBy((Record a) -> Pair.create(
							a.getValue(ZIPKIN_ANNOTATIONS.TRACE_ID),
							a.getValue(ZIPKIN_ANNOTATIONS.SPAN_ID)
							), LinkedHashMap::new,
							Collectors.<Record>toList())); // LinkedHashMap preserves order while grouping
		} catch (SQLException e) {
			throw new RuntimeException("Error querying for " + e);
		}
		
		List<List<Span>> result = new ArrayList<>(spansWithoutAnnotations.keySet().size());
		for (List<Span> spans : spansWithoutAnnotations.values()) {
			List<Span> trace = new ArrayList<>(spans.size());
			for (Span s : spans) {
				Span.Builder span = s.toBuilder();
				Pair<?> key = Pair.create(s.traceId, s.id);
				
				if (dbAnnotations.containsKey(key)) {
					for (Record a : dbAnnotations.get(key)) {
						Endpoint endpoint = endpoint(a);
						int type = a.getValue(ZIPKIN_ANNOTATIONS.A_TYPE);
						if (type == -1) {
							span.addAnnotation(Annotation.create(
									a.getValue(ZIPKIN_ANNOTATIONS.A_TIMESTAMP),
									a.getValue(ZIPKIN_ANNOTATIONS.A_KEY),
									endpoint));
						} else {
							span.addBinaryAnnotation(BinaryAnnotation.create(
									a.getValue(ZIPKIN_ANNOTATIONS.A_KEY),
									a.getValue(ZIPKIN_ANNOTATIONS.A_VALUE),
									BinaryAnnotation.Type.fromValue(type),
									endpoint));
						}
					}
				}
				Span rawSpan = span.build();
				trace.add(raw ? rawSpan : ApplyTimestampAndDuration.apply(rawSpan));
			}
			if (!raw) trace = CorrectForClockSkew.apply(trace);
			result.add(trace);
		}
		if (!raw) Collections.sort(result, (left, right) -> right.get(0).compareTo(left.get(0)));
		return result;
	}
	
	public int updateConfig(CloudInsConfig conf, Condition... cdtn) {
		int resCode = 0;
		try (Connection conn = ds.getConnection()) {
			resCode = ctx.get(conn)
					.update(CLOUDINS_CONFIGS)
					.set(CLOUDINS_CONFIGS.ID,conf.getId())
					.set(CLOUDINS_CONFIGS.PRODUCT, conf.getProduct())
					.set(CLOUDINS_CONFIGS.MODULE, conf.getModule())
					.set(CLOUDINS_CONFIGS.PARM_NAME, conf.getParm_name())
					.set(CLOUDINS_CONFIGS.PARM_VALUE, conf.getParm_value())
					.set(CLOUDINS_CONFIGS.FLAG, conf.getFlag())
					.set(CLOUDINS_CONFIGS.COMMENT, conf.getComment())
					.where(cdtn)
					.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in YarnDao");
		}
		return resCode;
	}
	private Endpoint endpoint(Record a) {
		String serviceName = a.getValue(ZIPKIN_ANNOTATIONS.ENDPOINT_SERVICE_NAME);
		if (serviceName == null) return null;
		return Endpoint.builder()
				.serviceName(serviceName)
				.port(a.getValue(ZIPKIN_ANNOTATIONS.ENDPOINT_PORT))
				.ipv4(a.getValue(ZIPKIN_ANNOTATIONS.ENDPOINT_IPV4))
				.build();
	}
}*/
