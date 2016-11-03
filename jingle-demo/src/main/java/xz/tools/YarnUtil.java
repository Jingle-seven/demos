package xz.tools;

import java.net.InetAddress;
import java.util.*;


/**
 * Created by liuxf on 2016年7月20日
 * 域名/IP地址 与整形数互转类
 */
public class YarnUtil {
	public static void main(String[] args) {
		String ip = "192.168.0.3";
		int intIp = ipToInt(ip);
		String ip2 = intToIp(intIp);
		System.out.println(intIp);
		System.out.println(ip2);
		Properties pro = System.getProperties();
		Map<String,String> map = System.getenv();
		
		String traceId = Util.toLowerHex(1477381964571791686L);
		System.out.println(traceId);
	}

	public static byte[] ipToBytes(String ipAddr) {
		try {
			return InetAddress.getByName(ipAddr).getAddress();
		} catch (Exception e) {
			throw new IllegalArgumentException(ipAddr + " is invalid IP");
		}
	}

	public static String intToIp(int ipInt) {
		return new StringBuilder()
				.append(((ipInt >> 24) & 0xff)).append('.')
				.append((ipInt >> 16) & 0xff).append('.')
				.append((ipInt >> 8) & 0xff).append('.')
				.append((ipInt & 0xff)).toString();
	}
	public static int bytesToInt(byte[] bytes) {
		int intIp = bytes[3] & 0xFF;
		intIp |= ((bytes[2] << 8) & 0xFF00);
		intIp |= ((bytes[1] << 16) & 0xFF0000);
		intIp |= ((bytes[0] << 24) & 0xFF000000);
		return intIp;
	}
	public static int ipToInt(String ip){
		return bytesToInt(ipToBytes(ip));
	}
	public static Long getDayBegin() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTimeInMillis();
	}
	static long jingleGetDayBegin() {
		long dayBegin = YarnUtil.getDayBegin();
		long now = System.currentTimeMillis();
		long rest = now % (1000 * 3600* 24);
		long myDayBegin = now - rest - (8 * 3600 * 1000);//time zone is east 8
		System.out.println("myDaybegin: "+myDayBegin);
		System.out.println("daybegin: "+dayBegin);
		return myDayBegin;
	}
}
