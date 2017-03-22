package xz.jingle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jinhua on 2017/3/22.
 */
public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add((int)(Math.random()*10));
		}
		System.out.println(list);
		List<Integer> subList = list.subList(0,5);
		subList.sort(null);
		System.out.println(list);
	}
}
