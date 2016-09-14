package com.xz.jingle;

public class TestClassInitOrder {

	public static void main(String[] args) {
		B b = new B(6);
	}
}
class A{
	static{
		System.out.println("A3 static");
	}
	{
		System.out.println("A3 block");
	}
	A(){
		System.out.println("A3 constructor");
	}
	A(int a){
		System.out.println("A3 constructor has paramter");
	}
}
class B extends A3 {
	static{
		System.out.println("B static");
	}
	{
		System.out.println("B block");
	}
	//invoke super class's none-param constructor
	B(){
		System.out.println("B constructor");
	}
	B(int a){
		System.out.println("B constructor has paramter");
	}
}