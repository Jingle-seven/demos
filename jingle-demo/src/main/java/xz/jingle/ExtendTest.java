package xz.jingle;

/**
 * Created by Jinhua on 2016/12/2.
 */
public class ExtendTest {
	public static void main(String[] args) {
		
		Animal an = new Dog();
		Dog dog = new Dog();
		
		System.out.println(an.name);
		System.out.println(dog.name);
		System.out.println(an.kind);
		
		an.name="cat";
		System.out.println(an.name);
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
	public String toString(){
		return "Dog's name is "+ name;
	}
}