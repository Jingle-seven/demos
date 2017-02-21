package xz.jingle;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import static java.awt.Color.blue;
import static java.awt.Color.cyan;


/**
 * Created by Jinhua on 2017/2/15.
 */
public class GsonTest {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.name = "kitty";
		cat.age = 3;
		cat.eyeColor = "blue";
		Gson gson = new Gson();
		System.out.println(gson.toJson(cat));
		
		//只转化本类属性不转化父类属性,如果json没有某个属性,赋初始值,json多余的属性不转换
		Cat cat2 = gson.fromJson("{eyeColor:blue,name:lanmao,sex:male}",Cat.class);
		System.out.println(cat2);
	}
}
class Cat extends Animal{
	
	public int age;
	public String eyeColor;
	
	
	public String toString() {
		return "Cat{" +
				"name=" + name +
				",age=" + age +
				", eyeColor='" + eyeColor + '\'' +
				'}';
	}
}