package xz.util;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import xz.controller.security.ButlerUserDetail;
import xz.model.AssetUser;
import xz.model.abst.BaseRecord;
import xz.model.abst.EntityHist;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jinhua on 2017/8/25 17:07.
 */
public class ButlerKit {
    public static <E extends EntityHist> Map<String, List<EntityHist>> groupingSort(List<E> rawList) {
        Map<String,List<EntityHist>> idToHist = new HashMap<>();
        //按实体id分组
        rawList.forEach(e->{
            List<EntityHist> list = idToHist.computeIfAbsent(e.getEntityId(), k -> new ArrayList<>());
            list.add(e);
        });
        //按更新时间排序
        idToHist.values().forEach(e-> e.sort((o1, o2) ->
                o1.getUpdateTime()>=o2.getUpdateTime()?1:-1
        ));
        return idToHist;
    }
    
    public static <T> ResponseEntity<T> cache(T value) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        builder.cacheControl(CacheControl.maxAge(300, TimeUnit.SECONDS).mustRevalidate());
        return builder.body(value);
    }
    
    public static ResponseEntity<?> cacheColumnAffected(String resStatus) {
        return cacheColumnAffected(resStatus,null);
    }
    
    public static ResponseEntity<?> cacheColumnAffected(String resStatus, Object data) {
        return cache(makeResMap(data,"columns:"+resStatus));
    }
    
    public static<E> ResponseEntity<Map<String,Object>> cacheMap(E data, String... meta) {
        return cache(makeResMap(data,meta));
    }
    
    public static AssetUser getLoggedOnUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AssetUser user = null;
        if(principal instanceof ButlerUserDetail) {
            user = ((ButlerUserDetail) principal).castToUser();
        }
        return user;
    }
    
    public static<E> Map<String,Object> makeResMap(E data, String... meta){
        Map<String,Object> resMap = new LinkedHashMap<>();
        Map<String, String> metaMap = strArrToMap(meta);
        resMap.put("meta",metaMap);
        resMap.put("data",data);
        return resMap;
    }
    
    private static Map<String, String> strArrToMap(String[] meta) {
        Map<String,String> metaMap = new HashMap<>();
        if(meta==null)
            return metaMap;
        for(String s: meta){
            if(s==null)
                continue;
            String[] kv = s.replaceFirst(":","->>").split("->>");
            if(kv.length==2) {
                metaMap.put(kv[0], kv[1]);
            }else if(kv.length==1){
                metaMap.put(kv[0], "");
            }else{
                throw new RuntimeException("meta is illegal: " + s);
            }
        }
        return metaMap;
    }
    
    public static BaseRecord initRecord(BaseRecord rcd){
        rcd.setId(XKit.genUniqueId());
        rcd.setCreateTime(XKit.getTs());
        rcd.setUpdateTime(XKit.getTs());
        checkStatus(rcd);
        return rcd;
    }
    
    public static void setUpdateTs(BaseRecord old, BaseRecord newOne){
        if(old==null)
            throw new RuntimeException("id不存在");
        newOne.setCreateTime(old.getCreateTime());
        newOne.setUpdateTime(XKit.getTs());
        checkStatus(newOne);
    }
    
    public static<T> void  intoInnerList(Map<String, List<T>> map, String key, T obj) {
        map.computeIfAbsent(key, e -> new ArrayList<>());
        map.computeIfPresent(key,(k,v)->{
            v.add(obj);
            return v;
        });
    }
    
    public static void checkStatus(BaseRecord rcd){
        if(!XKit.isNotEmpty(rcd.getStatus()))
            rcd.setStatus("0");
    }
}
