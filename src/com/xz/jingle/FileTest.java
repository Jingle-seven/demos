package com.xz.jingle;

import java.io.File;
import java.io.IOException;

/**
 * Created by Jinhua on 2016/9/2.
 */
public class FileTest {
	public static void main(String[] args) throws IOException {
		String path = "G:/temp/0/4.txt";
		File dir = new File(path.substring(0,path.lastIndexOf("/")));
		File file = new File(path);
		dir.mkdirs();
		file.createNewFile();
	}
}
