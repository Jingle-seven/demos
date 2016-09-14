package com.xz.jingle;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jinhua on 2016/7/25.
 */
public class Ymler {
	Map<String,Object> kv = new HashMap<>();
	File file;
	Ymler(String file){
		this.file = new File(file);
		init();
	}
	private void init(){
		System.out.println(file.getAbsolutePath());
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while((line = br.readLine())!=null){
				if(line.trim().equals(""))
					continue;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	private

	public static void main(String[] args) {
		Ymler y = new Ymler("foo.yml");
	}
}
