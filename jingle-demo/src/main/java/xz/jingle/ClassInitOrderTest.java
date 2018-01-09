package xz.jingle;

public class ClassInitOrderTest {

	public static void main(String[] args) {
		ClassB b2 = new ClassB();
		System.out.println();
		ClassB b1 = new ClassB(6);
	}
}
class ClassA{
	static{System.out.println("A static");}
	{System.out.println("A block");}
	ClassA(){System.out.println("A constructor");}
	ClassA(int a){System.out.println("A3 constructor has paramter");}
}
class ClassB extends ClassA {
	static{System.out.println("B static");}
	{System.out.println("B block");}
	//invoke super class's none-param constructor
	ClassB(){System.out.println("B constructor");}
	ClassB(int a){System.out.println("B constructor has paramter");}
}