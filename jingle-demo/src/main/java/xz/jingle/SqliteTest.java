package xz.jingle;


import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SqliteTest {
	private static Connection conn;
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:log/mock.db");
			Statement stmt = conn.createStatement();
			String sql =
					"CREATE TABLE IF NOT EXISTS t_file" +
							"(name		TEXT PRIMARY KEY	NOT NULL, " +
							"age 		INT 				NOT NULL," +
							"male		BOOLEAN				NOT NULL)";
			stmt.execute(sql);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Read history filename Failed. " + e);
		}
	}
	
	public static void insert(String name,int age ,boolean male) {
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT OR REPLACE INTO t_file VALUES(?,?,?)");
			pst.setString(1,name);
			pst.setInt(2,age);
			pst.setBoolean(3,male);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Insert file info error! " + e);
		}
	}
	public static void main(String[] args) {
		SqliteTest.insert("xx",1,false);
		SqliteTest.insert("xx",2,false);
	}
}
