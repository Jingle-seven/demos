package com.xz.comfirm;

/**
 * Created by Jinhua on 2016/8/26.
 */
public class StringToNumTest {
	public static void main(String[] args) {
		String str1 = "12";
		String str2 = "4";
		String str3 = String.valueOf(Integer.parseInt(str1)+Integer.parseInt(str2));
		System.out.println(str3);
	}
}
