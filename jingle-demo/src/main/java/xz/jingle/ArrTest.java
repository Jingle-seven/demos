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
	public void main() {
		String[] ss = "123,,2".split(",");
		for(String s:ss){
			System.out.println(Long.parseLong(s));
		}
	}
	
	@Test
	public void testModifyInForEach(){
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
	public void testSubList(){
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
}
