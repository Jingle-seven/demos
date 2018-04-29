import org.junit.Test;
import xz.model.Dept;
import xz.model.User;
import xz.util.XKit;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class SimpleTest {
	@Test
	public void testReflect() throws IllegalAccessException {
		class TestField{
			int f1;
			long f2;
			short f3;
			byte f4;
			char f5;
			boolean f6;
			double f7;
			float f8;
			String f9;
			Integer f11;
			Long f22;
			Short f33;
			Byte f44;
			Character f55;
			Boolean f66;
			Double f77;
			Float f88;
			Object o;
			Map c1;
			List c2;
			Set c3;
		}
		TestField tf = new TestField();
		Field[] fields = tf.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		List<String> list = Arrays.asList(
				"int","long","short","byte","char","boolean","double","float",
				"class java.lang.String", "class java.lang.Character",
				"class java.lang.Integer", "class java.lang.Long", "class java.lang.Short", "class java.lang.Byte",
				"class java.lang.Boolean",
				"class java.lang.Double", "class java.lang.Float");
		for (Field fd : fields) {
			if(!list.contains(fd.getType().toString())){
				System.out.println(fd.getType()+": "+fd.getName());
			}
			sb.append("\"").append(fd.getType()).append("\",");
		}
		System.out.println(sb.toString());
		System.out.println(list);
	}
	@Test
	public void testCastToMap() {
		User user1 = new User("Tom","Tom@qq.com");
		User user2 = new User("Nancy","Nancy@qq.com");
		Dept d = new Dept("超级部");
		user1.setDept(d);
		d.addUser(user1).addUser(user2);
		System.out.println(XKit.castToMap(user1));
		System.out.println(XKit.castToMap(user1,true));
		System.out.println(XKit.castToMap(user2));
		System.out.println(XKit.castToMap(user2,true));
		System.out.println(XKit.castToMap(d));
		System.out.println(XKit.castToMap(d,true));
	}
	@Test
	public void testInstanceOf() {
		List cs = Arrays.asList(new HashMap(),new ArrayList(),new LinkedList<>(),new HashSet());
		for(Object c:cs){
			assertEquals(true,c instanceof Collection || c instanceof Map);
		}
	}
}