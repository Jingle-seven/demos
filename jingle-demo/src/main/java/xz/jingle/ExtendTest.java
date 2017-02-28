package xz.jingle;

/**
 * Created by Jinhua on 2016/12/2.
 */
//子类变量会将父类变量隐藏,但仍可以通过super访问
public class ExtendTest {
	public static void main(String[] args) {
		
		Animal an = new Dog();
		Dog dog = new Dog();
		
		System.out.println(an.name);
		System.out.println(dog.name);
		System.out.println(an.kind);
		
		an.name="Cat";
		System.out.println(an.name);
		dog.setName("");
		System.out.println(dog.toString());
		
		dog.show();
	}
	
}
class Animal{
	public String name = "animal";
	static String kind = "moveAble";
	public void run(){
		System.out.println("Animal running!!!!");
	}
	@Override
	public String toString() {
		
		return "Animal{" +
				"name='" + name + '\'' +
				'}';
	}
}
class Dog extends Animal{
	Dog(){}
	Dog(String name){
		this.name=name;
	}
	static String kind = "move faster";
	String name = "dog";
	private Integer age;
	public void show(){
		System.out.println(super.toString());
		System.out.println(this.toString());
	}
	public String setName(String name){
		String temp = super.name;
		super.name = "name changed to "+name;
		this.name = name;
		return temp;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return "Dog's name is "+ name;
	}
}