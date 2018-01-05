package xz.http;

import java.io.*;
import java.net.URI;
import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class MyLibHttpClient  implements Runnable{

	
	public static void main(String[] args) {
		new Thread(new MyLibHttpClient()).start();
	}

	public void run() {
		getPage("http://218.192.12.92/�ޱ���ҳ_files/�ޱ���ҳ.html",null);
		
	}
	private  boolean getPage(String targetUrl,List<Map<String,String>> paramsList){
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost();
		post.setURI(URI.create(targetUrl));
		
		List list = new ArrayList();
		list.add(new BasicNameValuePair("txtUsername_Lib","121542345"));
		list.add(new BasicNameValuePair("txtPas_Lib","123456"));
		
		try {
			post.setEntity(new UrlEncodedFormEntity(list, "gb2312"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		HttpResponse res;
		try{
			res = httpClient.execute(post);
		}catch (Exception e) {
			System.out.println("���ӳ�ʱ");
			return false;
		}
		
		if(res.getStatusLine().getStatusCode()==200){
			HttpEntity httpEntity = res.getEntity();
			String pageStr = null;
			try {
				pageStr = new String(EntityUtils.toString(httpEntity).getBytes("ISO_8859_1"),"gb2312");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			System.out.println(pageStr);
			String[] pageLines = pageStr.split("\n");
			
		}else{
			System.out.println("��ȡҳ�������");
			System.out.println(res.getStatusLine().getStatusCode());
		}
		return false;
	}
}
