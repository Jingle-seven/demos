package com.xz.jingle;

import java.io.File;
import java.io.IOException;

/**
 * Created by Jinhua on 2016/9/2.
 */
public class FileTest {
	public static void main(String[] args) throws IOException {
//		String path = "G:/temp/0/4.txt";
//		File dir = new File(path.substring(0,path.lastIndexOf("/")));
//		File file = new File(path);
//		dir.mkdirs();
//		file.createNewFile();
		System.out.println("123456".substring(3));
		System.out.print(System.getProperty("file.encoding"));
		String str = new File("conf/config.prop").getAbsolutePath();
//		new File("conf/config.prop").mkdirs();
		System.out.println(str);
	}
}
