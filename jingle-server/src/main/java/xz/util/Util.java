/**
 * Copyright 2015-2016 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package xz.util;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Util {
	
	public static <T> ResponseEntity<T> cache(T value) {
		ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
		builder.cacheControl(CacheControl.maxAge(300, TimeUnit.SECONDS).mustRevalidate());
		return builder.body(value);
	}
	public static ResponseEntity<Map<String, Object>> cacheMsg(int size, String msg) {
		String[] meta = {"msg:" + msg, "size:" + size};
		Map<String, Object> resMap = makeResMap(null, meta);
		return Util.cache(resMap);
	}
	public static ResponseEntity<Map<String, Object>> cacheAffectedMsg(int column_affected, String action) {
		return cacheAffectedMsg(column_affected,action,new String[0]);
	}
	
	public static<T> ResponseEntity<Map<String, Object>> cacheAffectedMsg(int column_affected, String action, T returnData) {
		String[] meta = {"action:" + action, "column_affected:" + column_affected};
		Map<String, Object> resMap = makeResMap(returnData, meta);
		return Util.cache(resMap);
	}
	
	public static String intToIp(Integer ipInt) {
		if(ipInt==null)
			return "";
		return new StringBuilder().append(((ipInt >> 24) & 0xff)).append('.').append((ipInt >> 16) & 0xff).append('.')
				.append((ipInt >> 8) & 0xff).append('.').append((ipInt & 0xff)).toString();
	}
	public static long ipToInt(String ip) {
		try{
			String[] ipArray = ip.split("\\.");
			int sum = Integer.parseInt(ipArray[0]) << 8 << 8 << 8;
			sum += Long.parseLong(ipArray[1]) << 8 << 8;
			sum += Long.parseLong(ipArray[2]) << 8 ;
			sum += Long.parseLong(ipArray[3]);
			return sum;
		}catch (Exception e){
			return -1;
		}
	}
	public static Long getDayBegin() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	public static long tsToTimeNum(long ts){
		String time = new Date(ts).toInstant().toString();
		time = time.replaceAll("\\D","");
		return Long.parseLong(time);
	}
	public static<E>  Map<String,Object>  makeResMap(E data,String[] meta){
		Map<String,Object> resMap = new LinkedHashMap<>();
		Map<String, String> metaMap = strArrToMap(meta);
		resMap.put("meta",metaMap);
		resMap.put("data",data);
		return resMap;
	}
	public static Map<String,Object> castToMap(Object obj)  {
		Map<String,Object> map = new HashMap<>();
		if(obj==null)
			return map;
		
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			if(Modifier.isStatic(field.getModifiers())){
				continue;
			}
			field.setAccessible(true);
			try {
				map.put(field.getName(),field.get(obj));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	public static<E> List<Map<String,Object>> castToMap(Collection<E> collection) {
		List<Map<String,Object>> list = new ArrayList<>();
		collection.forEach(e -> list.add(castToMap(e)));
		return list;
	}
	private static Map<String, String> strArrToMap(String[] meta) {
		Map<String,String> metaMap = new HashMap<>();
		if(meta==null)
			return metaMap;
		for(String s: meta){
			if(s==null)
				continue;
			String[] kv = s.split(":");
			if(kv.length>1) {
				metaMap.put(kv[0], kv[1]);
			}else if(kv.length==1){
				metaMap.put(kv[0], "");
			}
		}
		return metaMap;
	}
	public static String checkNotNull(String str){
		return str==null? "" :str;
	}
}
