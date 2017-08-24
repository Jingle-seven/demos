package xz.idao.provider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;


/**
 * Created by Jinhua on 2017/6/14 17:04.
 */
public class BaseSqlProvider {
	
	
	public String findIn(Map<String, Object> para) {
		String s = new SQL()
				.SELECT("*")
				.FROM(para.get("t").toString())
				.WHERE(String.format("%s in (%s)", para.get("k"), para.get("v")))
				.toString();
		return s;
	}
	
	public String removeIn(Map<String, Object> para) {
		SQL sql = new SQL()
				.DELETE_FROM(para.get("t").toString())
				.WHERE(String.format("%s in (%s)", para.get("k"), para.get("v")));
		return sql.toString();
	}
	
	public String updateInId(Map<String, Object> para) {
		SQL sql = new SQL()
				.UPDATE(para.get("t").toString())
				.SET(String.format("%s = '%s'", para.get("k"), para.get("v")))
				.WHERE(String.format("id in (%s)", para.get("ids")));
		return sql.toString();
	}
	
	public String updateIn(Map<String, Object> para) {
		SQL sql = new SQL()
				.UPDATE(para.get("t").toString())
				.SET(String.format("%s = '%s'", para.get("k"), para.get("v")))
				.WHERE(String.format("%s in (%s)", para.get("ok"),para.get("ov")));
		return sql.toString();
	}
	
	public String findBy(Map<String, Object> para) {
		String s = new SQL()
				.SELECT("*")
				.FROM(para.get("t").toString())
				.WHERE(String.format("%s = '%s'", para.get("k"), para.get("v")))
				.toString();
		return s;
	}
	
	public String updateBy(Map<String, Object> para) {
		SQL sql = new SQL()
				.UPDATE(para.get("t").toString())
				.SET(String.format("%s = '%s'", para.get("k"), para.get("v")))
				.WHERE(String.format("%s = '%s'", para.get("ok"),para.get("ov")));
		return sql.toString();
	}
}
