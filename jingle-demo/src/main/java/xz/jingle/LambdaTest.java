package xz.jingle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

/**
 * Created by Jinhua on 2017/1/20.
 */
public class LambdaTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			list.add(i);
		
		list.stream()
				.filter(e-> e%2 ==0)
				.filter(e-> e%3 ==0)
				.forEach(System.out::println);
		list = list.stream()
				.filter(e-> e%2 ==0)
				.filter(e-> e%3 ==0)
				.collect(Collectors.toList());
		System.out.println(list);
		
		List<Integer> list2 = list.stream()
				.map(e->e*(e+1))
				.collect(Collectors.toList());
//				.collect(toCollection(ArrayList::new));
		list2.forEach(System.out::println);
		
		//如果不提供初始值0,返回的将会是optional
		int num = list.stream()
				.reduce(0,(res,e)-> res+(e*e));
		System.out.println(num);
		
		list2.add(-2);
		list2.stream()
				.sorted()
				.limit(5)//取前几个元素
				.skip(1)//抛弃前几个元素
				.forEach(System.out::println);
		
		//类似python的range()
		Stream.iterate(0,n->n+1).limit(10).forEach(System.out::println);
	}
}
