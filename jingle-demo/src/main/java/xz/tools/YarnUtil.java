package xz.tools;

import java.net.InetAddress;
import java.util.Calendar;


/**
 * Created by liuxf on 2016年7月20日
 * 域名/IP地址 与整形数互转类
 */
public class YarnUtil {


	public static byte[] ipToBytesByInet(String ipAddr) {
		try {
			return InetAddress.getByName(ipAddr).getAddress();
		} catch (Exception e) {
			throw new IllegalArgumentException(ipAddr + " is invalid IP");
		}
	}

	public static String intToIp(int ipInt) {
		return new StringBuilder().append(((ipInt >> 24) & 0xff)).append('.').append((ipInt >> 16) & 0xff).append('.')
				.append((ipInt >> 8) & 0xff).append('.').append((ipInt & 0xff)).toString();
	}
	public static Long getDayBegin() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTimeInMillis();
	}
}
