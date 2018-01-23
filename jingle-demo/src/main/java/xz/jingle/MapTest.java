package xz.jingle;

import org.junit.Test;

import java.util.*;

/**
 * Created by Jinhua on 2016/8/25.
 */
public class MapTest {
	static class XzInt{
		int value = 0;
		public XzInt(int value) {this.value = value;}

		@Override
		public int hashCode() {return 0;}

		@Override
		public boolean equals(Object obj) {return true;}

		@Override
		public String toString() {return "XzInt:" + value;}
	}
	@Test
	//如果元素equals和hashcode一样，放入hashmap会当做同一个东西
	public void testElementHash() {
		Map<XzInt,Integer> resMap = new HashMap<>();
		resMap.put(new XzInt(1),1);
		resMap.put(new XzInt(2),2);
		System.out.println(resMap);
	}
	@Test
	//如果元素要放入treeMap，要么元素类实现comparable接口，要么treeMap传入comparator参数，否则报错
	public void testTreeMap() {
		Map<XzInt,Integer> resMap = new TreeMap<>((o1, o2) -> o2.value-o1.value);
		resMap.put(new XzInt(1),1);
		resMap.put(new XzInt(2),2);
		System.out.println(resMap);
	}
	@Test
	//前两种方法删除会出现ConcurrentModificationException，要使用iterator
	public void testRemove() {
		Map<String,Integer> resMap = new HashMap<>();
		resMap.put("job_total_num",0);
		resMap.put("job_severe_num",0);
		for(Map.Entry<String,Integer> en: resMap.entrySet()){
			if("job_total_num".equals(en.getKey()))
				resMap.remove(en.getKey());
		}
		for(String k: resMap.keySet()){
			if("job_total_num".equals(k))
				resMap.remove(k);
		}
		Iterator<String> it = resMap.keySet().iterator();
		while(it.hasNext()){
			String k = it.next();
			if("job_total_num".equals(k))
				it.remove();
		}
		resMap.remove("hahaha");
		System.out.println(resMap);
	}
	
	@Test
	public void testComputeIfAbsent(){
		Map<String,Integer> map = new HashMap<>();
		map.put("0",0);
		//如果不存在,那么执行lambda,lambda唯一参数是map的key
		map.computeIfAbsent("1", (e)->{
			System.out.println(e);
			return 12;
		});
		//如果存在,那么执行lambda,lambda参数是key和value
		map.computeIfPresent("0", (k,v)-> {
			System.out.println(k+": "+v);
			return 100;
		});
		System.out.println(map);
	}
}
