package com.xz.comfirm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestDate {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		String str="2015-12-06 18:00:00";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date date = sf.parse(str);
		System.out.println(date.toString());

	}

}
