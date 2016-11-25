package xz.day_9_21;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.*;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import static javax.swing.UIManager.getString;

public class Pool {
	
	private ComboPooledDataSource ds;
	private static Pool pool = new Pool();
	
	private java.util.Properties prop;
	private String DBURL;
	private String DBUSR;
	private String DBPWD;
	private String DBDRIVRE;
	
	private Pool() {
		
		prop = new java.util.Properties();
		try {
//			prop.load(this.getClass().getClassLoader()
//					.getResourceAsStream("DBConfig.txt"));
//			DBURL = prop.getProperty("DBURL");
//			DBUSR = prop.getProperty("DBUSR");
//			DBPWD = prop.getProperty("DBPWD");
//			DBDRIVRE = prop.getProperty("DBDRIVRE");
//			&characterEncoding=UTF8&useSSL=false"
			
			ds = new ComboPooledDataSource();
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/cloudins?useSSL=false");
			ds.setUser("xjh");
			ds.setPassword("z");
			
			
//			ds.setInitialPoolSize(30);
			ds.setMinPoolSize(3);
			ds.setMaxPoolSize(30);
			ds.setMaxIdleTime(8);
			ds.setIdleConnectionTestPeriod(30);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Pool getPool() {
		return pool;
	}
	
	public DataSource getDataSource() {
		return ds;
	}
	
	public static void main(String[] args) throws Exception {
//		ExecutorService threadPool = new ThreadPoolExecutor(10,20,0L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		Pool connPool =Pool.getPool();
		
		ComboPooledDataSource cpds = (ComboPooledDataSource) connPool.getDataSource();
		new Thread(new Watcher(cpds)).start();
		
		for(int i=0;i<20;i++) {
			threadPool.execute(new ConnConsumer(cpds));
		}
	}
	
	static class ConnConsumer implements Runnable{
		ComboPooledDataSource ds;
		public ConnConsumer(ComboPooledDataSource ds) {this.ds = ds;}
		public void run() {
			try {
				Thread.sleep(15 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try (Connection conn = ds.getConnection()){
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select version()");
				rs.next();
				System.out.println(Thread.currentThread()+rs.getString(1));
//				st.getConnection().close();
				System.out.println(Thread.currentThread()+" exit ");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	static class Watcher implements Runnable{
		ComboPooledDataSource ds;
		public Watcher(ComboPooledDataSource ds) {this.ds = ds;}
		public void run() {
			while (true){
				try {
					System.out.println(System.currentTimeMillis()+" busy "+ds.getNumBusyConnections());
					System.out.println(System.currentTimeMillis()+" all "+ds.getNumConnections());
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
}
