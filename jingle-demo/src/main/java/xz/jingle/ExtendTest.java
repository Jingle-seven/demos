package xz.jingle;

/**
 * Created by Jinhua on 2016/12/2.
 *
 */
//子类变量会将父类变量隐藏,但仍可以通过super访问
public class ExtendTest {
	public static void main(String[] args) {

		Man man = new Man();
		Animal an = new Dog();
		Dog dog = new Dog();
		
		//方法重载，静态分派，根据声明类型决定调用方法。这里调用不同方法
		man.touch(an);
		man.touch(dog);
		man.touch(new Alive() {
			@Override
			public void move() {

			}
		});

		//方法覆盖（重写），动态分派，根据实际类型决定调用方法。这里调用的都是子类方法
		an.setName("汤姆");
		dog.setName("狗肉");
		System.out.println("animal'info: "+an);
		System.out.println("dog's info: "+dog);
		
		//而静态属性和方法也可以继承
		System.out.println(Animal.getKind());
		System.out.println(Dog.getKind());


	}
	
}
interface Moveable{void move();}
interface Alive extends Moveable{}//接口可以继承接口，不能实现接口
abstract class BigDog extends Dog implements Alive{}//抽象类可以继承实现类
class Man{
	void touch(Alive thing){System.out.println("A man is touching a alive thing");}
	void touch(Animal anamal){System.out.println("A man is touching a animal");}
	void touch(Dog dog){System.out.println("A man is touching a animal");}
}
class Animal{
	public String name = "animal";
	static String kind = "moveAble";

	public void run(){
		System.out.println("Animal running!!!!");
	}
	public String getName() {
		return name;
	}
	public Animal setName(String name) {this.name = name;;return this;}
	
	public static String getKind() {
		return kind;
	}

	@Override
	public String toString() {
		return "Animal{" + "name='" + name + '\'' + '}';
	}
}
class Dog extends Animal{
	public String nickName;
//	static String kind = "move faster";
//	String name = "dog";//变量同名导致父变量被隐藏，父方法setName针对的也非子类name

	public String getName() {
		return nickName;
	}
	public Animal setName(String name) {this.nickName = name;return this;}
	public Dog setNickName(String nickName) {this.nickName = nickName;return this;}
	public static String getKind() {return kind;}
	
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Dog{");
		sb.append("nickName='").append(nickName).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", superName='").append(super.name).append('\'');
		sb.append('}');
		return sb.toString();
	}
}