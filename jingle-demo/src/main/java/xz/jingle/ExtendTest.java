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
		
		an.name="cat";
		System.out.println(an.name);
		dog.changeName();
		System.out.println(dog.toString());
		
		dog.show();
	}
	
}
class Animal{
	static String kind = "moveAble";
	String name = "animal";
}
class Dog extends Animal{
	Dog(){}
	Dog(String name){
		this.name=name;
	}
	static String kind = "move faster";
	String name = "dog";
	public void show(){
		System.out.println(super.toString());
		System.out.println(this.toString());
	}
	public void changeName(){
		super.name = "name changed";
	}
	public String toString(){
		System.out.println("super: "+super.name);
		return "Dog's name is "+ name;
	}
}