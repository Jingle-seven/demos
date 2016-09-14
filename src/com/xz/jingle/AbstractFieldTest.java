package com.xz.jingle;

/**
 * Created by Jinhua on 2016/7/29.
 */
public class AbstractFieldTest {
	public static void main(String[] args) {
		new A1().p();
		new A2().p();
	}
}
abstract class A3 {
	int a = 0;
	void p(){
		System.out.println(a);
	}
}

class A1 extends A3 {
	int a = 1;
	void p(){
		System.out.println(a);
	}
}
class A2 extends A3 {
	int a = 2;
}