package day_9_21;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao{
	
	public User findById(int id) {
		ResultSet rs =  baseQuery("select * from table1 where id = ?", id);
		User user;
		try {
			rs.next();
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		ResultSet rs =  baseQuery("select * from table1");

		try {
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insert(User u){
		baseUpdate("insert into table1 values(?,?,?)",u.getId(),u.getName(),u.getSex());
	}
	
	public void insertSome(List<User> list){
		for (int i = 0; i < list.size(); i++) {
			insert(list.get(i));
		}
	}
	
	public void update(User user) {
		String sql = "update table1 set name =? ,sex= ? where id =? ";
		baseUpdate(sql,user.getName(),user.getSex(),user.getId());
	}
	public void delete(int id){
		baseUpdate("delete from table1 where id = ?",id);
	}
}
