package xz.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Jinhua on 2017/5/8.
 */
public class SimpleAnno {
	@Name("Tom")
	String me = "Tommy";
	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
//		Method[] ms = AnnotationTest.class.getMethods(); 获得包括父类的方法, 但是只包括public方法
		Method[] ms = SimpleAnno.class.getDeclaredMethods();
		Name myName =  SimpleAnno.class.getDeclaredField("me").getAnnotation(Name.class);
		for( Method m:ms){
			Say say = m.getAnnotation(Say.class);
			if(say!=null)
				System.out.println(String.format("%s: %s %s.",myName.value(),say.value(),say.who()));
			if(m.getParameterTypes().length==0)
				m.invoke(null);//会导致使用了对象引用的方法出现空指针
		}
	}
	
	@Say("fuck you!")
	static void foo() {System.out.println("foo");}
	
	@Say(value = "fuck you, too!!!",who = Say.People.NANCY)
	static void bar() {System.out.println("bar");}
	
	void foobar() {System.out.println(me+" :foobar");}
	
}



@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Name {
	String value() default "no-one";
}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Say {
	//注解方法修饰符只能用默认或者public
	String value() default "null";
	People who() default People.JIMMY;
	enum People{TOM, NANCY, JIMMY}
}

