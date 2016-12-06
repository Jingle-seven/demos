package xz.demo;

import java.sql.*;

/**
 * Created by Jinhua on 2016/12/5.
 */
public class SQLInsert {
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		String port = "3306";
		String name = "cloudins";
		String user = "root";
		String pwd = "123456";
		String url = "jdbc:mysql://%1$s:%2$s/%3$s?user=%4$s&password=%5$s" +
				"&useUnicode=true&characterEncoding=UTF8&useSSL=false";
		url = String.format(url, host, port, name, user, pwd);
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(url);
		insertCLoudinsLog(conn);
		System.out.println("Finished");
			
	}
	static void insertCheckLog(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("insert into yarn_app_check_log values(?,?,?,?,?,?,?)");
		for(int i = 10;i<20;i++){
			stmt.setLong(1,i);
			stmt.setString(2,"job_"+i);
			stmt.setString(3,"There is nothing");
			stmt.setLong(4,System.currentTimeMillis());
			stmt.setString(5,null);
			stmt.setBoolean(6,false);
			stmt.setBoolean(7,false);
			stmt.execute();
		}
		conn.close();
	}
	static void insertCLoudinsLog(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("insert into cloudins_log values(?,?,?,?,?,?,?,?)");
		for(int i = 0;i<10;i++){
			stmt.setLong(1,i);
			stmt.setString(2,"TEST");
			stmt.setString(3,"xxxclass.xx");
			stmt.setString(4,"There is nothing");
			stmt.setLong(5,System.currentTimeMillis());
			stmt.setLong(6,0);
			stmt.setBoolean(7,false);
			stmt.setBoolean(8,false);
			stmt.execute();
		}
		conn.close();
	}
}
