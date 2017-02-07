package xz.demo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Jinhua on 2017/2/6.
 */
@DatabaseTable(tableName = "tcity")
class City {
	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField(columnName = "name")
	String name;
	
	public City(){}
	public City(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "City{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
