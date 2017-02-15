package xz.demo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jinhua on 2017/2/6.
 */
public class OrmLiteDemo {
	static Dao userDao;
	static Dao cityDao;
	public static void main(String[] args) throws SQLException, InterruptedException {
		String dbUrl =  "jdbc:mysql://127.0.0.1:3306/web1?user=xjh&password=z" +
				"&useUnicode=true&characterEncoding=UTF8&useSSL=false&autoReconnect=true";
		JdbcConnectionSource ds = new JdbcConnectionSource(dbUrl);
		userDao = DaoManager.createDao(ds, User.class);
		cityDao = DaoManager.createDao(ds, City.class);
		
		showUserCity();
		Thread.sleep(6 *1000);
		showUserCity();
		
	}
	
	public static void showUsers() throws SQLException {
//		User u = new User("Jack","1234");
//		userDao.create(u);
		System.out.println(userDao.queryForAll());
		ConnectionSource ds = userDao.getConnectionSource();
		ds.close();
	}
	
	public static void showUserCity() throws SQLException {
		System.out.println(userDao.queryForAll());
		ConnectionSource ds = userDao.getConnectionSource();
		ds.close();
		userDao.create(new User("Jack","1234"));
		System.out.println(ds.isOpen());
		System.out.println(cityDao.queryForAll());
		System.out.println(ds.isOpen());
		ds.close();
	}
}

