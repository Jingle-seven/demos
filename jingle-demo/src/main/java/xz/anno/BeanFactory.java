package xz.anno;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jinhua on 2017/9/7 16:23.
 */
public class BeanFactory {
    public  Map<Class<?>,?> beanCache = new HashMap<>();
    
    public void inject(){
    
    }
    
    public void scan(String pack){
    
    }
    
    public void start(){
        scan("xz.anno");
    }
}
