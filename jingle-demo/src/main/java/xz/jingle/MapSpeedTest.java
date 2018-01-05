package xz.jingle;

import java.util.*;

/**
 * Created by Jinhua on 2016/10/28.
 */
public class MapSpeedTest {
	public static void main(String[] args) {
		Map<Integer,Integer> hashMap = new HashMap<>();
		Map<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
		
		long ts1 = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			hashMap.put(i,i);
		}
		
		long ts2 = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			linkedHashMap.put(i,i);
		}
		
		long ts3 = System.currentTimeMillis();
		int n = 0;
		for(int i=0;i<1000000;i++){
			n = hashMap.get(i);
		}
		long ts4 = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			n = linkedHashMap.get(i);
		}
		long ts5 = System.currentTimeMillis();
		
		System.out.println(ts2-ts1);
		System.out.println(ts3-ts2);
		System.out.println(ts4-ts3);
		System.out.println(ts5-ts4);
	}
}
