package com.xz.comfirm;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class TestIO {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String str = "��no��,memememememmeemmeememmememememememememememmememememememem\n";
		File file = new File("G:/J/StudentInfo.txt");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(str);
		}
		FileOutputStream fo = new FileOutputStream(file);
		
		Long before = System.currentTimeMillis();
		byte b[] = new byte[2048];
		b=sb.toString().getBytes();
		fo.write(b);
		fo.flush();
		fo.close();
		Long after = System.currentTimeMillis();
		System.out.println("����ʱ��:"+(after-before));
		
	}

}
