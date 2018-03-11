## Java用反射简单构建工厂，以及调用有参构造函数初始化实例  
这个程序分为完全不相关的两部分，只是因为都涉及反射才贪图方便写在一起测试。
第一部分：工厂类读取配置文件beanFactory.Properties信息，生成不同的实例返回到主方法。
第二部分：主方法调用有参数构造函初始化car实例。

下面是六个源文件。

配置文件beanFactory.Properties  
```
class1=beanFactory.Train
class2=beanFactory.Car
```
接口moveabel  
```
public interface Moveable {
	void run();
}
```
实体类car  
```
public class Car implements Moveable {
	String name = "车";

	public Car() {}
	public Car(String name) {
		super();
		this.name = name;
	}

	public void run() {
		System.out.println(name + "奔跑中");
	}
}
```
实体类train  
```
public class Train implements Moveable {
	String name = "火车";

	public void run() {
		System.out.println(name + "一路脱轨中");
	}
}
```
工厂类  
```
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Factory {
	
	Map<String,Object> map = new HashMap();
	
	public Factory(String fileName) throws Exception {
		
		Properties prop = new Properties();
		prop.load(Test.class.getClassLoader().getResourceAsStream(fileName));
		
		//遍历配置文件所有键值，生成键-实例对放入map容器
		Iterator it = prop.entrySet().iterator();
		while(it.hasNext()){
			Entry en = (Entry) it.next();
			System.out.println(en.getValue());
			map.put((String) en.getKey(), 
					Class.forName((String) en.getValue()).newInstance());
		}
	}
	
	//从容器中取出key对应的实例
	public Object getBean(String key){
		return map.get(key);
	}
}
```
主方法  
```
import java.lang.reflect.Constructor;
public class Test {
	public static void main(String[] args) {

		try {
			// 创建工厂生成一个交通工具（Car或者Train，可根据配置文件更改）
			Factory f = new Factory("beanFactory.Properties");
			Moveable m = (Moveable) f.getBean("class2");
			m.run();

			// 以下是调用有参数构造函数生成Car实例
			Moveable m1;
			Class c = Class.forName("Car");

			// 知道构造函数参数情况下，方法一
			m1 = (Moveable) c.getConstructor(String.class).newInstance("F4");

			// 不知道构造函数参数情况下，方法二
			Constructor[] con = c.getDeclaredConstructors();
			for (Constructor cons : con) {
				Class[] cls = cons.getParameterTypes();
				if (cls.length != 0) {
					// m1 = (Moveable) c.getConstructor(cls).newInstance("F1");
					m1.run();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```
