package com.xz.comfirm;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * Created by Jinhua on 2016/8/25.
 */
public class LocalDateTimeTest {
	public static void main(String[] args) {
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
	}
}
