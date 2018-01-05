package xz.jingle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Jinhua on 2016/8/4.
 */
public class MathTest {
	@Test
	public static void testInteger() {
		int c = 1470724335;
		long b = 1470724335313241345L;
		Integer in1 = 0;
		Integer in2 = 10010;
		Integer in3 = 10010;
		System.out.println(in1==0);
		System.out.println(in2==in3);
	}
	
	@Test
	public static void testParseNum() {
		String str = "";
		int i = Integer.parseInt(str);
		
		String str1 = "12";
		String str2 = "4";
		String str3 = String.valueOf(Integer.parseInt(str1)+Integer.parseInt(str2));
		System.out.println(str3);
		
		double d = 2.9;
		i = (int)d;
		System.out.println(i);
	}
	
	@Test
	public void testRate() {
		double moneyPerYear = 3660;
		double money = 0;
		double rate = 0.03;
		int year = 80 - 44;
		for (int i = 1; i <= year; i++) {
			money = money*(1+rate) + moneyPerYear;
		}
		System.out.println(money);// ~23W
	}
}
