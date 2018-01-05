package xz.jingle;

import java.lang.ref.SoftReference;

/**
 * Created by Jinhua on 2016/8/5.
 */
public class ReferenceTest {
	public static void main(String[] args) {
		SoftReference sr = new SoftReference(new Object());
		Dog Jimmy = new Dog("Jimmy");
		Dog Tom = null;
		DogHandle me = new DogHandle(Jimmy);
		me.walkTheDog();
		System.out.println(Tom instanceof Dog);
		
	}
	static class DogHandle{
		Dog dog;
		DogHandle(Dog dog) {
			this.dog = dog;
		}
		void walkTheDog(){
			System.out.println(dog.name+" walking");
		}
	}
}


