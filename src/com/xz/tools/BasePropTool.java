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
	
	/**
	 * @param path 使用class的getResourceAsStream,要加/
	 * @return	文件中以url开头的key对应的value
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<String> getPropsBy(String k) throws FileNotFoundException, IOException {
		List<String> props = new ArrayList<String>();
		
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
	 * 返回url开头的键值对
	 */
	public Map<String,String> getPropsMapsBy(String k) throws IOException{
		Map<String,String> props = new HashMap<String,String>();
		
		while (it.hasNext()) {
			String key = it.next();
			if(key.contains(k)){
				props.put(key,prop.getProperty(key));
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
