package xz.jingle;

/**
 * Created by Jinhua on 2016/9/19.
 */
public class StartWithTimeTest {
	public static void main(String[] args) {
		String str1 = "123456";
		String str2 = "123";
		long stime = System.currentTimeMillis();
//		for(int i = 0;i<1000000;i++){
//			Boolean b = str1.startsWith(str2);
//			String s = ""+b.toString();
//		}
		for(int i = 0;i<1000000;i++){
			Boolean b = str1.equals(str2);
			String s = ""+b.toString();
		}
		long etime = System.currentTimeMillis();
		System.out.println(etime-stime);
		
	}
}
