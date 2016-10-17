package com.xz.jingle;

/**
 * Created by Jinhua on 2016/10/17.
 */
public class BlankTest {
	public static void main(String[] args) {
		String str = "1 2\r3";
		String str2 = str.replaceAll("\\s", "");
		System.out.println(System.getProperty("line.separator").equals("\r\n"));
		System.out.println(str);
		System.out.println(str2);
	}
}
