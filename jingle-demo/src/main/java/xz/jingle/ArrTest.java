package xz.jingle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jinhua on 2016/12/5.
 */
public class ArrTest {
	@Test
	public void split() {
		String[] ss = "123,,2".split(",");
		for(String s:ss){
			System.out.println(Long.parseLong(s));
		}
	}
	
	@Test
	public void modifyInForEach(){
		List list = new ArrayList(){{
			add(1);
			add(2);
			add(3);
		}};
		System.out.println(list);
//		list.forEach(e -> e = (int)e+1);
		for (Object o : list) {
			o = 0;
		}
//		for (int i = 0; i < list.size(); i++) {
//			list.set(i,(int)list.get(i)+1);
//		}
		System.out.println(list);
	}
	
	@Test
	public void subList(){
		List list = new ArrayList(){{
			add(0);
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}};
		System.out.println(list.subList(0,5));
	}
	
	@Test
	public void toArray(){
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		List<Integer> list3 = new ArrayList<>();
		list3.add(1);
		list3.add(2);
		
		//new出来的list不能强行转换为数组,会报错
//		Integer[] ints = (Integer[])list3.toArray();
		Integer[] ints = list3.toArray(new Integer[list3.size()]);
		//而asList的可以直接转换
		Integer[] ints2 = (Integer[]) list3.toArray();
		System.out.println(Arrays.toString(ints));
		
		for(Object obj: list3){
			System.out.println(obj.getClass());
		}
	}
}
