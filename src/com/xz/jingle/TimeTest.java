package com.xz.jingle;

import java.io.File;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

/**
 * Created by Jinhua on 2016/8/10.
 */
public class TimeTest {
	public static void main(String[] args) {
		testTimeMillis();
	}
	
	private static void testTimeMillis(){
		Long now = System.currentTimeMillis();
		System.out.println(new Date(1472658622000L));
		Long past = now - (1000 * 3600 * 24);
		System.out.println(new Date(1476634295867L));
	}
	
	private static void testTime() {
		LocalDateTime time = LocalDateTime.now();
		String timeStr = time.toString().replace(":","_").replace(".","").replace("T","_");
		System.out.println(timeStr);
		Clock clock = Clock.systemUTC();
		System.out.println(clock.millis());
		System.out.println(Instant.now());
	}
}
