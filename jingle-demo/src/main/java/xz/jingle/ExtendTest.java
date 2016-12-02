package xz.jingle;

/**
 * Created by Jinhua on 2016/12/2.
 */
public class ExtendTest {
	public static void main(String[] args) {
		Dog an = new Dog();
		System.out.println(an.name);
	}
	static class Animal{
		static String kind = "moveAble";
		String name = "animal";
	}
	static class Dog extends Animal{
		static String kind = "move faster";
//		String name = "dog";
	}
}
