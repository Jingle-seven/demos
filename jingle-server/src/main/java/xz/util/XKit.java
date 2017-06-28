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
import org.springframework.security.core.context.SecurityContextHolder;
import xz.controller.security.ButlerUserDetail;
import xz.model.BaseRecord;
import xz.model.TUser;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class XKit {
	private XKit(){}
	
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
	
	/** Parses a 1 to 16 character lower-hex string with no prefix int an unsigned long. */
	public static long hexToLong(String lowerHex) {
		char[] array = lowerHex.toCharArray();
		if (array.length < 1 || array.length > 32) {
			throw isntLowerHexLong(lowerHex);
		}
		long result = 0;
		for (char c : array) {
			result <<= 4;
			if (c >= '0' && c <= '9') {
				result |= c - '0';
			} else if (c >= 'a' && c <= 'f') {
				result |= c - 'a' + 10;
			} else {
				throw isntLowerHexLong(lowerHex);
			}
		}
		return result;
	}
	static NumberFormatException isntLowerHexLong(String lowerHex) {
		throw new NumberFormatException(
				lowerHex + " should be a 1 to 32 character lower-hex string with no prefix");
	}
	/** Inspired by {@code okio.Buffer.writeLong} */
	public static String toLowerHex(long v) {
		char[] data = new char[16];
		writeHexLong(data, 0, v);
		return new String(data);
	}
	
	/** Inspired by {@code okio.Buffer.writeLong} */
	public static void writeHexLong(char[] data, int pos, long v) {
		writeHexByte(data, pos + 0,  (byte) ((v >>> 56L) & 0xff));
		writeHexByte(data, pos + 2,  (byte) ((v >>> 48L) & 0xff));
		writeHexByte(data, pos + 4,  (byte) ((v >>> 40L) & 0xff));
		writeHexByte(data, pos + 6,  (byte) ((v >>> 32L) & 0xff));
		writeHexByte(data, pos + 8,  (byte) ((v >>> 24L) & 0xff));
		writeHexByte(data, pos + 10, (byte) ((v >>> 16L) & 0xff));
		writeHexByte(data, pos + 12, (byte) ((v >>> 8L) & 0xff));
		writeHexByte(data, pos + 14, (byte)  (v & 0xff));
	}
	static final char[] HEX_DIGITS =
			{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	static void writeHexByte(char[] data, int pos, byte b) {
		data[pos + 0] = HEX_DIGITS[(b >> 4) & 0xf];
		data[pos + 1] = HEX_DIGITS[b & 0xf];
	}
	
	public static TUser getLoggedOnUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		TUser user = null;
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
	public static long genUniqueId(){
		long ms = System.currentTimeMillis();
		int randNum = (int) (Math.random()*1000);
		return ms*1000+randNum;
	}
	public static long getTs(){
		return System.currentTimeMillis();
	}
	public static BaseRecord initRecord(BaseRecord rcd){
		rcd.setId(genUniqueId());
		rcd.setCreateTime(getTs());
		rcd.setUpdateTime(getTs());
		return rcd;
	}
	public static void setUpdateTs(BaseRecord old,BaseRecord newOne){
		newOne.setCreateTime(old.getCreateTime());
		newOne.setUpdateTime(getTs());
	}
	public static String killUnkindChar(String e) {return e.replace("\'","").replace("`","");}
	public static boolean isNotEmpty(String... strs){
		for (String s : strs) {
			if(s==null || s.isEmpty())
				return false;
		}
		return true;
	}
	public static String[] concat(String[] a, String[] b) {
		String[] c = new String[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}
	public static<T> void  intoInnerList(Map<String, List<T>> map, String key, T obj) {
		map.computeIfAbsent(key, e -> new ArrayList<>());
		map.computeIfPresent(key,(k,v)->{
			System.out.println(k);
			v.add(obj);
			return v;
		});
	}
	public static boolean containsStr(String numStr) {
		String regex="[a-zA-Z]+";
		Matcher m= Pattern.compile(regex).matcher(numStr);
		return m.find();
	}
}
