package xz.jingle;

import java.util.Optional;

/**
 * Created by Jinhua on 2017/1/19.
 */
public class OptionalTest {
	public static void main(String[] args) {
		Dog dog = null;
		Optional<Dog> aDog = Optional.ofNullable(dog);
		//如果aDog为空，给调用者一个新狗
		System.out.println(aDog.orElse(new Dog()));
		
		//You can ignore {} when lambda expression contains only one line
		//It's same as ()->{ return new Dog(dog.toString())}
		System.out.println(aDog.orElseGet(()->new Dog()));
		
		//如果aDog不为空，执行lambda表达式
		aDog.ifPresent(e -> System.out.println(e.name+" barking"));
	}
}
