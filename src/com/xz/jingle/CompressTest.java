package com.xz.jingle;

import java.io.*;
import java.util.zip.ZipOutputStream;

/**
 * Created by Jinhua on 2016/9/9.
 */
public class CompressTest {
	public static void main(String[] args) throws Exception {
		FileInputStream is = new FileInputStream(new File("G:\\temp\\trace_generator\\job2.jhist"));
		BufferedInputStream bis = new BufferedInputStream(is);
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File("G:\\temp\\trace_generator\\job2.zip")));
		byte[] buf = new byte[2048];
		int length;
		while ((length = bis.read(buf)) > 0) {
			zos.write(buf, 0, length);
		}
		System.out.println("compres end");
	}
}
