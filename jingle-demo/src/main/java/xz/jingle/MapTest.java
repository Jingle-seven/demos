package xz.jingle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Jinhua on 2016/8/25.
 */
public class MapTest {
	public static void main(String[] args) {
		Map<String,Integer> resMap = new HashMap<>();
		resMap.put("job_total_num",0);
		resMap.put("job_critical_num",0);
		resMap.put("job_severe_num",0);
		resMap.put("job_moderate_num",0);
		resMap.put("job_normal_num",0);
		resMap.put("job_measure_num",0);
		resMap.put("user_num",0);
		
//		testPutAdd(resMap);
//		testRemove(resMap);
//		testGetAdd(resMap);
		
		testGetChange();
	}
	
	private static void testGetChange() {
		Map<String,XzInt> strToInt = new HashMap<>();
		strToInt.put("1",new XzInt());
		strToInt.get("1").value=10;
		System.out.println(strToInt);
		XzInt xint = strToInt.get("1");
		xint = new XzInt();
		System.out.println(strToInt);
	}
	
	static class XzInt{
		int value = 0;
		public String toString() {
			return "XzInt{" + "value=" + value + '}';
		}
	}
	private static void testRemove(Map<String, Integer> resMap) {
		//ConcurrentModificationException
		for(Map.Entry<String,Integer> en: resMap.entrySet()){
			if("job_total_num".equals(en.getKey()))
				resMap.remove(en.getKey());
		}
		for(String k: resMap.keySet()){
			if("job_total_num".equals(k));
				resMap.remove(k);
		}
		Iterator<String> it = resMap.keySet().iterator();
		while(it.hasNext()){
			String k = it.next();
			if("job_total_num".equals(k))
				it.remove();
		}
		resMap.remove("hahaha");
	}
	
	private static void testPutAdd(Map<String, Integer> resMap) {
		resMap.put("job_total_num",resMap.get("job_total_num")+10);
		resMap.put("job_total_num",resMap.get("job_total_num")+10);
		System.out.println(resMap.get("job_total_num"));
	}
	private static void testGetAdd(Map<String, Integer> resMap) {
		Integer value = resMap.get("job_total_num");
		value = value + 10;
		System.out.println(resMap);
	}
}
