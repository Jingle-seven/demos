package day_9_21;

import java.sql.*;
import java.util.*;

public class Test {
	UserDao d = new UserDao();
	
	
	public Vector query(String id){
		Vector v = new Vector() ;
		
		if(id.equals("")){
			List<User> list = d.findAll();
			for (int i = 0; i < list.size(); i++) {
				Vector fields = new Vector() ;
				fields.add(list.get(i).getId());
				fields.add(list.get(i).getName());
				fields.add(list.get(i).getSex());
				v.add(fields);
			}
		}else{
			Vector fields = new Vector() ;
			int userId = Integer.parseInt(id);
			User u = d.findById(userId);
			fields.add(u.getId());
			fields.add(u.getName());
			fields.add(u.getSex());
			v.add(fields);
		}
		return v;
	}
	
	public void insert(String id,String name,String sex){
		d.insert(new User(Integer.parseInt(id),name,sex));
	}
	public void update(String id,String name,String sex){
		d.update(new User(Integer.parseInt(id),name,sex));
	}
	public void delete(String id){
		d.delete(Integer.parseInt(id));
	}
	public static void main(String[] args) {
		
//		for (User user : list) {
//			System.out.println(user);
//		}
//		list.clear();
//		list.add(new User(5,"莉莉","女"));
//		list.add(new User(6,"爱丽丝","女"));
//		list.add(new User(7,"克劳尔","女"));
//		d.insertSome(list);

//		System.out.println("after");
//		list = d.findAll();
//		for (User user : list) {
//			System.out.println(user);
//		}
		
		
		
	}
}
