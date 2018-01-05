package xz.tools;


import java.lang.reflect.Field;
import java.util.*;


/**
 * Created by Jinhua on 2016/11/1.
 */
public class ListTest {
	public static void main(String[] args) throws IllegalAccessException {
		Collection<String> l = new LinkedList<>();
		for(int i=0;i<74;i++){
			if(i>10)
				System.out.println(l);
			l.add(""+i);
		}
		Class<?> clz = l.getClass();
		Field[] fs =  clz.getDeclaredFields();
		for(Field field: fs){
			field.setAccessible(true);
			Object val = field.get(l);
			System.out.println(field.getName()+" :"+val);
		}
//		Object val = fs[4].get(l);
//		System.out.println(((Object[]) val).length);
	}
}
