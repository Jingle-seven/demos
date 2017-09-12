package xz.anno;

/**
 * Created by Jinhua on 2017/9/7 16:37.
 */
public class Starter {
    protected static void startFactory(){
        new BeanFactory().start();
    }
    //TODO 分析ClasspathPackageScanner扫描类的方法,以扫描注解
    public static void main(String[] args) {
        startFactory();
        System.out.println("程序启动");
    }
}
