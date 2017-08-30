package xz.jingle;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Jinhua on 2017/8/30 15:03.
 */
public class ProxyTest {
    @Test
    public void test() {
        ComplexAnimal targetCat = new OrangeCat();
        ComplexAnimal targetDog = new YellowDog();
        ComplexAnimal proxyCat = (ComplexAnimal) new JdkAnimalProxy().create(targetCat);
        YellowDog proxyDog = (YellowDog) new CglibProxy().getProxy(targetDog.getClass());
        proxyDog.getAge();
        proxyCat.getAge();
    }
}
//JDK动态代理
class JdkAnimalProxy implements InvocationHandler {
    private Object target;
    public Object create(Object target){
        this.target = target;
        //创建代理对象proxy,获取target的接口并实现
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //invoke第一个参数不能是proxy,否则死循环,不知道为什么
        //设计缺陷还是故意为之,proxy这个参数意义何在?
        //所以必须要有一个类属性target,丑陋的写法
        Object result = method.invoke(target, args);
        System.out.println(method.getName() + " completed");
        return result;
    }
}
//cglib动态代理
class CglibProxy implements MethodInterceptor {
    //字节码增强方式创建子类
    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
            throws Throwable {
        System.out.println(obj.getClass()+" "+method.getName()+" start");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println(obj.getClass()+" "+method.getName()+" completed");
        return result;
    }
}
//被代理的接口
interface ComplexAnimal{
    int getAge();
    String getName();
}
//被代理的类们
class OrangeCat extends Animal implements ComplexAnimal{
    private int age = 1;
    public int getAge() {System.out.println(age);return age;}
    public OrangeCat setAge(int age) {this.age = age;return this;}
}
class YellowDog extends Animal implements ComplexAnimal{
    private int age = 4;
    public int getAge() {System.out.println(age);return age;}
    public YellowDog setAge(int age) {this.age = age;return this;}
}
