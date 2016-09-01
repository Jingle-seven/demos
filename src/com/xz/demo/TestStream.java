package com.xz.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinhua on 2016/8/22.
 */
public class TestStream {
	
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.stream().forEach(System.out::println);
	}
	
}
