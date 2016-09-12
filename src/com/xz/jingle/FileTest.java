package com.xz.jingle;

import java.io.File;

/**
 * Created by Jinhua on 2016/9/2.
 */
public class FileTest {
	public static void main(String[] args) {
		File file = new File("G:/temp//0");
		System.out.println(file.list());
	}
}
