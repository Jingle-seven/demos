package xz.mybatislog.pojo;

/**
 * Created by Jinhua on 2016/9/18.
 */
public class User {
	String name;
	int age;
	String location;
	
	User(){}
	public User(String name, int age, String location) {
		this.name = name;
		this.age = age;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				", location='" + location + '\'' +
				'}';
	}
}
