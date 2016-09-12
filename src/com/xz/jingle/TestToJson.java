package com.xz.jingle;

public class TestToJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str = "1233��С�ף��У��عأ��ع�".split("��");
		String str1 = "D_{'test':'123','age':17}";
		StringBuffer sb = new StringBuffer("[");
		System.out.println(sb.length());
//		sb.append("{\"sid\":\""+str[0]+"\",\"name\":\""+str[1]+"\",\"sex\":\""+str[2]+"\",\"photoPath\":\""+str[3]+"\",\"from\":\""+str[4]+"\"},");
//		sb.replace(sb.length()-1, sb.length(), "]");
		sb.append("{\"����\":\""+str[0]+"\",\"��ѧ\":\""+str[1]+"\",\"Ӣ��\":\""+str[2]+"\"}");
		System.out.println(sb.toString());

	}

}
