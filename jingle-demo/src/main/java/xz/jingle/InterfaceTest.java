package xz.jingle;


/**
 * Created by Jinhua on 2017/2/21.
 */
//父类方法与接口方法签名一样时,类的实例可通过接口方法调用父类方法,无需自己实现
public class InterfaceTest {
	public static void main(String[] args) {
		MyAnimal a = new MyDog();
		a.run();
	}
	interface MyAnimal{
		void run();
	}
	static class MyDog extends Animal implements MyAnimal{
		
	}
}
