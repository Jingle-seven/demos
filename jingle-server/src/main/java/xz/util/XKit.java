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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class XKit {
	private XKit(){}
	
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
	
	public static long genUniqueId(){
		long ms = System.currentTimeMillis();
		int randNum = (int) (Math.random()*1000);
		return ms*1000+randNum;
	}
	public static long getTs(){
		return System.currentTimeMillis();
	}
	public static long getRandInt(int min,int max){
		if(max==min) {
			return min;
		} else if(max<min){
			int temp = max;
			max = min;
			min = temp;
		}
		return new Random().nextInt(max-min) + min;
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
	
	public static boolean containsStr(String numStr) {
		String regex="[a-zA-Z]+";
		Matcher m= Pattern.compile(regex).matcher(numStr);
		return m.find();
	}
	
	public static String handleEx(Exception e) {
		Throwable throwable = getRootCase(e);
		String msg = throwable.toString();
		String regex1 = "Column '.+' cannot be null";
		String regex2="Duplicate entry '.+' ";
		Matcher m1 = Pattern.compile(regex1).matcher(msg);
		Matcher m2 = Pattern.compile(regex2).matcher(msg);
		if(m1.find()) {
			String info = m1.group();
			return "列不允许为空: " + info.substring(8,info.length()-16);
		}
		if(m2.find()) {
			String info = m2.group();
			return "已经存在的值不允许重复: " + info.substring(16,info.length());
		}
		return e.getMessage();
	}
	
	private static Throwable getRootCase(Throwable e) {
		Throwable theCase = e.getCause();
		if(theCase==null)
			return e;
		return getRootCase(theCase);
	}
	
	
	public static String longToIp(long ipInt) {
		return new StringBuilder().append(((ipInt >> 24) & 0xff)).append('.').append((ipInt >> 16) & 0xff).append('.')
				.append((ipInt >> 8) & 0xff).append('.').append((ipInt & 0xff)).toString();
	}
	public static long ipToLong(String ip) {
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

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(getRandInt(200,150));
		}
	}
}
