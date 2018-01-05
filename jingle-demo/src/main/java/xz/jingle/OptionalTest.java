package xz.jingle;

import java.util.Optional;

/**
 * Created by Jinhua on 2017/1/19.
 */
public class OptionalTest {
	public static void main(String[] args) {
		Dog dog = new Dog("FuckTheSky");
		Optional<Dog> aDog = Optional.ofNullable(dog);
		System.out.println(aDog.orElse(new Dog("null")));
		
		//You can ignore {} when lambda expression contains only one line
		//It's same as ()->{ return new Dog(dog.toString())}
		System.out.println(aDog.orElseGet(()->new Dog(dog.toString())));
		
		//If not null,execute lambda expression
		aDog.ifPresent(e -> System.out.println(e.name+" barking"));
	}
}
