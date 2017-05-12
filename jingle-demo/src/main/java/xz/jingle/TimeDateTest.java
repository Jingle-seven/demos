package xz.jingle;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Jinhua on 2016/8/10.
 */
public class TimeDateTest {
	public static void main(String[] args) {
		testLocalDateTime();
		testTask();
	}
	private static long tsToTimeNum(long ts){
		Date date = new Date(ts);
		String time = date.toInstant().toString();
		time = time.replaceAll("\\D","");
		return Long.parseLong(time);
	}
	
	private static void testTimeMillis(){
		Long now = System.currentTimeMillis();
		System.out.println(new Date(now));
		Long past = now - (1000 * 3600 * 24);
		System.out.println(new Date(past));
	}
	private static void testDayBegin() {
		Long  stampNow= System.currentTimeMillis();
		Long startTime  = stampNow/(1000*3600*24)*(1000*3600*24);
		System.out.println(stampNow-startTime);
	}
	private static void testLocalDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
//		LocalDateTime dateTime2 = LocalDateTime.parse("2011-11-23",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		System.out.println(dateTime2);
		String timeStr = dateTime.toString().replace(":","_").replace(".","").replace("T","_");
		System.out.println(dateTime);
		System.out.println(timeStr);
		System.out.println(dateTime.getMonth());
		System.out.println(dateTime.getMonthValue());
		System.out.println(dateTime.getDayOfWeek());
		System.out.println(dateTime.getHour());
		System.out.println(dateTime.getMinute());
		System.out.println(dateTime.getSecond());
		System.out.println(dateTime.getNano());
		System.out.println(dateTime.plusDays(-1).getDayOfWeek());
		System.out.println(dateTime.minusDays(-1).getDayOfWeek());
		System.out.println(dateTime.plusHours(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd")));
	}
	private static void testClock() {
		Clock clock = Clock.systemUTC();
		System.out.println(clock.millis());
		System.out.println(Instant.now());
	}
	private static void testTask(){
		int lastDownDay = 0;
		while (true){
			LocalDateTime now = LocalDateTime.now();
			int today = now.getDayOfMonth();
			if(now.getHour()==16 && lastDownDay!=today){
				String hdfsDir = String.format("/user/history/%s/%s/%s/",now.getYear(),now.getMonthValue(),today-1);
				String remoteDir = String.format("/home/yunjing/%s/%s/",now.getYear(),now.getMonthValue());
				System.out.println(String.format("hadoop dfs -get %s %s",hdfsDir,remoteDir));
				lastDownDay = today;
			}else {
				System.out.println("Is the same day,program waiting");
			}
			try {
				Thread.sleep(50 *1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
