package xz.designPattern;

/**
 * Created by Jinhua on 2016/10/25.
 */
public class SingletonDemo {
	public static void main(String[] args) {
		
		Dog dog1 = Dog.getDog();
		Dog dog2 = Dog.getDog();
		System.out.println(String.format("dog1'name: %s,dog2'name: %s", dog1.name,dog2.name));
		
		dog1.name = "cat";
		System.out.println(String.format("after that,dog1'name: %s,dog2'name: %s", dog1.name,dog2.name));
		//dog1的名字改为cat后,dog2的名字也是cat,说明这两者是同一个dog
	}
}

class Dog{
	
	public String name;
	
	private static Dog dog = new Dog();
	
	private Dog(){this.name = "dog";}
	
	public static Dog getDog(){return dog;}
}