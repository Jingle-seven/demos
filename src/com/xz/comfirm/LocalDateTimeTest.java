package com.xz.comfirm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Jinhua on 2016/8/25.
 */
public class LocalDateTimeTest {
	public static void main(String[] args) throws ParseException {
		long current = System.currentTimeMillis();
		System.out.println(LocalDateTime.now());
		System.out.println(current);
		String str = "123456";
		System.out.println(str.substring(0,str.length()-1));
		
		LocalDate date = LocalDate.now();
//		date.atTime(0,0,0,0).getl;
		long todayZero=current/(1000*3600*24)*(1000*3600*24);//- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
		System.out.println(todayZero);
		System.out.println(todayZero-TimeZone.getDefault().getRawOffset());
		System.out.println(date.atTime(0,0,0,0));
		
		String str1="2015-12-06 18:00:00";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date date1 = sf.parse(str1);
		System.out.println(date.toString());
	}
}
