package com.xz.designPattern;

/**
 * Created by Jinhua on 2016/10/25.
 */
public class FactoryDemo {
	public static void main(String[] args) {
		Coffee coffee = CoffeeShop.getCoffee(CoffeeShop.LATTE);
		System.out.println(coffee.getName());
	}
}

abstract class Coffee {
	public String name = "Coffee";
	public String getName(){return name;}
}
class Latte extends Coffee {
	public String name = "latte";
	public String getName(){return name;}
}
class Mocha extends Coffee {
	public String name = "mocha";
	public String getName(){return name;}
}
class Cappuccino extends Coffee {
	public String name = "cappuccino";
	public String getName(){return name;}
}

class CoffeeShop{
	public static String LATTE = "l";
	public static String MOCHA = "m";
	public static String CAPPU = "c";
	public static Coffee getCoffee(String type){
		if (LATTE.endsWith(type)){
			return new Latte();
		}else if(MOCHA.endsWith(type)){
			return new Mocha();
		} else if(CAPPU.endsWith(type)){
			return new Cappuccino();
		}
		System.out.println("We don't sale this kind of coffee ! ");
		return null;
	}
}