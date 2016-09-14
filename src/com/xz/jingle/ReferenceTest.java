package com.xz.jingle;

import java.lang.ref.SoftReference;

/**
 * Created by Jinhua on 2016/8/5.
 */
public class ReferenceTest {
	public static void main(String[] args) {
		SoftReference s = new SoftReference(new Object());
		Dog Jimmy = new Dog("Jimmy");
		DogHandle me = new DogHandle(Jimmy);
		me.walkTheDog();
	}
}

class DogHandle{
	Dog dog;
	public DogHandle(Dog dog) {
		this.dog = dog;
	}
	public void walkTheDog(){
		System.out.println(dog.name+" walking");
	}
}
