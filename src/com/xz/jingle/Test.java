package com.xz.jingle;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinhua on 2016/7/14.
 */
public class Test {
	public static void main(String a[]){
		Cat cat = new Cat();
		cat.miu();
	}
}


class Cat{
	String name = "变量初始化";
	{
//		name = "非静态代码块初始化";
		System.out.println("非静态代码块初始化");
	}
	Cat(){
//		name = "构造方法初始化";
		System.out.println("构造方法初始化");
	}
	public void miu(){
		System.out.println(": "+name);
	}
}
