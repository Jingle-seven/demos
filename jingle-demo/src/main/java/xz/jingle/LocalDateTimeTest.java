package xz.jingle;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Jinhua on 2016/8/25.
 */
public class LocalDateTimeTest {
	public static void main(String[] args) throws Exception {
		long current = System.currentTimeMillis();
		System.out.println("当前时间戳 " + current);
		
		LocalDate date = LocalDate.now();
		LocalDateTime dateTime = LocalDateTime.now();
		long todayZero=current/(1000*3600*24)*(1000*3600*24);
		System.out.println("暴力运算今日零时 " + todayZero);
		System.out.println("不知所谓 "+ (todayZero-TimeZone.getDefault().getRawOffset()));
		System.out.println("今日日期 " + date.toString());
		System.out.println("date.atTime  今日零时 " + date.atTime(0,0,0,0));
		System.out.println("date.atTime  今日零时ts " + date.atTime(0,0,0,0).toInstant(ZoneOffset.UTC).toEpochMilli());
		System.out.println("dateTime with 今日零时 " + dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0));
		
		String str="2015-12-06 18:00:00";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
		Date date1 = sf.parse(str);
		System.out.println("从字符格式化而来的时间  "+date1);
		System.out.println("格式化的dateTime字符串 "+dateTime.format(df));
	}
}
