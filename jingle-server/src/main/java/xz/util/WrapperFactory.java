package xz.util;


import xz.model.abst.BaseRecord;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static xz.util.LogKit.butlerLogger;


/**
 * Created by Jinhua on 2017/7/3 11:38.
 */
public class WrapperFactory {
    public static<S,E extends S> E castToWrapper(S father,Class<E> childCls){
        if(father==null)
            return null;
        E newObj = null;
        try {
            newObj = childCls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            butlerLogger.severe(e.toString());
        }
        List<Field> fs = new ArrayList<>();
        Collections.addAll(fs,father.getClass().getDeclaredFields());
        Collections.addAll(fs,father.getClass().getSuperclass().getDeclaredFields());
        for (Field field : fs) {
            field.setAccessible(true);
            try {
                field.set(newObj,field.get(father));
            } catch (IllegalAccessException e) {
                butlerLogger.severe(e.toString());
            }
        }
        return newObj;
    }
    
    public static String toStr(BaseRecord obj) {
        List<Field> list = getFields(obj);
        final StringBuilder sb = new StringBuilder(obj.getClass().getSimpleName()+"{");
        for (Field f: list) {
            f.setAccessible(true);
            try {
                sb.append(f.getName()).append(":").append(f.get(obj)).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append('}');
        
        return sb.toString();
    }
    
    public static List<Field> getFields(BaseRecord wrapper) {
        return getFields(new ArrayList<>(),wrapper.getClass());
    }
    //不获取wrapper自己的属性
    public static List<Field> getSuperFields(BaseRecord wrapper) {
        return getFields(new ArrayList<>(),wrapper.getClass().getSuperclass());
    }
    
    private static List<Field> getFields(List<Field> fs,Class cls) {
        Collections.addAll(fs, cls.getDeclaredFields());
        Class superCls = cls.getSuperclass();
        if(superCls==null) {
            return fs;
        }else {
            return getFields(fs,superCls);
        }
    }
    
}
