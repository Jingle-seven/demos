package com.xz.tools;

import java.io.*;
import java.util.*;

/**
 * @author Jinhua
 *	读取配置文件的工具类
 */
public class BasePropTool {

	Properties prop = new Properties();
	Iterator<String> it = null;
	
	public BasePropTool(String path){
		InputStream is = this.getClass().getResourceAsStream(path);
		try {
			Reader rd  = new InputStreamReader(is, "utf-8");
			prop.load(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		it = prop.stringPropertyNames().iterator();
		
	}
	
	public List<String> getPropsBy(String k) {
		List<String> props = new ArrayList<>();
		
		while (it.hasNext()) {
			String key = it.next();
			if(key.contains(k)){
				props.add(prop.getProperty(key));
				System.out.println("Get "+key + ": " + prop.getProperty(key));
			}
		}
		return props;
	}
	
	
	/**
	 * 根据key获取对应值
	 * @param key
	 * @return
	 */
	public String get(String key){
		return prop.getProperty(key, "key unavailable");
	}
}
