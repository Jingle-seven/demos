package com.xz.jingle;

/**
 * Created by Jinhua on 2016/8/15.
 */
public class AbstractClassTest {
	public static void main(String[] args) {
		Car car = new SmallCar();
		car.pr();
	}
}

class Car{
	public void p(){
		System.out.println("Car");
	}

	public void pr(){
		p();
	}
}

class SmallCar extends Car{
	public void p(){
		System.out.println("SmallCar");
	}
}