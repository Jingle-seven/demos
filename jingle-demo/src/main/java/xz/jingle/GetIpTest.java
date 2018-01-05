package xz.jingle;


import org.junit.Test;

import java.net.*;
import java.util.Enumeration;

/**
 * Created by Jinhua on 2017/4/21.
 */
public class GetIpTest {

	public static void main(String[] args)  throws UnknownHostException {
		String addr = InetAddress.getLocalHost().getHostAddress();
		System.out.println(addr);
	}
	@Test
	public  void main() throws SocketException {
		Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
		while (netInterfaces.hasMoreElements()) {
			NetworkInterface netIf = netInterfaces.nextElement();
			System.out.println("\n"+netIf);
			Enumeration<InetAddress> iparray = netIf.getInetAddresses();
			while (iparray.hasMoreElements()) {
				InetAddress addr = iparray.nextElement();
//				System.out.println(addr);
//				System.out.println(addr.getHostName());
//				System.out.println(addr.getHostAddress());
				if ( addr instanceof Inet4Address) {
					System.out.println(addr.getCanonicalHostName() +": "+ addr.getHostAddress());
				}
			}
		}
	}
}
