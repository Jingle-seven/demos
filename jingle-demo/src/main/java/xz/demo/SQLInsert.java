package xz.demo;

import java.sql.*;

/**
 * Created by Jinhua on 2016/12/5.
 */
public class SQLInsert {
	private static SQLInsert instance;
	String host = "10.17.36.55";
	String port = "3306";
	String name = "cloudins";
	String user = "root";
	String pwd = "z";
	String url = "jdbc:mysql://%1$s:%2$s/%3$s?user=%4$s&password=%5$s" +
			"&useUnicode=true&characterEncoding=UTF8&useSSL=false";
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = getConn();
//		findElephantExistZipkinNE(conn);
//		insertCheckConfig(conn);
		insertCheckLog(conn);
//		insertCloudinsConfig(conn);
		insertCLoudinsLog(conn);
		conn.close();
		System.out.println("Finished");
		
	}
	private SQLInsert(){
		url = String.format(url, host, port, name, user, pwd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private Connection connection() throws SQLException {
		return DriverManager.getConnection(url);
	}
	
	static Connection getConn() throws SQLException {
		checkInstance();
		return instance.connection();
	}
	
	private static void checkInstance() {
		if(instance==null){
			synchronized (SQLInsert.class){
				if (instance==null)
					instance = new SQLInsert();
			}
		}
	}
	static void findElephantExistZipkinNE(Connection conn) throws SQLException {
		int allNum = 0,notExistNum = 0;
		PreparedStatement elephantSt = conn.prepareStatement("select id from yarn_app_result");
		ResultSet elephatIds = elephantSt.executeQuery();
		while(elephatIds.next()){
			allNum++;
			String id = elephatIds.getString(1);
//			id = "application_1478503538757_1043";
			String longId = id.replaceAll("\\D","");
			PreparedStatement st = conn.prepareStatement("select * from zipkin_spans where trace_id="+longId+" limit 0,1");
			ResultSet rs = st.executeQuery();
			while (true){
				if(rs.next()) {
					notExistNum++;
					System.out.println(id + " E");
					break;
				}else {
					System.out.println(id + " notE");
					break;
				}
			}
		}
		System.out.println("All: "+allNum+"\n notE: "+notExistNum);
	}
	static void insertCheckLog(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("insert into yarn_app_check_log values(?,?,?,?,?,?,?)");
		for(int i = 21;i<100;i++){
			stmt.setLong(1,i);
			stmt.setString(2,"job_"+i);
			stmt.setString(3,"There is nothing");
			stmt.setLong(4,System.currentTimeMillis());
			stmt.setString(5,null);
			stmt.setBoolean(6,false);
			stmt.setBoolean(7,false);
			stmt.execute();
		}
//		conn.close();
	}
	static void insertCloudinsConfig(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("insert into cloudins_config values(?,?,?,?,?,?,?,?)");
		for(int i = 21;i<100;i++){
			stmt.setLong(1,i);
			stmt.setString(2,"product_"+i);
			stmt.setString(3,"The prophecy of Pander");
			stmt.setString(4,"A mod of M&B");
			stmt.setString(5,"Pander");
			stmt.setString(6,"56");
			stmt.setBoolean(7,false);
			stmt.setString(8,"wow");
			stmt.execute();
		}
//		conn.close();
	}
	static void insertCheckConfig(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("insert into yarn_app_check_setting values(?,?,?,?,?,?)");
		for(int i = 21;i<100;i++){
			stmt.setLong(1,i);
			stmt.setString(2,"name_"+i);
			stmt.setString(3,null);
			stmt.setInt(4,120);
			stmt.setInt(5,400);
			stmt.setInt(6,2);
			stmt.execute();
		}
//		conn.close();
	}
	static void insertCLoudinsLog(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("insert into cloudins_log values(?,?,?,?,?,?,?,?)");
		for(int i = 21;i<100;i++){
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
//		conn.close();
	}
}
