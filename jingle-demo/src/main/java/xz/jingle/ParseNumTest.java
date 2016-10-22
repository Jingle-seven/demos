package xz.jingle;

/**
 * Created by Jinhua on 2016/8/26.
 */
public class ParseNumTest {
	public static void main(String[] args) {
		String str = "123e";
		int i = Integer.parseInt(str);
		
		String str1 = "12";
		String str2 = "4";
		String str3 = String.valueOf(Integer.parseInt(str1)+Integer.parseInt(str2));
		System.out.println(str3);
	}
}
