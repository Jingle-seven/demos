package com.xz.jingle;

import java.io.File;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by Jinhua on 2016/8/10.
 */
public class TimeTest {
	public static void main(String[] args) {
//		File f = new File("G:\\temp\\xjh.json");
//		f.mkdirs();
		LocalDateTime time = LocalDateTime.now();
		String timeStr = time.toString().replace(":","_").replace(".","").replace("T","_");
		System.out.println(timeStr);
		Clock clock = Clock.systemUTC();
		System.out.println(clock.millis());
		System.out.println(Instant.now());
	}
}
