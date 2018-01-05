package xz.demo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Jinhua on 2017/2/6.
 */
@DatabaseTable(tableName = "tuser")
class User{
	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField(columnName = "name")
	String name;
	@DatabaseField
	String password;
	
	public User(){}
	public User( String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
