package xz.idao.provider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static xz.util.LogKit.xLogger;


/**
 * Created by Jinhua on 2017/6/14 17:04.
 */
public class BaseSqlProvider {
	
	
	public String find(Map<String, Object> para) {
		String s = new SQL()
				.SELECT("*")
				.FROM(para.get("t").toString())
				.WHERE(String.format("%s = '%s'", para.get("k"), para.get("v")))
				.toString();
		xLogger.info(s.replace("\n",""));
		return s;
	}
}
