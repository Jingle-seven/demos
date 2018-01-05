package xz.jingle;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Jinhua on 2017/2/24.
 */
public class ReflectTest {
	@Test
	public void test() throws IllegalAccessException, InstantiationException, InvocationTargetException {
		Class<?> dogClazz = Dog.class;
		Dog dog = (Dog)dogClazz.newInstance();
		Class<?> dogClazz2 = dog.getClass();
		dog.setName("拉布拉多");
		Dog dog2 = (Dog)dogClazz.newInstance();
		Method[] methods = dogClazz.getDeclaredMethods();
		Field[] fields = dogClazz.getDeclaredFields();
		
		for (Method method : methods) {
			System.out.println("方法: "+method);
//			System.out.println(method.invoke(dog));
			System.out.println("方法返回值: "+method.getReturnType());
		}
		//类成员的一些属性
		for (Field field : fields) {
			System.out.println("=================="+field);
			field.setAccessible(true);
			System.out.println("修饰符: "+field.getModifiers());
			Modifier.isStatic(field.getModifiers());
			System.out.println("类型: "+field.getType());
			System.out.println("名字: "+field.getName());
			field.set(dog2,field.get(dog));
			System.out.println("设置后的值: "+dog2.getName());
			
		}
	}
	
	@Test//final变量修改成功?
	public void testModifyFinalField() throws NoSuchFieldException, IllegalAccessException {
		SwimmingDog dog = new SwimmingDog();
		Field ageField = dog.getClass().getDeclaredField("age");
		System.out.println("修饰符: "+ ageField.getModifiers());
		ageField.setAccessible(true);
		ageField.set(dog,1);
		System.out.println("age: "+dog.getAge());
	}
}
	

class SwimmingDog extends Dog{
	private final int age;
	SwimmingDog(){
		age = 0;
	}
	SwimmingDog(int age){
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}
