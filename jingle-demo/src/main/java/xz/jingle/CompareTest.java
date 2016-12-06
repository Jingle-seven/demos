package xz.jingle;

import java.util.Comparator;
import java.util.*;

/**
 * Created by Jinhua on 2016/12/5.
 */
public class CompareTest {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.sort(new AgeComparetor());
	}
	static class AgeComparetor implements Comparator<Map<String,Integer>>{
		
		public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
			int i1 = o1.get("age");
			int i2 = o2.get("age");
			if(i1>i2){
				return -1;
			}else {
				return 1;
			}
		}
	}
}
