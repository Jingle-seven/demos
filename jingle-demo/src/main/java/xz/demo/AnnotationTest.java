package xz.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Jinhua on 2017/5/8.
 */
public class AnnotationTest {
	@Name("Tom")
	String me;
	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
//		Method[] ms = AnnotationTest.class.getMethods(); 获得包括父类的方法, 但是只包括public方法
		Method[] ms = AnnotationTest.class.getDeclaredMethods();
		Name myName =  AnnotationTest.class.getDeclaredField("me").getAnnotation(Name.class);
		for( Method m:ms){
			Say say = m.getAnnotation(Say.class);
			if(say!=null)
				System.out.println(String.format("%s: %s %s.",myName.value(),say.value(),say.who()));
			if(m.getParameterTypes().length==0)
				m.invoke(null);
		}
	}
	
	@Say("fuck you!")
	static void foo() {System.out.println("foo");}
	@Say(value = "fuck you, too!!!",who = Say.People.NANCY)
	static void bar() {System.out.println("bar");}
	static void foobar() {System.out.println("foobar");}
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Say {
	//注解方法修饰符只能用默认或者public
	public String value() default "null";
	People who() default People.JIMMY;
	enum People{ TOM, NANCY, JIMMY}
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Name {
	public String value() default "no-one";
}