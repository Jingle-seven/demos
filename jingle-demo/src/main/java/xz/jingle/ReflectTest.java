package xz.jingle;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Jinhua on 2017/2/24.
 */
public class ReflectTest {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
		Class<?> dogClazz = Dog.class;
		Dog dog = (Dog)dogClazz.newInstance();
		Class<?> dogClazz2 = dog.getClass();
		dog.setName("拉布拉多");
		Dog dog2 = (Dog)dogClazz.newInstance();
		Method[] methods = dogClazz.getDeclaredMethods();
		Field[] fields = dogClazz.getDeclaredFields();
		
		for (Method method : methods) {
			System.out.println(method);
//			System.out.println(method.invoke(dog));
			System.out.println(method.getReturnType());
		}
		for (Field field : fields) {
			System.out.println("=================="+field);
			field.setAccessible(true);
			System.out.println(field.getModifiers());
			Modifier.isStatic(field.getModifiers());
			System.out.println(field.getType());
			System.out.println(field.getName());
			field.set(dog2,field.get(dog));
			System.out.println(dog2.getName());
			
		}
	}
}
