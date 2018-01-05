package xz.tools;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class DBUtil {
	
	private static String MYSQL_DB_URL = "jdbc:mysql://%1$s:%2$s/%3$s?user=%4$s&password=%5$s" +
			"&useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC";
	private static DBUtil instance;
	private ComboPooledDataSource ds;
	
	private DBUtil(String host, String port, String database, String userName, String password) {
		try {
			String url = String.format(MYSQL_DB_URL, host, port, database, userName, password);
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
			ds = new ComboPooledDataSource();
			ds.setDriverClass("com.mysql.cj.jdbc.Driver");
			ds.setJdbcUrl(url);
			ds.setUser(userName);
			ds.setPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBUtil instance(String host, String port, String database, String userName, String password) {
		if (instance == null) {
			synchronized (DBUtil.class) {
				if (instance == null)
					instance = new DBUtil(host, port, database, userName, password);
			}
		}
		return instance;
	}
	
	
	public Connection getConn() throws SQLException {
		return ds.getConnection();
	}
	
	public Statement getStmt() throws SQLException {
		Connection conn = ds.getConnection();
		Statement st = conn.createStatement();
		return st;
	}
	
	public static void close(Connection conn) throws SQLException {
		if(conn!=null)
			conn.close();
	}
	public static void close(Statement st) throws SQLException {
		if(st!=null)
			st.close();
	}
	public static void close(ResultSet rs) throws SQLException {
		if(rs!=null)
			rs.close();
	}
	
}






































	/** <!-- 初始化连接池中的连接数，取值应在minPoolSize与maxPoolSize之间，默认为3-->
		<property name="initialPoolSize" value="2"/>
		<!-- 连接池中保留的最小连接数，默认为：3-->
		<property name="minPoolSize" value="2"/>
		<!--连接池中保留的最大连接数。默认值: 15 -->
		<property name="maxPoolSize" value="15"/>
		<!--当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。默认值: 3 -->
		<property name="acquireIncrement" value="2"/>
		<!--定义在从数据库获取新连接失败后重复尝试的次数。默认值: 30 ；小于等于0表示无限次-->
         <property name="acquireRetryAttempts" value="0"/>
         <!--重新尝试的时间间隔，默认为：1000毫秒-->
          <property name="acquireRetryDelay" value="1000" />
		 <!--最大空闲时间，3600秒内未使用则连接被丢弃。若为0则永不丢弃。默认值: 0 -->
		<property name="maxIdleTime" value="3600"/>
		 <!--c3p0全局的PreparedStatements缓存的大小。如果maxStatements与maxStatementsPerConnection均为0，则缓存不生效，只要有一个不为0，则语句的缓存就能生效。如果默认值: 0-->
		<property name="maxStatements" value="0"/>
		 <!--maxStatementsPerConnection定义了连接池内单个连接所拥有的最大缓存statements数。默认值: 0 -->
		<property name="maxStatementsPerConnection" value="0"/>
		<!--定义所有连接测试都执行的测试语句。在使用连接测试的情况下这个一显著提高测试速度。测试的表必须在初始数据源的时候就存在。Default: null-->
		<property name="preferredTestQuery" value="select 1"/>
		 <!--每1800秒检查所有连接池中的空闲连接。Default: 0 -->
		<property name="idleConnectionTestPeriod" value="1800"/>
		<!-- 获取连接时测试有效性，每次都验证连接是否可用 -->
		<property name="testConnectionOnCheckout" value="false"/>
	 **/