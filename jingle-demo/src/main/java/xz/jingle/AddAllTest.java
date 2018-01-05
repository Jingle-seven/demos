package xz.jingle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jinhua on 2016/7/29.
 */
public class AddAllTest {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		l1.add(""+1);
		l1.add(""+1);
		l1.add(""+1);
		List<String> l2 = new ArrayList<>();
		l2.add(""+2);
		l2.add(""+2);
		l2.add(""+2);
		List<String> l3 = new ArrayList<>();
		l3.add(""+3);
		l3.add(""+3);
		l3.add(""+3);

		l1.addAll(l2);
		l1.addAll(l3);
		l1.add(""+1);
		//以上证明addall相当好用
		System.out.println(l1);

		String[] a1 = new String[]{3.5+"",3.5+""};
		List<String> l4 = Arrays.asList(a1);
		l4.add(4+"");

		List<String> l5 = new ArrayList<>();
		 Collections.addAll(l5,a1);
		l5.add(4+"");
		System.out.println(l4);
		System.out.println(l5);
		//以上证明addall相当好用.asList不好用
	}
}
