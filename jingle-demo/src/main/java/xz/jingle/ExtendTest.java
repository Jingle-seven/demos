package xz.jingle;

/**
 * Created by Jinhua on 2016/12/2.
 *
 */
//子类变量会将父类变量隐藏,但仍可以通过super访问
public class ExtendTest {
	public static void main(String[] args) {
		
		Animal an = new Dog();
		Dog dog = new Dog();
		
		System.out.println(an.name);
		System.out.println(dog.name);
		
		//无论引用是什么,只要是子类对象,调用的方法都是子类方法
		an.setName("橘猫");
		dog.setName("拉布拉多");
		System.out.println("animal'info: "+an);
		System.out.println("dog's info: "+dog);
		
		//而静态属性和方法,似乎完全和继承无关
		System.out.println(Animal.getKind());
		System.out.println(Dog.getKind());
		
	}
	
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
	
	public Animal setName(String name) {
		this.name = name;
		return this;
	}
	
	public static String getKind() {
		return kind;
	}
	
	public static void setKind(String kind) {
		Animal.kind = kind;
	}
	
	@Override
	public String toString() {
		return "Animal{" +
				"name='" + name + '\'' +
				'}';
	}
}
class Dog extends Animal{
	public String nickName;
	static String kind = "move faster";
	String name = "dog";
	private Integer age;
	
	Dog(){}
	Dog(String name){
		this.name=name;
	}
	
	public Dog setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}
	
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Dog{");
		sb.append("nickName='").append(nickName).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", age=").append(age);
		sb.append('}');
		return sb.toString();
	}
}