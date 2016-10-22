package xz.day_9_21;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//c3p0���ӳ�   --����
public class Pool {
	
 //  ����Դ 
	private ComboPooledDataSource ds;
	private static Pool pool = new Pool();
	
	private java.util.Properties prop;
	private String DBURL;
	private String DBUSR;
	private String DBPWD;
	private String DBDRIVRE;
	
	private Pool(){
		
		prop = new java.util.Properties();
		try {
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream("DBConfig.txt"));
			DBURL = prop.getProperty("DBURL");
			DBUSR = prop.getProperty("DBUSR");
			DBPWD = prop.getProperty("DBPWD");
			DBDRIVRE = prop.getProperty("DBDRIVRE");
			
			
			//���ݿ����ӳ���Ϣ
			ds = new ComboPooledDataSource();
			ds.setDriverClass(DBDRIVRE);
			ds.setUser(DBUSR);
			ds.setPassword(DBPWD);
			ds.setJdbcUrl(DBURL);
			
			
			//���ӳز���
			ds.setInitialPoolSize(30);
			ds.setMaxPoolSize(80);
			ds.setMinPoolSize(10);
			ds.setMaxStatements(240);
			ds.setMaxIdleTime(5000);
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public static Pool getPool(){
		return pool;
	}
	
	public DataSource getDataSource(){
		return ds;
	}
	
	 public static void main(String[] args) {
		 
		    try {
				  Connection   comm =   Pool.getPool().getDataSource().getConnection();
		          System.out.println(comm);
		          
		          
		    } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
