package xz.tools;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Jinhua on 2016/10/31.
 */
public class DBUtilTest {
	@Test
	public void test() throws SQLException {
		DBUtil util = DBUtil.instance("127.0.0.1","3306","world","root","123456");
		Statement st = util.getStmt();
		ResultSet rs = st.executeQuery("select * from user");
		
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		for(int i=1;i<=columnCount;i++){
			System.out.println(metaData.getColumnName(i));
		}
		while (rs.next()){
			System.out.print(rs.getString(1));
			System.out.println(" age "+rs.getString(2));
		}
	}
}
