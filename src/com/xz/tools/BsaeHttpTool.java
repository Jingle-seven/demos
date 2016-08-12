package com.xz.tools;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BsaeHttpTool {
	
	private Gson gson = new Gson();

	/**
	 * @param urlList 一组网络API的url
	 * @return Map<String,String> 一组[url-结果] 映射
	 */
	public Map<String, String> getResByUrl(List<String> urlList) {
		Map<String, String> resMap = new HashMap<String, String>();

		// 使用了future类用于解决请求超时阻塞的情况,超过十秒未返回的任务将抛出超时异常
		// try(a)和catch(x|y|z)写法是java7后才支持的特性,可以简化代码
		ExecutorService exec = Executors.newFixedThreadPool(1);
		for (String url : urlList) {
			String res = "";
			
			try (CloseableHttpClient client = HttpClients.createDefault()) {
				Future<String> future = exec.submit(new GetRes(client, url,null));
				res = future.get(10, TimeUnit.SECONDS);
			} catch (TimeoutException | InterruptedException | ExecutionException | IOException e) {
				System.err.println("请求超时");
				e.printStackTrace();
			}
			resMap.put(url, res);
		}
		return resMap;
	}

	/**
	 * 带参数的post请求
	 * @param url
	 * @param paraJson
	 */
	public String postWithParas(String url,String paraJson) {
		ExecutorService exec = Executors.newFixedThreadPool(1);
		String res = "null";
		
		//设置请求参数
		Map<String,String> parasMap = gson.fromJson(paraJson, new TypeToken<Map<String,String>>(){}.getType());
		List<NameValuePair> paras = new ArrayList<NameValuePair>();
		for (String k : parasMap.keySet()) {
			paras.add(new BasicNameValuePair(k,parasMap.get(k)));
		}
		
		//用future发送请求,若超时则抛出异常
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			Future<String> future = exec.submit(new GetRes(client, url,paras));
			res = future.get(10, TimeUnit.SECONDS);
			
		} catch (TimeoutException | InterruptedException | ExecutionException | IOException e) {
			System.err.println("请求超时");
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 带参数的get请求
	 */
	public String getWithParas(String url,String paraJson){
		String res = "";
		url = joinUrl(url, paraJson);
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			res = EntityUtils.toString(client.execute(new HttpGet(url)).getEntity());
		} catch (Exception e) {
			System.err.println("请求错误");
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 拼接url和参数形成get请求地址
	 * @param url
	 * @param paraJson
	 */
	private String joinUrl(String url,String paraJson){
		Map<String,String> parasMap = gson.fromJson(paraJson, new TypeToken<Map<String,String>>(){}.getType());
		if(parasMap.isEmpty())
			return url;
		StringBuilder resUrl = new StringBuilder(url+"?");
		for (String k : parasMap.keySet()) {
			if(resUrl.toString().endsWith("?")){
				resUrl.append(k+"="+parasMap.get(k));
			}else{
				resUrl.append("&"+k+"="+parasMap.get(k));
			}
		}
		System.out.println(resUrl.toString());
		return resUrl.toString();
	}

	/**
	 * @author Jinhua 传入httpclient,网络数据接口的url以及参数,获取String格式的结果
	 */
	class GetRes implements Callable<String> {

		CloseableHttpClient client;
		List<NameValuePair> paras;
		String url;

		public GetRes(CloseableHttpClient client, String url,List<NameValuePair> paras) {
			super();
			this.client = client;
			this.paras = paras;
			this.url = url;
		}

		public String call() throws Exception {
			HttpPost post = new HttpPost(url);
			if(paras!=null){
				post.setEntity(new UrlEncodedFormEntity(paras));
			}
			String res = EntityUtils.toString(client.execute(post).getEntity());
			return res;
		}
	}
}
