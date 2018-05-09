package xz.jingle;

import org.junit.Test;

import java.text.ParseException;
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
	@Test
	public void testLocalDateTime() {
		long current = System.currentTimeMillis();
		System.out.println("当前时间戳 " + current);
		
        LocalDateTime dateTime = LocalDateTime.now();
        long todayZero=current/(1000*3600*24)*(1000*3600*24);
        System.out.println("暴力运算今日零时 " + todayZero);
        System.out.println("不知所谓 "+ (todayZero-TimeZone.getDefault().getRawOffset()));
		System.out.println("dateTime with 今日零时 " + dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0));
        System.out.println("dateTime.toLocalDate() " + dateTime.toLocalDate());
        System.out.println("dateTime.toLocalTime() " + dateTime.toLocalTime());

	}
    @Test
    public void testLocalDate() {
        LocalDate date = LocalDate.now();
        System.out.println("今日日期 " + date.toString());
        System.out.println("date.atTime  今日零时 " + date.atStartOfDay());
        System.out.println("date.atTime  今日零时 " + date.atTime(0,0,0,0));
        System.out.println("date.atTime  今日零时ts " + date.atTime(0,0,0,0).toInstant(ZoneOffset.UTC).toEpochMilli());

    }
	@Test
	public void TestFormatter() throws ParseException {
        String dateTimeStr="2015-12-06 18:00:00";
        String dateTimeStr2="2015-12-06T18:00:00";
        String dateStr="2015-12-06";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Date oldDate = sf.parse(dateTimeStr);
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeStr,df);
        System.out.println("SimpleDateFormat.parse(:String)  "+oldDate);
        System.out.println("LocalDateTime.parse(:String,:DateTimeFormatter)  "+parsedDateTime);
        System.out.println("dateTime.format(:DateTimeFormatter) "+parsedDateTime.format(df));
        System.out.println("符合格式可直接转不用Formatter"+LocalDateTime.parse(dateTimeStr2));
        System.out.println("符合格式可直接转不用Formatter"+LocalDate.parse(dateStr));
    }
}
